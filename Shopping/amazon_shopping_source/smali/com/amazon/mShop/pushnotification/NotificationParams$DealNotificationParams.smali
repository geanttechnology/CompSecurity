.class public Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;
.super Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DealNotificationParams"
.end annotation


# instance fields
.field private mCategory:Ljava/lang/String;

.field private mCategoryDisplayName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "asin"    # Ljava/lang/String;
    .param p5, "category"    # Ljava/lang/String;
    .param p6, "categoryDisplayName"    # Ljava/lang/String;
    .param p7, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 66
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p7

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    iput-object p5, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->mCategory:Ljava/lang/String;

    .line 68
    iput-object p6, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->mCategoryDisplayName:Ljava/lang/String;

    .line 69
    return-void
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->mCategory:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->mCategoryDisplayName:Ljava/lang/String;

    return-object v0
.end method
