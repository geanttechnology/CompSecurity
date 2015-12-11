.class public Lco/vine/android/recorder/AudioArray;
.super Ljava/lang/Object;
.source "AudioArray.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/AudioArray$AudioArrayType;
    }
.end annotation


# instance fields
.field public final length:I

.field private final mDataByte:[B

.field private final mDataShort:[S

.field private final mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;


# direct methods
.method public constructor <init>(ILco/vine/android/recorder/AudioArray$AudioArrayType;)V
    .locals 3
    .param p1, "length"    # I
    .param p2, "type"    # Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .prologue
    const/4 v2, 0x0

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p2, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .line 86
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_0

    .line 87
    iput-object v2, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    .line 88
    mul-int/lit8 v0, p1, 0x2

    new-array v0, v0, [B

    iput-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    .line 93
    :goto_0
    iput p1, p0, Lco/vine/android/recorder/AudioArray;->length:I

    .line 94
    return-void

    .line 90
    :cond_0
    iput-object v2, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    .line 91
    new-array v0, p1, [S

    iput-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 2
    .param p1, "audioData"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    if-nez p1, :cond_0

    .line 23
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "audioData == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 25
    :cond_0
    instance-of v0, p1, [B

    if-eqz v0, :cond_1

    .line 26
    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    iput-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .line 27
    iput-object v1, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    .line 28
    check-cast p1, [B

    .end local p1    # "audioData":Ljava/lang/Object;
    check-cast p1, [B

    iput-object p1, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    .line 29
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    array-length v0, v0

    iput v0, p0, Lco/vine/android/recorder/AudioArray;->length:I

    .line 36
    :goto_0
    return-void

    .line 31
    .restart local p1    # "audioData":Ljava/lang/Object;
    :cond_1
    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->SHORT:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    iput-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .line 32
    iput-object v1, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    .line 33
    check-cast p1, [S

    .end local p1    # "audioData":Ljava/lang/Object;
    check-cast p1, [S

    iput-object p1, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    .line 34
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    array-length v0, v0

    iput v0, p0, Lco/vine/android/recorder/AudioArray;->length:I

    goto :goto_0
.end method


# virtual methods
.method public getData()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_0

    .line 98
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    .line 100
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    goto :goto_0
.end method

.method public getDataByte()[B
    .locals 2

    .prologue
    .line 117
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_0

    .line 118
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    return-object v0

    .line 120
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The Data type for this is byte"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getDataShort()[S
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->SHORT:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_0

    .line 110
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    return-object v0

    .line 112
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The Data type for this is byte"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getFrom(Ljava/nio/Buffer;)V
    .locals 2
    .param p1, "audioBuffer"    # Ljava/nio/Buffer;

    .prologue
    .line 49
    instance-of v0, p1, Ljava/nio/ShortBuffer;

    if-eqz v0, :cond_0

    .line 50
    check-cast p1, Ljava/nio/ShortBuffer;

    .end local p1    # "audioBuffer":Ljava/nio/Buffer;
    invoke-virtual {p0}, Lco/vine/android/recorder/AudioArray;->getDataShort()[S

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/nio/ShortBuffer;->get([S)Ljava/nio/ShortBuffer;

    .line 58
    :goto_0
    return-void

    .line 52
    .restart local p1    # "audioBuffer":Ljava/nio/Buffer;
    :cond_0
    instance-of v0, p1, Ljava/nio/ByteBuffer;

    if-eqz v0, :cond_1

    .line 53
    check-cast p1, Ljava/nio/ByteBuffer;

    .end local p1    # "audioBuffer":Ljava/nio/Buffer;
    invoke-virtual {p0}, Lco/vine/android/recorder/AudioArray;->getDataByte()[B

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    goto :goto_0

    .line 55
    .restart local p1    # "audioBuffer":Ljava/nio/Buffer;
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid buffer type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getType()Lco/vine/android/recorder/AudioArray$AudioArrayType;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    return-object v0
.end method

.method public putInto(Lco/vine/android/recorder/AudioArray;II)V
    .locals 3
    .param p1, "dest"    # Lco/vine/android/recorder/AudioArray;
    .param p2, "offset"    # I
    .param p3, "count"    # I

    .prologue
    const/4 v2, 0x0

    .line 69
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    iget-object v1, p1, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-eq v0, v1, :cond_0

    .line 70
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Incompatible types."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_1

    .line 73
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    invoke-static {v0, v2, p3}, Ljava/nio/ByteBuffer;->wrap([BII)Ljava/nio/ByteBuffer;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    invoke-virtual {v0, v1, p2, p3}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 77
    :goto_0
    return-void

    .line 75
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    invoke-static {v0, v2, p3}, Ljava/nio/ShortBuffer;->wrap([SII)Ljava/nio/ShortBuffer;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    invoke-virtual {v0, v1, p2, p3}, Ljava/nio/ShortBuffer;->get([SII)Ljava/nio/ShortBuffer;

    goto :goto_0
.end method

.method public putInto(Ljava/nio/Buffer;II)V
    .locals 1
    .param p1, "audioBuffer"    # Ljava/nio/Buffer;
    .param p2, "start"    # I
    .param p3, "size"    # I

    .prologue
    .line 39
    instance-of v0, p1, Ljava/nio/ShortBuffer;

    if-eqz v0, :cond_1

    .line 40
    check-cast p1, Ljava/nio/ShortBuffer;

    .end local p1    # "audioBuffer":Ljava/nio/Buffer;
    invoke-virtual {p0}, Lco/vine/android/recorder/AudioArray;->getDataShort()[S

    move-result-object v0

    invoke-virtual {p1, v0, p2, p3}, Ljava/nio/ShortBuffer;->put([SII)Ljava/nio/ShortBuffer;

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 42
    .restart local p1    # "audioBuffer":Ljava/nio/Buffer;
    :cond_1
    instance-of v0, p1, Ljava/nio/ByteBuffer;

    if-eqz v0, :cond_0

    .line 43
    check-cast p1, Ljava/nio/ByteBuffer;

    .end local p1    # "audioBuffer":Ljava/nio/Buffer;
    invoke-virtual {p0}, Lco/vine/android/recorder/AudioArray;->getDataByte()[B

    move-result-object v0

    invoke-virtual {p1, v0, p2, p3}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    goto :goto_0
.end method

.method public readFrom(Landroid/media/AudioRecord;I)I
    .locals 3
    .param p1, "audioRecord"    # Landroid/media/AudioRecord;
    .param p2, "length"    # I

    .prologue
    const/4 v2, 0x0

    .line 61
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mType:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    sget-object v1, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne v0, v1, :cond_0

    .line 62
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataByte:[B

    invoke-virtual {p1, v0, v2, p2}, Landroid/media/AudioRecord;->read([BII)I

    move-result v0

    .line 64
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/AudioArray;->mDataShort:[S

    invoke-virtual {p1, v0, v2, p2}, Landroid/media/AudioRecord;->read([SII)I

    move-result v0

    goto :goto_0
.end method
