.class public Lcom/poshmark/utils/SearchFilterModel$SearchFilters;
.super Ljava/lang/Object;
.source "SearchFilterModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/SearchFilterModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SearchFilters"
.end annotation


# instance fields
.field brand:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field category_feature:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field category_v2:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field color:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field condition:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field inventory_status:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field price_range:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field size:Lcom/poshmark/data_model/models/SizeFilter;

.field final synthetic this$0:Lcom/poshmark/utils/SearchFilterModel;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/SearchFilterModel;)V
    .locals 1

    .prologue
    .line 646
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->this$0:Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 644
    new-instance v0, Lcom/poshmark/data_model/models/SizeFilter;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SizeFilter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    .line 647
    return-void
.end method


# virtual methods
.method public addAvailability(Ljava/lang/String;)V
    .locals 1
    .param p1, "availabilityLabel"    # Ljava/lang/String;

    .prologue
    .line 668
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-nez v0, :cond_0

    .line 669
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    .line 673
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 674
    return-void

    .line 671
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addBrand(Ljava/lang/String;)V
    .locals 1
    .param p1, "brandLabel"    # Ljava/lang/String;

    .prologue
    .line 737
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    if-nez v0, :cond_0

    .line 738
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    .line 742
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 743
    return-void

    .line 740
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "catLabel"    # Ljava/lang/String;

    .prologue
    .line 650
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    if-nez v0, :cond_0

    .line 651
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    .line 655
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 656
    return-void

    .line 653
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addColor(Ljava/lang/String;)V
    .locals 1
    .param p1, "colorName"    # Ljava/lang/String;

    .prologue
    .line 895
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    if-nez v0, :cond_0

    .line 896
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    .line 898
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 899
    return-void
.end method

.method public addCondition(Ljava/lang/String;)V
    .locals 1
    .param p1, "conditionLabel"    # Ljava/lang/String;

    .prologue
    .line 659
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-nez v0, :cond_0

    .line 660
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    .line 664
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 665
    return-void

    .line 662
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addPriceRange(Lcom/poshmark/data_model/models/PriceInfo;)V
    .locals 1
    .param p1, "price"    # Lcom/poshmark/data_model/models/PriceInfo;

    .prologue
    .line 684
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    if-nez v0, :cond_0

    .line 685
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    .line 687
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 688
    return-void
.end method

.method public addSize(Ljava/lang/String;)V
    .locals 1
    .param p1, "sizeLabel"    # Ljava/lang/String;

    .prologue
    .line 677
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-nez v0, :cond_0

    .line 678
    new-instance v0, Lcom/poshmark/data_model/models/SizeFilter;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SizeFilter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    .line 680
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/SizeFilter;->addSize(Ljava/lang/String;)V

    .line 681
    return-void
.end method

.method public addSubCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 913
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    if-nez v0, :cond_0

    .line 914
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    .line 916
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 917
    return-void
.end method

.method public clearAvailabilityList()V
    .locals 1

    .prologue
    .line 877
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 878
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 879
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    .line 881
    :cond_0
    return-void
.end method

.method public clearBrandList()V
    .locals 1

    .prologue
    .line 783
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 784
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 785
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    .line 787
    :cond_0
    return-void
.end method

.method public clearCategoryList()V
    .locals 1

    .prologue
    .line 766
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 767
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 768
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    .line 770
    :cond_0
    return-void
.end method

.method public clearColorList()V
    .locals 1

    .prologue
    .line 888
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 889
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 890
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    .line 892
    :cond_0
    return-void
.end method

.method public clearConditionList()V
    .locals 1

    .prologue
    .line 850
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 851
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 852
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    .line 854
    :cond_0
    return-void
.end method

.method public clearInventoryStatusList()V
    .locals 1

    .prologue
    .line 777
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 778
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 780
    :cond_0
    return-void
.end method

.method public clearPriceRangeList()V
    .locals 1

    .prologue
    .line 827
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 828
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 829
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    .line 831
    :cond_0
    return-void
.end method

.method public clearSizeList()V
    .locals 2

    .prologue
    .line 806
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-eqz v1, :cond_0

    .line 807
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/SizeFilter;->getSizes()Ljava/util/List;

    move-result-object v0

    .line 808
    .local v0, "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 809
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 812
    .end local v0    # "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method public clearSubCategoryList()V
    .locals 1

    .prologue
    .line 906
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 907
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 908
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    .line 910
    :cond_0
    return-void
.end method

.method public enableMySize(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 691
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-nez v0, :cond_0

    .line 692
    new-instance v0, Lcom/poshmark/data_model/models/SizeFilter;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SizeFilter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    .line 694
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/SizeFilter;->enableMySize(Z)V

    .line 695
    return-void
.end method

.method public enableNWTOption(Z)V
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 711
    if-eqz p1, :cond_1

    .line 712
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-nez v0, :cond_0

    .line 713
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    .line 717
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    const-string v1, "nwt"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 721
    :goto_1
    return-void

    .line 715
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 719
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    goto :goto_1
.end method

.method public enableRetailOption(Z)V
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 724
    if-eqz p1, :cond_1

    .line 725
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-nez v0, :cond_0

    .line 726
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    .line 730
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    const-string v1, "ret"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 734
    :goto_1
    return-void

    .line 728
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 732
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    goto :goto_1
.end method

.method public enableUnsoldOption(Z)V
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 698
    if-eqz p1, :cond_1

    .line 699
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-nez v0, :cond_0

    .line 700
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    .line 704
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    const-string v1, "available"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 708
    :goto_1
    return-void

    .line 702
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 706
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    goto :goto_1
.end method

.method public getAvailabilityList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 865
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    return-object v0
.end method

.method public getBrand()Ljava/lang/String;
    .locals 2

    .prologue
    .line 790
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 791
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 793
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBrandList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 773
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    return-object v0
.end method

.method public getCategoryFeature()Ljava/lang/String;
    .locals 2

    .prologue
    .line 754
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 755
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 757
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCategoryList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 762
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    return-object v0
.end method

.method public getCategory_v2()Ljava/lang/String;
    .locals 2

    .prologue
    .line 746
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 747
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 749
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getColorList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 884
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 2

    .prologue
    .line 857
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 858
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 860
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getConditionList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 846
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    return-object v0
.end method

.method public getInventory_status()Ljava/lang/String;
    .locals 2

    .prologue
    .line 869
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 870
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 872
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPriceRangeDisplayList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 834
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    if-nez v2, :cond_1

    .line 835
    const/4 v0, 0x0

    .line 842
    :cond_0
    return-object v0

    .line 837
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 838
    .local v0, "displayList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 839
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PriceInfo;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 838
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public getPriceRangeList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 823
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    return-object v0
.end method

.method public getSizeList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 798
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-eqz v0, :cond_0

    .line 799
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SizeFilter;->getSizes()Ljava/util/List;

    move-result-object v0

    .line 801
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSubCategoryList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 902
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    return-object v0
.end method

.method public isMySizeEnabled()Z
    .locals 1

    .prologue
    .line 815
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-eqz v0, :cond_0

    .line 816
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SizeFilter;->getMySizeFlag()Z

    move-result v0

    .line 818
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setSubCategories(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 920
    .local p1, "subCategoryList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    if-nez v0, :cond_0

    .line 921
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    .line 923
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 924
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 925
    return-void
.end method
