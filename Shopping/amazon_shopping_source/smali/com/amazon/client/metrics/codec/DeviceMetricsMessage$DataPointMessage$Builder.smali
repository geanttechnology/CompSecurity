.class public final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
.super Lcom/google/protobuf/GeneratedMessage$Builder;

# interfaces
.implements Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessage$Builder",
        "<",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;",
        ">;",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;"
    }
.end annotation


# instance fields
.field private bitField0_:I

.field private name_:Ljava/lang/Object;

.field private sampleSize_:I

.field private type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

.field private value_:Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessage$Builder;-><init>()V

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->maybeForceBuilderInitialization()V

    return-void
.end method

.method private constructor <init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V
    .locals 1

    invoke-direct {p0, p1}, Lcom/google/protobuf/GeneratedMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->maybeForceBuilderInitialization()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V

    return-void
.end method

.method static synthetic access$3000(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$3100()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method private buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->isInitialized()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->newUninitializedMessageException(Lcom/google/protobuf/Message;)Lcom/google/protobuf/UninitializedMessageException;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/UninitializedMessageException;->asInvalidProtocolBufferException()Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object v0

    throw v0

    :cond_0
    return-object v0
.end method

.method private static create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    invoke-direct {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;-><init>()V

    return-object v0
.end method

.method public static final getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_DataPointMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$2800()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method private maybeForceBuilderInitialization()V
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->alwaysUseFieldBuilders:Z
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3300()Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_0
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 2

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->isInitialized()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->newUninitializedMessageException(Lcom/google/protobuf/Message;)Lcom/google/protobuf/UninitializedMessageException;

    move-result-object v0

    throw v0

    :cond_0
    return-object v0
.end method

.method public bridge synthetic build()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 5

    const/4 v0, 0x1

    new-instance v2, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    const/4 v1, 0x0

    invoke-direct {v2, p0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;-><init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V

    iget v3, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    const/4 v1, 0x0

    and-int/lit8 v4, v3, 0x1

    if-ne v4, v0, :cond_3

    :goto_0
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->name_:Ljava/lang/Object;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3502(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;Ljava/lang/Object;)Ljava/lang/Object;

    and-int/lit8 v1, v3, 0x2

    const/4 v4, 0x2

    if-ne v1, v4, :cond_0

    or-int/lit8 v0, v0, 0x2

    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->value_:Ljava/lang/Object;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3602(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;Ljava/lang/Object;)Ljava/lang/Object;

    and-int/lit8 v1, v3, 0x4

    const/4 v4, 0x4

    if-ne v1, v4, :cond_1

    or-int/lit8 v0, v0, 0x4

    :cond_1
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->sampleSize_:I
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3702(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;I)I

    and-int/lit8 v1, v3, 0x8

    const/16 v3, 0x8

    if-ne v1, v3, :cond_2

    or-int/lit8 v0, v0, 0x8

    :cond_2
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3802(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->bitField0_:I
    invoke-static {v2, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->access$3902(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;I)I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onBuilt()V

    return-object v2

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public bridge synthetic buildPartial()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic buildPartial()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    invoke-super {p0}, Lcom/google/protobuf/GeneratedMessage$Builder;->clear()Lcom/google/protobuf/GeneratedMessage$Builder;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    return-object p0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/GeneratedMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public clearName()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clearSampleSize()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clearType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clearValue()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 2

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/AbstractMessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/GeneratedMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    return-object v0
.end method

.method public getDescriptorForType()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-nez v1, :cond_0

    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getSampleSize()I
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    return v0
.end method

.method public getType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-nez v1, :cond_0

    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public hasName()Z
    .locals 2

    const/4 v0, 0x1

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v1, v1, 0x1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasSampleSize()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x4

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasType()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x8

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasValue()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected internalGetFieldAccessorTable()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_DataPointMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$2900()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    move-result-object v0

    return-object v0
.end method

.method public final isInitialized()Z
    .locals 2

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->hasName()Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->hasValue()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->hasSampleSize()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->hasType()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v0

    if-ne p1, v0, :cond_0

    :goto_0
    return-object p0

    :cond_0
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->hasName()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setName(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->hasValue()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setValue(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    :cond_2
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->hasSampleSize()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getSampleSize()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setSampleSize(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    :cond_3
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->hasType()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setType(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    :cond_4
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    goto :goto_0
.end method

.method public mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-static {v0}, Lcom/google/protobuf/UnknownFieldSet;->newBuilder(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/UnknownFieldSet$Builder;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    invoke-virtual {p0, p1, v0, p2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->parseUnknownField(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet$Builder;->build()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    :goto_1
    return-object p0

    :sswitch_0
    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet$Builder;->build()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    goto :goto_1

    :sswitch_1
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    goto :goto_0

    :sswitch_2
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    goto :goto_0

    :sswitch_3
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readInt32()I

    move-result v1

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    goto :goto_0

    :sswitch_4
    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result v1

    invoke-static {v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->valueOf(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    move-result-object v2

    if-nez v2, :cond_1

    const/4 v2, 0x4

    invoke-virtual {v0, v2, v1}, Lcom/google/protobuf/UnknownFieldSet$Builder;->mergeVarintField(II)Lcom/google/protobuf/UnknownFieldSet$Builder;

    goto :goto_0

    :cond_1
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x8

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xa -> :sswitch_1
        0x12 -> :sswitch_2
        0x18 -> :sswitch_3
        0x20 -> :sswitch_4
    .end sparse-switch
.end method

.method public mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    instance-of v0, p1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object p0

    :goto_0
    return-object p0

    :cond_0
    invoke-super {p0, p1}, Lcom/google/protobuf/GeneratedMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/AbstractMessage$Builder;

    goto :goto_0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessageLite$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/Message$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setName(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method setName(Lcom/google/protobuf/ByteString;)V
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->name_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-void
.end method

.method public setSampleSize(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->sampleSize_:I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public setType(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->type_:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public setValue(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-object p0
.end method

.method setValue(Lcom/google/protobuf/ByteString;)V
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->value_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->onChanged()V

    return-void
.end method
