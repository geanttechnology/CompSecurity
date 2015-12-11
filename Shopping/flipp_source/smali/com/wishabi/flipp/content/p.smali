.class final Lcom/wishabi/flipp/content/p;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/x;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 78
    const-string v0, "CREATE TABLE flyers (_id INTEGER PRIMARY KEY, flyer_id INTEGER, available_from TEXT, available_to TEXT, flyer_run_id INTEGER, flyer_type_id INTEGER, width REAL, height REAL, language TEXT, locale TEXT, merchant TEXT, merchant_id INTEGER, merchant_logo TEXT, name TEXT, path TEXT, postal_code TEXT, premium INTEGER, priority INTEGER, resolutions TEXT, thumbnail TEXT, updated_at TEXT, valid_from TEXT, valid_to TEXT, web_indexed INTEGER);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 103
    const-string v0, "CREATE TABLE items (_id INTEGER PRIMARY KEY, available_to TEXT, bottom REAL, top REAL, left REAL, right REAL, brand TEXT, discount REAL, flyer_id INTEGER, name TEXT, price TEXT, thumbnail TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 116
    const-string v0, "CREATE TABLE categories (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, flyer_id INTEGER, UNIQUE (name, flyer_id));"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 121
    return-void
.end method

.method public final b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 125
    const-string v0, "DROP TABLE IF EXISTS flyers;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 126
    const-string v0, "DROP TABLE IF EXISTS items;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 127
    const-string v0, "DROP TABLE IF EXISTS categories;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 128
    return-void
.end method
