.class public Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;
.super Ljava/lang/Object;
.source "BlueKaiDataExtension.java"

# interfaces
.implements Ltv/freewheel/extension/IExtension;


# static fields
.field static alreadySync:Z


# instance fields
.field private adContext:Ltv/freewheel/ad/interfaces/IAdContext;

.field private bluekaiScript:Ljava/lang/String;

.field private constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private logger:Ltv/freewheel/utils/Logger;

.field requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private webView:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput-boolean v0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->alreadySync:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const-string v0, "<!DOCTYPE html><html><head><meta charset=\'utf-8\'></head><body><iframe name=\'__bkframe\' height=\'0\' width=\'0\' frameborder=\'0\' src=\'javascript:void(0)\'></iframe><script type=\'text/javascript\' src=\'http://tags.bkrtx.com/js/bk-coretag.js\'></script><script type=\'text/javascript\'>bk_allow_multiple_calls=true;bk_use_multiple_iframes=true;bk_send_statid_payload=true;bk_addPageCtx(\'id\',\'androidId_md5\');bk_addPageCtx(\'MD5_Android\',\'androidId_md5\');bk_doJSTag(14819, 0);</script></body></html>"

    iput-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;

    .line 32
    new-instance v0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension$1;-><init>(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ltv/freewheel/ad/interfaces/IAdContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    invoke-direct {p0}, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->getAndroidId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->bluekaiScript:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$500(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    .prologue
    .line 16
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->webView:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$502(Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;Landroid/webkit/WebView;)Landroid/webkit/WebView;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;
    .param p1, "x1"    # Landroid/webkit/WebView;

    .prologue
    .line 16
    iput-object p1, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->webView:Landroid/webkit/WebView;

    return-object p1
.end method

.method private getAndroidId()Ljava/lang/String;
    .locals 5

    .prologue
    .line 62
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    const-string v4, "_fw_did_android_id"

    invoke-interface {v3, v4}, Ltv/freewheel/ad/interfaces/IAdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 63
    .local v2, "paramValue":Ljava/lang/String;
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Ltv/freewheel/utils/CommonUtil;->parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v1

    .line 64
    .local v1, "enableDeviceIdentifier":Ljava/lang/Boolean;
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 65
    iget-object v3, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IAdContext;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "android_id"

    invoke-static {v3, v4}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "androidId":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 70
    .end local v0    # "androidId":Ljava/lang/String;
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public init(Ltv/freewheel/ad/interfaces/IAdContext;)V
    .locals 3
    .param p1, "adContext"    # Ltv/freewheel/ad/interfaces/IAdContext;

    .prologue
    .line 25
    iput-object p1, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    .line 26
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IAdContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 27
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->logger:Ltv/freewheel/utils/Logger;

    .line 28
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "init"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    iget-object v0, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;->requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 30
    return-void
.end method
