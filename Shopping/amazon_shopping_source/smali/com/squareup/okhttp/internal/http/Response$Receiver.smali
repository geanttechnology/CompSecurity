.class public interface abstract Lcom/squareup/okhttp/internal/http/Response$Receiver;
.super Ljava/lang/Object;
.source "Response.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/Response;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Receiver"
.end annotation


# virtual methods
.method public abstract onFailure(Lcom/squareup/okhttp/internal/http/Failure;)V
.end method

.method public abstract onResponse(Lcom/squareup/okhttp/internal/http/Response;)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
