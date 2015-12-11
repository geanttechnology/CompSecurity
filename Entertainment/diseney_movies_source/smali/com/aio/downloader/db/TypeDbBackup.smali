.class public Lcom/aio/downloader/db/TypeDbBackup;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "TypeDbBackup.java"


# static fields
.field public static final APP_NAME:Ljava/lang/String; = "app_name"

.field private static final DATABASE_APK:Ljava/lang/String; = "create table backup(package_name VARCHAR(255) PRIMARY KEY, typ VARCHAR(20),version VARCHAR(255),size VARCHAR(255),img VARCHAR(255),app_name VARCHAR(255))"

.field public static final IMG:Ljava/lang/String; = "img"

.field public static final PACKAGE_NAME:Ljava/lang/String; = "package_name"

.field public static final SIZE:Ljava/lang/String; = "size"

.field public static final TABLE_BUCKUP:Ljava/lang/String; = "backup"

.field public static final TYPE:Ljava/lang/String; = "typ"

.field public static final VERSION:Ljava/lang/String; = "version"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    const-string v0, "backup"

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 30
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 35
    const-string v0, "create table backup(package_name VARCHAR(255) PRIMARY KEY, typ VARCHAR(20),version VARCHAR(255),size VARCHAR(255),img VARCHAR(255),app_name VARCHAR(255))"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 43
    return-void
.end method
