.class public interface abstract Lamazon/communication/srr/SrrManager;
.super Ljava/lang/Object;
.source "SrrManager.java"


# virtual methods
.method public abstract makeRequestSync(Lamazon/communication/srr/SrrRequest;)Lorg/apache/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/TimeoutException;,
            Lamazon/communication/RequestFailedException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation
.end method
