.class public Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.source "SearchServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
        ">;"
    }
.end annotation


# static fields
.field private static PARSER_CLASS:Ljava/lang/String;

.field private static volatile defaultParser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;


# instance fields
.field private dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

.field private final parser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

.field private final request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    invoke-virtual {v1}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".jackson.SearchParser"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->PARSER_CLASS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Lcom/amazon/searchapp/retailsearch/client/SearchListener;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;)V
    .locals 6
    .param p1, "searchClient"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p2, "request"    # Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .param p4, "parser"    # Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    .prologue
    .line 53
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 54
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 55
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    .line 56
    return-void
.end method

.method private addDeviceInformation(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 168
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getDeviceInformation()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v0

    .line 170
    .local v0, "info":Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    if-nez v0, :cond_1

    .line 232
    :cond_0
    :goto_0
    return-void

    .line 174
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getCarrier()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 175
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->CARRIER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getCarrier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 178
    :cond_2
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getManufacturer()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 179
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MANUFACTURER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getManufacturer()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 182
    :cond_3
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getModel()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 183
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MODEL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getModel()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 186
    :cond_4
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 187
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 190
    :cond_5
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDescriptorId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 191
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DESCRIPTOR_ID:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDescriptorId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 195
    :cond_6
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getOsVersion()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 196
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->OS_VERSION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getOsVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 199
    :cond_7
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getRef()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_8

    .line 200
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->REF:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getRef()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 203
    :cond_8
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDensityClassification()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 204
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DENSITY_CLASSIFICATION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDensityClassification()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 208
    :cond_9
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceScreenLayout()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_a

    .line 209
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_SCREEN_LAYOUT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceScreenLayout()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 213
    :cond_a
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSerial()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_b

    .line 214
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SERIAL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSerial()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 217
    :cond_b
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildProduct()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_c

    .line 218
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_PRODUCT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildProduct()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 221
    :cond_c
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildFingerprint()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_d

    .line 222
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_FINGERPRINT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildFingerprint()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 225
    :cond_d
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSimOperator()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_e

    .line 226
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SIM_OPERATOR:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSimOperator()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 229
    :cond_e
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getPhoneType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 230
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->PHONE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getPhoneType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method private addRefTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 94
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getRefTag()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 100
    .end local p1    # "path":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 98
    .restart local p1    # "path":Ljava/lang/String;
    :cond_0
    if-eqz p1, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 99
    .local v0, "sb":Ljava/lang/StringBuilder;
    :goto_1
    const-string/jumbo v1, "ref"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getRefTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 98
    .end local v0    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_1
.end method

.method private declared-synchronized getDefaultParser()Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;
    .locals 1

    .prologue
    .line 258
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    if-nez v0, :cond_0

    .line 259
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->PARSER_CLASS:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/util/ClassUtil;->createInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    .line 262
    :cond_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->defaultParser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 258
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private getParser()Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->parser:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->getDefaultParser()Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 108
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    if-eqz v2, :cond_0

    .line 109
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getQuery()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 112
    :cond_0
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getDataSet()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 113
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->DATA_SET:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getDataSet()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 116
    :cond_1
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getAlias()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 117
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ALIAS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getAlias()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 120
    :cond_2
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getMerchant()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 121
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MERCHANT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getMerchant()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 124
    :cond_3
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getKeywords()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 125
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 128
    :cond_4
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getSort()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 129
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SORT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getSort()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 132
    :cond_5
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getRefinements()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 133
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->REFINEMENT_HISTORY:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getRefinements()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 136
    :cond_6
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getPage()I

    move-result v2

    if-eqz v2, :cond_7

    .line 137
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->PAGE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getPage()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 140
    :cond_7
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getPageSize()I

    move-result v2

    if-ltz v2, :cond_8

    .line 141
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MAX_RESULTS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getPageSize()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 144
    :cond_8
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getImageResolution()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_9

    .line 145
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_RESOLUTION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getImageResolution()Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 148
    :cond_9
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getImageCrop()Z

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_a

    .line 149
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_CROP:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getImageCrop()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 152
    :cond_a
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getSearchMethod()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_b

    .line 153
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SEARCH_METHOD:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getSearchMethod()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 156
    :cond_b
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getParameters()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 157
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getParameters()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 158
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 162
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_c
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->addDeviceInformation(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 164
    invoke-super {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 165
    return-void
.end method

.method protected buildPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getPath()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-direct {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->addRefTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->getDefaultPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected buildServiceCall()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getDataUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 72
    :try_start_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->request:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest;->getDataUrl()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->dataUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    :cond_0
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildServiceCall()V

    .line 79
    return-void

    .line 73
    :catch_0
    move-exception v0

    .line 74
    .local v0, "e":Ljava/net/URISyntaxException;
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected getListener()Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .locals 1

    .prologue
    .line 63
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    return-object v0
.end method

.method protected bridge synthetic getListener()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;
    .locals 1

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    move-result-object v0

    return-object v0
.end method

.method protected readResponse(ILjava/lang/String;Ljava/io/InputStream;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 2
    .param p1, "statusCode"    # I
    .param p2, "statusLine"    # Ljava/lang/String;
    .param p3, "content"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 240
    if-eqz p3, :cond_0

    .line 241
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->getParser()Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->getListener()Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    move-result-object v1

    invoke-interface {v0, p3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;->parse(Ljava/io/InputStream;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-result-object v0

    .line 244
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic readResponse(ILjava/lang/String;Ljava/io/InputStream;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 20
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;->readResponse(ILjava/lang/String;Ljava/io/InputStream;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-result-object v0

    return-object v0
.end method
