.class final Lcom/wishabi/flipp/b/b;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 7

    .prologue
    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-object v2, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;)J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x1f4

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 267
    iget-object v1, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/b/a;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v2

    iget-object v0, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->c(Lcom/wishabi/flipp/b/a;)Landroid/graphics/RectF;

    move-result-object v3

    iget-object v0, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->d(Lcom/wishabi/flipp/b/a;)F

    move-result v4

    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    const-string v0, "flyer_id"

    iget v6, v2, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "analytics_payload"

    iget-object v6, v2, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v5, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "flyer_run_id"

    iget v6, v2, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "flyer_type_id"

    iget v6, v2, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "merchant_id"

    iget v6, v2, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v6, "flipp_premium_merchant"

    iget-boolean v0, v2, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v0, :cond_2

    const-string v0, "1"

    :goto_0
    invoke-virtual {v5, v6, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "postal_code"

    iget-object v2, v2, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "screen_width"

    iget-object v2, v1, Lcom/wishabi/flipp/b/a;->l:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "screen_height"

    iget-object v2, v1, Lcom/wishabi/flipp/b/a;->l:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "left"

    iget v2, v3, Landroid/graphics/RectF;->left:F

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "right"

    iget v2, v3, Landroid/graphics/RectF;->right:F

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "top"

    iget v2, v3, Landroid/graphics/RectF;->top:F

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "bottom"

    iget v2, v3, Landroid/graphics/RectF;->bottom:F

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    cmpl-float v0, v4, v0

    if-lez v0, :cond_0

    const-string v0, "resolution"

    const/high16 v2, 0x3f800000    # 1.0f

    div-float/2addr v2, v4

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    const-string v0, "view"

    invoke-virtual {v1, v0, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;)V

    .line 268
    iget-object v0, p0, Lcom/wishabi/flipp/b/b;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->e(Lcom/wishabi/flipp/b/a;)J

    .line 270
    :cond_1
    return-void

    .line 267
    :cond_2
    const-string v0, "0"

    goto :goto_0
.end method
