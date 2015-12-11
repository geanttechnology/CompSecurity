.class Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;
.super Ljava/lang/Object;
.source "BrandsMetaData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/meta_data/BrandsMetaData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Brands"
.end annotation


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/utils/meta_data/BrandsMetaData;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/meta_data/BrandsMetaData;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->this$0:Lcom/poshmark/utils/meta_data/BrandsMetaData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBrandFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 120
    iget-object v2, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->data:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 121
    iget-object v2, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 122
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 123
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 124
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 129
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getList()Ljava/util/List;
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
    .line 116
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->data:Ljava/util/List;

    return-object v0
.end method
