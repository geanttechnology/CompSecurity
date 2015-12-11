.class public Lcom/amazon/dee/result/bif/SlotTrait;
.super Ljava/lang/Object;
.source "SlotTrait.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mName:Ljava/lang/String;

.field private mType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    .line 34
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 39
    instance-of v2, p1, Lcom/amazon/dee/result/bif/SlotTrait;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 41
    check-cast v0, Lcom/amazon/dee/result/bif/SlotTrait;

    .line 42
    .local v0, "other":Lcom/amazon/dee/result/bif/SlotTrait;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 47
    .end local v0    # "other":Lcom/amazon/dee/result/bif/SlotTrait;
    :cond_0
    return v1
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public final getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 54
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mName:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public final setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/dee/result/bif/SlotTrait;->mType:Ljava/lang/String;

    .line 87
    return-void
.end method
