.class public abstract Lcom/amazon/ansel/fetch/UriLoader;
.super Lcom/amazon/ansel/fetch/ResourceLoader;
.source "UriLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/ansel/fetch/ResourceLoader",
        "<TResult;>;"
    }
.end annotation


# instance fields
.field private final uriRequest:Lcom/amazon/ansel/fetch/UriRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Class;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/UriRequest;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p4, "priority"    # J
    .param p6, "uriRequest"    # Lcom/amazon/ansel/fetch/UriRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/LoaderContext;",
            "Ljava/lang/Class",
            "<TResult;>;",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TResult;>;>;J",
            "Lcom/amazon/ansel/fetch/UriRequest;",
            ")V"
        }
    .end annotation

    .prologue
    .line 14
    .local p0, "this":Lcom/amazon/ansel/fetch/UriLoader;, "Lcom/amazon/ansel/fetch/UriLoader<TResult;>;"
    .local p2, "resultClass":Ljava/lang/Class;, "Ljava/lang/Class<TResult;>;"
    .local p3, "listenerReference":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/ResourceListener<TResult;>;>;"
    invoke-direct/range {p0 .. p5}, Lcom/amazon/ansel/fetch/ResourceLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Class;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;J)V

    .line 15
    iput-object p6, p0, Lcom/amazon/ansel/fetch/UriLoader;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    .line 16
    return-void
.end method


# virtual methods
.method public getResourceRequest()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/ansel/fetch/UriLoader;, "Lcom/amazon/ansel/fetch/UriLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriLoader;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    return-object v0
.end method
