.class Lcom/amazon/device/ads/AAXParameter$ParameterData;
.super Ljava/lang/Object;
.source "AAXParameter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AAXParameter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ParameterData"
.end annotation


# instance fields
.field private adRequest:Lcom/amazon/device/ads/AdRequest;

.field private advancedOptions:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private loiSlot:Lcom/amazon/device/ads/AdRequest$LOISlot;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->advancedOptions:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->adRequest:Lcom/amazon/device/ads/AdRequest;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest$LOISlot;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->loiSlot:Lcom/amazon/device/ads/AdRequest$LOISlot;

    return-object v0
.end method


# virtual methods
.method setAdRequest(Lcom/amazon/device/ads/AdRequest;)Lcom/amazon/device/ads/AAXParameter$ParameterData;
    .locals 0
    .param p1, "adRequest"    # Lcom/amazon/device/ads/AdRequest;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->adRequest:Lcom/amazon/device/ads/AdRequest;

    .line 99
    return-object p0
.end method

.method setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AAXParameter$ParameterData;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/device/ads/AAXParameter$ParameterData;"
        }
    .end annotation

    .prologue
    .line 103
    .local p1, "advancedOptions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->advancedOptions:Ljava/util/Map;

    .line 104
    return-object p0
.end method

.method setLOISlot(Lcom/amazon/device/ads/AdRequest$LOISlot;)Lcom/amazon/device/ads/AAXParameter$ParameterData;
    .locals 0
    .param p1, "loiSlot"    # Lcom/amazon/device/ads/AdRequest$LOISlot;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/device/ads/AAXParameter$ParameterData;->loiSlot:Lcom/amazon/device/ads/AdRequest$LOISlot;

    .line 109
    return-object p0
.end method
