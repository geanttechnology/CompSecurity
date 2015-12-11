.class Lcom/poshmark/ui/fragments/SignupFormFragment$3;
.super Ljava/lang/Object;
.source "SignupFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignupFormFragment;->displayForm()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 308
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ImageView;->getHeight()I

    move-result v4

    # setter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->imageHeight:I
    invoke-static {v3, v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$102(Lcom/poshmark/ui/fragments/SignupFormFragment;I)I

    .line 309
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ImageView;->getWidth()I

    move-result v4

    # setter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->imageWidth:I
    invoke-static {v3, v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$302(Lcom/poshmark/ui/fragments/SignupFormFragment;I)I

    .line 310
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 311
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 312
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 313
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 314
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "CREATION_MODE"

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 315
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 316
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->SELECT_PICTURE:I
    invoke-static {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$400(Lcom/poshmark/ui/fragments/SignupFormFragment;)I

    move-result v4

    invoke-virtual {v3, v1, v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 317
    return-void
.end method
