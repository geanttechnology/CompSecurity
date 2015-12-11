.class abstract Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;
.super Ljava/lang/Object;
.source "AbstractDetArtifactProcessor.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/ArtifactProcessor;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mBodyWriter:Lcom/amazon/device/utils/DetUtil$BodyWriter;

.field protected final mBuffer:[C

.field protected final mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

.field protected final mDetUtil:Lcom/amazon/device/utils/DetUtil;

.field protected final mDeviceSerialNumber:Ljava/lang/String;

.field protected final mDeviceType:Ljava/lang/String;

.field protected final mExtraInfo:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "AbstractDetArtifactProcessor"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DetUtil;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 3
    .param p1, "detUtil"    # Lcom/amazon/device/utils/DetUtil;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "deviceSerialNumber"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/utils/DetUtil;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 53
    .local p4, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/16 v1, 0x6400

    new-array v1, v1, [C

    iput-object v1, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mBuffer:[C

    .line 55
    if-nez p1, :cond_0

    .line 56
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "DetUtil must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 58
    :cond_0
    if-nez p2, :cond_1

    .line 59
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "DeviceType must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 61
    :cond_1
    if-nez p3, :cond_2

    .line 62
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "DeviceSerialNumber must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 64
    :cond_2
    iput-object p1, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    .line 65
    iput-object p2, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDeviceType:Ljava/lang/String;

    .line 66
    iput-object p3, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDeviceSerialNumber:Ljava/lang/String;

    .line 67
    iput-object p4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mExtraInfo:Ljava/util/Map;

    .line 81
    new-instance v1, Lcom/amazon/device/utils/DetUtil$PlainBodyWriter;

    invoke-direct {v1}, Lcom/amazon/device/utils/DetUtil$PlainBodyWriter;-><init>()V

    iput-object v1, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mBodyWriter:Lcom/amazon/device/utils/DetUtil$BodyWriter;

    .line 84
    new-instance v1, Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    invoke-direct {v1}, Lcom/amazon/device/utils/DetUtil$HeaderWriter;-><init>()V

    iput-object v1, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    .line 87
    sget-object v0, Ljava/util/Collections;->EMPTY_MAP:Ljava/util/Map;

    .line 88
    .local v0, "defaultHeaderProcessors":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;>;"
    new-instance v1, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;

    iget-object v2, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    invoke-direct {v1, v0, v2}, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;-><init>(Ljava/util/Map;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V

    iput-object v1, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 89
    return-void
.end method


# virtual methods
.method protected addHeaders(Lcom/amazon/device/crashmanager/Artifact;Ljava/io/BufferedReader;Ljava/io/Writer;)V
    .locals 7
    .param p1, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;
    .param p2, "reader"    # Ljava/io/BufferedReader;
    .param p3, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 170
    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v0

    .line 171
    .local v0, "crashTimeMillis":J
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    invoke-virtual {v4, v0, v1}, Lcom/amazon/device/utils/DetUtil;->formatDate(J)Ljava/lang/String;

    move-result-object v3

    .line 172
    .local v3, "startTime":Ljava/lang/String;
    move-object v2, v3

    .line 174
    .local v2, "endTime":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v5, "StartTime"

    invoke-interface {v4, v5, v3, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 175
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v5, "EndTime"

    invoke-interface {v4, v5, v2, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 176
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v5, "CrashTimeUTC"

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 177
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v5, "CrashType"

    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 178
    iget-object v4, p0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v5, "OsBuildNumber"

    sget-object v6, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-interface {v4, v5, v6, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 180
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->addSpecificHeaders(Lcom/amazon/device/crashmanager/Artifact;Ljava/io/BufferedReader;Ljava/io/Writer;)V

    .line 181
    return-void
.end method

.method protected abstract addSpecificHeaders(Lcom/amazon/device/crashmanager/Artifact;Ljava/io/BufferedReader;Ljava/io/Writer;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method public processArtifact(Lcom/amazon/device/crashmanager/Artifact;)[B
    .locals 19
    .param p1, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 103
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/crashmanager/Artifact;->getInputStream()Ljava/io/InputStream;

    move-result-object v14

    .line 104
    .local v14, "inputStream":Ljava/io/InputStream;
    invoke-virtual {v14}, Ljava/io/InputStream;->available()I

    move-result v10

    .line 108
    .local v10, "bytesAvailableOnStream":I
    new-instance v17, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-direct {v3, v14}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    const/16 v4, 0x6400

    move-object/from16 v0, v17

    invoke-direct {v0, v3, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 112
    .local v17, "reader":Ljava/io/BufferedReader;
    new-instance v8, Ljava/io/StringWriter;

    add-int/lit16 v3, v10, 0x1400

    invoke-direct {v8, v3}, Ljava/io/StringWriter;-><init>(I)V

    .line 117
    .local v8, "writer":Ljava/io/StringWriter;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDeviceType:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDeviceSerialNumber:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mExtraInfo:Ljava/util/Map;

    invoke-virtual/range {v3 .. v8}, Lcom/amazon/device/utils/DetUtil;->addMetadataSectionHeader(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/io/Writer;)V

    .line 120
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2, v8}, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->addHeaders(Lcom/amazon/device/crashmanager/Artifact;Ljava/io/BufferedReader;Ljava/io/Writer;)V

    .line 123
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    invoke-virtual {v3, v8}, Lcom/amazon/device/utils/DetUtil;->addEventsSectionHeader(Ljava/io/Writer;)V

    .line 126
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mBodyWriter:Lcom/amazon/device/utils/DetUtil$BodyWriter;

    move-object/from16 v0, v17

    invoke-interface {v3, v0, v8}, Lcom/amazon/device/utils/DetUtil$BodyWriter;->write(Ljava/io/BufferedReader;Ljava/io/Writer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    :try_start_1
    invoke-virtual/range {v17 .. v17}, Ljava/io/BufferedReader;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 136
    :goto_0
    invoke-virtual {v8}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v16

    .line 137
    .local v16, "messageBytes":[B
    const/4 v8, 0x0

    .line 140
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Lcom/amazon/device/utils/DetUtil;->compressMessage([B)[B

    move-result-object v11

    .line 141
    .local v11, "compressedMessageBytes":[B
    const/16 v16, 0x0

    .line 146
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    new-instance v4, Ljava/lang/Long;

    array-length v5, v11

    int-to-long v5, v5

    invoke-direct {v4, v5, v6}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v3, v4}, Lcom/amazon/device/utils/DetUtil;->createDetMfbsHeader(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v13

    .line 147
    .local v13, "detMfbsHeaderString":Ljava/lang/String;
    invoke-virtual {v13}, Ljava/lang/String;->getBytes()[B

    move-result-object v12

    .line 148
    .local v12, "detMfbsHeaderBytes":[B
    const/4 v13, 0x0

    .line 150
    array-length v3, v12

    array-length v4, v11

    add-int/2addr v3, v4

    invoke-static {v3}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v9

    .line 151
    .local v9, "byteBuffer":Ljava/nio/ByteBuffer;
    invoke-virtual {v9, v12}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 152
    const/4 v12, 0x0

    .line 153
    invoke-virtual {v9, v11}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 154
    const/4 v11, 0x0

    .line 156
    invoke-virtual {v9}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v3

    return-object v3

    .line 130
    .end local v9    # "byteBuffer":Ljava/nio/ByteBuffer;
    .end local v11    # "compressedMessageBytes":[B
    .end local v12    # "detMfbsHeaderBytes":[B
    .end local v13    # "detMfbsHeaderString":Ljava/lang/String;
    .end local v16    # "messageBytes":[B
    :catch_0
    move-exception v15

    .line 131
    .local v15, "ioe":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "constructCrashUploadMessage"

    const-string/jumbo v5, "Failed to close crash entry input stream."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v15, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 128
    .end local v15    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    .line 129
    :try_start_2
    invoke-virtual/range {v17 .. v17}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 132
    :goto_1
    throw v3

    .line 130
    :catch_1
    move-exception v15

    .line 131
    .restart local v15    # "ioe":Ljava/io/IOException;
    sget-object v4, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "constructCrashUploadMessage"

    const-string/jumbo v6, "Failed to close crash entry input stream."

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/16 v18, 0x0

    aput-object v15, v7, v18

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method
