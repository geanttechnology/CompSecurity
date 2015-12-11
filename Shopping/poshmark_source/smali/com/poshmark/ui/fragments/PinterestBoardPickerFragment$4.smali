.class Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;
.super Ljava/lang/Object;
.source "PinterestBoardPickerFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->postSelectedBoard()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

.field final synthetic val$json:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->val$json:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 183
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const-string v4, "PinterestBoardPicker"

    iget-object v5, p1, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 184
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 185
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_0

    .line 186
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 187
    .local v2, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 188
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "DATA_SELECTED"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->val$json:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    const-string v4, "RETURNED_RESULTS"

    invoke-virtual {v2, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 190
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget v4, v4, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->mode:I

    const/4 v5, -0x1

    invoke-virtual {v1, v4, v5, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 191
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 192
    .local v3, "parent":Landroid/app/Activity;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->hideProgressDialog()V

    .line 193
    if-eqz v3, :cond_0

    .line 194
    invoke-virtual {v3}, Landroid/app/Activity;->onBackPressed()V

    .line 197
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "intent":Landroid/content/Intent;
    .end local v3    # "parent":Landroid/app/Activity;
    :cond_0
    return-void
.end method
