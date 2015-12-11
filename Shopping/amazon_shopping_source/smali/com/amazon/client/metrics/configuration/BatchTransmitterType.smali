.class public final enum Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
.super Ljava/lang/Enum;
.source "BatchTransmitterType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/configuration/BatchTransmitterType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

.field public static final enum NOS:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

.field public static final enum PERIODIC:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

.field public static final enum URGENT:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 8
    new-instance v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    const-string/jumbo v1, "PERIODIC"

    const-string/jumbo v2, "Periodic"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->PERIODIC:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    .line 9
    new-instance v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    const-string/jumbo v1, "NOS"

    const-string/jumbo v2, "Nos"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->NOS:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    .line 10
    new-instance v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    const-string/jumbo v1, "URGENT"

    const-string/jumbo v2, "Urgent"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->URGENT:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    .line 6
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    sget-object v1, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->PERIODIC:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->NOS:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->URGENT:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->$VALUES:[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 15
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->mName:Ljava/lang/String;

    .line 16
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->values()[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 24
    .local v3, "value":Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    invoke-virtual {v3}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 25
    return-object v3

    .line 23
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 28
    .end local v3    # "value":Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    :cond_1
    new-instance v4, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " is not a valid BatchTransmitterType"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->$VALUES:[Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->mName:Ljava/lang/String;

    return-object v0
.end method
