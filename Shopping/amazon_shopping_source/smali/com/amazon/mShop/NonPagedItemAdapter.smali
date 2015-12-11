.class public abstract Lcom/amazon/mShop/NonPagedItemAdapter;
.super Lcom/amazon/mShop/ObjectSubscriberAdapter;
.source "NonPagedItemAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field protected mAdapterView:Landroid/widget/AdapterView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/AdapterView",
            "<",
            "Landroid/widget/ListAdapter;",
            ">;"
        }
    .end annotation
.end field

.field protected mLayoutInflater:Landroid/view/LayoutInflater;

.field protected mRowResId:I


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "rowResId"    # I

    .prologue
    .line 24
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ObjectSubscriberAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 25
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/NonPagedItemAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 26
    iput p2, p0, Lcom/amazon/mShop/NonPagedItemAdapter;->mRowResId:I

    .line 27
    return-void
.end method


# virtual methods
.method public forward(ILandroid/view/View;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 40
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/NonPagedItemAdapter;->getCount()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 45
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/NonPagedItemAdapter;->getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/NonPagedItemAdapter;->makeObjectForForward(ILandroid/view/View;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected getAdapterViewHeaderViewsCount()I
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract makeObjectForForward(ILandroid/view/View;)Ljava/lang/Object;
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/amazon/mShop/NonPagedItemAdapter;->mAdapterView:Landroid/widget/AdapterView;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    sub-int v0, p3, v1

    .line 53
    .local v0, "index":I
    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/NonPagedItemAdapter;->forward(ILandroid/view/View;)V

    .line 54
    return-void

    .line 52
    .end local v0    # "index":I
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/NonPagedItemAdapter;->getAdapterViewHeaderViewsCount()I

    move-result v1

    goto :goto_0
.end method

.method public setAdapterView(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<",
            "Landroid/widget/ListAdapter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<Landroid/widget/ListAdapter;>;"
    iput-object p1, p0, Lcom/amazon/mShop/NonPagedItemAdapter;->mAdapterView:Landroid/widget/AdapterView;

    .line 35
    invoke-virtual {p1, p0}, Landroid/widget/AdapterView;->setAdapter(Landroid/widget/Adapter;)V

    .line 36
    invoke-virtual {p1, p0}, Landroid/widget/AdapterView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 37
    return-void
.end method
