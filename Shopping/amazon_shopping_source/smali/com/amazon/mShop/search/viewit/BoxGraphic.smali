.class public Lcom/amazon/mShop/search/viewit/BoxGraphic;
.super Lcom/amazon/mShop/search/viewit/FSEGraphic;
.source "BoxGraphic.java"


# static fields
.field private static mCheckMark:Landroid/graphics/Bitmap;


# instance fields
.field private mCenterPoint:Landroid/graphics/PointF;

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
    .line 18
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Landroid/graphics/PointF;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "centerPoint"    # Landroid/graphics/PointF;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/PointF;",
            ">;",
            "Landroid/graphics/PointF;",
            ")V"
        }
    .end annotation

    .prologue
    .line 22
    .local p2, "a_points":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/PointF;>;"
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSEGraphic;-><init>()V

    .line 23
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mPoints:Ljava/util/List;

    .line 24
    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCenterPoint:Landroid/graphics/PointF;

    .line 25
    sget-object v0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 26
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->checkmark:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    .line 28
    :cond_0
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Lcom/amazon/mShop/search/viewit/CameraPreview;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "a_preview"    # Lcom/amazon/mShop/search/viewit/CameraPreview;

    .prologue
    .line 45
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCenterPoint:Landroid/graphics/PointF;

    if-eqz v1, :cond_0

    .line 46
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCenterPoint:Landroid/graphics/PointF;

    invoke-virtual {p2, v1}, Lcom/amazon/mShop/search/viewit/CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    .line 47
    .local v0, "point":Landroid/graphics/PointF;
    sget-object v1, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    iget v2, v0, Landroid/graphics/PointF;->x:F

    sget-object v3, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v2, v3

    iget v3, v0, Landroid/graphics/PointF;->y:F

    sget-object v4, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCheckMark:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    sub-float/2addr v3, v4

    const/4 v4, 0x0

    invoke-virtual {p1, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 49
    .end local v0    # "point":Landroid/graphics/PointF;
    :cond_0
    return-void
.end method

.method public setCenterPoint(Landroid/graphics/PointF;)V
    .locals 0
    .param p1, "point"    # Landroid/graphics/PointF;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/BoxGraphic;->mCenterPoint:Landroid/graphics/PointF;

    .line 38
    return-void
.end method
