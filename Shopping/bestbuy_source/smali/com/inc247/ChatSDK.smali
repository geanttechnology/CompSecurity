.class public Lcom/inc247/ChatSDK;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;

.field public static chatDialog:Landroid/app/Dialog;

.field public static contactList:Lorg/w3c/dom/NodeList;

.field public static doc:Lorg/w3c/dom/Document;

.field public static documentDataForReturn:Lorg/w3c/dom/Document;

.field public static height_landscape:F

.field public static isAppDeveloperWantToAccessLocationService:Z

.field public static queue:Ljava/lang/String;

.field public static queueFromServerData:Ljava/lang/String;

.field private static self:Lcom/inc247/ChatSDK;

.field public static url:Ljava/lang/String;

.field public static width_landscape:F


# instance fields
.field public activity:Landroid/app/Activity;

.field agentAvailabilityURLWithParams:Ljava/lang/String;

.field private badgeLayout:Landroid/widget/LinearLayout;

.field private badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

.field private badgeView:Lcom/inc247/ChatSDKBadgeView;

.field private buttonLayout:Landroid/widget/LinearLayout;

.field private buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

.field public callback:Lcom/inc247/ChatSDKEventsCallback;

.field public chatWebView:Lcom/inc247/ChatSDKWebView;

.field context:Landroid/content/Context;

.field public contextInfo:Lorg/json/JSONObject;

.field deviceInches:D

.field public height:I

.field public height_portrait:F

.field private maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

.field private maximizedView:Z

.field notCalled:Z

.field public padding_left_landscape:F

.field public padding_left_portrait:F

.field public padding_top_landscape:F

.field public padding_top_portrait:F

.field progressDialog:Landroid/app/ProgressDialog;

.field queueIdAndUrl:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public queueIdFromAppDeveloper:Lorg/json/JSONObject;

.field screenInches:D

.field public width:I

.field public width_portrait:F


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 69
    const-class v0, Lcom/inc247/ChatSDK;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/inc247/ChatSDK;->TAG:Ljava/lang/String;

    .line 71
    sput-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    .line 107
    sput-object v1, Lcom/inc247/ChatSDK;->documentDataForReturn:Lorg/w3c/dom/Document;

    .line 109
    const-string v0, ""

    sput-object v0, Lcom/inc247/ChatSDK;->queue:Ljava/lang/String;

    .line 113
    const-string v0, ""

    sput-object v0, Lcom/inc247/ChatSDK;->url:Ljava/lang/String;

    .line 123
    const/4 v0, 0x0

    sput-boolean v0, Lcom/inc247/ChatSDK;->isAppDeveloperWantToAccessLocationService:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-boolean v1, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    .line 70
    iput-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    .line 72
    iput-object v0, p0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    .line 73
    iput-object v0, p0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 75
    iput-boolean v1, p0, Lcom/inc247/ChatSDK;->notCalled:Z

    .line 76
    iput-object v0, p0, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    .line 77
    iput-object v0, p0, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    .line 79
    iput-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    .line 80
    iput-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    .line 81
    iput-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    .line 82
    iput-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    .line 83
    iput-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 84
    iput-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 120
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/inc247/ChatSDK;->queueIdAndUrl:Ljava/util/HashMap;

    .line 130
    return-void
.end method

.method private GetDeviceInch()V
    .locals 6

    .prologue
    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    .line 956
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 957
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 958
    invoke-virtual {v1, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 959
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v1, v1

    iget v2, v0, Landroid/util/DisplayMetrics;->xdpi:F

    div-float/2addr v1, v2

    float-to-double v2, v1

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    .line 960
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-float v1, v1

    iget v0, v0, Landroid/util/DisplayMetrics;->ydpi:F

    div-float v0, v1, v0

    float-to-double v0, v0

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    .line 961
    add-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/inc247/ChatSDK;->screenInches:D

    .line 962
    iget-wide v0, p0, Lcom/inc247/ChatSDK;->screenInches:D

    iput-wide v0, p0, Lcom/inc247/ChatSDK;->deviceInches:D

    .line 963
    return-void
.end method

.method static synthetic access$0()Lcom/inc247/ChatSDK;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    return-object v0
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/inc247/ChatSDK;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKMaximizeButton;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    return-object v0
.end method

.method static synthetic access$3(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 601
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->showMaximizeButton()V

    return-void
.end method

.method static synthetic access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$5(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKBadgeView;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    return-object v0
.end method

.method public static getSDKInstance()Lcom/inc247/ChatSDK;
    .locals 2

    .prologue
    .line 138
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    if-eqz v0, :cond_0

    .line 139
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    .line 143
    :goto_0
    return-object v0

    .line 141
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDK;->TAG:Ljava/lang/String;

    .line 142
    const-string v1, "Please call initializeChat before calling any other method from ChatSDK"

    .line 141
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 143
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private get_landscape_padding_parameters()V
    .locals 1

    .prologue
    .line 1022
    .line 1023
    sget-object v0, Lcom/inc247/ChatSDKResources;->PADDING_TOP_LANDSCAPE:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 1022
    iput v0, p0, Lcom/inc247/ChatSDK;->padding_top_landscape:F

    .line 1025
    sget-object v0, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 1024
    iput v0, p0, Lcom/inc247/ChatSDK;->padding_left_landscape:F

    .line 1026
    return-void
.end method

.method public static get_landscape_parameters()V
    .locals 3

    .prologue
    .line 1000
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDKResources;->WIDTH_LANDSCAPE:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 999
    sput v0, Lcom/inc247/ChatSDK;->width_landscape:F

    .line 1002
    sget-object v0, Lcom/inc247/ChatSDKResources;->HEIGHT_LANDSCAPE:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 1001
    sput v0, Lcom/inc247/ChatSDK;->height_landscape:F
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1010
    :goto_0
    return-void

    .line 1004
    :catch_0
    move-exception v0

    .line 1005
    invoke-virtual {v0}, Ljava/lang/NumberFormatException;->printStackTrace()V

    .line 1007
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

    .line 1006
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private get_portrait_padding_parameters()V
    .locals 1

    .prologue
    .line 1038
    .line 1039
    sget-object v0, Lcom/inc247/ChatSDKResources;->PADDING_TOP_PORTRAIT:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 1038
    iput v0, p0, Lcom/inc247/ChatSDK;->padding_top_portrait:F

    .line 1041
    sget-object v0, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_PORTRAIT:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 1040
    iput v0, p0, Lcom/inc247/ChatSDK;->padding_left_portrait:F

    .line 1042
    return-void
.end method

.method private get_portrait_parameters()V
    .locals 3

    .prologue
    .line 975
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDKResources;->WIDTH_PORTRAIT:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/inc247/ChatSDK;->width_portrait:F

    .line 976
    iget v0, p0, Lcom/inc247/ChatSDK;->width_portrait:F

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/inc247/ChatSDK;->width_portrait:F

    .line 978
    sget-object v0, Lcom/inc247/ChatSDKResources;->HEIGHT_PORTRAIT:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 977
    iput v0, p0, Lcom/inc247/ChatSDK;->height_portrait:F

    .line 979
    iget v0, p0, Lcom/inc247/ChatSDK;->height_portrait:F

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/inc247/ChatSDK;->height_portrait:F
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 986
    :goto_0
    return-void

    .line 980
    :catch_0
    move-exception v0

    .line 981
    invoke-virtual {v0}, Ljava/lang/NumberFormatException;->printStackTrace()V

    .line 983
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

    .line 982
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private hideDialog()V
    .locals 1

    .prologue
    .line 560
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    .line 561
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 562
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    .line 564
    :cond_0
    return-void
.end method

.method private hideMaximizeButton()V
    .locals 0

    .prologue
    .line 625
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideWithAnimation()V

    .line 626
    return-void
.end method

.method private hideMaximizedChat()V
    .locals 0

    .prologue
    .line 553
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideDialog()V

    .line 554
    return-void
.end method

.method private hideWithAnimation()V
    .locals 4

    .prologue
    .line 866
    .line 867
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getButtonHideAnimation()Landroid/view/animation/TranslateAnimation;

    move-result-object v0

    .line 869
    sget v1, Lcom/inc247/constants/ChatSDKConstants;->maximizeButtonAnimationDuration:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 870
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setFillAfter(Z)V

    .line 871
    new-instance v1, Lcom/inc247/ChatSDK$6;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$6;-><init>(Lcom/inc247/ChatSDK;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 890
    iget-object v1, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKMaximizeButton;->startAnimation(Landroid/view/animation/Animation;)V

    .line 891
    return-void
.end method

.method public static initializeChat(Landroid/app/Activity;)Lcom/inc247/ChatSDK;
    .locals 2

    .prologue
    .line 153
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    if-nez v0, :cond_0

    .line 154
    new-instance v0, Lcom/inc247/ChatSDK;

    invoke-direct {v0}, Lcom/inc247/ChatSDK;-><init>()V

    sput-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    .line 155
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    iput-object v1, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    .line 156
    invoke-static {p0}, Lcom/inc247/ChatSDKResources;->initializeValues(Landroid/content/Context;)V

    .line 157
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iput-object p0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 159
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    return-object v0
.end method

.method private makeNotifView()V
    .locals 9

    .prologue
    const/16 v3, 0x12

    const/16 v8, 0xa

    const/4 v7, 0x5

    .line 381
    const-string v0, "Fade Function"

    const-string v1, "Chat SDK Fade Function Enters"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 382
    new-instance v0, Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    .line 383
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 384
    const/high16 v1, -0x10000

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 385
    const/high16 v1, 0x42b40000    # 90.0f

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 386
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 387
    invoke-static {v3}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v2

    .line 388
    invoke-static {v3}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 386
    iput-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 389
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 390
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    .line 391
    invoke-static {v7}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v3

    .line 390
    add-int/2addr v2, v3

    .line 392
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v3

    const/4 v4, 0x1

    aget v3, v3, v4

    .line 393
    const/4 v4, 0x7

    invoke-static {v4}, Lcom/inc247/ChatSDKUtil;->convertDpToPixel(I)I

    move-result v4

    .line 392
    add-int/2addr v3, v4

    .line 394
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v4

    const/4 v5, 0x2

    aget v4, v4, v5

    .line 395
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v5

    const/4 v6, 0x3

    aget v5, v5, v6

    .line 389
    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 397
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v8, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 398
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v1, v7, v7, v7, v7}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 400
    new-instance v1, Lcom/inc247/ChatSDKBadgeView;

    iget-object v2, p0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-direct {v1, v2}, Lcom/inc247/ChatSDKBadgeView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    .line 401
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    const-string v2, "0"

    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKBadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 402
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    const/high16 v2, 0x41400000    # 12.0f

    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKBadgeView;->setTextSize(F)V

    .line 403
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKBadgeView;->setTextColor(I)V

    .line 405
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-ge v1, v2, :cond_0

    .line 406
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKBadgeView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 410
    :goto_0
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    iget-object v2, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v0, v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 411
    return-void

    .line 408
    :cond_0
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKBadgeView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private resetBadge()V
    .locals 2

    .prologue
    .line 922
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    if-eqz v0, :cond_0

    .line 923
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    const-string v1, "0"

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKBadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 924
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 926
    :cond_0
    return-void
.end method

.method private resetBadgeViewPosition()V
    .locals 6

    .prologue
    .line 824
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeHeight()I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 825
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getBadgeWidth()I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 826
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParamsForBadge()[I

    move-result-object v1

    const/4 v2, 0x0

    aget v1, v1, v2

    .line 827
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParamsForBadge()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    .line 828
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParamsForBadge()[I

    move-result-object v3

    const/4 v4, 0x2

    aget v3, v3, v4

    .line 829
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParamsForBadge()[I

    move-result-object v4

    const/4 v5, 0x3

    aget v4, v4, v5

    .line 826
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 831
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKBadgeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 833
    return-void
.end method

.method private resetMaximizeButtonPosition()V
    .locals 6

    .prologue
    .line 810
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 811
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 812
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v1

    const/4 v2, 0x0

    aget v1, v1, v2

    .line 813
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    .line 814
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v3

    const/4 v4, 0x2

    aget v3, v3, v4

    .line 815
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v4

    const/4 v5, 0x3

    aget v4, v4, v5

    .line 812
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 816
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 818
    return-void
.end method

.method private showMaximizeButton()V
    .locals 3

    .prologue
    .line 602
    sget-object v0, Lcom/inc247/ChatSDKResources;->CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

    const-string v1, "false"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 603
    iget-object v0, p0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 604
    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    .line 603
    check-cast v0, Landroid/view/ViewGroup;

    .line 605
    iget-object v1, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 606
    iget-object v1, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewManager;

    .line 607
    iget-object v2, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-interface {v1, v2}, Landroid/view/ViewManager;->removeView(Landroid/view/View;)V

    .line 609
    :cond_0
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetMaximizeButtonPosition()V

    .line 611
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 612
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewManager;

    iget-object v2, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    invoke-interface {v1, v2}, Landroid/view/ViewManager;->removeView(Landroid/view/View;)V

    .line 614
    :cond_1
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetBadgeViewPosition()V

    .line 615
    iget-object v1, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 616
    iget-object v1, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 617
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->showWithAnimation()V

    .line 619
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    .line 620
    return-void
.end method

.method private showMaximizedChat()V
    .locals 2

    .prologue
    .line 414
    sget-boolean v0, Lcom/inc247/ChatSDK;->isAppDeveloperWantToAccessLocationService:Z

    if-eqz v0, :cond_0

    .line 415
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->sendLocation()V

    .line 417
    :cond_0
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 418
    invoke-virtual {p0}, Lcom/inc247/ChatSDK;->showDialog()V

    .line 419
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetBadge()V

    .line 420
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKWebView;->setVisibility(I)V

    .line 421
    return-void
.end method

.method private showWithAnimation()V
    .locals 4

    .prologue
    .line 839
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 840
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 842
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getButtonShowAnimation()Landroid/view/animation/TranslateAnimation;

    move-result-object v0

    .line 844
    sget v1, Lcom/inc247/constants/ChatSDKConstants;->maximizeButtonAnimationDuration:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 845
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setFillAfter(Z)V

    .line 846
    new-instance v1, Lcom/inc247/ChatSDK$5;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$5;-><init>(Lcom/inc247/ChatSDK;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 859
    iget-object v1, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKMaximizeButton;->startAnimation(Landroid/view/animation/Animation;)V

    .line 860
    return-void
.end method


# virtual methods
.method public addChat(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 574
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iput-object p1, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 575
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    if-eqz v0, :cond_1

    .line 577
    iget-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    if-nez v0, :cond_0

    .line 584
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 585
    new-instance v1, Lcom/inc247/ChatSDK$2;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$2;-><init>(Lcom/inc247/ChatSDK;)V

    .line 590
    const-wide/16 v2, 0xc8

    .line 585
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 598
    :cond_0
    :goto_0
    return-void

    .line 594
    :cond_1
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 595
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 594
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 596
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    goto :goto_0
.end method

.method public checkAgentAvailability()V
    .locals 4

    .prologue
    .line 638
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDK;->queueFromServerData:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 640
    sget-object v0, Lcom/inc247/ChatSDK;->queueFromServerData:Ljava/lang/String;

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createAgentAvailabilityURLStringFromCAServerUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 639
    iput-object v0, p0, Lcom/inc247/ChatSDK;->agentAvailabilityURLWithParams:Ljava/lang/String;

    .line 648
    :goto_0
    new-instance v0, Lcom/inc247/ChatSDKAgentAvailibilityHelper;

    invoke-direct {v0}, Lcom/inc247/ChatSDKAgentAvailibilityHelper;-><init>()V

    .line 649
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/inc247/ChatSDK;->agentAvailabilityURLWithParams:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKAgentAvailibilityHelper;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 657
    :goto_1
    return-void

    .line 644
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDKResources;->AGENTAVAILABILITY_URL:Ljava/lang/String;

    .line 645
    sget-object v1, Lcom/inc247/ChatSDKResources;->QUEUE_ID:Ljava/lang/String;

    .line 646
    sget-object v2, Lcom/inc247/ChatSDKResources;->ACCOUNT_ID:Ljava/lang/String;

    .line 643
    invoke-static {v0, v1, v2}, Lcom/inc247/ChatSDKUtil;->createAgentAvailabilityURLString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 642
    iput-object v0, p0, Lcom/inc247/ChatSDK;->agentAvailabilityURLWithParams:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 650
    :catch_0
    move-exception v0

    .line 651
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 653
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

    .line 652
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 655
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 654
    invoke-static {v0}, Lcom/inc247/constants/CheckInternetConnection;->ShowInternetConnectionLossAlert(Landroid/content/Context;)V

    goto :goto_1
.end method

.method public destroySDKInstance()V
    .locals 1

    .prologue
    .line 1052
    const/4 v0, 0x0

    sput-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    .line 1053
    return-void
.end method

.method public endChat()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 737
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    if-nez v0, :cond_0

    .line 738
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 739
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 738
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 740
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 753
    :goto_0
    return-void

    .line 744
    :cond_0
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideMaximizedChat()V

    .line 745
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideMaximizeButton()V

    .line 746
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetBadge()V

    .line 747
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    invoke-virtual {v0}, Lcom/inc247/ChatSDKWebView;->destroyWebView()V

    .line 748
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->setChatRunning(Z)V

    .line 749
    iput-object v1, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    .line 750
    iput-object v1, p0, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    .line 751
    sput-object v1, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    goto :goto_0
.end method

.method public getQueueId(Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 633
    iput-object p1, p0, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    .line 634
    return-void
.end method

.method public getQueueIdParameters()V
    .locals 3

    .prologue
    .line 171
    :try_start_0
    new-instance v0, Lcom/inc247/ChatSDK$getXmlData;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/inc247/ChatSDK$getXmlData;-><init>(Lcom/inc247/ChatSDK;Lcom/inc247/ChatSDK$getXmlData;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDK$getXmlData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    :goto_0
    return-void

    .line 173
    :catch_0
    move-exception v0

    .line 174
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 176
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

    .line 175
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getWindowParam()V
    .locals 2

    .prologue
    .line 938
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 939
    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 938
    check-cast v0, Landroid/view/WindowManager;

    .line 940
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 941
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v1

    iput v1, p0, Lcom/inc247/ChatSDK;->width:I

    .line 942
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/inc247/ChatSDK;->height:I

    .line 944
    return-void
.end method

.method public incrementBadge()V
    .locals 4

    .prologue
    .line 899
    iget-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    if-nez v0, :cond_0

    .line 900
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;

    if-eqz v0, :cond_0

    .line 901
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 902
    new-instance v1, Lcom/inc247/ChatSDK$7;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$7;-><init>(Lcom/inc247/ChatSDK;)V

    .line 913
    sget v2, Lcom/inc247/constants/ChatSDKConstants;->maximizeButtonAnimationDuration:I

    int-to-long v2, v2

    .line 902
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 916
    :cond_0
    return-void
.end method

.method public maximizeChat()V
    .locals 4

    .prologue
    .line 667
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    if-nez v0, :cond_0

    .line 668
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 669
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 668
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 670
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 700
    :goto_0
    return-void

    .line 673
    :cond_0
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 679
    :try_start_0
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->sendChatMaximizedCallbackToJS()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 687
    :goto_1
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideMaximizeButton()V

    .line 688
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->showMaximizedChat()V

    .line 689
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatMaximizedEvent(Lorg/json/JSONObject;)V

    .line 690
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 691
    new-instance v1, Lcom/inc247/ChatSDK$3;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$3;-><init>(Lcom/inc247/ChatSDK;)V

    .line 698
    const-wide/16 v2, 0xc8

    .line 691
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 680
    :catch_0
    move-exception v0

    .line 684
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

    .line 683
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public minimizeChat()V
    .locals 2

    .prologue
    .line 714
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    if-nez v0, :cond_0

    .line 715
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 716
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 715
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 717
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 728
    :goto_0
    return-void

    .line 721
    :cond_0
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->hideMaximizedChat()V

    .line 722
    sget-object v0, Lcom/inc247/ChatSDKResources;->CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

    const-string v1, "false"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 723
    invoke-static {}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->sendChatMinimizedCallbackToJS()V

    .line 724
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->showMaximizeButton()V

    .line 726
    :cond_1
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatMinimizedEvent(Lorg/json/JSONObject;)V

    .line 727
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    goto :goto_0
.end method

.method public orientationChanged()V
    .locals 4

    .prologue
    .line 761
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 762
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 763
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetMaximizeButtonPosition()V

    .line 764
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetBadgeViewPosition()V

    .line 771
    :cond_0
    iget-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    if-eqz v0, :cond_2

    .line 773
    invoke-virtual {p0}, Lcom/inc247/ChatSDK;->showDialog()V

    .line 774
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->getLocationAlertStatus()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 776
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 778
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 779
    new-instance v1, Lcom/inc247/ChatSDK$4;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$4;-><init>(Lcom/inc247/ChatSDK;)V

    .line 786
    const-wide/16 v2, 0x190

    .line 779
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 803
    :cond_1
    :goto_0
    return-void

    .line 794
    :cond_2
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetMaximizeButtonPosition()V

    .line 795
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->resetBadgeViewPosition()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 797
    :catch_0
    move-exception v0

    .line 798
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 800
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

    .line 799
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setChatEventsListener(Lcom/inc247/ChatSDKEventsListener;)V
    .locals 1

    .prologue
    .line 294
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v0, p1}, Lcom/inc247/ChatSDKEventsCallback;->setChatEventsListener(Lcom/inc247/ChatSDKEventsListener;)V

    .line 295
    return-void
.end method

.method public showDialog()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 428
    invoke-virtual {p0}, Lcom/inc247/ChatSDK;->getWindowParam()V

    .line 430
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->GetDeviceInch()V

    .line 431
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    invoke-virtual {v0}, Lcom/inc247/ChatSDKWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 432
    iget-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    invoke-virtual {v0}, Lcom/inc247/ChatSDKWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewManager;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    invoke-interface {v0, v1}, Landroid/view/ViewManager;->removeView(Landroid/view/View;)V

    .line 434
    :cond_0
    iget-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z

    if-eqz v0, :cond_1

    .line 436
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 444
    :cond_1
    :goto_0
    new-instance v0, Landroid/app/Dialog;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 445
    const v2, 0x1030009

    .line 444
    invoke-direct {v0, v1, v2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    sput-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    .line 446
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 447
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v1, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 446
    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 451
    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    .line 452
    sget-object v1, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/WindowManager$LayoutParams;->copyFrom(Landroid/view/WindowManager$LayoutParams;)I

    .line 456
    iget-wide v2, p0, Lcom/inc247/ChatSDK;->screenInches:D

    const-wide/high16 v4, 0x401a000000000000L    # 6.5

    cmpl-double v1, v2, v4

    if-ltz v1, :cond_2

    .line 457
    iget v1, p0, Lcom/inc247/ChatSDK;->width:I

    iget v2, p0, Lcom/inc247/ChatSDK;->height:I

    if-le v1, v2, :cond_3

    .line 460
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->get_landscape_padding_parameters()V

    .line 462
    invoke-static {}, Lcom/inc247/ChatSDK;->get_landscape_parameters()V

    .line 463
    iget v1, p0, Lcom/inc247/ChatSDK;->width:I

    sget v2, Lcom/inc247/ChatSDK;->width_landscape:F

    float-to-int v2, v2

    mul-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x64

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 464
    iget v1, p0, Lcom/inc247/ChatSDK;->height:I

    sget v2, Lcom/inc247/ChatSDK;->height_landscape:F

    float-to-int v2, v2

    mul-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x64

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 465
    iget v1, p0, Lcom/inc247/ChatSDK;->padding_left_landscape:F

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 466
    iget v1, p0, Lcom/inc247/ChatSDK;->padding_top_landscape:F

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 484
    :cond_2
    :goto_1
    :try_start_1
    sget-object v1, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 485
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    const-string v1, "left-right"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 486
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 487
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 489
    const-string v2, "chatAnimation_left_right"

    .line 490
    const-string v3, "style"

    .line 491
    sget-object v4, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v4, v4, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 492
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 488
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 486
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 537
    :goto_2
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->requestWindowFeature(I)Z

    .line 538
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    .line 539
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setCancelable(Z)V

    .line 540
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 541
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/inc247/ChatSDK;->maximizedView:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 547
    :goto_3
    return-void

    .line 437
    :catch_0
    move-exception v0

    .line 438
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 439
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 440
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 439
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 441
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    goto/16 :goto_0

    .line 473
    :cond_3
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->get_portrait_padding_parameters()V

    .line 475
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->get_portrait_parameters()V

    .line 476
    iget v1, p0, Lcom/inc247/ChatSDK;->height:I

    iget v2, p0, Lcom/inc247/ChatSDK;->height_portrait:F

    float-to-int v2, v2

    mul-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x64

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 477
    iget v1, p0, Lcom/inc247/ChatSDK;->width:I

    iget v2, p0, Lcom/inc247/ChatSDK;->width_portrait:F

    float-to-int v2, v2

    mul-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x64

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 478
    iget v1, p0, Lcom/inc247/ChatSDK;->padding_left_portrait:F

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 479
    iget v1, p0, Lcom/inc247/ChatSDK;->padding_top_portrait:F

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    goto/16 :goto_1

    .line 493
    :cond_4
    :try_start_2
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    .line 494
    const-string v1, "right-left"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 495
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 496
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 498
    const-string v2, "chatAnimation_right_left"

    .line 499
    const-string v3, "style"

    .line 500
    sget-object v4, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v4, v4, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 501
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 497
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 495
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_2

    .line 542
    :catch_1
    move-exception v0

    .line 543
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 545
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

    .line 544
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 502
    :cond_5
    :try_start_3
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    .line 503
    const-string v1, "top-bottom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 504
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 505
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 507
    const-string v2, "chatAnimation_top_bottom"

    .line 508
    const-string v3, "style"

    .line 509
    sget-object v4, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v4, v4, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 510
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 506
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 504
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    goto/16 :goto_2

    .line 511
    :cond_6
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    .line 512
    const-string v1, "bottom-top"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 513
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 518
    :cond_7
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 519
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 521
    const-string v2, "chatAnimation_bottom_top"

    .line 522
    const-string v3, "style"

    .line 523
    sget-object v4, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v4, v4, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 524
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 520
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 518
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    goto/16 :goto_2

    .line 525
    :cond_8
    sget-object v0, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    const-string v1, "none"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 526
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    const/4 v1, 0x0

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    goto/16 :goto_2

    .line 532
    :cond_9
    sget-object v0, Lcom/inc247/ChatSDK;->chatDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    const/4 v1, 0x0

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 533
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 534
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKInvalidParameterError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 533
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 535
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_2
.end method

.method public startChat(Lorg/json/JSONObject;Landroid/app/Activity;Lorg/json/JSONObject;Z)V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 314
    sput-boolean p4, Lcom/inc247/ChatSDK;->isAppDeveloperWantToAccessLocationService:Z

    .line 315
    invoke-static {v3}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->setLocationAlertShowingOrNot(Z)V

    .line 316
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iput-object p2, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 317
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iput-object p3, v0, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    .line 318
    invoke-static {}, Lcom/inc247/ChatSDKResources;->isXMLValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 319
    sget-object v0, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iput-object p1, v0, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    .line 320
    invoke-static {p2}, Lcom/inc247/ChatSDKWebView;->getInstance(Landroid/content/Context;)Lcom/inc247/ChatSDKWebView;

    move-result-object v0

    iput-object v0, p0, Lcom/inc247/ChatSDK;->chatWebView:Lcom/inc247/ChatSDKWebView;

    .line 321
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    if-nez v0, :cond_0

    .line 323
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    .line 324
    new-instance v0, Lcom/inc247/ChatSDKMaximizeButton;

    invoke-direct {v0, p2}, Lcom/inc247/ChatSDKMaximizeButton;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    .line 325
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    .line 327
    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_BACKGROUND:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    .line 326
    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setBackgroundColor(I)V

    .line 328
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    .line 330
    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_TEXTCOLOR:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    .line 329
    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setTextColor(I)V

    .line 331
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    const-string v1, "  Chat"

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setText(Ljava/lang/CharSequence;)V

    .line 332
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setTextSize(F)V

    .line 333
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setGravity(I)V

    .line 334
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 335
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonWidth()I

    move-result v1

    .line 336
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMaximizeButtonHeight()I

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 334
    iput-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 337
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v1

    aget v1, v1, v3

    .line 338
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    .line 339
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v3

    const/4 v4, 0x2

    aget v3, v3, v4

    .line 340
    invoke-static {}, Lcom/inc247/ChatSDKUtil;->getMarginParams()[I

    move-result-object v4

    const/4 v5, 0x3

    aget v4, v4, v5

    .line 337
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 341
    iget-object v0, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    new-instance v1, Lcom/inc247/ChatSDK$1;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$1;-><init>(Lcom/inc247/ChatSDK;)V

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 358
    iget-object v0, p0, Lcom/inc247/ChatSDK;->buttonLayout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;

    iget-object v2, p0, Lcom/inc247/ChatSDK;->buttonLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v0, v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 362
    :cond_0
    iget-object v0, p0, Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;

    if-nez v0, :cond_1

    .line 363
    invoke-direct {p0}, Lcom/inc247/ChatSDK;->makeNotifView()V

    .line 370
    :goto_0
    return-void

    .line 365
    :cond_1
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 366
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKInvalidParameterError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 365
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 367
    sget-object v1, Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    goto :goto_0
.end method

.method public uploadFile(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 1069
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/inc247/ChatSDKWebView;->getInstance(Landroid/content/Context;)Lcom/inc247/ChatSDKWebView;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/inc247/ChatSDKWebView;->onActivityResult(IILandroid/content/Intent;)V

    .line 1070
    return-void
.end method
