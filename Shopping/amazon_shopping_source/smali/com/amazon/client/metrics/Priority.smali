.class public final enum Lcom/amazon/client/metrics/Priority;
.super Ljava/lang/Enum;
.source "Priority.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/Priority;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/Priority;

.field public static final enum HIGH:Lcom/amazon/client/metrics/Priority;

.field public static final enum NORMAL:Lcom/amazon/client/metrics/Priority;

.field public static final enum RESERVED_FOR_LOCATION_SERVICE:Lcom/amazon/client/metrics/Priority;

.field public static final enum RESERVED_FOR_NON_ANONYMOUS_METRICS:Lcom/amazon/client/metrics/Priority;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-instance v0, Lcom/amazon/client/metrics/Priority;

    const-string/jumbo v1, "NORMAL"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    .line 33
    new-instance v0, Lcom/amazon/client/metrics/Priority;

    const-string/jumbo v1, "HIGH"

    invoke-direct {v0, v1, v3}, Lcom/amazon/client/metrics/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/Priority;->HIGH:Lcom/amazon/client/metrics/Priority;

    .line 37
    new-instance v0, Lcom/amazon/client/metrics/Priority;

    const-string/jumbo v1, "RESERVED_FOR_LOCATION_SERVICE"

    invoke-direct {v0, v1, v4}, Lcom/amazon/client/metrics/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_LOCATION_SERVICE:Lcom/amazon/client/metrics/Priority;

    .line 43
    new-instance v0, Lcom/amazon/client/metrics/Priority;

    const-string/jumbo v1, "RESERVED_FOR_NON_ANONYMOUS_METRICS"

    invoke-direct {v0, v1, v5}, Lcom/amazon/client/metrics/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_NON_ANONYMOUS_METRICS:Lcom/amazon/client/metrics/Priority;

    .line 25
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/client/metrics/Priority;

    sget-object v1, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/client/metrics/Priority;->HIGH:Lcom/amazon/client/metrics/Priority;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_LOCATION_SERVICE:Lcom/amazon/client/metrics/Priority;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_NON_ANONYMOUS_METRICS:Lcom/amazon/client/metrics/Priority;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/Priority;->$VALUES:[Lcom/amazon/client/metrics/Priority;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static fromInt(I)Lcom/amazon/client/metrics/Priority;
    .locals 3
    .param p0, "priorityNum"    # I

    .prologue
    .line 47
    if-ltz p0, :cond_0

    invoke-static {}, Lcom/amazon/client/metrics/Priority;->values()[Lcom/amazon/client/metrics/Priority;

    move-result-object v0

    array-length v0, v0

    if-le p0, v0, :cond_1

    .line 48
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "invalid priority "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_1
    invoke-static {}, Lcom/amazon/client/metrics/Priority;->values()[Lcom/amazon/client/metrics/Priority;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/Priority;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/amazon/client/metrics/Priority;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/Priority;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/Priority;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/client/metrics/Priority;->$VALUES:[Lcom/amazon/client/metrics/Priority;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/Priority;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/Priority;

    return-object v0
.end method
