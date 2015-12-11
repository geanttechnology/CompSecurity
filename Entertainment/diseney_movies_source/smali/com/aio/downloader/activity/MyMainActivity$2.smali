.class Lcom/aio/downloader/activity/MyMainActivity$2;
.super Landroid/os/Handler;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 253
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 9
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v6, 0x0

    .line 257
    iget v4, p1, Landroid/os/Message;->what:I

    const/16 v5, 0x234

    if-ne v4, v5, :cond_0

    .line 259
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Lcom/aio/downloader/model/GameInfosVersionModel;

    .line 261
    .local v1, "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/model/GameInfosVersionModel;->getUpdatePath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$0(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V

    .line 262
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$1(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 264
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE2:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$2(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 265
    const-string v4, "bbb"

    const-string v5, "exists___exists"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 266
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->updateaioApk1()V
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$3(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 330
    .end local v1    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    :cond_0
    :goto_0
    return-void

    .line 268
    .restart local v1    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    :cond_1
    const-string v4, "bbb"

    const-string v5, "unexists___unexists"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 269
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$2$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MyMainActivity$2$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$2;)V

    new-array v5, v6, [Ljava/lang/Void;

    .line 285
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$2$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 287
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$4(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/content/SharedPreferences;

    move-result-object v4

    const-string v5, "isopen"

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 289
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v5, :cond_2

    .line 290
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$5(Lcom/aio/downloader/activity/MyMainActivity;)V

    goto :goto_0

    .line 295
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$6(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v4

    const-string v5, "com.allinone.downloader"

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_0

    .line 296
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 297
    const-string v5, "com.allinone.downloader"

    .line 298
    const-string v6, "AIO Downloader"

    .line 299
    const-string v7, "http://img.android.downloadatoz.com/upload/android/other/201504/03/all-in-one-downloader-downloader-pn-1428055219.jpg"

    .line 300
    const v8, 0x2488ef

    .line 296
    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk1(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    .line 310
    :cond_3
    new-instance v0, Lcom/aio/downloader/dialog/NoupdareversionDialog;

    .line 311
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$2;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const v5, 0x7f0c000e

    .line 310
    invoke-direct {v0, v4, v5}, Lcom/aio/downloader/dialog/NoupdareversionDialog;-><init>(Landroid/content/Context;I)V

    .line 312
    .local v0, "dialog":Lcom/aio/downloader/dialog/NoupdareversionDialog;
    invoke-virtual {v0, v6}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->setCanceledOnTouchOutside(Z)V

    .line 313
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->show()V

    .line 315
    const v4, 0x7f070140

    invoke-virtual {v0, v4}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 314
    check-cast v3, Landroid/widget/TextView;

    .line 316
    .local v3, "tvversioncontent":Landroid/widget/TextView;
    const-string v4, "Current version: 3.3.9 is the latest version."

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    const v4, 0x7f07034d

    invoke-virtual {v0, v4}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 319
    .local v2, "ok":Landroid/widget/Button;
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$2$2;

    invoke-direct {v4, p0, v0}, Lcom/aio/downloader/activity/MyMainActivity$2$2;-><init>(Lcom/aio/downloader/activity/MyMainActivity$2;Lcom/aio/downloader/dialog/NoupdareversionDialog;)V

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method
