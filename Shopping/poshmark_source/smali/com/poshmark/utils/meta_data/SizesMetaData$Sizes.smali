.class Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;
.super Ljava/lang/Object;
.source "SizesMetaData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/meta_data/SizesMetaData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Sizes"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;
    }
.end annotation


# instance fields
.field sizes_by_category:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/utils/meta_data/SizesMetaData;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/meta_data/SizesMetaData;)V
    .locals 1

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->this$0:Lcom/poshmark/utils/meta_data/SizesMetaData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->sizes_by_category:Ljava/util/List;

    .line 75
    return-void
.end method


# virtual methods
.method public getSizesForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .param p1, "categoryName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 80
    iget-object v2, p0, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->sizes_by_category:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 81
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 82
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;

    .line 83
    .local v1, "sizes":Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;
    iget-object v2, v1, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;->categoryName:Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 84
    iget-object v2, v1, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;->sizes:Ljava/util/List;

    .line 87
    .end local v1    # "sizes":Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;
    :goto_0
    return-object v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method
