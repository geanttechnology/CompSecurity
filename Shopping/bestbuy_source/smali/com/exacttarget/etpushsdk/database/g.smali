.class public Lcom/exacttarget/etpushsdk/database/g;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 19
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "latitude"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "longitude"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "radius"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "active"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "beacon_guid"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "beacon_major"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "beacon_minor"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "entry_count"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "exit_count"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "description"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "name"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "location_type"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "has_entered"

    aput-object v2, v0, v1

    sput-object v0, Lcom/exacttarget/etpushsdk/database/g;->a:[Ljava/lang/String;

    return-void
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 2

    .prologue
    .line 121
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "regions"

    invoke-virtual {v0, v1, p2, p0, p1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Region;
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 129
    new-instance v0, Lcom/exacttarget/etpushsdk/data/Region;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/data/Region;-><init>()V

    .line 131
    :try_start_0
    const-string v3, "id"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setId(Ljava/lang/String;)V

    .line 132
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "latitude"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setLatitude(Ljava/lang/Double;)V

    .line 133
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "longitude"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setLongitude(Ljava/lang/Double;)V

    .line 134
    const-string v3, "radius"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setRadius(Ljava/lang/Integer;)V

    .line 135
    const-string v3, "active"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_0

    move v3, v1

    :goto_0
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 136
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "beacon_guid"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setGuid(Ljava/lang/String;)V

    .line 137
    const-string v3, "beacon_major"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setMajor(Ljava/lang/Integer;)V

    .line 138
    const-string v3, "beacon_minor"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setMinor(Ljava/lang/Integer;)V

    .line 139
    const-string v3, "entry_count"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setEntryCount(Ljava/lang/Integer;)V

    .line 140
    const-string v3, "exit_count"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setExitCount(Ljava/lang/Integer;)V

    .line 141
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "description"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setDescription(Ljava/lang/String;)V

    .line 142
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "name"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setName(Ljava/lang/String;)V

    .line 143
    const-string v3, "location_type"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setLocationType(Ljava/lang/Integer;)V

    .line 144
    const-string v3, "has_entered"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_1

    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setHasEntered(Ljava/lang/Boolean;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 149
    :goto_2
    return-object v0

    :cond_0
    move v3, v2

    .line 135
    goto/16 :goto_0

    :cond_1
    move v1, v2

    .line 144
    goto :goto_1

    .line 145
    :catch_0
    move-exception v0

    .line 146
    const-string v1, "~!dg"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 147
    const/4 v0, 0x0

    goto :goto_2
.end method

.method public static a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 57
    const-string v3, "id = ?"

    .line 59
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p0, v4, v0

    .line 61
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "regions"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/g;->a:[Ljava/lang/String;

    const-string v8, "1"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 73
    if-eqz v0, :cond_1

    .line 74
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 75
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v5

    .line 77
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 80
    :cond_1
    return-object v5
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 8

    .prologue
    .line 84
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "regions"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/g;->a:[Ljava/lang/String;

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 93
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 95
    if-eqz v0, :cond_1

    .line 96
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 97
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_0

    .line 98
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v2

    .line 99
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 100
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 102
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 105
    :cond_1
    return-object v1
.end method

.method public static a(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 4

    .prologue
    .line 40
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "regions"

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/g;->d(Lcom/exacttarget/etpushsdk/data/Region;)Landroid/content/ContentValues;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 44
    return-void
.end method

.method public static b(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v0

    .line 49
    if-nez v0, :cond_0

    .line 50
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/g;->a(Lcom/exacttarget/etpushsdk/data/Region;)V

    .line 54
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    goto :goto_0
.end method

.method public static c(Lcom/exacttarget/etpushsdk/data/Region;)I
    .locals 5

    .prologue
    .line 110
    const-string v0, "id = ?"

    .line 111
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 113
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v3, "regions"

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/g;->d(Lcom/exacttarget/etpushsdk/data/Region;)Landroid/content/ContentValues;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method private static d(Lcom/exacttarget/etpushsdk/data/Region;)Landroid/content/ContentValues;
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 153
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 155
    const-string v0, "id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    const-string v0, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getLatitude()Ljava/lang/Double;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    const-string v0, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getLongitude()Ljava/lang/Double;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    const-string v0, "radius"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getRadius()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 159
    const-string v4, "active"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getActive()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 160
    const-string v0, "beacon_guid"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getGuid()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    const-string v0, "beacon_major"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 162
    const-string v0, "beacon_minor"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 163
    const-string v0, "entry_count"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 164
    const-string v0, "exit_count"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 165
    const-string v0, "description"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const-string v0, "name"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    const-string v0, "location_type"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getLocationType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 168
    const-string v0, "has_entered"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getHasEntered()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_1

    :goto_1
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 170
    return-object v3

    :cond_0
    move v0, v2

    .line 159
    goto :goto_0

    :cond_1
    move v1, v2

    .line 168
    goto :goto_1
.end method
