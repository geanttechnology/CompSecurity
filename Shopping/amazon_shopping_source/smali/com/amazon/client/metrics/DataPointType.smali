.class public final enum Lcom/amazon/client/metrics/DataPointType;
.super Ljava/lang/Enum;
.source "DataPointType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/DataPointType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/DataPointType;

.field public static final enum CK:Lcom/amazon/client/metrics/DataPointType;

.field public static final enum CT:Lcom/amazon/client/metrics/DataPointType;

.field public static final enum DV:Lcom/amazon/client/metrics/DataPointType;

.field public static final enum TI:Lcom/amazon/client/metrics/DataPointType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 27
    new-instance v0, Lcom/amazon/client/metrics/DataPointType;

    const-string/jumbo v1, "CT"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/DataPointType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/DataPointType;->CT:Lcom/amazon/client/metrics/DataPointType;

    .line 31
    new-instance v0, Lcom/amazon/client/metrics/DataPointType;

    const-string/jumbo v1, "TI"

    invoke-direct {v0, v1, v3}, Lcom/amazon/client/metrics/DataPointType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/DataPointType;->TI:Lcom/amazon/client/metrics/DataPointType;

    .line 35
    new-instance v0, Lcom/amazon/client/metrics/DataPointType;

    const-string/jumbo v1, "DV"

    invoke-direct {v0, v1, v4}, Lcom/amazon/client/metrics/DataPointType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/DataPointType;->DV:Lcom/amazon/client/metrics/DataPointType;

    .line 39
    new-instance v0, Lcom/amazon/client/metrics/DataPointType;

    const-string/jumbo v1, "CK"

    invoke-direct {v0, v1, v5}, Lcom/amazon/client/metrics/DataPointType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    .line 23
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/client/metrics/DataPointType;

    sget-object v1, Lcom/amazon/client/metrics/DataPointType;->CT:Lcom/amazon/client/metrics/DataPointType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/client/metrics/DataPointType;->TI:Lcom/amazon/client/metrics/DataPointType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/DataPointType;->DV:Lcom/amazon/client/metrics/DataPointType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/DataPointType;->$VALUES:[Lcom/amazon/client/metrics/DataPointType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static fromInt(I)Lcom/amazon/client/metrics/DataPointType;
    .locals 3
    .param p0, "datapointNum"    # I

    .prologue
    .line 50
    if-ltz p0, :cond_0

    invoke-static {}, Lcom/amazon/client/metrics/DataPointType;->values()[Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    array-length v0, v0

    if-le p0, v0, :cond_1

    .line 51
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "invalid datapoint "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_1
    invoke-static {}, Lcom/amazon/client/metrics/DataPointType;->values()[Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static getCounterType()Lcom/amazon/client/metrics/DataPointType;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 64
    sget-object v0, Lcom/amazon/client/metrics/DataPointType;->CT:Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method

.method public static getDiscreteValueType()Lcom/amazon/client/metrics/DataPointType;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 84
    sget-object v0, Lcom/amazon/client/metrics/DataPointType;->DV:Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method

.method public static getTimerType()Lcom/amazon/client/metrics/DataPointType;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 74
    sget-object v0, Lcom/amazon/client/metrics/DataPointType;->TI:Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/DataPointType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    const-class v0, Lcom/amazon/client/metrics/DataPointType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/DataPointType;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/client/metrics/DataPointType;->$VALUES:[Lcom/amazon/client/metrics/DataPointType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/DataPointType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method
