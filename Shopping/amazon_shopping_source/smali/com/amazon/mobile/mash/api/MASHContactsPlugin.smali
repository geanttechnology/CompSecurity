.class public Lcom/amazon/mobile/mash/api/MASHContactsPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHContactsPlugin.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCallbackContext:Lorg/apache/cordova/CallbackContext;

.field private mContactAccessor:Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;

.field private mReturnResultKey:Lorg/json/JSONArray;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    .line 113
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHContactsPlugin;)Lorg/apache/cordova/CallbackContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private showContactPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 65
    sget-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_CONTACT_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/appcontext/Capability;->isAvailable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 87
    :goto_0
    return-void

    .line 69
    :cond_0
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;

    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-direct {v0, v1}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;-><init>(Lorg/apache/cordova/CordovaInterface;)V

    iput-object v0, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mContactAccessor:Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;

    .line 70
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mReturnResultKey:Lorg/json/JSONArray;

    .line 72
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;

    invoke-direct {v0, p0}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHContactsPlugin;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 48
    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 50
    const-string/jumbo v0, "ShowContactPicker"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->showContactPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 53
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "reqCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 92
    const/16 v3, 0x2711

    if-ne p1, v3, :cond_1

    .line 93
    const/4 v3, -0x1

    if-ne p2, v3, :cond_0

    .line 95
    :try_start_0
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 96
    .local v0, "contactData":Landroid/net/Uri;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mContactAccessor:Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;

    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mReturnResultKey:Lorg/json/JSONArray;

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;->getContact(Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONObject;

    move-result-object v1

    .line 98
    .local v1, "contactObject":Lorg/json/JSONObject;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v3, v1}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    .end local v0    # "contactData":Landroid/net/Uri;
    .end local v1    # "contactObject":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    if-nez p2, :cond_1

    .line 108
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 111
    :cond_1
    return-void

    .line 99
    :catch_0
    move-exception v2

    .line 100
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 101
    sget-object v3, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    :cond_2
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
