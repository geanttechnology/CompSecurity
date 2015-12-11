.class public Lkk;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$PageTransformer;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;


# direct methods
.method private constructor <init>(Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lkk;->a:Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager$1;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lkk;-><init>(Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;)V

    return-void
.end method


# virtual methods
.method public transformPage(Landroid/view/View;F)V
    .locals 5

    .prologue
    const/high16 v4, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    .line 30
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    .line 31
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 33
    const/high16 v2, -0x40800000    # -1.0f

    cmpg-float v2, p2, v2

    if-gez v2, :cond_0

    .line 35
    invoke-virtual {p1, v3}, Landroid/view/View;->setAlpha(F)V

    .line 51
    :goto_0
    return-void

    .line 37
    :cond_0
    cmpg-float v2, p2, v4

    if-gtz v2, :cond_1

    .line 38
    invoke-virtual {p1, v4}, Landroid/view/View;->setAlpha(F)V

    .line 41
    int-to-float v0, v0

    neg-float v2, p2

    mul-float/2addr v0, v2

    invoke-virtual {p1, v0}, Landroid/view/View;->setTranslationX(F)V

    .line 44
    int-to-float v0, v1

    mul-float/2addr v0, p2

    .line 45
    invoke-virtual {p1, v0}, Landroid/view/View;->setTranslationY(F)V

    goto :goto_0

    .line 49
    :cond_1
    invoke-virtual {p1, v3}, Landroid/view/View;->setAlpha(F)V

    goto :goto_0
.end method
