.class public Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "FKMREntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/FKMR;


# instance fields
.field private index:I

.field private keywords:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private message:Ljava/util/List;
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

.field private seeAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

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

.field private totalResults:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getIndex()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->index:I

    return v0
.end method

.method public getKeywords()Ljava/util/List;
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
    .line 103
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->keywords:Ljava/util/List;

    return-object v0
.end method

.method public getMessage()Ljava/util/List;
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
    .line 123
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->message:Ljava/util/List;

    return-object v0
.end method

.method public getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    return-object v0
.end method

.method public getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->seeAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

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
    .line 83
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->styledText:Ljava/util/List;

    return-object v0
.end method

.method public getTotalResults()J
    .locals 2

    .prologue
    .line 143
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->totalResults:J

    return-wide v0
.end method

.method public setIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->index:I

    .line 74
    return-void
.end method

.method public setKeywords(Ljava/util/List;)V
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
    .line 113
    .local p1, "keywords":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->keywords:Ljava/util/List;

    .line 114
    return-void
.end method

.method public setMessage(Ljava/util/List;)V
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
    .line 133
    .local p1, "message":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->message:Ljava/util/List;

    .line 134
    return-void
.end method

.method public setResults(Lcom/amazon/searchapp/retailsearch/model/ProductSection;)V
    .locals 0
    .param p1, "results"    # Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .line 174
    return-void
.end method

.method public setSeeAllLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "seeAllLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->seeAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 54
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
    .line 93
    .local p1, "styledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->styledText:Ljava/util/List;

    .line 94
    return-void
.end method

.method public setTotalResults(J)V
    .locals 0
    .param p1, "totalResults"    # J

    .prologue
    .line 153
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->totalResults:J

    .line 154
    return-void
.end method
