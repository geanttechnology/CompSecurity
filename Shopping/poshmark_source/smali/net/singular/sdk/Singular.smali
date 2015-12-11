.class public Lnet/singular/sdk/Singular;
.super Ljava/lang/Object;
.source "Singular.java"


# static fields
.field protected static controller:Lnet/singular/sdk/Controller;

.field protected static initialized:Z

.field protected static log:Lnet/singular/sdk/SingularLog;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    sput-object v0, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    .line 17
    const/4 v0, 0x0

    sput-boolean v0, Lnet/singular/sdk/Singular;->initialized:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appOpen(Landroid/net/Uri;)V
    .locals 7
    .param p0, "intentData"    # Landroid/net/Uri;

    .prologue
    .line 414
    const-string v3, "appOpen()"

    .line 416
    .local v3, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v3}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v4

    if-nez v4, :cond_1

    .line 433
    :cond_0
    :goto_0
    return-void

    .line 419
    :cond_1
    if-eqz p0, :cond_0

    .line 421
    :try_start_1
    sget-object v4, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v5, "DEEP_URL"

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v2

    .line 422
    .local v2, "event":Lorg/json/JSONObject;
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 423
    .local v0, "deep_link":Ljava/lang/String;
    const-string v4, "url"

    invoke-virtual {v2, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 424
    sget-object v4, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v4, v2}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 425
    .end local v0    # "deep_link":Ljava/lang/String;
    .end local v2    # "event":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 427
    .local v1, "e":Lorg/json/JSONException;
    :try_start_2
    sget-object v4, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v4}, Lnet/singular/sdk/Controller;->getLogger()Lnet/singular/sdk/SingularLog;

    move-result-object v4

    const-string v5, "singular_sdk"

    const-string v6, "Trying to log deep url open with an invalid intentData argument"

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 430
    .end local v1    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v1

    .line 431
    .local v1, "e":Ljava/lang/RuntimeException;
    invoke-static {v1, v3}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static checkInitialized(Ljava/lang/String;)Z
    .locals 4
    .param p0, "func_name"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 22
    sget-boolean v2, Lnet/singular/sdk/Singular;->initialized:Z

    if-nez v2, :cond_0

    .line 23
    const-string v2, "singular_sdk"

    const-string v3, "Tried calling %s without calling Singular.initialize() first"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v0

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static getSingularId()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 103
    const-string v1, "getSingularId()"

    .line 105
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 112
    :goto_0
    return-object v2

    .line 109
    :cond_0
    sget-object v3, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v3}, Lnet/singular/sdk/Controller;->getSingularId()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 110
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static getSingularLog()Lnet/singular/sdk/SingularLog;
    .locals 1

    .prologue
    .line 615
    sget-object v0, Lnet/singular/sdk/Singular;->log:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method

.method public static initialize(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lnet/singular/sdk/Singular;->initialize(Landroid/content/Context;Z)V

    .line 39
    return-void
.end method

.method public static initialize(Landroid/content/Context;Z)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sandbox"    # Z

    .prologue
    .line 50
    :try_start_0
    sget-boolean v2, Lnet/singular/sdk/Singular;->initialized:Z

    if-nez v2, :cond_0

    .line 51
    new-instance v1, Lnet/singular/sdk/NewInjector;

    invoke-direct {v1, p0, p1}, Lnet/singular/sdk/NewInjector;-><init>(Landroid/content/Context;Z)V

    .line 52
    .local v1, "injector":Lnet/singular/sdk/NewInjector;
    invoke-virtual {v1}, Lnet/singular/sdk/NewInjector;->getController()Lnet/singular/sdk/Controller;

    move-result-object v2

    sput-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    .line 53
    invoke-virtual {v1}, Lnet/singular/sdk/NewInjector;->getSingularLog()Lnet/singular/sdk/SingularLog;

    move-result-object v2

    sput-object v2, Lnet/singular/sdk/Singular;->log:Lnet/singular/sdk/SingularLog;

    .line 54
    const/4 v2, 0x1

    sput-boolean v2, Lnet/singular/sdk/Singular;->initialized:Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    .end local v1    # "injector":Lnet/singular/sdk/NewInjector;
    :cond_0
    :goto_0
    return-void

    .line 56
    :catch_0
    move-exception v0

    .line 57
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v2, "singular_sdk"

    const-string v3, "Initialization failed!"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private static logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V
    .locals 5
    .param p0, "e"    # Ljava/lang/RuntimeException;
    .param p1, "funcName"    # Ljava/lang/String;

    .prologue
    .line 620
    :try_start_0
    sget-object v0, Lnet/singular/sdk/Singular;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v2, "Singular:%s failed"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2, p0}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 622
    :goto_0
    return-void

    .line 621
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static onPause()V
    .locals 3

    .prologue
    .line 87
    const-string v1, "onPause()"

    .line 89
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 97
    :goto_0
    return-void

    .line 93
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->onPause()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 94
    :catch_0
    move-exception v0

    .line 95
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static onResume()V
    .locals 3

    .prologue
    .line 68
    const-string v1, "onResume()"

    .line 70
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 78
    :goto_0
    return-void

    .line 74
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->onResume()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 75
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static setCustomUserId(Ljava/lang/String;)V
    .locals 4
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 536
    const-string v1, "setCustomUserId()"

    .line 538
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 546
    :goto_0
    return-void

    .line 542
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "user_id"

    invoke-virtual {v2, v3, p0}, Lnet/singular/sdk/Controller;->setTemporalId(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 543
    :catch_0
    move-exception v0

    .line 544
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static setDefaultCurrency(Ljava/lang/String;)V
    .locals 3
    .param p0, "currency"    # Ljava/lang/String;

    .prologue
    .line 584
    const-string v1, "setDefaultCurrency()"

    .line 586
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 594
    :goto_0
    return-void

    .line 590
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2, p0}, Lnet/singular/sdk/Controller;->setDefaultCurrency(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 591
    :catch_0
    move-exception v0

    .line 592
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static setFacebookId(Ljava/lang/String;)V
    .locals 4
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 440
    const-string v1, "setFacebookId()"

    .line 442
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 450
    :goto_0
    return-void

    .line 446
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "fb_user_id"

    invoke-virtual {v2, v3, p0}, Lnet/singular/sdk/Controller;->setTemporalId(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 447
    :catch_0
    move-exception v0

    .line 448
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static setGoogleId(Ljava/lang/String;)V
    .locals 4
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 472
    const-string v1, "setGoogleId()"

    .line 474
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 482
    :goto_0
    return-void

    .line 478
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "google_user_id"

    invoke-virtual {v2, v3, p0}, Lnet/singular/sdk/Controller;->setTemporalId(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 479
    :catch_0
    move-exception v0

    .line 480
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static setTwitterId(Ljava/lang/String;)V
    .locals 4
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 504
    const-string v1, "setTwitterId()"

    .line 506
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 514
    :goto_0
    return-void

    .line 510
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "twitter_user_id"

    invoke-virtual {v2, v3, p0}, Lnet/singular/sdk/Controller;->setTemporalId(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 511
    :catch_0
    move-exception v0

    .line 512
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;)V
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;

    .prologue
    .line 141
    const/4 v1, 0x0

    :try_start_0
    check-cast v1, Ljava/lang/String;

    invoke-static {p0, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    :goto_0
    return-void

    .line 142
    :catch_0
    move-exception v0

    .line 143
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackEvent()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;

    .prologue
    .line 155
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, p1, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    return-void

    .line 156
    :catch_0
    move-exception v0

    .line 157
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackEvent()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;
    .param p2, "attribute2"    # Ljava/lang/String;

    .prologue
    .line 171
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, p1, p2, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 175
    :goto_0
    return-void

    .line 172
    :catch_0
    move-exception v0

    .line 173
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackEvent()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;
    .param p2, "attribute2"    # Ljava/lang/String;
    .param p3, "attribute3"    # Ljava/lang/String;

    .prologue
    .line 189
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, p1, p2, p3, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 193
    :goto_0
    return-void

    .line 190
    :catch_0
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackEvent()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;
    .param p2, "attribute2"    # Ljava/lang/String;
    .param p3, "attribute3"    # Ljava/lang/String;
    .param p4, "attribute4"    # Ljava/lang/String;

    .prologue
    .line 209
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    :try_start_0
    invoke-static/range {v0 .. v5}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 213
    :goto_0
    return-void

    .line 210
    :catch_0
    move-exception v6

    .line 211
    .local v6, "e":Ljava/lang/RuntimeException;
    const-string v0, "trackEvent()"

    invoke-static {v6, v0}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;
    .param p2, "attribute2"    # Ljava/lang/String;
    .param p3, "attribute3"    # Ljava/lang/String;
    .param p4, "attribute4"    # Ljava/lang/String;
    .param p5, "attribute5"    # Ljava/lang/String;

    .prologue
    .line 231
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v6}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 232
    return-void
.end method

.method private static trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 11
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "attribute1"    # Ljava/lang/String;
    .param p2, "attribute2"    # Ljava/lang/String;
    .param p3, "attribute3"    # Ljava/lang/String;
    .param p4, "attribute4"    # Ljava/lang/String;
    .param p5, "attribute5"    # Ljava/lang/String;
    .param p6, "internalEventName"    # Z

    .prologue
    .line 242
    const-string v10, "trackEvent()"

    .line 244
    .local v10, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v10}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v0

    if-nez v0, :cond_1

    .line 263
    :cond_0
    :goto_0
    return-void

    .line 248
    :cond_1
    if-eqz p0, :cond_0

    .line 253
    :try_start_1
    sget-object v0, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v6, p5

    move/from16 v7, p6

    invoke-virtual/range {v0 .. v7}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v9

    .line 255
    .local v9, "event":Lorg/json/JSONObject;
    sget-object v0, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0, v9}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 256
    .end local v9    # "event":Lorg/json/JSONObject;
    :catch_0
    move-exception v8

    .line 258
    .local v8, "e":Lorg/json/JSONException;
    :try_start_2
    sget-object v0, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0}, Lnet/singular/sdk/Controller;->getLogger()Lnet/singular/sdk/SingularLog;

    move-result-object v0

    const-string v1, "singular_sdk"

    const-string v2, "Trying to log revenue with an invalid amount"

    invoke-virtual {v0, v1, v2}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 260
    .end local v8    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v8

    .line 261
    .local v8, "e":Ljava/lang/RuntimeException;
    invoke-static {v8, v10}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackEvent(Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "eventProperties"    # Lorg/json/JSONObject;

    .prologue
    .line 124
    if-eqz p1, :cond_1

    .line 125
    :try_start_0
    instance-of v1, p1, Lorg/json/JSONObject;

    if-nez v1, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .end local p1    # "eventProperties":Lorg/json/JSONObject;
    :goto_0
    invoke-static {p0, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    :goto_1
    return-void

    .line 125
    .restart local p1    # "eventProperties":Lorg/json/JSONObject;
    :cond_0
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "eventProperties":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 127
    .restart local p1    # "eventProperties":Lorg/json/JSONObject;
    :cond_1
    invoke-static {p0}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 129
    .end local p1    # "eventProperties":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 130
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackEvent()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_1
.end method

.method static trackReferralId(Ljava/lang/String;)V
    .locals 9
    .param p0, "referralId"    # Ljava/lang/String;

    .prologue
    .line 602
    const-string v8, "trackReferralId()"

    .line 604
    .local v8, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v8}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 612
    :goto_0
    return-void

    .line 607
    :cond_0
    sget-object v0, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0, p0}, Lnet/singular/sdk/Controller;->setReferralId(Ljava/lang/String;)V

    .line 608
    const-string v0, "GOT_PLAY_REFERRER"

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static/range {v0 .. v6}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 609
    :catch_0
    move-exception v7

    .line 610
    .local v7, "e":Ljava/lang/RuntimeException;
    invoke-static {v7, v8}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(D)V
    .locals 4
    .param p0, "price"    # D

    .prologue
    .line 272
    const-string v1, "trackRevenue()"

    .line 274
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 281
    :goto_0
    return-void

    .line 277
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->getDefaultCurrency()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, p1, v2}, Lnet/singular/sdk/Singular;->trackRevenue(DLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 278
    :catch_0
    move-exception v0

    .line 279
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(DLjava/lang/String;)V
    .locals 4
    .param p0, "price"    # D
    .param p2, "currency"    # Ljava/lang/String;

    .prologue
    .line 291
    const/4 v1, 0x0

    const/4 v2, 0x0

    :try_start_0
    invoke-static {p0, p1, p2, v1, v2}, Lnet/singular/sdk/Singular;->trackRevenue(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 295
    :goto_0
    return-void

    .line 292
    :catch_0
    move-exception v0

    .line 293
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "trackRevenue()"

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(DLjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "price"    # D
    .param p2, "receipt"    # Ljava/lang/String;
    .param p3, "receiptSignature"    # Ljava/lang/String;

    .prologue
    .line 305
    const-string v1, "trackRevenue()"

    .line 307
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 315
    :goto_0
    return-void

    .line 311
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->getDefaultCurrency()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, p1, v2, p2, p3}, Lnet/singular/sdk/Singular;->trackRevenue(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 312
    :catch_0
    move-exception v0

    .line 313
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p0, "price"    # D
    .param p2, "currency"    # Ljava/lang/String;
    .param p3, "receipt"    # Ljava/lang/String;
    .param p4, "receiptSignature"    # Ljava/lang/String;

    .prologue
    .line 326
    const/4 v0, 0x0

    const/4 v1, 0x1

    move-wide v2, p0

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    :try_start_0
    invoke-static/range {v0 .. v6}, Lnet/singular/sdk/Singular;->trackRevenue(Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 330
    :goto_0
    return-void

    .line 327
    :catch_0
    move-exception v7

    .line 328
    .local v7, "e":Ljava/lang/RuntimeException;
    const-string v0, "trackRevenue()"

    invoke-static {v7, v0}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(Ljava/lang/String;ID)V
    .locals 4
    .param p0, "productId"    # Ljava/lang/String;
    .param p1, "quantity"    # I
    .param p2, "price"    # D

    .prologue
    .line 340
    const-string v1, "trackRevenue()"

    .line 342
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 350
    :goto_0
    return-void

    .line 346
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->getDefaultCurrency()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, p1, p2, p3, v2}, Lnet/singular/sdk/Singular;->trackRevenue(Ljava/lang/String;IDLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 347
    :catch_0
    move-exception v0

    .line 348
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(Ljava/lang/String;IDLjava/lang/String;)V
    .locals 8
    .param p0, "productId"    # Ljava/lang/String;
    .param p1, "quantity"    # I
    .param p2, "price"    # D
    .param p4, "currency"    # Ljava/lang/String;

    .prologue
    .line 361
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move v1, p1

    move-wide v2, p2

    move-object v4, p4

    :try_start_0
    invoke-static/range {v0 .. v6}, Lnet/singular/sdk/Singular;->trackRevenue(Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 365
    :goto_0
    return-void

    .line 362
    :catch_0
    move-exception v7

    .line 363
    .local v7, "e":Ljava/lang/RuntimeException;
    const-string v0, "trackRevenue()"

    invoke-static {v7, v0}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static trackRevenue(Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "productId"    # Ljava/lang/String;
    .param p1, "quantity"    # I
    .param p2, "price"    # D
    .param p4, "currency"    # Ljava/lang/String;
    .param p5, "receipt"    # Ljava/lang/String;
    .param p6, "receiptSignature"    # Ljava/lang/String;

    .prologue
    .line 378
    const-string v2, "trackRevenue()"

    .line 380
    .local v2, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v2}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v3

    if-nez v3, :cond_0

    .line 400
    :goto_0
    return-void

    .line 385
    :cond_0
    :try_start_1
    sget-object v3, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v4, "REVENUE"

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v1

    .line 386
    .local v1, "event":Lorg/json/JSONObject;
    const-string v3, "product_id"

    invoke-virtual {v1, v3, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 387
    const-string v3, "quantity"

    invoke-virtual {v1, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 388
    const-string v3, "revenue"

    invoke-virtual {v1, v3, p2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 389
    const-string v3, "currency"

    invoke-virtual {v1, v3, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 390
    const-string v3, "purchase_receipt"

    invoke-virtual {v1, v3, p5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 391
    const-string v3, "purchase_receipt_signature"

    invoke-virtual {v1, v3, p6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 392
    sget-object v3, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v3, v1}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 393
    .end local v1    # "event":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 395
    .local v0, "e":Lorg/json/JSONException;
    :try_start_2
    sget-object v3, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v3}, Lnet/singular/sdk/Controller;->getLogger()Lnet/singular/sdk/SingularLog;

    move-result-object v3

    const-string v4, "singular_sdk"

    const-string v5, "Trying to log revenue with an invalid price"

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 397
    .end local v0    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v0

    .line 398
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v2}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static unsetAllUserIds()V
    .locals 3

    .prologue
    .line 567
    const-string v1, "unsetAllUserIds()"

    .line 569
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 577
    :goto_0
    return-void

    .line 573
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2}, Lnet/singular/sdk/Controller;->clearTemporalIds()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 574
    :catch_0
    move-exception v0

    .line 575
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static unsetCustomUserId()V
    .locals 4

    .prologue
    .line 551
    const-string v1, "unsetCustomUserId()"

    .line 553
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 561
    :goto_0
    return-void

    .line 557
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "user_id"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/Controller;->unsetTemporalId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 558
    :catch_0
    move-exception v0

    .line 559
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static unsetFacebookId()V
    .locals 4

    .prologue
    .line 455
    const-string v1, "unsetFacebookId()"

    .line 457
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 465
    :goto_0
    return-void

    .line 461
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "fb_user_id"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/Controller;->unsetTemporalId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 462
    :catch_0
    move-exception v0

    .line 463
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static unsetGoogleId()V
    .locals 4

    .prologue
    .line 487
    const-string v1, "unsetGoogleId()"

    .line 489
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 497
    :goto_0
    return-void

    .line 493
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "google_user_id"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/Controller;->unsetTemporalId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 494
    :catch_0
    move-exception v0

    .line 495
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static unsetTwitterId()V
    .locals 4

    .prologue
    .line 519
    const-string v1, "unsetTwitterId()"

    .line 521
    .local v1, "funcName":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lnet/singular/sdk/Singular;->checkInitialized(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 529
    :goto_0
    return-void

    .line 525
    :cond_0
    sget-object v2, Lnet/singular/sdk/Singular;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "twitter_user_id"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/Controller;->unsetTemporalId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 526
    :catch_0
    move-exception v0

    .line 527
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->logRuntimeError(Ljava/lang/RuntimeException;Ljava/lang/String;)V

    goto :goto_0
.end method
