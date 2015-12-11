.class public Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
.super Ljava/lang/Object;
.source "DeviceInformation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private buildFingerprint:Ljava/lang/String;

.field private buildProduct:Ljava/lang/String;

.field private carrier:Ljava/lang/String;

.field private deviceDensityClassification:Ljava/lang/String;

.field private deviceDescriptorId:Ljava/lang/String;

.field private deviceScreenLayout:Ljava/lang/String;

.field private deviceType:Ljava/lang/String;

.field private manufacturer:Ljava/lang/String;

.field private model:Ljava/lang/String;

.field private osVersion:Ljava/lang/String;

.field private phoneType:Ljava/lang/String;

.field private ref:Ljava/lang/String;

.field private serial:Ljava/lang/String;

.field private simOperator:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    return-void
.end method

.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)V
    .locals 1
    .param p1, "info"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .prologue
    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 130
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getCarrier()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->carrier:Ljava/lang/String;

    .line 131
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getManufacturer()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->manufacturer:Ljava/lang/String;

    .line 132
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getModel()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->model:Ljava/lang/String;

    .line 133
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceType()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceType:Ljava/lang/String;

    .line 134
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDescriptorId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDescriptorId:Ljava/lang/String;

    .line 135
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getOsVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->osVersion:Ljava/lang/String;

    .line 136
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getRef()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->ref:Ljava/lang/String;

    .line 137
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceDensityClassification()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDensityClassification:Ljava/lang/String;

    .line 138
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getDeviceScreenLayout()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceScreenLayout:Ljava/lang/String;

    .line 139
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSerial()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->serial:Ljava/lang/String;

    .line 140
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildProduct()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildProduct:Ljava/lang/String;

    .line 141
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getBuildFingerprint()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildFingerprint:Ljava/lang/String;

    .line 142
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getSimOperator()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->simOperator:Ljava/lang/String;

    .line 143
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;->getPhoneType()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->phoneType:Ljava/lang/String;

    .line 144
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 15

    .prologue
    .line 273
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->carrier:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->manufacturer:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->model:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceType:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDescriptorId:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->osVersion:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->ref:Ljava/lang/String;

    iget-object v8, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDensityClassification:Ljava/lang/String;

    iget-object v9, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceScreenLayout:Ljava/lang/String;

    iget-object v10, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->serial:Ljava/lang/String;

    iget-object v11, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildProduct:Ljava/lang/String;

    iget-object v12, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildFingerprint:Ljava/lang/String;

    iget-object v13, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->simOperator:Ljava/lang/String;

    iget-object v14, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->phoneType:Ljava/lang/String;

    invoke-direct/range {v0 .. v14}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public setBuildFingerprint(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "buildFingerprint"    # Ljava/lang/String;

    .prologue
    .line 250
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildFingerprint:Ljava/lang/String;

    .line 251
    return-object p0
.end method

.method public setBuildProduct(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "buildProduct"    # Ljava/lang/String;

    .prologue
    .line 241
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->buildProduct:Ljava/lang/String;

    .line 242
    return-object p0
.end method

.method public setCarrier(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "carrier"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->carrier:Ljava/lang/String;

    .line 152
    return-object p0
.end method

.method public setDeviceDensityClassification(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "deviceDensityClassification"    # Ljava/lang/String;

    .prologue
    .line 214
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDensityClassification:Ljava/lang/String;

    .line 215
    return-object p0
.end method

.method public setDeviceDescriptorId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "deviceDescriptorId"    # Ljava/lang/String;

    .prologue
    .line 187
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceDescriptorId:Ljava/lang/String;

    .line 188
    return-object p0
.end method

.method public setDeviceScreenLayout(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "deviceScreenLayout"    # Ljava/lang/String;

    .prologue
    .line 223
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceScreenLayout:Ljava/lang/String;

    .line 224
    return-object p0
.end method

.method public setDeviceType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->deviceType:Ljava/lang/String;

    .line 179
    return-object p0
.end method

.method public setManufacturer(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "manufacturer"    # Ljava/lang/String;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->manufacturer:Ljava/lang/String;

    .line 161
    return-object p0
.end method

.method public setModel(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "model"    # Ljava/lang/String;

    .prologue
    .line 169
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->model:Ljava/lang/String;

    .line 170
    return-object p0
.end method

.method public setOsVersion(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "osVersion"    # Ljava/lang/String;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->osVersion:Ljava/lang/String;

    .line 197
    return-object p0
.end method

.method public setPhoneType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "phoneType"    # Ljava/lang/String;

    .prologue
    .line 268
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->phoneType:Ljava/lang/String;

    .line 269
    return-object p0
.end method

.method public setRef(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "ref"    # Ljava/lang/String;

    .prologue
    .line 205
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->ref:Ljava/lang/String;

    .line 206
    return-object p0
.end method

.method public setSerial(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "serial"    # Ljava/lang/String;

    .prologue
    .line 232
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->serial:Ljava/lang/String;

    .line 233
    return-object p0
.end method

.method public setSimOperator(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    .locals 0
    .param p1, "simOperator"    # Ljava/lang/String;

    .prologue
    .line 259
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->simOperator:Ljava/lang/String;

    .line 260
    return-object p0
.end method
