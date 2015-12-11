.class public Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
.super Ljava/lang/Object;
.source "SearchRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private alias:Ljava/lang/String;

.field private dataSet:Ljava/lang/String;

.field private dataUrl:Ljava/lang/String;

.field private deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

.field private imageCrop:Z

.field private imageResolution:Ljava/lang/Integer;

.field private keywords:Ljava/lang/String;

.field private merchant:Ljava/lang/String;

.field private page:I

.field private pageSize:I

.field private parameters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private refTag:Ljava/lang/String;

.field private refinements:Ljava/lang/String;

.field private searchMethod:Ljava/lang/String;

.field private sort:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 262
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 233
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->pageSize:I

    .line 245
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->imageResolution:Ljava/lang/Integer;

    .line 263
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    .locals 18

    .prologue
    .line 533
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->dataSet:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->alias:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->keywords:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->refinements:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->merchant:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->sort:Ljava/lang/String;

    move-object/from16 v0, p0

    iget v8, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->page:I

    move-object/from16 v0, p0

    iget v9, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->pageSize:I

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->parameters:Ljava/util/Map;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->refTag:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->dataUrl:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->imageResolution:Ljava/lang/Integer;

    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->imageCrop:Z

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->searchMethod:Ljava/lang/String;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-direct/range {v1 .. v17}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/amazon/searchapp/retailsearch/client/DeviceInformation;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRequest$1;)V

    return-object v1
.end method

.method public setAlias(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 314
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->alias:Ljava/lang/String;

    .line 315
    return-object p0
.end method

.method public setDataUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "dataUrl"    # Ljava/lang/String;

    .prologue
    .line 459
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->dataUrl:Ljava/lang/String;

    .line 460
    return-object p0
.end method

.method public setDeviceInformation(Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "deviceInformation"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .prologue
    .line 507
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 508
    return-object p0
.end method

.method public setImageCrop(Z)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "imageCrop"    # Z

    .prologue
    .line 491
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->imageCrop:Z

    .line 492
    return-object p0
.end method

.method public setImageResolution(Ljava/lang/Integer;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "imageResolution"    # Ljava/lang/Integer;

    .prologue
    .line 475
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->imageResolution:Ljava/lang/Integer;

    .line 476
    return-object p0
.end method

.method public setKeywords(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 330
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->keywords:Ljava/lang/String;

    .line 331
    return-object p0
.end method

.method public setParameters(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;"
        }
    .end annotation

    .prologue
    .line 426
    .local p1, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->parameters:Ljava/util/Map;

    .line 428
    return-object p0

    .line 426
    :cond_0
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    goto :goto_0
.end method

.method public setRefinements(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "refinements"    # Ljava/lang/String;

    .prologue
    .line 346
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->refinements:Ljava/lang/String;

    .line 347
    return-object p0
.end method

.method public setSearchMethod(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    .locals 0
    .param p1, "searchMethod"    # Ljava/lang/String;

    .prologue
    .line 523
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->searchMethod:Ljava/lang/String;

    .line 524
    return-object p0
.end method
