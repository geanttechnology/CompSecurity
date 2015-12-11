.class public abstract Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;
.super Landroid/widget/BaseAdapter;
.source "ViewHolderBaseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        "H:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/widget/BaseAdapter;"
    }
.end annotation


# instance fields
.field private adapterDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate",
            "<TI;TH;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;)V
    .locals 1
    .param p1, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter<TI;TH;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 14
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;Landroid/view/LayoutInflater;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->adapterDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;

    .line 40
    return-void
.end method


# virtual methods
.method protected abstract bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TH;TI;)V"
        }
    .end annotation
.end method

.method protected abstract createViewHolder()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TH;"
        }
    .end annotation
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "pos"    # I

    .prologue
    .line 63
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter<TI;TH;>;"
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter<TI;TH;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->adapterDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getViewLayoutId()I
.end method

.method protected abstract initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Landroid/view/ViewGroup;",
            "TH;)V"
        }
    .end annotation
.end method
