.class public Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
.super Ljava/lang/Object;
.source "RetailSearchResultItem.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;
    }
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field private detailPageUrlPath:Ljava/lang/String;

.field private editionsType:Ljava/lang/String;

.field private productGroup:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setDetailPageUrlPath(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->setEditionsType(Ljava/lang/String;)V

    return-void
.end method

.method private setDetailPageUrlPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailPageUrlPath"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->detailPageUrlPath:Ljava/lang/String;

    .line 51
    return-void
.end method

.method private setEditionsType(Ljava/lang/String;)V
    .locals 0
    .param p1, "editionsType"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->editionsType:Ljava/lang/String;

    .line 80
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getDetailPageUrlPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->detailPageUrlPath:Ljava/lang/String;

    return-object v0
.end method

.method public getEditionsType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->editionsType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->productGroup:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->asin:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setProductGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->productGroup:Ljava/lang/String;

    .line 70
    return-void
.end method
