.class Lcom/aio/downloader/cleaner/RubActivity$1;
.super Landroid/os/Handler;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/RubActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 108
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 11
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 111
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$0(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v6

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 112
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->scanningtv:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$1(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 113
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$2(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 114
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$2(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/Button;->performClick()Z

    .line 115
    iget v6, p1, Landroid/os/Message;->what:I

    sparse-switch v6, :sswitch_data_0

    .line 304
    :goto_0
    :sswitch_0
    return-void

    .line 117
    :sswitch_1
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    new-instance v7, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {v7, v8}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/RubActivity;->access$3(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;)V

    .line 118
    new-instance v5, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 119
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$4(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    move-result-object v6

    .line 118
    invoke-direct {v5, v6}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 120
    .local v5, "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$5(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ListView;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 121
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$5(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ListView;

    move-result-object v6

    invoke-virtual {v6, v5}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 124
    new-instance v4, Lcom/aio/downloader/cleaner/RubActivity$memInfo;

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {v4, v6}, Lcom/aio/downloader/cleaner/RubActivity$memInfo;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    .line 125
    .local v4, "info":Lcom/aio/downloader/cleaner/RubActivity$memInfo;
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->getmem_TOLAL()J

    move-result-wide v0

    .line 127
    .local v0, "getmem_TOLAL":J
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/cleaner/RubActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v4, v6}, Lcom/aio/downloader/cleaner/RubActivity$memInfo;->getmem_UNUSED(Landroid/content/Context;)J

    move-result-wide v2

    .line 128
    .local v2, "getmem_UNUSED":J
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    sub-long v7, v0, v2

    invoke-static {v6, v7, v8}, Lcom/aio/downloader/cleaner/RubActivity;->access$6(Lcom/aio/downloader/cleaner/RubActivity;J)V

    .line 129
    const-string v6, "www"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "getmem_UNUSED="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "getmem_TOLAL="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 130
    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 129
    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 131
    const-string v6, "www"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "handler="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v8, v8, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    long-to-int v6, v6

    div-int/lit16 v6, v6, 0x400

    int-to-double v6, v6

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/RubActivity;->access$7(D)V

    .line 135
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    const-wide/16 v8, 0x400

    div-long/2addr v6, v8

    const-wide/16 v8, 0x400

    div-long/2addr v6, v8

    const-wide/16 v8, 0x1

    cmp-long v6, v6, v8

    if-ltz v6, :cond_0

    .line 136
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$8(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "GB"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 137
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v7, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v7, v7, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    long-to-double v7, v7

    const-wide/high16 v9, 0x4090000000000000L    # 1024.0

    div-double/2addr v7, v9

    const-wide/high16 v9, 0x4090000000000000L    # 1024.0

    div-double/2addr v7, v9

    .line 138
    const/4 v9, 0x2

    .line 137
    invoke-static {v7, v8, v9}, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/RubActivity;->access$9(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/Double;)V

    .line 139
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->roundDouble:Ljava/lang/Double;
    invoke-static {v8}, Lcom/aio/downloader/cleaner/RubActivity;->access$11(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/lang/Double;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 141
    :cond_0
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$8(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "MB"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 142
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v7, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v7, v7, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    long-to-double v7, v7

    const-wide/high16 v9, 0x4090000000000000L    # 1024.0

    div-double/2addr v7, v9

    const/4 v9, 0x2

    invoke-static {v7, v8, v9}, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/RubActivity;->access$9(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/Double;)V

    .line 143
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->roundDouble:Ljava/lang/Double;
    invoke-static {v8}, Lcom/aio/downloader/cleaner/RubActivity;->access$11(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/lang/Double;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 153
    .end local v0    # "getmem_TOLAL":J
    .end local v2    # "getmem_UNUSED":J
    .end local v4    # "info":Lcom/aio/downloader/cleaner/RubActivity$memInfo;
    .end local v5    # "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    :sswitch_2
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->iv_ok1:Landroid/widget/ImageView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$12(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ImageView;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 154
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->iv_ok1:Landroid/widget/ImageView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$12(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ImageView;

    move-result-object v6

    .line 155
    iget-object v7, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v7}, Lcom/aio/downloader/cleaner/RubActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const v8, 0x7f040021

    .line 154
    invoke-static {v7, v8}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 157
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->releasedtime:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$13(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 159
    new-instance v6, Lcom/aio/downloader/cleaner/RubActivity$1$1;

    invoke-direct {v6, p0}, Lcom/aio/downloader/cleaner/RubActivity$1$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$1;)V

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Void;

    .line 300
    invoke-virtual {v6, v7}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 115
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_0
        0x3 -> :sswitch_0
        0xc8 -> :sswitch_2
    .end sparse-switch
.end method
