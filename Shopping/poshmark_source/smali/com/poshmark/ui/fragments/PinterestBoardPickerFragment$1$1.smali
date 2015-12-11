.class Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1$1;
.super Ljava/lang/Object;
.source "PinterestBoardPickerFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 3

    .prologue
    .line 95
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    const/4 v1, 0x2

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/PMContainerActivity;->popTopNFragments(IZ)V

    .line 96
    return-void
.end method
