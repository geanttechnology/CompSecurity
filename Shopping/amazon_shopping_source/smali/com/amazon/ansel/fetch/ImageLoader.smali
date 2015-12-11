.class public Lcom/amazon/ansel/fetch/ImageLoader;
.super Lcom/amazon/ansel/fetch/UriLoader;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/UriLoader",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;JLcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 6
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p2, "priority"    # J
    .param p4, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;

    .prologue
    .line 43
    const/4 v2, 0x0

    check-cast v2, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/ResourceListener;JLcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 6
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p3, "priority"    # J
    .param p5, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/LoaderContext;",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;J",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ")V"
        }
    .end annotation

    .prologue
    .line 31
    .local p2, "listener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p1, p2}, Lcom/amazon/ansel/fetch/LoaderContext;->newResourceListenerReference(Lcom/amazon/ansel/fetch/ResourceListener;)Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    move-result-object v2

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p3

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 7
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p3, "priority"    # J
    .param p5, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/LoaderContext;",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;>;J",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ")V"
        }
    .end annotation

    .prologue
    .line 15
    .local p2, "listenerReference":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;>;"
    const-class v2, Landroid/graphics/Bitmap;

    invoke-virtual {p5}, Lcom/amazon/ansel/fetch/ImageRequest;->getUriRequest()Lcom/amazon/ansel/fetch/UriRequest;

    move-result-object v6

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/ansel/fetch/UriLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Class;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/UriRequest;)V

    .line 23
    iput-object p5, p0, Lcom/amazon/ansel/fetch/ImageLoader;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 24
    return-void
.end method


# virtual methods
.method public getResourceRequest()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ImageLoader;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    return-object v0
.end method

.method public newLoaderTask()Lcom/amazon/ansel/fetch/LoaderTask;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 62
    new-instance v0, Lcom/amazon/ansel/fetch/ImageTask;

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ImageLoader;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ImageLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ImageLoader;->getPriority()J

    move-result-wide v3

    iget-object v5, p0, Lcom/amazon/ansel/fetch/ImageLoader;->imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageTask;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;JLcom/amazon/ansel/fetch/ImageRequest;)V

    return-object v0
.end method
