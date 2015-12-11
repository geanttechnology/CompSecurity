.class public Lcom/amazon/mShop/clouddrive/CloudDriveManageStorageActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "CloudDriveManageStorageActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstance"    # Landroid/os/Bundle;

    .prologue
    .line 22
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    const-string/jumbo v6, ""

    .line 27
    .local v6, "url":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v7, "com.amazon.clouddrive.library.CloudDriveLibrary"

    const/4 v8, 0x1

    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v9

    invoke-static {v7, v8, v9}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v2

    .line 29
    .local v2, "cls":Ljava/lang/Class;
    const-string/jumbo v8, "getInstance"

    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/Class;

    invoke-virtual {v2, v8, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 30
    .local v4, "getInstance":Ljava/lang/reflect/Method;
    const/4 v8, 0x0

    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/Object;

    invoke-virtual {v4, v8, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 31
    .local v1, "cloudDriveLibrary":Ljava/lang/Object;
    const-string/jumbo v8, "getManageStorageUrl"

    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/Class;

    invoke-virtual {v2, v8, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    .line 32
    .local v5, "getManageStorageUrl":Ljava/lang/reflect/Method;
    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/Class;

    invoke-virtual {v5, v1, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/lang/String;

    move-object v6, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    .end local v1    # "cloudDriveLibrary":Ljava/lang/Object;
    .end local v2    # "cls":Ljava/lang/Class;
    .end local v4    # "getInstance":Ljava/lang/reflect/Method;
    .end local v5    # "getManageStorageUrl":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveManageStorageActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v7

    invoke-virtual {v7, v6}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 40
    return-void

    .line 33
    :catch_0
    move-exception v3

    .line 34
    .local v3, "e":Ljava/lang/Exception;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 35
    const-string/jumbo v7, "CloudDriveManageStorageActivity"

    const-string/jumbo v8, "Exception occurred using reflection to fetch manage storage url for Cloud Drive account"

    invoke-static {v7, v8, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
