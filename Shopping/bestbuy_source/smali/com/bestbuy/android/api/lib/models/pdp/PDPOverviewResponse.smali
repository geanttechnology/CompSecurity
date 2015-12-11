.class public Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

.field private overview:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    return-object v0
.end method

.method public getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->overview:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method public setDistilledReviewSummary(Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    .line 23
    return-void
.end method

.method public setOverview(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->overview:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 31
    return-void
.end method
