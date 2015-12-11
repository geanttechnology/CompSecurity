.class public Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
.super Ljava/lang/Object;
.source "HalActor.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
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

    .line 21
    if-ne p0, p1, :cond_1

    .line 28
    :cond_0
    :goto_0
    return v1

    .line 24
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 25
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 27
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;

    .line 28
    .local v0, "halActor":Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0

    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    if-nez v3, :cond_4

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 1
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 12
    const-string v0, "name"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->name:Ljava/lang/String;

    .line 13
    return-void
.end method
