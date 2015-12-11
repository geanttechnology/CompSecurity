.class Lcom/inc247/ChatSDKEventsCallback$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKEventsCallback;->sendonChatMaximizedEvent(Lorg/json/JSONObject;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKEventsCallback;

.field private final synthetic val$data:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKEventsCallback$6;->this$0:Lcom/inc247/ChatSDKEventsCallback;

    iput-object p2, p0, Lcom/inc247/ChatSDKEventsCallback$6;->val$data:Lorg/json/JSONObject;

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 89
    # getter for: Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->access$0()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    # getter for: Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;
    invoke-static {v0}, Lcom/inc247/ChatSDKEventsCallback;->access$1(Lcom/inc247/ChatSDKEventsCallback;)Lcom/inc247/ChatSDKEventsListener;

    move-result-object v0

    iget-object v1, p0, Lcom/inc247/ChatSDKEventsCallback$6;->val$data:Lorg/json/JSONObject;

    invoke-interface {v0, v1}, Lcom/inc247/ChatSDKEventsListener;->onChatMaximized(Lorg/json/JSONObject;)V

    .line 90
    return-void
.end method
