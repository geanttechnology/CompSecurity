.class public Lcom/poshmark/db/PMDbHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "PMDbHelper.java"


# static fields
.field public static final COLUMN_CANONICAL_NAME:Ljava/lang/String; = "canonical_name"

.field public static final COLUMN_CATEGORY_ID:Ljava/lang/String; = "category_id"

.field public static final COLUMN_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final COLUMN_FOLLOWING_STATUS:Ljava/lang/String; = "following"

.field public static final COLUMN_ID:Ljava/lang/String; = "_id"

.field public static final COLUMN_INSERT_TIME:Ljava/lang/String; = "insert_dtm"

.field public static final COLUMN_LAST_UPDATE:Ljava/lang/String; = "last_update_dtm"

.field public static final COLUMN_LONG_NAME:Ljava/lang/String; = "long_name"

.field public static final COLUMN_RGB:Ljava/lang/String; = "rgb"

.field public static final COLUMN_SEARCH_KEYWORD:Ljava/lang/String; = "keyword"

.field public static final COLUMN_SEARCH_TYPE:Ljava/lang/String; = "type"

.field public static final COLUMN_SHORT_NAME:Ljava/lang/String; = "short_name"

.field public static final COLUMN_SUBCATEGORY_NAME:Ljava/lang/String; = "name"

.field public static final COLUMN_TIMESTAMP_TAG:Ljava/lang/String; = "tag"

.field public static final COLUMN_USER_ID:Ljava/lang/String; = "user"

.field private static final DATABASE_NAME:Ljava/lang/String; = "poshmark_app_Database.db"

.field private static final DATABASE_VERSION:I = 0x3

.field public static final INDEX_BRANDS_CANONICAL_NAME:Ljava/lang/String; = "canonical_name_index"

.field public static final INDEX_KEYWORD:Ljava/lang/String; = "search_keyword_index"

.field public static final TABLE_BRANDS:Ljava/lang/String; = "brands"

.field public static final TABLE_CATEGORY:Ljava/lang/String; = "category"

.field public static final TABLE_CATEGORY_SIZES:Ljava/lang/String; = "sizes"

.field public static final TABLE_COLORS:Ljava/lang/String; = "colors"

.field public static final TABLE_FOLLOWING_BRANDS:Ljava/lang/String; = "following"

.field public static final TABLE_RECENT_BRANDS:Ljava/lang/String; = "recent_brands"

.field public static final TABLE_SAVED_SEARCHES:Ljava/lang/String; = "saved_searches"

.field public static final TABLE_SUBCATEGORY:Ljava/lang/String; = "subcategory"

.field public static final TABLE_TIMESTAMPS:Ljava/lang/String; = "timestamps"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    const-string v0, "poshmark_app_Database.db"

    const/4 v1, 0x0

    const/4 v2, 0x3

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 71
    return-void
.end method

.method private createAllTablesAndIndexes(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 79
    const-string v1, "create table category(_id text primary key, canonical_name text not null collate nocase);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_0

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 80
    :goto_0
    const-string v1, "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_1

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 81
    :goto_1
    const-string v1, "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_2

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 82
    :goto_2
    const-string v1, "create table colors(_id text primary key, rgb text not null);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_3

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 83
    :goto_3
    const-string v1, "create table brands(_id integer primary key autoincrement, canonical_name text not null collate nocase, description text, following integer);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_4

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 84
    :goto_4
    const-string v1, "create table following(_id integer primary key autoincrement, user text not null, canonical_name text not null);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_5

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 85
    :goto_5
    const-string v1, "create table timestamps(tag text not null, last_update_dtm text not null);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_6

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 86
    :goto_6
    const-string v1, "create table recent_brands(_id integer primary key autoincrement, user text not null, canonical_name text not null, insert_dtm text not null);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_7

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 87
    :goto_7
    const-string v1, "create index canonical_name_index on brands(canonical_name);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_8

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 88
    :goto_8
    const-string v1, "create table saved_searches(_id integer primary key autoincrement, user text not null, keyword text not null, type text, insert_dtm text not null);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_9

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 89
    :goto_9
    const-string v0, "create index search_keyword_index on saved_searches(keyword);"

    instance-of v1, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_a

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 90
    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_a
    return-void

    .restart local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    move-object v0, p1

    .line 79
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v0, p1

    .line 80
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v0, p1

    .line 81
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_2

    :cond_3
    move-object v0, p1

    .line 82
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_3

    :cond_4
    move-object v0, p1

    .line 83
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_4

    :cond_5
    move-object v0, p1

    .line 84
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_5

    :cond_6
    move-object v0, p1

    .line 85
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_6

    :cond_7
    move-object v0, p1

    .line 86
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_7

    :cond_8
    move-object v0, p1

    .line 87
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_8

    :cond_9
    move-object v0, p1

    .line 88
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_9

    .line 89
    :cond_a
    check-cast p1, Landroid/database/sqlite/SQLiteDatabase;

    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {p1, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_a
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/poshmark/db/PMDbHelper;->createAllTablesAndIndexes(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 76
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 94
    packed-switch p2, :pswitch_data_0

    .line 102
    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 97
    .restart local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_0
    const-string v1, "create table category(_id text primary key, canonical_name text not null collate nocase);"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_0

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 98
    :goto_1
    const-string v1, "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_1

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 99
    :goto_2
    const-string v1, "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));"

    instance-of v0, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_2

    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 100
    :goto_3
    const-string v0, "create table colors(_id text primary key, rgb text not null);"

    instance-of v1, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_3

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v0, p1

    .line 97
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_1

    :cond_1
    move-object v0, p1

    .line 98
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_2

    :cond_2
    move-object v0, p1

    .line 99
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_3

    .line 100
    :cond_3
    check-cast p1, Landroid/database/sqlite/SQLiteDatabase;

    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {p1, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0

    .line 94
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
