.class public interface abstract Loauth/signpost/OAuthConsumer;
.super Ljava/lang/Object;
.source "OAuthConsumer.java"

# interfaces
.implements Ljava/io/Serializable;


# virtual methods
.method public abstract sign(Ljava/lang/Object;)Loauth/signpost/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Loauth/signpost/exception/OAuthMessageSignerException;,
            Loauth/signpost/exception/OAuthExpectationFailedException;,
            Loauth/signpost/exception/OAuthCommunicationException;
        }
    .end annotation
.end method
