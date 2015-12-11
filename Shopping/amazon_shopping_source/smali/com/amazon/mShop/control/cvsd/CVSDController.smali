.class public Lcom/amazon/mShop/control/cvsd/CVSDController;
.super Lcom/amazon/mShop/control/BaseController;
.source "CVSDController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;


# instance fields
.field private receivedMessage:Ljava/lang/String;

.field private receivedTypeVaule:I

.field private resultAddressList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;"
        }
    .end annotation
.end field

.field private subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 30
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;

    .line 36
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/cvsd/CVSDController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/cvsd/CVSDController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/cvsd/CVSDController;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;

    .prologue
    .line 19
    iget v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/cvsd/CVSDController;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    return-object v0
.end method

.method private reset()V
    .locals 1

    .prologue
    .line 202
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 204
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;

    .line 205
    return-void
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 127
    return-void
.end method

.method public cancel()V
    .locals 0

    .prologue
    .line 196
    invoke-direct {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->reset()V

    .line 198
    invoke-super {p0}, Lcom/amazon/mShop/control/BaseController;->cancel()V

    .line 199
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 132
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/cvsd/CVSDController$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/cvsd/CVSDController$1;-><init>(Lcom/amazon/mShop/control/cvsd/CVSDController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 169
    return-void
.end method

.method public getResultAddressList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;

    return-object v0
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->getSubscriber()Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    return-object v0
.end method

.method public receivedAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 175
    return-void
.end method

.method public receivedMessage(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;

    .line 181
    return-void
.end method

.method public receivedTotalCount(Ljava/lang/Integer;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Integer;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 186
    return-void
.end method

.method public receivedType(Ljava/lang/Integer;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/Integer;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 190
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I

    .line 192
    return-void
.end method

.method public searchDeliveryLoationByLandmark(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "landmark"    # Ljava/lang/String;
    .param p2, "state"    # Ljava/lang/String;
    .param p3, "taskcallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->cancel()V

    .line 108
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;-><init>()V

    .line 109
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setType(I)V

    .line 110
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setQuery(Ljava/lang/String;)V

    .line 111
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 112
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setState(Ljava/lang/String;)V

    .line 114
    :cond_0
    new-instance v1, Ljava/lang/Integer;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setPage(Ljava/lang/Integer;)V

    .line 115
    new-instance v1, Ljava/lang/Integer;

    const/16 v2, 0xa

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setSize(Ljava/lang/Integer;)V

    .line 116
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p3}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 117
    return-void
.end method

.method public searchDeliveryLocationByAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 4
    .param p1, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .param p2, "taskcallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->cancel()V

    .line 66
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;-><init>()V

    .line 67
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setType(I)V

    .line 68
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;-><init>()V

    .line 69
    .local v0, "coordinate":Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getLocation()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLatitude()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLatitude(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getLocation()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLongitude()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLongitude(Ljava/lang/String;)V

    .line 71
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setCoordinates(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;)V

    .line 72
    new-instance v2, Ljava/lang/Integer;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setPage(Ljava/lang/Integer;)V

    .line 73
    new-instance v2, Ljava/lang/Integer;

    const/16 v3, 0xa

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setSize(Ljava/lang/Integer;)V

    .line 74
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    invoke-virtual {p0, v2, p2}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 75
    return-void
.end method

.method public searchDeliveryLocationByAddress(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "state"    # Ljava/lang/String;
    .param p2, "address"    # Ljava/lang/String;
    .param p3, "taskcallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    const/4 v2, 0x1

    .line 79
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->cancel()V

    .line 81
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;-><init>()V

    .line 82
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setType(I)V

    .line 83
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 84
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setState(Ljava/lang/String;)V

    .line 86
    :cond_0
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setQuery(Ljava/lang/String;)V

    .line 87
    new-instance v1, Ljava/lang/Integer;

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setPage(Ljava/lang/Integer;)V

    .line 88
    new-instance v1, Ljava/lang/Integer;

    const/16 v2, 0xa

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setSize(Ljava/lang/Integer;)V

    .line 89
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p3}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 90
    return-void
.end method

.method public searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "lat"    # Ljava/lang/String;
    .param p2, "lon"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->cancel()V

    .line 50
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;-><init>()V

    .line 51
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setType(I)V

    .line 52
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;-><init>()V

    .line 53
    .local v0, "coordinate":Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLatitude(Ljava/lang/String;)V

    .line 54
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLongitude(Ljava/lang/String;)V

    .line 55
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setCoordinates(Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;)V

    .line 56
    new-instance v2, Ljava/lang/Integer;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setPage(Ljava/lang/Integer;)V

    .line 57
    new-instance v2, Ljava/lang/Integer;

    const/16 v3, 0xa

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setSize(Ljava/lang/Integer;)V

    .line 58
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 60
    return-void
.end method

.method public searchDeliveryLocationByZipcode(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "zipCode"    # Ljava/lang/String;
    .param p2, "taskcallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->cancel()V

    .line 96
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;-><init>()V

    .line 97
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setType(I)V

    .line 98
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setQuery(Ljava/lang/String;)V

    .line 99
    new-instance v1, Ljava/lang/Integer;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setPage(Ljava/lang/Integer;)V

    .line 100
    new-instance v1, Ljava/lang/Integer;

    const/16 v2, 0xa

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;->setSize(Ljava/lang/Integer;)V

    .line 101
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 102
    return-void
.end method

.method public setSubscriber(Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    .line 44
    return-void
.end method
