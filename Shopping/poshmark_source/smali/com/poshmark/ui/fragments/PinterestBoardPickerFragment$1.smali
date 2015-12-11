.class Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;
.super Ljava/lang/Object;
.source "PinterestBoardPickerFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->onActivityCreated(Landroid/os/Bundle;)V
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
        "Lcom/poshmark/utils/meta_data/PinterestBoardList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoardList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 80
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/utils/meta_data/PinterestBoardList;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_1

    .line 81
    const-string v2, "PinterestBoardPicker"

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/utils/meta_data/PinterestBoardList;

    .line 83
    .local v0, "boardList":Lcom/poshmark/utils/meta_data/PinterestBoardList;
    if-eqz v0, :cond_0

    .line 84
    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/PinterestBoardList;->getBoards()Ljava/util/ArrayList;

    move-result-object v1

    .line 85
    .local v1, "boards":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/utils/meta_data/PinterestBoard;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->allboards:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 86
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->setAllboards(Ljava/util/List;)V

    .line 87
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    invoke-virtual {v2}, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->notifyDataSetChanged()V

    .line 88
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->setFooterView()V
    invoke-static {v2}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->access$000(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V

    .line 90
    .end local v1    # "boards":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/utils/meta_data/PinterestBoard;>;"
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->hideProgressDialog()V

    .line 101
    .end local v0    # "boardList":Lcom/poshmark/utils/meta_data/PinterestBoardList;
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    const v4, 0x7f06022e

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1$1;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0
.end method
