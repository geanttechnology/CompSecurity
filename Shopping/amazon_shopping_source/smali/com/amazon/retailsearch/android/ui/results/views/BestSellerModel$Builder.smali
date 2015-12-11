.class public Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel$Builder;
.super Ljava/lang/Object;
.source "BestSellerModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/BestSeller;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    .locals 5
    .param p1, "bestSeller"    # Lcom/amazon/searchapp/retailsearch/model/BestSeller;
    .param p2, "res"    # Landroid/content/res/Resources;

    .prologue
    const/4 v2, 0x1

    .line 75
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/BestSeller;->getRank()I

    move-result v1

    if-ne v1, v2, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/BestSeller;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 77
    :cond_0
    const/4 v0, 0x0

    .line 88
    :cond_1
    :goto_0
    return-object v0

    .line 80
    :cond_2
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;-><init>()V

    .line 82
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/BestSeller;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->setBadgeId(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Ljava/lang/String;)V

    .line 83
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/BestSeller;->getNode()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 85
    sget v1, Lcom/amazon/retailsearch/R$string;->rs_results_best_seller_department:I

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/BestSeller;->getNode()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p2, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->setDepartmentLabel(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Ljava/lang/String;)V

    goto :goto_0
.end method
