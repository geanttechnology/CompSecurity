.class Lcom/mixerbox/mixerbox3b/MixerBox$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/facebook/Session$StatusCallback;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MixerBox;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MixerBox;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$1;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$1;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    # invokes: Lcom/mixerbox/mixerbox3b/MixerBox;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    invoke-static {v0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/MixerBox;->access$000(Lcom/mixerbox/mixerbox3b/MixerBox;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 82
    return-void
.end method
