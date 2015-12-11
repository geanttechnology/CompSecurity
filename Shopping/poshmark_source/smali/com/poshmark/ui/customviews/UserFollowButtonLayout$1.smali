.class Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;
.super Ljava/lang/Object;
.source "UserFollowButtonLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 89
    const/4 v0, 0x0

    .line 90
    .local v0, "handler":Lcom/poshmark/http/api/PMApiResponseHandler;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-boolean v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    if-nez v1, :cond_2

    .line 91
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-boolean v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->fireAndForgetMode:Z

    if-nez v1, :cond_1

    .line 92
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # getter for: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;
    invoke-static {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$000(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)Lcom/poshmark/http/api/PMApiResponseHandler;

    move-result-object v0

    .line 93
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setButtonVisibility(Z)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$100(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;Z)V

    .line 101
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/poshmark/http/api/PMApi;->followUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 115
    :goto_1
    return-void

    .line 96
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowingButton()V
    invoke-static {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$200(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    .line 97
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    if-eqz v1, :cond_0

    .line 98
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    invoke-interface {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;->onFollowClick()V

    goto :goto_0

    .line 103
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-boolean v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->fireAndForgetMode:Z

    if-nez v1, :cond_4

    .line 104
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # getter for: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followingCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;
    invoke-static {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$300(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)Lcom/poshmark/http/api/PMApiResponseHandler;

    move-result-object v0

    .line 105
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setButtonVisibility(Z)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$100(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;Z)V

    .line 113
    :cond_3
    :goto_2
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/poshmark/http/api/PMApi;->unFollowUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1

    .line 107
    :cond_4
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowButton()V
    invoke-static {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$400(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    .line 108
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    if-eqz v1, :cond_3

    .line 109
    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    invoke-interface {v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;->onFollowingClick()V

    goto :goto_2
.end method
