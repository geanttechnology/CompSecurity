.class final Lcom/wishabi/flipp/app/br;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/bt;


# instance fields
.field final synthetic a:Landroid/app/Activity;

.field final synthetic b:Lcom/wishabi/flipp/app/bo;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bo;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 295
    iput-object p1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iput-object p2, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 316
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 317
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V
    .locals 4

    .prologue
    .line 307
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->d(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/bu;->a()V

    .line 310
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->e(Lcom/wishabi/flipp/app/bo;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 311
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v2

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getZoomScale()F

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;F)V

    .line 313
    :cond_1
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerViewGroup;II)V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/high16 v7, 0x3f000000    # 0.5f

    .line 542
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getZoomScale()F

    move-result v0

    .line 543
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getMinZoomScale()F

    move-result v1

    .line 544
    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 545
    new-instance v0, Landroid/graphics/RectF;

    int-to-float v2, p2

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, v7

    div-float/2addr v3, v1

    sub-float/2addr v2, v3

    int-to-float v3, p3

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    mul-float/2addr v4, v7

    div-float/2addr v4, v1

    sub-float/2addr v3, v4

    int-to-float v4, p2

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v5, v7

    div-float/2addr v5, v1

    add-float/2addr v4, v5

    int-to-float v5, p3

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v6

    int-to-float v6, v6

    mul-float/2addr v6, v7

    div-float v1, v6, v1

    add-float/2addr v1, v5

    invoke-direct {v0, v2, v3, v4, v1}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {p1, v0, v8, v8}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;ZZ)V

    .line 554
    :goto_0
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 555
    return-void

    .line 551
    :cond_0
    new-instance v0, Landroid/graphics/RectF;

    add-int/lit16 v1, p2, -0xfa

    int-to-float v1, v1

    add-int/lit16 v2, p3, -0xfa

    int-to-float v2, v2

    add-int/lit16 v3, p2, 0xfa

    int-to-float v3, v3

    add-int/lit16 v4, p3, 0xfa

    int-to-float v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {p1, v0, v8, v8}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;ZZ)V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerViewGroup;J)V
    .locals 2

    .prologue
    .line 298
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->playSoundEffect(I)V

    .line 299
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->sendAccessibilityEvent(I)V

    .line 302
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0, p2, p3}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;J)Z

    .line 303
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V
    .locals 6

    .prologue
    .line 323
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 324
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bo;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 325
    if-eqz v0, :cond_0

    if-eqz p2, :cond_0

    if-nez v1, :cond_1

    .line 360
    :cond_0
    :goto_0
    return-void

    .line 329
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->performHapticFeedback(I)Z

    .line 331
    iget-object v0, p2, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/app/bt;

    .line 334
    iget v1, v0, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-static {v1}, Lcom/wishabi/flipp/content/ag;->a(I)Lcom/wishabi/flipp/content/ag;

    move-result-object v1

    .line 335
    if-nez v1, :cond_2

    .line 336
    sget-object v1, Lcom/wishabi/flipp/content/ag;->a:Lcom/wishabi/flipp/content/ag;

    .line 338
    :cond_2
    sget-object v2, Lcom/wishabi/flipp/app/bs;->a:[I

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ag;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 352
    iget v1, v1, Lcom/wishabi/flipp/content/ag;->w:I

    invoke-static {v1}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-wide v2, v0, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v1, v2, v3}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 354
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1, p2}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/widget/bi;)Z

    .line 357
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v2, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v2}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v2

    iget-wide v4, v0, Lcom/wishabi/flipp/app/bt;->a:J

    sget-object v0, Lcom/wishabi/flipp/b/o;->a:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v1, v2, v4, v5, v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V

    goto :goto_0

    .line 340
    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    goto :goto_0

    .line 343
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/bo;->b(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    goto :goto_0

    .line 346
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    goto :goto_0

    .line 349
    :pswitch_3
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/bo;->d(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    goto :goto_0

    .line 338
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final b(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V
    .locals 12

    .prologue
    .line 365
    if-nez p2, :cond_3

    .line 366
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->g(Lcom/wishabi/flipp/app/bo;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 367
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    const v2, 0x7f0e00d9

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;)V

    .line 368
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    const-string v2, "loading"

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;)V

    .line 377
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 378
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    .line 536
    :cond_0
    :goto_1
    return-void

    .line 369
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->h(Lcom/wishabi/flipp/app/bo;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 370
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    const v2, 0x7f0e00f7

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;)V

    .line 371
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    const-string v2, "no items"

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;)V

    goto :goto_0

    .line 373
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    const v2, 0x7f0e000b

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;)V

    .line 374
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    const-string v2, "no box"

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;)V

    goto :goto_0

    .line 384
    :cond_3
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->playSoundEffect(I)V

    .line 385
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->sendAccessibilityEvent(I)V

    .line 388
    iget-object v0, p2, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    move-object v7, v0

    check-cast v7, Lcom/wishabi/flipp/app/bt;

    .line 392
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    sget-object v1, Lcom/wishabi/flipp/content/ag;->c:Lcom/wishabi/flipp/content/ag;

    iget v1, v1, Lcom/wishabi/flipp/content/ag;->w:I

    if-ne v0, v1, :cond_4

    .line 393
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0, v7}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    .line 394
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 395
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto :goto_1

    .line 400
    :cond_4
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    sget-object v1, Lcom/wishabi/flipp/content/ag;->d:Lcom/wishabi/flipp/content/ag;

    iget v1, v1, Lcom/wishabi/flipp/content/ag;->w:I

    if-ne v0, v1, :cond_5

    .line 401
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0, v7}, Lcom/wishabi/flipp/app/bo;->b(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    .line 402
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 403
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto/16 :goto_1

    .line 408
    :cond_5
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    sget-object v1, Lcom/wishabi/flipp/content/ag;->l:Lcom/wishabi/flipp/content/ag;

    iget v1, v1, Lcom/wishabi/flipp/content/ag;->w:I

    if-ne v0, v1, :cond_6

    .line 409
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0, v7}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    .line 410
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 411
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto/16 :goto_1

    .line 416
    :cond_6
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    sget-object v1, Lcom/wishabi/flipp/content/ag;->e:Lcom/wishabi/flipp/content/ag;

    iget v1, v1, Lcom/wishabi/flipp/content/ag;->w:I

    if-ne v0, v1, :cond_7

    .line 417
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0, v7}, Lcom/wishabi/flipp/app/bo;->d(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z

    .line 418
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 419
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto/16 :goto_1

    .line 425
    :cond_7
    const/4 v8, 0x0

    .line 426
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->i(Lcom/wishabi/flipp/app/bo;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->i(Lcom/wishabi/flipp/app/bo;)Ljava/util/HashMap;

    move-result-object v0

    iget-wide v2, v7, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    move-object v6, v0

    .line 430
    :goto_2
    :try_start_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-wide v10, v7, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v10, v11}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 433
    if-eqz v1, :cond_b

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 435
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-wide v8, v7, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 439
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-static {v0}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v0

    if-eqz v0, :cond_8

    if-eqz v6, :cond_8

    .line 440
    const/4 v0, 0x0

    sget-object v2, Lcom/wishabi/flipp/b/p;->a:Lcom/wishabi/flipp/b/p;

    const/4 v3, 0x1

    invoke-static {v6, v0, v2, v3}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z

    .line 443
    :cond_8
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_9

    .line 444
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, -0x1

    invoke-interface {v0, v2, v3, v4}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 450
    :cond_9
    if-eqz v1, :cond_0

    .line 451
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 426
    :cond_a
    const/4 v0, 0x0

    move-object v6, v0

    goto :goto_2

    .line 450
    :cond_b
    if-eqz v1, :cond_c

    .line 451
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 455
    :cond_c
    iget v0, v7, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-static {v0}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 457
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-wide v2, v7, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v0, v2, v3}, Lcom/wishabi/flipp/app/bo;->b(Lcom/wishabi/flipp/app/bo;J)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 458
    const/4 v0, 0x0

    sget-object v1, Lcom/wishabi/flipp/b/p;->a:Lcom/wishabi/flipp/b/p;

    const/4 v2, 0x1

    invoke-static {v6, v0, v1, v2}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z

    .line 461
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 462
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto/16 :goto_1

    .line 450
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_3
    if-eqz v1, :cond_d

    .line 451
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_d
    throw v0

    .line 469
    :cond_e
    if-eqz v6, :cond_10

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_10

    .line 470
    const/4 v0, 0x1

    sget-object v1, Lcom/wishabi/flipp/b/p;->a:Lcom/wishabi/flipp/b/p;

    const/4 v2, 0x1

    invoke-static {v6, v0, v1, v2}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z

    .line 473
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 474
    iget-object v0, v7, Lcom/wishabi/flipp/app/bt;->k:Ljava/lang/String;

    .line 475
    if-eqz v0, :cond_f

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 476
    const/4 v0, 0x0

    .line 478
    :cond_f
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v1

    const/4 v2, 0x1

    iget v3, v7, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-interface {v1, v2, v0, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    goto/16 :goto_1

    .line 490
    :cond_10
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 491
    const-string v1, "_id"

    iget-wide v2, v7, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 492
    const-string v1, "flyer_id"

    iget v2, v7, Lcom/wishabi/flipp/app/bt;->b:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 493
    const-string v1, "bottom"

    iget v2, v7, Lcom/wishabi/flipp/app/bt;->c:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Float;)V

    .line 494
    const-string v1, "top"

    iget v2, v7, Lcom/wishabi/flipp/app/bt;->d:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Float;)V

    .line 495
    const-string v1, "left"

    iget v2, v7, Lcom/wishabi/flipp/app/bt;->e:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Float;)V

    .line 496
    const-string v1, "right"

    iget v2, v7, Lcom/wishabi/flipp/app/bt;->f:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Float;)V

    .line 497
    const-string v1, "merchant"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 498
    const-string v1, "merchant_logo"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->h:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 499
    const-string v1, "name"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 500
    const-string v1, "premium"

    iget-boolean v2, v7, Lcom/wishabi/flipp/app/bt;->i:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 501
    const-string v1, "price"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    const-string v1, "thumbnail"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    const-string v1, "valid_to"

    iget-object v2, v7, Lcom/wishabi/flipp/app/bt;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 504
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 508
    if-eqz v6, :cond_11

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_11

    .line 509
    const/4 v0, 0x1

    sget-object v1, Lcom/wishabi/flipp/b/p;->a:Lcom/wishabi/flipp/b/p;

    const/4 v2, 0x1

    invoke-static {v6, v0, v1, v2}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z

    .line 513
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 514
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    if-nez v1, :cond_14

    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    .line 518
    :cond_11
    :goto_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 519
    iget-object v0, v7, Lcom/wishabi/flipp/app/bt;->k:Ljava/lang/String;

    .line 520
    if-eqz v0, :cond_12

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 521
    const/4 v0, 0x0

    .line 523
    :cond_12
    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;

    move-result-object v1

    const/4 v2, 0x1

    iget v3, v7, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-interface {v1, v2, v0, v3}, Lcom/wishabi/flipp/app/bu;->a(ZLjava/lang/String;I)V

    .line 527
    :cond_13
    iget-object v0, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->a:Landroid/app/Activity;

    const v2, 0x7f0e00ca

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bo;->a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;)V

    .line 529
    iget-object v0, v7, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    if-eqz v0, :cond_15

    iget-object v0, v7, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->c(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_15

    iget-object v0, v7, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v5

    .line 533
    :goto_5
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 534
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/br;->b:Lcom/wishabi/flipp/app/bo;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bo;->f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v1

    iget-wide v2, v7, Lcom/wishabi/flipp/app/bt;->a:J

    sget-object v4, Lcom/wishabi/flipp/b/o;->e:Lcom/wishabi/flipp/b/o;

    invoke-virtual/range {v0 .. v6}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;D)V

    goto/16 :goto_1

    .line 514
    :cond_14
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v2, 0x2

    new-array v2, v2, [Lcom/wishabi/flipp/content/FormattedString$Part;

    const/4 v4, 0x0

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e0144

    invoke-virtual {v1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v8, 0x1

    new-array v8, v8, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v9, 0x0

    new-instance v10, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v11, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v10, v11}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v10, v8, v9

    invoke-direct {v5, v6, v8}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v2, v4

    const/4 v4, 0x1

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e0145

    invoke-virtual {v1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v6, 0x1

    new-array v6, v6, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v8, 0x0

    new-instance v9, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v10, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v9, v10}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v9, v6, v8

    invoke-direct {v5, v1, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v2, v4

    invoke-direct {v3, v2}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    const/4 v1, 0x0

    const-string v2, "tutorial_showed_after_clipping"

    const v4, 0x7f0200f3

    const v5, 0x7f0200f1

    const/4 v6, 0x0

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    goto/16 :goto_4

    .line 529
    :cond_15
    const-wide/16 v5, 0x0

    goto :goto_5

    .line 450
    :catchall_1
    move-exception v0

    goto/16 :goto_3
.end method
