.class final Lcom/wishabi/flipp/content/w;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 286
    const-string v0, "flyers.db"

    const/4 v1, 0x0

    const/4 v2, 0x7

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 287
    return-void
.end method


# virtual methods
.method public final onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 291
    const/4 v0, 0x0

    const/4 v1, 0x7

    invoke-virtual {p0, p1, v0, v1}, Lcom/wishabi/flipp/content/w;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 292
    return-void
.end method

.method public final onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 2

    .prologue
    .line 302
    add-int/lit8 v0, p2, -0x1

    :goto_0
    if-lt v0, p3, :cond_0

    .line 303
    invoke-static {}, Lcom/wishabi/flipp/content/FlyersContentProvider;->a()[Lcom/wishabi/flipp/content/x;

    move-result-object v1

    aget-object v1, v1, v0

    invoke-interface {v1, p1}, Lcom/wishabi/flipp/content/x;->b(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 302
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 304
    :cond_0
    return-void
.end method

.method public final onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 296
    :goto_0
    if-ge p2, p3, :cond_0

    .line 297
    invoke-static {}, Lcom/wishabi/flipp/content/FlyersContentProvider;->a()[Lcom/wishabi/flipp/content/x;

    move-result-object v0

    aget-object v0, v0, p2

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/content/x;->a(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 296
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 298
    :cond_0
    return-void
.end method
