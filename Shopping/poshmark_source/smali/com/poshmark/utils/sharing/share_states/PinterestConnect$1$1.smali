.class Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;
.super Ljava/lang/Object;
.source "PinterestConnect.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 5
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 60
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v1

    const-string v2, "user"

    const-string v3, "connect_pinterest_failed"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 62
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 55
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 56
    return-void
.end method
