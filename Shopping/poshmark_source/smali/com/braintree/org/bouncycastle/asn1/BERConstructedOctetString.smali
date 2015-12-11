.class public Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;
.super Lcom/braintree/org/bouncycastle/asn1/DEROctetString;
.source "BERConstructedOctetString.java"


# static fields
.field private static final MAX_LENGTH:I = 0x3e8


# instance fields
.field private octs:Ljava/util/Vector;


# direct methods
.method public constructor <init>(Lcom/braintree/org/bouncycastle/asn1/DEREncodable;)V
    .locals 1
    .param p1, "obj"    # Lcom/braintree/org/bouncycastle/asn1/DEREncodable;

    .prologue
    .line 70
    invoke-interface {p1}, Lcom/braintree/org/bouncycastle/asn1/DEREncodable;->getDERObject()Lcom/braintree/org/bouncycastle/asn1/DERObject;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;-><init>(Lcom/braintree/org/bouncycastle/asn1/DEREncodable;)V

    .line 71
    return-void
.end method

.method public constructor <init>(Lcom/braintree/org/bouncycastle/asn1/DERObject;)V
    .locals 0
    .param p1, "obj"    # Lcom/braintree/org/bouncycastle/asn1/DERObject;

    .prologue
    .line 64
    invoke-direct {p0, p1}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;-><init>(Lcom/braintree/org/bouncycastle/asn1/DEREncodable;)V

    .line 65
    return-void
.end method

.method public constructor <init>(Ljava/util/Vector;)V
    .locals 1
    .param p1, "octs"    # Ljava/util/Vector;

    .prologue
    .line 56
    invoke-static {p1}, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->toBytes(Ljava/util/Vector;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;-><init>([B)V

    .line 58
    iput-object p1, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->octs:Ljava/util/Vector;

    .line 59
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "string"    # [B

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;-><init>([B)V

    .line 51
    return-void
.end method

.method public static fromSequence(Lcom/braintree/org/bouncycastle/asn1/ASN1Sequence;)Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;
    .locals 3
    .param p0, "seq"    # Lcom/braintree/org/bouncycastle/asn1/ASN1Sequence;

    .prologue
    .line 147
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    .line 148
    .local v1, "v":Ljava/util/Vector;
    invoke-virtual {p0}, Lcom/braintree/org/bouncycastle/asn1/ASN1Sequence;->getObjects()Ljava/util/Enumeration;

    move-result-object v0

    .line 150
    .local v0, "e":Ljava/util/Enumeration;
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 152
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0

    .line 155
    :cond_0
    new-instance v2, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;

    invoke-direct {v2, v1}, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;-><init>(Ljava/util/Vector;)V

    return-object v2
.end method

.method private generateOcts()Ljava/util/Vector;
    .locals 7

    .prologue
    .line 93
    new-instance v3, Ljava/util/Vector;

    invoke-direct {v3}, Ljava/util/Vector;-><init>()V

    .line 94
    .local v3, "vec":Ljava/util/Vector;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->string:[B

    array-length v4, v4

    if-ge v1, v4, :cond_1

    .line 98
    add-int/lit16 v4, v1, 0x3e8

    iget-object v5, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->string:[B

    array-length v5, v5

    if-le v4, v5, :cond_0

    .line 100
    iget-object v4, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->string:[B

    array-length v0, v4

    .line 107
    .local v0, "end":I
    :goto_1
    sub-int v4, v0, v1

    new-array v2, v4, [B

    .line 109
    .local v2, "nStr":[B
    iget-object v4, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->string:[B

    const/4 v5, 0x0

    array-length v6, v2

    invoke-static {v4, v1, v2, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 111
    new-instance v4, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;

    invoke-direct {v4, v2}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;-><init>([B)V

    invoke-virtual {v3, v4}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 94
    add-int/lit16 v1, v1, 0x3e8

    goto :goto_0

    .line 104
    .end local v0    # "end":I
    .end local v2    # "nStr":[B
    :cond_0
    add-int/lit16 v0, v1, 0x3e8

    .restart local v0    # "end":I
    goto :goto_1

    .line 114
    .end local v0    # "end":I
    :cond_1
    return-object v3
.end method

.method private static toBytes(Ljava/util/Vector;)[B
    .locals 7
    .param p0, "octs"    # Ljava/util/Vector;

    .prologue
    .line 19
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 21
    .local v0, "bOut":Ljava/io/ByteArrayOutputStream;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/util/Vector;->size()I

    move-result v4

    if-eq v2, v4, :cond_0

    .line 25
    :try_start_0
    invoke-virtual {p0, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;

    .line 27
    .local v3, "o":Lcom/braintree/org/bouncycastle/asn1/DEROctetString;
    invoke-virtual {v3}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;->getOctets()[B

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 21
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 29
    .end local v3    # "o":Lcom/braintree/org/bouncycastle/asn1/DEROctetString;
    :catch_0
    move-exception v1

    .line 31
    .local v1, "e":Ljava/lang/ClassCastException;
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " found in input should only contain DEROctetString"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 33
    .end local v1    # "e":Ljava/lang/ClassCastException;
    :catch_1
    move-exception v1

    .line 35
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "exception converting octets "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 39
    .end local v1    # "e":Ljava/io/IOException;
    :cond_0
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    return-object v4
.end method


# virtual methods
.method public encode(Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;)V
    .locals 3
    .param p1, "out"    # Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 121
    instance-of v1, p1, Lcom/braintree/org/bouncycastle/asn1/ASN1OutputStream;

    if-nez v1, :cond_0

    instance-of v1, p1, Lcom/braintree/org/bouncycastle/asn1/BEROutputStream;

    if-eqz v1, :cond_2

    .line 123
    :cond_0
    const/16 v1, 0x24

    invoke-virtual {p1, v1}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->write(I)V

    .line 125
    const/16 v1, 0x80

    invoke-virtual {p1, v1}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->write(I)V

    .line 130
    invoke-virtual {p0}, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->getObjects()Ljava/util/Enumeration;

    move-result-object v0

    .line 131
    .local v0, "e":Ljava/util/Enumeration;
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 133
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->writeObject(Ljava/lang/Object;)V

    goto :goto_0

    .line 136
    :cond_1
    invoke-virtual {p1, v2}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->write(I)V

    .line 137
    invoke-virtual {p1, v2}, Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;->write(I)V

    .line 143
    .end local v0    # "e":Ljava/util/Enumeration;
    :goto_1
    return-void

    .line 141
    :cond_2
    invoke-super {p0, p1}, Lcom/braintree/org/bouncycastle/asn1/DEROctetString;->encode(Lcom/braintree/org/bouncycastle/asn1/DEROutputStream;)V

    goto :goto_1
.end method

.method public getObjects()Ljava/util/Enumeration;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->octs:Ljava/util/Vector;

    if-nez v0, :cond_0

    .line 85
    invoke-direct {p0}, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->generateOcts()Ljava/util/Vector;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v0

    .line 88
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->octs:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v0

    goto :goto_0
.end method

.method public getOctets()[B
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/braintree/org/bouncycastle/asn1/BERConstructedOctetString;->string:[B

    return-object v0
.end method
