.class public interface abstract Lcom/amazon/retailsearch/data/assets/AssetsLoader;
.super Ljava/lang/Object;
.source "AssetsLoader.java"


# virtual methods
.method public abstract clear()V
.end method

.method public abstract getBadges()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end method

.method public abstract load(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
.end method
