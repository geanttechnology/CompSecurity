.class public Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
.super Ljava/lang/Object;
.source "ParentalControlsPin.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private final pin:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "pin"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notBlank(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->pin:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 22
    if-ne p0, p1, :cond_0

    .line 23
    const/4 v1, 0x1

    .line 29
    :goto_0
    return v1

    .line 25
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-eq v1, v2, :cond_2

    .line 26
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 28
    check-cast v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    .line 29
    .local v0, "that":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    iget-object v1, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->pin:Ljava/lang/String;

    iget-object v2, v0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->pin:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public getPin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->pin:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->pin:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonValue;
    .end annotation

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->getPin()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
