.class public Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;
.super Lcom/amazon/identity/kcpsdk/common/XMLEntity;
.source "XMLDeviceTypeSoftwareVersionMap.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDeviceTypeSoftwareVersionMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p1, "versionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/common/XMLEntity;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    .line 24
    return-void
.end method


# virtual methods
.method toXML(Lorg/w3c/dom/Element;)V
    .locals 13
    .param p1, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 35
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    if-nez v4, :cond_1

    .line 60
    :cond_0
    :goto_0
    return-void

    .line 40
    :cond_1
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v4, "deviceTypeSoftwareVersionMap"

    new-array v5, v11, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    invoke-direct {v3, v4, v5}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    .line 41
    .local v3, "versionMapEle":Lcom/amazon/identity/kcpsdk/common/XMLElement;
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 43
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    .line 44
    .local v2, "keyValue":Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 47
    new-instance v5, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v6, "entry"

    const/4 v4, 0x3

    new-array v7, v4, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    new-instance v8, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    const-string/jumbo v9, "deviceType"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {v8, v9, v4}, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v7, v11

    new-instance v8, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    const-string/jumbo v9, "version"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v8, v9, v4}, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v7, v12

    const/4 v8, 0x2

    new-instance v9, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    const-string/jumbo v10, "softwareComponentId"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v9, v10, v4}, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v9, v7, v8

    invoke-direct {v5, v6, v7}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    invoke-virtual {v3, v5}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    goto :goto_1

    .line 56
    :cond_2
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Skipping version for entry %s - version not present"

    new-array v6, v12, [Ljava/lang/Object;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v6, v11

    invoke-static {v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 59
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    .end local v2    # "keyValue":Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    :cond_3
    invoke-virtual {v3, p1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->toXML(Lorg/w3c/dom/Element;)V

    goto/16 :goto_0
.end method
