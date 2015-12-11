.class public interface abstract Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
.super Ljava/lang/Object;
.source "DrawableFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/DrawableFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "DrawableFactoryInterface"
.end annotation


# virtual methods
.method public abstract createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/res/Resources;",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Landroid/graphics/drawable/Drawable;"
        }
    .end annotation
.end method

.method public abstract getDefaultDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
.end method

.method public abstract resetDefaultImage()V
.end method
