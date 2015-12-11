.class Lcom/inc247/bridge/ChatSDKJSToNativeBridge$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/bridge/ChatSDKJSToNativeBridge;->onAgentMessage(Lorg/json/JSONObject;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/bridge/ChatSDKJSToNativeBridge;


# direct methods
.method constructor <init>(Lcom/inc247/bridge/ChatSDKJSToNativeBridge;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$3;->this$0:Lcom/inc247/bridge/ChatSDKJSToNativeBridge;

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 146
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    .line 147
    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->incrementBadge()V

    .line 148
    return-void
.end method
