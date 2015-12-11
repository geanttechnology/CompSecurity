.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel$Builder;
.super Ljava/lang/Object;
.source "TradeInModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/TradeIn;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    .locals 2
    .param p1, "tradeInInfo"    # Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    .prologue
    .line 52
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TradeIn;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TradeIn;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 55
    :cond_0
    const/4 v0, 0x0

    .line 61
    :goto_0
    return-object v0

    .line 58
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;-><init>()V

    .line 59
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TradeIn;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;->setTradeInMessage(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;Ljava/lang/String;)V

    goto :goto_0
.end method
