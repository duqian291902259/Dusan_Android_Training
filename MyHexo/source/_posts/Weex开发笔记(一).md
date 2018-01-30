---
title: Weex开发笔记(一)
date: 2016-06-28 08:20:00
tags:
  - Weex
  - android
categories: Weex
---
关于weex的环境安装，前面已经介绍了，并且顺利运行android版官方demo，亮点十足，继续关注。本文介绍weex for ios的相关内容，以及遇到的坑，weex入门还是挺简单的，不过目前的bug不少，还需要跟进学习。
weex仓库：[https://github.com/alibaba/weex](https://github.com/alibaba/weex)。
本文主要介绍IOS版的使用，关于android 环境搭建，看：[Weex开源测试之环境搭建，weex未来展望](http://blog.csdn.net/dzsw0117/article/details/51702319)。
<!-- more -->
![这里写图片描述](http://img.blog.csdn.net/20160628090120400)
### 一，运行IOS playground
阿里巴巴官方说明：
> Prerequisites
Install Node.js 4.0+
Under project root
npm install, install project
./start
Install iOS Environment
Install CocoaPods
Run playground
cd ios/playground
pod install
Open WeexDemo.xcworkspace in Xcode
Click  (Run button) or use default hot key cmd + r in xcode
If you want to run demo on your device. In DemoDefine.h(you can search this file by Xcode default hot key cmd+space+o), modify CURRENT_IP to your local IP

但是按照这个步骤来，编译报错。可能是路径不对，总是报各种路径找不到的错误。然后我就这样改：
将weex项目中ios目录下的sdk放入playground根目录，然后Podfile改为如下：
```
source 'https://github.com/CocoaPods/Specs.git'
target 'WeexDemo' do
    platform :ios, '7.0' 
    pod 'SDWebImage', '3.7.5'
    pod 'SocketRocket', '0.4.2'
    pod 'ATSDK-Weex', '0.0.1'
    pod 'WeexSDK', :path=>'./sdk/'   
end
```
点开WeexDemo.xcworkspace，编译的时候又提示缺少两张图片，我加了同名的png图片，然后可以顺利编译通过。
![看看多好看，还带了性能，调试工具](http://img.blog.csdn.net/20160628085922259)
UI不错噢。使用起来各种流畅哇。

### 二，各种命令行操作，shell脚本

weex根目录下面有个打包的脚本文件：package.json，终端使用者和开发者，可以通过命令行使用脚本。
for end-user
#### 1,清理examples/build and test/build 文件夹 *.js ：
`npm run clean`

#### 2,创建.we file文件
```
//run npm run create -- -h for help
npm run create -- [name] -o [directory]
```
#### 3,编译.we文件为js
transform *.we in examples and test folders 
```
npm run transform
```
#### 4,运行npm run clean && npm run transform 
```
npm run dev
```
#### 5,开启服务：run a file server at 12580 port 
这个方便在PC浏览器里面打开页面看效果。也可以自定义端口。
```
 npm run serve
```
#### 6,监测.we文件改动，自动更新
run a watcher for *.we changed ，一旦文件变动，就回自动渲染。
```
 npm run watch
```
For SDK Developer
#### 1,we文件渲染转换 js-framework and h5-render 
```
npm run build
```
#### 2,使用 js-framework and h5-render 运行test目录
```
npm run ci
```
#### 3,拷贝编译后的js文件到playgroud工程
（assets文件夹，方便调用）
```
npm run copy
```
### 三，weex相关技巧
weex项目根目录下面的index.html，在pc浏览器渲染不出来。也改成weed-loader-demo的渲染方式就可以。
```
<!-- jsframework -->
<script src="./src/js-framework/dist/index.js"></script>
<!-- h5render 
<script src="./src/h5-render/dist/index.js"></script>  此处注释掉，改为下面的代码，然后 npm run serve,就可以pc浏览器访问samples里面的页面了。-->
 <script src="./node_modules/weex-html5/dist/weex.js"></script>
```
浏览器访问的页面地址：**http://192.168.100.47:12580/index.html?page=./examples/build/index.js**，192.168.100.47替换成自己本机ip即可。weex for h5如图：
![weex for h5](http://img.blog.csdn.net/20160628113736216)
### 四，可安装淘宝的NPM镜像
如果安装node，weex工具包使用npm比较慢的话。可以用淘宝的镜像。这是一个完整 npmjs.org 镜像，你可以用此代替官方版本，同步频率目前为 10分钟 一次以保证尽量与官方服务同步。
当前 registry.npm.taobao.org 是从 r.cnpmjs.org 进行全量同步的.
当前 npm.taobao.org 运行版本是: cnpmjs.org@
本系统运行在 Node.js@ 上.
开源镜像: http://npm.taobao.org/mirrors
Node.js 镜像: http://npm.taobao.org/mirrors/node
alinode 镜像: http://npm.taobao.org/mirrors/alinode
phantomjs 镜像: http://npm.taobao.org/mirrors/phantomjs
ChromeDriver 镜像: http://npm.taobao.org/mirrors/chromedriver
OperaDriver 镜像: http://npm.taobao.org/mirrors/operadriver
Selenium 镜像: http://npm.taobao.org/mirrors/selenium
Node.js 文档镜像: http://npm.taobao.org/mirrors/node/latest/docs/api/index.html
NPM 镜像: https://npm.taobao.org/mirrors/npm/
electron 镜像: https://npm.taobao.org/mirrors/electron/
node-inspector 镜像: https://npm.taobao.org/mirrors/node-inspector/

install e.g 举例参考：
```
cd /Users/duqian/AndroidStudioProjects/Weex/weex-loader-demo 
npm install -g cnpm --registry=https://registry.npm.taobao.org
cnpm init -y
cnpm install --save-dev webpack weex-loader
cnpm install --save-dev weex-scripter@^0.1.4 weex-styler@^0.0.17 weex-templater@^0.2.1
cnpm install --save-dev webpack weex-loader
cnpm install --save-dev serve weex-html5
```
### 五，weex demo
weex-loader-demo，weex团队大神阿里－鬼道录制了视频，这个demo简单，拿来学习还是可以的，自行github。可以了解一些安装，打包的过程，以及weex如何加载第三方库，比如弹toast。
[weex-loader-demo视频](http://vodcdn.video.taobao.com/player/ugc/tb_ugc_bytes_core_player_loader.swf?version=1.0.20160613&vid=40370446&uid=1696871850&p=1&t=1&rid=&random=6666)
另外，还有weexOne，百度大神dodola两天写出来的作品，主要是TabBar和网络请求操作，亲测，有bug，不是很完善。
后期我也写一个weex demo，顺便参加workshop大赛。

### come on ，developer，Learn/write once，run everywhere!
```
Android开发，Dusan_杜乾：291902259，公众号：OpenDeveloper
```