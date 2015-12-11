.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 211
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 214
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v4, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v3, v4, :cond_0

    .line 216
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 217
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 218
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 219
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 220
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "CREATION_MODE"

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 221
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 222
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->SELECT_PICTURE:I
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$100(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)I

    move-result v4

    invoke-virtual {v3, v1, v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 224
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method
