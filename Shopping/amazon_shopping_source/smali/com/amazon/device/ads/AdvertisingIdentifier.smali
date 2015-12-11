.class Lcom/amazon/device/ads/AdvertisingIdentifier;
.super Ljava/lang/Object;
.source "AdvertisingIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    }
.end annotation


# static fields
.field private static final GPS_ADVERTISING_IDENTIFIER_SETTING:Ljava/lang/String; = "gpsAdId"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final TRANSITION_MIGRATE:Ljava/lang/String; = "migrate"

.field private static final TRANSITION_RESET:Ljava/lang/String; = "reset"

.field private static final TRANSITION_REVERT:Ljava/lang/String; = "revert"

.field private static final TRANSITION_SETTING:Ljava/lang/String; = "adIdTransistion"


# instance fields
.field private gpsAdvertisingInfo:Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

.field private shouldSetCurrentAdvertisingIdentifier:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdvertisingIdentifier;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->shouldSetCurrentAdvertisingIdentifier:Z

    .line 192
    return-void
.end method

.method private determineTransition()V
    .locals 3

    .prologue
    .line 94
    const/4 v0, 0x0

    .line 95
    .local v0, "transition":Ljava/lang/String;
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->isTransitionMigrated()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 97
    const-string/jumbo v0, "migrate"

    .line 108
    :cond_0
    :goto_0
    if-eqz v0, :cond_3

    .line 110
    invoke-static {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->setTransition(Ljava/lang/String;)V

    .line 116
    :goto_1
    return-void

    .line 99
    :cond_1
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->isTransitionReset()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 101
    const-string/jumbo v0, "reset"

    goto :goto_0

    .line 103
    :cond_2
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->isTransitionReverted()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 105
    const-string/jumbo v0, "revert"

    goto :goto_0

    .line 114
    :cond_3
    sget-object v1, Lcom/amazon/device/ads/AdvertisingIdentifier;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "No transition detected."

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method static getAndClearTransition()Ljava/lang/String;
    .locals 4

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    .line 31
    .local v0, "settings":Lcom/amazon/device/ads/Settings;
    const-string/jumbo v2, "adIdTransistion"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/Settings;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 32
    .local v1, "transition":Ljava/lang/String;
    const-string/jumbo v2, "adIdTransistion"

    invoke-virtual {v0, v2}, Lcom/amazon/device/ads/Settings;->remove(Ljava/lang/String;)V

    .line 33
    return-object v1
.end method

.method private static getCurrentGPSAID()Ljava/lang/String;
    .locals 3

    .prologue
    .line 178
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "gpsAdId"

    const-string/jumbo v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/Settings;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private hasCurrentGPSAID()Z
    .locals 1

    .prologue
    .line 186
    invoke-static {}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getCurrentGPSAID()Ljava/lang/String;

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

.method private isTransitionMigrated()Z
    .locals 2

    .prologue
    .line 142
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    .line 143
    .local v0, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    invoke-virtual {v0}, Lcom/amazon/device/ads/RegistrationInfo;->hasAdId()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/amazon/device/ads/RegistrationInfo;->isAdIdOriginatedFromNonAdvertisingIdentifier()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->hasCurrentGPSAID()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->hasAdvertisingIdentifier()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isTransitionReset()Z
    .locals 2

    .prologue
    .line 155
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->hasCurrentGPSAID()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->hasAdvertisingIdentifier()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getCurrentGPSAID()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isTransitionReverted()Z
    .locals 1

    .prologue
    .line 166
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->hasCurrentGPSAID()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->hasAdvertisingIdentifier()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static setCurrentGPSAID(Ljava/lang/String;)V
    .locals 2
    .param p0, "gpsaid"    # Ljava/lang/String;

    .prologue
    .line 170
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "gpsAdId"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/device/ads/Settings;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    return-void
.end method

.method private static setTransition(Ljava/lang/String;)V
    .locals 4
    .param p0, "transition"    # Ljava/lang/String;

    .prologue
    .line 119
    sget-object v0, Lcom/amazon/device/ads/AdvertisingIdentifier;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Transition: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 120
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "adIdTransistion"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/device/ads/Settings;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    return-void
.end method


# virtual methods
.method protected fetchGooglePlayServicesAdvertisingIdentifierInfo()V
    .locals 2

    .prologue
    .line 127
    new-instance v0, Lcom/amazon/device/ads/GooglePlayServices;

    invoke-direct {v0}, Lcom/amazon/device/ads/GooglePlayServices;-><init>()V

    .line 128
    .local v0, "gps":Lcom/amazon/device/ads/GooglePlayServices;
    invoke-virtual {v0}, Lcom/amazon/device/ads/GooglePlayServices;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->gpsAdvertisingInfo:Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    .line 129
    return-void
.end method

.method getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 4

    .prologue
    .line 50
    invoke-static {}, Lcom/amazon/device/ads/ThreadUtils;->isOnMainThread()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 52
    sget-object v2, Lcom/amazon/device/ads/AdvertisingIdentifier;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "You must obtain the advertising indentifier information on a background thread."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    new-instance v2, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-direct {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;-><init>()V

    const/4 v3, 0x0

    # invokes: Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setCanDo(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-static {v2, v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->access$000(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    .line 86
    :goto_0
    return-object v0

    .line 56
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->fetchGooglePlayServicesAdvertisingIdentifierInfo()V

    .line 57
    iget-boolean v2, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->shouldSetCurrentAdvertisingIdentifier:Z

    if-eqz v2, :cond_1

    .line 59
    invoke-direct {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->determineTransition()V

    .line 62
    :cond_1
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;-><init>()V

    .line 64
    .local v0, "info":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->hasAdvertisingIdentifier()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 66
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setAdvertisingIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-static {v0, v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->access$100(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 67
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->isLimitAdTrackingEnabled()Z

    move-result v2

    # invokes: Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setLimitAdTrackingEnabled(Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-static {v0, v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->access$200(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Z)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 68
    iget-boolean v2, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->shouldSetCurrentAdvertisingIdentifier:Z

    if-eqz v2, :cond_2

    .line 70
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier;->setCurrentGPSAID(Ljava/lang/String;)V

    .line 76
    :cond_2
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v1

    .line 77
    .local v1, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    invoke-static {v0}, Lcom/amazon/device/ads/RegistrationInfo;->isAdIdCurrent(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 79
    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->getAdId()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->setSISDeviceIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-static {v0, v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->access$300(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Ljava/lang/String;)Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    goto :goto_0

    .line 83
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->requestNewSISDeviceIdentifier()V

    goto :goto_0
.end method

.method protected getGPSAdvertisingInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->gpsAdvertisingInfo:Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    return-object v0
.end method

.method setShouldSetCurrentAdvertisingIdentifier(Z)Lcom/amazon/device/ads/AdvertisingIdentifier;
    .locals 0
    .param p1, "shouldSetCurrentAdvertisingIdentifier"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdvertisingIdentifier;->shouldSetCurrentAdvertisingIdentifier:Z

    .line 39
    return-object p0
.end method
