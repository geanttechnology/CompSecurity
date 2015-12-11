.class Lcom/poshmark/ui/fragments/SignupFormFragment$5;
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
    .line 413
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 417
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 418
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 419
    return-void
.end method
