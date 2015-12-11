.class public Lcom/xfinity/playerlib/model/consumable/NetworkInfo;
.super Ljava/lang/Object;
.source "NetworkInfo.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonAutoDetect;
.end annotation


# instance fields
.field private displayName:Ljava/lang/String;

.field private isPremium:Z

.field private networkId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 42
    if-ne p0, p1, :cond_1

    .line 59
    :cond_0
    :goto_0
    return v1

    .line 45
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 46
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 48
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;

    .line 49
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/NetworkInfo;
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->isPremium:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->isPremium:Z

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 50
    goto :goto_0

    .line 52
    :cond_4
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->networkId:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->networkId:I

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 53
    goto :goto_0

    .line 56
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 57
    goto :goto_0

    .line 56
    :cond_6
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkId()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->networkId:I

    return v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 64
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->networkId:I

    .line 65
    .local v0, "result":I
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->isPremium:Z

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    add-int v0, v3, v1

    .line 66
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 67
    return v0

    :cond_1
    move v1, v2

    .line 65
    goto :goto_0
.end method

.method public isPremium()Z
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "isPremium"
    .end annotation

    .prologue
    .line 25
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->isPremium:Z

    return v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->displayName:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setNetworkId(I)V
    .locals 0
    .param p1, "networkId"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->networkId:I

    .line 38
    return-void
.end method

.method public setisPremium(Z)V
    .locals 0
    .param p1, "premium"    # Z

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/consumable/NetworkInfo;->isPremium:Z

    .line 30
    return-void
.end method
