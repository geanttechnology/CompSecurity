.class public final enum Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
.super Ljava/lang/Enum;
.source "HttpRequestSignerType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

.field public static final enum DCP:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

.field public static final enum DCP_OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

.field public static final enum OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;


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
    new-instance v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    const-string/jumbo v1, "DCP"

    const-string/jumbo v2, "Dcp"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->DCP:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    .line 9
    new-instance v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    const-string/jumbo v1, "DCP_OAUTH"

    const-string/jumbo v2, "DcpOAuth"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->DCP_OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    .line 10
    new-instance v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    const-string/jumbo v1, "OAUTH"

    const-string/jumbo v2, "OAuth"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    .line 6
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    sget-object v1, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->DCP:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->DCP_OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->$VALUES:[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

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
    .line 15
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 16
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->mName:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->values()[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 25
    .local v3, "value":Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    invoke-virtual {v3}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 26
    return-object v3

    .line 24
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 29
    .end local v3    # "value":Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    :cond_1
    new-instance v4, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " is not a valid RequestSignerType"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->$VALUES:[Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->mName:Ljava/lang/String;

    return-object v0
.end method
