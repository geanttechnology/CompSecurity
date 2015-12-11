.class Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;
.super Ljava/lang/Object;
.source "PinterestShare.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/PinterestShare;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/PinterestShare;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 2
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_CANCELLED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 41
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 42
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 2
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_SUCCESS:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 35
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 36
    return-void
.end method
