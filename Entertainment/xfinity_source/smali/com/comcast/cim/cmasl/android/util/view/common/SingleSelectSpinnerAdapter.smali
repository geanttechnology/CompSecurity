.class public Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;
.super Landroid/widget/BaseAdapter;
.source "SingleSelectSpinnerAdapter.java"

# interfaces
.implements Landroid/widget/SpinnerAdapter;


# instance fields
.field private final inflater:Landroid/view/LayoutInflater;

.field private final items:[Ljava/lang/String;

.field private selectedItem:I


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->items:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 51
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v4, Lcom/comcast/cim/cmasl/android/util/R$layout;->single_select_spinner_drop_down_item:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 52
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/comcast/cim/cmasl/android/util/R$id;->item_text:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 54
    .local v1, "label":Landroid/widget/TextView;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 55
    .local v0, "item":Ljava/lang/String;
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    iget v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->selectedItem:I

    if-ne p1, v3, :cond_0

    .line 58
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setSelected(Z)V

    .line 62
    :goto_0
    return-object v2

    .line 60
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setSelected(Z)V

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->items:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 33
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getSelectedItem()I
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->selectedItem:I

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 39
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v4, Lcom/comcast/cim/cmasl/android/util/R$layout;->single_select_spinner_item:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 41
    .local v2, "view":Landroid/view/View;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 42
    .local v1, "text":Ljava/lang/String;
    sget v3, Lcom/comcast/cim/cmasl/android/util/R$id;->item_text:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 43
    .local v0, "label":Landroid/widget/TextView;
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 45
    return-object v2
.end method

.method public setSelectedItem(I)V
    .locals 0
    .param p1, "selectedItem"    # I

    .prologue
    .line 66
    iput p1, p0, Lcom/comcast/cim/cmasl/android/util/view/common/SingleSelectSpinnerAdapter;->selectedItem:I

    .line 67
    return-void
.end method
