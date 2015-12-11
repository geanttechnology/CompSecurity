.class public Lcom/amazon/mobile/mash/MASHWebView;
.super Lorg/apache/cordova/CordovaWebView;
.source "MASHWebView.java"


# instance fields
.field private mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

.field private mIsInEmbeddedBrowserMode:Z

.field private mMASHWebBackForwardList:Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

.field private mPendingNavRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

.field private mShouldHideProgressIndicator:Z


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/appcontext/AppContext;Landroid/content/Context;)V
    .locals 8
    .param p1, "appContext"    # Lcom/amazon/mobile/mash/appcontext/AppContext;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 71
    invoke-direct {p0, p2}, Lorg/apache/cordova/CordovaWebView;-><init>(Landroid/content/Context;)V

    .line 36
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    invoke-direct {v0}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mMASHWebBackForwardList:Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    .line 40
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mShouldHideProgressIndicator:Z

    .line 72
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lorg/apache/cordova/CordovaInterface;

    invoke-static {}, Lorg/apache/cordova/Config;->getPluginEntries()Ljava/util/List;

    move-result-object v4

    invoke-static {}, Lorg/apache/cordova/Config;->getWhitelist()Lorg/apache/cordova/Whitelist;

    move-result-object v5

    invoke-static {}, Lorg/apache/cordova/Config;->getExternalWhitelist()Lorg/apache/cordova/Whitelist;

    move-result-object v6

    invoke-static {}, Lorg/apache/cordova/Config;->getPreferences()Lorg/apache/cordova/CordovaPreferences;

    move-result-object v7

    move-object v0, p0

    move-object v3, v2

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/mobile/mash/MASHWebView;->init(Lorg/apache/cordova/CordovaInterface;Lorg/apache/cordova/CordovaWebViewClient;Lorg/apache/cordova/CordovaChromeClient;Ljava/util/List;Lorg/apache/cordova/Whitelist;Lorg/apache/cordova/Whitelist;Lorg/apache/cordova/CordovaPreferences;)V

    .line 74
    iput-object p1, p0, Lcom/amazon/mobile/mash/MASHWebView;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    .line 75
    return-void
.end method


# virtual methods
.method public checkForFileChooserActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "intent"    # Landroid/content/Intent;

    .prologue
    .line 217
    const/16 v2, 0x1435

    if-ne p1, v2, :cond_0

    .line 218
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getWebChromeClient()Lorg/apache/cordova/CordovaChromeClient;

    move-result-object v2

    iget-object v1, v2, Lorg/apache/cordova/CordovaChromeClient;->mUploadMessage:Landroid/webkit/ValueCallback;

    .line 219
    .local v1, "uploadMessage":Landroid/webkit/ValueCallback;, "Landroid/webkit/ValueCallback<Landroid/net/Uri;>;"
    if-nez v1, :cond_1

    .line 225
    .end local v1    # "uploadMessage":Landroid/webkit/ValueCallback;, "Landroid/webkit/ValueCallback<Landroid/net/Uri;>;"
    :cond_0
    :goto_0
    return-void

    .line 222
    .restart local v1    # "uploadMessage":Landroid/webkit/ValueCallback;, "Landroid/webkit/ValueCallback<Landroid/net/Uri;>;"
    :cond_1
    if-eqz p3, :cond_2

    const/4 v2, -0x1

    if-eq p2, v2, :cond_3

    :cond_2
    const/4 v0, 0x0

    .line 223
    .local v0, "result":Landroid/net/Uri;
    :goto_1
    invoke-interface {v1, v0}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 222
    .end local v0    # "result":Landroid/net/Uri;
    :cond_3
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    goto :goto_1
.end method

.method public createPluginManager(Ljava/util/List;)Lorg/apache/cordova/PluginManager;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/cordova/PluginEntry;",
            ">;)",
            "Lorg/apache/cordova/PluginManager;"
        }
    .end annotation

    .prologue
    .line 48
    .local p1, "pluginEntries":Ljava/util/List;, "Ljava/util/List<Lorg/apache/cordova/PluginEntry;>;"
    new-instance v1, Lcom/amazon/mobile/mash/api/MASHPluginManager;

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lorg/apache/cordova/CordovaInterface;

    invoke-direct {v1, p0, v0, p1}, Lcom/amazon/mobile/mash/api/MASHPluginManager;-><init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V

    return-object v1
.end method

.method public destroy()V
    .locals 0

    .prologue
    .line 187
    invoke-super {p0}, Lorg/apache/cordova/CordovaWebView;->destroy()V

    .line 188
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->handleDestroy()V

    .line 189
    return-void
.end method

.method public getAppContext()Lcom/amazon/mobile/mash/appcontext/AppContext;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    return-object v0
.end method

.method public getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mMASHWebBackForwardList:Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    return-object v0
.end method

.method public getPendingNavRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mPendingNavRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    return-object v0
.end method

.method public handleDestroy()V
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->pluginManager:Lorg/apache/cordova/PluginManager;

    if-eqz v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->pluginManager:Lorg/apache/cordova/PluginManager;

    invoke-virtual {v0}, Lorg/apache/cordova/PluginManager;->onDestroy()V

    .line 206
    :cond_0
    return-void
.end method

.method public isInEmbeddedBrowserMode()Z
    .locals 1

    .prologue
    .line 173
    iget-boolean v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mIsInEmbeddedBrowserMode:Z

    return v0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x0

    .line 153
    const/16 v1, 0x54

    if-ne p1, v1, :cond_1

    .line 162
    :cond_0
    :goto_0
    return v0

    .line 158
    :cond_1
    const/4 v1, 0x4

    if-eq p1, v1, :cond_0

    .line 162
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaWebView;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public postUrl(Ljava/lang/String;[B)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "postData"    # [B

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->pluginManager:Lorg/apache/cordova/PluginManager;

    invoke-virtual {v0}, Lorg/apache/cordova/PluginManager;->init()V

    .line 148
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaWebView;->postUrl(Ljava/lang/String;[B)V

    .line 149
    return-void
.end method

.method public setAppContext(Lcom/amazon/mobile/mash/appcontext/AppContext;)V
    .locals 0
    .param p1, "appContex"    # Lcom/amazon/mobile/mash/appcontext/AppContext;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mobile/mash/MASHWebView;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    .line 82
    return-void
.end method

.method public setIsInEmbeddedBrowserMode(Z)V
    .locals 0
    .param p1, "isInEmbeddedBrowserMode"    # Z

    .prologue
    .line 180
    iput-boolean p1, p0, Lcom/amazon/mobile/mash/MASHWebView;->mIsInEmbeddedBrowserMode:Z

    .line 181
    return-void
.end method

.method public setPendingNavRequest(Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V
    .locals 0
    .param p1, "pendingNavRequest"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mobile/mash/MASHWebView;->mPendingNavRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .line 119
    return-void
.end method

.method public setShouldHideProgressIndicator(Z)V
    .locals 0
    .param p1, "shouldHideProgressIndicator"    # Z

    .prologue
    .line 135
    iput-boolean p1, p0, Lcom/amazon/mobile/mash/MASHWebView;->mShouldHideProgressIndicator:Z

    .line 136
    return-void
.end method

.method public shouldHideProgressIndicator()Z
    .locals 1

    .prologue
    .line 128
    iget-boolean v0, p0, Lcom/amazon/mobile/mash/MASHWebView;->mShouldHideProgressIndicator:Z

    return v0
.end method
