.class public Lco/vine/android/recorder/VideoData;
.super Ljava/lang/Object;
.source "VideoData.java"

# interfaces
.implements Ljava/io/Externalizable;


# static fields
.field private static final serialVersionUID:J = 0x773635a4cd84a345L

.field private static final version:J = -0x2L


# instance fields
.field data:[B

.field public keyFrame:Z

.field segment:Lco/vine/android/recorder/RecordSegment;

.field size:I

.field public start:I

.field timestamp:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public constructor <init>(J[B)V
    .locals 1
    .param p1, "timestamp"    # J
    .param p3, "data"    # [B

    .prologue
    const/4 v0, -0x1

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-wide p1, p0, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 38
    iput-object p3, p0, Lco/vine/android/recorder/VideoData;->data:[B

    .line 39
    iput v0, p0, Lco/vine/android/recorder/VideoData;->start:I

    .line 40
    iput v0, p0, Lco/vine/android/recorder/VideoData;->size:I

    .line 41
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/VideoData;)V
    .locals 2
    .param p1, "source"    # Lco/vine/android/recorder/VideoData;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iget-wide v0, p1, Lco/vine/android/recorder/VideoData;->timestamp:J

    iput-wide v0, p0, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 49
    iget-object v0, p1, Lco/vine/android/recorder/VideoData;->data:[B

    iput-object v0, p0, Lco/vine/android/recorder/VideoData;->data:[B

    .line 50
    iget v0, p1, Lco/vine/android/recorder/VideoData;->size:I

    iput v0, p0, Lco/vine/android/recorder/VideoData;->size:I

    .line 51
    iget v0, p1, Lco/vine/android/recorder/VideoData;->start:I

    iput v0, p0, Lco/vine/android/recorder/VideoData;->start:I

    .line 52
    return-void
.end method


# virtual methods
.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 4
    .param p1, "stream"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 68
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    .line 69
    .local v0, "possibleVersion":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    .line 70
    const-wide/16 v2, -0x2

    iput-wide v2, p0, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 75
    :goto_0
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v2

    iput v2, p0, Lco/vine/android/recorder/VideoData;->start:I

    .line 76
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v2

    iput v2, p0, Lco/vine/android/recorder/VideoData;->size:I

    .line 77
    return-void

    .line 72
    :cond_0
    invoke-interface {p1}, Ljava/io/ObjectInput;->readBoolean()Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    .line 73
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/recorder/VideoData;->timestamp:J

    goto :goto_0
.end method

.method public setSegment(Lco/vine/android/recorder/RecordSegment;)V
    .locals 0
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 55
    iput-object p1, p0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    .line 56
    return-void
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 2
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    const-wide/16 v0, -0x2

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 60
    iget-boolean v0, p0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeBoolean(Z)V

    .line 61
    iget-wide v0, p0, Lco/vine/android/recorder/VideoData;->timestamp:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 62
    iget v0, p0, Lco/vine/android/recorder/VideoData;->start:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 63
    iget v0, p0, Lco/vine/android/recorder/VideoData;->size:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 64
    return-void
.end method
