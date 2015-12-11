.class Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "AdapterView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AdapterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AdapterDataSetObserver"
.end annotation


# instance fields
.field private mInstanceState:Landroid/os/Parcelable;

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AdapterView;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AdapterView;)V
    .locals 1

    .prologue
    .line 808
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.AdapterDataSetObserver;"
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    .line 810
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->mInstanceState:Landroid/os/Parcelable;

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 817
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.AdapterDataSetObserver;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lit/sephiroth/android/library/widget/AdapterView;->mDataChanged:Z

    .line 818
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget v1, v1, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    iput v1, v0, Lit/sephiroth/android/library/widget/AdapterView;->mOldItemCount:I

    .line 819
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v1

    invoke-interface {v1}, Landroid/widget/Adapter;->getCount()I

    move-result v1

    iput v1, v0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    .line 824
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/Adapter;->hasStableIds()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->mInstanceState:Landroid/os/Parcelable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget v0, v0, Lit/sephiroth/android/library/widget/AdapterView;->mOldItemCount:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget v0, v0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    if-lez v0, :cond_0

    .line 829
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->mInstanceState:Landroid/os/Parcelable;

    # invokes: Lit/sephiroth/android/library/widget/AdapterView;->onRestoreInstanceState(Landroid/os/Parcelable;)V
    invoke-static {v0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->access$000(Lit/sephiroth/android/library/widget/AdapterView;Landroid/os/Parcelable;)V

    .line 830
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->mInstanceState:Landroid/os/Parcelable;

    .line 837
    :goto_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->checkFocus()V

    .line 838
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->requestLayout()V

    .line 839
    return-void

    .line 835
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->rememberSyncState()V

    goto :goto_0
.end method

.method public onInvalidated()V
    .locals 6

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.AdapterDataSetObserver;"
    const-wide/high16 v4, -0x8000000000000000L

    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 846
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lit/sephiroth/android/library/widget/AdapterView;->mDataChanged:Z

    .line 848
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/Adapter;->hasStableIds()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 851
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    # invokes: Lit/sephiroth/android/library/widget/AdapterView;->onSaveInstanceState()Landroid/os/Parcelable;
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AdapterView;->access$100(Lit/sephiroth/android/library/widget/AdapterView;)Landroid/os/Parcelable;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->mInstanceState:Landroid/os/Parcelable;

    .line 855
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget v1, v1, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    iput v1, v0, Lit/sephiroth/android/library/widget/AdapterView;->mOldItemCount:I

    .line 856
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput v3, v0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    .line 857
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput v2, v0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 858
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput-wide v4, v0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 859
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput v2, v0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 860
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput-wide v4, v0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 861
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iput-boolean v3, v0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 863
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->checkFocus()V

    .line 864
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->requestLayout()V

    .line 865
    return-void
.end method
