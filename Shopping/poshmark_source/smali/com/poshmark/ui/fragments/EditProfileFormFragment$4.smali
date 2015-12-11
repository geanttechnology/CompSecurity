.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V
    .locals 0

    .prologue
    .line 227
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    const/4 v3, 0x0

    .line 230
    if-eqz p2, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    if-ne p1, v1, :cond_0

    .line 231
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideKeyboard()V

    .line 232
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 233
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v0, v3, v1, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 235
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method
