# Seat Reservation Gradle

Eclipse2020，Intellij IDEAで動作確認済

コンパイル時（恐らく）ネットワーク環境が必要

JavaFXはJDK1.8にバンドルされているものが使われます（Corretto1．8で動作確認済）

ライブラリについて
junit,testfxはプロジェクト実行時にGradleによりネットワーク上から読み込まれる

jfoenix,ojdbcはsrc/main/resources/lib

(jfoenixは多分dependenciesの1行目の通りネットワーク上からも読まれている）


