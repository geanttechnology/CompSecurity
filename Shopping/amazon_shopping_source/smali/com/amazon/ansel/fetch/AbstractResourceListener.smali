.class public abstract Lcom/amazon/ansel/fetch/AbstractResourceListener;
.super Ljava/lang/Object;
.source "AbstractResourceListener.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/ResourceListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/ResourceListener",
        "<TResult;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    .local p0, "this":Lcom/amazon/ansel/fetch/AbstractResourceListener;, "Lcom/amazon/ansel/fetch/AbstractResourceListener<TResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public done()V
    .locals 0

    .prologue
    .line 14
    .local p0, "this":Lcom/amazon/ansel/fetch/AbstractResourceListener;, "Lcom/amazon/ansel/fetch/AbstractResourceListener<TResult;>;"
    return-void
.end method

.method public error(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 10
    .local p0, "this":Lcom/amazon/ansel/fetch/AbstractResourceListener;, "Lcom/amazon/ansel/fetch/AbstractResourceListener<TResult;>;"
    return-void
.end method

.method public invalidate()V
    .locals 0

    .prologue
    .line 18
    .local p0, "this":Lcom/amazon/ansel/fetch/AbstractResourceListener;, "Lcom/amazon/ansel/fetch/AbstractResourceListener<TResult;>;"
    return-void
.end method

.method public result(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/amazon/ansel/fetch/AbstractResourceListener;, "Lcom/amazon/ansel/fetch/AbstractResourceListener<TResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TResult;"
    return-void
.end method
