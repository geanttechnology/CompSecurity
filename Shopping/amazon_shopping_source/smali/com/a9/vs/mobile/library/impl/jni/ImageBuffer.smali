.class public Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;
.super Ljava/lang/Object;
.source "ImageBuffer.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ImageBuffer__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ImageDef;Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;IIIILcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;)V
    .locals 8
    .param p1, "def"    # Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .param p2, "form"    # Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "step"    # I
    .param p6, "c"    # I
    .param p7, "d"    # Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;

    .prologue
    .line 43
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue()I

    move-result v0

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue()I

    move-result v1

    invoke-static {p7}, Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;)J

    move-result-wide v6

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    invoke-static/range {v0 .. v7}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ImageBuffer__SWIG_1(IIIIIIJ)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;-><init>(JZ)V

    .line 44
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ImageBuffer(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_1
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public fillBuffer([BI)I
    .locals 2
    .param p1, "buffer"    # [B
    .param p2, "size"    # I

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_fillBuffer(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;[BI)I

    move-result v0

    return v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->delete()V

    .line 26
    return-void
.end method

.method public getAllocLen()I
    .locals 2

    .prologue
    .line 112
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_allocLen_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    return v0
.end method

.method public getData()Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;
    .locals 4

    .prologue
    .line 103
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_data_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J

    move-result-wide v0

    .line 104
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;-><init>(JZ)V

    goto :goto_0
.end method

.method public getDefinition()Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_definition_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    move-result-object v0

    return-object v0
.end method

.method public getFormat()Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_format_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    move-result-object v0

    return-object v0
.end method

.method public getHeight()I
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_height_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    return v0
.end method

.method public getNumChannels()I
    .locals 2

    .prologue
    .line 95
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_numChannels_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    return v0
.end method

.method public getWidth()I
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_width_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    return v0
.end method

.method public getWidthStep()I
    .locals 2

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_widthStep_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I

    move-result v0

    return v0
.end method

.method public setAllocLen(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 108
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_allocLen_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 109
    return-void
.end method

.method public setData(Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;)V
    .locals 4
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/SWIGTYPE_p_unsigned_char;)J

    move-result-wide v2

    invoke-static {v0, v1, p0, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_data_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;J)V

    .line 100
    return-void
.end method

.method public setDefinition(Lcom/a9/vs/mobile/library/impl/jni/ImageDef;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_definition_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 52
    return-void
.end method

.method public setFormat(Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_format_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 60
    return-void
.end method

.method public setHeight(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_height_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 76
    return-void
.end method

.method public setNumChannels(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_numChannels_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 92
    return-void
.end method

.method public setWidth(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_width_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 68
    return-void
.end method

.method public setWidthStep(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ImageBuffer_widthStep_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V

    .line 84
    return-void
.end method
