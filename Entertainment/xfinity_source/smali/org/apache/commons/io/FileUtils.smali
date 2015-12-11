.class public Lorg/apache/commons/io/FileUtils;
.super Ljava/lang/Object;
.source "FileUtils.java"


# static fields
.field public static final EMPTY_FILE_ARRAY:[Ljava/io/File;

.field public static final ONE_YB:Ljava/math/BigInteger;

.field public static final ONE_ZB:Ljava/math/BigInteger;

.field private static final UTF8:Ljava/nio/charset/Charset;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const-wide/high16 v2, 0x1000000000000000L

    .line 131
    const-wide/16 v0, 0x400

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/io/FileUtils;->ONE_ZB:Ljava/math/BigInteger;

    .line 136
    sget-object v0, Lorg/apache/commons/io/FileUtils;->ONE_ZB:Ljava/math/BigInteger;

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/io/FileUtils;->ONE_YB:Ljava/math/BigInteger;

    .line 141
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/io/File;

    sput-object v0, Lorg/apache/commons/io/FileUtils;->EMPTY_FILE_ARRAY:[Ljava/io/File;

    .line 146
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/io/FileUtils;->UTF8:Ljava/nio/charset/Charset;

    return-void
.end method

.method public static cleanDirectory(Ljava/io/File;)V
    .locals 11
    .param p0, "directory"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1381
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_0

    .line 1382
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " does not exist"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1383
    .local v7, "message":Ljava/lang/String;
    new-instance v8, Ljava/lang/IllegalArgumentException;

    invoke-direct {v8, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1386
    .end local v7    # "message":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v8

    if-nez v8, :cond_1

    .line 1387
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " is not a directory"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1388
    .restart local v7    # "message":Ljava/lang/String;
    new-instance v8, Ljava/lang/IllegalArgumentException;

    invoke-direct {v8, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1391
    .end local v7    # "message":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v3

    .line 1392
    .local v3, "files":[Ljava/io/File;
    if-nez v3, :cond_2

    .line 1393
    new-instance v8, Ljava/io/IOException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Failed to list contents of "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1396
    :cond_2
    const/4 v1, 0x0

    .line 1397
    .local v1, "exception":Ljava/io/IOException;
    move-object v0, v3

    .local v0, "arr$":[Ljava/io/File;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v6, :cond_3

    aget-object v2, v0, v4

    .line 1399
    .local v2, "file":Ljava/io/File;
    :try_start_0
    invoke-static {v2}, Lorg/apache/commons/io/FileUtils;->forceDelete(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1397
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1400
    :catch_0
    move-exception v5

    .line 1401
    .local v5, "ioe":Ljava/io/IOException;
    move-object v1, v5

    goto :goto_1

    .line 1405
    .end local v2    # "file":Ljava/io/File;
    .end local v5    # "ioe":Ljava/io/IOException;
    :cond_3
    if-eqz v1, :cond_4

    .line 1406
    throw v1

    .line 1408
    :cond_4
    return-void
.end method

.method public static copyFile(Ljava/io/File;Ljava/io/File;)V
    .locals 1
    .param p0, "srcFile"    # Ljava/io/File;
    .param p1, "destFile"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 835
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;Z)V

    .line 836
    return-void
.end method

.method public static copyFile(Ljava/io/File;Ljava/io/File;Z)V
    .locals 4
    .param p0, "srcFile"    # Ljava/io/File;
    .param p1, "destFile"    # Ljava/io/File;
    .param p2, "preserveFileDate"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 864
    if-nez p0, :cond_0

    .line 865
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "Source must not be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 867
    :cond_0
    if-nez p1, :cond_1

    .line 868
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "Destination must not be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 870
    :cond_1
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2

    .line 871
    new-instance v1, Ljava/io/FileNotFoundException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Source \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 873
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 874
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Source \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' exists but is a directory"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 876
    :cond_3
    invoke-virtual {p0}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 877
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Source \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' and destination \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' are the same"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 879
    :cond_4
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    .line 880
    .local v0, "parentFile":Ljava/io/File;
    if-eqz v0, :cond_5

    .line 881
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    if-nez v1, :cond_5

    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-nez v1, :cond_5

    .line 882
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Destination \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' directory cannot be created"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 885
    :cond_5
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-virtual {p1}, Ljava/io/File;->canWrite()Z

    move-result v1

    if-nez v1, :cond_6

    .line 886
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Destination \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' exists but is read-only"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 888
    :cond_6
    invoke-static {p0, p1, p2}, Lorg/apache/commons/io/FileUtils;->doCopyFile(Ljava/io/File;Ljava/io/File;Z)V

    .line 889
    return-void
.end method

.method public static deleteDirectory(Ljava/io/File;)V
    .locals 3
    .param p0, "directory"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1326
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1339
    :cond_0
    return-void

    .line 1330
    :cond_1
    invoke-static {p0}, Lorg/apache/commons/io/FileUtils;->isSymlink(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 1331
    invoke-static {p0}, Lorg/apache/commons/io/FileUtils;->cleanDirectory(Ljava/io/File;)V

    .line 1334
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1335
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unable to delete directory "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1337
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static doCopyFile(Ljava/io/File;Ljava/io/File;Z)V
    .locals 18
    .param p0, "srcFile"    # Ljava/io/File;
    .param p1, "destFile"    # Ljava/io/File;
    .param p2, "preserveFileDate"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 926
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->exists()Z

    move-result v14

    if-eqz v14, :cond_0

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->isDirectory()Z

    move-result v14

    if-eqz v14, :cond_0

    .line 927
    new-instance v14, Ljava/io/IOException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Destination \'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\' exists but is a directory"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 930
    :cond_0
    const/4 v8, 0x0

    .line 931
    .local v8, "fis":Ljava/io/FileInputStream;
    const/4 v10, 0x0

    .line 932
    .local v10, "fos":Ljava/io/FileOutputStream;
    const/4 v3, 0x0

    .line 933
    .local v3, "input":Ljava/nio/channels/FileChannel;
    const/4 v2, 0x0

    .line 935
    .local v2, "output":Ljava/nio/channels/FileChannel;
    :try_start_0
    new-instance v9, Ljava/io/FileInputStream;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 936
    .end local v8    # "fis":Ljava/io/FileInputStream;
    .local v9, "fis":Ljava/io/FileInputStream;
    :try_start_1
    new-instance v11, Ljava/io/FileOutputStream;

    move-object/from16 v0, p1

    invoke-direct {v11, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 937
    .end local v10    # "fos":Ljava/io/FileOutputStream;
    .local v11, "fos":Ljava/io/FileOutputStream;
    :try_start_2
    invoke-virtual {v9}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v3

    .line 938
    invoke-virtual {v11}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v2

    .line 939
    invoke-virtual {v3}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v12

    .line 940
    .local v12, "size":J
    const-wide/16 v4, 0x0

    .line 941
    .local v4, "pos":J
    const-wide/16 v6, 0x0

    .line 942
    .local v6, "count":J
    :goto_0
    cmp-long v14, v4, v12

    if-gez v14, :cond_2

    .line 943
    sub-long v14, v12, v4

    const-wide/32 v16, 0x1e00000

    cmp-long v14, v14, v16

    if-lez v14, :cond_1

    const-wide/32 v6, 0x1e00000

    .line 944
    :goto_1
    invoke-virtual/range {v2 .. v7}, Ljava/nio/channels/FileChannel;->transferFrom(Ljava/nio/channels/ReadableByteChannel;JJ)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-wide v14

    add-long/2addr v4, v14

    goto :goto_0

    .line 943
    :cond_1
    sub-long v6, v12, v4

    goto :goto_1

    .line 947
    :cond_2
    invoke-static {v2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 948
    invoke-static {v11}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 949
    invoke-static {v3}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 950
    invoke-static {v9}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 953
    invoke-virtual/range {p0 .. p0}, Ljava/io/File;->length()J

    move-result-wide v14

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v16

    cmp-long v14, v14, v16

    if-eqz v14, :cond_3

    .line 954
    new-instance v14, Ljava/io/IOException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Failed to copy full contents from \'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\' to \'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 947
    .end local v4    # "pos":J
    .end local v6    # "count":J
    .end local v9    # "fis":Ljava/io/FileInputStream;
    .end local v11    # "fos":Ljava/io/FileOutputStream;
    .end local v12    # "size":J
    .restart local v8    # "fis":Ljava/io/FileInputStream;
    .restart local v10    # "fos":Ljava/io/FileOutputStream;
    :catchall_0
    move-exception v14

    :goto_2
    invoke-static {v2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 948
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 949
    invoke-static {v3}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 950
    invoke-static {v8}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    throw v14

    .line 957
    .end local v8    # "fis":Ljava/io/FileInputStream;
    .end local v10    # "fos":Ljava/io/FileOutputStream;
    .restart local v4    # "pos":J
    .restart local v6    # "count":J
    .restart local v9    # "fis":Ljava/io/FileInputStream;
    .restart local v11    # "fos":Ljava/io/FileOutputStream;
    .restart local v12    # "size":J
    :cond_3
    if-eqz p2, :cond_4

    .line 958
    invoke-virtual/range {p0 .. p0}, Ljava/io/File;->lastModified()J

    move-result-wide v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v14, v15}, Ljava/io/File;->setLastModified(J)Z

    .line 960
    :cond_4
    return-void

    .line 947
    .end local v4    # "pos":J
    .end local v6    # "count":J
    .end local v11    # "fos":Ljava/io/FileOutputStream;
    .end local v12    # "size":J
    .restart local v10    # "fos":Ljava/io/FileOutputStream;
    :catchall_1
    move-exception v14

    move-object v8, v9

    .end local v9    # "fis":Ljava/io/FileInputStream;
    .restart local v8    # "fis":Ljava/io/FileInputStream;
    goto :goto_2

    .end local v8    # "fis":Ljava/io/FileInputStream;
    .end local v10    # "fos":Ljava/io/FileOutputStream;
    .restart local v9    # "fis":Ljava/io/FileInputStream;
    .restart local v11    # "fos":Ljava/io/FileOutputStream;
    :catchall_2
    move-exception v14

    move-object v10, v11

    .end local v11    # "fos":Ljava/io/FileOutputStream;
    .restart local v10    # "fos":Ljava/io/FileOutputStream;
    move-object v8, v9

    .end local v9    # "fis":Ljava/io/FileInputStream;
    .restart local v8    # "fis":Ljava/io/FileInputStream;
    goto :goto_2
.end method

.method public static forceDelete(Ljava/io/File;)V
    .locals 5
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1909
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1910
    invoke-static {p0}, Lorg/apache/commons/io/FileUtils;->deleteDirectory(Ljava/io/File;)V

    .line 1922
    :cond_0
    return-void

    .line 1912
    :cond_1
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    .line 1913
    .local v0, "filePresent":Z
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1914
    if-nez v0, :cond_2

    .line 1915
    new-instance v2, Ljava/io/FileNotFoundException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "File does not exist: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1917
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unable to delete file: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1919
    .local v1, "message":Ljava/lang/String;
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public static isSymlink(Ljava/io/File;)Z
    .locals 5
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 2471
    if-nez p0, :cond_0

    .line 2472
    new-instance v2, Ljava/lang/NullPointerException;

    const-string v3, "File must not be null"

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 2474
    :cond_0
    invoke-static {}, Lorg/apache/commons/io/FilenameUtils;->isSystemWindows()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 2488
    :cond_1
    :goto_0
    return v2

    .line 2477
    :cond_2
    const/4 v1, 0x0

    .line 2478
    .local v1, "fileInCanonicalDir":Ljava/io/File;
    invoke-virtual {p0}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_3

    .line 2479
    move-object v1, p0

    .line 2485
    :goto_1
    invoke-virtual {v1}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v1}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 2488
    const/4 v2, 0x1

    goto :goto_0

    .line 2481
    :cond_3
    invoke-virtual {p0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    move-result-object v0

    .line 2482
    .local v0, "canonicalDir":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    .end local v1    # "fileInCanonicalDir":Ljava/io/File;
    invoke-virtual {p0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v0, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v1    # "fileInCanonicalDir":Ljava/io/File;
    goto :goto_1
.end method
