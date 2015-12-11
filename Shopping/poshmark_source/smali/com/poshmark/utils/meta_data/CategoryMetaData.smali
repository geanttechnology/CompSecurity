.class public Lcom/poshmark/utils/meta_data/CategoryMetaData;
.super Ljava/lang/Object;
.source "CategoryMetaData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;
    }
.end annotation


# static fields
.field public static final sCategoryAccessories:Ljava/lang/String; = "Accessories"

.field public static final sCategoryBoots:Ljava/lang/String; = "Boots"

.field public static final sCategoryClutchesAndWallets:Ljava/lang/String; = "Clutches & Wallets"

.field public static final sCategoryDenim:Ljava/lang/String; = "Denim"

.field public static final sCategoryDressesAndSkirts:Ljava/lang/String; = "Dresses & Skirts"

.field public static final sCategoryHandbags:Ljava/lang/String; = "Handbags"

.field public static final sCategoryJacketsAndBlazers:Ljava/lang/String; = "Jackets & Blazers"

.field public static final sCategoryJewelry:Ljava/lang/String; = "Jewelry"

.field public static final sCategoryOther:Ljava/lang/String; = "Other"

.field public static final sCategoryOuterwear:Ljava/lang/String; = "Outerwear"

.field public static final sCategoryPants:Ljava/lang/String; = "Pants"

.field public static final sCategoryShoes:Ljava/lang/String; = "Shoes"

.field public static final sCategorySweaters:Ljava/lang/String; = "Sweaters"

.field public static final sCategoryTops:Ljava/lang/String; = "Tops"


# instance fields
.field categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData;->categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    if-nez v0, :cond_0

    .line 34
    new-instance v0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;-><init>(Lcom/poshmark/utils/meta_data/CategoryMetaData;)V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData;->categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    .line 35
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData;->categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->loadCategories()V

    .line 37
    :cond_0
    return-void
.end method


# virtual methods
.method public getAllCategories()Ljava/util/List;
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
    .line 44
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData;->categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->getAllCategories()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getCategory(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData;->categories:Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->getMatchingItem(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method
