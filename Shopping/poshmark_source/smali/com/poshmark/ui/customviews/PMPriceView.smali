.class public Lcom/poshmark/ui/customviews/PMPriceView;
.super Landroid/view/View;
.source "PMPriceView.java"


# instance fields
.field listingPrice:Ljava/lang/String;

.field originalPrice:Ljava/lang/String;

.field paint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    const-string v0, "$2000"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceView;->originalPrice:Ljava/lang/String;

    .line 19
    const-string v0, "$3000"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceView;->listingPrice:Ljava/lang/String;

    .line 24
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceView;->paint:Landroid/graphics/Paint;

    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMPriceView;->initInternal()V

    .line 27
    return-void
.end method

.method private initInternal()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 38
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090040

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 39
    .local v1, "myColor":I
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 40
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceView;->getContext()Landroid/content/Context;

    move-result-object v2

    const/high16 v3, 0x41b00000    # 22.0f

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    .line 41
    .local v0, "fontSize":F
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 42
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 43
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setFlags(I)V

    .line 44
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 48
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 49
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    .line 52
    .local v0, "width":I
    return-void
.end method

.method public setListingPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "listingPrice"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMPriceView;->listingPrice:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setOriginalPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "originalPrice"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMPriceView;->originalPrice:Ljava/lang/String;

    .line 35
    return-void
.end method
