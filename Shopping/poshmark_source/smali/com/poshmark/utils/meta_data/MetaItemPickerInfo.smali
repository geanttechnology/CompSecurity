.class public Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
.super Ljava/lang/Object;
.source "MetaItemPickerInfo.java"


# instance fields
.field public allItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public currentCategory:Lcom/poshmark/data_model/models/MetaItem;

.field public currentSelection:Lcom/poshmark/data_model/models/MetaItem;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addToAllItems(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 1
    .param p1, "data"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 30
    return-void
.end method

.method public getAllItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentSelection()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public setAllItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 25
    return-void
.end method
