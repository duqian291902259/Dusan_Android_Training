---
title: webrtc入门之客户端连麦demo-apprtc
date: 2018-01-30 11:55:00
tags:
  - webrtc
  - 连麦
  - p2p
categories: 音视频
---
webrtc很强大，一起学习吧。webrtc编译起来比较痛苦，源码和工具链下载下来十几G，源码samples里面提供了androidapp项目，只有源码，没有jar包和so库，所以我编译好webrtc，提取出所需的jar包和so文件，并把里面androidapp弄成android studio项目，可以正常编译运行。这个demo实现webrtc连麦，点对点视频通信，对webrtc初学者还是挺有帮助的。<!-- more -->

以下是关于这个demo的详细信息，英文不是装逼，因为这个源码我分享在了github上面。
WebRTC Demos:[webrtc-android-demo-apprtc](https://github.com/duqian291902259/webrtc-android-demo-apprtc)


This demo is based on WebRTC.
WebRTC is a free, open project.The source code of this demo is based on official samples(src/samples/androidapp). I have compiled webrtc source to get required .so and .jar files, so you can just build it by android studio.
![webrtc-android-demo-as-project.png](http://upload-images.jianshu.io/upload_images/2001922-8ea966a296ef66a7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### How to build and run?
Please clone this project,build it with android stuido,install the target apk files to your devices

###  How to start
1，go to website : [https://appr.tc/](https://appr.tc/).input your room id(any number).
![appr.tc-webrtc-server.png](http://upload-images.jianshu.io/upload_images/2001922-f464498ba6143195.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2，open the apprtc app,input the same room id.

![AppRTC-android-demo-p2p.png](http://upload-images.jianshu.io/upload_images/2001922-b73b87fe19f2b2ee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3，Experience p2p connectivity with webrtc.

![AppRTC-connectivity.png](http://upload-images.jianshu.io/upload_images/2001922-3d0a0249b5849528.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### Future 
Maybe I will share more articles about webrtc in the future.

### Thanks to WebRTC team！
Dusan's E-mail: duqian2010@gmail.com

WebRTC Demos:[webrtc-android-demo-apprtc](https://github.com/duqian291902259/webrtc-android-demo-apprtc)


如果对webrtc编译感兴趣，以下是我在linux ubuntu 14.04上编译webrtc所用的命令，希望对你有帮助。

### Development
if you try to compile src of webrtc,you'll depressed 
at its large size,the total checkout size will be about 16 GB. and more than 30G after compiled.
for more details about getting source code: [https://webrtc.org/native-code/android/](https://webrtc.org/native-code/android/)

if you have installed all required softwares in linux.
let's excute cmds like this:

``` java
#!/bin/bash
#duqian2010@gmail.com

export PATH=$PATH:~/webrtc/depot_tools

cd ~/webrtc/android/

fetch --nohooks webrtc_android
gclient sync
gclient runhooks

ls
cd src

git new-branch webrtc_compile
git checkout webrtc_compile

echo "--------------compile config：android，arm-----------------"

gn gen out/arm --args='target_os="android" target_cpu="arm"'

echo "-----------------start compiling webrtc---------------------"

ninja -C out/arm

echo "-----------------compile webrtc done---------------------"

#ninja -C out/arm AppRTCMobile
#build/android/gradle/generate_gradle.py --output-directory $PWD/out/arm --target "//webrtc/examples:AppRTCMobile" --use-gradle-process-resources --split-projects --canary

echo "start copying jar files"
mkdir ../libs/armeabi-v7a/

cp out/arm/lib.java/sdk/android/libjingle_peerconnection_java.jar ../libs/libjingle_peerconnection_java.jar 
cp out/arm/lib.java/rtc_base/base_java.jar ../libs/base_java.jar 
cp out/arm/gen/modules/audio_device/audio_device_java__compile_java.javac.jar ../libs/audio_device_java__compile_java.javac.jar
cp out/arm/lib.java/examples/androidapp/third_party/autobanh/autobanh.jar ../libs/autobanh.jar

echo "start copying so files"

cp out/arm/libjingle_peerconnection_so.so ../libs/armeabi-v7a/libjingle_peerconnection_so.so

echo "task has finished"
exit 0

# scp /Users/duqian/Downloads/webrtc_arm.sh nonolive@192.168.0.18:/home/nonolive/webrtc/android/
```

谢，喜欢就分享吧。


----------

杜乾，Dusan，duqian2010@gmail.com,QQ：291902259

微信公众号：OpenDeveloper

分享不仅限于Android，Web 开发，做开放的开发者。

Blog：[http://blog.csdn.net/dzsw0117](http://blog.csdn.net/dzsw0117)

Github:[duqian291902259](https://github.com/duqian291902259)
