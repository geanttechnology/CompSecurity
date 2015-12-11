.class Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;
.super Ljava/lang/Object;
.source "SizesMetaData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CategorySizes"
.end annotation


# instance fields
.field categoryName:Ljava/lang/String;

.field sizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$1:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;)V
    .locals 1

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;->this$1:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes$CategorySizes;->sizes:Ljava/util/List;

    return-void
.end method
