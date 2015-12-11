.class public Lcom/comcast/cim/microdata/model/MicrodataContext;
.super Ljava/lang/Object;
.source "MicrodataContext.java"


# instance fields
.field private final baseUrl:Ljava/lang/String;

.field private final hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

.field private final itemMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation
.end field

.field private final modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;Ljava/util/Map;)V
    .locals 0
    .param p1, "hypermediaClient"    # Lcom/comcast/cim/microdata/client/HypermediaClient;
    .param p2, "baseUrl"    # Ljava/lang/String;
    .param p3, "modelFactory"    # Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/microdata/client/HypermediaClient;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p4, "itemMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    .line 16
    iput-object p2, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->baseUrl:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    .line 18
    iput-object p4, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->itemMap:Ljava/util/Map;

    .line 19
    return-void
.end method


# virtual methods
.method public getBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getHypermediaClient()Lcom/comcast/cim/microdata/client/HypermediaClient;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    return-object v0
.end method

.method public getItemMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->itemMap:Ljava/util/Map;

    return-object v0
.end method

.method public getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataContext;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    return-object v0
.end method
