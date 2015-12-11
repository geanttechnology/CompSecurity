.class public Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;
.super Landroid/widget/TextView;
.source "BestSeller.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;",
        ">;"
    }
.end annotation


# instance fields
.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 42
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 43
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 3
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 51
    if-nez p1, :cond_0

    .line 53
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->setVisibility(I)V

    .line 70
    :goto_0
    return-void

    .line 57
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 60
    .local v0, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->getBadgeId()Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_BestSeller:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendBadge(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 63
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->getDepartmentLabel()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 65
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->getDepartmentLabel()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 68
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->setText(Ljava/lang/CharSequence;)V

    .line 69
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 29
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method
