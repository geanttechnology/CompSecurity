.class public abstract Lcom/amazon/ansel/fetch/AbstractLoaderListener;
.super Ljava/lang/Object;
.source "AbstractLoaderListener.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/LoaderListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public done()V
    .locals 0

    .prologue
    .line 10
    return-void
.end method

.method public error(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 6
    return-void
.end method

.method public invalidate()V
    .locals 0

    .prologue
    .line 14
    return-void
.end method
