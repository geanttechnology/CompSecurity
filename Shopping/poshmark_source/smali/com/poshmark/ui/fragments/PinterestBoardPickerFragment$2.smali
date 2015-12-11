.class Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;
.super Ljava/lang/Object;
.source "PinterestBoardPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->setFooterView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

.field final synthetic val$checkMark:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->val$checkMark:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 120
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->val$checkMark:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 121
    new-instance v0, Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/PinterestBoard;-><init>()V

    .line 122
    .local v0, "board":Lcom/poshmark/utils/meta_data/PinterestBoard;
    iput-boolean v2, v0, Lcom/poshmark/utils/meta_data/PinterestBoard;->enabled:Z

    .line 123
    const-string v1, ""

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PinterestBoard;->name:Ljava/lang/String;

    .line 124
    const-string v1, "0"

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PinterestBoard;->board_id:Ljava/lang/String;

    .line 125
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iput-object v0, v1, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 126
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->notifyDataSetChanged()V

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->postSelectedBoard()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->access$100(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V

    .line 128
    return-void
.end method
