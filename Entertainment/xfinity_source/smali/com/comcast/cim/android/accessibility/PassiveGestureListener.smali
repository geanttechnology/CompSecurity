.class public Lcom/comcast/cim/android/accessibility/PassiveGestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "PassiveGestureListener.java"


# instance fields
.field passiveStateChangeListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 20
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    .line 23
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 24
    return-void
.end method

.method public constructor <init>(Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p1, "passiveStateChangeListeners":Ljava/util/Set;, "Ljava/util/Set<Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;>;"
    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 20
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    .line 27
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    .line 28
    return-void
.end method

.method public static isDownInRange(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Z
    .locals 11
    .param p0, "event"    # Landroid/view/MotionEvent;
    .param p1, "displayMetrics"    # Landroid/util/DisplayMetrics;

    .prologue
    const/4 v10, 0x0

    const-wide v8, 0x3fe51eb851eb851fL    # 0.66

    const-wide v6, 0x3fd51eb851eb851fL    # 0.33

    const-wide v4, 0x3fb999999999999aL    # 0.1

    .line 50
    .line 51
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    cmpl-float v0, v0, v10

    if-lez v0, :cond_0

    .line 52
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v4

    double-to-int v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    .line 53
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v6

    double-to-int v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 54
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v8

    double-to-int v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-ltz v0, :cond_1

    .line 56
    :cond_0
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    cmpl-float v0, v0, v10

    if-lez v0, :cond_2

    .line 57
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v4

    double-to-int v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_2

    .line 58
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v6

    double-to-int v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_2

    .line 59
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-double v2, v1

    mul-double/2addr v2, v8

    double-to-int v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 4
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 33
    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const v2, 0x451c4000    # 2500.0f

    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    .line 34
    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const v2, -0x3ae3c000    # -2500.0f

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 36
    iget-object v2, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    monitor-enter v2

    .line 38
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->passiveStateChangeListeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;

    .line 39
    .local v0, "listener":Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;
    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;->onSpeechSwipe()V

    goto :goto_0

    .line 41
    .end local v0    # "listener":Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 42
    const/4 v1, 0x1

    .line 45
    :goto_1
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method
