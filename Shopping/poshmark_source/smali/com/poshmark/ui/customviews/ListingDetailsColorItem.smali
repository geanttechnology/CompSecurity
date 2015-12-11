.class public Lcom/poshmark/ui/customviews/ListingDetailsColorItem;
.super Landroid/widget/LinearLayout;
.source "ListingDetailsColorItem.java"


# instance fields
.field category:Ljava/lang/String;

.field color:Lcom/poshmark/data_model/models/PMColor;

.field context:Landroid/content/Context;

.field screenNameForAnalytics:Ljava/lang/String;

.field searchTriggerType:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    const-string v0, "clr"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->searchTriggerType:Ljava/lang/String;

    .line 40
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->context:Landroid/content/Context;

    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setupListener()V

    .line 42
    return-void
.end method

.method private setupListener()V
    .locals 1

    .prologue
    .line 52
    new-instance v0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsColorItem;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 90
    return-void
.end method


# virtual methods
.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "catId"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->category:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setColor(Lcom/poshmark/data_model/models/PMColor;)V
    .locals 5
    .param p1, "color"    # Lcom/poshmark/data_model/models/PMColor;

    .prologue
    .line 93
    const v3, 0x7f0c00d4

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 94
    .local v0, "colorImage":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f020038

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/GradientDrawable;

    .line 95
    .local v1, "drawable":Landroid/graphics/drawable/GradientDrawable;
    iget-object v3, p1, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 96
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 98
    const v3, 0x7f0c00d5

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 99
    .local v2, "label":Landroid/widget/TextView;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PMColor;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->color:Lcom/poshmark/data_model/models/PMColor;

    .line 101
    return-void
.end method

.method public setParentScreenNameForAnalytics(Ljava/lang/String;)V
    .locals 0
    .param p1, "viewNameForAnalytics"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->screenNameForAnalytics:Ljava/lang/String;

    .line 50
    return-void
.end method
