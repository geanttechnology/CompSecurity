.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;
.super Landroid/os/Handler;
.source "PhoneBoostActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 65
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x1

    .line 67
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x6

    if-eq v0, v1, :cond_0

    .line 70
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 71
    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    invoke-static {v1, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$0(Lcom/aio/downloader/cleaner/PhoneBoostActivity;Ljava/util/List;)V

    .line 72
    const-string v0, "toggletag"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "listdata="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$2(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/adapter/base/BoostPhoneAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Lcom/wjj/adapter/base/BoostPhoneAdapter;->addData(Ljava/util/List;Z)V

    .line 74
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$2(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/adapter/base/BoostPhoneAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wjj/adapter/base/BoostPhoneAdapter;->notifyDataSetChanged()V

    .line 99
    :cond_0
    :goto_0
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_0

    .line 162
    :goto_1
    return-void

    .line 75
    :cond_1
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v3, :cond_2

    .line 76
    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J

    move-result-wide v2

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    add-long/2addr v2, v4

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$4(Lcom/aio/downloader/cleaner/PhoneBoostActivity;J)V

    .line 77
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$5(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/wjj/manager/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_danwei:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$6(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/wjj/manager/CommonUtil;->formatSizeDanweiTwo(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 80
    :cond_2
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 81
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->num:I
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$7(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$8(Lcom/aio/downloader/cleaner/PhoneBoostActivity;I)V

    .line 82
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_new:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$9(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->num:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$7(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 84
    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/wjj/eneity/RuningApp;

    invoke-static {v1, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$10(Lcom/aio/downloader/cleaner/PhoneBoostActivity;Lcom/wjj/eneity/RuningApp;)V

    .line 85
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_clean_cache_status:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$11(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Scan:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->app:Lcom/wjj/eneity/RuningApp;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$12(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/eneity/RuningApp;

    move-result-object v2

    iget-object v2, v2, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 87
    :cond_3
    iget v0, p1, Landroid/os/Message;->what:I

    if-nez v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->isover:I
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$13(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 89
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_stop:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$14(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 90
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$15(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 92
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_clean_cache_status:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$11(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 93
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->total_memory:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$16(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Selected memory:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 94
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/manager/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 95
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/manager/CommonUtil;->formatSizeDanweiTwo(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 93
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 101
    :sswitch_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#3E56B1"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 104
    :sswitch_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#3B62A8"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 107
    :sswitch_2
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#3967A4"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 110
    :sswitch_3
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#386BA1"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 113
    :sswitch_4
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#376F9E"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 116
    :sswitch_5
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#36739B"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 119
    :sswitch_6
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#357699"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 122
    :sswitch_7
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#347A96"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 125
    :sswitch_8
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#337C94"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 128
    :sswitch_9
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#337F92"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 131
    :sswitch_a
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#31848E"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 134
    :sswitch_b
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#30878C"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 137
    :sswitch_c
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2F8B89"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 140
    :sswitch_d
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2E9085"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 143
    :sswitch_e
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2D9482"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 146
    :sswitch_f
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2C997E"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 149
    :sswitch_10
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2C9E7A"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 152
    :sswitch_11
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2CA277"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 155
    :sswitch_12
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2CA574"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 158
    :sswitch_13
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const-string v1, "#2CA971"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 99
    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_0
        0x14 -> :sswitch_1
        0x1e -> :sswitch_2
        0x28 -> :sswitch_3
        0x32 -> :sswitch_4
        0x3c -> :sswitch_5
        0x46 -> :sswitch_6
        0x50 -> :sswitch_7
        0x5a -> :sswitch_8
        0x64 -> :sswitch_9
        0x6e -> :sswitch_a
        0x78 -> :sswitch_b
        0x82 -> :sswitch_c
        0x8c -> :sswitch_d
        0x96 -> :sswitch_e
        0xa0 -> :sswitch_f
        0xaa -> :sswitch_10
        0xb4 -> :sswitch_11
        0xbe -> :sswitch_12
        0xc8 -> :sswitch_13
    .end sparse-switch
.end method
