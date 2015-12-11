.class public Lco/vine/android/ConversationAdapter$BlurRunnable;
.super Ljava/lang/Object;
.source "ConversationAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BlurRunnable"
.end annotation


# instance fields
.field private final bitmap:Landroid/graphics/Bitmap;

.field private final imageView:Landroid/widget/ImageView;

.field private setImage:Z

.field final synthetic this$0:Lco/vine/android/ConversationAdapter;


# direct methods
.method public constructor <init>(Lco/vine/android/ConversationAdapter;Landroid/graphics/Bitmap;Landroid/widget/ImageView;)V
    .locals 0
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 1292
    iput-object p1, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1293
    iput-object p2, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->bitmap:Landroid/graphics/Bitmap;

    .line 1294
    iput-object p3, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->imageView:Landroid/widget/ImageView;

    .line 1295
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1299
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lco/vine/android/ConversationAdapter;->access$1300(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1300
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->createDefaultSizeBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    # setter for: Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;
    invoke-static {v0, v1}, Lco/vine/android/ConversationAdapter;->access$1302(Lco/vine/android/ConversationAdapter;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    .line 1302
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mRsBlur:Lco/vine/android/recorder/RsBlur;
    invoke-static {v0}, Lco/vine/android/ConversationAdapter;->access$1400(Lco/vine/android/ConversationAdapter;)Lco/vine/android/recorder/RsBlur;

    move-result-object v0

    if-nez v0, :cond_1

    .line 1303
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    new-instance v1, Lco/vine/android/recorder/RsBlur;

    iget-object v2, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;
    invoke-static {v2}, Lco/vine/android/ConversationAdapter;->access$000(Lco/vine/android/ConversationAdapter;)Lco/vine/android/ConversationActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v8/renderscript/RenderScript;->create(Landroid/content/Context;)Landroid/support/v8/renderscript/RenderScript;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;
    invoke-static {v3}, Lco/vine/android/ConversationAdapter;->access$1300(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;

    move-result-object v3

    const/high16 v4, 0x41c80000    # 25.0f

    invoke-direct {v1, v2, v3, v4}, Lco/vine/android/recorder/RsBlur;-><init>(Landroid/support/v8/renderscript/RenderScript;Landroid/graphics/Bitmap;F)V

    # setter for: Lco/vine/android/ConversationAdapter;->mRsBlur:Lco/vine/android/recorder/RsBlur;
    invoke-static {v0, v1}, Lco/vine/android/ConversationAdapter;->access$1402(Lco/vine/android/ConversationAdapter;Lco/vine/android/recorder/RsBlur;)Lco/vine/android/recorder/RsBlur;

    .line 1305
    :cond_1
    iget-boolean v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->setImage:Z

    if-eqz v0, :cond_2

    .line 1306
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->imageView:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;
    invoke-static {v1}, Lco/vine/android/ConversationAdapter;->access$1300(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 1312
    :goto_0
    return-void

    .line 1308
    :cond_2
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mRsBlur:Lco/vine/android/recorder/RsBlur;
    invoke-static {v0}, Lco/vine/android/ConversationAdapter;->access$1400(Lco/vine/android/ConversationAdapter;)Lco/vine/android/recorder/RsBlur;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->bitmap:Landroid/graphics/Bitmap;

    iget-object v2, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;
    invoke-static {v2}, Lco/vine/android/ConversationAdapter;->access$1300(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;

    move-result-object v2

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/recorder/RsBlur;->execute(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;I)V

    .line 1309
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->setImage:Z

    .line 1310
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$BlurRunnable;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/ConversationAdapter;->access$1500(Lco/vine/android/ConversationAdapter;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
