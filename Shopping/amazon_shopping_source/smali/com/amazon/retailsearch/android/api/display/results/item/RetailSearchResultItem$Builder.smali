.class public Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;
.super Ljava/lang/Object;
.source "RetailSearchResultItem.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    .locals 1
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "srdsDetailPageUrlPath"    # Ljava/lang/String;
    .param p3, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 110
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;->build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    move-result-object v0

    return-object v0
.end method

.method public build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    .locals 4
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "srdsDetailPageUrlPath"    # Ljava/lang/String;
    .param p3, "productGroup"    # Ljava/lang/String;
    .param p4, "editionsType"    # Ljava/lang/String;

    .prologue
    .line 91
    new-instance v1, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;-><init>()V

    .line 93
    .local v1, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    invoke-virtual {v1, p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setAsin(Ljava/lang/String;)V

    .line 95
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 98
    const-string/jumbo v2, ".*?/dp/"

    const-string/jumbo v3, ""

    invoke-virtual {p2, v2, v3}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 99
    .local v0, "detailPageUrlPath":Ljava/lang/String;
    # invokes: Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setDetailPageUrlPath(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->access$000(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Ljava/lang/String;)V

    .line 102
    .end local v0    # "detailPageUrlPath":Ljava/lang/String;
    :cond_0
    invoke-virtual {v1, p3}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setProductGroup(Ljava/lang/String;)V

    .line 103
    # invokes: Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setEditionsType(Ljava/lang/String;)V
    invoke-static {v1, p4}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->access$100(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Ljava/lang/String;)V

    .line 105
    return-object v1
.end method
