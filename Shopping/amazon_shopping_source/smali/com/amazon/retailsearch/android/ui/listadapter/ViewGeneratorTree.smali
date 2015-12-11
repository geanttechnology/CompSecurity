.class public Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;
.super Ljava/lang/Object;
.source "ViewGeneratorTree.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Element::",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;"
    }
.end annotation


# instance fields
.field private final children:Ljava/util/List;
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
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    .line 21
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "capacity"    # I

    .prologue
    .line 28
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

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
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    .local p1, "children":Ljava/util/List;, "Ljava/util/List<TElement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    .line 39
    return-void
.end method


# virtual methods
.method public getChildren()Ljava/util/List;
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
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    return-object v0
.end method

.method public getCount()I
    .locals 4

    .prologue
    .line 55
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    const/4 v0, 0x0

    .line 57
    .local v0, "count":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .line 58
    .local v2, "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    invoke-interface {v2}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getCount()I

    move-result v3

    add-int/2addr v0, v3

    goto :goto_0

    .line 61
    .end local v2    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    :cond_0
    return v0
.end method

.method public getType(I)I
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 69
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .line 70
    .local v1, "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getCount()I

    move-result v2

    .line 72
    .local v2, "size":I
    if-ge p1, v2, :cond_0

    .line 73
    invoke-interface {v1, p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getType(I)I

    move-result v3

    .line 79
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :goto_1
    return v3

    .line 76
    .restart local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .restart local v2    # "size":I
    :cond_0
    sub-int/2addr p1, v2

    .line 77
    goto :goto_0

    .line 79
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :cond_1
    const/4 v3, -0x1

    goto :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "index"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 87
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .line 88
    .local v1, "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getCount()I

    move-result v2

    .line 90
    .local v2, "size":I
    if-ge p1, v2, :cond_0

    .line 91
    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 97
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :goto_1
    return-object v3

    .line 94
    .restart local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .restart local v2    # "size":I
    :cond_0
    sub-int/2addr p1, v2

    .line 95
    goto :goto_0

    .line 97
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public isEnabled(I)Z
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 105
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree<TElement;>;"
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGeneratorTree;->children:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .line 106
    .local v1, "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getCount()I

    move-result v2

    .line 108
    .local v2, "size":I
    if-ge p1, v2, :cond_0

    .line 109
    invoke-interface {v1, p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->isEnabled(I)Z

    move-result v3

    .line 115
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :goto_1
    return v3

    .line 112
    .restart local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .restart local v2    # "size":I
    :cond_0
    sub-int/2addr p1, v2

    .line 113
    goto :goto_0

    .line 115
    .end local v1    # "item":Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;, "TElement;"
    .end local v2    # "size":I
    :cond_1
    const/4 v3, 0x1

    goto :goto_1
.end method
