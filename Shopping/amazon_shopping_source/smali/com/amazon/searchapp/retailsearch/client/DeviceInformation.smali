.class public Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
.super Ljava/lang/Object;
.source "DeviceInformation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    }
.end annotation


# instance fields
.field private final buildFingerprint:Ljava/lang/String;

.field private final buildProduct:Ljava/lang/String;

.field private final carrier:Ljava/lang/String;

.field private final deviceDensityClassification:Ljava/lang/String;

.field private final deviceDescriptorId:Ljava/lang/String;

.field private final deviceScreenLayout:Ljava/lang/String;

.field private final deviceType:Ljava/lang/String;

.field private final manufacturer:Ljava/lang/String;

.field private final model:Ljava/lang/String;

.field private final osVersion:Ljava/lang/String;

.field private final phoneType:Ljava/lang/String;

.field private final ref:Ljava/lang/String;

.field private final serial:Ljava/lang/String;

.field private final simOperator:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "carrier"    # Ljava/lang/String;
    .param p2, "manufacturer"    # Ljava/lang/String;
    .param p3, "model"    # Ljava/lang/String;
    .param p4, "deviceType"    # Ljava/lang/String;
    .param p5, "deviceDescriptorId"    # Ljava/lang/String;
    .param p6, "osVersion"    # Ljava/lang/String;
    .param p7, "ref"    # Ljava/lang/String;
    .param p8, "deviceDensityClassification"    # Ljava/lang/String;
    .param p9, "deviceScreenLayout"    # Ljava/lang/String;
    .param p10, "serial"    # Ljava/lang/String;
    .param p11, "buildProduct"    # Ljava/lang/String;
    .param p12, "buildFingerprint"    # Ljava/lang/String;
    .param p13, "simOperator"    # Ljava/lang/String;
    .param p14, "phoneType"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->carrier:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->manufacturer:Ljava/lang/String;

    .line 39
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->model:Ljava/lang/String;

    .line 40
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceType:Ljava/lang/String;

    .line 41
    iput-object p5, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceDescriptorId:Ljava/lang/String;

    .line 42
    iput-object p6, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->osVersion:Ljava/lang/String;

    .line 43
    iput-object p7, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->ref:Ljava/lang/String;

    .line 44
    iput-object p8, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceDensityClassification:Ljava/lang/String;

    .line 45
    iput-object p9, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceScreenLayout:Ljava/lang/String;

    .line 46
    iput-object p10, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->serial:Ljava/lang/String;

    .line 47
    iput-object p11, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->buildProduct:Ljava/lang/String;

    .line 48
    iput-object p12, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->buildFingerprint:Ljava/lang/String;

    .line 49
    iput-object p13, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->simOperator:Ljava/lang/String;

    .line 50
    iput-object p14, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->phoneType:Ljava/lang/String;

    .line 51
    return-void
.end method


# virtual methods
.method public getBuildFingerprint()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->buildFingerprint:Ljava/lang/String;

    return-object v0
.end method

.method public getBuildProduct()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->buildProduct:Ljava/lang/String;

    return-object v0
.end method

.method public getCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->carrier:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceDensityClassification()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceDensityClassification:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceDescriptorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceDescriptorId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceScreenLayout()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceScreenLayout:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->deviceType:Ljava/lang/String;

    return-object v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->manufacturer:Ljava/lang/String;

    return-object v0
.end method

.method public getModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->model:Ljava/lang/String;

    return-object v0
.end method

.method public getOsVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->osVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->phoneType:Ljava/lang/String;

    return-object v0
.end method

.method public getRef()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->ref:Ljava/lang/String;

    return-object v0
.end method

.method public getSerial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->serial:Ljava/lang/String;

    return-object v0
.end method

.method public getSimOperator()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->simOperator:Ljava/lang/String;

    return-object v0
.end method
