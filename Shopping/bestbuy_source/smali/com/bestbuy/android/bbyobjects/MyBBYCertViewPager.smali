.class public Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;
.super Landroid/support/v4/view/ViewPager;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    .line 13
    invoke-direct {p0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;->a()V

    .line 14
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    invoke-direct {p0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;->a()V

    .line 19
    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 22
    const/4 v0, 0x1

    new-instance v1, Lkk;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lkk;-><init>(Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager$1;)V

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;->setPageTransformer(ZLandroid/support/v4/view/ViewPager$PageTransformer;)V

    .line 23
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertViewPager;->setOverScrollMode(I)V

    .line 24
    return-void
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 60
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/view/MotionEvent;->setLocation(FF)V

    .line 62
    invoke-super {p0, p1}, Landroid/support/v4/view/ViewPager;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
