.class Lcom/poshmark/ui/customviews/RoundedImageView$1;
.super Ljava/lang/Object;
.source "RoundedImageView.java"

# interfaces
.implements Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/RoundedImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/RoundedImageView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/RoundedImageView;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadingCancelled(Ljava/lang/String;Landroid/view/View;)V
    .locals 3
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 199
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 200
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImageSync(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    # setter for: Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;
    invoke-static {v1, v2}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$002(Lcom/poshmark/ui/customviews/RoundedImageView;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 201
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    # getter for: Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z
    invoke-static {v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$100(Lcom/poshmark/ui/customviews/RoundedImageView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 202
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 204
    :cond_0
    return-void
.end method

.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 191
    iget-object v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    # setter for: Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;
    invoke-static {v0, p3}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$002(Lcom/poshmark/ui/customviews/RoundedImageView;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 192
    iget-object v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    # getter for: Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z
    invoke-static {v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$100(Lcom/poshmark/ui/customviews/RoundedImageView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 195
    :cond_0
    return-void
.end method

.method public onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/universalimageloader/core/assist/FailReason;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "failReason"    # Lcom/nostra13/universalimageloader/core/assist/FailReason;

    .prologue
    .line 187
    return-void
.end method

.method public onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V
    .locals 5
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "ic_user_default"

    const-string v3, "drawable"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 178
    .local v0, "id":I
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    # setter for: Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;
    invoke-static {v1, v2}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$002(Lcom/poshmark/ui/customviews/RoundedImageView;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 179
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    # getter for: Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z
    invoke-static {v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->access$100(Lcom/poshmark/ui/customviews/RoundedImageView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 180
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView$1;->this$0:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 182
    :cond_0
    return-void
.end method
