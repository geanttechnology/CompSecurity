.class Lcom/aio/downloader/activity/PaidforFreeActivity1$1;
.super Landroid/os/Handler;
.source "PaidforFreeActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/PaidforFreeActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/PaidforFreeActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$1;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 130
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 135
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 136
    iget v1, p1, Landroid/os/Message;->what:I

    const/16 v2, 0x7530

    if-ne v1, v2, :cond_0

    .line 137
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 138
    iget-object v3, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$1;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetClickTime(Landroid/content/Context;)J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 139
    iget-object v1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$1;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$0(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    const v2, 0x7f0200d8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 141
    iget-object v1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$1;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f04001e

    .line 140
    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 142
    .local v0, "shake":Landroid/view/animation/Animation;
    iget-object v1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$1;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$0(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 145
    .end local v0    # "shake":Landroid/view/animation/Animation;
    :cond_0
    return-void
.end method
