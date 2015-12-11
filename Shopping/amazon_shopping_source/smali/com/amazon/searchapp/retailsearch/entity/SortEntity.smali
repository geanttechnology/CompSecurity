.class public Lcom/amazon/searchapp/retailsearch/entity/SortEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SortEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Sort;


# instance fields
.field private options:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SelectedOption;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getOptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SelectedOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;->options:Ljava/util/List;

    return-object v0
.end method

.method public setOptions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SelectedOption;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "options":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SelectedOption;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;->options:Ljava/util/List;

    .line 34
    return-void
.end method
