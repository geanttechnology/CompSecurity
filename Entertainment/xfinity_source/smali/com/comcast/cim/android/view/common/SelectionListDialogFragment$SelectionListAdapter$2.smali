.class Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;
.super Ljava/lang/Object;
.source "SelectionListDialogFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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
    .line 209
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 212
    if-eqz p2, :cond_0

    invoke-virtual {p1}, Landroid/widget/CompoundButton;->getId()I

    move-result v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v1, v1, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v1}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v1

    if-ne v0, v1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-boolean v0, v0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->isToggleable:Z

    if-eqz v0, :cond_2

    .line 213
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;->this$1:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onSelectionChangedListener:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;

    invoke-virtual {p1}, Landroid/widget/CompoundButton;->getId()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;->onSelectionChanged(I)V

    .line 217
    :goto_0
    return-void

    .line 215
    :cond_2
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    goto :goto_0
.end method
