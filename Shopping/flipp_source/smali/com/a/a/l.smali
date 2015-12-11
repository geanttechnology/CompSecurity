.class final Lcom/a/a/l;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/lang/String;

.field final b:Lcom/a/a/a/a/v;

.field final c:Ljava/lang/String;

.field final d:Lcom/a/a/a/a/v;

.field final e:Ljava/lang/String;

.field final f:[Ljava/security/cert/Certificate;

.field final g:[Ljava/security/cert/Certificate;


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 511
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 513
    :try_start_0
    new-instance v2, Lcom/a/a/a/s;

    sget-object v1, Lcom/a/a/a/u;->d:Ljava/nio/charset/Charset;

    invoke-direct {v2, p1, v1}, Lcom/a/a/a/s;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 514
    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/a/a/l;->a:Ljava/lang/String;

    .line 515
    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/a/a/l;->c:Ljava/lang/String;

    .line 516
    new-instance v1, Lcom/a/a/a/a/v;

    invoke-direct {v1}, Lcom/a/a/a/a/v;-><init>()V

    iput-object v1, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    .line 517
    invoke-virtual {v2}, Lcom/a/a/a/s;->b()I

    move-result v3

    move v1, v0

    .line 518
    :goto_0
    if-ge v1, v3, :cond_0

    .line 519
    iget-object v4, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/a/a/a/a/v;->c(Ljava/lang/String;)V

    .line 518
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 522
    :cond_0
    new-instance v1, Lcom/a/a/a/a/v;

    invoke-direct {v1}, Lcom/a/a/a/a/v;-><init>()V

    iput-object v1, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    .line 523
    iget-object v1, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;)V

    .line 524
    invoke-virtual {v2}, Lcom/a/a/a/s;->b()I

    move-result v1

    .line 525
    :goto_1
    if-ge v0, v1, :cond_1

    .line 526
    iget-object v3, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/a/a/a/a/v;->c(Ljava/lang/String;)V

    .line 525
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 529
    :cond_1
    invoke-virtual {p0}, Lcom/a/a/l;->a()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 530
    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v0

    .line 531
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 532
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "expected \"\" but was \""

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 543
    :catchall_0
    move-exception v0

    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    throw v0

    .line 534
    :cond_2
    :try_start_1
    invoke-virtual {v2}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->e:Ljava/lang/String;

    .line 535
    invoke-static {v2}, Lcom/a/a/l;->a(Lcom/a/a/a/s;)[Ljava/security/cert/Certificate;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    .line 536
    invoke-static {v2}, Lcom/a/a/l;->a(Lcom/a/a/a/s;)[Ljava/security/cert/Certificate;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 543
    :goto_2
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    .line 544
    return-void

    .line 538
    :cond_3
    const/4 v0, 0x0

    :try_start_2
    iput-object v0, p0, Lcom/a/a/l;->e:Ljava/lang/String;

    .line 539
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    .line 540
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2
.end method

.method public constructor <init>(Ljava/net/URI;Lcom/a/a/a/a/v;Ljava/net/HttpURLConnection;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 548
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 549
    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->a:Ljava/lang/String;

    .line 550
    iput-object p2, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    .line 551
    invoke-virtual {p3}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->c:Ljava/lang/String;

    .line 552
    invoke-virtual {p3}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/a/v;->a(Ljava/util/Map;)Lcom/a/a/a/a/v;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    .line 554
    instance-of v0, p3, Lcom/a/a/a/a/r;

    if-eqz v0, :cond_0

    check-cast p3, Lcom/a/a/a/a/r;

    iget-object v0, p3, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->b()Lcom/a/a/a/a/h;

    move-result-object v0

    :goto_0
    instance-of v2, v0, Lcom/a/a/a/a/q;

    if-eqz v2, :cond_1

    check-cast v0, Lcom/a/a/a/a/q;

    iget-object v0, v0, Lcom/a/a/a/a/q;->k:Ljavax/net/ssl/SSLSocket;

    move-object v2, v0

    .line 555
    :goto_1
    if-eqz v2, :cond_2

    .line 556
    invoke-virtual {v2}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->e:Ljava/lang/String;

    .line 559
    :try_start_0
    invoke-virtual {v2}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getPeerCertificates()[Ljava/security/cert/Certificate;
    :try_end_0
    .catch Ljavax/net/ssl/SSLPeerUnverifiedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 562
    :goto_2
    iput-object v0, p0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    .line 563
    invoke-virtual {v2}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    .line 569
    :goto_3
    return-void

    .line 554
    :cond_0
    check-cast p3, Lcom/a/a/a/a/o;

    invoke-virtual {p3}, Lcom/a/a/a/a/o;->b()Lcom/a/a/a/a/h;

    move-result-object v0

    goto :goto_0

    :cond_1
    move-object v2, v1

    goto :goto_1

    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_2

    .line 565
    :cond_2
    iput-object v1, p0, Lcom/a/a/l;->e:Ljava/lang/String;

    .line 566
    iput-object v1, p0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    .line 567
    iput-object v1, p0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    goto :goto_3
.end method

.method private static a(Ljava/io/Writer;[Ljava/security/cert/Certificate;)V
    .locals 4

    .prologue
    .line 637
    if-nez p1, :cond_1

    .line 638
    const-string v0, "-1\n"

    invoke-virtual {p0, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 650
    :cond_0
    return-void

    .line 642
    :cond_1
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    array-length v1, p1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0xa

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 643
    array-length v1, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    aget-object v2, p1, v0

    .line 644
    invoke-virtual {v2}, Ljava/security/cert/Certificate;->getEncoded()[B

    move-result-object v2

    .line 645
    invoke-static {v2}, Lcom/a/a/a/b;->b([B)Ljava/lang/String;

    move-result-object v2

    .line 646
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 643
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 648
    :catch_0
    move-exception v0

    .line 649
    new-instance v1, Ljava/io/IOException;

    invoke-virtual {v0}, Ljava/security/cert/CertificateEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static a(Lcom/a/a/a/s;)[Ljava/security/cert/Certificate;
    .locals 5

    .prologue
    .line 618
    invoke-virtual {p0}, Lcom/a/a/a/s;->b()I

    move-result v0

    .line 619
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 620
    const/4 v0, 0x0

    .line 630
    :cond_0
    return-object v0

    .line 623
    :cond_1
    :try_start_0
    const-string v1, "X.509"

    invoke-static {v1}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v2

    .line 624
    new-array v0, v0, [Ljava/security/cert/Certificate;

    .line 625
    const/4 v1, 0x0

    :goto_0
    array-length v3, v0

    if-ge v1, v3, :cond_0

    .line 626
    invoke-virtual {p0}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v3

    .line 627
    const-string v4, "US-ASCII"

    invoke-virtual {v3, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-static {v3}, Lcom/a/a/a/b;->a([B)[B

    move-result-object v3

    .line 628
    new-instance v4, Ljava/io/ByteArrayInputStream;

    invoke-direct {v4, v3}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-virtual {v2, v4}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v3

    aput-object v3, v0, v1
    :try_end_0
    .catch Ljava/security/cert/CertificateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 625
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 631
    :catch_0
    move-exception v0

    .line 632
    new-instance v1, Ljava/io/IOException;

    invoke-virtual {v0}, Ljava/security/cert/CertificateException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public final a(Lcom/a/a/a/f;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    const/16 v5, 0xa

    .line 588
    invoke-virtual {p1, v1}, Lcom/a/a/a/f;->a(I)Ljava/io/OutputStream;

    move-result-object v0

    .line 589
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/OutputStreamWriter;

    sget-object v4, Lcom/a/a/a/u;->e:Ljava/nio/charset/Charset;

    invoke-direct {v3, v0, v4}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 591
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->a:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 592
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->c:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 593
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v3}, Lcom/a/a/a/a/v;->a()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    move v0, v1

    .line 594
    :goto_0
    iget-object v3, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v3}, Lcom/a/a/a/a/v;->a()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 595
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v4, v0}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v4, v0}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 594
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 598
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    iget-object v3, v3, Lcom/a/a/a/a/v;->b:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 599
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v3}, Lcom/a/a/a/a/v;->a()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 600
    :goto_1
    iget-object v0, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v0}, Lcom/a/a/a/a/v;->a()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 601
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v3, v1}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ": "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v3, v1}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 600
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 604
    :cond_1
    invoke-virtual {p0}, Lcom/a/a/l;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 605
    invoke-virtual {v2, v5}, Ljava/io/Writer;->write(I)V

    .line 606
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/a/a/l;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 607
    iget-object v0, p0, Lcom/a/a/l;->f:[Ljava/security/cert/Certificate;

    invoke-static {v2, v0}, Lcom/a/a/l;->a(Ljava/io/Writer;[Ljava/security/cert/Certificate;)V

    .line 608
    iget-object v0, p0, Lcom/a/a/l;->g:[Ljava/security/cert/Certificate;

    invoke-static {v2, v0}, Lcom/a/a/l;->a(Ljava/io/Writer;[Ljava/security/cert/Certificate;)V

    .line 610
    :cond_2
    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 611
    return-void
.end method

.method final a()Z
    .locals 2

    .prologue
    .line 614
    iget-object v0, p0, Lcom/a/a/l;->a:Ljava/lang/String;

    const-string v1, "https://"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
