.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;)V
    .locals 0

    .prologue
    .line 309
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->hideProgressDialog()V

    .line 315
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 317
    :cond_0
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 321
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 322
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->hideProgressDialog()V

    .line 323
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0, p2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterLoginComplete(Landroid/os/Bundle;)V

    .line 325
    :cond_0
    return-void
.end method
