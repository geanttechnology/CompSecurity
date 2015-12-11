.class public interface abstract Lcom/amazon/ansel/fetch/ResourceListener;
.super Ljava/lang/Object;
.source "ResourceListener.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/LoaderListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/LoaderListener;"
    }
.end annotation


# virtual methods
.method public abstract result(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation
.end method
