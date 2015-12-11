.class final enum Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
.super Ljava/lang/Enum;
.source "DeviceInfoLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "MasField"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum BuildFingerprint:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum BuildProduct:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum Carrier:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum DeviceDensityClassification:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum DeviceDescriptorId:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum DeviceInfo:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum DeviceScrenLayout:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum DeviceType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum Manufacturer:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum Model:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum OsVersion:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum PhoneType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum Ref:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum SearchContext:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum Serial:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field public static final enum SimOperator:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

.field private static final names:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 14

    .prologue
    const/4 v13, 0x4

    const/4 v12, 0x3

    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 419
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "Carrier"

    const-string/jumbo v7, "carrier"

    invoke-direct {v5, v6, v9, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Carrier:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 420
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "Manufacturer"

    const-string/jumbo v7, "manufacturer"

    invoke-direct {v5, v6, v10, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Manufacturer:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 421
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "Model"

    const-string/jumbo v7, "model"

    invoke-direct {v5, v6, v11, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Model:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 422
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "DeviceType"

    const-string/jumbo v7, "deviceType"

    invoke-direct {v5, v6, v12, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 423
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "DeviceDescriptorId"

    const-string/jumbo v7, "deviceDescriptorId"

    invoke-direct {v5, v6, v13, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceDescriptorId:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 424
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "OsVersion"

    const/4 v7, 0x5

    const-string/jumbo v8, "osVersion"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->OsVersion:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 425
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "Ref"

    const/4 v7, 0x6

    const-string/jumbo v8, "ref"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Ref:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 426
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "DeviceDensityClassification"

    const/4 v7, 0x7

    const-string/jumbo v8, "deviceDensityClassification"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceDensityClassification:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 427
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "DeviceScrenLayout"

    const/16 v7, 0x8

    const-string/jumbo v8, "deviceScreenLayout"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceScrenLayout:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 428
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "Serial"

    const/16 v7, 0x9

    const-string/jumbo v8, "serial"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Serial:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 429
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "BuildProduct"

    const/16 v7, 0xa

    const-string/jumbo v8, "build_product"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->BuildProduct:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 430
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "BuildFingerprint"

    const/16 v7, 0xb

    const-string/jumbo v8, "build_fingerprint"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->BuildFingerprint:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 431
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "SimOperator"

    const/16 v7, 0xc

    const-string/jumbo v8, "simOperator"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SimOperator:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 432
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "PhoneType"

    const/16 v7, 0xd

    const-string/jumbo v8, "phoneType"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->PhoneType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 433
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "SearchContext"

    const/16 v7, 0xe

    const-string/jumbo v8, "searchContext"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SearchContext:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 434
    new-instance v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    const-string/jumbo v6, "DeviceInfo"

    const/16 v7, 0xf

    const-string/jumbo v8, "deviceInfo"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceInfo:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 417
    const/16 v5, 0x10

    new-array v5, v5, [Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Carrier:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v6, v5, v9

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Manufacturer:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v6, v5, v10

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Model:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v6, v5, v11

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v6, v5, v12

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceDescriptorId:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v6, v5, v13

    const/4 v6, 0x5

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->OsVersion:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/4 v6, 0x6

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Ref:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/4 v6, 0x7

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceDensityClassification:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0x8

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceScrenLayout:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0x9

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->Serial:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xa

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->BuildProduct:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xb

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->BuildFingerprint:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xc

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SimOperator:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xd

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->PhoneType:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xe

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SearchContext:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    const/16 v6, 0xf

    sget-object v7, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceInfo:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    aput-object v7, v5, v6

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->$VALUES:[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    .line 441
    new-instance v4, Ljava/util/HashMap;

    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->values()[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    move-result-object v5

    array-length v5, v5

    invoke-direct {v4, v5}, Ljava/util/HashMap;-><init>(I)V

    .line 443
    .local v4, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;>;"
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->values()[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 445
    .local v1, "field":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 443
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 448
    .end local v1    # "field":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    :cond_0
    invoke-static {v4}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v5

    sput-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->names:Ljava/util/Map;

    .line 449
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 452
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 453
    iput-object p3, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->name:Ljava/lang/String;

    .line 454
    return-void
.end method

.method public static find(Ljava/lang/String;)Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 463
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->names:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 417
    const-class v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    .locals 1

    .prologue
    .line 417
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->$VALUES:[Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 458
    iget-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->name:Ljava/lang/String;

    return-object v0
.end method
