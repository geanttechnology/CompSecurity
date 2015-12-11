.class Lcom/exacttarget/etpushsdk/util/a$c;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljavax/crypto/SecretKey;

.field private b:Ljavax/crypto/SecretKey;


# direct methods
.method public constructor <init>(Ljavax/crypto/SecretKey;Ljavax/crypto/SecretKey;)V
    .locals 0

    .prologue
    .line 519
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 520
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/util/a$c;->a(Ljavax/crypto/SecretKey;)V

    .line 521
    invoke-virtual {p0, p2}, Lcom/exacttarget/etpushsdk/util/a$c;->b(Ljavax/crypto/SecretKey;)V

    .line 522
    return-void
.end method


# virtual methods
.method public a()Ljavax/crypto/SecretKey;
    .locals 1

    .prologue
    .line 525
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$c;->a:Ljavax/crypto/SecretKey;

    return-object v0
.end method

.method public a(Ljavax/crypto/SecretKey;)V
    .locals 0

    .prologue
    .line 529
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/a$c;->a:Ljavax/crypto/SecretKey;

    .line 530
    return-void
.end method

.method public b()Ljavax/crypto/SecretKey;
    .locals 1

    .prologue
    .line 533
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$c;->b:Ljavax/crypto/SecretKey;

    return-object v0
.end method

.method public b(Ljavax/crypto/SecretKey;)V
    .locals 0

    .prologue
    .line 537
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/a$c;->b:Ljavax/crypto/SecretKey;

    .line 538
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 562
    if-ne p0, p1, :cond_1

    .line 578
    :cond_0
    :goto_0
    return v0

    .line 565
    :cond_1
    if-nez p1, :cond_2

    move v0, v1

    .line 566
    goto :goto_0

    .line 568
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    move v0, v1

    .line 569
    goto :goto_0

    .line 571
    :cond_3
    check-cast p1, Lcom/exacttarget/etpushsdk/util/a$c;

    .line 572
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$c;->b:Ljavax/crypto/SecretKey;

    iget-object v3, p1, Lcom/exacttarget/etpushsdk/util/a$c;->b:Ljavax/crypto/SecretKey;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    move v0, v1

    .line 573
    goto :goto_0

    .line 575
    :cond_4
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$c;->a:Ljavax/crypto/SecretKey;

    iget-object v3, p1, Lcom/exacttarget/etpushsdk/util/a$c;->a:Ljavax/crypto/SecretKey;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    .line 576
    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 553
    .line 555
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$c;->a:Ljavax/crypto/SecretKey;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    add-int/lit8 v0, v0, 0x1f

    .line 556
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$c;->b:Ljavax/crypto/SecretKey;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 557
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x2

    .line 547
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$c;->a()Ljavax/crypto/SecretKey;

    move-result-object v1

    invoke-interface {v1}, Ljavax/crypto/SecretKey;->getEncoded()[B

    move-result-object v1

    invoke-static {v1, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/a$c;->b()Ljavax/crypto/SecretKey;

    move-result-object v1

    invoke-interface {v1}, Ljavax/crypto/SecretKey;->getEncoded()[B

    move-result-object v1

    invoke-static {v1, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
