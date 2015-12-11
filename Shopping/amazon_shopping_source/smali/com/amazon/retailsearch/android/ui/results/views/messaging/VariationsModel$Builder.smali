.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel$Builder;
.super Ljava/lang/Object;
.source "VariationsModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Ljava/util/List;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Variation;",
            ">;)",
            "Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;"
        }
    .end annotation

    .prologue
    .local p1, "variations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Variation;>;"
    const/4 v0, 0x0

    .line 54
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 67
    :cond_0
    :goto_0
    return-object v0

    .line 58
    :cond_1
    const/4 v2, 0x0

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Variation;

    .line 59
    .local v1, "variation":Lcom/amazon/searchapp/retailsearch/model/Variation;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Variation;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Variation;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 64
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;-><init>()V

    .line 65
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Variation;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->setVariationsMessage(Ljava/lang/String;)V
    invoke-static {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;Ljava/lang/String;)V

    goto :goto_0
.end method
