.class public Lcom/xfinity/playerlib/model/database/FavoriteDAO;
.super Ljava/lang/Object;
.source "FavoriteDAO.java"


# instance fields
.field private db:Landroid/database/sqlite/SQLiteDatabase;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 1
    .param p1, "dbHelper"    # Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    .line 49
    iput-object p2, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 50
    return-void
.end method

.method public static onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 53
    const-string v0, "create table favorite (_id integer primary key autoincrement, merlin_id integer, namespace text, title text, user_name text, is_adult integer,created integer)"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 54
    return-void
.end method

.method public static onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "oldVersion"    # I
    .param p2, "newVersion"    # I

    .prologue
    .line 57
    return-void
.end method


# virtual methods
.method public addFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)J
    .locals 6
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 60
    if-nez p1, :cond_0

    .line 61
    const-wide/16 v2, -0x1

    .line 78
    :goto_0
    return-wide v2

    .line 64
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    .line 65
    .local v1, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 67
    .local v0, "cvs":Landroid/content/ContentValues;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-gtz v2, :cond_2

    .line 68
    :cond_1
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Illegal merlinId"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 71
    :cond_2
    const-string v2, "merlin_id"

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 72
    const-string v2, "namespace"

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    const-string v2, "title"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const-string v3, "user_name"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const-string v3, "is_adult"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->isAdultContent()Z

    move-result v2

    if-eqz v2, :cond_3

    const/4 v2, 0x1

    :goto_1
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 76
    const-string v2, "created"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 78
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "favorite"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    goto :goto_0

    .line 75
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public deleteFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z
    .locals 12
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 120
    if-nez p1, :cond_0

    .line 129
    :goto_0
    return v4

    .line 124
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    .line 125
    .local v0, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "favorite"

    const-string v7, "user_name=? and namespace=? and merlin_id=?"

    const/4 v2, 0x3

    new-array v8, v2, [Ljava/lang/String;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 127
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v8, v4

    .line 128
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->name()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v8, v3

    const/4 v2, 0x2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v2

    .line 125
    invoke-virtual {v5, v6, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 129
    .local v1, "rows":I
    if-lez v1, :cond_1

    move v2, v3

    :goto_1
    move v4, v2

    goto :goto_0

    :cond_1
    move v2, v4

    goto :goto_1
.end method

.method public getAllFavorite()Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/VideoFavorite;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 84
    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 85
    const-string v4, "select * from favorite where user_name=? order by _id desc"

    .line 89
    .local v4, "query":Ljava/lang/String;
    :goto_0
    iget-object v8, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    new-array v9, v6, [Ljava/lang/String;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v9, v7

    invoke-virtual {v8, v4, v9}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 90
    .local v0, "c":Landroid/database/Cursor;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 91
    .local v2, "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/VideoFavorite;>;"
    :goto_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 92
    new-instance v3, Lcom/xfinity/playerlib/model/MerlinId;

    const-string v5, "namespace"

    .line 93
    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v5

    const-string v8, "merlin_id"

    .line 94
    invoke-interface {v0, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 93
    invoke-interface {v0, v8}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-direct {v3, v5, v8}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    .line 95
    .local v3, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    const-string v5, "title"

    .line 96
    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    const-string v5, "is_adult"

    .line 97
    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    if-lez v5, :cond_1

    move v5, v6

    :goto_2
    new-instance v9, Ljava/util/Date;

    const-string v10, "created"

    .line 98
    invoke-interface {v0, v10}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    invoke-interface {v0, v10}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    invoke-direct {v9, v10, v11}, Ljava/util/Date;-><init>(J)V

    invoke-direct {v1, v3, v8, v5, v9}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;ZLjava/util/Date;)V

    .line 99
    .local v1, "favorite":Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 87
    .end local v0    # "c":Landroid/database/Cursor;
    .end local v1    # "favorite":Lcom/xfinity/playerlib/model/VideoFavorite;
    .end local v2    # "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/VideoFavorite;>;"
    .end local v3    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v4    # "query":Ljava/lang/String;
    :cond_0
    const-string v4, "select * from favorite where user_name=? and is_adult = 0 order by _id desc"

    .restart local v4    # "query":Ljava/lang/String;
    goto :goto_0

    .restart local v0    # "c":Landroid/database/Cursor;
    .restart local v2    # "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/VideoFavorite;>;"
    .restart local v3    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_1
    move v5, v7

    .line 97
    goto :goto_2

    .line 101
    .end local v3    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_2
    return-object v2
.end method

.method public isInFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z
    .locals 8
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 105
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    .line 106
    .local v1, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "select * from favorite where user_name=? and namespace=? and merlin_id=?"

    const/4 v2, 0x3

    new-array v5, v2, [Ljava/lang/String;

    const/4 v6, 0x0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 108
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v6

    const/4 v2, 0x1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->name()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    const/4 v2, 0x2

    .line 109
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    .line 106
    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 110
    .local v0, "c":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    return v2
.end method
