.class Lcom/aio/downloader/activity/TodaysPickActivity$1;
.super Landroid/os/Handler;
.source "TodaysPickActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/TodaysPickActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/TodaysPickActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 121
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 126
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 127
    iget v1, p1, Landroid/os/Message;->what:I

    const/16 v2, 0x7530

    if-ne v1, v2, :cond_0

    .line 128
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 129
    iget-object v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity$1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetClickTime(Landroid/content/Context;)J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 130
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$0(Lcom/aio/downloader/activity/TodaysPickActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const v2, 0x7f0200d8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 132
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f04001e

    .line 131
    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 133
    .local v0, "shake":Landroid/view/animation/Animation;
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$0(Lcom/aio/downloader/activity/TodaysPickActivity;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 136
    .end local v0    # "shake":Landroid/view/animation/Animation;
    :cond_0
    return-void
.end method
