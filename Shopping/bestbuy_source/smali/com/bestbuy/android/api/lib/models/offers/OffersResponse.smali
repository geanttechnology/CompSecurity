.class public Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private cursor:Ljava/lang/String;

.field private offers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;->offers:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public getCursor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;->cursor:Ljava/lang/String;

    return-object v0
.end method

.method public getOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;->offers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setCursor(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 19
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;->cursor:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public setOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/offers/OffersResponse;->offers:Ljava/util/ArrayList;

    .line 28
    return-void
.end method
