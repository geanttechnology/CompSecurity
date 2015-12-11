.class public Lcom/amazon/mShop/kiang/KiangController;
.super Ljava/lang/Object;
.source "KiangController.java"

# interfaces
.implements Lcom/amazon/mShop/control/device/KiangSubscriber;


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static mKiangController:Lcom/amazon/mShop/kiang/KiangController;


# instance fields
.field private mIsRegisterInProgress:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/mShop/kiang/KiangController;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/kiang/KiangController;->TAG:Ljava/lang/String;

    .line 24
    new-instance v0, Lcom/amazon/mShop/kiang/KiangController;

    invoke-direct {v0}, Lcom/amazon/mShop/kiang/KiangController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/kiang/KiangController;->mKiangController:Lcom/amazon/mShop/kiang/KiangController;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/kiang/KiangController;->mIsRegisterInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 31
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/kiang/KiangController;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/mShop/kiang/KiangController;->mKiangController:Lcom/amazon/mShop/kiang/KiangController;

    return-object v0
.end method


# virtual methods
.method public kiangRegister(Landroid/content/Context;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x0

    .line 40
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 41
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "applicationInstallId"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 64
    :cond_0
    :goto_0
    return-void

    .line 47
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/kiang/KiangController;->mIsRegisterInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndSet(I)I

    move-result v3

    if-nez v3, :cond_0

    .line 49
    :try_start_0
    new-instance v2, Lcom/amazon/mShop/control/device/DeviceRegisterController;

    invoke-static {p1}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangAppInfomation(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangPushInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5, p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;-><init>(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;Lcom/amazon/mShop/control/device/KiangSubscriber;)V

    .line 58
    .local v2, "registerController":Lcom/amazon/mShop/control/device/DeviceRegisterController;
    sget-object v3, Lcom/amazon/mShop/kiang/KiangController;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "kiang register"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    invoke-virtual {v2}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->kiangRegister()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 60
    .end local v2    # "registerController":Lcom/amazon/mShop/control/device/DeviceRegisterController;
    :catch_0
    move-exception v1

    .line 61
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0, v6, v6}, Lcom/amazon/mShop/kiang/KiangController;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0
.end method

.method public kiangUpdate(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 73
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 78
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "applicationInstallId"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 79
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/kiang/KiangController;->kiangRegister(Landroid/content/Context;)V

    .line 88
    :goto_0
    return-void

    .line 81
    :cond_0
    new-instance v1, Lcom/amazon/mShop/control/device/DeviceUpdateController;

    invoke-static {}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangSecurity()Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;

    move-result-object v2

    invoke-static {p1}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangApplicationState(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    move-result-object v3

    invoke-direct {v1, v2, v3, p0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;-><init>(Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;Lcom/amazon/mShop/control/device/KiangSubscriber;)V

    .line 85
    .local v1, "updateController":Lcom/amazon/mShop/control/device/DeviceUpdateController;
    sget-object v2, Lcom/amazon/mShop/kiang/KiangController;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "kiang update"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    invoke-virtual {v1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->kiangUpdate()V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 92
    sget-object v0, Lcom/amazon/mShop/kiang/KiangController;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Kiang Error"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 93
    return-void
.end method

.method public onRegisterCompleted()V
    .locals 3

    .prologue
    .line 103
    iget-object v1, p0, Lcom/amazon/mShop/kiang/KiangController;->mIsRegisterInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 104
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 105
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 106
    return-void
.end method

.method public onRegisterError()V
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/kiang/KiangController;->mIsRegisterInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 98
    return-void
.end method

.method public onResetRegister()V
    .locals 2

    .prologue
    .line 110
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 111
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangRegister(Landroid/content/Context;)V

    .line 112
    return-void
.end method
