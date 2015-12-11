.class public Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# instance fields
.field private array:Ljava/util/List;

.field private mInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 20
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->array:Ljava/util/List;

    .line 21
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 22
    return-void
.end method


# virtual methods
.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->array:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getViewType()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->array:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;->mInflater:Landroid/view/LayoutInflater;

    invoke-interface {v0, v1, p2}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 30
    invoke-static {}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->values()[Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    move-result-object v0

    array-length v0, v0

    return v0
.end method
