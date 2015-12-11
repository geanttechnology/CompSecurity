.class public Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;
.super Lcom/amazon/mShop/pushnotification/NotificationParams;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CoinsNotificationParams"
.end annotation


# instance fields
.field private mTitle:Ljava/lang/String;

.field private mUrl:Ljava/lang/String;

.field private mUseCoinsIcon:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "message"    # Ljava/lang/String;
    .param p5, "useCoinsIcon"    # Z
    .param p6, "refMarker"    # Ljava/lang/String;
    .param p7, "url"    # Ljava/lang/String;

    .prologue
    .line 148
    invoke-direct {p0, p1, p2, p4, p6}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    iput-object p7, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mUrl:Ljava/lang/String;

    .line 150
    iput-object p3, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mTitle:Ljava/lang/String;

    .line 151
    iput-boolean p5, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mUseCoinsIcon:Z

    .line 152
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public useCoinsIcon()Z
    .locals 1

    .prologue
    .line 163
    iget-boolean v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->mUseCoinsIcon:Z

    return v0
.end method
