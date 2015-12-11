.class public Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;
.super Ljava/lang/Object;
.source "LoaderTask.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/LoaderTask$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/ansel/fetch/LoaderTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AbstractListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/LoaderTask$Listener",
        "<TResult;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 304
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;, "Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener<TResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public done()V
    .locals 0

    .prologue
    .line 315
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;, "Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener<TResult;>;"
    return-void
.end method

.method public error(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 311
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;, "Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener<TResult;>;"
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
    .line 307
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;, "Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener<TResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TResult;"
    return-void
.end method
