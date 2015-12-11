.class Lcom/amazon/device/ads/AAXParameter$SlotParameter;
.super Lcom/amazon/device/ads/AAXParameter$StringParameter;
.source "AAXParameter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AAXParameter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "SlotParameter"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 493
    const-string/jumbo v0, "slot"

    const-string/jumbo v1, "debug.slot"

    invoke-direct {p0, v0, v1}, Lcom/amazon/device/ads/AAXParameter$StringParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 494
    return-void
.end method


# virtual methods
.method protected bridge synthetic getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 489
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AAXParameter$SlotParameter;->getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDerivedValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/String;
    .locals 1
    .param p1, "parameterData"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 499
    # getter for: Lcom/amazon/device/ads/AAXParameter$ParameterData;->adRequest:Lcom/amazon/device/ads/AdRequest;
    invoke-static {p1}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->access$200(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRequest;->getOrientation()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
