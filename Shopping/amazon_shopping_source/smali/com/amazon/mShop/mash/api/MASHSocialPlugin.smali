.class public Lcom/amazon/mShop/mash/api/MASHSocialPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHSocialPlugin.java"


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private handleActivityResultForShare(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 89
    const/4 v1, -0x1

    if-ne p2, v1, :cond_1

    .line 91
    const-string/jumbo v1, "SelectedResult"

    invoke-virtual {p3, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 92
    .local v0, "sharedResult":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1, v0}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    .line 100
    .end local v0    # "sharedResult":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 94
    :cond_1
    if-nez p2, :cond_0

    .line 98
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    const-string/jumbo v2, "null"

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private share(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 7
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 56
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    .line 57
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 58
    .local v2, "text":Ljava/lang/String;
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 59
    .local v3, "subject":Ljava/lang/String;
    const/4 v0, 0x5

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 60
    .local v4, "imageUrl":Ljava/lang/String;
    const/4 v0, 0x6

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 61
    .local v5, "url":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;

    move-object v1, p0

    move-object v6, p2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHSocialPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 79
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 33
    const-string/jumbo v0, "Share"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 34
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->share(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 35
    const/4 v0, 0x1

    .line 37
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 42
    const/16 v0, 0xf

    if-ne p1, v0, :cond_0

    .line 43
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->handleActivityResultForShare(IILandroid/content/Intent;)V

    .line 45
    :cond_0
    return-void
.end method
