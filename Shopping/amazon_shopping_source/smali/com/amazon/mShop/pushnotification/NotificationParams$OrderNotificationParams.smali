.class public Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;
.super Lcom/amazon/mShop/pushnotification/NotificationParams;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OrderNotificationParams"
.end annotation


# instance fields
.field private mOrderId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "orderId"    # Ljava/lang/String;
    .param p5, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 91
    invoke-direct {p0, p1, p2, p3, p5}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iput-object p4, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;->mOrderId:Ljava/lang/String;

    .line 93
    return-void
.end method


# virtual methods
.method public getOrderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;->mOrderId:Ljava/lang/String;

    return-object v0
.end method
