.class public Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ResultsMetadataEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;


# instance fields
.field private firstItem:J

.field private itemCount:J

.field private resultsLabel:Ljava/lang/String;

.field private totalResults:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getFirstItem()J
    .locals 2

    .prologue
    .line 90
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->firstItem:J

    return-wide v0
.end method

.method public getItemCount()J
    .locals 2

    .prologue
    .line 50
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->itemCount:J

    return-wide v0
.end method

.method public getResultsLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->resultsLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalResults()J
    .locals 2

    .prologue
    .line 70
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->totalResults:J

    return-wide v0
.end method

.method public setFirstItem(J)V
    .locals 0
    .param p1, "firstItem"    # J

    .prologue
    .line 100
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->firstItem:J

    .line 101
    return-void
.end method

.method public setItemCount(J)V
    .locals 0
    .param p1, "itemCount"    # J

    .prologue
    .line 60
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->itemCount:J

    .line 61
    return-void
.end method

.method public setResultsLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "resultsLabel"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->resultsLabel:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setTotalResults(J)V
    .locals 0
    .param p1, "totalResults"    # J

    .prologue
    .line 80
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;->totalResults:J

    .line 81
    return-void
.end method
