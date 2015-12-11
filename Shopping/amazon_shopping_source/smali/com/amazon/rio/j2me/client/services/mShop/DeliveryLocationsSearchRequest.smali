.class public Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
.super Ljava/lang/Object;
.source "DeliveryLocationsSearchRequest.java"


# instance fields
.field private coordinates:Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

.field private page:Ljava/lang/Integer;

.field private query:Ljava/lang/String;

.field private radiusKm:Ljava/lang/String;

.field private size:Ljava/lang/Integer;

.field private state:Ljava/lang/String;

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCoordinates()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->coordinates:Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    return-object v0
.end method

.method public getPage()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->page:Ljava/lang/Integer;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getRadiusKm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->radiusKm:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->size:Ljava/lang/Integer;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 23
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->type:I

    return v0
.end method

.method public setCoordinates(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->coordinates:Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    .line 68
    return-void
.end method

.method public setPage(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->page:Ljava/lang/Integer;

    .line 94
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->query:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setSize(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->size:Ljava/lang/Integer;

    .line 107
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->state:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 28
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->type:I

    .line 29
    return-void
.end method
