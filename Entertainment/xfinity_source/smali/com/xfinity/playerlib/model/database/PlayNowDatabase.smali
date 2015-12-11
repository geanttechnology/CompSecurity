.class public Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "PlayNowDatabase.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    const-string v0, "playNowDB"

    const/4 v1, 0x0

    const/4 v2, 0x4

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 14
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 18
    invoke-static {p1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 19
    invoke-static {p1}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 20
    invoke-static {p1}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 21
    return-void
.end method

.method public onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "database"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 32
    invoke-super {p0, p1}, Landroid/database/sqlite/SQLiteOpenHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 33
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 35
    const-string v0, "PRAGMA foreign_keys=ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 37
    :cond_0
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "database"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 25
    invoke-static {p1, p2, p3}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 26
    invoke-static {p1, p2, p3}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 27
    invoke-static {p1, p2, p3}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 28
    return-void
.end method
