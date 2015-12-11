.class public Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
.super Landroid/widget/LinearLayout;
.source "MultiViewToggle.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/ViewSelector;
.implements Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;,
        Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;,
        Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
    }
.end annotation


# instance fields
.field private final buttons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;",
            ">;"
        }
    .end annotation
.end field

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
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    .line 38
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 43
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->init()V

    .line 44
    return-void
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method private init()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    .line 48
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->addUserPreferenceChangeListener(Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;)V

    .line 52
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    sget v3, Lcom/amazon/retailsearch/R$drawable;->list_view_option:I

    sget v4, Lcom/amazon/retailsearch/R$drawable;->list_view_option_selected:I

    sget v5, Lcom/amazon/retailsearch/R$string;->list_view_description:I

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;IIILcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 60
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    sget v3, Lcom/amazon/retailsearch/R$drawable;->grid_view_option:I

    sget v4, Lcom/amazon/retailsearch/R$drawable;->grid_view_option_selected:I

    sget v5, Lcom/amazon/retailsearch/R$string;->grid_view_description:I

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;IIILcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 68
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    sget v3, Lcom/amazon/retailsearch/R$drawable;->gallery_view_option:I

    sget v4, Lcom/amazon/retailsearch/R$drawable;->gallery_view_option_selected:I

    sget v5, Lcom/amazon/retailsearch/R$string;->image_view_description:I

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;IIILcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .line 78
    .local v7, "button":Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;
    invoke-static {v7}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$100(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 80
    .end local v7    # "button":Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
    :cond_0
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v1, v2}, Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;->displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    .line 86
    .local v0, "selected":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :goto_0
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 87
    return-void

    .line 85
    .end local v0    # "selected":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    goto :goto_0
.end method

.method public onViewTypeUpdated(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "newViewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 95
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 96
    return-void
.end method

.method public updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 5
    .param p1, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 104
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->buttons:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .line 106
    .local v0, "button":Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$200(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 108
    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$100(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->selectedImageId:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$300(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 112
    :cond_0
    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$100(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->imageId:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->access$400(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 115
    .end local v0    # "button":Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
    :cond_1
    return-void
.end method
