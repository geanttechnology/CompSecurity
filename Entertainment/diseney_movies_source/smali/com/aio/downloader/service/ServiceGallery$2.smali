.class Lcom/aio/downloader/service/ServiceGallery$2;
.super Ljava/lang/Object;
.source "ServiceGallery.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceGallery;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceGallery;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceGallery;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceGallery$2;)Lcom/aio/downloader/service/ServiceGallery;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v4, 0x1bff04

    .line 124
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 198
    :goto_0
    return-void

    .line 126
    :pswitch_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceGallery;->access$1(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/GralleryDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/GralleryDialog;->dismiss()V

    goto :goto_0

    .line 129
    :pswitch_1
    const-string v2, "qwer"

    const-string v3, "ll_gallery_onclick"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 130
    new-instance v2, Lcom/aio/downloader/service/ServiceGallery$2$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceGallery$2$1;-><init>(Lcom/aio/downloader/service/ServiceGallery$2;)V

    .line 140
    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceGallery$2$1;->start()V

    .line 142
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 143
    const-string v3, "gallery_click"

    .line 142
    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 145
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceGallery;->access$1(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/GralleryDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/GralleryDialog;->dismiss()V

    .line 147
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceGallery;->access$2(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 148
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceGallery;->access$2(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceGallery;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 149
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 151
    .local v1, "intent":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERYAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceGallery;->access$2(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 152
    const-string v3, "application/vnd.android.package-archive"

    .line 150
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 153
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 154
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceGallery;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 189
    .end local v1    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 155
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERY:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceGallery;->access$3(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 156
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERY:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceGallery;->access$3(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceGallery;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    .line 158
    new-instance v2, Lcom/aio/downloader/service/ServiceGallery$2$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceGallery$2$2;-><init>(Lcom/aio/downloader/service/ServiceGallery$2;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 180
    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/ServiceGallery$2$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 183
    :cond_1
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 184
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 183
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 185
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    const-string v3, "com.androidapp.gallary3d"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 186
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 187
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$2;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceGallery;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 124
    :pswitch_data_0
    .packed-switch 0x7f070216
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
