.class public Lcom/amazon/clouddrive/library/service/CheckStorageServiceProxy;
.super Lcom/amazon/mShop/android/platform/services/ProxyService;
.source "CheckStorageServiceProxy.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;-><init>()V

    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 12
    const/4 v0, 0x0

    return-object v0
.end method
