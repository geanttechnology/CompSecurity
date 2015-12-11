.class public interface abstract Lcom/poshmark/http/api/PMApiResponseHandler;
.super Ljava/lang/Object;
.source "PMApiResponseHandler.java"

# interfaces
.implements Lcom/poshmark/http/PMBaseHttpResponseHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/PMBaseHttpResponseHandler;"
    }
.end annotation


# virtual methods
.method public abstract handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<TT;>;)V"
        }
    .end annotation
.end method
