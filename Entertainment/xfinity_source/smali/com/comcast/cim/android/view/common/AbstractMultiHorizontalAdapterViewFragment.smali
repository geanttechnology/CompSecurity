.class public abstract Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;
.super Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
.source "AbstractMultiHorizontalAdapterViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
        "<TI;",
        "Lit/sephiroth/android/library/widget/AdapterView;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment<TI;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract getOnItemClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;
.end method

.method protected abstract getOnItemLongClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;
.end method

.method protected initInfoView(ILcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V
    .locals 2
    .param p1, "resId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<TI;",
            "Lit/sephiroth/android/library/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V"
        }
    .end annotation

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment<TI;>;"
    .local p2, "info":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;Lit/sephiroth/android/library/widget/AdapterView;>.AdapterViewInfo;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lit/sephiroth/android/library/widget/AdapterView;

    iput-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    .line 10
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Lit/sephiroth/android/library/widget/AdapterView;

    iget-object v1, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->setAdapter(Landroid/widget/Adapter;)V

    .line 11
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->getOnItemClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V

    .line 12
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->getOnItemLongClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->setOnItemLongClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;)V

    .line 13
    return-void
.end method
