.class public Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
.super Ljava/lang/Object;
.source "ParentalControlsSettings.java"


# instance fields
.field private final parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

.field private final protectedNetworkIds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final protectedRatings:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/model/Rating;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;Ljava/util/List;Ljava/util/List;)V
    .locals 1
    .param p1, "parentalPin"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "parentalPin"
        .end annotation
    .end param
    .param p2    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "protectedRatings"
        .end annotation
    .end param
    .param p3    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "protectedNetworks"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/model/Rating;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p2, "protectedRatings":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/model/Rating;>;"
    .local p3, "protectedNetworks":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    .line 18
    invoke-static {p2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    .line 19
    invoke-static {p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    .line 20
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 37
    if-ne p0, p1, :cond_1

    .line 55
    :cond_0
    :goto_0
    return v1

    .line 40
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 41
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 43
    check-cast v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    .line 45
    .local v0, "that":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    iget-object v4, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-virtual {v3, v4}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 46
    goto :goto_0

    .line 45
    :cond_5
    iget-object v3, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    if-nez v3, :cond_4

    .line 48
    :cond_6
    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    iget-object v4, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 49
    goto :goto_0

    .line 48
    :cond_8
    iget-object v3, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    if-nez v3, :cond_7

    .line 52
    :cond_9
    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    if-eqz v3, :cond_a

    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    iget-object v4, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 53
    goto :goto_0

    .line 52
    :cond_a
    iget-object v3, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getParentalPin()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    return-object v0
.end method

.method public getProtectedNetworkIds()Ljava/util/List;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "protectedNetworks"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    return-object v0
.end method

.method public getProtectedRatings()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/model/Rating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 60
    iget-object v2, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->parentalPin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-virtual {v2}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->hashCode()I

    move-result v0

    .line 61
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedRatings:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 62
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->protectedNetworkIds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 63
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 60
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 61
    goto :goto_1
.end method
