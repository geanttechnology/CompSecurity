.class Lcom/amazon/device/ads/AAXParameter$TestParameter;
.super Lcom/amazon/device/ads/AAXParameter$BooleanParameter;
.source "AAXParameter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AAXParameter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "TestParameter"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 386
    const-string/jumbo v0, "isTest"

    const-string/jumbo v1, "debug.test"

    invoke-direct {p0, v0, v1}, Lcom/amazon/device/ads/AAXParameter$BooleanParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 387
    return-void
.end method


# virtual methods
.method protected getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Boolean;
    .locals 3
    .param p1, "parameterData"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 392
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "testingEnabled"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 382
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AAXParameter$TestParameter;->getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
