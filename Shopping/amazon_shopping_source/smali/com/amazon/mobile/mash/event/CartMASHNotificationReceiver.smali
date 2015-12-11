.class public Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;
.super Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
.source "CartMASHNotificationReceiver.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, v0, p1, v1}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;-><init>(Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Z)V

    .line 29
    return-void
.end method

.method public static getCartUpdateJSONObject(I)Lorg/json/JSONObject;
    .locals 7
    .param p0, "cartCount"    # I

    .prologue
    .line 38
    const/4 v1, 0x0

    .line 40
    .local v1, "detail":Lorg/json/JSONObject;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    .end local v1    # "detail":Lorg/json/JSONObject;
    .local v2, "detail":Lorg/json/JSONObject;
    :try_start_1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 42
    .local v0, "cart":Lorg/json/JSONObject;
    const-string/jumbo v4, "itemCount"

    invoke-virtual {v0, v4, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 43
    const-string/jumbo v4, "cart"

    invoke-virtual {v2, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, v2

    .line 47
    .end local v0    # "cart":Lorg/json/JSONObject;
    .end local v2    # "detail":Lorg/json/JSONObject;
    .restart local v1    # "detail":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 44
    :catch_0
    move-exception v3

    .line 45
    .local v3, "e":Lorg/json/JSONException;
    :goto_1
    sget-object v4, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Created a bad JSON object. Error : "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 44
    .end local v1    # "detail":Lorg/json/JSONObject;
    .end local v3    # "e":Lorg/json/JSONException;
    .restart local v2    # "detail":Lorg/json/JSONObject;
    :catch_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "detail":Lorg/json/JSONObject;
    .restart local v1    # "detail":Lorg/json/JSONObject;
    goto :goto_1
.end method
