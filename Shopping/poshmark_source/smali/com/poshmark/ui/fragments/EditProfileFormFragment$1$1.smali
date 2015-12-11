.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$1$1;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 2

    .prologue
    .line 184
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 185
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->onBackPressed()V

    .line 186
    return-void
.end method
