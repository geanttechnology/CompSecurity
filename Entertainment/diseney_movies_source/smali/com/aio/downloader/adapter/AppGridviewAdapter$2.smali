.class Lcom/aio/downloader/adapter/AppGridviewAdapter$2;
.super Ljava/lang/Object;
.source "AppGridviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppGridviewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

.field private final synthetic val$has_apk:Ljava/lang/String;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iput-object p3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$has_apk:Ljava/lang/String;

    .line 284
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x1

    .line 288
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$2(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "appname"

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 289
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$has_apk:Ljava/lang/String;

    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 291
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/adapter/AppGridviewAdapter$2$1;

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3, p0, v4}, Lcom/aio/downloader/adapter/AppGridviewAdapter$2$1;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter$2;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 297
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 298
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$4(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "isopen"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 300
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v2

    if-eq v2, v5, :cond_1

    .line 301
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # invokes: Lcom/aio/downloader/adapter/AppGridviewAdapter;->downwifi()V
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppGridviewAdapter;)V

    .line 344
    :cond_0
    :goto_0
    return-void

    .line 306
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$6(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_2

    .line 307
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 308
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v6

    .line 307
    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    .line 313
    :cond_2
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "It has been in downloading list already."

    const/4 v4, 0x1

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 315
    :catch_0
    move-exception v2

    goto :goto_0

    .line 321
    :cond_3
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$has_apk:Ljava/lang/String;

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 322
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/adapter/AppGridviewAdapter$2$2;

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3, p0, v4}, Lcom/aio/downloader/adapter/AppGridviewAdapter$2$2;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter$2;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 336
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 338
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://play.google.com/store/apps/details?id="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 339
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 338
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 340
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 341
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0
.end method
