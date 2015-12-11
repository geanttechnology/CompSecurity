.class public Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
.super Ljava/lang/Object;
.source "RatingsLineModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;
    }
.end annotation


# instance fields
.field private accessibilityText:Ljava/lang/String;

.field private reviewCountText:Ljava/lang/String;

.field private starsDrawable:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    .param p1, "x1"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setStarsDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setAccessibilityText(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setReviewCountText(Ljava/lang/String;)V

    return-void
.end method

.method private setAccessibilityText(Ljava/lang/String;)V
    .locals 0
    .param p1, "accessibilityText"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->accessibilityText:Ljava/lang/String;

    .line 84
    return-void
.end method

.method private setReviewCountText(Ljava/lang/String;)V
    .locals 0
    .param p1, "reviewCountText"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->reviewCountText:Ljava/lang/String;

    .line 39
    return-void
.end method

.method private setStarsDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "starsDrawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->starsDrawable:Landroid/graphics/drawable/Drawable;

    .line 66
    return-void
.end method


# virtual methods
.method public getAccessibilityText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->accessibilityText:Ljava/lang/String;

    return-object v0
.end method

.method public getReviewCountText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->reviewCountText:Ljava/lang/String;

    return-object v0
.end method

.method public getStarsDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->starsDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method
