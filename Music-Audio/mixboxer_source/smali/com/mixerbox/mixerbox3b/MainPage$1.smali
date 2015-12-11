.class Lcom/mixerbox/mixerbox3b/MainPage$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/facebook/Session$StatusCallback;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$1;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$1;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    invoke-static {v0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/MainPage;->access$000(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 300
    return-void
.end method
