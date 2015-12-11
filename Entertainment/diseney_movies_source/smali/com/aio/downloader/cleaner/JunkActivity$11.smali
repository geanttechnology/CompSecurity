.class Lcom/aio/downloader/cleaner/JunkActivity$11;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/JunkActivity;->showNormal3()V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 624
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 11
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 630
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->bt_stop:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$42(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 631
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$43(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 633
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->nc_pb:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$1(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 634
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_ncall:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$2(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 636
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->progressBarcache:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$17(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 637
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_cacheall:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$18(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 639
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->pb_canliu:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$28(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 640
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_canliuall:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$29(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 642
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->pb_apk:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$37(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 643
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->iv_apkall:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$38(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 645
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v0, v0, Lcom/aio/downloader/cleaner/JunkActivity;->sticky_content:Landroid/widget/ScrollView;

    invoke-virtual {v0, v2}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 646
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->content_two:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$46(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 647
    iget-object v10, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    new-instance v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    .line 648
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$47(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$16(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$33(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/JunkActivity;->access$26(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v4

    .line 649
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/JunkActivity;->access$48(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-virtual {v6}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 650
    iget-object v7, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v7}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v7

    iget-object v8, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;
    invoke-static {v8}, Lcom/aio/downloader/cleaner/JunkActivity;->access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->l:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v9}, Lcom/aio/downloader/cleaner/JunkActivity;->access$50(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;-><init>(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;[Ljava/lang/String;Landroid/content/Context;Lcom/xiaos/view/PinnedHeaderExpandableListView;[Ljava/lang/String;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;)V

    .line 647
    invoke-static {v10, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$51(Lcom/aio/downloader/cleaner/JunkActivity;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)V

    .line 651
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$11;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$52(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 652
    return-void
.end method
