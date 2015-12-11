.class public abstract Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;
.source "MultiDeleteBrowseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        "H:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter",
        "<TI;TH;>;"
    }
.end annotation


# instance fields
.field protected isEditMode:Z


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;)V
    .locals 0
    .param p1, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 14
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter<TI;TH;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 15
    return-void
.end method


# virtual methods
.method public abstract getData()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TI;>;"
        }
    .end annotation
.end method

.method public abstract removeItems(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TI;>;)V"
        }
    .end annotation
.end method

.method public abstract setData(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TI;>;)V"
        }
    .end annotation
.end method

.method public setEditMode(Z)V
    .locals 0
    .param p1, "isEditMode"    # Z

    .prologue
    .line 18
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter<TI;TH;>;"
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->isEditMode:Z

    .line 21
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;->notifyDataSetChanged()V

    .line 22
    return-void
.end method
