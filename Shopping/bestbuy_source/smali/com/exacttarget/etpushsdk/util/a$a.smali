.class public Lcom/exacttarget/etpushsdk/util/a$a;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:[B

.field private final b:[B

.field private final c:[B


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 611
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 612
    const-string v0, ":"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 613
    array-length v1, v0

    const/4 v2, 0x3

    if-eq v1, v2, :cond_0

    .line 614
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cannot parse iv:ciphertext:mac"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 616
    :cond_0
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    .line 617
    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-static {v1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    .line 618
    aget-object v0, v0, v3

    invoke-static {v0, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    .line 620
    return-void
.end method

.method public constructor <init>([B[B[B)V
    .locals 1

    .prologue
    .line 597
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 598
    array-length v0, p1

    invoke-static {p1, v0}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    .line 599
    array-length v0, p2

    invoke-static {p2, v0}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    .line 600
    array-length v0, p3

    invoke-static {p3, v0}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    .line 601
    return-void
.end method

.method public static a([B[B)[B
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 631
    array-length v0, p0

    array-length v1, p1

    add-int/2addr v0, v1

    new-array v0, v0, [B

    .line 632
    array-length v1, p0

    invoke-static {p0, v3, v0, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 633
    array-length v1, p0

    array-length v2, p1

    invoke-static {p1, v3, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 634
    return-object v0
.end method


# virtual methods
.method public a()[B
    .locals 1

    .prologue
    .line 638
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    return-object v0
.end method

.method public b()[B
    .locals 1

    .prologue
    .line 642
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    return-object v0
.end method

.method public c()[B
    .locals 1

    .prologue
    .line 646
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 675
    if-ne p0, p1, :cond_1

    .line 694
    :cond_0
    :goto_0
    return v0

    .line 678
    :cond_1
    if-nez p1, :cond_2

    move v0, v1

    .line 679
    goto :goto_0

    .line 681
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    move v0, v1

    .line 682
    goto :goto_0

    .line 684
    :cond_3
    check-cast p1, Lcom/exacttarget/etpushsdk/util/a$a;

    .line 685
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    iget-object v3, p1, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-nez v2, :cond_4

    move v0, v1

    .line 686
    goto :goto_0

    .line 688
    :cond_4
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    iget-object v3, p1, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-nez v2, :cond_5

    move v0, v1

    .line 689
    goto :goto_0

    .line 691
    :cond_5
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    iget-object v3, p1, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    .line 692
    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 665
    .line 667
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([B)I

    move-result v0

    add-int/lit8 v0, v0, 0x1f

    .line 668
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v1

    add-int/2addr v0, v1

    .line 669
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v1

    add-int/2addr v0, v1

    .line 670
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 657
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/a$a;->b:[B

    invoke-static {v0, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    .line 658
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/util/a$a;->a:[B

    invoke-static {v1, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    .line 659
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/util/a$a;->c:[B

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    .line 660
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ":"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
