.class public Lcom/amazon/dee/result/bif/Token;
.super Ljava/lang/Object;
.source "Token.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mConfidence:D

.field private mValue:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 33
    const-wide/16 v0, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/dee/result/bif/Token;-><init>(Ljava/lang/String;D)V

    .line 34
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;D)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "confidence"    # D

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    .line 47
    iput-wide p2, p0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    .line 48
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 53
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Token;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 55
    check-cast v0, Lcom/amazon/dee/result/bif/Token;

    .line 56
    .local v0, "other":Lcom/amazon/dee/result/bif/Token;
    iget-wide v2, p0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    iget-wide v3, v0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 61
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Token;
    :cond_0
    return v1
.end method

.method public final getConfidence()D
    .locals 2

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    return-wide v0
.end method

.method public final getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 68
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-wide v2, p0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final setConfidence(D)V
    .locals 0
    .param p1, "confidence"    # D

    .prologue
    .line 110
    iput-wide p1, p0, Lcom/amazon/dee/result/bif/Token;->mConfidence:D

    .line 111
    return-void
.end method

.method public final setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Token;->mValue:Ljava/lang/String;

    .line 90
    return-void
.end method
