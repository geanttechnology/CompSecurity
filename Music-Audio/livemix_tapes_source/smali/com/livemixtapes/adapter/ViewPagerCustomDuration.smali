.class public Lcom/livemixtapes/adapter/ViewPagerCustomDuration;
.super Landroid/support/v4/view/ViewPager;
.source "ViewPagerCustomDuration.java"


# instance fields
.field private mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    .line 22
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    .line 14
    invoke-direct {p0}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->postInitViewPager()V

    .line 15
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    .line 19
    invoke-direct {p0}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->postInitViewPager()V

    .line 20
    return-void
.end method

.method private postInitViewPager()V
    .locals 5

    .prologue
    .line 30
    :try_start_0
    const-class v2, Landroid/support/v4/view/ViewPager;

    const-string v3, "mScroller"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 31
    .local v1, "scroller":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 32
    const-class v2, Landroid/support/v4/view/ViewPager;

    const-string v3, "sInterpolator"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 33
    .local v0, "interpolator":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 35
    new-instance v3, Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    invoke-virtual {p0}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->getContext()Landroid/content/Context;

    move-result-object v4

    .line 36
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/animation/Interpolator;

    invoke-direct {v3, v4, v2}, Lcom/livemixtapes/adapter/ScrollerCustomDuration;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    .line 35
    iput-object v3, p0, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    .line 37
    iget-object v2, p0, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    .end local v0    # "interpolator":Ljava/lang/reflect/Field;
    .end local v1    # "scroller":Ljava/lang/reflect/Field;
    :goto_0
    return-void

    .line 38
    :catch_0
    move-exception v2

    goto :goto_0
.end method


# virtual methods
.method public setScrollDurationFactor(D)V
    .locals 1
    .param p1, "scrollFactor"    # D

    .prologue
    .line 46
    iget-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->mScroller:Lcom/livemixtapes/adapter/ScrollerCustomDuration;

    invoke-virtual {v0, p1, p2}, Lcom/livemixtapes/adapter/ScrollerCustomDuration;->setScrollDurationFactor(D)V

    .line 47
    return-void
.end method
