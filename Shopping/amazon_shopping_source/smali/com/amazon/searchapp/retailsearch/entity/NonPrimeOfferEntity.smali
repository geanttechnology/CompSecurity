.class public Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "NonPrimeOfferEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;


# instance fields
.field private asin:Ljava/lang/String;

.field private label:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->label:Ljava/util/List;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->asin:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 80
    .local p1, "label":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->label:Ljava/util/List;

    .line 81
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 61
    return-void
.end method
