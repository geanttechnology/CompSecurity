.class public Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SpellCorrectedEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;


# instance fields
.field private correctedKeywords:Ljava/lang/String;

.field private detailedStyledText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

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
.method public getCorrectedKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->correctedKeywords:Ljava/lang/String;

    return-object v0
.end method

.method public getDetailedStyledText()Ljava/util/List;
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
    .line 117
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->detailedStyledText:Ljava/util/List;

    return-object v0
.end method

.method public getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    return-object v0
.end method

.method public getSeeMoreLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->seeMoreLink:Lcom/amazon/searchapp/retailsearch/model/Link;

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
    .line 77
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->styledText:Ljava/util/List;

    return-object v0
.end method

.method public setCorrectedKeywords(Ljava/lang/String;)V
    .locals 0
    .param p1, "correctedKeywords"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->correctedKeywords:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setDetailedStyledText(Ljava/util/List;)V
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
    .line 127
    .local p1, "detailedStyledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->detailedStyledText:Ljava/util/List;

    .line 128
    return-void
.end method

.method public setResults(Lcom/amazon/searchapp/retailsearch/model/ProductSection;)V
    .locals 0
    .param p1, "results"    # Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .line 108
    return-void
.end method

.method public setSeeMoreLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "seeMoreLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->seeMoreLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 68
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
    .line 87
    .local p1, "styledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;->styledText:Ljava/util/List;

    .line 88
    return-void
.end method
