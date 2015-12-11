.class Lcom/inc247/ChatSDKEventsCallback$9;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKEventsCallback;->sendonQueueIdParamRetrievalStarted()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKEventsCallback;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKEventsCallback;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKEventsCallback$9;->this$0:Lcom/inc247/ChatSDKEventsCallback;

    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 116
    # getter for: Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->access$0()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    # getter for: Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;
    invoke-static {v0}, Lcom/inc247/ChatSDKEventsCallback;->access$1(Lcom/inc247/ChatSDKEventsCallback;)Lcom/inc247/ChatSDKEventsListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/inc247/ChatSDKEventsListener;->onQueueIdParamRetrievalStarted()V

    .line 117
    return-void
.end method
