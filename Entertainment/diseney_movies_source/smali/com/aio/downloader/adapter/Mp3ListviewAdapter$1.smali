.class Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;
.super Ljava/lang/Object;
.source "Mp3ListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 235
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    .line 239
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "appname"

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 240
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$1;

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$1;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 250
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 252
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$1(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "isopen"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 255
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # invokes: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->downwifi()V
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$3(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V

    .line 332
    :goto_0
    return-void

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$4(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 261
    new-instance v0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;

    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    new-array v1, v3, [Ljava/lang/Void;

    .line 326
    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 329
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # invokes: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$7(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V

    goto :goto_0
.end method
