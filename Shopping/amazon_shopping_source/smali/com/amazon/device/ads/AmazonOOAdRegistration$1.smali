.class final Lcom/amazon/device/ads/AmazonOOAdRegistration$1;
.super Ljava/lang/Object;
.source "AmazonOOAdRegistration.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AmazonOOAdRegistration;->updateLastIdentifyUserWithSISTime(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 308
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 312
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$1;->val$context:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 313
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "lastIdentifyUserWithSisTime"

    sget-wide v2, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/device/ads/Settings;->putLong(Ljava/lang/String;J)V

    .line 314
    return-void
.end method
