.class Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;
.super Landroid/widget/BaseAdapter;
.source "SelectionListDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SelectionListAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionItems:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 164
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 169
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 174
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->inflater:Landroid/view/LayoutInflater;
    invoke-static {v2}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$100(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$layout;->selection_list_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 176
    sget v2, Lcom/comcast/cim/android/R$id;->item_text:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 177
    .local v1, "itemText":Landroid/widget/TextView;
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v3, v3, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionItems:[Ljava/lang/String;

    aget-object v3, v3, p1

    invoke-virtual {v2, v3}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDisplayText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 180
    sget v2, Lcom/comcast/cim/android/R$id;->item_check:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 181
    .local v0, "itemCheck":Landroid/widget/CheckBox;
    new-instance v2, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$1;-><init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;)V

    invoke-virtual {v0, v2}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 209
    new-instance v2, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter$2;-><init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;)V

    invoke-virtual {v0, v2}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 220
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I
    invoke-static {v2}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v2

    if-ne v2, p1, :cond_0

    const/4 v2, 0x1

    :goto_0
    invoke-virtual {v0, v2}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 221
    invoke-virtual {v0, p1}, Landroid/widget/CheckBox;->setId(I)V

    .line 223
    return-object p2

    .line 220
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
