.class public Lcom/amazon/sdk/availability/EncryptionManagerImpl;
.super Ljava/lang/Object;
.source "EncryptionManagerImpl.java"

# interfaces
.implements Lcom/amazon/sdk/availability/EncryptionManager;


# instance fields
.field private final encryptionAlgorithm:Ljava/lang/String;

.field private final key:Ljava/lang/String;

.field private final secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "encryptionAlgorithm"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->encryptionAlgorithm:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->key:Ljava/lang/String;

    .line 49
    :try_start_0
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    const-string/jumbo v2, "UTF-8"

    invoke-virtual {p2, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-direct {v1, v2, p1}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    return-void

    .line 50
    :catch_0
    move-exception v0

    .line 51
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public decrypt([B)Ljava/lang/String;
    .locals 16
    .param p1, "encryptedBlob"    # [B

    .prologue
    .line 79
    const-class v13, Lcom/amazon/sdk/availability/EncryptionManagerImpl;

    const-string/jumbo v14, "decrypt"

    invoke-static {v13, v14}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v8

    .line 81
    .local v8, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    const/4 v1, 0x0

    .line 82
    .local v1, "baos":Ljava/io/ByteArrayInputStream;
    const/4 v10, 0x0

    .line 83
    .local v10, "out":Ljava/io/ByteArrayOutputStream;
    const/4 v6, 0x0

    .line 85
    .local v6, "in":Ljava/util/zip/GZIPInputStream;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->encryptionAlgorithm:Ljava/lang/String;

    invoke-static {v13}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v4

    .line 86
    .local v4, "cipher":Ljavax/crypto/Cipher;
    const/4 v13, 0x2

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v4, v13, v14}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 87
    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v9

    .line 89
    .local v9, "originalBytes":[B
    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-direct {v2, v9}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 90
    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .local v2, "baos":Ljava/io/ByteArrayInputStream;
    :try_start_1
    new-instance v7, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v7, v2}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    .line 91
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .local v7, "in":Ljava/util/zip/GZIPInputStream;
    :try_start_2
    new-instance v11, Ljava/io/ByteArrayOutputStream;

    const/16 v13, 0x400

    invoke-direct {v11, v13}, Ljava/io/ByteArrayOutputStream;-><init>(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    .line 92
    .end local v10    # "out":Ljava/io/ByteArrayOutputStream;
    .local v11, "out":Ljava/io/ByteArrayOutputStream;
    const/4 v12, 0x0

    .line 93
    .local v12, "readBytes":I
    const/16 v13, 0x400

    :try_start_3
    new-array v3, v13, [B

    .line 94
    .local v3, "buffer":[B
    :goto_0
    invoke-virtual {v7, v3}, Ljava/util/zip/GZIPInputStream;->read([B)I

    move-result v12

    if-lez v12, :cond_0

    .line 95
    const/4 v13, 0x0

    invoke-virtual {v11, v3, v13, v12}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_5

    goto :goto_0

    .line 98
    .end local v3    # "buffer":[B
    :catch_0
    move-exception v5

    move-object v6, v7

    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    move-object v10, v11

    .end local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "out":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .line 99
    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v4    # "cipher":Ljavax/crypto/Cipher;
    .end local v9    # "originalBytes":[B
    .end local v12    # "readBytes":I
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .local v5, "e":Ljava/lang/Exception;
    :goto_1
    :try_start_4
    new-instance v13, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v13, v5}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v13
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 101
    .end local v5    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v13

    :goto_2
    :try_start_5
    const-string/jumbo v14, "GZIPInputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 102
    const-string/jumbo v14, "ByteArrayInputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 103
    const-string/jumbo v14, "GZuipOutputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v10, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 105
    const/4 v1, 0x0

    .line 106
    const/4 v6, 0x0

    .line 107
    const/4 v10, 0x0

    throw v13
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 110
    :catchall_1
    move-exception v13

    :goto_3
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v13

    .line 97
    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .end local v10    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v3    # "buffer":[B
    .restart local v4    # "cipher":Ljavax/crypto/Cipher;
    .restart local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v9    # "originalBytes":[B
    .restart local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "readBytes":I
    :cond_0
    :try_start_6
    new-instance v13, Ljava/lang/String;

    invoke-virtual {v11}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v14

    const-string/jumbo v15, "UTF-8"

    invoke-direct {v13, v14, v15}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    .line 101
    :try_start_7
    const-string/jumbo v14, "GZIPInputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 102
    const-string/jumbo v14, "ByteArrayInputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 103
    const-string/jumbo v14, "GZuipOutputStream"

    move-object/from16 v0, p0

    invoke-virtual {v0, v11, v14}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    .line 105
    const/4 v1, 0x0

    .line 106
    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    const/4 v6, 0x0

    .line 107
    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    const/4 v10, 0x0

    .line 110
    .end local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "out":Ljava/io/ByteArrayOutputStream;
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    return-object v13

    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .end local v10    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v11    # "out":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v13

    move-object v6, v7

    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    move-object v10, v11

    .end local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "out":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_3

    .line 101
    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v3    # "buffer":[B
    .end local v12    # "readBytes":I
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    :catchall_3
    move-exception v13

    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_2

    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v7    # "in":Ljava/util/zip/GZIPInputStream;
    :catchall_4
    move-exception v13

    move-object v6, v7

    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_2

    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .end local v10    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "readBytes":I
    :catchall_5
    move-exception v13

    move-object v6, v7

    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    move-object v10, v11

    .end local v11    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "out":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_2

    .line 98
    .end local v4    # "cipher":Ljavax/crypto/Cipher;
    .end local v9    # "originalBytes":[B
    .end local v12    # "readBytes":I
    :catch_1
    move-exception v5

    goto :goto_1

    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "cipher":Ljavax/crypto/Cipher;
    .restart local v9    # "originalBytes":[B
    :catch_2
    move-exception v5

    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_1

    .end local v1    # "baos":Ljava/io/ByteArrayInputStream;
    .end local v6    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v7    # "in":Ljava/util/zip/GZIPInputStream;
    :catch_3
    move-exception v5

    move-object v6, v7

    .end local v7    # "in":Ljava/util/zip/GZIPInputStream;
    .restart local v6    # "in":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .end local v2    # "baos":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayInputStream;
    goto :goto_1
.end method

.method public encrypt(Lorg/json/JSONObject;)[B
    .locals 10
    .param p1, "jobj"    # Lorg/json/JSONObject;

    .prologue
    .line 121
    const-class v8, Lcom/amazon/sdk/availability/EncryptionManagerImpl;

    const-string/jumbo v9, "encrypt"

    invoke-static {v8, v9}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v5

    .line 123
    .local v5, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    const/4 v0, 0x0

    .line 124
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v6, 0x0

    .line 127
    .local v6, "out":Ljava/util/zip/GZIPOutputStream;
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    const/16 v8, 0x400

    invoke-direct {v1, v8}, Ljava/io/ByteArrayOutputStream;-><init>(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 128
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v7, Ljava/util/zip/GZIPOutputStream;

    invoke-direct {v7, v1}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    .line 129
    .end local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    .local v7, "out":Ljava/util/zip/GZIPOutputStream;
    :try_start_2
    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/zip/GZIPOutputStream;->write([B)V

    .line 130
    invoke-virtual {v7}, Ljava/util/zip/GZIPOutputStream;->close()V

    .line 131
    iget-object v8, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->encryptionAlgorithm:Ljava/lang/String;

    invoke-static {v8}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v2

    .line 132
    .local v2, "cipher":Ljavax/crypto/Cipher;
    const/4 v8, 0x1

    iget-object v9, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v2, v8, v9}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 133
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v8

    invoke-virtual {v2, v8}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    move-result-object v4

    .line 138
    .local v4, "encryptedBlob":[B
    :try_start_3
    const-string/jumbo v8, "ByteArrayOutputStream"

    invoke-virtual {p0, v1, v8}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 139
    const-string/jumbo v8, "GZipOutputStream"

    invoke-virtual {p0, v7, v8}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 141
    const/4 v0, 0x0

    .line 142
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v6, 0x0

    .line 145
    .end local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    invoke-static {v5}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    return-object v4

    .line 135
    .end local v2    # "cipher":Ljavax/crypto/Cipher;
    .end local v4    # "encryptedBlob":[B
    :catch_0
    move-exception v3

    .line 136
    .local v3, "e":Ljava/lang/Exception;
    :goto_0
    :try_start_4
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v8, v3}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 138
    .end local v3    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v8

    :goto_1
    :try_start_5
    const-string/jumbo v9, "ByteArrayOutputStream"

    invoke-virtual {p0, v0, v9}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 139
    const-string/jumbo v9, "GZipOutputStream"

    invoke-virtual {p0, v6, v9}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V

    .line 141
    const/4 v0, 0x0

    .line 142
    const/4 v6, 0x0

    throw v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 145
    :catchall_1
    move-exception v8

    :goto_2
    invoke-static {v5}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v8

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "cipher":Ljavax/crypto/Cipher;
    .restart local v4    # "encryptedBlob":[B
    .restart local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    :catchall_2
    move-exception v8

    move-object v6, v7

    .end local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_2

    .line 138
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "cipher":Ljavax/crypto/Cipher;
    .end local v4    # "encryptedBlob":[B
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_3
    move-exception v8

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_1

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    :catchall_4
    move-exception v8

    move-object v6, v7

    .end local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_1

    .line 135
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_1
    move-exception v3

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_0

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    :catch_2
    move-exception v3

    move-object v6, v7

    .end local v7    # "out":Ljava/util/zip/GZIPOutputStream;
    .restart local v6    # "out":Ljava/util/zip/GZIPOutputStream;
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_0
.end method

.method public getEncryptionAlgorithm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->encryptionAlgorithm:Ljava/lang/String;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/sdk/availability/EncryptionManagerImpl;->key:Ljava/lang/String;

    return-object v0
.end method

.method protected safelyClose(Ljava/io/Closeable;Ljava/lang/String;)V
    .locals 3
    .param p1, "closable"    # Ljava/io/Closeable;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 157
    if-eqz p1, :cond_0

    .line 159
    :try_start_0
    invoke-interface {p1}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 160
    :catch_0
    move-exception v0

    .line 161
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Error closing "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
