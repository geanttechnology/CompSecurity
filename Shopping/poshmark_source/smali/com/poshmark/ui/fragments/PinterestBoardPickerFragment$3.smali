.class Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;
.super Ljava/lang/Object;
.source "PinterestBoardPickerFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 161
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 162
    .local v0, "board":Lcom/poshmark/utils/meta_data/PinterestBoard;
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/poshmark/utils/meta_data/PinterestBoard;->enabled:Z

    .line 163
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iput-object v0, v1, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 164
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->notifyDataSetChanged()V

    .line 165
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->postSelectedBoard()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->access$100(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V

    .line 166
    return-void
.end method
