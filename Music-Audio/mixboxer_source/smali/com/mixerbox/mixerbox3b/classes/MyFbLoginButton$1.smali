.class Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/facebook/Request$GraphUserCallback;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

.field final synthetic val$currentSession:Lcom/facebook/Session;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/facebook/Session;)V
    .locals 0

    .prologue
    .line 539
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->val$currentSession:Lcom/facebook/Session;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted(Lcom/facebook/model/GraphUser;Lcom/facebook/Response;)V
    .locals 2

    .prologue
    .line 542
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->val$currentSession:Lcom/facebook/Session;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/internal/SessionTracker;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/internal/SessionTracker;->getOpenSession()Lcom/facebook/Session;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 543
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # setter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;
    invoke-static {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$302(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/facebook/model/GraphUser;)Lcom/facebook/model/GraphUser;

    .line 544
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$400(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 545
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$400(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/model/GraphUser;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;->onUserInfoFetched(Lcom/facebook/model/GraphUser;)V

    .line 548
    :cond_0
    invoke-virtual {p2}, Lcom/facebook/Response;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 549
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {p2}, Lcom/facebook/Response;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/FacebookRequestError;->getException()Lcom/facebook/FacebookException;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->handleError(Ljava/lang/Exception;)V

    .line 551
    :cond_1
    return-void
.end method
