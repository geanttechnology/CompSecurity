.class public Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "NewerVersionEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/NewerVersion;


# instance fields
.field private asin:Ljava/lang/String;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;->asin:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 56
    return-void
.end method
