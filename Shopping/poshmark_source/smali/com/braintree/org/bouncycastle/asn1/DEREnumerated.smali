.class public Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;
.super Lcom/braintree/org/bouncycastle/asn1/ASN1Object;
.source "DEREnumerated.java"


# instance fields
.field bytes:[B


# direct methods
.method public constructor <init>(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/braintree/org/bouncycastle/asn1/ASN1Object;-><init>()V

    .line 57
    int-to-long v0, p1

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    invoke-virtual {v0}, Ljava/math/BigInteger;->toByteArray()[B

    move-result-object v0

    iput-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    .line 58
    return-void
.end method

.method public constructor <init>(Ljava/math/BigInteger;)V
    .locals 1
    .param p1, "value"    # Ljava/math/BigInteger;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/braintree/org/bouncycastle/asn1/ASN1Object;-><init>()V

    .line 63
    invoke-virtual {p1}, Ljava/math/BigInteger;->toByteArray()[B

    move-result-object v0

    iput-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    .line 64
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bytes"    # [B

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/braintree/org/bouncycastle/asn1/ASN1Object;-><init>()V

    .line 69
    iput-object p1, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    .line 70
    return-void
.end method

.method public static getInstance(Lcom/braintree/org/bouncycastle/asn1/ASN1TaggedObject;Z)Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;
    .locals 3
    .param p0, "obj"    # Lcom/braintree/org/bouncycastle/asn1/ASN1TaggedObject;
    .param p1, "explicit"    # Z

    .prologue
    .line 42
    invoke-virtual {p0}, Lcom/braintree/org/bouncycastle/asn1/ASN1TaggedObject;->getObject()Lcom/braintree/org/bouncycastle/asn1/DERObject;

    move-result-object v0

    .line 44
    .local v0, "o":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    if-nez p1, :cond_0

    instance-of v1, v0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    if-eqz v1, :cond_1

    .line 46
    :cond_0
    invoke-static {v0}, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->getInstance(Ljava/lang/Object;)Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    move-result-object v1

    .line 50
    .end local v0    # "o":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    :goto_0
    return-object v1

    .restart local v0    # "o":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    :cond_1
    new-instance v1, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    check-cast v0, Lcom/braintree/org/bouncycastle/asn1/ASN1OctetString;

    .end local v0    # "o":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    invoke-virtual {v0}, Lcom/braintree/org/bouncycastle/asn1/ASN1OctetString;->getOctets()[B

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;-><init>([B)V

    goto :goto_0
.end method

.method public static getInstance(Ljava/lang/Object;)Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;
    .locals 3
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 21
    if-eqz p0, :cond_0

    instance-of v0, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    if-eqz v0, :cond_1

    .line 23
    :cond_0
    check-cast p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    .end local p0    # "obj":Ljava/lang/Object;
    return-object p0

    .line 26
    .restart local p0    # "obj":Ljava/lang/Object;
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "illegal object in getInstance: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method asn1Equals(Lcom/braintree/org/bouncycastle/asn1/DERObject;)Z
    .locals 3
    .param p1, "o"    # Lcom/braintree/org/bouncycastle/asn1/DERObject;

    .prologue
    .line 87
    instance-of v1, p1, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    if-nez v1, :cond_0

    .line 89
    const/4 v1, 0x0

    .line 94
    :goto_0
    return v1

    :cond_0
    move-object v0, p1

    .line 92
    check-cast v0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;

    .line 94
    .local v0, "other":Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;
    iget-object v1, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    iget-object v2, v0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    invoke-static {v1, v2}, Lcom/braintree/org/bouncycastle/util/Arrays;->areEqual([B[B)Z

    move-result v1

    goto :goto_0
.end method

.method encode(Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;)V
    .locals 2
    .param p1, "out"    # Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 81
    const/16 v0, 0xa

    iget-object v1, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    invoke-virtual {p1, v0, v1}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->writeEncoded(I[B)V

    .line 82
    return-void
.end method

.method public getValue()Ljava/math/BigInteger;
    .locals 2

    .prologue
    .line 74
    new-instance v0, Ljava/math/BigInteger;

    iget-object v1, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>([B)V

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/DEREnumerated;->bytes:[B

    invoke-static {v0}, Lcom/braintree/org/bouncycastle/util/Arrays;->hashCode([B)I

    move-result v0

    return v0
.end method
