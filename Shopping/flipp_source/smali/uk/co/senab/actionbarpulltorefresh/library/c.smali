.class public final Luk/co/senab/actionbarpulltorefresh/library/c;
.super Luk/co/senab/actionbarpulltorefresh/library/f;
.source "SourceFile"


# instance fields
.field a:Landroid/view/View;

.field private b:Landroid/view/ViewGroup;

.field private c:Landroid/widget/TextView;

.field private d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

.field private e:Ljava/lang/CharSequence;

.field private f:Ljava/lang/CharSequence;

.field private g:Ljava/lang/CharSequence;

.field private h:I

.field private i:J

.field private j:I

.field private k:I

.field private final l:Landroid/view/animation/Interpolator;


# direct methods
.method protected constructor <init>()V
    .locals 2

    .prologue
    .line 69
    invoke-direct {p0}, Luk/co/senab/actionbarpulltorefresh/library/f;-><init>()V

    .line 65
    const/4 v0, -0x2

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->k:I

    .line 67
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->l:Landroid/view/animation/Interpolator;

    .line 70
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-ge v0, v1, :cond_0

    .line 72
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This HeaderTransformer is designed to run on SDK 14+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_0
    return-void
.end method

.method private static a(Landroid/content/Context;I[I)Landroid/content/res/TypedArray;
    .locals 3

    .prologue
    .line 443
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 444
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, p1, v0, v2}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 445
    iget v0, v0, Landroid/util/TypedValue;->resourceId:I

    .line 448
    invoke-virtual {p0, v0, p2}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method

.method private static a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 388
    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x10100d4

    aput v1, v0, v2

    .line 391
    const v1, 0x10102ce

    invoke-static {p0, v1, v0}, Luk/co/senab/actionbarpulltorefresh/library/c;->a(Landroid/content/Context;I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 395
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 397
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method private static b(Landroid/content/Context;)I
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 402
    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x10102eb

    aput v1, v0, v2

    .line 403
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 405
    const/4 v1, 0x0

    const/4 v2, 0x0

    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 407
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method private b(Landroid/app/Activity;Landroid/view/View;)V
    .locals 4

    .prologue
    .line 289
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/p;->ptrHeaderStyle:I

    sget-object v1, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader:[I

    invoke-static {p1, v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/c;->a(Landroid/content/Context;I[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 293
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 294
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrHeaderHeight:I

    invoke-static {p1}, Luk/co/senab/actionbarpulltorefresh/library/c;->b(Landroid/content/Context;)I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v0

    .line 296
    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    iput v0, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 297
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->requestLayout()V

    .line 301
    :cond_0
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrHeaderBackground:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_8

    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrHeaderBackground:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 304
    :goto_0
    if-eqz v0, :cond_1

    .line 305
    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 308
    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    .line 309
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setBackgroundResource(I)V

    .line 314
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 315
    sget v2, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrHeaderTitleTextAppearance:I

    invoke-static {v0}, Luk/co/senab/actionbarpulltorefresh/library/c;->c(Landroid/content/Context;)I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 318
    if-eqz v2, :cond_2

    .line 319
    iget-object v3, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    invoke-virtual {v3, v0, v2}, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 323
    :cond_2
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrProgressBarColor:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 324
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrProgressBarColor:I

    iget v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->h:I

    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->h:I

    .line 328
    :cond_3
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrProgressBarStyle:I

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->j:I

    .line 331
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrProgressBarHeight:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 332
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrProgressBarHeight:I

    iget v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->k:I

    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v0

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->k:I

    .line 337
    :cond_4
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrPullText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 338
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrPullText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->e:Ljava/lang/CharSequence;

    .line 340
    :cond_5
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrRefreshingText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 341
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrRefreshingText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->f:Ljava/lang/CharSequence;

    .line 344
    :cond_6
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrReleaseText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 345
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader_ptrReleaseText:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->g:Ljava/lang/CharSequence;

    .line 348
    :cond_7
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 349
    return-void

    .line 301
    :cond_8
    invoke-static {p1}, Luk/co/senab/actionbarpulltorefresh/library/c;->a(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto/16 :goto_0
.end method

.method private static c(Landroid/content/Context;)I
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 412
    const/4 v0, 0x1

    new-array v0, v0, [I

    const v1, 0x10102f8

    aput v1, v0, v2

    .line 415
    const v1, 0x10102ce

    invoke-static {p0, v1, v0}, Luk/co/senab/actionbarpulltorefresh/library/c;->a(Landroid/content/Context;I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 419
    const/4 v1, 0x0

    const/4 v2, 0x0

    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 421
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method


# virtual methods
.method public final a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 118
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v0, v2}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v0, v2}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setProgress(I)V

    .line 121
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v0, v2}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setIndeterminate(Z)V

    .line 125
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    if-eqz v0, :cond_1

    .line 126
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 127
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->e:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    :cond_1
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    if-eqz v0, :cond_2

    .line 132
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 133
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_2

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 135
    :cond_2
    return-void
.end method

.method public final a(F)V
    .locals 3

    .prologue
    .line 139
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setVisibility(I)V

    .line 141
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->l:Landroid/view/animation/Interpolator;

    invoke-interface {v0, p1}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v0

    .line 142
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v2}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->getMax()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    invoke-virtual {v1, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setProgress(I)V

    .line 144
    :cond_0
    return-void
.end method

.method public final a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    invoke-direct {p0, p1, v0}, Luk/co/senab/actionbarpulltorefresh/library/c;->b(Landroid/app/Activity;Landroid/view/View;)V

    .line 113
    return-void
.end method

.method public final a(Landroid/app/Activity;Landroid/view/View;)V
    .locals 4

    .prologue
    .line 80
    iput-object p2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    .line 83
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/s;->ptr_progress:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    .line 84
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/s;->ptr_text:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    .line 85
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/s;->ptr_content:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    .line 88
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/u;->pull_to_refresh_pull_label:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->e:Ljava/lang/CharSequence;

    .line 89
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/u;->pull_to_refresh_refreshing_label:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->f:Ljava/lang/CharSequence;

    .line 90
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/u;->pull_to_refresh_release_label:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->g:Ljava/lang/CharSequence;

    .line 92
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x10e0000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->i:J

    .line 95
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Luk/co/senab/actionbarpulltorefresh/library/q;->default_progress_bar_color:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->h:I

    .line 99
    invoke-direct {p0, p1, p2}, Luk/co/senab/actionbarpulltorefresh/library/c;->b(Landroid/app/Activity;Landroid/view/View;)V

    .line 101
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x1

    iget v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->k:I

    invoke-direct {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    iget v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->j:I

    packed-switch v1, :pswitch_data_0

    :goto_0
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v1, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 104
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    if-eqz v0, :cond_0

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Luk/co/senab/actionbarpulltorefresh/library/r;->ptr_progress_bar_stroke_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    new-instance v2, Lfr/castorflex/android/smoothprogressbar/k;

    iget-object v3, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v3}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Lfr/castorflex/android/smoothprogressbar/k;-><init>(Landroid/content/Context;)V

    iget v3, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->h:I

    invoke-virtual {v2, v3}, Lfr/castorflex/android/smoothprogressbar/k;->a(I)Lfr/castorflex/android/smoothprogressbar/k;

    move-result-object v2

    invoke-virtual {v2, v0}, Lfr/castorflex/android/smoothprogressbar/k;->b(I)Lfr/castorflex/android/smoothprogressbar/k;

    move-result-object v0

    invoke-virtual {v0}, Lfr/castorflex/android/smoothprogressbar/k;->a()Lfr/castorflex/android/smoothprogressbar/i;

    move-result-object v0

    invoke-virtual {v1, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setIndeterminateDrawable(Landroid/graphics/drawable/Drawable;)V

    new-instance v0, Landroid/graphics/drawable/ShapeDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/ShapeDrawable;-><init>()V

    new-instance v1, Landroid/graphics/drawable/shapes/RectShape;

    invoke-direct {v1}, Landroid/graphics/drawable/shapes/RectShape;-><init>()V

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/ShapeDrawable;->setShape(Landroid/graphics/drawable/shapes/Shape;)V

    invoke-virtual {v0}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v1

    iget v2, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->h:I

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v1, Landroid/graphics/drawable/ClipDrawable;

    const/16 v2, 0x11

    const/4 v3, 0x1

    invoke-direct {v1, v0, v2, v3}, Landroid/graphics/drawable/ClipDrawable;-><init>(Landroid/graphics/drawable/Drawable;II)V

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v0, v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setProgressDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 107
    :cond_0
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/c;->a()V

    .line 108
    return-void

    .line 101
    :pswitch_0
    const/16 v1, 0x8

    sget v2, Luk/co/senab/actionbarpulltorefresh/library/s;->ptr_content:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    goto :goto_0

    :pswitch_1
    const/4 v1, 0x3

    sget v2, Luk/co/senab/actionbarpulltorefresh/library/s;->ptr_content:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->f:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 151
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    if-eqz v0, :cond_1

    .line 152
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setVisibility(I)V

    .line 153
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setIndeterminate(Z)V

    .line 155
    :cond_1
    return-void
.end method

.method public final c()V
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->c:Landroid/widget/TextView;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->g:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 162
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    if-eqz v0, :cond_1

    .line 163
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->d:Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;

    invoke-virtual {v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->getMax()I

    move-result v1

    invoke-virtual {v0, v1}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setProgress(I)V

    .line 165
    :cond_1
    return-void
.end method

.method public final d()V
    .locals 3

    .prologue
    .line 170
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 171
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    const-string v1, "alpha"

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_0

    invoke-static {v0, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 173
    :cond_0
    return-void

    .line 171
    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method public final e()Z
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 181
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 183
    :goto_0
    if-eqz v0, :cond_0

    .line 184
    iget-object v3, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/View;->setVisibility(I)V

    .line 185
    new-instance v3, Landroid/animation/AnimatorSet;

    invoke-direct {v3}, Landroid/animation/AnimatorSet;-><init>()V

    .line 186
    iget-object v4, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    const-string v5, "translationY"

    new-array v6, v8, [F

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v7}, Landroid/view/ViewGroup;->getHeight()I

    move-result v7

    neg-int v7, v7

    int-to-float v7, v7

    aput v7, v6, v2

    const/4 v7, 0x0

    aput v7, v6, v1

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    .line 188
    iget-object v5, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    const-string v6, "alpha"

    new-array v7, v8, [F

    fill-array-data v7, :array_0

    invoke-static {v5, v6, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v5

    .line 189
    new-array v6, v8, [Landroid/animation/Animator;

    aput-object v4, v6, v2

    aput-object v5, v6, v1

    invoke-virtual {v3, v6}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 190
    iget-wide v4, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->i:J

    invoke-virtual {v3, v4, v5}, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;

    .line 191
    invoke-virtual {v3}, Landroid/animation/AnimatorSet;->start()V

    .line 194
    :cond_0
    return v0

    :cond_1
    move v0, v2

    .line 181
    goto :goto_0

    .line 188
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public final f()Z
    .locals 9

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v8, 0x2

    .line 199
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_1

    move v2, v3

    .line 201
    :goto_0
    if-eqz v2, :cond_0

    .line 203
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getAlpha()F

    move-result v0

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_2

    .line 205
    new-instance v1, Landroid/animation/AnimatorSet;

    invoke-direct {v1}, Landroid/animation/AnimatorSet;-><init>()V

    .line 206
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    const-string v5, "translationY"

    new-array v6, v8, [F

    const/4 v7, 0x0

    aput v7, v6, v4

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->b:Landroid/view/ViewGroup;

    invoke-virtual {v7}, Landroid/view/ViewGroup;->getHeight()I

    move-result v7

    neg-int v7, v7

    int-to-float v7, v7

    aput v7, v6, v3

    invoke-static {v0, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v5

    .line 208
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    const-string v6, "alpha"

    new-array v7, v8, [F

    fill-array-data v7, :array_0

    invoke-static {v0, v6, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v6

    move-object v0, v1

    .line 209
    check-cast v0, Landroid/animation/AnimatorSet;

    new-array v7, v8, [Landroid/animation/Animator;

    aput-object v5, v7, v4

    aput-object v6, v7, v3

    invoke-virtual {v0, v7}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 214
    :goto_1
    iget-wide v4, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->i:J

    invoke-virtual {v1, v4, v5}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 215
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/d;

    invoke-direct {v0, p0}, Luk/co/senab/actionbarpulltorefresh/library/d;-><init>(Luk/co/senab/actionbarpulltorefresh/library/c;)V

    invoke-virtual {v1, v0}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 216
    invoke-virtual {v1}, Landroid/animation/Animator;->start()V

    .line 219
    :cond_0
    return v2

    :cond_1
    move v2, v4

    .line 199
    goto :goto_0

    .line 212
    :cond_2
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/c;->a:Landroid/view/View;

    const-string v1, "alpha"

    new-array v3, v8, [F

    fill-array-data v3, :array_1

    invoke-static {v0, v1, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    goto :goto_1

    .line 208
    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data

    .line 212
    :array_1
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method
