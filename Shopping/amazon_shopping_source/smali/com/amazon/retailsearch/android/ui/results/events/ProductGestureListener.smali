.class public Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "ProductGestureListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    }
.end annotation


# static fields
.field private static final MIN_TOUCH_TARGET_RADIUS:I = 0x18


# instance fields
.field private displayMetrics:Landroid/util/DisplayMetrics;

.field private resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

.field private tapTargets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;",
            ">;"
        }
    .end annotation
.end field

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/util/DisplayMetrics;)V
    .locals 1
    .param p1, "displayMetrics"    # Landroid/util/DisplayMetrics;

    .prologue
    .line 61
    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->tapTargets:Ljava/util/List;

    .line 62
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 63
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->displayMetrics:Landroid/util/DisplayMetrics;

    .line 64
    return-void
.end method

.method private eventInView(Landroid/view/MotionEvent;Landroid/view/View;I)Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    .locals 8
    .param p1, "event"    # Landroid/view/MotionEvent;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "minRadius"    # I

    .prologue
    const/high16 v7, 0x40000000    # 2.0f

    .line 187
    const/4 v6, 0x2

    new-array v5, v6, [I

    .line 188
    .local v5, "viewCoords":[I
    invoke-virtual {p2, v5}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 189
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    move-result v6

    int-to-float v6, v6

    div-float v3, v6, v7

    .line 190
    .local v3, "radiusX":F
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    move-result v6

    int-to-float v6, v6

    div-float v4, v6, v7

    .line 191
    .local v4, "radiusY":F
    int-to-float v6, p3

    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->displayMetrics:Landroid/util/DisplayMetrics;

    iget v7, v7, Landroid/util/DisplayMetrics;->density:F

    mul-float v2, v6, v7

    .line 194
    .local v2, "minRadiusPixels":F
    const/4 v6, 0x0

    aget v6, v5, v6

    int-to-float v6, v6

    add-float/2addr v6, v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v7

    sub-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v0

    .line 195
    .local v0, "distanceFromCenterX":F
    const/4 v6, 0x1

    aget v6, v5, v6

    int-to-float v6, v6

    add-float/2addr v6, v4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v7

    sub-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v1

    .line 196
    .local v1, "distanceFromCenterY":F
    cmpg-float v6, v0, v3

    if-gtz v6, :cond_0

    cmpg-float v6, v1, v4

    if-gtz v6, :cond_0

    .line 198
    sget-object v6, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->IN_VIEW:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    .line 204
    :goto_0
    return-object v6

    .line 200
    :cond_0
    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v6

    cmpg-float v6, v0, v6

    if-gtz v6, :cond_1

    invoke-static {v2, v4}, Ljava/lang/Math;->max(FF)F

    move-result v6

    cmpg-float v6, v1, v6

    if-gtz v6, :cond_1

    .line 202
    sget-object v6, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->WITHIN_PADDING:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    goto :goto_0

    .line 204
    :cond_1
    sget-object v6, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->MISS:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    goto :goto_0
.end method


# virtual methods
.method public addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V
    .locals 1
    .param p1, "resultView"    # Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;

    .prologue
    .line 97
    if-eqz p1, :cond_0

    .line 99
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->tapTargets:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    :cond_0
    return-void
.end method

.method public getTappedTarget(Landroid/view/MotionEvent;)Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    .locals 7
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 136
    const/4 v5, 0x0

    .line 138
    .local v5, "viewTappedInPadding":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    const/4 v0, 0x0

    .line 139
    .local v0, "countViewsTappedInPadding":I
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->tapTargets:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;

    .line 141
    .local v2, "resultView":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    invoke-interface {v2}, Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;->getView()Landroid/view/View;

    move-result-object v3

    .line 142
    .local v3, "view":Landroid/view/View;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v6

    if-nez v6, :cond_0

    .line 147
    const/16 v6, 0x18

    invoke-direct {p0, p1, v3, v6}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->eventInView(Landroid/view/MotionEvent;Landroid/view/View;I)Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    move-result-object v4

    .line 148
    .local v4, "viewTapLocation":Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    sget-object v6, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->IN_VIEW:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    if-ne v4, v6, :cond_1

    .line 171
    .end local v2    # "resultView":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    .end local v3    # "view":Landroid/view/View;
    .end local v4    # "viewTapLocation":Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    :goto_1
    return-object v2

    .line 153
    .restart local v2    # "resultView":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    .restart local v3    # "view":Landroid/view/View;
    .restart local v4    # "viewTapLocation":Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    :cond_1
    sget-object v6, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->WITHIN_PADDING:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    if-ne v4, v6, :cond_0

    .line 156
    if-nez v0, :cond_2

    .line 159
    move-object v5, v2

    .line 161
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 164
    .end local v2    # "resultView":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    .end local v3    # "view":Landroid/view/View;
    .end local v4    # "viewTapLocation":Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    :cond_3
    if-eqz v5, :cond_4

    const/4 v6, 0x1

    if-ne v0, v6, :cond_4

    move-object v2, v5

    .line 167
    goto :goto_1

    .line 171
    :cond_4
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 86
    const/4 v0, 0x1

    return v0
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->getTappedTarget(Landroid/view/MotionEvent;)Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;

    move-result-object v0

    .line 115
    .local v0, "resultView":Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;
    if-nez v0, :cond_0

    .line 118
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    sget-object v3, Lcom/amazon/retailsearch/metrics/DetailPageType;->MAIN:Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-interface {v1, v2, v3}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V

    .line 125
    :goto_0
    const/4 v1, 0x1

    return v1

    .line 123
    :cond_0
    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;->handleSingleTap()V

    goto :goto_0
.end method

.method public setResultItem(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 0
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .line 78
    return-void
.end method

.method public setUserInteractionListener(Lcom/amazon/retailsearch/interaction/UserInteractionListener;)V
    .locals 0
    .param p1, "userInteractionListener"    # Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    .line 73
    return-void
.end method
