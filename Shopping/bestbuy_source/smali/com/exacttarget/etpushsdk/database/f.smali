.class public Lcom/exacttarget/etpushsdk/database/f;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 22
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "message_id"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "region_id"

    aput-object v2, v0, v1

    sput-object v0, Lcom/exacttarget/etpushsdk/database/f;->a:[Ljava/lang/String;

    return-void
.end method

.method public static a(I)I
    .locals 6

    .prologue
    .line 63
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "region_message"

    const-string v2, "id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Ljava/util/List;)I
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 71
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "region_message"

    const-string v2, "id IN (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const-string v4, ","

    invoke-static {v4, p0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/RegionMessage;
    .locals 3

    .prologue
    .line 80
    new-instance v0, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;-><init>()V

    .line 82
    :try_start_0
    const-string v1, "id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->setId(Ljava/lang/Integer;)V

    .line 84
    const-string v1, "message_id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 85
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v1

    .line 86
    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->setMessage(Lcom/exacttarget/etpushsdk/data/Message;)V

    .line 88
    const-string v1, "region_id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 89
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v1

    .line 90
    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->setRegion(Lcom/exacttarget/etpushsdk/data/Region;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    :goto_0
    return-object v0

    .line 92
    :catch_0
    move-exception v0

    .line 93
    const-string v1, "~!df"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 94
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 8

    .prologue
    .line 38
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "region_message"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/f;->a:[Ljava/lang/String;

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 47
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 49
    if-eqz v0, :cond_1

    .line 50
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 51
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_0

    .line 52
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/f;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/RegionMessage;

    move-result-object v2

    .line 53
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 54
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 56
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 59
    :cond_1
    return-object v1
.end method

.method public static a(Lcom/exacttarget/etpushsdk/data/RegionMessage;)V
    .locals 4

    .prologue
    .line 29
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "region_message"

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/f;->b(Lcom/exacttarget/etpushsdk/data/RegionMessage;)Landroid/content/ContentValues;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 34
    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->setId(Ljava/lang/Integer;)V

    .line 35
    return-void
.end method

.method private static b(Lcom/exacttarget/etpushsdk/data/RegionMessage;)Landroid/content/ContentValues;
    .locals 3

    .prologue
    .line 100
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 102
    const-string v1, "message_id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getMessage()Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    const-string v1, "region_id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getRegion()Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    return-object v0
.end method
