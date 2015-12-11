.class public Lcom/poshmark/ui/customviews/ListingStatusView;
.super Landroid/view/View;
.source "ListingStatusView.java"


# instance fields
.field private listingStatus:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

.field private paint:Landroid/graphics/Paint;

.field private statusBitmap:Landroid/graphics/Bitmap;

.field private statusBool:Z

.field private statusString:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 27
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 21
    iput-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 22
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    .line 23
    iput-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    .line 28
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->initInternal()V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 32
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    iput-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 22
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    .line 23
    iput-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->initInternal()V

    .line 34
    return-void
.end method

.method private initInternal()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 60
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 61
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getContext()Landroid/content/Context;

    move-result-object v1

    const/high16 v2, 0x41400000    # 12.0f

    invoke-static {v1, v2}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    .line 62
    .local v0, "fontSize":F
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 63
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v6}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 64
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    const/high16 v4, -0x40800000    # -1.0f

    const/high16 v5, -0x1000000

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Paint;->setShadowLayer(FFFI)V

    .line 65
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v6}, Landroid/graphics/Paint;->setFlags(I)V

    .line 66
    return-void
.end method


# virtual methods
.method public getSuggestedMinimumHeight()I
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    .line 81
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSuggestedMinimumWidth()I
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    .line 89
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v3, 0x0

    .line 94
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    if-nez v1, :cond_1

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 96
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v3, v3, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 98
    iget-boolean v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBool:Z

    if-eqz v1, :cond_2

    .line 99
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 102
    :goto_1
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 103
    .local v0, "size":Landroid/graphics/Rect;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 104
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    int-to-float v3, v3

    iget-object v4, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 101
    .end local v0    # "size":Landroid/graphics/Rect;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->paint:Landroid/graphics/Paint;

    const/high16 v2, -0x1000000

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_1
.end method

.method public onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v1, 0x0

    .line 70
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/ListingStatusView;->setMeasuredDimension(II)V

    .line 74
    :goto_0
    return-void

    .line 73
    :cond_0
    invoke-virtual {p0, v1, v1}, Lcom/poshmark/ui/customviews/ListingStatusView;->setMeasuredDimension(II)V

    goto :goto_0
.end method

.method public setListingStatus(Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;)V
    .locals 4
    .param p1, "lStatus"    # Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 37
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->listingStatus:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 38
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->listingStatus:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v0, v1, :cond_0

    .line 39
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02013a

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 40
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f06022b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    .line 41
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBool:Z

    .line 55
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->requestLayout()V

    .line 56
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->invalidate()V

    .line 57
    return-void

    .line 42
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->listingStatus:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v0, v1, :cond_1

    .line 43
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02013c

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 44
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060285

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    .line 45
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBool:Z

    goto :goto_0

    .line 46
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->listingStatus:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->NOT_FOR_SALE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v0, v1, :cond_2

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02012b

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 48
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingStatusView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0601d4

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBool:Z

    goto :goto_0

    .line 51
    :cond_2
    iput-object v3, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusBitmap:Landroid/graphics/Bitmap;

    .line 52
    iput-object v3, p0, Lcom/poshmark/ui/customviews/ListingStatusView;->statusString:Ljava/lang/String;

    goto :goto_0
.end method
