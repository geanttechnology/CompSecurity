.class public Lcom/aio/downloader/db/TypeDb;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "TypeDb.java"


# static fields
.field public static final CREATE_TIME:Ljava/lang/String; = "create_time"

.field private static final DATABASE_APK:Ljava/lang/String; = "create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),serial INT(10),create_time INT(10))"

.field public static final ICON:Ljava/lang/String; = "icon"

.field public static final PATH:Ljava/lang/String; = "path"

.field public static final SERIAL:Ljava/lang/String; = "serial"

.field public static final SIZE:Ljava/lang/String; = "size"

.field public static final TABLE_NAME:Ljava/lang/String; = "file_list"

.field public static final TITLE:Ljava/lang/String; = "title"

.field public static final TYPE:Ljava/lang/String; = "typ"

.field public static final _ID:Ljava/lang/String; = "id"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    const-string v0, "file_list"

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 37
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 42
    const-string v0, "create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),serial INT(10),create_time INT(10))"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 43
    const-string v0, "qwa"

    const-string v1, "dbdbdb"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 51
    return-void
.end method
