.class public final Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
.super Ljava/lang/Object;
.source "SearchRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/SearchRequest$1;,
        Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    }
.end annotation


# instance fields
.field private final alias:Ljava/lang/String;

.field private final dataSet:Ljava/lang/String;

.field private final dataUrl:Ljava/lang/String;

.field private final deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

.field private final imageCrop:Z

.field private final imageResolution:Ljava/lang/Integer;

.field private final keywords:Ljava/lang/String;

.field private final merchant:Ljava/lang/String;

.field private final page:I

.field private final pageSize:I

.field private final parameters:Ljava/util/Map;
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

.field private final refTag:Ljava/lang/String;

.field private final refinements:Ljava/lang/String;

.field private final searchMethod:Ljava/lang/String;

.field private final sort:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/amazon/searchapp/retailsearch/client/DeviceInformation;Ljava/lang/String;)V
    .locals 0
    .param p1, "dataSet"    # Ljava/lang/String;
    .param p2, "alias"    # Ljava/lang/String;
    .param p3, "keywords"    # Ljava/lang/String;
    .param p4, "refinements"    # Ljava/lang/String;
    .param p5, "merchant"    # Ljava/lang/String;
    .param p6, "sort"    # Ljava/lang/String;
    .param p7, "page"    # I
    .param p8, "pageSize"    # I
    .param p10, "refTag"    # Ljava/lang/String;
    .param p11, "dataUrl"    # Ljava/lang/String;
    .param p12, "imageResolution"    # Ljava/lang/Integer;
    .param p13, "imageCrop"    # Z
    .param p14, "deviceInformation"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .param p15, "searchMethod"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "II",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Z",
            "Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 81
    .local p9, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->dataSet:Ljava/lang/String;

    .line 83
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->alias:Ljava/lang/String;

    .line 84
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->keywords:Ljava/lang/String;

    .line 85
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->refinements:Ljava/lang/String;

    .line 86
    iput-object p5, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->merchant:Ljava/lang/String;

    .line 87
    iput-object p6, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->sort:Ljava/lang/String;

    .line 88
    iput p7, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->page:I

    .line 89
    iput p8, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->pageSize:I

    .line 90
    iput-object p9, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->parameters:Ljava/util/Map;

    .line 91
    iput-object p10, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->refTag:Ljava/lang/String;

    .line 92
    iput-object p11, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->dataUrl:Ljava/lang/String;

    .line 93
    iput-object p12, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->imageResolution:Ljava/lang/Integer;

    .line 94
    iput-boolean p13, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->imageCrop:Z

    .line 95
    iput-object p14, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 96
    iput-object p15, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->searchMethod:Ljava/lang/String;

    .line 97
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/amazon/searchapp/retailsearch/client/DeviceInformation;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRequest$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Ljava/lang/String;
    .param p5, "x4"    # Ljava/lang/String;
    .param p6, "x5"    # Ljava/lang/String;
    .param p7, "x6"    # I
    .param p8, "x7"    # I
    .param p9, "x8"    # Ljava/util/Map;
    .param p10, "x9"    # Ljava/lang/String;
    .param p11, "x10"    # Ljava/lang/String;
    .param p12, "x11"    # Ljava/lang/Integer;
    .param p13, "x12"    # Z
    .param p14, "x13"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .param p15, "x14"    # Ljava/lang/String;
    .param p16, "x15"    # Lcom/amazon/searchapp/retailsearch/client/SearchRequest$1;

    .prologue
    .line 13
    invoke-direct/range {p0 .. p15}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/amazon/searchapp/retailsearch/client/DeviceInformation;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getDataSet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->dataSet:Ljava/lang/String;

    return-object v0
.end method

.method public getDataUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->dataUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceInformation()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->deviceInformation:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    return-object v0
.end method

.method public getImageCrop()Z
    .locals 1

    .prologue
    .line 187
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->imageCrop:Z

    return v0
.end method

.method public getImageResolution()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->imageResolution:Ljava/lang/Integer;

    return-object v0
.end method

.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchant()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->merchant:Ljava/lang/String;

    return-object v0
.end method

.method public getPage()I
    .locals 1

    .prologue
    .line 145
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->page:I

    return v0
.end method

.method public getPageSize()I
    .locals 1

    .prologue
    .line 152
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->pageSize:I

    return v0
.end method

.method public getParameters()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->parameters:Ljava/util/Map;

    return-object v0
.end method

.method public getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->refTag:Ljava/lang/String;

    return-object v0
.end method

.method public getRefinements()Ljava/lang/String;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->refinements:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->searchMethod:Ljava/lang/String;

    return-object v0
.end method

.method public getSort()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->sort:Ljava/lang/String;

    return-object v0
.end method
