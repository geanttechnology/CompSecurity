.class public Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;
.super Lcom/amazon/mShop/pushnotification/NotificationParams;
.source "NotificationParams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SnsNotificationParams"
.end annotation


# instance fields
.field private mToken:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationType"    # Ljava/lang/String;
    .param p2, "marketPlace"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "refMarker"    # Ljava/lang/String;
    .param p5, "token"    # Ljava/lang/String;

    .prologue
    .line 107
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    iput-object p5, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;->mToken:Ljava/lang/String;

    .line 109
    return-void
.end method


# virtual methods
.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;->mToken:Ljava/lang/String;

    return-object v0
.end method
