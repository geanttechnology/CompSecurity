.class Lcom/poshmark/ui/fragments/ShareFragment$1$1;
.super Ljava/lang/Object;
.source "ShareFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShareFragment$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ShareFragment$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShareFragment$1;)V
    .locals 0

    .prologue
    .line 226
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShareFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ShareFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ShareFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 230
    return-void
.end method
