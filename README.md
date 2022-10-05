# 書籍管理システム

## 使用技術
- Kotlin
- Spring Boot
- MyBatis（ORM）
- MySQL
- Redis
- Docker

## アーキテクチャ
[オニオンアーキテクチャ](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)をベースとした設計とする

### 階層の説明

| 階層                  | 概要                                  |
|---------------------|-------------------------------------|
| User Interface      | Presentation層とも呼ばれる。UIに直結する処理の実装を担う |
| Infrastructure      | I/Oに関する技術スタック（DB等）に関する実装を担う         |
| Application Service | 各機能の仕様に応じた処理（ユースケース）を担う             |
| Domain Service      | ドメインに関するビジネスロジックの実装を担う              |
| Domain Model        | ドメインに関する状態と振る舞いの実装を担う               |
| Tests               | テストコードの実装を担う                        |

### 階層とパッケージ

| 階層                  | パッケージ                           |
|---------------------|---------------------------------|
| Presentation(UI)    | com.book.manager.presentation   |
| Infrastructure      | com.book.manager.infrastructure |
| Application Service | com.book.manager.application    |
| Domain      | com.book.manager.domain         |

### フロントエンドのリポジトリ

https://github.com/Tomoya185-miyawaki/book-manager-front