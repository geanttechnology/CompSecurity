.class Lcom/aio/downloader/cleaner/RubActivity$8;
.super Landroid/os/AsyncTask;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 602
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;
    .locals 1

    .prologue
    .line 602
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/cleaner/RubActivity$8;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 608
    const-wide/16 v5, 0x64

    :try_start_0
    invoke-static {v5, v6}, Ljava/lang/Thread;->sleep(J)V

    .line 609
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pm:Landroid/content/pm/PackageManager;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$28(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 610
    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v2

    .line 611
    .local v2, "packinfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pb:Landroid/widget/ProgressBar;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$29(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ProgressBar;

    move-result-object v5

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 612
    const/4 v4, 0x0

    .line 613
    .local v4, "total":I
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_0

    .line 625
    .end local v2    # "packinfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    .end local v4    # "total":I
    :goto_1
    const/4 v5, 0x0

    return-object v5

    .line 613
    .restart local v2    # "packinfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    .restart local v4    # "total":I
    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 614
    .local v1, "packinfo":Landroid/content/pm/PackageInfo;
    iget-object v3, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 615
    .local v3, "packname":Ljava/lang/String;
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v6, v3}, Lcom/aio/downloader/cleaner/RubActivity;->getCacheInfo(Ljava/lang/String;)V

    .line 616
    add-int/lit8 v4, v4, 0x1

    .line 618
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pb:Landroid/widget/ProgressBar;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$29(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ProgressBar;

    move-result-object v6

    invoke-virtual {v6, v4}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 619
    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    invoke-virtual {p0, v6}, Lcom/aio/downloader/cleaner/RubActivity$8;->publishProgress([Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 622
    .end local v1    # "packinfo":Landroid/content/pm/PackageInfo;
    .end local v2    # "packinfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    .end local v3    # "packname":Ljava/lang/String;
    .end local v4    # "total":I
    :catch_0
    move-exception v0

    .line 623
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/cleaner/RubActivity$8;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    const/16 v2, 0x8

    const/4 v5, 0x1

    .line 636
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_status:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$30(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "Complete"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 638
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # invokes: Lcom/aio/downloader/cleaner/RubActivity;->killTask()V
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$31(Lcom/aio/downloader/cleaner/RubActivity;)V

    .line 639
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->bt_process_ing:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$32(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 640
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->bt_process_finish_rub:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$33(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 642
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc_rub1:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$34(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 643
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_jieguo_rub:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$35(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$36(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 644
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$36(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v1

    int-to-double v1, v1

    const-wide/high16 v3, 0x4090000000000000L    # 1024.0

    div-double/2addr v1, v3

    const/4 v3, 0x2

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$9(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/Double;)V

    .line 647
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-static {v0, v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$37(Lcom/aio/downloader/cleaner/RubActivity;Z)V

    .line 648
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$8$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$8$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$8;)V

    .line 688
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/RubActivity$8$1;->start()V

    .line 690
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-static {v0, v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$43(Lcom/aio/downloader/cleaner/RubActivity;Z)V

    .line 691
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$8$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$8$2;-><init>(Lcom/aio/downloader/cleaner/RubActivity$8;)V

    .line 721
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/RubActivity$8$2;->start()V

    .line 723
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 724
    return-void
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 631
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 632
    return-void
.end method

.method protected varargs onProgressUpdate([Ljava/lang/Object;)V
    .locals 5
    .param p1, "values"    # [Ljava/lang/Object;

    .prologue
    .line 728
    const/4 v1, 0x0

    aget-object v0, p1, v1

    check-cast v0, Landroid/content/pm/PackageInfo;

    .line 729
    .local v0, "packinfo":Landroid/content/pm/PackageInfo;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_status:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$30(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Scanning:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 730
    iget-object v3, v0, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pm:Landroid/content/pm/PackageManager;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$28(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/pm/PackageManager;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 729
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 731
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v1, v0, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pm:Landroid/content/pm/PackageManager;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/RubActivity;->access$28(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v2, v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$47(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/String;)V

    .line 733
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onProgressUpdate([Ljava/lang/Object;)V

    .line 734
    return-void
.end method
