.class public final Lcom/inc247/bridge/ChatSDKNativeToJSBridge;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static MessageForGoogleLocationService:Ljava/lang/String;

.field public static MessageForGps:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;

.field public static address:Ljava/lang/String;

.field private static bridgeEventsCallback:Ljava/lang/String;

.field private static chatBackground:Ljava/lang/String;

.field private static chatEndedString:Ljava/lang/String;

.field private static chatForeground:Ljava/lang/String;

.field private static chatMaximizedString:Ljava/lang/String;

.field private static chatMinimizedString:Ljava/lang/String;

.field public static data:Lorg/json/JSONObject;

.field public static getLocationToBridge:Ljava/lang/String;

.field public static gps:Lcom/gps/locationfinder/GPSTracker;

.field public static latitude:Ljava/lang/String;

.field public static locationManager:Landroid/location/LocationManager;

.field public static longitude:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;

    .line 28
    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 27
    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->TAG:Ljava/lang/String;

    .line 29
    const-string v0, "ApplicationStatus"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    .line 30
    const-string v0, "getValues"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->getLocationToBridge:Ljava/lang/String;

    .line 31
    const-string v0, "Chat Window Maximized"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatMaximizedString:Ljava/lang/String;

    .line 32
    const-string v0, "Chat Window Minimized"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatMinimizedString:Ljava/lang/String;

    .line 33
    const-string v0, "Chat Foreground"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatForeground:Ljava/lang/String;

    .line 34
    const-string v0, "Chat Background"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatBackground:Ljava/lang/String;

    .line 36
    const-string v0, "chatEnded"

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatEndedString:Ljava/lang/String;

    .line 40
    const/4 v0, 0x0

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    .line 42
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertForEnableGps:Ljava/lang/String;

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->MessageForGps:Ljava/lang/String;

    .line 43
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertForEnabledGoogleLocationService:Ljava/lang/String;

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->MessageForGoogleLocationService:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static CheckGPSandGoogleLocationIsOn()V
    .locals 2

    .prologue
    .line 170
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 171
    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 170
    check-cast v0, Landroid/location/LocationManager;

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->locationManager:Landroid/location/LocationManager;

    .line 172
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->locationManager:Landroid/location/LocationManager;

    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 173
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->MessageForGps:Ljava/lang/String;

    invoke-static {v0}, Lcom/inc247/Location_Alert;->showGPSDisabledAlertToUser(Ljava/lang/String;)V

    .line 182
    :goto_0
    return-void

    .line 174
    :cond_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->locationManager:Landroid/location/LocationManager;

    .line 175
    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 177
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->MessageForGoogleLocationService:Ljava/lang/String;

    invoke-static {v0}, Lcom/inc247/Location_Alert;->ShowGoogleLocationAlert(Ljava/lang/String;)V

    goto :goto_0

    .line 180
    :cond_1
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->sendCurrentLocationToJS()V

    goto :goto_0
.end method

.method public static executeJS(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 54
    const-string v0, "javascript:"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    :try_start_0
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 57
    new-instance v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge$1;

    invoke-direct {v1, p0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge$1;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :goto_0
    return-void

    .line 63
    :catch_0
    move-exception v0

    .line 64
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 65
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0

    .line 69
    :cond_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->TAG:Ljava/lang/String;

    const-string v1, "Error in javascript String"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static get_current_longitude_latitude()V
    .locals 2

    .prologue
    .line 213
    new-instance v0, Lcom/gps/locationfinder/GPSTracker;

    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1}, Lcom/gps/locationfinder/GPSTracker;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->gps:Lcom/gps/locationfinder/GPSTracker;

    .line 214
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->gps:Lcom/gps/locationfinder/GPSTracker;

    iget-wide v0, v0, Lcom/gps/locationfinder/GPSTracker;->longitude:D

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->longitude:Ljava/lang/String;

    .line 215
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->gps:Lcom/gps/locationfinder/GPSTracker;

    iget-wide v0, v0, Lcom/gps/locationfinder/GPSTracker;->latitude:D

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->latitude:Ljava/lang/String;

    .line 216
    return-void
.end method

.method public static sendChatBackgroundCallbackToJS()V
    .locals 3

    .prologue
    .line 112
    :try_start_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    sget-object v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatBackground:Ljava/lang/String;

    .line 111
    invoke-static {v0, v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 113
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 120
    :goto_0
    return-void

    .line 115
    :catch_0
    move-exception v0

    .line 116
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 117
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static sendChatForegroundCallbackToJS()V
    .locals 3

    .prologue
    .line 126
    :try_start_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    sget-object v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatForeground:Ljava/lang/String;

    .line 125
    invoke-static {v0, v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 127
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 133
    :goto_0
    return-void

    .line 128
    :catch_0
    move-exception v0

    .line 129
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 130
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static sendChatMaximizedCallbackToJS()V
    .locals 3

    .prologue
    .line 81
    :try_start_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    sget-object v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatMaximizedString:Ljava/lang/String;

    .line 80
    invoke-static {v0, v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 82
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 89
    :goto_0
    return-void

    .line 83
    :catch_0
    move-exception v0

    .line 85
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 86
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static sendChatMinimizedCallbackToJS()V
    .locals 3

    .prologue
    .line 98
    :try_start_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    sget-object v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatMinimizedString:Ljava/lang/String;

    .line 97
    invoke-static {v0, v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 99
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    :goto_0
    return-void

    .line 100
    :catch_0
    move-exception v0

    .line 102
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 103
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static sendCurrentLocationToJS()V
    .locals 3

    .prologue
    .line 192
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->get_current_longitude_latitude()V

    .line 193
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    .line 195
    :try_start_0
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    const-string v1, "longitude : "

    sget-object v2, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->longitude:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 196
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    const-string v1, "latitude : "

    sget-object v2, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->latitude:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 198
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKJSToNativeBridge;->getLocation(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    return-void

    .line 199
    :catch_0
    move-exception v0

    .line 200
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 201
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static sendEndedCallbackToJS()V
    .locals 2

    .prologue
    .line 141
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->bridgeEventsCallback:Ljava/lang/String;

    sget-object v1, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->chatEndedString:Ljava/lang/String;

    .line 140
    invoke-static {v0, v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 142
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 143
    return-void
.end method

.method public static sendLocation()V
    .locals 1

    .prologue
    .line 153
    sget-boolean v0, Lcom/inc247/constants/ChatSDKConstants;->isUserPermitGps:Z

    if-nez v0, :cond_0

    .line 155
    const/4 v0, 0x0

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    .line 161
    :cond_0
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->CheckGPSandGoogleLocationIsOn()V

    .line 163
    return-void
.end method
