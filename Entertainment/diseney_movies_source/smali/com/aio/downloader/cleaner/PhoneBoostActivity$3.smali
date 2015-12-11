.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;
.super Ljava/lang/Thread;
.source "PhoneBoostActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;->asyPb()V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 193
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/16 v8, 0x32

    const/16 v7, 0x28

    const/16 v6, 0x1e

    const/16 v5, 0x14

    const/16 v4, 0xa

    .line 195
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    const/16 v2, 0x65

    if-lt v1, v2, :cond_0

    .line 296
    return-void

    .line 197
    :cond_0
    const-wide/16 v2, 0xf

    :try_start_0
    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 201
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 203
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/4 v3, 0x5

    if-ne v2, v3, :cond_1

    .line 204
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 206
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    if-ne v2, v4, :cond_2

    .line 207
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 209
    :cond_2
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0xf

    if-ne v2, v3, :cond_3

    .line 211
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 214
    :cond_3
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    if-ne v2, v5, :cond_4

    .line 216
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 219
    :cond_4
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x19

    if-ne v2, v3, :cond_5

    .line 221
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v8}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 224
    :cond_5
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    if-ne v2, v6, :cond_6

    .line 226
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x3c

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 229
    :cond_6
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x23

    if-ne v2, v3, :cond_7

    .line 231
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x46

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 234
    :cond_7
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    if-ne v2, v7, :cond_8

    .line 236
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x50

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 239
    :cond_8
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x2d

    if-ne v2, v3, :cond_9

    .line 241
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x5a

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 244
    :cond_9
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    if-ne v2, v8, :cond_a

    .line 246
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x64

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 249
    :cond_a
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x37

    if-ne v2, v3, :cond_b

    .line 251
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x6e

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 254
    :cond_b
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x3c

    if-ne v2, v3, :cond_c

    .line 256
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x78

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 259
    :cond_c
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x41

    if-ne v2, v3, :cond_d

    .line 261
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x82

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 264
    :cond_d
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x46

    if-ne v2, v3, :cond_e

    .line 266
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x8c

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 269
    :cond_e
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x4b

    if-ne v2, v3, :cond_f

    .line 271
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0x96

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 274
    :cond_f
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x50

    if-ne v2, v3, :cond_10

    .line 276
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0xa0

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 279
    :cond_10
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x55

    if-ne v2, v3, :cond_11

    .line 281
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0xaa

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 284
    :cond_11
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x5a

    if-ne v2, v3, :cond_12

    .line 286
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0xb4

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 289
    :cond_12
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x5f

    if-ne v2, v3, :cond_13

    .line 290
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0xbe

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 292
    :cond_13
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v2

    const/16 v3, 0x64

    if-ne v2, v3, :cond_14

    .line 293
    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v2

    const/16 v3, 0xc8

    invoke-virtual {v2, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 195
    :cond_14
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 198
    :catch_0
    move-exception v0

    .line 199
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto/16 :goto_1
.end method
