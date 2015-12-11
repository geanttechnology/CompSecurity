.class public Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
.super Landroid/support/v4/widget/SwipeRefreshLayout;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# static fields
.field private static b:F


# instance fields
.field a:Landroid/view/ViewTreeObserver;

.field private c:I

.field private d:Lnd;

.field private e:Z

.field private f:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const v0, 0x3f19999a    # 0.6f

    sput v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->b:F

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0, p1, p2}, Landroid/support/v4/widget/SwipeRefreshLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    const/16 v0, 0x12c

    iput v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->c:I

    .line 31
    iput-boolean v1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->e:Z

    .line 32
    iput-boolean v1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->f:Z

    .line 37
    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->a:Landroid/view/ViewTreeObserver;

    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->a:Landroid/view/ViewTreeObserver;

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 39
    return-void
.end method


# virtual methods
.method public canChildScrollUp()Z
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->d:Lnd;

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->d:Lnd;

    invoke-interface {v0}, Lnd;->i()Z

    move-result v0

    .line 126
    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->canChildScrollUp()Z

    move-result v0

    goto :goto_0
.end method

.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 44
    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sget v2, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->b:F

    mul-float/2addr v0, v2

    iget v2, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->c:I

    int-to-float v2, v2

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 49
    :try_start_0
    const-class v1, Landroid/support/v4/widget/SwipeRefreshLayout;

    const-string v2, "mDistanceToTriggerSync"

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 50
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 51
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {v1, p0, v0}, Ljava/lang/reflect/Field;->setFloat(Ljava/lang/Object;F)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 59
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 60
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    .line 61
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 66
    :goto_1
    return-void

    .line 52
    :catch_0
    move-exception v0

    .line 53
    invoke-virtual {v0}, Ljava/lang/NoSuchFieldException;->printStackTrace()V

    goto :goto_0

    .line 54
    :catch_1
    move-exception v0

    .line 55
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 64
    :cond_0
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_1
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 94
    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getContext()Landroid/content/Context;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v1, :cond_3

    .line 95
    iget-boolean v1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->f:Z

    if-eqz v1, :cond_2

    .line 96
    iget-boolean v1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->e:Z

    if-eqz v1, :cond_1

    .line 97
    invoke-super {p0, p1}, Landroid/support/v4/widget/SwipeRefreshLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 110
    :cond_0
    :goto_0
    return v0

    .line 99
    :cond_1
    iput-boolean v0, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->e:Z

    goto :goto_0

    .line 103
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x43a50000    # 330.0f

    invoke-virtual {p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v2, v3}, Lnf;->a(FLandroid/content/Context;)F

    move-result v2

    cmpg-float v1, v1, v2

    if-gez v1, :cond_0

    .line 104
    invoke-super {p0, p1}, Landroid/support/v4/widget/SwipeRefreshLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 110
    :cond_3
    invoke-super {p0, p1}, Landroid/support/v4/widget/SwipeRefreshLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 131
    invoke-super {p0, p1}, Landroid/support/v4/widget/SwipeRefreshLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public requestDisallowInterceptTouchEvent(Z)V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0, p1}, Landroid/support/v4/widget/SwipeRefreshLayout;->requestDisallowInterceptTouchEvent(Z)V

    .line 80
    return-void
.end method

.method public setCanChildScrollUpCallback(Lnd;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->d:Lnd;

    .line 119
    return-void
.end method

.method public setFromMDotWebFragment(Z)V
    .locals 0

    .prologue
    .line 87
    iput-boolean p1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->f:Z

    .line 88
    return-void
.end method

.method public setPullDownEvent(Z)V
    .locals 0

    .prologue
    .line 83
    iput-boolean p1, p0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->e:Z

    .line 84
    return-void
.end method
