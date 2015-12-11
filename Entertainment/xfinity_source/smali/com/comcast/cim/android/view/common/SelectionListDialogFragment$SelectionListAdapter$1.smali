.class Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;
.super Ljava/lang/Object;
.source "SelectionListDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    .prologue
    .line 181
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    .line 184
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    .line 187
    .local v2, "id":I
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v4

    if-ltz v4, :cond_1

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v4

    if-ne v4, v2, :cond_1

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-boolean v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->isToggleable:Z

    if-nez v4, :cond_1

    .line 206
    .end local v2    # "id":I
    :cond_0
    :goto_0
    return-void

    .line 191
    .restart local v2    # "id":I
    :cond_1
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v5, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v5, v5, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v5}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v5

    if-ne v5, v2, :cond_2

    const/4 v2, -0x1

    .end local v2    # "id":I
    :cond_2
    # setter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v4, v2}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$202(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;I)I

    .line 194
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$300(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v0

    .line 195
    .local v0, "firstVisiblePosition":I
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$300(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 196
    .local v1, "firstVisibleView":Landroid/view/View;
    if-nez v1, :cond_3

    .line 198
    .local v3, "top":I
    :goto_1
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$300(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    invoke-virtual {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->notifyDataSetInvalidated()V

    .line 201
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$300(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4, v0, v3}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 203
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-boolean v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->cancelOnSelectionChanged:Z

    if-eqz v4, :cond_0

    .line 204
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v4, v4, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-virtual {v4}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Dialog;->cancel()V

    goto :goto_0

    .line 196
    .end local v3    # "top":I
    :cond_3
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v3

    goto :goto_1
.end method
