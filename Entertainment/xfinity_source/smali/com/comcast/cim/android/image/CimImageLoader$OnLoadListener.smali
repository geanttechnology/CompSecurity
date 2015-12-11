.class public interface abstract Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
.super Ljava/lang/Object;
.source "CimImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/image/CimImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnLoadListener"
.end annotation


# virtual methods
.method public abstract onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
.end method

.method public abstract onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
.end method
