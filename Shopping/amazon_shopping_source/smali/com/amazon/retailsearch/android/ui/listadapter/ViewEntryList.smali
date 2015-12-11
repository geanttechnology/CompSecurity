.class public Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;
.super Ljava/lang/Object;
.source "ViewEntryList.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Element:",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;"
    }
.end annotation


# instance fields
.field private final content:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TElement;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    .line 21
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "count"    # I

    .prologue
    .line 28
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TElement;>;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    .local p1, "content":Ljava/util/List;, "Ljava/util/List<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    .line 39
    return-void
.end method


# virtual methods
.method public getContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TElement;>;"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 55
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getType(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 63
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getType()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "index"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0, p2, p3}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 79
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->content:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->isEnabled()Z

    move-result v0

    return v0
.end method
