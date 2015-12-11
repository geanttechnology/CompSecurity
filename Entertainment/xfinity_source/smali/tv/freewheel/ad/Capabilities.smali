.class public Ltv/freewheel/ad/Capabilities;
.super Ljava/lang/Object;
.source "Capabilities.java"


# static fields
.field public static final CANDIDATE_ADS_CAPABILITIES:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEFAULT_CAPABILITIES:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private capabilities:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Ltv/freewheel/ad/Capabilities;->CANDIDATE_ADS_CAPABILITIES:Ljava/util/ArrayList;

    .line 19
    sget-object v0, Ltv/freewheel/ad/Capabilities;->CANDIDATE_ADS_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "checkCompanion"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 20
    sget-object v0, Ltv/freewheel/ad/Capabilities;->CANDIDATE_ADS_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "checkTargeting"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    .line 23
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "supportsSlotTemplate"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 24
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "supportsAdUnitInMultipleSlots"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 25
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "supportsSlotCallback"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 26
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "bypassCommercialRatioRestriction"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 27
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "requiresVideoCallbackUrl"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 28
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "skipsAdSelection"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 29
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "synchronizeMultipleRequests"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 30
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "resetExclusivity"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 31
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "supportNullCreative"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 32
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "expectMultipleCreativeRenditions"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 33
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TWO_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "supportsFallbackAds"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Ltv/freewheel/ad/Capabilities;->TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    .line 36
    sget-object v0, Ltv/freewheel/ad/Capabilities;->TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    const-string v1, "recordVideoView"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 38
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    .line 40
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "supportsSlotTemplate"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 41
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "supportsAdUnitInMultipleSlots"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 42
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "supportsSlotCallback"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 43
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "requiresRendererManifest"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 44
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "supportNullCreative"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 45
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "expectMultipleCreativeRenditions"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 46
    sget-object v0, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    const-string v1, "supportsFallbackAds"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 47
    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v1, Ljava/util/TreeMap;

    invoke-direct {v1}, Ljava/util/TreeMap;-><init>()V

    iput-object v1, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    .line 51
    sget-object v1, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    invoke-virtual {v1}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 52
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 53
    iget-object v1, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 55
    :cond_0
    sget-object v1, Ltv/freewheel/ad/Capabilities;->TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 56
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 57
    iget-object v1, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 59
    :cond_1
    return-void
.end method


# virtual methods
.method public buildXMLElement()Ltv/freewheel/utils/XMLElement;
    .locals 6

    .prologue
    .line 94
    new-instance v3, Ltv/freewheel/utils/XMLElement;

    const-string v5, "capabilities"

    invoke-direct {v3, v5}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 95
    .local v3, "node":Ltv/freewheel/utils/XMLElement;
    iget-object v5, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-virtual {v5}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 96
    .local v2, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 97
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 98
    .local v0, "capName":Ljava/lang/String;
    invoke-virtual {p0, v0}, Ltv/freewheel/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v4

    .line 100
    .local v4, "status":I
    sget-object v5, Ltv/freewheel/ad/Capabilities;->TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 101
    new-instance v1, Ltv/freewheel/utils/XMLElement;

    invoke-direct {v1, v0}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 102
    .local v1, "childNode":Ltv/freewheel/utils/XMLElement;
    if-nez v4, :cond_1

    .line 103
    const-string v5, "true"

    invoke-virtual {v1, v5}, Ltv/freewheel/utils/XMLElement;->setText(Ljava/lang/String;)V

    .line 109
    :goto_1
    invoke-virtual {v3, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_0

    .line 104
    :cond_1
    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 105
    const-string v5, "false"

    invoke-virtual {v1, v5}, Ltv/freewheel/utils/XMLElement;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 110
    .end local v1    # "childNode":Ltv/freewheel/utils/XMLElement;
    :cond_2
    if-nez v4, :cond_0

    .line 111
    new-instance v1, Ltv/freewheel/utils/XMLElement;

    invoke-direct {v1, v0}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 112
    .restart local v1    # "childNode":Ltv/freewheel/utils/XMLElement;
    invoke-virtual {v3, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_0

    .line 116
    .end local v0    # "capName":Ljava/lang/String;
    .end local v1    # "childNode":Ltv/freewheel/utils/XMLElement;
    .end local v4    # "status":I
    :cond_3
    return-object v3
.end method

.method public getCapability(Ljava/lang/String;)I
    .locals 3
    .param p1, "capability"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 69
    iget-object v1, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-virtual {v1, p1}, Ljava/util/TreeMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 70
    iget-object v1, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-virtual {v1, p1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 71
    .local v0, "status":I
    sget-object v1, Ltv/freewheel/ad/Capabilities;->TRI_VALUE_CAPABILITIES:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 84
    .end local v0    # "status":I
    :cond_0
    :goto_0
    return v0

    .line 74
    .restart local v0    # "status":I
    :cond_1
    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 75
    sget-object v1, Ltv/freewheel/ad/Capabilities;->DEFAULT_CAPABILITIES:Ljava/util/HashSet;

    invoke-virtual {v1, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 76
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    move v0, v2

    .line 78
    goto :goto_0

    .end local v0    # "status":I
    :cond_3
    move v0, v2

    .line 84
    goto :goto_0
.end method

.method public setCapability(Ljava/lang/String;I)V
    .locals 2
    .param p1, "capability"    # Ljava/lang/String;
    .param p2, "status"    # I

    .prologue
    .line 62
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 66
    :cond_0
    :goto_0
    return-void

    .line 65
    :cond_1
    iget-object v0, p0, Ltv/freewheel/ad/Capabilities;->capabilities:Ljava/util/TreeMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method
