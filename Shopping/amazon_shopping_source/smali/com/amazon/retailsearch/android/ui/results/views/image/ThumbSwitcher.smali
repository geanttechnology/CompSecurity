.class public Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
.super Landroid/widget/LinearLayout;
.source "ThumbSwitcher.java"


# static fields
.field private static final DELAY:I = 0x12c

.field private static final MAX_IMAGES:I = 0x5

.field private static final MAX_LOAD_TIME:I = 0xea60

.field private static final STATES:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final activeDot:Landroid/graphics/drawable/Drawable;

.field asin:Ljava/lang/String;

.field private final context:Landroid/content/Context;

.field private final density:F

.field private displayedImageResource:Lcom/amazon/ansel/fetch/ImageRequest;

.field private final highDot:Landroid/graphics/drawable/Drawable;

.field private imageResources:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;"
        }
    .end annotation
.end field

.field private imageSubscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;>;"
        }
    .end annotation
.end field

.field private imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

.field private final inactiveDot:Landroid/graphics/drawable/Drawable;

.field private loadStartTime:J

.field private loadedImage:Z

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private position:I

.field private productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

.field private progressEnabled:Z

.field private progressRunning:Z

.field private resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->STATES:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageSubscribers:Ljava/util/List;

    .line 62
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->context:Landroid/content/Context;

    .line 63
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->active_dot:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->activeDot:Landroid/graphics/drawable/Drawable;

    .line 64
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->inactive_dot:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->inactiveDot:Landroid/graphics/drawable/Drawable;

    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->highlighted_dot:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->highDot:Landroid/graphics/drawable/Drawable;

    .line 66
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->density:F

    .line 67
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 68
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageSubscribers:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadedImage:Z

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadedImage:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # I

    .prologue
    .line 27
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I

    return p1
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Lcom/amazon/ansel/fetch/ImageRequest;)Lcom/amazon/ansel/fetch/ImageRequest;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # Lcom/amazon/ansel/fetch/ImageRequest;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->displayedImageResource:Lcom/amazon/ansel/fetch/ImageRequest;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPagerPosition(I)V

    return-void
.end method

.method static synthetic access$702(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressEnabled:Z

    return p1
.end method

.method static synthetic access$802(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z

    return p1
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->showProgress()V

    return-void
.end method

.method private setPagerPosition(I)V
    .locals 9
    .param p1, "pos"    # I

    .prologue
    const/4 v8, 0x0

    const/4 v7, -0x2

    .line 239
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getCount()I

    move-result v0

    .line 241
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildCount()I

    move-result v5

    if-ge v1, v5, :cond_1

    .line 243
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    if-nez v1, :cond_0

    const/4 v5, 0x4

    :goto_1
    invoke-virtual {v6, v5}, Landroid/view/View;->setVisibility(I)V

    .line 241
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 243
    :cond_0
    const/16 v5, 0x8

    goto :goto_1

    .line 246
    :cond_1
    const/4 v5, 0x1

    if-gt v0, v5, :cond_2

    .line 279
    :goto_2
    return-void

    .line 251
    :cond_2
    const/4 v5, 0x5

    invoke-static {v0, v5}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 253
    .local v3, "n":I
    const/4 v1, 0x0

    :goto_3
    if-ge v1, v3, :cond_6

    .line 255
    const/4 v4, 0x0

    .line 257
    .local v4, "view":Landroid/widget/ImageView;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildCount()I

    move-result v5

    if-ge v1, v5, :cond_3

    .line 259
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "view":Landroid/widget/ImageView;
    check-cast v4, Landroid/widget/ImageView;

    .line 260
    .restart local v4    # "view":Landroid/widget/ImageView;
    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 275
    :goto_4
    if-ne p1, v1, :cond_5

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->activeDot:Landroid/graphics/drawable/Drawable;

    :goto_5
    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 253
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 262
    :cond_3
    new-instance v4, Landroid/widget/ImageView;

    .end local v4    # "view":Landroid/widget/ImageView;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->context:Landroid/content/Context;

    invoke-direct {v4, v5}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 263
    .restart local v4    # "view":Landroid/widget/ImageView;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v7, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 265
    .local v2, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v5, 0x10

    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->gravity:I

    .line 267
    if-lez v1, :cond_4

    .line 269
    const/high16 v5, 0x40000000    # 2.0f

    iget v6, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->density:F

    mul-float/2addr v5, v6

    const/high16 v6, 0x3f000000    # 0.5f

    add-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    .line 272
    :cond_4
    invoke-virtual {p0, v4, v2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_4

    .line 275
    .end local v2    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    :cond_5
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->inactiveDot:Landroid/graphics/drawable/Drawable;

    goto :goto_5

    .line 278
    .end local v4    # "view":Landroid/widget/ImageView;
    :cond_6
    invoke-virtual {p0, v8}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setVisibility(I)V

    goto :goto_2
.end method

.method private showProgress()V
    .locals 9

    .prologue
    const/4 v4, 0x0

    .line 283
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z

    if-eqz v3, :cond_0

    .line 334
    :goto_0
    return-void

    .line 288
    :cond_0
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressEnabled:Z

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildCount()I

    move-result v3

    if-eqz v3, :cond_1

    iget-wide v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadStartTime:J

    const-wide/16 v7, 0x0

    cmp-long v3, v5, v7

    if-eqz v3, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-wide v7, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadStartTime:J

    sub-long/2addr v5, v7

    const-wide/32 v7, 0xea60

    cmp-long v3, v5, v7

    if-lez v3, :cond_2

    .line 292
    :cond_1
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z

    goto :goto_0

    .line 296
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getDisplayedImage()I

    move-result v3

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v5

    if-eq v3, v5, :cond_3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v3

    const/4 v5, -0x1

    if-ne v3, v5, :cond_4

    .line 300
    :cond_3
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z

    goto :goto_0

    .line 304
    :cond_4
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z

    .line 305
    const/4 v2, -0x1

    .line 307
    .local v2, "idx":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildCount()I

    move-result v3

    if-ge v1, v3, :cond_5

    .line 309
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 311
    .local v0, "child":Landroid/widget/ImageView;
    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v3

    if-nez v3, :cond_7

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->highDot:Landroid/graphics/drawable/Drawable;

    if-ne v3, v5, :cond_7

    .line 313
    move v2, v1

    .line 318
    .end local v0    # "child":Landroid/widget/ImageView;
    :cond_5
    if-ltz v2, :cond_6

    .line 320
    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->inactiveDot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 323
    :cond_6
    add-int/lit8 v3, v2, 0x1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildCount()I

    move-result v5

    if-ge v3, v5, :cond_8

    add-int/lit8 v3, v2, 0x1

    :goto_2
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->highDot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 325
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v4, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V

    const-wide/16 v5, 0x12c

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;J)V

    goto/16 :goto_0

    .line 307
    .restart local v0    # "child":Landroid/widget/ImageView;
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .end local v0    # "child":Landroid/widget/ImageView;
    :cond_8
    move v3, v4

    .line 323
    goto :goto_2
.end method


# virtual methods
.method public buildView(Ljava/lang/String;Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;Ljava/util/List;Lcom/amazon/ansel/fetch/ResourceProvider;)V
    .locals 7
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "imageWrapper"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
    .param p4, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;",
            "Lcom/amazon/ansel/fetch/ResourceProvider;",
            ")V"
        }
    .end annotation

    .prologue
    .local p3, "imageResources":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/ImageRequest;>;"
    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 79
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->asin:Ljava/lang/String;

    .line 80
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    .line 81
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageResources:Ljava/util/List;

    .line 82
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 84
    iput v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I

    .line 85
    iput-boolean v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadedImage:Z

    .line 86
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageSubscribers:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 87
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadStartTime:J

    .line 88
    iput-boolean v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressEnabled:Z

    .line 90
    const/4 v1, 0x0

    .line 91
    .local v1, "pos":I
    sget-object v3, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->STATES:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    iput-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    .line 93
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getDisplayedImage()I

    move-result v3

    if-eq v3, v6, :cond_0

    .line 95
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getDisplayedImage()I

    move-result v1

    .line 98
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getCount()I

    move-result v0

    .line 99
    .local v0, "count":I
    if-ltz v1, :cond_5

    if-ge v1, v0, :cond_5

    invoke-interface {p3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/ansel/fetch/ImageRequest;

    move-object v2, v3

    .line 101
    .local v2, "res":Lcom/amazon/ansel/fetch/ImageRequest;
    :goto_0
    if-eqz v2, :cond_1

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->displayedImageResource:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-virtual {v2, v3}, Lcom/amazon/ansel/fetch/ImageRequest;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 103
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 106
    :cond_2
    if-eqz v2, :cond_3

    .line 108
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I

    .line 109
    const/4 v3, 0x1

    invoke-virtual {p0, v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPosition(IZ)V

    .line 112
    :cond_3
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getDisplayedImage()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v4

    if-eq v3, v4, :cond_4

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v3

    if-eq v3, v6, :cond_4

    .line 116
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v3

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPosition(I)V

    .line 118
    :cond_4
    return-void

    .line 99
    .end local v2    # "res":Lcom/amazon/ansel/fetch/ImageRequest;
    :cond_5
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageResources:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageResources:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 127
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I

    return v0
.end method

.method public normalizePosition(I)I
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 232
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getCount()I

    move-result v0

    .line 233
    .local v0, "count":I
    rem-int/2addr p1, v0

    .line 234
    if-ltz p1, :cond_0

    .end local p1    # "pos":I
    :goto_0
    return p1

    .restart local p1    # "pos":I
    :cond_0
    add-int/2addr p1, v0

    goto :goto_0
.end method

.method public setPosition(I)V
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 227
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPosition(IZ)V

    .line 228
    return-void
.end method

.method public setPosition(IZ)V
    .locals 8
    .param p1, "imagePosition"    # I
    .param p2, "initialView"    # Z

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->getCount()I

    move-result v6

    .line 134
    .local v6, "count":I
    if-nez v6, :cond_1

    .line 136
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 140
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadStartTime:J

    .line 142
    if-nez p2, :cond_2

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    if-nez v1, :cond_2

    .line 144
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;-><init>()V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    .line 145
    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->STATES:Ljava/util/HashMap;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->asin:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    :cond_2
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->normalizePosition(I)I

    move-result v7

    .line 150
    .local v7, "pos":I
    if-nez p2, :cond_3

    .line 152
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    invoke-virtual {v1, v7}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->setRequestedImage(I)V

    .line 155
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageResources:Ljava/util/List;

    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/ansel/fetch/ImageRequest;

    .line 157
    .local v5, "imageResource":Lcom/amazon/ansel/fetch/ImageRequest;
    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;

    invoke-direct {v2, p0, p2, v7, v5}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;ZILcom/amazon/ansel/fetch/ImageRequest;)V

    .line 207
    .local v2, "sub":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageSubscribers:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 209
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/ResourceListener;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 216
    .local v0, "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1, v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    .line 218
    if-nez p2, :cond_0

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I

    if-eq v1, v7, :cond_0

    .line 220
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressEnabled:Z

    .line 221
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->showProgress()V

    goto :goto_0
.end method
