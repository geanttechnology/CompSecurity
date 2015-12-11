.class Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field mActivity:Ljava/lang/ref/WeakReference;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding;)V
    .locals 1

    .prologue
    .line 251
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 252
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->mActivity:Ljava/lang/ref/WeakReference;

    .line 253
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x4

    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 257
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->mActivity:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/Onboarding;

    .line 258
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 259
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 281
    :goto_0
    return-void

    .line 261
    :pswitch_0
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    .line 262
    invoke-virtual {v1, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    .line 263
    rem-int/lit8 v2, v2, 0x2

    if-nez v2, :cond_0

    .line 264
    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS1:Landroid/widget/ImageView;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 267
    :goto_1
    invoke-virtual {v1, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    .line 268
    rem-int/lit8 v2, v2, 0x2

    if-nez v2, :cond_1

    .line 269
    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS2:Landroid/widget/ImageView;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 272
    :goto_2
    invoke-virtual {v1, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    .line 273
    rem-int/lit8 v1, v1, 0x2

    if-nez v1, :cond_2

    .line 274
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS3:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 277
    :goto_3
    invoke-virtual {p0, v6}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->removeMessages(I)V

    .line 278
    const-wide/16 v0, 0x1f4

    invoke-virtual {p0, v6, v0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    .line 266
    :cond_0
    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS1:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1

    .line 271
    :cond_1
    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS2:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 276
    :cond_2
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS3:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_3

    .line 259
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
