.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->popuWindow(ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

.field private final synthetic val$mHas_apk:Ljava/lang/String;

.field private final synthetic val$myPosition:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    iput-object p3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$mHas_apk:Ljava/lang/String;

    .line 658
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    .locals 1

    .prologue
    .line 658
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x1

    .line 663
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$2(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 664
    const-string v4, "appname"

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v3, v4, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 665
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 666
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$mHas_apk:Ljava/lang/String;

    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 668
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-direct {v3, p0, v4}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$1;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;I)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 678
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 679
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$10(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "isopen"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 681
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v2

    if-eq v2, v6, :cond_0

    .line 682
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # invokes: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->downwifi()V
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$11(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V

    .line 736
    :goto_0
    return-void

    .line 687
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$12(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v3

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_2

    .line 688
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v4

    .line 689
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v5

    .line 690
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v6

    .line 691
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v7, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v2

    .line 688
    invoke-virtual {v3, v4, v5, v6, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 728
    :cond_1
    :goto_1
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$3;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 696
    :cond_2
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v2

    .line 697
    const-string v3, "It has been in downloading list already."

    .line 698
    const/4 v4, 0x1

    .line 696
    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 698
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 700
    :catch_0
    move-exception v2

    goto :goto_1

    .line 706
    :cond_3
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$mHas_apk:Ljava/lang/String;

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 707
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$2;

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-direct {v3, p0, v4}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$2;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;I)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 721
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 723
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "https://play.google.com/store/apps/details?id="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 724
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->val$myPosition:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 723
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 725
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 726
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method
