.class Lcom/amazon/device/ads/AdRequest$LOISlot;
.super Ljava/lang/Object;
.source "AdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LOISlot"
.end annotation


# static fields
.field static final PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Lcom/amazon/device/ads/AAXParameter",
            "<*>;"
        }
    .end annotation
.end field


# instance fields
.field private final adData:Lcom/amazon/device/ads/AdData;

.field private final jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

.field private final opt:Lcom/amazon/device/ads/AdTargetingOptions;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 193
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/device/ads/AAXParameter;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SIZE:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->PAGE_TYPE:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SLOT:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SLOT_POSITION:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->MAX_SIZE:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SLOT_ID:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->FLOOR_PRICE:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/device/ads/AdRequest$LOISlot;->PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;

    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdTargetingOptions;Lcom/amazon/device/ads/AdRequest;)V
    .locals 4
    .param p1, "adData"    # Lcom/amazon/device/ads/AdData;
    .param p2, "opt"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p3, "adRequest"    # Lcom/amazon/device/ads/AdRequest;

    .prologue
    .line 214
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 215
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->adData:Lcom/amazon/device/ads/AdData;

    .line 216
    iput-object p2, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    .line 217
    iget-object v2, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdTargetingOptions;->getCopyOfAdvancedOptions()Ljava/util/HashMap;

    move-result-object v0

    .line 218
    .local v0, "advancedOptions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Lcom/amazon/device/ads/AAXParameter$ParameterData;

    invoke-direct {v2}, Lcom/amazon/device/ads/AAXParameter$ParameterData;-><init>()V

    invoke-virtual {v2, v0}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->setLOISlot(Lcom/amazon/device/ads/AdRequest$LOISlot;)Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v2

    invoke-virtual {v2, p3}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->setAdRequest(Lcom/amazon/device/ads/AdRequest;)Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v1

    .line 222
    .local v1, "parameterData":Lcom/amazon/device/ads/AAXParameter$ParameterData;
    new-instance v2, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-direct {v2}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;-><init>()V

    sget-object v3, Lcom/amazon/device/ads/AdRequest$LOISlot;->PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setAAXParameters([Lcom/amazon/device/ads/AAXParameter;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setParameterData(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    .line 226
    return-void
.end method


# virtual methods
.method getAdData()Lcom/amazon/device/ads/AdData;
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->adData:Lcom/amazon/device/ads/AdData;

    return-object v0
.end method

.method getAdTargetingOptions()Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    return-object v0
.end method

.method getJSON()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->build()V

    .line 240
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$LOISlot;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->getJSON()Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method
