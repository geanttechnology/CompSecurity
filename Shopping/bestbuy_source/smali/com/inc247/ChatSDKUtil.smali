.class public final Lcom/inc247/ChatSDKUtil;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/inc247/ChatSDKUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/inc247/ChatSDKUtil;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convertDpToPixel(I)I
    .locals 3

    .prologue
    .line 196
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 197
    const/4 v1, 0x1

    int-to-float v2, p0

    .line 198
    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 197
    invoke-static {v1, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    .line 199
    float-to-int v0, v0

    return v0
.end method

.method public static createAgentAvailabilityURLString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 45
    const-string v0, "%s?queueId=%s&accountId=%s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    const/4 v2, 0x2

    aput-object p2, v1, v2

    .line 44
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 46
    return-object v0
.end method

.method public static createAgentAvailabilityURLStringFromCAServerUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 51
    return-object p0
.end method

.method public static createExecJSString(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 64
    const-string v0, "javascript:%s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 65
    return-object v0
.end method

.method public static createExecJSString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 79
    const-string v0, "javascript:%s(\'%s\')"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    .line 80
    aput-object p1, v1, v2

    .line 79
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 81
    return-object v0
.end method

.method public static createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 100
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 102
    :try_start_0
    const-string v0, "id"

    invoke-virtual {v1, v0, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 103
    const-string v0, "result"

    invoke-virtual {v1, v0, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 104
    const-string v0, "action"

    invoke-virtual {v1, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 105
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 106
    const-string v2, "data"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 112
    :goto_0
    const-string v0, "javascript:window.NativeBridge._complete(\'%s\')"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 113
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v3

    .line 111
    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 114
    return-object v0

    .line 107
    :catch_0
    move-exception v0

    .line 108
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 109
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "{\'Error\':\'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\'}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 133
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 135
    :try_start_0
    const-string v0, "id"

    invoke-virtual {v1, v0, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 136
    const-string v0, "result"

    invoke-virtual {v1, v0, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 137
    const-string v0, "action"

    invoke-virtual {v1, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 138
    const-string v0, "data"

    invoke-virtual {v1, v0, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    :goto_0
    const-string v0, "javascript:window.NativeBridge._complete(\'%s\')"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 145
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v3

    .line 143
    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 146
    return-object v0

    .line 139
    :catch_0
    move-exception v0

    .line 140
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 141
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "{\'Error\':\'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\'}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getBadgeHeight()I
    .locals 1

    .prologue
    .line 235
    sget v0, Lcom/inc247/constants/ChatSDKConstants;->BADGE_HEIGHT_DP:F

    float-to-int v0, v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v0

    return v0
.end method

.method public static getBadgeMargin()I
    .locals 1

    .prologue
    .line 244
    sget v0, Lcom/inc247/constants/ChatSDKConstants;->BADGE_MARGIN_DP:F

    float-to-int v0, v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v0

    return v0
.end method

.method public static getBadgeWidth()I
    .locals 1

    .prologue
    .line 226
    sget v0, Lcom/inc247/constants/ChatSDKConstants;->BADGE_WIDTH_DP:F

    float-to-int v0, v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v0

    return v0
.end method

.method public static getButtonHideAnimation()Landroid/view/animation/TranslateAnimation;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 380
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 381
    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 382
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v3

    iget-object v3, v3, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget v3, v3, Landroid/content/res/Configuration;->orientation:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_5

    .line 383
    const-string v2, "top-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 384
    const-string v2, "middle-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 385
    const-string v2, "bottom-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 386
    :cond_0
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    move v2, v0

    move v0, v1

    .line 412
    :goto_0
    new-instance v3, Landroid/view/animation/TranslateAnimation;

    int-to-float v4, v1

    .line 413
    int-to-float v2, v2

    int-to-float v1, v1

    int-to-float v0, v0

    .line 412
    invoke-direct {v3, v4, v2, v1, v0}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 415
    return-object v3

    .line 387
    :cond_1
    const-string v2, "top-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 388
    const-string v2, "middle-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 389
    const-string v2, "bottom-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 390
    :cond_2
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    neg-int v0, v0

    move v2, v0

    move v0, v1

    .line 391
    goto :goto_0

    :cond_3
    const-string v2, "top-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 392
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    neg-int v0, v0

    move v2, v1

    .line 393
    goto :goto_0

    :cond_4
    const-string v2, "bottom-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 394
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    move v2, v1

    .line 396
    goto :goto_0

    .line 397
    :cond_5
    const-string v0, "top-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 398
    const-string v0, "middle-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 399
    const-string v0, "bottom-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 400
    :cond_6
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    move v2, v0

    move v0, v1

    .line 401
    goto :goto_0

    :cond_7
    const-string v0, "top-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 402
    const-string v0, "middle-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 403
    const-string v0, "bottom-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 404
    :cond_8
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    neg-int v0, v0

    move v2, v0

    move v0, v1

    .line 405
    goto/16 :goto_0

    :cond_9
    const-string v0, "top-center"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 406
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    neg-int v0, v0

    move v2, v1

    .line 407
    goto/16 :goto_0

    :cond_a
    const-string v0, "bottom-center"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 408
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    move v2, v1

    goto/16 :goto_0

    :cond_b
    move v0, v1

    move v2, v1

    goto/16 :goto_0
.end method

.method public static getButtonShowAnimation()Landroid/view/animation/TranslateAnimation;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 426
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 427
    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 428
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v3

    iget-object v3, v3, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget v3, v3, Landroid/content/res/Configuration;->orientation:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_5

    .line 429
    const-string v2, "top-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 430
    const-string v2, "middle-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 431
    const-string v2, "bottom-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 432
    :cond_0
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    move v2, v0

    move v0, v1

    .line 458
    :goto_0
    new-instance v3, Landroid/view/animation/TranslateAnimation;

    int-to-float v2, v2

    .line 459
    int-to-float v4, v1

    int-to-float v0, v0

    int-to-float v1, v1

    .line 458
    invoke-direct {v3, v2, v4, v0, v1}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 461
    return-object v3

    .line 433
    :cond_1
    const-string v2, "top-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 434
    const-string v2, "middle-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 435
    const-string v2, "bottom-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 436
    :cond_2
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    neg-int v0, v0

    move v2, v0

    move v0, v1

    .line 437
    goto :goto_0

    :cond_3
    const-string v2, "top-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 438
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    neg-int v0, v0

    move v2, v1

    .line 439
    goto :goto_0

    :cond_4
    const-string v2, "bottom-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 440
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    move v2, v1

    .line 442
    goto :goto_0

    .line 443
    :cond_5
    const-string v0, "top-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 444
    const-string v0, "middle-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 445
    const-string v0, "bottom-right"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 446
    :cond_6
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    move v2, v0

    move v0, v1

    .line 447
    goto :goto_0

    :cond_7
    const-string v0, "top-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 448
    const-string v0, "middle-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 449
    const-string v0, "bottom-left"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 450
    :cond_8
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v0

    neg-int v0, v0

    move v2, v0

    move v0, v1

    .line 451
    goto/16 :goto_0

    :cond_9
    const-string v0, "top-center"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 452
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    neg-int v0, v0

    move v2, v1

    .line 453
    goto/16 :goto_0

    :cond_a
    const-string v0, "bottom-center"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 454
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v0

    move v2, v1

    goto/16 :goto_0

    :cond_b
    move v0, v1

    move v2, v1

    goto/16 :goto_0
.end method

.method public static getMarginParams()[I
    .locals 12

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 276
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getStatusBarHeight()I

    move-result v1

    .line 277
    new-array v2, v11, [I

    .line 278
    const/4 v0, 0x4

    new-array v3, v0, [I

    .line 279
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v4

    .line 280
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v5

    .line 281
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getScreenDimentions()[I

    move-result-object v0

    aget v6, v0, v9

    .line 282
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getScreenDimentions()[I

    move-result-object v0

    aget v7, v0, v10

    .line 285
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v10, :cond_0

    .line 286
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 291
    :goto_0
    const-string v8, "top-left"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 292
    aput v9, v2, v9

    .line 293
    aput v9, v2, v10

    .line 324
    :goto_1
    aget v0, v2, v9

    aput v0, v3, v9

    .line 325
    aget v0, v2, v10

    add-int/2addr v0, v1

    aput v0, v3, v10

    .line 326
    aput v9, v3, v11

    .line 327
    const/4 v0, 0x3

    aput v9, v3, v0

    .line 329
    return-object v3

    .line 288
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    goto :goto_0

    .line 294
    :cond_1
    const-string v8, "top-right"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 295
    sub-int v0, v6, v4

    aput v0, v2, v9

    .line 296
    aput v9, v2, v10

    goto :goto_1

    .line 297
    :cond_2
    const-string v8, "top-center"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 298
    sub-int v0, v6, v4

    div-int/lit8 v0, v0, 0x2

    .line 299
    div-int/lit8 v4, v4, 0x2

    sub-int/2addr v0, v4

    .line 298
    aput v0, v2, v9

    .line 300
    aput v9, v2, v10

    goto :goto_1

    .line 301
    :cond_3
    const-string v8, "middle-left"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 302
    aput v9, v2, v9

    .line 303
    sub-int v0, v7, v5

    div-int/lit8 v0, v0, 0x2

    .line 304
    div-int/lit8 v4, v5, 0x2

    sub-int/2addr v0, v4

    add-int/2addr v0, v1

    .line 303
    aput v0, v2, v10

    goto :goto_1

    .line 305
    :cond_4
    const-string v8, "middle-right"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 306
    sub-int v0, v6, v4

    aput v0, v2, v9

    .line 307
    sub-int v0, v7, v5

    div-int/lit8 v0, v0, 0x2

    .line 308
    div-int/lit8 v4, v5, 0x2

    sub-int/2addr v0, v4

    add-int/2addr v0, v1

    .line 307
    aput v0, v2, v10

    goto :goto_1

    .line 309
    :cond_5
    const-string v8, "bottom-left"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 310
    aput v9, v2, v9

    .line 311
    add-int v0, v1, v5

    sub-int v0, v7, v0

    aput v0, v2, v10

    goto :goto_1

    .line 312
    :cond_6
    const-string v8, "bottom-center"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 313
    sub-int v0, v6, v4

    div-int/lit8 v0, v0, 0x2

    .line 314
    div-int/lit8 v5, v4, 0x2

    sub-int/2addr v0, v5

    .line 313
    aput v0, v2, v9

    .line 315
    add-int v0, v1, v4

    sub-int v0, v7, v0

    aput v0, v2, v10

    goto/16 :goto_1

    .line 316
    :cond_7
    const-string v8, "bottom-right"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 317
    sub-int v0, v6, v4

    aput v0, v2, v9

    .line 318
    add-int v0, v1, v5

    sub-int v0, v7, v0

    aput v0, v2, v10

    goto/16 :goto_1

    .line 320
    :cond_8
    sget-object v0, Lcom/inc247/ChatSDKUtil;->TAG:Ljava/lang/String;

    const-string v4, "Invalid Parameter in XML"

    invoke-static {v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 321
    aput v9, v2, v9

    .line 322
    aput v9, v2, v10

    goto/16 :goto_1
.end method

.method public static getMarginParamsForBadge()[I
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 339
    const/4 v0, 0x4

    new-array v0, v0, [I

    .line 340
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v1

    .line 343
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v6, :cond_1

    .line 344
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 349
    :goto_0
    const-string v2, "top-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 350
    const-string v2, "middle-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 351
    const-string v2, "bottom-right"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 352
    :cond_0
    aget v0, v1, v5

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v2

    add-int/2addr v0, v2

    aput v0, v1, v5

    .line 353
    aget v0, v1, v6

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v2

    add-int/2addr v0, v2

    aput v0, v1, v6

    .line 369
    :goto_1
    return-object v1

    .line 346
    :cond_1
    sget-object v0, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    goto :goto_0

    .line 354
    :cond_2
    const-string v2, "top-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 355
    const-string v2, "middle-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 356
    const-string v2, "bottom-left"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 357
    :cond_3
    aget v0, v1, v5

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v2

    add-int/2addr v0, v2

    aput v0, v1, v5

    .line 358
    aget v0, v1, v6

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v2

    add-int/2addr v0, v2

    aput v0, v1, v6

    goto :goto_1

    .line 359
    :cond_4
    const-string v2, "top-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 360
    const-string v2, "bottom-center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 361
    :cond_5
    aget v0, v1, v5

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v2

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeWidth()I

    move-result v3

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v4

    add-int/2addr v3, v4

    sub-int/2addr v2, v3

    add-int/2addr v0, v2

    aput v0, v1, v5

    .line 362
    aget v0, v1, v6

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeMargin()I

    move-result v2

    add-int/2addr v0, v2

    aput v0, v1, v6

    goto :goto_1

    .line 364
    :cond_6
    sget-object v0, Lcom/inc247/ChatSDKUtil;->TAG:Ljava/lang/String;

    const-string v2, "Invalid Parameter in XML"

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 365
    aput v5, v1, v5

    .line 366
    aput v5, v1, v6

    goto :goto_1
.end method

.method public static getMaximizeButtonHeight()I
    .locals 1

    .prologue
    .line 217
    sget v0, Lcom/inc247/constants/ChatSDKConstants;->MAXIMIZE_BUTTON_HEIGHT_DP:F

    float-to-int v0, v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v0

    return v0
.end method

.method public static getMaximizeButtonWidth()I
    .locals 1

    .prologue
    .line 208
    sget v0, Lcom/inc247/constants/ChatSDKConstants;->MAXIMIZE_BUTTON_WIDTH_DP:F

    float-to-int v0, v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v0

    return v0
.end method

.method public static getScreenDimentions()[I
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 254
    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 255
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    .line 256
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 257
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xd

    if-lt v2, v3, :cond_0

    .line 258
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    .line 259
    invoke-virtual {v1, v2}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 260
    iget v1, v2, Landroid/graphics/Point;->x:I

    aput v1, v0, v4

    .line 261
    iget v1, v2, Landroid/graphics/Point;->y:I

    aput v1, v0, v5

    .line 266
    :goto_0
    return-object v0

    .line 263
    :cond_0
    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v2

    aput v2, v0, v4

    .line 264
    invoke-virtual {v1}, Landroid/view/Display;->getHeight()I

    move-result v1

    aput v1, v0, v5

    goto :goto_0
.end method

.method public static getStatusBarHeight()I
    .locals 2

    .prologue
    .line 181
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 182
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    .line 183
    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 184
    iget v0, v0, Landroid/graphics/Rect;->top:I

    .line 185
    return v0
.end method

.method public static isTablet(Landroid/content/Context;)Z
    .locals 2

    .prologue
    .line 473
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v0, 0xf

    const/4 v1, 0x3

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static sendLocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 161
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 163
    :try_start_0
    const-string v0, "Longitude"

    invoke-virtual {v1, v0, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 164
    const-string v0, "Latitude"

    invoke-virtual {v1, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 170
    :goto_0
    const-string v0, "javascript:%s(%s)"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    const/4 v3, 0x1

    .line 171
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v3

    .line 170
    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 172
    return-object v0

    .line 166
    :catch_0
    move-exception v0

    .line 167
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 168
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "{\'Error\':\'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\'}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method
