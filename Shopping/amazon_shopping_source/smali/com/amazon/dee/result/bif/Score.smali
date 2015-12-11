.class public Lcom/amazon/dee/result/bif/Score;
.super Ljava/lang/Object;
.source "Score.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# static fields
.field public static final ZERO:Lcom/amazon/dee/result/bif/Score;


# instance fields
.field private mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

.field private mValue:D


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 84
    new-instance v0, Lcom/amazon/dee/result/bif/Score;

    const-wide/16 v1, 0x0

    invoke-direct {v0, v1, v2}, Lcom/amazon/dee/result/bif/Score;-><init>(D)V

    sput-object v0, Lcom/amazon/dee/result/bif/Score;->ZERO:Lcom/amazon/dee/result/bif/Score;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method

.method public constructor <init>(D)V
    .locals 1
    .param p1, "value"    # D

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-wide p1, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    .line 31
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    .line 32
    return-void
.end method

.method public constructor <init>(DLcom/amazon/dee/result/bif/ConfidenceBin;)V
    .locals 0
    .param p1, "value"    # D
    .param p3, "bin"    # Lcom/amazon/dee/result/bif/ConfidenceBin;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-wide p1, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    .line 37
    iput-object p3, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    .line 38
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 43
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Score;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 45
    check-cast v0, Lcom/amazon/dee/result/bif/Score;

    .line 46
    .local v0, "other":Lcom/amazon/dee/result/bif/Score;
    iget-wide v2, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    iget-wide v3, v0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 51
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Score;
    :cond_0
    return v1
.end method

.method public getBin()Lcom/amazon/dee/result/bif/ConfidenceBin;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    return-object v0
.end method

.method public getValue()D
    .locals 2

    .prologue
    .line 73
    iget-wide v0, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    return-wide v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 58
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-wide v2, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setBin(Lcom/amazon/dee/result/bif/ConfidenceBin;)V
    .locals 0
    .param p1, "bin"    # Lcom/amazon/dee/result/bif/ConfidenceBin;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Score;->mBin:Lcom/amazon/dee/result/bif/ConfidenceBin;

    .line 69
    return-void
.end method

.method public setValue(D)V
    .locals 0
    .param p1, "value"    # D

    .prologue
    .line 78
    iput-wide p1, p0, Lcom/amazon/dee/result/bif/Score;->mValue:D

    .line 79
    return-void
.end method
