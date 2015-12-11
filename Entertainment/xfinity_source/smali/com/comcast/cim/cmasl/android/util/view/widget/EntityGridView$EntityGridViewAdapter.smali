.class public abstract Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;
.source "EntityGridView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "EntityGridViewAdapter"
.end annotation

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
.field private entities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TI;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;)V
    .locals 1
    .param p1, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 215
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;TH;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 212
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->entities:Ljava/util/List;

    .line 216
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 219
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;TH;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->entities:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "i"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TI;"
        }
    .end annotation

    .prologue
    .line 223
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;TH;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->entities:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setEntities(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TI;>;)V"
        }
    .end annotation

    .prologue
    .line 227
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;TH;>;"
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<TI;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->entities:Ljava/util/List;

    .line 228
    return-void
.end method
