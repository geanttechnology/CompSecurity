.class public Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "VariationEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Variation;


# instance fields
.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private type:Ljava/lang/String;


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
    .line 25
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 36
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;->type:Ljava/lang/String;

    .line 56
    return-void
.end method
