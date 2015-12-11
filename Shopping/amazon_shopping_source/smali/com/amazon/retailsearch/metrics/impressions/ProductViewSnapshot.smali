.class public Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;
.super Ljava/lang/Object;
.source "ProductViewSnapshot.java"


# instance fields
.field private final asin:Ljava/lang/String;

.field private final percentVisible:F

.field private final timestamp:J


# direct methods
.method public constructor <init>(Ljava/lang/String;FJ)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "percentVisible"    # F
    .param p3, "timestamp"    # J

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->asin:Ljava/lang/String;

    .line 22
    iput p2, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->percentVisible:F

    .line 23
    iput-wide p3, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->timestamp:J

    .line 24
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getPercentVisible()F
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->percentVisible:F

    return v0
.end method

.method public getTimestamp()J
    .locals 2

    .prologue
    .line 38
    iget-wide v0, p0, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->timestamp:J

    return-wide v0
.end method
