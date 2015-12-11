.class Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
.super Ljava/lang/Object;
.source "AdvertisingIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdvertisingIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Info"
.end annotation


# instance fields
.field private advertisingIdentifier:Ljava/lang/String;

.field private canDo:Z

.field private limitAdTrackingEnabled:Z

.field private sisDeviceIdentifier:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 200
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 201
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo:Z

    .line 202
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .param p1, "x1"    # Z

    .prologue
    .line 192
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setCanDo(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 192
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setAdvertisingIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .param p1, "x1"    # Z

    .prologue
    .line 192
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setLimitAdTrackingEnabled(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 192
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setSISDeviceIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    return-object v0
.end method

.method private setAdvertisingIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 0
    .param p1, "advertisingIdentifier"    # Ljava/lang/String;

    .prologue
    .line 235
    iput-object p1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->advertisingIdentifier:Ljava/lang/String;

    .line 236
    return-object p0
.end method

.method private setCanDo(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 0
    .param p1, "canDo"    # Z

    .prologue
    .line 214
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo:Z

    .line 215
    return-object p0
.end method

.method private setLimitAdTrackingEnabled(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 0
    .param p1, "limitAdTrackingEnabled"    # Z

    .prologue
    .line 264
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->limitAdTrackingEnabled:Z

    .line 265
    return-object p0
.end method

.method private setSISDeviceIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 0
    .param p1, "sisDeviceIdentifier"    # Ljava/lang/String;

    .prologue
    .line 289
    iput-object p1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->sisDeviceIdentifier:Ljava/lang/String;

    .line 290
    return-object p0
.end method


# virtual methods
.method canDo()Z
    .locals 1

    .prologue
    .line 210
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo:Z

    return v0
.end method

.method getAdvertisingIdentifier()Ljava/lang/String;
    .locals 2

    .prologue
    .line 224
    const-string/jumbo v0, "debug.idfa"

    iget-object v1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->advertisingIdentifier:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getSISDeviceIdentifier()Ljava/lang/String;
    .locals 2

    .prologue
    .line 274
    const-string/jumbo v0, "debug.adid"

    iget-object v1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->sisDeviceIdentifier:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method hasAdvertisingIdentifier()Z
    .locals 1

    .prologue
    .line 244
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method hasSISDeviceIdentifier()Z
    .locals 1

    .prologue
    .line 280
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isLimitAdTrackingEnabled()Z
    .locals 2

    .prologue
    .line 253
    const-string/jumbo v0, "debug.optOut"

    iget-boolean v1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->limitAdTrackingEnabled:Z

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
