.class Lcom/livemixtapes/ImageLoader$BitmapDisplayer;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "BitmapDisplayer"
.end annotation


# instance fields
.field bitmap:Landroid/graphics/Bitmap;

.field photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

.field final synthetic this$0:Lcom/livemixtapes/ImageLoader;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/ImageLoader;Landroid/graphics/Bitmap;Lcom/livemixtapes/ImageLoader$PhotoToLoad;)V
    .locals 0
    .param p2, "b"    # Landroid/graphics/Bitmap;
    .param p3, "p"    # Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    .prologue
    .line 180
    iput-object p1, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->this$0:Lcom/livemixtapes/ImageLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 181
    iput-object p2, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->bitmap:Landroid/graphics/Bitmap;

    .line 182
    iput-object p3, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    .line 183
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 186
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v1, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ImageLoader;->imageViewReused(Lcom/livemixtapes/ImageLoader$PhotoToLoad;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    :goto_0
    return-void

    .line 188
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_1

    .line 189
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    iget-object v0, v0, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->imageView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 191
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    iget-object v0, v0, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->imageView:Landroid/widget/ImageView;

    const v1, 0x7f0200ec

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
