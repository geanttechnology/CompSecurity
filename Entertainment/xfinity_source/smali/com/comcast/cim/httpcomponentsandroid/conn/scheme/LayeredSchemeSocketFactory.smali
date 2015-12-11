.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;
.super Ljava/lang/Object;
.source "LayeredSchemeSocketFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;


# virtual methods
.method public abstract createLayeredSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;
        }
    .end annotation
.end method
