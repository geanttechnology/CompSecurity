.class final Lcom/wishabi/flipp/content/bd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/bk;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 134
    const-string v0, "CREATE TABLE shopping_lists (id INTEGER PRIMARY KEY,name TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 138
    const-string v0, "CREATE TABLE shopping_list_items (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,position INTEGER,checked INTEGER,datetime_updated INTEGER,shopping_list_id INTEGER,FOREIGN KEY(shopping_list_id) REFERENCES shopping_lists(id));"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 146
    return-void
.end method

.method public final b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 150
    const-string v0, "DROP TABLE IF EXISTS shopping_lists;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 151
    const-string v0, "DROP TABLE IF EXISTS shopping_list_items;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 152
    return-void
.end method
