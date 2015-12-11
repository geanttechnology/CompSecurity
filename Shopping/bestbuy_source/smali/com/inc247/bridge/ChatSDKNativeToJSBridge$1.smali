.class Lcom/inc247/bridge/ChatSDKNativeToJSBridge$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
.end annotation


# instance fields
.field private final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge$1;->val$url:Ljava/lang/String;

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 60
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 59
    invoke-static {v0}, Lcom/inc247/ChatSDKWebView;->getInstance(Landroid/content/Context;)Lcom/inc247/ChatSDKWebView;

    move-result-object v0

    .line 60
    iget-object v1, p0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge$1;->val$url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKWebView;->loadUrl(Ljava/lang/String;)V

    .line 61
    return-void
.end method
