.class public Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel$Builder;
.super Ljava/lang/Object;
.source "ForcedPrimeModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .locals 2
    .param p1, "nonPrimeOffer"    # Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;
    .param p2, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 107
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 109
    :cond_0
    const/4 v0, 0x0

    .line 119
    :goto_0
    return-object v0

    .line 112
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;-><init>()V

    .line 113
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setLowerPriceMessage(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V

    .line 114
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getLabel()Ljava/util/List;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setPriceAndLabel(Ljava/util/List;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/util/List;)V

    .line 115
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getAsin()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setAsin(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V

    .line 116
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setUrl(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->access$300(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V

    .line 117
    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setProductGroup(Ljava/lang/String;)V
    invoke-static {v0, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->access$400(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V

    goto :goto_0
.end method
