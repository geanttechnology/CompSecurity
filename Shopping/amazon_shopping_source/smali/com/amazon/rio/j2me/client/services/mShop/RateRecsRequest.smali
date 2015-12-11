.class public Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;
.super Ljava/lang/Object;
.source "RateRecsRequest.java"


# instance fields
.field private additions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;"
        }
    .end annotation
.end field

.field private deletions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAdditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;->additions:Ljava/util/List;

    return-object v0
.end method

.method public getDeletions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;->deletions:Ljava/util/List;

    return-object v0
.end method

.method public setAdditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;->additions:Ljava/util/List;

    .line 40
    return-void
.end method
