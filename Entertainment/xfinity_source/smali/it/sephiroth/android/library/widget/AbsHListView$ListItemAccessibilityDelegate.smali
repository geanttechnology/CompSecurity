.class Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;
.super Landroid/support/v4/view/AccessibilityDelegateCompat;
.source "AbsHListView.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ListItemAccessibilityDelegate"
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 0

    .prologue
    .line 1992
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Landroid/support/v4/view/AccessibilityDelegateCompat;-><init>()V

    return-void
.end method


# virtual methods
.method public onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;)V
    .locals 4
    .param p1, "host"    # Landroid/view/View;
    .param p2, "info"    # Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    .prologue
    const/4 v3, 0x1

    .line 1996
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/AccessibilityDelegateCompat;->onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;)V

    .line 1998
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getPositionForView(Landroid/view/View;)I

    move-result v1

    .line 1999
    .local v1, "position":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 2001
    .local v0, "adapter":Landroid/widget/ListAdapter;
    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    if-nez v0, :cond_1

    .line 2026
    :cond_0
    :goto_0
    return-void

    .line 2005
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2009
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v2

    if-ne v1, v2, :cond_3

    .line 2010
    invoke-virtual {p2, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->setSelected(Z)V

    .line 2011
    const/16 v2, 0x8

    invoke-virtual {p2, v2}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->addAction(I)V

    .line 2016
    :goto_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->isClickable()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 2017
    const/16 v2, 0x10

    invoke-virtual {p2, v2}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->addAction(I)V

    .line 2018
    invoke-virtual {p2, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->setClickable(Z)V

    .line 2021
    :cond_2
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->isLongClickable()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2022
    const/16 v2, 0x20

    invoke-virtual {p2, v2}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->addAction(I)V

    .line 2023
    invoke-virtual {p2, v3}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->setLongClickable(Z)V

    goto :goto_0

    .line 2013
    :cond_3
    const/4 v2, 0x4

    invoke-virtual {p2, v2}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->addAction(I)V

    goto :goto_1
.end method

.method public performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 8
    .param p1, "host"    # Landroid/view/View;
    .param p2, "action"    # I
    .param p3, "arguments"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, -0x1

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 2030
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/view/AccessibilityDelegateCompat;->performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 2078
    :goto_0
    return v4

    .line 2034
    :cond_0
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getPositionForView(Landroid/view/View;)I

    move-result v1

    .line 2035
    .local v1, "position":I
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 2037
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-eq v1, v7, :cond_1

    if-nez v0, :cond_2

    :cond_1
    move v4, v5

    .line 2039
    goto :goto_0

    .line 2042
    :cond_2
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v6

    if-nez v6, :cond_4

    :cond_3
    move v4, v5

    .line 2044
    goto :goto_0

    .line 2047
    :cond_4
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getItemIdAtPosition(I)J

    move-result-wide v2

    .line 2049
    .local v2, "id":J
    sparse-switch p2, :sswitch_data_0

    move v4, v5

    .line 2078
    goto :goto_0

    .line 2051
    :sswitch_0
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v6

    if-ne v6, v1, :cond_5

    .line 2052
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v5, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelection(I)V

    goto :goto_0

    :cond_5
    move v4, v5

    .line 2056
    goto :goto_0

    .line 2058
    :sswitch_1
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v6

    if-eq v6, v1, :cond_6

    .line 2059
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v5, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelection(I)V

    goto :goto_0

    :cond_6
    move v4, v5

    .line 2063
    goto :goto_0

    .line 2065
    :sswitch_2
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->isClickable()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 2066
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4, p1, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->performItemClick(Landroid/view/View;IJ)Z

    move-result v4

    goto :goto_0

    :cond_7
    move v4, v5

    .line 2069
    goto :goto_0

    .line 2071
    :sswitch_3
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->isLongClickable()Z

    move-result v4

    if-eqz v4, :cond_8

    .line 2072
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4, p1, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->performLongPress(Landroid/view/View;IJ)Z

    move-result v4

    goto :goto_0

    :cond_8
    move v4, v5

    .line 2075
    goto :goto_0

    .line 2049
    nop

    :sswitch_data_0
    .sparse-switch
        0x4 -> :sswitch_1
        0x8 -> :sswitch_0
        0x10 -> :sswitch_2
        0x20 -> :sswitch_3
    .end sparse-switch
.end method
