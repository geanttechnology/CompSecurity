.class public Lcom/amazon/mShop/debug/DebugSettings;
.super Ljava/lang/Object;
.source "DebugSettings.java"


# static fields
.field private static final DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

.field private static sDebugEnabled:Z

.field private static sDebugSigned:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 23
    new-instance v0, Ljavax/security/auth/x500/X500Principal;

    const-string/jumbo v1, "CN=Android Debug,O=Android,C=US"

    invoke-direct {v0, v1}, Ljavax/security/auth/x500/X500Principal;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/debug/DebugSettings;->DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

    .line 25
    sput-boolean v2, Lcom/amazon/mShop/debug/DebugSettings;->sDebugEnabled:Z

    .line 26
    sput-boolean v2, Lcom/amazon/mShop/debug/DebugSettings;->sDebugSigned:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isDebugEnabled()Z
    .locals 1

    .prologue
    .line 29
    sget-boolean v0, Lcom/amazon/mShop/debug/DebugSettings;->sDebugEnabled:Z

    return v0
.end method

.method public static setDebugEnabled(Landroid/content/Context;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    const-string/jumbo v6, "true"

    sget v7, Lcom/amazon/mShop/android/lib/R$raw;->debug:I

    invoke-static {p0, v7}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    sput-boolean v6, Lcom/amazon/mShop/debug/DebugSettings;->sDebugEnabled:Z

    .line 42
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x40

    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    .line 44
    .local v3, "pinfo":Landroid/content/pm/PackageInfo;
    iget-object v4, v3, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .line 45
    .local v4, "signatures":[Landroid/content/pm/Signature;
    const-string/jumbo v6, "X.509"

    invoke-static {v6}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v1

    .line 46
    .local v1, "cf":Ljava/security/cert/CertificateFactory;
    if-eqz v4, :cond_0

    .line 47
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v6, v4

    if-ge v2, v6, :cond_0

    .line 48
    new-instance v5, Ljava/io/ByteArrayInputStream;

    aget-object v6, v4, v2

    invoke-virtual {v6}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 50
    .local v5, "stream":Ljava/io/ByteArrayInputStream;
    invoke-virtual {v1, v5}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;

    .line 52
    .local v0, "cert":Ljava/security/cert/X509Certificate;
    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v6

    sget-object v7, Lcom/amazon/mShop/debug/DebugSettings;->DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

    invoke-virtual {v6, v7}, Ljavax/security/auth/x500/X500Principal;->equals(Ljava/lang/Object;)Z

    move-result v6

    sput-boolean v6, Lcom/amazon/mShop/debug/DebugSettings;->sDebugSigned:Z

    .line 53
    sget-boolean v6, Lcom/amazon/mShop/debug/DebugSettings;->sDebugSigned:Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/cert/CertificateException; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v6, :cond_1

    .line 63
    .end local v0    # "cert":Ljava/security/cert/X509Certificate;
    .end local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v2    # "i":I
    .end local v3    # "pinfo":Landroid/content/pm/PackageInfo;
    .end local v4    # "signatures":[Landroid/content/pm/Signature;
    .end local v5    # "stream":Ljava/io/ByteArrayInputStream;
    :cond_0
    :goto_1
    return-void

    .line 47
    .restart local v0    # "cert":Ljava/security/cert/X509Certificate;
    .restart local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .restart local v2    # "i":I
    .restart local v3    # "pinfo":Landroid/content/pm/PackageInfo;
    .restart local v4    # "signatures":[Landroid/content/pm/Signature;
    .restart local v5    # "stream":Ljava/io/ByteArrayInputStream;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 60
    .end local v0    # "cert":Ljava/security/cert/X509Certificate;
    .end local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v2    # "i":I
    .end local v3    # "pinfo":Landroid/content/pm/PackageInfo;
    .end local v4    # "signatures":[Landroid/content/pm/Signature;
    .end local v5    # "stream":Ljava/io/ByteArrayInputStream;
    :catch_0
    move-exception v6

    goto :goto_1

    .line 58
    :catch_1
    move-exception v6

    goto :goto_1
.end method
