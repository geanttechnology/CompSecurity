.class Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;
.super Landroid/widget/BaseAdapter;
.source "SettingsFragment.java"

# interfaces
.implements Landroid/widget/SpinnerAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/SettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EditionsSpinnerAdapter"
.end annotation


# instance fields
.field private mCursor:Landroid/database/Cursor;

.field final synthetic this$0:Lco/vine/android/SettingsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/SettingsFragment;)V
    .locals 0

    .prologue
    .line 1708
    iput-object p1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->this$0:Lco/vine/android/SettingsFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public changeCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 1720
    iput-object p1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    .line 1721
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->notifyDataSetChanged()V

    .line 1722
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 1713
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 1714
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 1716
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCursor()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1800
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    return-object v0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 1754
    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-ge p1, v2, :cond_1

    .line 1756
    if-eqz p2, :cond_0

    .line 1757
    move-object v0, p2

    .line 1761
    .local v0, "res":Landroid/view/View;
    :goto_0
    const v2, 0x7f0a004a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 1762
    .local v1, "t":Landroid/widget/TextView;
    invoke-virtual {p0, p1}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->getEditionName(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1763
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 1764
    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 1767
    .end local v0    # "res":Landroid/view/View;
    .end local v1    # "t":Landroid/widget/TextView;
    :goto_1
    return-object v0

    .line 1759
    :cond_0
    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f030092

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "res":Landroid/view/View;
    goto :goto_0

    .end local v0    # "res":Landroid/view/View;
    :cond_1
    move-object v0, p2

    .line 1767
    goto :goto_1
.end method

.method public getEditionCode(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 1792
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 1793
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 1794
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1796
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getEditionName(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 1784
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 1785
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 1786
    iget-object v0, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1788
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 1726
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 1731
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 1736
    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-ge p1, v2, :cond_1

    .line 1738
    if-eqz p2, :cond_0

    .line 1739
    move-object v0, p2

    .line 1743
    .local v0, "res":Landroid/view/View;
    :goto_0
    const v2, 0x7f0a004a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 1744
    .local v1, "t":Landroid/widget/TextView;
    invoke-virtual {p0, p1}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->getEditionName(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1745
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 1746
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 1749
    .end local v0    # "res":Landroid/view/View;
    .end local v1    # "t":Landroid/widget/TextView;
    :goto_1
    return-object v0

    .line 1741
    :cond_0
    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f030092

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "res":Landroid/view/View;
    goto :goto_0

    .end local v0    # "res":Landroid/view/View;
    :cond_1
    move-object v0, p2

    .line 1749
    goto :goto_1
.end method

.method public setSelectionToUserEdition()V
    .locals 3

    .prologue
    .line 1771
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v1, :cond_1

    .line 1772
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v2, -0x1

    invoke-interface {v1, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 1773
    :cond_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1774
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1775
    .local v0, "editionCode":Ljava/lang/String;
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1200(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1776
    iget-object v1, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$2700(Lco/vine/android/SettingsFragment;)Landroid/widget/Spinner;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getPosition()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/Spinner;->setSelection(I)V

    .line 1781
    .end local v0    # "editionCode":Ljava/lang/String;
    :cond_1
    return-void
.end method
