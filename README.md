Todoリスト
===
> ToDoリストやToDoを作成、管理、検索できるウェブサイトです。ユーザ登録、ログイン、ログアウト機能も実装しています。

* [概要](#概要)
* [使用した技術要素](#使用した技術要素)
  * [言語：](#言語)
  * [フレームワーク:](#フレームワーク)
  * [データベース](#データベース)
  * [モジュール管理ツール](#モジュール管理ツール)
  * [IDE](#ide)
* [全体の設計・構成](#全体の設計構成)
  * [機能](#機能)
  * [データベースの設計](#データベースの設計)
  * [ルータ設計](#ルータ設計)
  * [API提供](#api提供)
    * [GET Request](#get-request)
    * [POST Request](#post-request)
  * [フロントエンドの各ファイル説明](#フロントエンドの各ファイル説明)
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
###フロントエンド
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
        |-- server                 　　　//サーバーを設定するディレクトリ
        |   |-- api.js                  //apiを管理するファイル
        |   |-- db.js　　　　　　　　　　  //データベースを設定するファイル
        |   |-- index.js                //サーバーの起動を設定するファイル
        |   |-- node_modules
        |   |-- package.json
        |   |-- package-lock.json
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
### 機能
* `ToDoリスト`一覧表示、新しい`ToDoリスト`を作成する

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/createTodolist.gif)

* `ToDo`一覧表示、新しい`ToDo`を作成して、`完了/未完了`の状態を変更する

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/createTodo.gif)

* 登録された`ToDo`や`ToDoリスト`について検索する

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/search.gif)

* **[独自]** ユーザ新規登録

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/Register.gif)

* **[独自]** ユーザログインして、自分に属する`ToDoリスト`や`ToDo`を作成する（状態変更、検索もできる）

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/Login.gif)

* **[独自]** ユーザログアウト、`public`状態を戻る

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/Logout.gif)

* **[独自]** `ToDo`や`ToDoリスト`を削除する

![image](https://github.com/Alienaaa/Todo-list/blob/master/ReadMe_img/deleteTodo%26Todolist.gif)


### API提供
#### GET Request
* `/api/getallTodolist` 該当ユーザのすべてのリストを取得する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | ユーザ名 | user   | String |
   * 出力
     * `response.data`: 作成日が新しい順にを表示する`ToDoリスト`の配列

* `/api/getallTodoitem` 該当ユーザが選定されたToDoリストのすべてのToDoを取得する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id   | ObjectId |
      | ユーザ名 | user   | String |
   * 出力
     * `response.data[0]`: 作成日が新しい順にを表示する`ToDo`の配列

* `/api/searchTodolist` 該当ユーザのkeywordを含まれているToDoリストを取得する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | キーワード | keyword   | String |
      | ユーザ名 | user   | String |
   * 出力
     * `response.data`: 作成日が新しい順にを表示する keywordを含まれている`ToDoリスト`の配列

* `/api/searchTodoitem` 該当ユーザのkeywordを含まれているToDoを取得する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | キーワード | keyword   | String |
      | ユーザ名 | user   | String |
   * 出力
     * `response.data`: 作成日が新しい順にを表示する keywordを含まれている`ToDo`の配列

* `/api/login` ユーザ認証は成功するかどうかを確認する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | ユーザ名 | name   | String |
      | パスワード | pass   | String |
   * 出力
     *  |        | status  | msg  | data
        |:---------:|:-----------:|:--------:|:--------:|
        | 認証成功の場合 | 1000   | ユーザ認証成功です。|ユーザデータ |
        | ユーザ名は登録されてない場合 | 1002   |ユーザ登録されてません。| null |
        | パスワードは誤りがある場合 | 1001   |パスワードの入力に誤りがあります。| null |<br>

#### POST Request
* `/api/createTodolist` 該当ユーザの新しいToDoリストを作成する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id         | ObjectId |
      | ToDoリスト名 | title        | String   |
      | ToDoリスト作成日| listCreateData | Date   |
      | ユーザ名       | user   | String     |　
      | ToDoを格納する配列 | TodoItem | ToDoを格納する配列  |
* `/api/createTodoitem` 該当ユーザが選定したToDoリストで、新しいToDoを作成する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id         | ObjectId |
      | ToDoリスト名    | title        | String   |
      | ToDo名     | TodoTitle | String     |
      | 期限       | TodoDDL   | Date     |
      | ToDo作成日 | TodoCreateData | Date  |
      | 完了/未完了 | isDone | Boolean  |
* `/api/deleteTodolist` 該当ユーザが選定したToDoリストを削除する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id         | ObjectId |
      | ユーザ名       | user   | String     |

* `/api/deleteTodoitem` 該当ユーザが選定したToDoリストのToDoを削除する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id         | ObjectId |
      | ユーザ名       | user   | String     |
      | ToDo名     | TodoTitle | String     |
* `/api/changeIsdone` 該当ユーザが選定したToDoリストのToDoの`完了/未完了`変更する
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | TodoリストID | _id         | ObjectId |
      | ユーザ名       | user   | String     |
      | ToDo名     | TodoTitle | String     |
      | 完了/未完了 | isDone | Boolean  |
* `/api/logup` 新規ユーザ登録
  * 入力
    * | 内容       | フィールド名  | データ型  |
      |:---------:|:-----------:|:--------:|
      | ユーザ名 | name   | String |
      | パスワード | pass   | String |
  * 出力
    * |        | status  | msg  | data
      |:---------:|:-----------:|:--------:|:--------:|
      | 登録成功の場合 | 1000   | ユーザログアップ成功です。|被ったユーザデータ |
      | ユーザ名は既存ユーザに被った場合 | 1001   |このユーザ名はすでに登録されました。| ユーザデータ |


## 開発環境のセットアップ手順

[こちら](https://nodejs.org/ja/)にNode.jsをインストールする

``` bash
# リポジトリをローカルへクローンする
git clone https://github.com/Alienaaa/Todo-list.git

cd Todo-list

# 必要なパッケージをインストールする
npm install

# サーバーを起動する(localhost:3000)
cd server
node index.js

# クライアントサードを起動
cd ..
npm run dev

# localhost:8080をオーブンする
```
## 今まで出来てないところ
* リスト名/ToDo名を編集する機能を実装
* Inputとボタンの様式適応性調整
* 締め切り前日の提示機能を作る
## 動作確認URL
>Supported by [Heroku](https://www.heroku.com/)<br>
https://todolist-alien.herokuapp.com/

`IE 11` `Firefox 66.0.3` `Microsoft Edge` `Chrome  73.0.3683.103` `Safari  9.0.2` 動作チェック済み
