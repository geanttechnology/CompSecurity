.class public Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "CloudDriveUploadActivity.java"


# instance fields
.field private mUploadView:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->initActivity()V

    return-void
.end method

.method private initActivity()V
    .locals 7

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v4

    if-nez v4, :cond_1

    .line 53
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->showNetworkErrorView()V

    .line 77
    :cond_0
    :goto_0
    return-void

    .line 55
    :cond_1
    const/4 v3, 0x0

    .line 56
    .local v3, "goToSignInActivityRunnable":Ljava/lang/Runnable;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v4

    if-nez v4, :cond_2

    .line 57
    new-instance v3, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$1;

    .end local v3    # "goToSignInActivityRunnable":Ljava/lang/Runnable;
    invoke-direct {v3, p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$1;-><init>(Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;)V

    .line 66
    .restart local v3    # "goToSignInActivityRunnable":Ljava/lang/Runnable;
    :cond_2
    :try_start_0
    const-string/jumbo v4, "com.amazon.clouddrive.library.display.CloudDriveUploadView"

    const/4 v5, 0x1

    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v6

    invoke-static {v4, v5, v6}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v0

    .line 68
    .local v0, "cls":Ljava/lang/Class;
    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Landroid/support/v4/app/FragmentActivity;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-class v6, Ljava/lang/Runnable;

    aput-object v6, v4, v5

    invoke-virtual {v0, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 69
    .local v1, "constructor":Ljava/lang/reflect/Constructor;
    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    const/4 v5, 0x1

    aput-object v3, v4, v5

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/View;

    iput-object v4, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->mUploadView:Landroid/view/View;

    .line 70
    iget-object v4, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->mUploadView:Landroid/view/View;

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->setRootView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 71
    .end local v0    # "cls":Ljava/lang/Class;
    .end local v1    # "constructor":Ljava/lang/reflect/Constructor;
    :catch_0
    move-exception v2

    .line 72
    .local v2, "e":Ljava/lang/Exception;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 73
    const-string/jumbo v4, "CloudDriveUploadActivity"

    const-string/jumbo v5, "Exception occurred using reflection to construct CloudDriveUploadView"

    invoke-static {v4, v5, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private showNetworkErrorView()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 80
    new-instance v0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$2;-><init>(Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;)V

    .line 89
    .local v0, "buttonOnClickListener":Landroid/view/View$OnClickListener;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v4}, Lcom/amazon/mShop/util/UIUtils;->formatErrorMessage(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    .line 91
    .local v2, "message":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/error/AmazonErrorBox;-><init>(Landroid/content/Context;)V

    .line 92
    .local v1, "errorBox":Lcom/amazon/mShop/error/AmazonErrorBox;
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->setMessage(Ljava/lang/CharSequence;)V

    .line 93
    invoke-virtual {v1, v4, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonOnClick(ILandroid/view/View$OnClickListener;)V

    .line 94
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->setRootView(Landroid/view/View;)V

    .line 95
    return-void
.end method


# virtual methods
.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 1

    .prologue
    .line 122
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 7
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 99
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 102
    :try_start_0
    const-string/jumbo v4, "com.amazon.clouddrive.library.display.CloudDriveUploadView"

    const/4 v5, 0x1

    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v6

    invoke-static {v4, v5, v6}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v0

    .line 104
    .local v0, "cls":Ljava/lang/Class;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 105
    const-string/jumbo v5, "onSignInSuccess"

    const/4 v4, 0x0

    check-cast v4, [Ljava/lang/Class;

    invoke-virtual {v0, v5, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 106
    .local v3, "onSignInSuccess":Ljava/lang/reflect/Method;
    iget-object v5, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->mUploadView:Landroid/view/View;

    const/4 v4, 0x0

    check-cast v4, [Ljava/lang/Object;

    invoke-virtual {v3, v5, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    .end local v0    # "cls":Ljava/lang/Class;
    .end local v3    # "onSignInSuccess":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return-void

    .line 109
    .restart local v0    # "cls":Ljava/lang/Class;
    :cond_1
    const-string/jumbo v5, "onSignInFailure"

    const/4 v4, 0x0

    check-cast v4, [Ljava/lang/Class;

    invoke-virtual {v0, v5, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 110
    .local v2, "onSignInFailure":Ljava/lang/reflect/Method;
    iget-object v5, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->mUploadView:Landroid/view/View;

    const/4 v4, 0x0

    check-cast v4, [Ljava/lang/Object;

    invoke-virtual {v2, v5, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    invoke-virtual {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 113
    .end local v0    # "cls":Ljava/lang/Class;
    .end local v2    # "onSignInFailure":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v1

    .line 114
    .local v1, "e":Ljava/lang/Exception;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 115
    const-string/jumbo v4, "CloudDriveUploadActivity"

    const-string/jumbo v5, "Exception occurred using reflection to invoke CloudDriveUploadView.onSignInSuccess/Failure"

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstance"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->initActivity()V

    .line 38
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "i"    # Landroid/content/Intent;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->initActivity()V

    .line 49
    return-void
.end method
