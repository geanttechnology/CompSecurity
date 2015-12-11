.class public Lcom/amazon/ansel/fetch/ResourceProvider;
.super Lcom/amazon/ansel/fetch/LoaderGroup;
.source "ResourceProvider.java"


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;

    .prologue
    .line 7
    invoke-direct {p0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;)V

    .line 8
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderGroup;)V
    .locals 0
    .param p1, "parent"    # Lcom/amazon/ansel/fetch/LoaderGroup;

    .prologue
    .line 11
    invoke-direct {p0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup;-><init>(Lcom/amazon/ansel/fetch/LoaderGroup;)V

    .line 12
    return-void
.end method


# virtual methods
.method public getImage(Lcom/amazon/ansel/fetch/ImageRequest;Lcom/amazon/ansel/fetch/ResourceListener;)V
    .locals 6
    .param p1, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p2, "imageListener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    const-wide/16 v3, 0x0

    move-object v2, p2

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/ResourceListener;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 20
    .local v0, "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    invoke-virtual {p0, v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    .line 21
    return-void
.end method
