.class public abstract Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;
.super Lcom/comcast/cim/android/view/common/SearchableFragment;
.source "MultiDeleteActionFragment.java"


# instance fields
.field protected actionMode:Landroid/view/ActionMode;

.field protected actionModeCallback:Landroid/view/ActionMode$Callback;

.field protected counterField:Landroid/widget/TextView;

.field protected isEditMode:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;-><init>()V

    .line 24
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$1;-><init>(Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->actionModeCallback:Landroid/view/ActionMode$Callback;

    return-void
.end method


# virtual methods
.method protected abstract deleteItems()V
.end method

.method protected abstract getCheckedItemsCount()I
.end method

.method protected abstract getTotalItemsCount()I
.end method

.method protected abstract getViewLayoutId()I
.end method

.method protected abstract isEditEnabled()Z
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 95
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 97
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->searchable:Lcom/comcast/cim/android/view/common/Searchable;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->searchable:Lcom/comcast/cim/android/view/common/Searchable;

    invoke-interface {v1}, Lcom/comcast/cim/android/view/common/Searchable;->isSearching()Z

    move-result v1

    if-nez v1, :cond_1

    .line 98
    :cond_0
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_item_edit:I

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 101
    .local v0, "editMenuItem":Landroid/view/MenuItem;
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 102
    new-instance v1, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$2;-><init>(Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;)V

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 110
    .end local v0    # "editMenuItem":Landroid/view/MenuItem;
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 71
    if-eqz p3, :cond_0

    .line 72
    const-string v1, "isEditMode"

    invoke-virtual {p3, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    .line 75
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getViewLayoutId()I

    move-result v1

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 77
    .local v0, "view":Landroid/view/ViewGroup;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 78
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->setHasOptionsMenu(Z)V

    .line 81
    :cond_1
    return-object v0
.end method

.method protected onEditModeChanged(Z)V
    .locals 0
    .param p1, "inEditMode"    # Z

    .prologue
    .line 153
    return-void
.end method

.method public onResumeInternal()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onResumeInternal()V

    .line 88
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->startActionMode()V

    .line 91
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 115
    const-string v0, "isEditMode"

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 116
    return-void
.end method

.method protected setEditMode(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 144
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    if-eq v0, p1, :cond_0

    .line 145
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    .line 147
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->isEditMode:Z

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onEditModeChanged(Z)V

    .line 149
    :cond_0
    return-void
.end method

.method protected showSelectedCountOnActionMenu()V
    .locals 5

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getCheckedItemsCount()I

    move-result v1

    .line 129
    .local v1, "selectedCnt":I
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 131
    .local v0, "sb":Ljava/lang/StringBuffer;
    if-nez v1, :cond_0

    .line 132
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->none:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 139
    :goto_0
    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->selected:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 140
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->counterField:Landroid/widget/TextView;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 141
    return-void

    .line 133
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getTotalItemsCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 134
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 136
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->all:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method protected startActionMode()V
    .locals 2

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->actionModeCallback:Landroid/view/ActionMode$Callback;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->actionMode:Landroid/view/ActionMode;

    .line 124
    return-void
.end method
