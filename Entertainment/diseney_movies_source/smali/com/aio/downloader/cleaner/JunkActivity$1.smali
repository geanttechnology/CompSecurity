.class Lcom/aio/downloader/cleaner/JunkActivity$1;
.super Landroid/os/Handler;
.source "JunkActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/JunkActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 81
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 16
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 86
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    .line 87
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    invoke-static {v2, v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$0(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 88
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->nc_pb:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$1(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 89
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_ncall:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$2(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 90
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allok:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$4(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 91
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$5(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 177
    :cond_0
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allok:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    .line 179
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->bt_stop:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$42(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 180
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$43(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 181
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->tv_scan:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$13(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 182
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rub_center:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$44(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Selected junk:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 183
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v5}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v5

    add-long/2addr v3, v5

    .line 184
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v5}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v5

    .line 183
    add-long/2addr v3, v5

    .line 184
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v5}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v5

    .line 183
    add-long/2addr v3, v5

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 182
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 186
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 187
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 188
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 189
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 190
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v1, v1, Lcom/aio/downloader/cleaner/JunkActivity;->sticky_content:Landroid/widget/ScrollView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 191
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->content_two:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$46(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/LinearLayout;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 193
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    new-instance v1, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$47(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$16(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v3

    .line 194
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$33(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/JunkActivity;->access$26(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/JunkActivity;->access$48(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-virtual {v7}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    .line 195
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v8}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v9}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->l:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v10}, Lcom/aio/downloader/cleaner/JunkActivity;->access$50(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v10

    invoke-direct/range {v1 .. v10}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;-><init>(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;[Ljava/lang/String;Landroid/content/Context;Lcom/xiaos/view/PinnedHeaderExpandableListView;[Ljava/lang/String;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;)V

    .line 193
    invoke-static {v15, v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$51(Lcom/aio/downloader/cleaner/JunkActivity;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)V

    .line 196
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$52(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 198
    :cond_1
    return-void

    .line 96
    :cond_2
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_3

    .line 97
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$7(Lcom/aio/downloader/cleaner/JunkActivity;J)V

    .line 98
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->bost_num:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$8(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 99
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$9(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    .line 100
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    .line 99
    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 101
    :cond_3
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/16 v2, 0x16

    if-ne v1, v2, :cond_4

    .line 102
    move-object/from16 v0, p1

    iget-object v11, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v11, Lcom/wjj/eneity/RuningApp;

    .line 103
    .local v11, "app":Lcom/wjj/eneity/RuningApp;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->tv_scan:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$13(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Scanning:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v11, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 105
    .end local v11    # "app":Lcom/wjj/eneity/RuningApp;
    :cond_4
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_5

    .line 106
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    invoke-static {v2, v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$14(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 107
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$15(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCacheAdapter;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$16(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/wjj/adapter/base/JunkCacheAdapter;->addData(Ljava/util/List;Z)V

    .line 108
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$15(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCacheAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wjj/adapter/base/JunkCacheAdapter;->notifyDataSetChanged()V

    .line 109
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->progressBarcache:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$17(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 110
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_cacheall:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$18(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 111
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allok:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$4(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 112
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$19(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    goto/16 :goto_0

    .line 117
    :cond_5
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x4

    if-ne v1, v2, :cond_6

    .line 118
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$20(Lcom/aio/downloader/cleaner/JunkActivity;J)V

    .line 119
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cache_num:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$21(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$9(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    .line 121
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    .line 120
    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 122
    :cond_6
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x5

    if-ne v1, v2, :cond_8

    .line 123
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    invoke-static {v2, v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$22(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 124
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lt v13, v1, :cond_7

    .line 134
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$27(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCanliuAdapter;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$26(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/wjj/adapter/base/JunkCanliuAdapter;->addData(Ljava/util/List;Z)V

    .line 135
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$27(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCanliuAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wjj/adapter/base/JunkCanliuAdapter;->notifyDataSetChanged()V

    .line 136
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->pb_canliu:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$28(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 137
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_canliuall:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$29(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 138
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$9(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    .line 139
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    .line 138
    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allok:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$4(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 141
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$30(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    goto/16 :goto_0

    .line 125
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$24(Lcom/aio/downloader/cleaner/JunkActivity;J)V

    .line 126
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->canliu_num:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$25(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 127
    new-instance v12, Lcom/wjj/eneity/Canliu;

    invoke-direct {v12}, Lcom/wjj/eneity/Canliu;-><init>()V

    .line 128
    .local v12, "cc":Lcom/wjj/eneity/Canliu;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v12, Lcom/wjj/eneity/Canliu;->runingsoftname:Ljava/lang/String;

    .line 129
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v1

    iput-wide v1, v12, Lcom/wjj/eneity/Canliu;->memory:J

    .line 130
    const/4 v1, 0x1

    iput-boolean v1, v12, Lcom/wjj/eneity/Canliu;->ischecked:Z

    .line 131
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v12, Lcom/wjj/eneity/Canliu;->path:Ljava/lang/String;

    .line 132
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$26(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 124
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_1

    .line 146
    .end local v12    # "cc":Lcom/wjj/eneity/Canliu;
    .end local v13    # "i":I
    :cond_8
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/16 v2, 0x3ba

    if-ne v1, v2, :cond_c

    .line 148
    const/4 v13, 0x0

    .restart local v13    # "i":I
    :goto_2
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$31(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-lt v13, v1, :cond_9

    .line 157
    :goto_3
    const/4 v14, 0x0

    .local v14, "j":I
    :goto_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$32(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lt v14, v1, :cond_b

    .line 160
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$36(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/ApkSoftAdapter;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$33(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/wjj/adapter/base/ApkSoftAdapter;->addData(Ljava/util/List;Z)V

    .line 161
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$36(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/ApkSoftAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wjj/adapter/base/ApkSoftAdapter;->notifyDataSetChanged()V

    .line 162
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->pb_apk:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$37(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 163
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_apkall:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$38(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 164
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allok:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$4(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 165
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$39(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    goto/16 :goto_0

    .line 149
    .end local v14    # "j":I
    :cond_9
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 150
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$31(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 151
    const/4 v3, 0x1

    .line 150
    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 149
    if-eqz v1, :cond_a

    .line 152
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$32(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$31(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 148
    :cond_a
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_2

    .line 158
    .restart local v14    # "j":I
    :cond_b
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$33(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->sm:Lcom/wjj/manager/SoftApkManager;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$34(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/SoftApkManager;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->smListener:Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$35(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$32(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Lcom/wjj/manager/SoftApkManager;->GetAllApk2(Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;Ljava/lang/String;)Lcom/wjj/eneity/SoftApk;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 157
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_4

    .line 170
    .end local v13    # "i":I
    .end local v14    # "j":I
    :cond_c
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->what:I

    const/4 v2, 0x7

    if-ne v1, v2, :cond_0

    .line 171
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v3

    move-object/from16 v0, p1

    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$40(Lcom/aio/downloader/cleaner/JunkActivity;J)V

    .line 172
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apk_num:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$41(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 173
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$9(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v2

    .line 174
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/cleaner/JunkActivity$1;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J

    move-result-wide v4

    add-long/2addr v2, v4

    .line 173
    invoke-static {v2, v3}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 155
    .restart local v13    # "i":I
    :catch_0
    move-exception v1

    goto/16 :goto_3
.end method
