.class public Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "TrackingInfoEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;


# instance fields
.field private baseRH:Ljava/lang/String;

.field private browseLadder:Ljava/lang/String;

.field private csrfToken:Ljava/lang/String;

.field private isApplicationFailure:Z

.field private isUnsupportedRequest:Z

.field private node:Ljava/lang/String;

.field private pageApp:Ljava/lang/String;

.field private pageStructure:Ljava/lang/String;

.field private pageType:Ljava/lang/String;

.field private qid:Ljava/lang/String;

.field private redirectUrl:Ljava/lang/String;

.field private rid:Ljava/lang/String;

.field private searchAlias:Ljava/lang/String;

.field private searchAliasDisplayName:Ljava/lang/String;

.field private searchKeywords:Ljava/lang/String;

.field private searchSkeletonKey:Ljava/lang/String;

.field private store:Ljava/lang/String;

.field private subPageType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBaseRH()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->baseRH:Ljava/lang/String;

    return-object v0
.end method

.method public getBrowseLadder()Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->browseLadder:Ljava/lang/String;

    return-object v0
.end method

.method public getCsrfToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 372
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->csrfToken:Ljava/lang/String;

    return-object v0
.end method

.method public getIsApplicationFailure()Z
    .locals 1

    .prologue
    .line 272
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->isApplicationFailure:Z

    return v0
.end method

.method public getIsUnsupportedRequest()Z
    .locals 1

    .prologue
    .line 392
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->isUnsupportedRequest:Z

    return v0
.end method

.method public getNode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->node:Ljava/lang/String;

    return-object v0
.end method

.method public getPageApp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageApp:Ljava/lang/String;

    return-object v0
.end method

.method public getPageStructure()Ljava/lang/String;
    .locals 1

    .prologue
    .line 312
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageStructure:Ljava/lang/String;

    return-object v0
.end method

.method public getPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageType:Ljava/lang/String;

    return-object v0
.end method

.method public getQid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->qid:Ljava/lang/String;

    return-object v0
.end method

.method public getRedirectUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->redirectUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getRid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->rid:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchAlias:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAliasDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchAliasDisplayName:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchKeywords:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchSkeletonKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchSkeletonKey:Ljava/lang/String;

    return-object v0
.end method

.method public getStore()Ljava/lang/String;
    .locals 1

    .prologue
    .line 412
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->store:Ljava/lang/String;

    return-object v0
.end method

.method public getSubPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->subPageType:Ljava/lang/String;

    return-object v0
.end method

.method public setBaseRH(Ljava/lang/String;)V
    .locals 0
    .param p1, "baseRH"    # Ljava/lang/String;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->baseRH:Ljava/lang/String;

    .line 143
    return-void
.end method

.method public setBrowseLadder(Ljava/lang/String;)V
    .locals 0
    .param p1, "browseLadder"    # Ljava/lang/String;

    .prologue
    .line 302
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->browseLadder:Ljava/lang/String;

    .line 303
    return-void
.end method

.method public setCsrfToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "csrfToken"    # Ljava/lang/String;

    .prologue
    .line 382
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->csrfToken:Ljava/lang/String;

    .line 383
    return-void
.end method

.method public setIsApplicationFailure(Z)V
    .locals 0
    .param p1, "isApplicationFailure"    # Z

    .prologue
    .line 282
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->isApplicationFailure:Z

    .line 283
    return-void
.end method

.method public setIsUnsupportedRequest(Z)V
    .locals 0
    .param p1, "isUnsupportedRequest"    # Z

    .prologue
    .line 402
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->isUnsupportedRequest:Z

    .line 403
    return-void
.end method

.method public setNode(Ljava/lang/String;)V
    .locals 0
    .param p1, "node"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->node:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setPageApp(Ljava/lang/String;)V
    .locals 0
    .param p1, "pageApp"    # Ljava/lang/String;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageApp:Ljava/lang/String;

    .line 263
    return-void
.end method

.method public setPageStructure(Ljava/lang/String;)V
    .locals 0
    .param p1, "pageStructure"    # Ljava/lang/String;

    .prologue
    .line 322
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageStructure:Ljava/lang/String;

    .line 323
    return-void
.end method

.method public setPageType(Ljava/lang/String;)V
    .locals 0
    .param p1, "pageType"    # Ljava/lang/String;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->pageType:Ljava/lang/String;

    .line 223
    return-void
.end method

.method public setQid(Ljava/lang/String;)V
    .locals 0
    .param p1, "qid"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->qid:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setRedirectUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "redirectUrl"    # Ljava/lang/String;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->redirectUrl:Ljava/lang/String;

    .line 203
    return-void
.end method

.method public setRid(Ljava/lang/String;)V
    .locals 0
    .param p1, "rid"    # Ljava/lang/String;

    .prologue
    .line 242
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->rid:Ljava/lang/String;

    .line 243
    return-void
.end method

.method public setSearchAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchAlias"    # Ljava/lang/String;

    .prologue
    .line 362
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchAlias:Ljava/lang/String;

    .line 363
    return-void
.end method

.method public setSearchAliasDisplayName(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchAliasDisplayName"    # Ljava/lang/String;

    .prologue
    .line 342
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchAliasDisplayName:Ljava/lang/String;

    .line 343
    return-void
.end method

.method public setSearchKeywords(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchKeywords"    # Ljava/lang/String;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchKeywords:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setSearchSkeletonKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchSkeletonKey"    # Ljava/lang/String;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->searchSkeletonKey:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setStore(Ljava/lang/String;)V
    .locals 0
    .param p1, "store"    # Ljava/lang/String;

    .prologue
    .line 422
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->store:Ljava/lang/String;

    .line 423
    return-void
.end method

.method public setSubPageType(Ljava/lang/String;)V
    .locals 0
    .param p1, "subPageType"    # Ljava/lang/String;

    .prologue
    .line 182
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;->subPageType:Ljava/lang/String;

    .line 183
    return-void
.end method
