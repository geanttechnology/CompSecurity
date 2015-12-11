.class public Lcom/bestbuy/android/api/lib/models/pdpoffers/PDPOffersParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/pdpoffers/SIOffers;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/pdpoffers/SIOffers;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/PDPOffersParent;->si:Lcom/bestbuy/android/api/lib/models/pdpoffers/SIOffers;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/pdpoffers/SIOffers;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/PDPOffersParent;->si:Lcom/bestbuy/android/api/lib/models/pdpoffers/SIOffers;

    .line 23
    return-void
.end method
