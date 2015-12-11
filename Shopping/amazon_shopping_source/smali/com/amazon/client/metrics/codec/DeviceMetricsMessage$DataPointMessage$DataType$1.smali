.class final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/protobuf/Internal$EnumLiteMap;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/protobuf/Internal$EnumLiteMap",
        "<",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public findValueByNumber(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 1

    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->valueOf(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic findValueByNumber(I)Lcom/google/protobuf/Internal$EnumLite;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType$1;->findValueByNumber(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    move-result-object v0

    return-object v0
.end method
