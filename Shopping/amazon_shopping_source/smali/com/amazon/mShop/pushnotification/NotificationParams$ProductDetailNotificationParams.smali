.class public Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;
.super Lcom/amazon/mShop/pushnotification/NotificationParams;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProductDetailNotificationParams"
.end annotation


# instance fields
.field private mAsin:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "asin"    # Ljava/lang/String;
    .param p5, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2, p3, p5}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    iput-object p4, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;->mAsin:Ljava/lang/String;

    .line 50
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;->mAsin:Ljava/lang/String;

    return-object v0
.end method
