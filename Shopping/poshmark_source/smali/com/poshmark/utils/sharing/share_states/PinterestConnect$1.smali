.class Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;
.super Ljava/lang/Object;
.source "PinterestConnect.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

.field final synthetic val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;

.field final synthetic val$fragment:Lcom/poshmark/ui/fragments/PMFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/PinterestConnect;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/utils/view_holders/PinterestDialog;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iput-object p2, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$fragment:Lcom/poshmark/ui/fragments/PMFragment;

    iput-object p3, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 48
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 69
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-virtual {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;->dismiss()V

    .line 70
    return-void

    .line 50
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$fragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->val$fragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 51
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    new-instance v2, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1$1;-><init>(Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->pinterestLink(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0

    .line 66
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;->this$0:Lcom/poshmark/utils/sharing/share_states/PinterestConnect;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_0

    .line 48
    :pswitch_data_0
    .packed-switch 0x7f0c0262
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
