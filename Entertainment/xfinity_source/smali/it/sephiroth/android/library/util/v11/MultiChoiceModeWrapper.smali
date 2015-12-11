.class public Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;
.super Ljava/lang/Object;
.source "MultiChoiceModeWrapper.java"

# interfaces
.implements Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;


# instance fields
.field private mView:Lit/sephiroth/android/library/widget/AbsHListView;

.field private mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;


# direct methods
.method public constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 0
    .param p1, "view"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    .line 17
    return-void
.end method


# virtual methods
.method public hasWrappedCallback()Z
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    invoke-interface {v0, p1, p2}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;->onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 30
    iget-object v1, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    invoke-interface {v1, p1, p2}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;->onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 31
    iget-object v1, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v1, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->setLongClickable(Z)V

    .line 32
    const/4 v0, 0x1

    .line 34
    :cond_0
    return v0
.end method

.method public onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 3
    .param p1, "mode"    # Landroid/view/ActionMode;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 52
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    invoke-interface {v0, p1}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;->onDestroyActionMode(Landroid/view/ActionMode;)V

    .line 53
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v1, 0x0

    iput-object v1, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    .line 56
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearChoices()V

    .line 57
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 58
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->rememberSyncState()V

    .line 59
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->requestLayout()V

    .line 60
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setLongClickable(Z)V

    .line 61
    return-void
.end method

.method public onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V
    .locals 7
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "position"    # I
    .param p3, "id"    # J
    .param p5, "checked"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 66
    iget-object v1, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move v6, p5

    invoke-interface/range {v1 .. v6}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;->onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V

    .line 69
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mView:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->getCheckedItemCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 70
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    .line 72
    :cond_0
    return-void
.end method

.method public onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 40
    iget-object v0, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    invoke-interface {v0, p1, p2}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;->onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public setWrapped(Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;)V
    .locals 0
    .param p1, "wrapped"    # Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    .prologue
    .line 20
    iput-object p1, p0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->mWrapped:Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;

    .line 21
    return-void
.end method
