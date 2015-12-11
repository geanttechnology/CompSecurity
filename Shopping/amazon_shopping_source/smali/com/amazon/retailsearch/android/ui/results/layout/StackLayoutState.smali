.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
.super Ljava/lang/Object;
.source "StackLayoutState.java"


# instance fields
.field private asinEntryGroupIndex:I

.field private asinGroupMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private atfImagesLoadedCount:I

.field private entryAsin:Ljava/lang/String;

.field private final mainContent:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;",
            ">;"
        }
    .end annotation
.end field

.field private nextPosition:I

.field private final pendingContent:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;>;"
        }
    .end annotation
.end field

.field private productCount:I

.field private productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;"
        }
    .end annotation
.end field

.field private productRowCount:I

.field private final products:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation
.end field

.field private relatedSearchesExists:Z

.field private startingPosition:I

.field private startingProductRowCount:I

.field private startingSize:I


# direct methods
.method constructor <init>()V
    .locals 13

    .prologue
    const/4 v1, 0x0

    .line 58
    new-instance v8, Ljava/util/ArrayList;

    const/16 v0, 0x8

    invoke-direct {v8, v0}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v9, 0x0

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    move-object v0, p0

    move v2, v1

    move v3, v1

    move v4, v1

    move v5, v1

    move v6, v1

    move v7, v1

    move v12, v1

    invoke-direct/range {v0 .. v12}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>(IIIIIIILjava/util/List;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;Ljava/util/List;Ljava/util/List;Z)V

    .line 66
    return-void
.end method

.method constructor <init>(IIIIIIILjava/util/List;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;Ljava/util/List;Ljava/util/List;Z)V
    .locals 1
    .param p1, "startingSize"    # I
    .param p2, "startingPosition"    # I
    .param p3, "nextPosition"    # I
    .param p4, "startingProductRowCount"    # I
    .param p5, "productRowCount"    # I
    .param p6, "productCount"    # I
    .param p7, "atfImagesLoadedCount"    # I
    .param p12, "relatedSearchesExists"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IIIIIII",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;>;Z)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p8, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    .local p9, "productRow":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;>;"
    .local p10, "mainContent":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;>;"
    .local p11, "pendingContent":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingSize:I

    .line 43
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingPosition:I

    .line 44
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->nextPosition:I

    .line 45
    iput p4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingProductRowCount:I

    .line 46
    iput p5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRowCount:I

    .line 47
    iput p6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productCount:I

    .line 48
    iput p7, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->atfImagesLoadedCount:I

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p8}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->products:Ljava/util/List;

    .line 50
    iput-object p9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p10}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->mainContent:Ljava/util/List;

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p11}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->pendingContent:Ljava/util/List;

    .line 53
    iput-boolean p12, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->relatedSearchesExists:Z

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->asinGroupMap:Ljava/util/HashMap;

    .line 55
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;)V
    .locals 13
    .param p1, "pageState"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .prologue
    .line 69
    iget v1, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingSize:I

    iget v2, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingPosition:I

    iget v3, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->nextPosition:I

    iget v4, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingProductRowCount:I

    iget v5, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRowCount:I

    iget v6, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productCount:I

    iget v7, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->atfImagesLoadedCount:I

    new-instance v8, Ljava/util/ArrayList;

    iget-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->products:Ljava/util/List;

    invoke-direct {v8, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iget-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->copyProductRow(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v9

    :goto_0
    new-instance v10, Ljava/util/ArrayList;

    iget-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->mainContent:Ljava/util/List;

    invoke-direct {v10, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance v11, Ljava/util/ArrayList;

    iget-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->pendingContent:Ljava/util/List;

    invoke-direct {v11, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iget-boolean v12, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->relatedSearchesExists:Z

    move-object v0, p0

    invoke-direct/range {v0 .. v12}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>(IIIIIIILjava/util/List;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;Ljava/util/List;Ljava/util/List;Z)V

    .line 83
    return-void

    .line 69
    :cond_0
    const/4 v9, 0x0

    goto :goto_0
.end method

.method private static copyProductRow(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;)",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 204
    .local p0, "element":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;>;"
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-direct {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;)V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getRequestedPosition()I

    move-result v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPriority()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSpan()I

    move-result v5

    new-instance v6, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLoaders()Ljava/util/List;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPosition()I

    move-result v7

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IIIILjava/util/List;ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    return-object v0
.end method


# virtual methods
.method public getAsinGroupMap()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 170
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->asinGroupMap:Ljava/util/HashMap;

    return-object v0
.end method

.method getAtfImagesLoadedCount()I
    .locals 1

    .prologue
    .line 134
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->atfImagesLoadedCount:I

    return v0
.end method

.method protected getEntryAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->entryAsin:Ljava/lang/String;

    return-object v0
.end method

.method getEntryGroupIndex()I
    .locals 1

    .prologue
    .line 178
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->asinEntryGroupIndex:I

    return v0
.end method

.method getMainContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->mainContent:Ljava/util/List;

    return-object v0
.end method

.method getNextPosition()I
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->nextPosition:I

    return v0
.end method

.method getPendingContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->pendingContent:Ljava/util/List;

    return-object v0
.end method

.method getProductCount()I
    .locals 1

    .prologue
    .line 126
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productCount:I

    return v0
.end method

.method getProductRow()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    return-object v0
.end method

.method getProductRowCount()I
    .locals 1

    .prologue
    .line 118
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRowCount:I

    return v0
.end method

.method getProducts()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->products:Ljava/util/List;

    return-object v0
.end method

.method getRelatedSearchesExists()Z
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->relatedSearchesExists:Z

    return v0
.end method

.method getStartingPosition()I
    .locals 1

    .prologue
    .line 94
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingPosition:I

    return v0
.end method

.method getStartingProductRowCount()I
    .locals 1

    .prologue
    .line 110
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingProductRowCount:I

    return v0
.end method

.method getStartingSize()I
    .locals 1

    .prologue
    .line 86
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingSize:I

    return v0
.end method

.method setAtfImagesLoadedCount(I)V
    .locals 0
    .param p1, "atfImagesLoadedCount"    # I

    .prologue
    .line 138
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->atfImagesLoadedCount:I

    .line 139
    return-void
.end method

.method protected setEntryAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "entryAsin"    # Ljava/lang/String;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->entryAsin:Ljava/lang/String;

    .line 195
    return-void
.end method

.method setEntryGroupIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 174
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->asinEntryGroupIndex:I

    .line 175
    return-void
.end method

.method setNextPosition(I)V
    .locals 0
    .param p1, "nextPosition"    # I

    .prologue
    .line 106
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->nextPosition:I

    .line 107
    return-void
.end method

.method setProductCount(I)V
    .locals 0
    .param p1, "productCount"    # I

    .prologue
    .line 130
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productCount:I

    .line 131
    return-void
.end method

.method setProductRow(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 150
    .local p1, "productRow":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRow:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .line 151
    return-void
.end method

.method setProductRowCount(I)V
    .locals 0
    .param p1, "productRowCount"    # I

    .prologue
    .line 122
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->productRowCount:I

    .line 123
    return-void
.end method

.method setRelatedSearchesExists(Z)V
    .locals 0
    .param p1, "relatedSearchesExists"    # Z

    .prologue
    .line 166
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->relatedSearchesExists:Z

    .line 167
    return-void
.end method

.method setStartingPosition(I)V
    .locals 0
    .param p1, "startingPosition"    # I

    .prologue
    .line 98
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingPosition:I

    .line 99
    return-void
.end method

.method setStartingProductRowCount(I)V
    .locals 0
    .param p1, "startingProductRowCount"    # I

    .prologue
    .line 114
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingProductRowCount:I

    .line 115
    return-void
.end method

.method setStartingSize(I)V
    .locals 0
    .param p1, "startingSize"    # I

    .prologue
    .line 90
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->startingSize:I

    .line 91
    return-void
.end method
