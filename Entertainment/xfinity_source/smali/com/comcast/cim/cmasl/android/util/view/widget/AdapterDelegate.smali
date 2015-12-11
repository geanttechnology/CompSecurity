.class public abstract Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;
.super Ljava/lang/Object;
.source "AdapterDelegate.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        "H:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private inflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;)V
    .locals 0
    .param p1, "inflater"    # Landroid/view/LayoutInflater;

    .prologue
    .line 19
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;, "Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate<TI;TH;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->inflater:Landroid/view/LayoutInflater;

    .line 21
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

.method protected abstract getItem(I)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TI;"
        }
    .end annotation
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "pos"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;, "Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate<TI;TH;>;"
    if-nez p2, :cond_0

    .line 34
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->inflater:Landroid/view/LayoutInflater;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->getViewLayoutId()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 36
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->createViewHolder()Ljava/lang/Object;

    move-result-object v0

    .line 38
    .local v0, "holder":Ljava/lang/Object;, "TH;"
    invoke-virtual {p0, p2, p3, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V

    .line 40
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 52
    :goto_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 53
    .local v1, "item":Ljava/lang/Object;, "TI;"
    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;->bindItem(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 55
    return-object p2

    .line 48
    .end local v0    # "holder":Ljava/lang/Object;, "TH;"
    .end local v1    # "item":Ljava/lang/Object;, "TI;"
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .restart local v0    # "holder":Ljava/lang/Object;, "TH;"
    goto :goto_0
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
