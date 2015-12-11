.class public Lcom/amazon/mShop/details/CustomizedGallery;
.super Landroid/widget/Gallery;
.source "CustomizedGallery.java"


# instance fields
.field private mAction:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

.field public mGalleryImageStatus:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Landroid/widget/Gallery;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mGalleryImageStatus:Ljava/util/Map;

    .line 34
    return-void
.end method

.method private isScrollingLeft(Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;

    .prologue
    .line 37
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private logImageStatusRefMarker(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "status"    # Ljava/lang/String;
    .param p2, "refmarker"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 97
    iget-object v2, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mGalleryImageStatus:Ljava/util/Map;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 98
    .local v1, "statusMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>;"
    if-eqz v1, :cond_2

    .line 99
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 100
    .local v0, "bool":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v2}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 101
    :cond_0
    invoke-static {p2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 102
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    .end local v0    # "bool":Ljava/lang/Boolean;
    :cond_1
    :goto_0
    return-void

    .line 105
    :cond_2
    invoke-static {p2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 106
    new-instance v1, Ljava/util/HashMap;

    .end local v1    # "statusMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>;"
    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 107
    .restart local v1    # "statusMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>;"
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    iget-object v2, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mGalleryImageStatus:Ljava/util/Map;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public getAction()Lcom/amazon/mShop/details/ProductImagesView$MoveAction;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mAction:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    return-object v0
.end method

.method public logImageViewedRefMarker()V
    .locals 5

    .prologue
    .line 80
    const-string/jumbo v0, "image_viewed"

    const-string/jumbo v1, "dp_img_%1$d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/details/CustomizedGallery;->logImageStatusRefMarker(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public logImageZoomedRefMarker()V
    .locals 5

    .prologue
    .line 86
    const-string/jumbo v0, "image_zoomed"

    const-string/jumbo v1, "dp_img_%1$d_z"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/details/CustomizedGallery;->logImageStatusRefMarker(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    return-void
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 2
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 43
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/CustomizedGallery;->isScrollingLeft(Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 45
    const/16 v0, 0x15

    .line 51
    .local v0, "kEvent":I
    :goto_0
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/details/CustomizedGallery;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 52
    const/4 v1, 0x1

    return v1

    .line 48
    .end local v0    # "kEvent":I
    :cond_0
    const/16 v0, 0x16

    .restart local v0    # "kEvent":I
    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 72
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    if-ne v1, v0, :cond_0

    .line 73
    invoke-super {p0, p1}, Landroid/widget/Gallery;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 75
    :cond_0
    return v0
.end method

.method public setAction(Lcom/amazon/mShop/details/ProductImagesView$MoveAction;)V
    .locals 0
    .param p1, "action"    # Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mAction:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    .line 29
    return-void
.end method

.method public setSelection(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v0

    if-le p1, v0, :cond_1

    .line 58
    sget-object v0, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->RIGHT:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    iput-object v0, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mAction:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    .line 61
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/Gallery;->setSelection(I)V

    .line 62
    return-void

    .line 59
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/details/CustomizedGallery;->getSelectedItemPosition()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 60
    sget-object v0, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->LEFT:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    iput-object v0, p0, Lcom/amazon/mShop/details/CustomizedGallery;->mAction:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    goto :goto_0
.end method
