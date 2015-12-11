.class Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/facebook/Session$StatusCallback;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;


# direct methods
.method private constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V
    .locals 0

    .prologue
    .line 628
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;)V
    .locals 0

    .prologue
    .line 628
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    return-void
.end method


# virtual methods
.method public call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 632
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # invokes: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$1300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    .line 633
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # invokes: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setButtonText()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$1400(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    .line 634
    if-eqz p3, :cond_0

    .line 635
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0, p3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->handleError(Ljava/lang/Exception;)V

    .line 638
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v0

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1500(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/Session$StatusCallback;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 639
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v0

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1500(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/Session$StatusCallback;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lcom/facebook/Session$StatusCallback;->call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 641
    :cond_1
    return-void
.end method
