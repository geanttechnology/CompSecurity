.class public Lcom/poshmark/utils/meta_data/SizesMetaData;
.super Ljava/lang/Object;
.source "SizesMetaData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;
    }
.end annotation


# instance fields
.field sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/SizesMetaData;->sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    .line 25
    invoke-direct {p0}, Lcom/poshmark/utils/meta_data/SizesMetaData;->loadSizesData()V

    .line 26
    return-void
.end method

.method private loadSizesData()V
    .locals 8

    .prologue
    .line 31
    :try_start_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v6

    const-string v7, "listing_meta/sizes.json"

    invoke-virtual {v6, v7}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v3

    .line 32
    .local v3, "ip":Ljava/io/InputStream;
    new-instance v5, Ljava/io/StringWriter;

    invoke-direct {v5}, Ljava/io/StringWriter;-><init>()V

    .line 33
    .local v5, "writer":Ljava/io/StringWriter;
    const-string v6, "UTF-8"

    invoke-static {v3, v5, v6}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 34
    invoke-virtual {v5}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v4

    .line 36
    .local v4, "sizesJSONString":Ljava/lang/String;
    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    .line 37
    .local v2, "gson":Lcom/google/gson/Gson;
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 38
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->serializeNulls()Lcom/google/gson/GsonBuilder;

    move-result-object v6

    const/4 v7, 0x0

    new-array v7, v7, [I

    invoke-virtual {v6, v7}, Lcom/google/gson/GsonBuilder;->excludeFieldsWithModifiers([I)Lcom/google/gson/GsonBuilder;

    .line 39
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 40
    const-class v6, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    instance-of v7, v2, Lcom/google/gson/Gson;

    if-nez v7, :cond_0

    invoke-virtual {v2, v4, v6}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    .end local v2    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v6, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    iput-object v6, p0, Lcom/poshmark/utils/meta_data/SizesMetaData;->sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    .line 45
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "ip":Ljava/io/InputStream;
    .end local v4    # "sizesJSONString":Ljava/lang/String;
    .end local v5    # "writer":Ljava/io/StringWriter;
    :goto_1
    return-void

    .line 40
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "ip":Ljava/io/InputStream;
    .restart local v4    # "sizesJSONString":Ljava/lang/String;
    .restart local v5    # "writer":Ljava/io/StringWriter;
    :cond_0
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v4, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    goto :goto_0

    .line 41
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "ip":Ljava/io/InputStream;
    .end local v4    # "sizesJSONString":Ljava/lang/String;
    .end local v5    # "writer":Ljava/io/StringWriter;
    :catch_0
    move-exception v1

    .line 43
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method


# virtual methods
.method public getSizeListForCategory(Lcom/poshmark/data_model/models/MetaItem;)Ljava/util/List;
    .locals 2
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/SizesMetaData;->sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSizeListForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;
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
    .line 67
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/SizesMetaData;->sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSizeMetaItem(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 5
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 48
    iget-object v3, p0, Lcom/poshmark/utils/meta_data/SizesMetaData;->sizes:Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/meta_data/SizesMetaData$Sizes;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 50
    .local v2, "sizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v2, :cond_1

    .line 51
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 52
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 53
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 54
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 59
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
