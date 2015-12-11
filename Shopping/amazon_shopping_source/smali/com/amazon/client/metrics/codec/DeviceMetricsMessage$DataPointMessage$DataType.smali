.class public final enum Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
.super Ljava/lang/Enum;

# interfaces
.implements Lcom/google/protobuf/ProtocolMessageEnum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DataType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;",
        ">;",
        "Lcom/google/protobuf/ProtocolMessageEnum;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field public static final enum CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field public static final CLICKSTREAM_VALUE:I = 0x3

.field public static final enum COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field public static final COUNTER_VALUE:I = 0x0

.field public static final enum DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field public static final DISCRETE_VALUE:I = 0x2

.field public static final enum TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field public static final TIMER_VALUE:I = 0x1

.field private static final VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field private static internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Internal$EnumLiteMap",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final index:I

.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    const-string/jumbo v1, "COUNTER"

    invoke-direct {v0, v1, v2, v2, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;-><init>(Ljava/lang/String;III)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    const-string/jumbo v1, "TIMER"

    invoke-direct {v0, v1, v3, v3, v3}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;-><init>(Ljava/lang/String;III)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    const-string/jumbo v1, "DISCRETE"

    invoke-direct {v0, v1, v4, v4, v4}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;-><init>(Ljava/lang/String;III)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    const-string/jumbo v1, "CLICKSTREAM"

    invoke-direct {v0, v1, v5, v5, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;-><init>(Ljava/lang/String;III)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    new-array v0, v6, [Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->$VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType$1;

    invoke-direct {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType$1;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;

    new-array v0, v6, [Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;III)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->index:I

    iput p4, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->value:I

    return-void
.end method

.method public static final getDescriptor()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    .locals 2

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$Descriptor;->getEnumTypes()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$EnumDescriptor;

    return-object v0
.end method

.method public static internalGetValueMap()Lcom/google/protobuf/Internal$EnumLiteMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Internal$EnumLiteMap",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;",
            ">;"
        }
    .end annotation

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;

    return-object v0
.end method

.method public static valueOf(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 1

    packed-switch p0, :pswitch_data_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :pswitch_0
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    :pswitch_1
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    :pswitch_2
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    :pswitch_3
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static valueOf(Lcom/google/protobuf/Descriptors$EnumValueDescriptor;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 2

    invoke-virtual {p0}, Lcom/google/protobuf/Descriptors$EnumValueDescriptor;->getType()Lcom/google/protobuf/Descriptors$EnumDescriptor;

    move-result-object v0

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->getDescriptor()Lcom/google/protobuf/Descriptors$EnumDescriptor;

    move-result-object v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "EnumValueDescriptor is not for this type."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-virtual {p0}, Lcom/google/protobuf/Descriptors$EnumValueDescriptor;->getIndex()I

    move-result v1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 1

    const-class v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 1

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->$VALUES:[Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    return-object v0
.end method


# virtual methods
.method public final getDescriptorForType()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->getDescriptor()Lcom/google/protobuf/Descriptors$EnumDescriptor;

    move-result-object v0

    return-object v0
.end method

.method public final getNumber()I
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->value:I

    return v0
.end method

.method public final getValueDescriptor()Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
    .locals 2

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->getDescriptor()Lcom/google/protobuf/Descriptors$EnumDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$EnumDescriptor;->getValues()Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->index:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$EnumValueDescriptor;

    return-object v0
.end method
