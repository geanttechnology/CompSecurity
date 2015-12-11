.class public final Lcom/wishabi/flipp/content/h;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:J

.field public b:I

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field public f:I

.field public g:Ljava/lang/String;

.field public h:Ljava/lang/String;

.field public i:I

.field private j:Landroid/graphics/RectF;


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wishabi/flipp/content/h;->a:J

    .line 24
    const-string v0, "flyer_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/h;->b:I

    .line 25
    const-string v0, "item_image_url"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->c:Ljava/lang/String;

    .line 26
    const-string v0, "weight"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/h;->i:I

    .line 28
    const-string v0, "sale_story"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    .line 29
    const-string v0, "description"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->e:Ljava/lang/String;

    .line 30
    const-string v0, "brand_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/h;->f:I

    .line 31
    const-string v0, "brand_logo_image_url"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->h:Ljava/lang/String;

    .line 32
    const-string v0, "brand_display_name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    .line 34
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    const-string v1, "left"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    iput v1, v0, Landroid/graphics/RectF;->left:F

    .line 36
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    const-string v1, "top"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    iput v1, v0, Landroid/graphics/RectF;->top:F

    .line 37
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    const-string v1, "right"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    iput v1, v0, Landroid/graphics/RectF;->right:F

    .line 38
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    const-string v1, "bottom"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    iput v1, v0, Landroid/graphics/RectF;->bottom:F

    .line 39
    return-void
.end method

.method public static a(Ljava/util/List;)Lcom/wishabi/flipp/content/h;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;)",
            "Lcom/wishabi/flipp/content/h;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 92
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    :cond_0
    const/4 v0, 0x0

    .line 116
    :goto_0
    return-object v0

    .line 95
    :cond_1
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v5

    .line 98
    new-array v6, v5, [F

    move v3, v1

    move v4, v2

    .line 99
    :goto_1
    if-ge v3, v5, :cond_2

    .line 100
    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/h;

    .line 103
    iget v0, v0, Lcom/wishabi/flipp/content/h;->i:I

    int-to-float v0, v0

    .line 104
    aput v0, v6, v3

    .line 105
    add-float/2addr v4, v0

    .line 99
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 108
    :cond_2
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v8

    float-to-double v10, v4

    mul-double/2addr v8, v10

    double-to-float v3, v8

    move v0, v1

    move v1, v2

    .line 110
    :goto_2
    if-ge v0, v5, :cond_4

    .line 111
    aget v2, v6, v0

    add-float/2addr v1, v2

    .line 112
    cmpl-float v2, v1, v3

    if-ltz v2, :cond_3

    .line 113
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/h;

    goto :goto_0

    .line 110
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 116
    :cond_4
    add-int/lit8 v0, v5, -0x1

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/h;

    goto :goto_0
.end method

.method public static a(Ljava/util/List;J)Lcom/wishabi/flipp/content/h;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;J)",
            "Lcom/wishabi/flipp/content/h;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 121
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move-object v0, v1

    .line 129
    :goto_0
    return-object v0

    .line 124
    :cond_1
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/h;

    .line 125
    iget-wide v4, v0, Lcom/wishabi/flipp/content/h;->a:J

    cmp-long v3, v4, p1

    if-nez v3, :cond_2

    goto :goto_0

    :cond_3
    move-object v0, v1

    .line 129
    goto :goto_0
.end method


# virtual methods
.method public final a()Landroid/graphics/RectF;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 79
    const/4 v0, 0x0

    .line 81
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/h;->j:Landroid/graphics/RectF;

    goto :goto_0
.end method
