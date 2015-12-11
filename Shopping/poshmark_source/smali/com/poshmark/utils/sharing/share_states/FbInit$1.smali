.class Lcom/poshmark/utils/sharing/share_states/FbInit$1;
.super Ljava/lang/Object;
.source "FbInit.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/FbInit;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/FbInit;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/FbInit;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/FbInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 1
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 38
    if-eqz p1, :cond_0

    .line 39
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 42
    return-void
.end method

.method public success(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "grantedPermissions"    # I
    .param p2, "accessToken"    # Ljava/lang/String;
    .param p3, "formattedDate"    # Ljava/lang/String;

    .prologue
    .line 31
    and-int/lit8 v0, p1, 0x8

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 34
    :cond_0
    return-void
.end method
