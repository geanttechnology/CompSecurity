.class public final Lcom/amazon/googlefixes/PRNGFixes;
.super Ljava/lang/Object;
.source "PRNGFixes.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandom;,
        Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider;
    }
.end annotation


# static fields
.field private static final BUILD_FINGERPRINT_AND_DEVICE_SERIAL:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/googlefixes/PRNGFixes;->getBuildFingerprintAndDeviceSerial()[B

    move-result-object v0

    sput-object v0, Lcom/amazon/googlefixes/PRNGFixes;->BUILD_FINGERPRINT_AND_DEVICE_SERIAL:[B

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()[B
    .locals 1

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/googlefixes/PRNGFixes;->generateSeed()[B

    move-result-object v0

    return-object v0
.end method

.method private static generateSeed()[B
    .locals 5

    .prologue
    .line 315
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 316
    .local v1, "seedBuffer":Ljava/io/ByteArrayOutputStream;
    new-instance v2, Ljava/io/DataOutputStream;

    invoke-direct {v2, v1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 318
    .local v2, "seedBufferOut":Ljava/io/DataOutputStream;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/io/DataOutputStream;->writeLong(J)V

    .line 319
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/io/DataOutputStream;->writeLong(J)V

    .line 320
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 321
    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 322
    sget-object v3, Lcom/amazon/googlefixes/PRNGFixes;->BUILD_FINGERPRINT_AND_DEVICE_SERIAL:[B

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->write([B)V

    .line 323
    invoke-virtual {v2}, Ljava/io/DataOutputStream;->close()V

    .line 324
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    return-object v3

    .line 325
    .end local v2    # "seedBufferOut":Ljava/io/DataOutputStream;
    :catch_0
    move-exception v0

    .line 326
    .local v0, "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/SecurityException;

    const-string/jumbo v4, "Failed to generate seed"

    invoke-direct {v3, v4, v0}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method private static getBuildFingerprintAndDeviceSerial()[B
    .locals 6

    .prologue
    .line 351
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 352
    .local v2, "result":Ljava/lang/StringBuilder;
    sget-object v1, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    .line 353
    .local v1, "fingerprint":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 354
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 356
    :cond_0
    invoke-static {}, Lcom/amazon/googlefixes/PRNGFixes;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v3

    .line 357
    .local v3, "serial":Ljava/lang/String;
    if-eqz v3, :cond_1

    .line 358
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 361
    :cond_1
    :try_start_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "UTF-8"

    invoke-virtual {v4, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    return-object v4

    .line 362
    :catch_0
    move-exception v0

    .line 363
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v4, Ljava/lang/RuntimeException;

    const-string/jumbo v5, "UTF-8 encoding not supported"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private static getDeviceSerialNumber()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 339
    :try_start_0
    const-class v1, Landroid/os/Build;

    const-string/jumbo v3, "SERIAL"

    invoke-virtual {v1, v3}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 341
    .local v0, "ignored":Ljava/lang/Exception;
    :goto_0
    return-object v1

    .line 340
    .end local v0    # "ignored":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .restart local v0    # "ignored":Ljava/lang/Exception;
    move-object v1, v2

    .line 341
    goto :goto_0
.end method
