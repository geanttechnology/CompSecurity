.class public Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "NoResultsSetEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;


# instance fields
.field private fallbackResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation
.end field

.field private label:Ljava/lang/String;

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
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getFallbackResults()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->fallbackResults:Ljava/util/List;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->label:Ljava/lang/String;

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
    .line 50
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->styledText:Ljava/util/List;

    return-object v0
.end method

.method public setFallbackResults(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "fallbackResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->fallbackResults:Ljava/util/List;

    .line 41
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->label:Ljava/lang/String;

    .line 81
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
    .line 60
    .local p1, "styledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;->styledText:Ljava/util/List;

    .line 61
    return-void
.end method
