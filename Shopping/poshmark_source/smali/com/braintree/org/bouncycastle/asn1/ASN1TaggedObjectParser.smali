.class public interface abstract Lcom/braintree/org/bouncycastle/asn1/ASN1TaggedObjectParser;
.super Ljava/lang/Object;
.source "ASN1TaggedObjectParser.java"

# interfaces
.implements Lcom/braintree/org/bouncycastle/asn1/DEREncodable;
.implements Lcom/braintree/org/bouncycastle/asn1/InMemoryRepresentable;


# virtual methods
.method public abstract getObjectParser(IZ)Lcom/braintree/org/bouncycastle/asn1/DEREncodable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract getTagNo()I
.end method
