.class public abstract Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;
.super Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
.source "AbstractMultiAdapterViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
        "<TI;",
        "Landroid/widget/AdapterView;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment<TI;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract getOnItemClickListener()Landroid/widget/AdapterView$OnItemClickListener;
.end method

.method protected abstract getOnItemLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;
.end method

.method protected initInfoView(ILcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V
    .locals 2
    .param p1, "resId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<TI;",
            "Landroid/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V"
        }
    .end annotation

    .prologue
    .line 8
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment<TI;>;"
    .local p2, "info":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;Landroid/widget/AdapterView;>.AdapterViewInfo;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AdapterView;

    iput-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    .line 9
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Landroid/widget/AdapterView;

    iget-object v1, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AdapterView;->setAdapter(Landroid/widget/Adapter;)V

    .line 10
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Landroid/widget/AdapterView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->getOnItemClickListener()Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AdapterView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 11
    iget-object v0, p2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->view:Landroid/view/ViewGroup;

    check-cast v0, Landroid/widget/AdapterView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->getOnItemLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AdapterView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 12
    return-void
.end method
