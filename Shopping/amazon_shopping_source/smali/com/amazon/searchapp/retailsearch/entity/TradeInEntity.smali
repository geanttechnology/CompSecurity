.class public Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "TradeInEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/TradeIn;


# instance fields
.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private price:Ljava/lang/String;

.field private resultLink:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getResultLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->resultLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 59
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->price:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setResultLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "resultLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;->resultLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 79
    return-void
.end method
