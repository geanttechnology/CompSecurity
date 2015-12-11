.class Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;
.source "ViewHolderBaseAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;-><init>(Landroid/view/LayoutInflater;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate",
        "<TI;TH;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "x0"    # Landroid/view/LayoutInflater;

    .prologue
    .line 14
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/AdapterDelegate;-><init>(Landroid/view/LayoutInflater;)V

    return-void
.end method


# virtual methods
.method protected bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TH;TI;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    .local p1, "holder":Ljava/lang/Object;, "TH;"
    .local p2, "item":Ljava/lang/Object;, "TI;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->bindItem(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 28
    return-void
.end method

.method protected createViewHolder()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TH;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->createViewHolder()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "pos"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TI;"
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->getViewLayoutId()I

    move-result v0

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "parent"    # Landroid/view/ViewGroup;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Landroid/view/ViewGroup;",
            "TH;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;, "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter.1;"
    .local p3, "holder":Ljava/lang/Object;, "TH;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V

    .line 23
    return-void
.end method
