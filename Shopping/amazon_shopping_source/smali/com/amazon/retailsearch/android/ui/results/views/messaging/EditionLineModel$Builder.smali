.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel$Builder;
.super Ljava/lang/Object;
.source "EditionLineModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
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
.method public build(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;ZLjava/lang/String;Z)Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    .locals 2
    .param p1, "mainPrice"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .param p2, "useEditionsPricing"    # Z
    .param p3, "typeName"    # Ljava/lang/String;
    .param p4, "isSponsoredPrice"    # Z

    .prologue
    .line 55
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;-><init>()V

    .line 57
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    if-eqz p2, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 60
    invoke-virtual {v0, p3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->setEditionText(Ljava/lang/String;)V

    .line 72
    .end local v0    # "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    :goto_0
    return-object v0

    .line 64
    .restart local v0    # "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    :cond_0
    if-nez p2, :cond_1

    if-nez p4, :cond_1

    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 68
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->setEditionText(Ljava/lang/String;)V

    goto :goto_0

    .line 72
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
