.class public Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;
.super Lcom/amazon/mShop/search/viewit/FSEGraphic;
.source "TrackingDotsGraphic.java"


# static fields
.field private static mTrackingDotBitmap:Landroid/graphics/Bitmap;


# instance fields
.field private mPoints:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/graphics/PointF;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mTrackingDotBitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/PointF;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 18
    .local p2, "points":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/PointF;>;"
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSEGraphic;-><init>()V

    .line 19
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mPoints:Ljava/util/List;

    .line 20
    sget-object v0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mTrackingDotBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 21
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->view_it_tracker_dot:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mTrackingDotBitmap:Landroid/graphics/Bitmap;

    .line 23
    :cond_0
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Lcom/amazon/mShop/search/viewit/CameraPreview;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "preview"    # Lcom/amazon/mShop/search/viewit/CameraPreview;

    .prologue
    .line 37
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mPoints:Ljava/util/List;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mPoints:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x2

    if-ge v3, v4, :cond_1

    .line 46
    :cond_0
    return-void

    .line 42
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mPoints:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/PointF;

    .line 43
    .local v1, "point":Landroid/graphics/PointF;
    invoke-virtual {p2, v1}, Lcom/amazon/mShop/search/viewit/CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v2

    .line 44
    .local v2, "translatedPoint":Landroid/graphics/PointF;
    sget-object v3, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;->mTrackingDotBitmap:Landroid/graphics/Bitmap;

    iget v4, v2, Landroid/graphics/PointF;->x:F

    iget v5, v2, Landroid/graphics/PointF;->y:F

    const/4 v6, 0x0

    invoke-virtual {p1, v3, v4, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method public setCenterPoint(Landroid/graphics/PointF;)V
    .locals 0
    .param p1, "a_point"    # Landroid/graphics/PointF;

    .prologue
    .line 33
    return-void
.end method
