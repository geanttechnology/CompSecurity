.class final Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;
.super Ljava/lang/Object;
.source "AmazonApprovedCiphers.java"


# static fields
.field private static final ALLOWED_CIPHERS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final APPROVED_CIPHERS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final APPROVED_PROTOCOLS:[Ljava/lang/String;

.field private static final DEPRECATED_CIPHERS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final ENABLED_ON_THIS_PLATFORM:Z


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/16 v7, 0xa

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 26
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v7, :cond_0

    move v1, v2

    :goto_0
    sput-boolean v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->ENABLED_ON_THIS_PLATFORM:Z

    .line 31
    new-array v1, v2, [Ljava/lang/String;

    const-string/jumbo v4, "TLSv1"

    aput-object v4, v1, v3

    sput-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->APPROVED_PROTOCOLS:[Ljava/lang/String;

    .line 36
    new-instance v1, Ljava/util/HashSet;

    const/16 v4, 0x28

    new-array v4, v4, [Ljava/lang/String;

    const-string/jumbo v5, "TLS_RSA_WITH_AES_128_CBC_SHA256"

    aput-object v5, v4, v3

    const-string/jumbo v5, "TLS_RSA_WITH_AES_256_CBC_SHA256"

    aput-object v5, v4, v2

    const-string/jumbo v5, "TLS_RSA_WITH_AES_128_GCM_SHA256"

    aput-object v5, v4, v8

    const-string/jumbo v5, "TLS_RSA_WITH_AES_256_GCM_SHA384"

    aput-object v5, v4, v9

    const/4 v5, 0x4

    const-string/jumbo v6, "TLS_DH_RSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-string/jumbo v6, "TLS_DH_RSA_WITH_AES_256_CBC_SHA256"

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-string/jumbo v6, "TLS_DH_RSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const-string/jumbo v6, "TLS_DH_RSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x8

    const-string/jumbo v6, "TLS_DH_DSS_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x9

    const-string/jumbo v6, "TLS_DH_DSS_WITH_AES_256_CBC_SHA256"

    aput-object v6, v4, v5

    const-string/jumbo v5, "TLS_DH_DSS_WITH_AES_128_GCM_SHA256"

    aput-object v5, v4, v7

    const/16 v5, 0xb

    const-string/jumbo v6, "TLS_DH_DSS_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0xc

    const-string/jumbo v6, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0xd

    const-string/jumbo v6, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0xe

    const-string/jumbo v6, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0xf

    const-string/jumbo v6, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x10

    const-string/jumbo v6, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x11

    const-string/jumbo v6, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x12

    const-string/jumbo v6, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x13

    const-string/jumbo v6, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x14

    const-string/jumbo v6, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x15

    const-string/jumbo v6, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x16

    const-string/jumbo v6, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x17

    const-string/jumbo v6, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x18

    const-string/jumbo v6, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x19

    const-string/jumbo v6, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x1a

    const-string/jumbo v6, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x1b

    const-string/jumbo v6, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x1c

    const-string/jumbo v6, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x1d

    const-string/jumbo v6, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x1e

    const-string/jumbo v6, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x1f

    const-string/jumbo v6, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x20

    const-string/jumbo v6, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x21

    const-string/jumbo v6, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x22

    const-string/jumbo v6, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x23

    const-string/jumbo v6, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    const/16 v5, 0x24

    const-string/jumbo v6, "TLS_DH_anon_WITH_AES_128_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x25

    const-string/jumbo v6, "TLS_DH_anon_WITH_AES_256_CBC_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x26

    const-string/jumbo v6, "TLS_DH_anon_WITH_AES_128_GCM_SHA256"

    aput-object v6, v4, v5

    const/16 v5, 0x27

    const-string/jumbo v6, "TLS_DH_anon_WITH_AES_256_GCM_SHA384"

    aput-object v6, v4, v5

    invoke-static {v4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->APPROVED_CIPHERS:Ljava/util/Set;

    .line 94
    new-instance v1, Ljava/util/HashSet;

    const/16 v4, 0x17

    new-array v4, v4, [Ljava/lang/String;

    const-string/jumbo v5, "TLS_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v5, v4, v3

    const-string/jumbo v3, "TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const-string/jumbo v2, "TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v2, v4, v8

    const-string/jumbo v2, "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA"

    aput-object v2, v4, v9

    const/4 v2, 0x4

    const-string/jumbo v3, "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/4 v2, 0x5

    const-string/jumbo v3, "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/4 v2, 0x6

    const-string/jumbo v3, "SSL_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/4 v2, 0x7

    const-string/jumbo v3, "SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x8

    const-string/jumbo v3, "SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x9

    const-string/jumbo v3, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const-string/jumbo v2, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA"

    aput-object v2, v4, v7

    const/16 v2, 0xb

    const-string/jumbo v3, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0xc

    const-string/jumbo v3, "TLS_RSA_WITH_AES_128_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0xd

    const-string/jumbo v3, "TLS_DH_RSA_WITH_AES_128_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0xe

    const-string/jumbo v3, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0xf

    const-string/jumbo v3, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x10

    const-string/jumbo v3, "TLS_DH_anon_WITH_AES_128_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x11

    const-string/jumbo v3, "TLS_RSA_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x12

    const-string/jumbo v3, "TLS_DH_DSS_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x13

    const-string/jumbo v3, "TLS_DH_RSA_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x14

    const-string/jumbo v3, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x15

    const-string/jumbo v3, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    const/16 v2, 0x16

    const-string/jumbo v3, "TLS_DH_anon_WITH_AES_256_CBC_SHA"

    aput-object v3, v4, v2

    invoke-static {v4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->DEPRECATED_CIPHERS:Ljava/util/Set;

    .line 133
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 134
    .local v0, "set":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->APPROVED_CIPHERS:Ljava/util/Set;

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 135
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->DEPRECATED_CIPHERS:Ljava/util/Set;

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 136
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->ALLOWED_CIPHERS:Ljava/util/Set;

    .line 137
    return-void

    .end local v0    # "set":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    :cond_0
    move v1, v3

    .line 26
    goto/16 :goto_0
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 144
    return-void
.end method

.method private static enable(Ljavax/net/ssl/SSLSocket;Ljava/util/Set;)Z
    .locals 8
    .param p0, "sslSocket"    # Ljavax/net/ssl/SSLSocket;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljavax/net/ssl/SSLSocket;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "cipherSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 169
    sget-boolean v0, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->ENABLED_ON_THIS_PLATFORM:Z

    if-eqz v0, :cond_3

    .line 171
    invoke-virtual {p0}, Ljavax/net/ssl/SSLSocket;->getSupportedCipherSuites()[Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    array-length v5, v3

    move v0, v2

    :goto_0
    if-ge v0, v5, :cond_1

    aget-object v6, v3, v0

    invoke-interface {p1, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {v4, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljavax/net/ssl/SSLSocket;->setEnabledCipherSuites([Ljava/lang/String;)V

    .line 173
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->APPROVED_PROTOCOLS:[Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljavax/net/ssl/SSLSocket;->setEnabledProtocols([Ljava/lang/String;)V

    .line 175
    invoke-virtual {p0}, Ljavax/net/ssl/SSLSocket;->getEnabledCipherSuites()[Ljava/lang/String;

    move-result-object v0

    array-length v0, v0

    if-lez v0, :cond_2

    invoke-virtual {p0}, Ljavax/net/ssl/SSLSocket;->getEnabledProtocols()[Ljava/lang/String;

    move-result-object v0

    array-length v0, v0

    if-lez v0, :cond_2

    move v0, v1

    .line 177
    :goto_1
    return v0

    :cond_2
    move v0, v2

    .line 175
    goto :goto_1

    :cond_3
    move v0, v1

    .line 177
    goto :goto_1
.end method

.method static enableAllowed(Ljavax/net/ssl/SSLSocket;)Z
    .locals 1
    .param p0, "sslSocket"    # Ljavax/net/ssl/SSLSocket;

    .prologue
    .line 151
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->ALLOWED_CIPHERS:Ljava/util/Set;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->enable(Ljavax/net/ssl/SSLSocket;Ljava/util/Set;)Z

    move-result v0

    return v0
.end method

.method static enableApproved(Ljavax/net/ssl/SSLSocket;)Z
    .locals 1
    .param p0, "sslSocket"    # Ljavax/net/ssl/SSLSocket;

    .prologue
    .line 159
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->APPROVED_CIPHERS:Ljava/util/Set;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->enable(Ljavax/net/ssl/SSLSocket;Ljava/util/Set;)Z

    move-result v0

    return v0
.end method
