.class Lio/branch/referral/ShareLinkManager$2;
.super Ljava/lang/Object;
.source "ShareLinkManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/ShareLinkManager;->createShareDialog(Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/ShareLinkManager;


# direct methods
.method constructor <init>(Lio/branch/referral/ShareLinkManager;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    const/4 v1, 0x0

    .line 179
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v0, v0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v0, v0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    invoke-interface {v0}, Lio/branch/referral/Branch$BranchLinkShareListener;->onShareLinkDialogDismissed()V

    .line 181
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    iput-object v1, v0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    .line 184
    :cond_0
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z
    invoke-static {v0}, Lio/branch/referral/ShareLinkManager;->access$500(Lio/branch/referral/ShareLinkManager;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 185
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    iput-object v1, v0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    .line 186
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    # setter for: Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;
    invoke-static {v0, v1}, Lio/branch/referral/ShareLinkManager;->access$602(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/Branch$ShareLinkBuilder;)Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 188
    :cond_1
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$2;->this$0:Lio/branch/referral/ShareLinkManager;

    iput-object v1, v0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    .line 189
    return-void
.end method
