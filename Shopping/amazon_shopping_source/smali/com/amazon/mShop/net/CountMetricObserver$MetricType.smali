.class public final enum Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
.super Ljava/lang/Enum;
.source "CountMetricObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/CountMetricObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MetricType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/CountMetricObserver$MetricType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

.field public static final enum FLOW_SCAN:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 26
    new-instance v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    const-string/jumbo v1, "FLOW_SCAN"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->FLOW_SCAN:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    .line 25
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    sget-object v1, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->FLOW_SCAN:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->$VALUES:[Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->$VALUES:[Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    return-object v0
.end method
