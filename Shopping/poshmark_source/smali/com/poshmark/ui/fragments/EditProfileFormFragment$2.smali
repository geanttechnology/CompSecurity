.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 198
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 200
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-ne v2, v1, :cond_0

    .line 202
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideKeyboard()V

    .line 203
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 204
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v0, v3, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 207
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
