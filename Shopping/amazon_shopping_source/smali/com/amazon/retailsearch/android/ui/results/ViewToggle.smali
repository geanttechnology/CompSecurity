.class public Lcom/amazon/retailsearch/android/ui/results/ViewToggle;
.super Landroid/widget/ImageView;
.source "ViewToggle.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/ViewSelector;
.implements Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/ViewToggle$1;,
        Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;
    }
.end annotation


# instance fields
.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 37
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->init()V

    .line 38
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/ViewToggle;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method private init()V
    .locals 3

    .prologue
    .line 42
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 44
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$dimen;->padding_b:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 45
    .local v0, "padding":I
    invoke-virtual {p0, v0, v0, v0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setPadding(IIII)V

    .line 48
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1, p0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->addUserPreferenceChangeListener(Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;)V

    .line 49
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewToggle$1;)V

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 50
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v1, v2}, Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;->displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    .line 56
    .local v0, "selected":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :goto_0
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 57
    return-void

    .line 55
    .end local v0    # "selected":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    goto :goto_0
.end method

.method public onViewTypeUpdated(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "newViewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 90
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 91
    return-void
.end method

.method public updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 62
    if-nez p1, :cond_0

    .line 64
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setVisibility(I)V

    .line 85
    :goto_0
    return-void

    .line 68
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setVisibility(I)V

    .line 70
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne p1, v0, :cond_1

    .line 72
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->grid_view_option:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 73
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->grid_view_description:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 75
    :cond_1
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne p1, v0, :cond_2

    .line 77
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->gallery_view_option:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 78
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->image_view_description:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 82
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->list_view_option:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 83
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->list_view_description:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
