.class Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;
.super Ljava/lang/Object;
.source "UserFollowButtonLayout.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/UserFollowButtonLayout;
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
    .line 169
    iput-object p1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .param p1, "apiResponse"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 172
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 173
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiRequest:Lcom/poshmark/http/api/PMApiRequest;

    iget-object v0, v0, Lcom/poshmark/http/api/PMApiRequest;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowButton()V
    invoke-static {v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$400(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    .line 175
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    .line 176
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->fireUserFollowingStatusChangedNotification()V
    invoke-static {v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$500(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    .line 177
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    invoke-interface {v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;->onFollowingClick()V

    .line 184
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setButtonVisibility(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$100(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;Z)V

    .line 185
    return-void

    .line 182
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;->this$0:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowButton()V
    invoke-static {v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->access$400(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    goto :goto_0
.end method
