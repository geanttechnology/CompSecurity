.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;)V
    .locals 0

    .prologue
    .line 297
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 301
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 302
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->hideProgressDialog()V

    .line 303
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_TUMBLR:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 306
    :cond_0
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 310
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->hideProgressDialog()V

    .line 312
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5$3;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTumblrShareLayout()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$600(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    .line 315
    :cond_0
    return-void
.end method
