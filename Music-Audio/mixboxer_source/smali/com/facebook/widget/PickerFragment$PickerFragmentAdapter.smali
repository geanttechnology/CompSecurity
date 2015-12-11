.class abstract Lcom/facebook/widget/PickerFragment$PickerFragmentAdapter;
.super Lcom/facebook/widget/GraphObjectAdapter;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/facebook/widget/PickerFragment;


# direct methods
.method public constructor <init>(Lcom/facebook/widget/PickerFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1032
    iput-object p1, p0, Lcom/facebook/widget/PickerFragment$PickerFragmentAdapter;->this$0:Lcom/facebook/widget/PickerFragment;

    .line 1033
    invoke-direct {p0, p2}, Lcom/facebook/widget/GraphObjectAdapter;-><init>(Landroid/content/Context;)V

    .line 1034
    return-void
.end method


# virtual methods
.method isGraphObjectSelected(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 1038
    iget-object v0, p0, Lcom/facebook/widget/PickerFragment$PickerFragmentAdapter;->this$0:Lcom/facebook/widget/PickerFragment;

    # getter for: Lcom/facebook/widget/PickerFragment;->selectionStrategy:Lcom/facebook/widget/PickerFragment$SelectionStrategy;
    invoke-static {v0}, Lcom/facebook/widget/PickerFragment;->access$600(Lcom/facebook/widget/PickerFragment;)Lcom/facebook/widget/PickerFragment$SelectionStrategy;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/widget/PickerFragment$SelectionStrategy;->isSelected(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method updateCheckboxState(Landroid/widget/CheckBox;Z)V
    .locals 1

    .prologue
    .line 1043
    invoke-virtual {p1, p2}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 1044
    if-nez p2, :cond_0

    iget-object v0, p0, Lcom/facebook/widget/PickerFragment$PickerFragmentAdapter;->this$0:Lcom/facebook/widget/PickerFragment;

    # getter for: Lcom/facebook/widget/PickerFragment;->selectionStrategy:Lcom/facebook/widget/PickerFragment$SelectionStrategy;
    invoke-static {v0}, Lcom/facebook/widget/PickerFragment;->access$600(Lcom/facebook/widget/PickerFragment;)Lcom/facebook/widget/PickerFragment$SelectionStrategy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/widget/PickerFragment$SelectionStrategy;->shouldShowCheckBoxIfUnselected()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    .line 1046
    :goto_0
    invoke-virtual {p1, v0}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 1047
    return-void

    .line 1044
    :cond_1
    const/16 v0, 0x8

    goto :goto_0
.end method
