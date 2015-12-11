.class Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
.super Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;
.source "LayoutElement.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Entry:",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;",
        ">",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper",
        "<TEntry;>;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
        "<*>;>;"
    }
.end annotation


# instance fields
.field private final layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

.field private loaders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation
.end field

.field private position:I

.field private final priority:I

.field private final requestedPosition:I

.field private final section:I

.field private final span:I


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IIIILjava/util/List;ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 0
    .param p2, "section"    # I
    .param p3, "requestedPosition"    # I
    .param p4, "priority"    # I
    .param p5, "span"    # I
    .param p7, "position"    # I
    .param p8, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TEntry;IIII",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;I",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    .local p1, "viewEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;, "TEntry;"
    .local p6, "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;)V

    .line 32
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->section:I

    .line 33
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->requestedPosition:I

    .line 34
    iput p4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->priority:I

    .line 35
    iput p5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->span:I

    .line 36
    iput-object p6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->loaders:Ljava/util/List;

    .line 37
    iput p7, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->position:I

    .line 38
    iput-object p8, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .line 39
    return-void
.end method

.method constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 9
    .param p2, "section"    # I
    .param p3, "requestedPosition"    # I
    .param p4, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TEntry;II",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    .local p1, "viewEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;, "TEntry;"
    const/4 v4, 0x0

    .line 42
    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v7, v4

    move-object v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IIIILjava/util/List;ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 43
    return-void
.end method


# virtual methods
.method addLoader(Lcom/amazon/ansel/fetch/tools/collection/Factory;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 66
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    .local p1, "loader":Lcom/amazon/ansel/fetch/tools/collection/Factory;, "Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->loaders:Ljava/util/List;

    if-nez v0, :cond_0

    .line 67
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->loaders:Ljava/util/List;

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->loaders:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 71
    return-void
.end method

.method public compareTo(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)I"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    .local p1, "x":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->section:I

    iget v2, p1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->section:I

    sub-int v0, v1, v2

    .line 90
    .local v0, "d":I
    if-eqz v0, :cond_0

    move v1, v0

    .line 95
    :goto_0
    return v1

    .line 94
    :cond_0
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->requestedPosition:I

    iget v2, p1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->requestedPosition:I

    sub-int v0, v1, v2

    .line 95
    if-eqz v0, :cond_1

    move v1, v0

    goto :goto_0

    :cond_1
    iget v1, p1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->priority:I

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->priority:I

    sub-int/2addr v1, v2

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 19
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->compareTo(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)I

    move-result v0

    return v0
.end method

.method getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .locals 1

    .prologue
    .line 83
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    return-object v0
.end method

.method getLoaders()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation

    .prologue
    .line 62
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->loaders:Ljava/util/List;

    return-object v0
.end method

.method getPosition()I
    .locals 1

    .prologue
    .line 74
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->position:I

    return v0
.end method

.method getPriority()I
    .locals 1

    .prologue
    .line 54
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->priority:I

    return v0
.end method

.method getRequestedPosition()I
    .locals 1

    .prologue
    .line 50
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->requestedPosition:I

    return v0
.end method

.method getSection()I
    .locals 1

    .prologue
    .line 46
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->section:I

    return v0
.end method

.method getSpan()I
    .locals 1

    .prologue
    .line 58
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->span:I

    return v0
.end method

.method setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 78
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<TEntry;>;"
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->position:I

    .line 79
    return-void
.end method
