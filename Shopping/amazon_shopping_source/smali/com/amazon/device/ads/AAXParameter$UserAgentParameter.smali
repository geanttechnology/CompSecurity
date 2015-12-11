.class Lcom/amazon/device/ads/AAXParameter$UserAgentParameter;
.super Lcom/amazon/device/ads/AAXParameter$StringParameter;
.source "AAXParameter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AAXParameter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "UserAgentParameter"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 294
    const-string/jumbo v0, "ua"

    const-string/jumbo v1, "debug.ua"

    invoke-direct {p0, v0, v1}, Lcom/amazon/device/ads/AAXParameter$StringParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 295
    return-void
.end method


# virtual methods
.method protected bridge synthetic getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 290
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AAXParameter$UserAgentParameter;->getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/String;
    .locals 1
    .param p1, "parameterData"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 300
    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
