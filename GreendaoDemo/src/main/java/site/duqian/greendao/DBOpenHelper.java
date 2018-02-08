package site.duqian.greendao;

import android.content.Context;
import android.util.Log;


import org.greenrobot.greendao.database.Database;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class DBOpenHelper extends DaoMaster.OpenHelper {

    private static final TreeMap<Integer, Upgrade> ALL_UPGRADES = new TreeMap<>();
    private static final String TAG = DBOpenHelper.class.getSimpleName();

    static {
        ALL_UPGRADES.put(1, new UpgradeV1());
    }

    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        //super.onCreate(db);
        executeUpgrades(db, ALL_UPGRADES.keySet());
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);
        Log.d(TAG,"Upgrade from" + oldVersion + "to" + newVersion);
        if (newVersion > oldVersion) {
            SortedMap<Integer, Upgrade> subMap = ALL_UPGRADES.subMap(oldVersion, false, newVersion, true);
            if (subMap != null && subMap.size() > 0) {
                executeUpgrades(db, subMap.keySet());
            }
        }
    }

    private void executeUpgrades(Database db, Set<Integer> keySet) {
        if (keySet != null && keySet.size() > 0) {
            for (final Integer version : keySet) {
                ALL_UPGRADES.get(version).onUpgrade(db);
            }
        }
    }

    private interface Upgrade {
        void onUpgrade(Database db);
    }

    private static class UpgradeV1 implements Upgrade {
        @Override
        public void onUpgrade(Database db) {
            NoteDao.createTable(db, false);
            MusicDao.createTable(db, false);
        }
    }

}
