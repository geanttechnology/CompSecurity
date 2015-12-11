.class public final Lcom/wishabi/flipp/content/ai;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:J

.field public b:I

.field public c:Ljava/lang/String;

.field public d:Landroid/net/Uri;

.field public e:Landroid/graphics/RectF;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:Z

.field public i:Lb/a/a/b;

.field private j:I

.field private final k:I


# direct methods
.method private constructor <init>(I)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput p1, p0, Lcom/wishabi/flipp/content/ai;->k:I

    .line 30
    return-void
.end method

.method public static a(Lorg/json/JSONObject;ILandroid/content/ContentResolver;)Lcom/wishabi/flipp/content/ai;
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 35
    :try_start_0
    new-instance v6, Lcom/wishabi/flipp/content/ai;

    invoke-direct {v6, p1}, Lcom/wishabi/flipp/content/ai;-><init>(I)V

    .line 36
    const-string v0, "flyer_item_id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, v6, Lcom/wishabi/flipp/content/ai;->a:J

    .line 37
    const-string v0, "flyer_id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v6, Lcom/wishabi/flipp/content/ai;->b:I

    .line 38
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v6, Lcom/wishabi/flipp/content/ai;->c:Ljava/lang/String;

    .line 39
    const-string v0, "clipping_image_url"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, v6, Lcom/wishabi/flipp/content/ai;->d:Landroid/net/Uri;

    .line 40
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, v6, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    .line 41
    iget-object v0, v6, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    const-string v1, "left"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    iput v1, v0, Landroid/graphics/RectF;->left:F

    .line 42
    iget-object v0, v6, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    const-string v1, "top"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    neg-float v1, v1

    iput v1, v0, Landroid/graphics/RectF;->top:F

    .line 43
    iget-object v0, v6, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    const-string v1, "right"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    .line 44
    iget-object v0, v6, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    const-string v1, "bottom"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    neg-float v1, v1

    iput v1, v0, Landroid/graphics/RectF;->bottom:F
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 48
    :try_start_1
    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "flyer_id = ?"

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    iget v5, v6, Lcom/wishabi/flipp/content/ai;->b:I

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    move-object v0, p2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v1

    .line 52
    if-eqz v1, :cond_0

    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v0

    if-nez v0, :cond_2

    .line 71
    :cond_0
    if-eqz v1, :cond_1

    .line 72
    :try_start_3
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    :cond_1
    move-object v0, v6

    .line 75
    :goto_0
    return-object v0

    .line 55
    :cond_2
    :try_start_4
    const-string v0, "merchant"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v6, Lcom/wishabi/flipp/content/ai;->f:Ljava/lang/String;

    .line 57
    const-string v0, "merchant_logo"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v6, Lcom/wishabi/flipp/content/ai;->g:Ljava/lang/String;

    .line 59
    const-string v0, "priority"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, v6, Lcom/wishabi/flipp/content/ai;->j:I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 63
    :try_start_5
    const-string v0, "premium"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v6, Lcom/wishabi/flipp/content/ai;->h:Z
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 71
    :goto_1
    if-eqz v1, :cond_3

    .line 72
    :try_start_6
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_1

    :cond_3
    move-object v0, v6

    goto :goto_0

    .line 65
    :catch_0
    move-exception v0

    :try_start_7
    const-string v0, "premium"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v8, :cond_5

    move v0, v8

    :goto_2
    iput-boolean v0, v6, Lcom/wishabi/flipp/content/ai;->h:Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_1

    .line 71
    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_4

    .line 72
    :try_start_8
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_1

    .line 75
    :catch_1
    move-exception v0

    move-object v0, v7

    goto :goto_0

    :cond_5
    move v0, v9

    .line 65
    goto :goto_2

    .line 71
    :catchall_1
    move-exception v0

    move-object v1, v7

    goto :goto_3
.end method
