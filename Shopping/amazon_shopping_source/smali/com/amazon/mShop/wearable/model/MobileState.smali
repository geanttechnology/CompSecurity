.class public Lcom/amazon/mShop/wearable/model/MobileState;
.super Ljava/lang/Object;
.source "MobileState.java"


# instance fields
.field public loggedIn:Z

.field public networkAvailable:Z

.field public oneClickCity:Ljava/lang/String;

.field public oneClickEnabled:Z

.field public oneClickName:Ljava/lang/String;

.field public prime:Z

.field public supportedLocale:Z

.field public updateTime:J

.field public weblabOneClickDisabled:Z

.field public weblabWearableDeviceDisabled:Z


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/wearable/model/MobileState;->updateTime:J

    .line 5
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickEnabled:Z

    .line 6
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->loggedIn:Z

    .line 7
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->prime:Z

    .line 8
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->supportedLocale:Z

    .line 9
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->networkAvailable:Z

    .line 10
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->weblabOneClickDisabled:Z

    .line 11
    iput-boolean v2, p0, Lcom/amazon/mShop/wearable/model/MobileState;->weblabWearableDeviceDisabled:Z

    .line 12
    iput-object v3, p0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickCity:Ljava/lang/String;

    .line 13
    iput-object v3, p0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickName:Ljava/lang/String;

    return-void
.end method
