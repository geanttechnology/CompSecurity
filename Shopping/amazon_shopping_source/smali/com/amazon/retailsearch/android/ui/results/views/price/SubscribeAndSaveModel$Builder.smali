.class public Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel$Builder;
.super Ljava/lang/Object;
.source "SubscribeAndSaveModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;ZLcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    .locals 3
    .param p1, "subscribeAndSavePrice"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .param p2, "showSaveMoreText"    # Z
    .param p3, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p4, "res"    # Landroid/content/res/Resources;

    .prologue
    const/4 v1, 0x0

    .line 93
    if-eqz p1, :cond_0

    if-eqz p3, :cond_0

    if-nez p4, :cond_2

    :cond_0
    move-object v0, v1

    .line 120
    :cond_1
    :goto_0
    return-object v0

    .line 98
    :cond_2
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;-><init>()V

    .line 101
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    move-object v0, v1

    .line 103
    goto :goto_0

    .line 105
    :cond_3
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setPrice(Ljava/lang/String;)V
    invoke-static {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V

    .line 108
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v2

    if-eqz v2, :cond_4

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_5

    :cond_4
    move-object v0, v1

    .line 110
    goto :goto_0

    .line 112
    :cond_5
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setPriceLabel(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V

    .line 115
    if-eqz p2, :cond_1

    .line 117
    sget v1, Lcom/amazon/retailsearch/R$string;->subscribe_and_save:I

    invoke-virtual {p4, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setSaveMoreText(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V

    goto :goto_0
.end method
