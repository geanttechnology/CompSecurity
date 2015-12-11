.class public interface abstract Lamazon/communication/authentication/RequestSigner;
.super Ljava/lang/Object;
.source "RequestSigner.java"


# virtual methods
.method public abstract signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation
.end method
