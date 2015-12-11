.class Lcom/inc247/ChatSDKEventsCallback$8;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKEventsCallback;

.field private final synthetic val$data:Lcom/inc247/errors/ChatSDKError;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKEventsCallback;Lcom/inc247/errors/ChatSDKError;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKEventsCallback$8;->this$0:Lcom/inc247/ChatSDKEventsCallback;

    iput-object p2, p0, Lcom/inc247/ChatSDKEventsCallback$8;->val$data:Lcom/inc247/errors/ChatSDKError;

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 107
    # getter for: Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->access$0()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    # getter for: Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;
    invoke-static {v0}, Lcom/inc247/ChatSDKEventsCallback;->access$1(Lcom/inc247/ChatSDKEventsCallback;)Lcom/inc247/ChatSDKEventsListener;

    move-result-object v0

    iget-object v1, p0, Lcom/inc247/ChatSDKEventsCallback$8;->val$data:Lcom/inc247/errors/ChatSDKError;

    invoke-interface {v0, v1}, Lcom/inc247/ChatSDKEventsListener;->onChatError(Lcom/inc247/errors/ChatSDKError;)V

    .line 108
    return-void
.end method
