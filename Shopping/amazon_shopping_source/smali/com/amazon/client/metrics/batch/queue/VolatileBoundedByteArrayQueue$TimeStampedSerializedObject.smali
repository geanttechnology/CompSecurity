.class Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;
.super Ljava/lang/Object;
.source "VolatileBoundedByteArrayQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TimeStampedSerializedObject"
.end annotation


# instance fields
.field private mSerializedObject:[B

.field private mTimeStamp:J

.field final synthetic this$0:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;J[B)V
    .locals 0
    .param p2, "timeStamp"    # J
    .param p4, "serializedObject"    # [B

    .prologue
    .line 142
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->this$0:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    iput-wide p2, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->mTimeStamp:J

    .line 144
    iput-object p4, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->mSerializedObject:[B

    .line 145
    return-void
.end method


# virtual methods
.method public getSerializedObject()[B
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->mSerializedObject:[B

    return-object v0
.end method

.method public getTimeStamp()J
    .locals 2

    .prologue
    .line 148
    iget-wide v0, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->mTimeStamp:J

    return-wide v0
.end method
