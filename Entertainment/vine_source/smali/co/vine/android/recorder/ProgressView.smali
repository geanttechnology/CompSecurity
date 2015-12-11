.class public Lco/vine/android/recorder/ProgressView;
.super Landroid/view/View;
.source "ProgressView.java"


# instance fields
.field protected final mPaint:Landroid/graphics/Paint;

.field public mProgressRatio:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 17
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    .line 18
    invoke-direct {p0}, Lco/vine/android/recorder/ProgressView;->init()V

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 23
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    .line 24
    invoke-direct {p0}, Lco/vine/android/recorder/ProgressView;->init()V

    .line 25
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    .line 30
    invoke-direct {p0}, Lco/vine/android/recorder/ProgressView;->init()V

    .line 31
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 34
    iget-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 35
    iget-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lco/vine/android/recorder/ProgressView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lco/vine/android/recorder/R$color;->vine_green:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 36
    return-void
.end method


# virtual methods
.method public setColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/ProgressView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 40
    return-void
.end method

.method public setProgressRatio(F)V
    .locals 2
    .param p1, "ratio"    # F

    .prologue
    const/high16 v0, 0x3f800000    # 1.0f

    .line 43
    cmpl-float v1, p1, v0

    if-lez v1, :cond_0

    move p1, v0

    .line 44
    :cond_0
    iput p1, p0, Lco/vine/android/recorder/ProgressView;->mProgressRatio:F

    .line 45
    new-instance v0, Lco/vine/android/recorder/ProgressView$1;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/ProgressView$1;-><init>(Lco/vine/android/recorder/ProgressView;)V

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/ProgressView;->post(Ljava/lang/Runnable;)Z

    .line 50
    return-void
.end method
