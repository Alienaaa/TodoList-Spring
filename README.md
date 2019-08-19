Todoリスト
===
> ToDoを作成、管理、検索できるウェブサイトです。

* [概要](#概要)
* [使用した技術要素](#使用した技術要素)
  * [言語：](#言語)
  * [フレームワーク:](#フレームワーク)
  * [データベース](#データベース)
  * [モジュール管理ツール](#モジュール管理ツール)
  * [IDE](#ide)
* [全体の設計・構成](#全体の設計構成)
  * [フロントエンド](#フロントエンド)
  * [サーバサイド](#サーバサイド)
  * [機能](#機能)
  
* [開発環境のセットアップ手順](#開発環境のセットアップ手順)
* [今まで出来てないところ](#今まで出来てないところ)
* [動作確認URL](#動作確認url)


## 概要
* **ソフト名**：ToDoリスト Simplified Version
* **バージョン**：ver.β
* **製作者**：朱　文佳 (Alien)

## 使用した技術要素
### 言語：
* フロントエンド
  * `HTML`,`CSS`,`JavaScript`
* サーバサイド
  * `Java`

### フレームワーク:
* フロントエンド
  * `Vue.js`
    * dependencies<br>
        ```
        "axios": "^0.18.0",　　　　　　// HTTP通信フレームワーク
        "element-ui": "^2.7.0",       // UI フレームワーク
        "lodash": "^4.17.11",         // 便利な関数をまとめて提供しているフレームワーク
        "moment": "^2.24.0",          //日付処理フレームワーク
        "node-sass": "^4.11.0",
        "sass": "^1.17.3",
        "sass-loader": "^7.1.0",
        "scss": "^0.2.4",
        "vue": "^2.5.2",
        "vue-router": "^3.0.1",　　　 //公式ルータフレームワーク
        ```
* サーバサイド
  * `Spring boot`
    * dependencies<br>
        ```
        dependencies {
          implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
          implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
          implementation 'org.springframework.boot:spring-boot-starter-web'
          developmentOnly 'org.springframework.boot:spring-boot-devtools'
          runtimeOnly 'mysql:mysql-connector-java'
          testImplementation 'org.springframework.boot:spring-boot-starter-test'
         }
        ```
### データベース
`MySQL`<br>
https://w2.cleardb.net/

### モジュール管理ツール
`npm`

### IDE
`VS code`
`IntelliJ IDEA`

## 全体の設計・構成
### フロントエンド

        |-- build                       // ビルドに関するディレクトリ
        |   |-- build.js
        |   |-- check-version.js
        |   |-- dev-client.js
        |   |-- dev-server.js
        |   |-- utils.js
        |   |-- webpack.base.conf.js
        |   |-- webpack.dev.conf.js
        |   |-- webpack.prod.conf.js
        |-- config                      // 開発環境に関するディレクトリ
        |   |-- dev.env.js
        |   |-- index.js                // ここではProxyTableを設定
        |   |-- prod.env.js
        |-- dist                        // ビルドしたときに生成先
        |   |-- static                  // 静的なソースを管理するディレクトリ
        |   |-- index.html              // エントリーポイント
        |-- node_modules
        |-- src                         // フロントエンドのコードを管理するディレクトリ
        |   |-- assets                  // ソースを管理するディレクトリ
        |   |-- components              // componentを管理するディレクトリ
        |   |-- router                  // routerを管理するディレクトリ
        |   |-- pages                   // pagesを管理するディレクトリ
        |   |-- App.vue                 // Vue.jsのエントリーポイント
        |   |-- main.js                 // JavaScriptのエントリーポイント
        |-- .babelrc
        |-- .editorconfig
        |-- .eslintignore               // ESLintチェックしたくないもの設定
        |-- .eslistrc.js                // ESLint設定ファイル
        |-- index.html                  // プロジェクトのエントリーポイント
        |-- package.json

### サーバサイド 
        
        |-- gradle                      // gradle
        |   |-- wrapper 
        |-- src                      
        |   |-- main
        |   |   |-- java
        |   |   |   |--com
        |   |   |      |-- alien
        |   |   |          |-- TodoList
        |   |   |              |-- TodoListApplication.java   // main function
        |   |   |              |-- config
        |   |   |              |-- controller   //Interface
        |   |   |              |-- pojo         //TodoItem Class
        |   |   |              |-- repository
        |   |   |-- resources
        |   |   |-- |--application.properties
        |   |   |-- |--static           //静的なソースを管理するディレクトリ（フロントエンド）
        |   |   |-- |--templates
        |   |-- test                
        |-- build.gradle                        
        |-- gradlew
        |-- gradle.bat
        |-- settings.gradle
      

### 機能
* `ToDo`一覧表示、新しい`ToDo`を作成する

![image](https://github.com/Alienaaa/TodoList-Spring/blob/master/Demo_img/addnewtodo.gif)

* `完了/未完了`の状態を変更する

![image](https://github.com/Alienaaa/TodoList-Spring/blob/master/Demo_img/changebutton.gif)

* `ToDo`を更新する

![image](https://github.com/Alienaaa/TodoList-Spring/blob/master/Demo_img/edittodo.gif)

* `ToDo`について検索する

![image](https://github.com/Alienaaa/TodoList-Spring/blob/master/Demo_img/searchfortodo.gif)



## 開発環境のセットアップ手順

``` bash
# リポジトリをローカルへクローンする
git https://github.com/Alienaaa/TodoList-Spring.git

cd TodoList-Spring

#run
# サーバーを起動する(localhost:9000)

# localhost:9000/index.html をオーブンする
```
> フロントエンド Dev は　[こちら](https://github.com/Alienaaa/TodoList-vue)　に参照してお願いします。

## 今まで出来てないところ
* Template Engine を利用する（インターン開始まで作り直す予定）
* Spring bootで日本語や中国語が文字化け問題（いつくの提案を試したが、なんだか解決出来なかった。今は試行錯誤中。）
* 検索ページの並び順
## 動作確認URL
>Supported by [Heroku](https://www.heroku.com/)<br>
https://todolist-spring.herokuapp.com/index.html

`IE 11` `Firefox 66.0.3` `Microsoft Edge` `Chrome  73.0.3683.103` `Safari  9.0.2` 動作チェック済み
