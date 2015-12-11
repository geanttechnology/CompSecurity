.class public final enum Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
.super Ljava/lang/Enum;
.source "MetricIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/metrics/MetricIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Level"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/metrics/MetricIdentifier$Level;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

.field public static final enum CRITICAL:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

.field public static final enum ERROR:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

.field public static final enum INFO:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

.field public static final enum WARN:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 119
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    const-string/jumbo v1, "INFO"

    invoke-direct {v0, v1, v2}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->INFO:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    .line 120
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    const-string/jumbo v1, "WARN"

    invoke-direct {v0, v1, v3}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->WARN:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    .line 121
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    const-string/jumbo v1, "ERROR"

    invoke-direct {v0, v1, v4}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->ERROR:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    .line 122
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    const-string/jumbo v1, "CRITICAL"

    invoke-direct {v0, v1, v5}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->CRITICAL:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    .line 117
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    sget-object v1, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->INFO:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->WARN:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->ERROR:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->CRITICAL:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->$VALUES:[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

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
    .line 117
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static fromCode(I)Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    .locals 5
    .param p0, "code"    # I

    .prologue
    .line 127
    invoke-static {}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->values()[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 129
    .local v3, "level":Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    invoke-virtual {v3}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->ordinal()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 131
    return-object v3

    .line 127
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 134
    .end local v3    # "level":Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    :cond_1
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 117
    const-class v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    .locals 1

    .prologue
    .line 117
    sget-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->$VALUES:[Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    invoke-virtual {v0}, [Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    return-object v0
.end method
