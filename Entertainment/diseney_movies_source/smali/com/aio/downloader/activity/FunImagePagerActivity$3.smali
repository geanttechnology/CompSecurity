.class Lcom/aio/downloader/activity/FunImagePagerActivity$3;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 224
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$3;)Lcom/aio/downloader/activity/FunImagePagerActivity;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v4, 0x1bff04

    .line 229
    const-string v2, "qwer"

    const-string v3, "fun_gallery"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 230
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "fun_gallery"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 232
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$12(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 233
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$12(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 234
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 236
    .local v1, "intent":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$12(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 237
    const-string v3, "application/vnd.android.package-archive"

    .line 235
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 238
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 239
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->startActivity(Landroid/content/Intent;)V

    .line 277
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 240
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERY:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$13(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 241
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$12(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    .line 243
    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$3$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$3$1;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity$3;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 264
    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/FunImagePagerActivity$3$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 273
    :catch_0
    move-exception v0

    .line 275
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 267
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_1
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 268
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 267
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 269
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    const-string v3, "com.androidapp.gallary3d"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 270
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 271
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$3;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
