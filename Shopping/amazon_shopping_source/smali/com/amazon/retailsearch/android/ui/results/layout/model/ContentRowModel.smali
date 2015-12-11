.class public Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;
.super Ljava/lang/Object;
.source "ContentRowModel.java"


# instance fields
.field private final columns:I

.field private final content:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;",
            ">;"
        }
    .end annotation
.end field

.field private final spacing:I


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V
    .locals 3
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    .prologue
    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getSpacing()I

    move-result v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;-><init>(Ljava/util/List;II)V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/util/List;II)V
    .locals 0
    .param p2, "columns"    # I
    .param p3, "spacing"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "content":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->content:Ljava/util/List;

    .line 25
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->spacing:I

    .line 26
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->columns:I

    .line 27
    return-void
.end method


# virtual methods
.method public getColumns()I
    .locals 1

    .prologue
    .line 50
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->columns:I

    return v0
.end method

.method public getContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->content:Ljava/util/List;

    return-object v0
.end method

.method public getSpacing()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->spacing:I

    return v0
.end method
