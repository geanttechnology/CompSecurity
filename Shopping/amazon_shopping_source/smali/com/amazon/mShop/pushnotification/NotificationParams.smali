.class public Lcom/amazon/mShop/pushnotification/NotificationParams;
.super Ljava/lang/Object;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;,
        Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;
    }
.end annotation


# instance fields
.field private mMarketPlace:Ljava/lang/String;

.field private mMessage:Ljava/lang/String;

.field private mNotificationType:Ljava/lang/String;

.field private mRefMarker:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mNotificationType:Ljava/lang/String;

    .line 11
    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mMarketPlace:Ljava/lang/String;

    .line 12
    iput-object p3, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mMessage:Ljava/lang/String;

    .line 13
    iput-object p4, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mRefMarker:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public getMarketPlace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mMarketPlace:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getNotificationType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mNotificationType:Ljava/lang/String;

    return-object v0
.end method

.method public getRefMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams;->mRefMarker:Ljava/lang/String;

    return-object v0
.end method
