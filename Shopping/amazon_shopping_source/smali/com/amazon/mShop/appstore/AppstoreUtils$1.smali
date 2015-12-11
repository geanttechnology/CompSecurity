.class final Lcom/amazon/mShop/appstore/AppstoreUtils$1;
.super Ljava/lang/Object;
.source "AppstoreUtils.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/appstore/AppstoreUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private setAppstoreDeviceInfoCookie()V
    .locals 2

    .prologue
    .line 27
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 28
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/appstore/AppstoreUtils;->setAppstoreDeviceInfoCookie(Landroid/content/Context;)V

    .line 29
    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/appstore/AppstoreUtils$1;->setAppstoreDeviceInfoCookie()V

    .line 39
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/amazon/mShop/appstore/AppstoreUtils$1;->setAppstoreDeviceInfoCookie()V

    .line 44
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/appstore/AppstoreUtils$1;->setAppstoreDeviceInfoCookie()V

    .line 34
    return-void
.end method
