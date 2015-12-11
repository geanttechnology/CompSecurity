.class public Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
.super Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
.source "BrandsMetaItemPickerInfo.java"


# instance fields
.field public recentItems:Lcom/poshmark/utils/MetaItemList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 11
    new-instance v0, Lcom/poshmark/utils/MetaItemList;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Lcom/poshmark/utils/MetaItemList;-><init>(I)V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->recentItems:Lcom/poshmark/utils/MetaItemList;

    return-void
.end method


# virtual methods
.method public addToRecentItems(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 1
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/MetaItemList;->add(Ljava/lang/Object;)Z

    .line 19
    return-void
.end method

.method public getRecentItems()Lcom/poshmark/utils/MetaItemList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 14
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->recentItems:Lcom/poshmark/utils/MetaItemList;

    return-object v0
.end method
