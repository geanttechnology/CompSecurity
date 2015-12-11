.class public Lcom/poshmark/utils/meta_data/BrandsMetaData;
.super Ljava/lang/Object;
.source "BrandsMetaData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;
    }
.end annotation


# instance fields
.field allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

.field brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 22
    iput-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 30
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 1
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 22
    iput-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 25
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/meta_data/BrandsMetaData;->loadBrandsOfCategory(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 26
    return-void
.end method


# virtual methods
.method public getAllBrands()Ljava/util/List;
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
    .line 105
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    if-nez v0, :cond_0

    .line 106
    invoke-virtual {p0}, Lcom/poshmark/utils/meta_data/BrandsMetaData;->loadAllBrands()V

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->data:Ljava/util/List;

    return-object v0
.end method

.method public getBrand(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->getBrandFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    .line 93
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBrandListForCategory()Ljava/util/List;
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
    .line 97
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;->data:Ljava/util/List;

    .line 100
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadAllBrands()V
    .locals 9

    .prologue
    .line 71
    :try_start_0
    const-string v2, "listing_meta/All.json"

    .line 72
    .local v2, "fileName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v7

    invoke-virtual {v7, v2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    .line 73
    .local v4, "ip":Ljava/io/InputStream;
    new-instance v6, Ljava/io/StringWriter;

    invoke-direct {v6}, Ljava/io/StringWriter;-><init>()V

    .line 74
    .local v6, "writer":Ljava/io/StringWriter;
    const-string v7, "UTF-8"

    invoke-static {v4, v6, v7}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 75
    invoke-virtual {v6}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v5

    .line 77
    .local v5, "sizesJSONString":Ljava/lang/String;
    new-instance v3, Lcom/google/gson/Gson;

    invoke-direct {v3}, Lcom/google/gson/Gson;-><init>()V

    .line 78
    .local v3, "gson":Lcom/google/gson/Gson;
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 79
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->serializeNulls()Lcom/google/gson/GsonBuilder;

    move-result-object v7

    const/4 v8, 0x0

    new-array v8, v8, [I

    invoke-virtual {v7, v8}, Lcom/google/gson/GsonBuilder;->excludeFieldsWithModifiers([I)Lcom/google/gson/GsonBuilder;

    .line 80
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v3

    .line 81
    const-class v7, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    instance-of v8, v3, Lcom/google/gson/Gson;

    if-nez v8, :cond_0

    invoke-virtual {v3, v5, v7}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v7

    .end local v3    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v7, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    iput-object v7, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 87
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v2    # "fileName":Ljava/lang/String;
    .end local v4    # "ip":Ljava/io/InputStream;
    .end local v5    # "sizesJSONString":Ljava/lang/String;
    .end local v6    # "writer":Ljava/io/StringWriter;
    :goto_1
    return-void

    .line 81
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "fileName":Ljava/lang/String;
    .restart local v3    # "gson":Lcom/google/gson/Gson;
    .restart local v4    # "ip":Ljava/io/InputStream;
    .restart local v5    # "sizesJSONString":Ljava/lang/String;
    .restart local v6    # "writer":Ljava/io/StringWriter;
    :cond_0
    check-cast v3, Lcom/google/gson/Gson;

    .end local v3    # "gson":Lcom/google/gson/Gson;
    invoke-static {v3, v5, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    goto :goto_0

    .line 83
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v2    # "fileName":Ljava/lang/String;
    .end local v4    # "ip":Ljava/io/InputStream;
    .end local v5    # "sizesJSONString":Ljava/lang/String;
    .end local v6    # "writer":Ljava/io/StringWriter;
    :catch_0
    move-exception v1

    .line 85
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method public loadBrandsOfCategory(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 12
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 34
    if-nez p1, :cond_0

    .line 64
    :goto_0
    return-void

    .line 38
    :cond_0
    :try_start_0
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "listing_meta/"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v9

    const-string v10, " "

    const-string v11, "_"

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".json"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 39
    .local v3, "fileName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v8

    invoke-virtual {v8, v3}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v5

    .line 40
    .local v5, "ip":Ljava/io/InputStream;
    new-instance v7, Ljava/io/StringWriter;

    invoke-direct {v7}, Ljava/io/StringWriter;-><init>()V

    .line 41
    .local v7, "writer":Ljava/io/StringWriter;
    const-string v8, "UTF-8"

    invoke-static {v5, v7, v8}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 42
    invoke-virtual {v7}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v6

    .line 44
    .local v6, "sizesJSONString":Ljava/lang/String;
    new-instance v4, Lcom/google/gson/Gson;

    invoke-direct {v4}, Lcom/google/gson/Gson;-><init>()V

    .line 45
    .local v4, "gson":Lcom/google/gson/Gson;
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 46
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->serializeNulls()Lcom/google/gson/GsonBuilder;

    move-result-object v8

    const/4 v9, 0x0

    new-array v9, v9, [I

    invoke-virtual {v8, v9}, Lcom/google/gson/GsonBuilder;->excludeFieldsWithModifiers([I)Lcom/google/gson/GsonBuilder;

    .line 47
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v4

    .line 48
    const-class v9, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    instance-of v8, v4, Lcom/google/gson/Gson;

    if-nez v8, :cond_1

    invoke-virtual {v4, v6, v9}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    :goto_1
    check-cast v8, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    iput-object v8, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->brands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    .line 52
    const-string v3, "listing_meta/Other.json"

    .line 53
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v8

    invoke-virtual {v8, v3}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v5

    .line 54
    new-instance v7, Ljava/io/StringWriter;

    .end local v7    # "writer":Ljava/io/StringWriter;
    invoke-direct {v7}, Ljava/io/StringWriter;-><init>()V

    .line 55
    .restart local v7    # "writer":Ljava/io/StringWriter;
    const-string v8, "UTF-8"

    invoke-static {v5, v7, v8}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 56
    invoke-virtual {v7}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v6

    .line 58
    const-class v8, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    instance-of v9, v4, Lcom/google/gson/Gson;

    if-nez v9, :cond_2

    invoke-virtual {v4, v6, v8}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    .end local v4    # "gson":Lcom/google/gson/Gson;
    :goto_2
    check-cast v8, Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;

    iput-object v8, p0, Lcom/poshmark/utils/meta_data/BrandsMetaData;->allBrands:Lcom/poshmark/utils/meta_data/BrandsMetaData$Brands;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 60
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "fileName":Ljava/lang/String;
    .end local v5    # "ip":Ljava/io/InputStream;
    .end local v6    # "sizesJSONString":Ljava/lang/String;
    .end local v7    # "writer":Ljava/io/StringWriter;
    :catch_0
    move-exception v2

    .line 62
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 48
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v3    # "fileName":Ljava/lang/String;
    .restart local v4    # "gson":Lcom/google/gson/Gson;
    .restart local v5    # "ip":Ljava/io/InputStream;
    .restart local v6    # "sizesJSONString":Ljava/lang/String;
    .restart local v7    # "writer":Ljava/io/StringWriter;
    :cond_1
    :try_start_1
    move-object v0, v4

    check-cast v0, Lcom/google/gson/Gson;

    move-object v8, v0

    invoke-static {v8, v6, v9}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    goto :goto_1

    .line 58
    :cond_2
    check-cast v4, Lcom/google/gson/Gson;

    .end local v4    # "gson":Lcom/google/gson/Gson;
    invoke-static {v4, v6, v8}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v8

    goto :goto_2
.end method
