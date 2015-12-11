.class public final enum Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;
.super Ljava/lang/Enum;
.source "DeviceInfoParameter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum BUILD_FINGERPRINT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum BUILD_PRODUCT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum CARRIER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum DEVICE_DENSITY_CLASSIFICATION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum DEVICE_DESCRIPTOR_ID:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum DEVICE_SCREEN_LAYOUT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum DEVICE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum MANUFACTURER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum MODEL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum OS_VERSION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum PHONE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum REF:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum SERIAL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

.field public static final enum SIM_OPERATOR:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 4
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "CARRIER"

    const-string/jumbo v2, "carrier"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->CARRIER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 5
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "MANUFACTURER"

    const-string/jumbo v2, "manufacturer"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MANUFACTURER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 6
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "MODEL"

    const-string/jumbo v2, "model"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MODEL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 7
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "DEVICE_TYPE"

    const-string/jumbo v2, "deviceType"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 8
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "DEVICE_DESCRIPTOR_ID"

    const-string/jumbo v2, "deviceDescriptorId"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DESCRIPTOR_ID:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 9
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "OS_VERSION"

    const/4 v2, 0x5

    const-string/jumbo v3, "osVersion"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->OS_VERSION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 10
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "REF"

    const/4 v2, 0x6

    const-string/jumbo v3, "deviceRef"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->REF:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "DEVICE_DENSITY_CLASSIFICATION"

    const/4 v2, 0x7

    const-string/jumbo v3, "deviceDensityClassification"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DENSITY_CLASSIFICATION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 12
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "DEVICE_SCREEN_LAYOUT"

    const/16 v2, 0x8

    const-string/jumbo v3, "deviceScreenLayout"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_SCREEN_LAYOUT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 13
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "SERIAL"

    const/16 v2, 0x9

    const-string/jumbo v3, "serial"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SERIAL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 14
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "BUILD_PRODUCT"

    const/16 v2, 0xa

    const-string/jumbo v3, "buildProduct"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_PRODUCT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 15
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "BUILD_FINGERPRINT"

    const/16 v2, 0xb

    const-string/jumbo v3, "buildFingerprint"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_FINGERPRINT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 16
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "SIM_OPERATOR"

    const/16 v2, 0xc

    const-string/jumbo v3, "simOperator"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SIM_OPERATOR:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 17
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    const-string/jumbo v1, "PHONE_TYPE"

    const/16 v2, 0xd

    const-string/jumbo v3, "phoneType"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->PHONE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    .line 3
    const/16 v0, 0xe

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->CARRIER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MANUFACTURER:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->MODEL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DESCRIPTOR_ID:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->OS_VERSION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->REF:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_DENSITY_CLASSIFICATION:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->DEVICE_SCREEN_LAYOUT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SERIAL:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_PRODUCT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->BUILD_FINGERPRINT:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->SIM_OPERATOR:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->PHONE_TYPE:Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 26
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->name:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInfoParameter;->name:Ljava/lang/String;

    return-object v0
.end method
