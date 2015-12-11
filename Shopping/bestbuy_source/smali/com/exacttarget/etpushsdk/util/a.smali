.class public Lcom/exacttarget/etpushsdk/util/a;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private static b:Ljava/lang/String;

.field private static c:Landroid/content/SharedPreferences;

.field private static d:Lcom/exacttarget/etpushsdk/util/a$c;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 81
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 85
    sput-object v2, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    .line 86
    sput-object v2, Lcom/exacttarget/etpushsdk/util/a;->c:Landroid/content/SharedPreferences;

    .line 87
    sput-object v2, Lcom/exacttarget/etpushsdk/util/a;->d:Lcom/exacttarget/etpushsdk/util/a$c;

    return-void
.end method

.method private static declared-synchronized a(Landroid/content/Context;)Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 163
    const-class v1, Lcom/exacttarget/etpushsdk/util/a;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->c:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 164
    const-string v0, "ETPush"

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->c:Landroid/content/SharedPreferences;

    .line 166
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->c:Landroid/content/SharedPreferences;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 163
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static a(Ljava/lang/String;Lcom/exacttarget/etpushsdk/util/a$c;)Lcom/exacttarget/etpushsdk/util/a$a;
    .locals 1

    .prologue
    .line 345
    const-string v0, "UTF-8"

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/a;->a(Ljava/lang/String;Lcom/exacttarget/etpushsdk/util/a$c;Ljava/lang/String;)Lcom/exacttarget/etpushsdk/util/a$a;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;Lcom/exacttarget/etpushsdk/util/a$c;Ljava/lang/String;)Lcom/exacttarget/etpushsdk/util/a$a;
    .locals 1

    .prologue
    .line 360
    invoke-virtual {p0, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {v0, p1}, Lcom/exacttarget/etpushsdk/util/a;->a([BLcom/exacttarget/etpushsdk/util/a$c;)Lcom/exacttarget/etpushsdk/util/a$a;

    move-result-object v0

    return-object v0
.end method

.method private static a([BLcom/exacttarget/etpushsdk/util/a$c;)Lcom/exacttarget/etpushsdk/util/a$a;
    .locals 5

    .prologue
    .line 374
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a;->b()[B

    move-result-object v0

    .line 375
    const-string v1, "AES/CBC/PKCS5Padding"

    invoke-static {v1}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    .line 376
    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/a$c;->a()Ljavax/crypto/SecretKey;

    move-result-object v3

    new-instance v4, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v4, v0}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    invoke-virtual {v1, v2, v3, v4}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 382
    invoke-virtual {v1}, Ljavax/crypto/Cipher;->getIV()[B

    move-result-object v0

    .line 383
    invoke-virtual {v1, p0}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v1

    .line 384
    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a$a;->a([B[B)[B

    move-result-object v2

    .line 386
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/a$c;->b()Ljavax/crypto/SecretKey;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/a;->a([BLjavax/crypto/SecretKey;)[B

    move-result-object v2

    .line 387
    new-instance v3, Lcom/exacttarget/etpushsdk/util/a$a;

    invoke-direct {v3, v1, v0, v2}, Lcom/exacttarget/etpushsdk/util/a$a;-><init>([B[B[B)V

    return-object v3
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;)Lcom/exacttarget/etpushsdk/util/a$c;
    .locals 1

    .prologue
    .line 284
    const/4 v0, 0x2

    invoke-static {p1, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    invoke-static {p0, v0}, Lcom/exacttarget/etpushsdk/util/a;->a(Ljava/lang/String;[B)Lcom/exacttarget/etpushsdk/util/a$c;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;[B)Lcom/exacttarget/etpushsdk/util/a$c;
    .locals 5

    .prologue
    const/16 v4, 0x10

    .line 254
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a;->c()V

    .line 256
    new-instance v0, Ljavax/crypto/spec/PBEKeySpec;

    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    const/16 v2, 0x2710

    const/16 v3, 0x180

    invoke-direct {v0, v1, p1, v2, v3}, Ljavax/crypto/spec/PBEKeySpec;-><init>([C[BII)V

    .line 258
    const-string v1, "PBKDF2WithHmacSHA1"

    invoke-static {v1}, Ljavax/crypto/SecretKeyFactory;->getInstance(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;

    move-result-object v1

    .line 260
    invoke-virtual {v1, v0}, Ljavax/crypto/SecretKeyFactory;->generateSecret(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;

    move-result-object v0

    invoke-interface {v0}, Ljavax/crypto/SecretKey;->getEncoded()[B

    move-result-object v0

    .line 263
    const/4 v1, 0x0

    invoke-static {v0, v1, v4}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v1

    .line 264
    const/16 v2, 0x30

    invoke-static {v0, v4, v2}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    .line 267
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    const-string v3, "AES"

    invoke-direct {v2, v1, v3}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 270
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    const-string v3, "HmacSHA256"

    invoke-direct {v1, v0, v3}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 272
    new-instance v0, Lcom/exacttarget/etpushsdk/util/a$c;

    invoke-direct {v0, v2, v1}, Lcom/exacttarget/etpushsdk/util/a$c;-><init>(Ljavax/crypto/SecretKey;Ljavax/crypto/SecretKey;)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    if-nez p1, :cond_1

    .line 119
    const/4 p1, 0x0

    .line 125
    :cond_0
    :goto_0
    return-object p1

    .line 121
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->e()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 124
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;)Lcom/exacttarget/etpushsdk/util/a$c;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/util/a;->a(Ljava/lang/String;Lcom/exacttarget/etpushsdk/util/a$c;)Lcom/exacttarget/etpushsdk/util/a$a;

    move-result-object v0

    .line 125
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/a$a;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method private static declared-synchronized a(Landroid/content/SharedPreferences;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 139
    const-class v1, Lcom/exacttarget/etpushsdk/util/a;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 140
    const-string v0, "install_date_enc"

    const/4 v2, 0x0

    invoke-interface {p0, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    .line 141
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 142
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a;->a()[B

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/a;->a([B)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    .line 143
    invoke-interface {p0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "install_date_enc"

    sget-object v3, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 146
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "29200FA5-DF79-4C3F-BC0F-E2FF3CE6199A"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 149
    :try_start_1
    invoke-static {}, Ljava/text/NumberFormat;->getInstance()Ljava/text/NumberFormat;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/text/NumberFormat;->parse(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 154
    :goto_0
    :try_start_2
    sget-object v2, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v2, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;

    .line 159
    :cond_1
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->b:Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit v1

    return-object v0

    .line 150
    :catch_0
    move-exception v0

    .line 151
    const/16 v0, 0xc8

    goto :goto_0

    .line 139
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static a(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 438
    const-string v0, "UTF-8"

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/a;->a(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static a(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 423
    new-instance v0, Ljava/lang/String;

    invoke-static {p0, p1}, Lcom/exacttarget/etpushsdk/util/a;->b(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;)[B

    move-result-object v1

    invoke-direct {v0, v1, p2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    return-object v0
.end method

.method private static a([B)Ljava/lang/String;
    .locals 1

    .prologue
    .line 304
    const/4 v0, 0x2

    invoke-static {p0, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 90
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 93
    :try_start_0
    invoke-static {p0, p2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p2

    .line 97
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 98
    return-void

    .line 94
    :catch_0
    move-exception v1

    .line 95
    const-string v2, "~!ua"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static a([B[B)Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 494
    array-length v0, p0

    array-length v2, p1

    if-eq v0, v2, :cond_1

    .line 501
    :cond_0
    :goto_0
    return v1

    :cond_1
    move v0, v1

    move v2, v1

    .line 498
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_2

    .line 499
    aget-byte v3, p0, v0

    aget-byte v4, p1, v0

    xor-int/2addr v3, v4

    or-int/2addr v2, v3

    .line 498
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 501
    :cond_2
    if-nez v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static a()[B
    .locals 1

    .prologue
    .line 293
    const/16 v0, 0x80

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/a;->a(I)[B

    move-result-object v0

    return-object v0
.end method

.method private static a(I)[B
    .locals 2

    .prologue
    .line 319
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a;->c()V

    .line 320
    const-string v0, "SHA1PRNG"

    invoke-static {v0}, Ljava/security/SecureRandom;->getInstance(Ljava/lang/String;)Ljava/security/SecureRandom;

    move-result-object v0

    .line 321
    new-array v1, p0, [B

    .line 322
    invoke-virtual {v0, v1}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 323
    return-object v1
.end method

.method private static a([BLjavax/crypto/SecretKey;)[B
    .locals 1

    .prologue
    .line 481
    const-string v0, "HmacSHA256"

    invoke-static {v0}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v0

    .line 482
    invoke-virtual {v0, p1}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 483
    invoke-virtual {v0, p0}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v0

    return-object v0
.end method

.method private static declared-synchronized b(Landroid/content/Context;)Lcom/exacttarget/etpushsdk/util/a$c;
    .locals 3

    .prologue
    .line 170
    const-class v1, Lcom/exacttarget/etpushsdk/util/a;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->d:Lcom/exacttarget/etpushsdk/util/a$c;

    if-nez v0, :cond_0

    .line 171
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->e()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/exacttarget/etpushsdk/util/a$c;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a;->d:Lcom/exacttarget/etpushsdk/util/a$c;

    .line 176
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->d:Lcom/exacttarget/etpushsdk/util/a$c;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 170
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    if-nez p1, :cond_1

    .line 130
    const/4 p1, 0x0

    .line 135
    :cond_0
    :goto_0
    return-object p1

    .line 132
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->e()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 135
    new-instance v0, Lcom/exacttarget/etpushsdk/util/a$a;

    invoke-direct {v0, p1}, Lcom/exacttarget/etpushsdk/util/a$a;-><init>(Ljava/lang/String;)V

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;)Lcom/exacttarget/etpushsdk/util/a$c;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a;->a(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 101
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 105
    const/4 v2, 0x0

    :try_start_0
    invoke-interface {v1, p1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 107
    if-eqz v1, :cond_0

    .line 109
    invoke-static {p0, v1}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 114
    :cond_0
    :goto_0
    if-nez v0, :cond_1

    :goto_1
    return-object p2

    .line 111
    :catch_0
    move-exception v1

    .line 112
    const-string v2, "~!ua"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    :cond_1
    move-object p2, v0

    .line 114
    goto :goto_1
.end method

.method private static b()[B
    .locals 1

    .prologue
    .line 315
    const/16 v0, 0x10

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/a;->a(I)[B

    move-result-object v0

    return-object v0
.end method

.method private static b(Lcom/exacttarget/etpushsdk/util/a$a;Lcom/exacttarget/etpushsdk/util/a$c;)[B
    .locals 5

    .prologue
    .line 452
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$a;->b()[B

    move-result-object v0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$a;->a()[B

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a$a;->a([B[B)[B

    move-result-object v0

    .line 453
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/a$c;->b()Ljavax/crypto/SecretKey;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a;->a([BLjavax/crypto/SecretKey;)[B

    move-result-object v0

    .line 454
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$a;->c()[B

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a;->a([B[B)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 455
    const-string v0, "AES/CBC/PKCS5Padding"

    invoke-static {v0}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 456
    const/4 v1, 0x2

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/a$c;->a()Ljavax/crypto/SecretKey;

    move-result-object v2

    new-instance v3, Ljavax/crypto/spec/IvParameterSpec;

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$a;->b()[B

    move-result-object v4

    invoke-direct {v3, v4}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    invoke-virtual {v0, v1, v2, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 458
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$a;->a()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v0

    return-object v0

    .line 460
    :cond_0
    new-instance v0, Ljava/security/GeneralSecurityException;

    const-string v1, "MAC stored in civ does not match computed MAC."

    invoke-direct {v0, v1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static c()V
    .locals 3

    .prologue
    .line 395
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_1

    .line 396
    const-class v1, Lcom/exacttarget/etpushsdk/util/a$b;

    monitor-enter v1

    .line 397
    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 398
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a$b;->a()V

    .line 399
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 401
    :cond_0
    monitor-exit v1

    .line 403
    :cond_1
    return-void

    .line 401
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
