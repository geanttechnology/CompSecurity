.class public final enum Lcom/amazon/mShop/net/MetricsAggregator$Type;
.super Ljava/lang/Enum;
.source "MetricsAggregator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MetricsAggregator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/MetricsAggregator$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum CallMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum ClickedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum CountMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum ErrorExceptionMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum ExposedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum NetworkInfoMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum OrientationMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum PageMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum RefMarkerMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

.field public static final enum StartupMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 80
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "CallMetric"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CallMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 85
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "PageMetric"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->PageMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 90
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "ExposedSlotsMetric"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ExposedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 95
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "ClickedSlotsMetric"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ClickedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 100
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "ErrorExceptionMetric"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ErrorExceptionMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 105
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "OrientationMetric"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->OrientationMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 110
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "RefMarkerMetric"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->RefMarkerMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 115
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "StartupMetric"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->StartupMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 120
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "CountMetric"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CountMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 125
    new-instance v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    const-string/jumbo v1, "NetworkInfoMetric"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsAggregator$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->NetworkInfoMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .line 76
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/amazon/mShop/net/MetricsAggregator$Type;

    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CallMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator$Type;->PageMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ExposedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ClickedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ErrorExceptionMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/net/MetricsAggregator$Type;->OrientationMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mShop/net/MetricsAggregator$Type;->RefMarkerMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mShop/net/MetricsAggregator$Type;->StartupMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CountMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mShop/net/MetricsAggregator$Type;->NetworkInfoMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->$VALUES:[Lcom/amazon/mShop/net/MetricsAggregator$Type;

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
    .line 76
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 76
    const-class v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->$VALUES:[Lcom/amazon/mShop/net/MetricsAggregator$Type;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/MetricsAggregator$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method
