.class public Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;
.super Ljava/lang/Object;
.source "CookieDataStoreFactory.java"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->mContext:Landroid/content/Context;

    .line 19
    const-string/jumbo v0, "sso_platform"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 20
    return-void
.end method


# virtual methods
.method public getDataStore()Lcom/amazon/identity/auth/device/storage/CookieDataStore;
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPreMergeDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;-><init>(Landroid/content/Context;)V

    .line 29
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;-><init>(Landroid/content/Context;)V

    goto :goto_0
.end method
