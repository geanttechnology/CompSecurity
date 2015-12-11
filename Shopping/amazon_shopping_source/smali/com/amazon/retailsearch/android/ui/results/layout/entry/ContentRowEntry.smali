.class public Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;
.super Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;
.source "ContentRowEntry.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;",
        "Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(ILcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V
    .locals 1
    .param p1, "type"    # I
    .param p2, "model"    # Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    .prologue
    .line 12
    const-class v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;-><init>(ILjava/lang/Class;Ljava/lang/Object;)V

    .line 13
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;)V
    .locals 3
    .param p1, "entry"    # Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    .prologue
    .line 16
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getType()I

    move-result v1

    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-direct {v2, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V

    invoke-direct {p0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;-><init>(ILcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V

    .line 17
    return-void
.end method
