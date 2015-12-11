.class public Lgz;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Ljavax/crypto/Cipher;

.field private final b:Ljavax/crypto/Cipher;

.field private final c:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    :try_start_0
    const-string v0, "AES/CBC/PKCS5Padding"

    invoke-static {v0}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    iput-object v0, p0, Lgz;->a:Ljavax/crypto/Cipher;

    .line 62
    const-string v0, "AES/CBC/PKCS5Padding"

    invoke-static {v0}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    iput-object v0, p0, Lgz;->b:Ljavax/crypto/Cipher;

    .line 66
    iget-object v0, p0, Lgz;->a:Ljavax/crypto/Cipher;

    invoke-virtual {v0}, Ljavax/crypto/Cipher;->getBlockSize()I

    move-result v0

    new-array v0, v0, [B

    .line 67
    const-string v1, "superRandomInitializationVectorByKEV_jDJ4s391!id"

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    iget-object v4, p0, Lgz;->a:Ljavax/crypto/Cipher;

    invoke-virtual {v4}, Ljavax/crypto/Cipher;->getBlockSize()I

    move-result v4

    invoke-static {v1, v2, v0, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 68
    new-instance v1, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v1, v0}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 71
    const-string v0, "EflFpk4jnTwgKXNZvWsk1RbDeOaqz8yZTCk6zdrLtM9fm2a0d5p537JTos6UAqPBSkFNadmxshxxbgEsmujdMTeisJUvxyiA5B4XxeLLgQRCYTUNpHUW39rG"

    invoke-virtual {p0, v0}, Lgz;->a(Ljava/lang/String;)[B

    move-result-object v0

    .line 72
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    const-string v3, "AES/CBC/PKCS5Padding"

    invoke-direct {v2, v0, v3}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 74
    iget-object v0, p0, Lgz;->a:Ljavax/crypto/Cipher;

    const/4 v3, 0x1

    invoke-virtual {v0, v3, v2, v1}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 75
    iget-object v0, p0, Lgz;->b:Ljavax/crypto/Cipher;

    const/4 v3, 0x2

    invoke-virtual {v0, v3, v2, v1}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 78
    const-string v0, "BBY_API_PREF"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lgz;->c:Landroid/content/SharedPreferences;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    .line 86
    return-void

    .line 80
    :catch_0
    move-exception v0

    .line 81
    new-instance v1, Lha;

    invoke-direct {v1, v0}, Lha;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 83
    :catch_1
    move-exception v0

    .line 84
    new-instance v1, Lha;

    invoke-direct {v1, v0}, Lha;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static a(Ljavax/crypto/Cipher;[B)[B
    .locals 2

    .prologue
    .line 159
    :try_start_0
    invoke-virtual {p0, p1}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 161
    :catch_0
    move-exception v0

    .line 162
    new-instance v1, Lha;

    invoke-direct {v1, v0}, Lha;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lgz;->a:Ljavax/crypto/Cipher;

    invoke-virtual {p0, p2, v0}, Lgz;->a(Ljava/lang/String;Ljavax/crypto/Cipher;)Ljava/lang/String;

    move-result-object v0

    .line 131
    iget-object v1, p0, Lgz;->c:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, p1, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 132
    return-void
.end method

.method private d(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 125
    return-object p1
.end method


# virtual methods
.method protected a(Ljava/lang/String;Ljavax/crypto/Cipher;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 137
    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {p2, v0}, Lgz;->a(Ljavax/crypto/Cipher;[B)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 142
    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    .line 143
    return-object v0

    .line 139
    :catch_0
    move-exception v0

    .line 140
    new-instance v1, Lha;

    invoke-direct {v1, v0}, Lha;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 96
    if-nez p2, :cond_0

    .line 97
    iget-object v0, p0, Lgz;->c:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-direct {p0, p1}, Lgz;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 102
    :goto_0
    return-void

    .line 100
    :cond_0
    invoke-direct {p0, p1}, Lgz;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lgz;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Ljava/lang/String;)[B
    .locals 2

    .prologue
    .line 89
    const-string v0, "SHA-256"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 90
    invoke-virtual {v0}, Ljava/security/MessageDigest;->reset()V

    .line 91
    const-string v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v0

    .line 92
    return-object v0
.end method

.method public b(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 113
    iget-object v0, p0, Lgz;->c:Landroid/content/SharedPreferences;

    invoke-direct {p0, p1}, Lgz;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lgz;->c:Landroid/content/SharedPreferences;

    invoke-direct {p0, p1}, Lgz;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 115
    invoke-virtual {p0, v0}, Lgz;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 117
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected c(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 147
    const/4 v0, 0x2

    invoke-static {p1, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 148
    iget-object v1, p0, Lgz;->b:Ljavax/crypto/Cipher;

    invoke-static {v1, v0}, Lgz;->a(Ljavax/crypto/Cipher;[B)[B

    move-result-object v0

    .line 150
    :try_start_0
    new-instance v1, Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-direct {v1, v0, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 152
    :catch_0
    move-exception v0

    .line 153
    new-instance v1, Lha;

    invoke-direct {v1, v0}, Lha;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
