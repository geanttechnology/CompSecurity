.class final Lcom/wishabi/flipp/content/t;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/x;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 169
    const-string v0, "CREATE TABLE featured_items (_id INTEGER PRIMARY KEY, flyer_id INTEGER, item_image_url TEXT, sale_story TEXT, description TEXT, brand_id INTEGER, brand_logo_image_url TEXT, brand_display_name TEXT, weight INTEGER, left REAL, top REAL, right REAL, bottom REAL);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 183
    return-void
.end method

.method public final b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 187
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Downward migration not supported"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
