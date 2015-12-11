.class final Lcom/a/a/n;
.super Ljava/net/SecureCacheResponse;
.source "SourceFile"


# instance fields
.field private final a:Lcom/a/a/l;

.field private final b:Lcom/a/a/a/i;

.field private final c:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Lcom/a/a/l;Lcom/a/a/a/i;)V
    .locals 1

    .prologue
    .line 700
    invoke-direct {p0}, Ljava/net/SecureCacheResponse;-><init>()V

    .line 701
    iput-object p1, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    .line 702
    iput-object p2, p0, Lcom/a/a/n;->b:Lcom/a/a/a/i;

    .line 703
    invoke-static {p2}, Lcom/a/a/f;->a(Lcom/a/a/a/i;)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/n;->c:Ljava/io/InputStream;

    .line 704
    return-void
.end method

.method static synthetic a(Lcom/a/a/n;)Lcom/a/a/a/i;
    .locals 1

    .prologue
    .line 695
    iget-object v0, p0, Lcom/a/a/n;->b:Lcom/a/a/a/i;

    return-object v0
.end method


# virtual methods
.method public final getBody()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 711
    iget-object v0, p0, Lcom/a/a/n;->c:Ljava/io/InputStream;

    return-object v0
.end method

.method public final getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 715
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->e:Ljava/lang/String;

    return-object v0
.end method

.method public final getHeaders()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 707
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getLocalCertificateChain()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/security/cert/Certificate;",
            ">;"
        }
    .end annotation

    .prologue
    .line 734
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 735
    :cond_0
    const/4 v0, 0x0

    .line 737
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    invoke-virtual {v0}, [Ljava/security/cert/Certificate;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public final getLocalPrincipal()Ljava/security/Principal;
    .locals 2

    .prologue
    .line 741
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 742
    :cond_0
    const/4 v0, 0x0

    .line 744
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    check-cast v0, Ljava/security/cert/X509Certificate;

    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v0

    goto :goto_0
.end method

.method public final getPeerPrincipal()Ljava/security/Principal;
    .locals 2

    .prologue
    .line 727
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 728
    :cond_0
    new-instance v0, Ljavax/net/ssl/SSLPeerUnverifiedException;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljavax/net/ssl/SSLPeerUnverifiedException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 730
    :cond_1
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    check-cast v0, Ljava/security/cert/X509Certificate;

    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v0

    return-object v0
.end method

.method public final getServerCertificateChain()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/security/cert/Certificate;",
            ">;"
        }
    .end annotation

    .prologue
    .line 720
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 721
    :cond_0
    new-instance v0, Ljavax/net/ssl/SSLPeerUnverifiedException;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljavax/net/ssl/SSLPeerUnverifiedException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 723
    :cond_1
    iget-object v0, p0, Lcom/a/a/n;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    invoke-virtual {v0}, [Ljava/security/cert/Certificate;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
