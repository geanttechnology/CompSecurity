.class public final enum Lcom/amazon/client/metrics/MetricEventType;
.super Ljava/lang/Enum;
.source "MetricEventType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/MetricEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/MetricEventType;

.field public static final enum AGGREGATING:Lcom/amazon/client/metrics/MetricEventType;

.field public static final enum AVERAGING:Lcom/amazon/client/metrics/MetricEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 47
    new-instance v0, Lcom/amazon/client/metrics/MetricEventType;

    const-string/jumbo v1, "AGGREGATING"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/MetricEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/MetricEventType;->AGGREGATING:Lcom/amazon/client/metrics/MetricEventType;

    .line 52
    new-instance v0, Lcom/amazon/client/metrics/MetricEventType;

    const-string/jumbo v1, "AVERAGING"

    invoke-direct {v0, v1, v3}, Lcom/amazon/client/metrics/MetricEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/MetricEventType;->AVERAGING:Lcom/amazon/client/metrics/MetricEventType;

    .line 42
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/client/metrics/MetricEventType;

    sget-object v1, Lcom/amazon/client/metrics/MetricEventType;->AGGREGATING:Lcom/amazon/client/metrics/MetricEventType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/client/metrics/MetricEventType;->AVERAGING:Lcom/amazon/client/metrics/MetricEventType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/client/metrics/MetricEventType;->$VALUES:[Lcom/amazon/client/metrics/MetricEventType;

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
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static getDefault()Lcom/amazon/client/metrics/MetricEventType;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/amazon/client/metrics/MetricEventType;->AGGREGATING:Lcom/amazon/client/metrics/MetricEventType;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEventType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 42
    const-class v0, Lcom/amazon/client/metrics/MetricEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/MetricEventType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/MetricEventType;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/amazon/client/metrics/MetricEventType;->$VALUES:[Lcom/amazon/client/metrics/MetricEventType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/MetricEventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/MetricEventType;

    return-object v0
.end method
