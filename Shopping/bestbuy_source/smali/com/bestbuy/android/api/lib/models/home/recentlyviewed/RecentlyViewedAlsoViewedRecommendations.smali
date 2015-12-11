.class public Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x25599878e9e12d36L


# instance fields
.field private skus:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;",
            ">;"
        }
    .end annotation
.end field

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSkus()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->skus:Ljava/util/List;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setSkus(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->skus:Ljava/util/List;

    .line 45
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->type:Ljava/lang/String;

    .line 39
    return-void
.end method
