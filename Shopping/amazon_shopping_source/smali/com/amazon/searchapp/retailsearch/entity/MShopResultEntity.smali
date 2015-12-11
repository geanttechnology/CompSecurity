.class public Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "MShopResultEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/MShopResult;


# instance fields
.field private browserUrl:Ljava/lang/String;

.field private notice:Ljava/lang/String;

.field private showResultSummary:Z

.field private viewType:Ljava/lang/String;

.field private webViewUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBrowserUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->browserUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getNotice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->notice:Ljava/lang/String;

    return-object v0
.end method

.method public getShowResultSummary()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->showResultSummary:Z

    return v0
.end method

.method public getViewType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->viewType:Ljava/lang/String;

    return-object v0
.end method

.method public getWebViewUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->webViewUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setBrowserUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "browserUrl"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->browserUrl:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setNotice(Ljava/lang/String;)V
    .locals 0
    .param p1, "notice"    # Ljava/lang/String;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->notice:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setShowResultSummary(Z)V
    .locals 0
    .param p1, "showResultSummary"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->showResultSummary:Z

    .line 124
    return-void
.end method

.method public setViewType(Ljava/lang/String;)V
    .locals 0
    .param p1, "viewType"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->viewType:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setWebViewUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "webViewUrl"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;->webViewUrl:Ljava/lang/String;

    .line 64
    return-void
.end method
