.class public final enum Lcom/amazon/client/metrics/configuration/CodecType;
.super Ljava/lang/Enum;
.source "CodecType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/configuration/CodecType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/configuration/CodecType;

.field public static final enum PROTOCOL_BUFFERS:Lcom/amazon/client/metrics/configuration/CodecType;

.field public static final enum STRING:Lcom/amazon/client/metrics/configuration/CodecType;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 8
    new-instance v0, Lcom/amazon/client/metrics/configuration/CodecType;

    const-string/jumbo v1, "PROTOCOL_BUFFERS"

    const-string/jumbo v2, "ProtocolBuffers"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/client/metrics/configuration/CodecType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/CodecType;->PROTOCOL_BUFFERS:Lcom/amazon/client/metrics/configuration/CodecType;

    .line 9
    new-instance v0, Lcom/amazon/client/metrics/configuration/CodecType;

    const-string/jumbo v1, "STRING"

    const-string/jumbo v2, "String"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/client/metrics/configuration/CodecType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/CodecType;->STRING:Lcom/amazon/client/metrics/configuration/CodecType;

    .line 6
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/client/metrics/configuration/CodecType;

    sget-object v1, Lcom/amazon/client/metrics/configuration/CodecType;->PROTOCOL_BUFFERS:Lcom/amazon/client/metrics/configuration/CodecType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/configuration/CodecType;->STRING:Lcom/amazon/client/metrics/configuration/CodecType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/client/metrics/configuration/CodecType;->$VALUES:[Lcom/amazon/client/metrics/configuration/CodecType;

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
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/CodecType;->mName:Ljava/lang/String;

    .line 16
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/CodecType;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/client/metrics/configuration/CodecType;->values()[Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/client/metrics/configuration/CodecType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 24
    .local v3, "value":Lcom/amazon/client/metrics/configuration/CodecType;
    invoke-virtual {v3}, Lcom/amazon/client/metrics/configuration/CodecType;->getName()Ljava/lang/String;

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
    .end local v3    # "value":Lcom/amazon/client/metrics/configuration/CodecType;
    :cond_1
    new-instance v4, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " is not a valid Codec"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/CodecType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/amazon/client/metrics/configuration/CodecType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/CodecType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/configuration/CodecType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/amazon/client/metrics/configuration/CodecType;->$VALUES:[Lcom/amazon/client/metrics/configuration/CodecType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/configuration/CodecType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/configuration/CodecType;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/CodecType;->mName:Ljava/lang/String;

    return-object v0
.end method
