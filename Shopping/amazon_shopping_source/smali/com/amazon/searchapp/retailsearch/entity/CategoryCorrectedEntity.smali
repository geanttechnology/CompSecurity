.class public Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "CategoryCorrectedEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;


# instance fields
.field private keywords:Ljava/lang/String;

.field private results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

.field private seeMoreLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private styledText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    return-object v0
.end method

.method public getSeeMoreLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->seeMoreLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getStyledText()Ljava/util/List;
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
    .line 94
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->styledText:Ljava/util/List;

    return-object v0
.end method

.method public setKeywords(Ljava/lang/String;)V
    .locals 0
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->keywords:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setResults(Lcom/amazon/searchapp/retailsearch/model/ProductSection;)V
    .locals 0
    .param p1, "results"    # Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .line 85
    return-void
.end method

.method public setSeeMoreLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "seeMoreLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->seeMoreLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 65
    return-void
.end method

.method public setStyledText(Ljava/util/List;)V
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
    .line 104
    .local p1, "styledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;->styledText:Ljava/util/List;

    .line 105
    return-void
.end method
