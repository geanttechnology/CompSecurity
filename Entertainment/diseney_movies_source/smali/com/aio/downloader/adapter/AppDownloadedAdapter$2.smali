.class Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;
.super Ljava/lang/Object;
.source "AppDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private myVer_c:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 187
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/16 v11, 0x6e

    .line 194
    :try_start_0
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v8}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 195
    iget-object v9, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    .line 194
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$1(Lcom/aio/downloader/adapter/AppDownloadedAdapter;Landroid/content/pm/PackageInfo;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 201
    :goto_0
    new-instance v1, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-direct {v1, v7}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 203
    .local v1, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_1
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->myVer_c:Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 208
    :goto_1
    const-string v7, "qwa"

    .line 209
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "n_fo.getMovieHeadImagePath()="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 210
    iget-object v9, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "myVer_c="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 211
    iget-object v9, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->myVer_c:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 209
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 208
    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 212
    const-string v7, "qwa"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "++++++++++"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v7

    const-string v8, "video"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 215
    new-instance v6, Landroid/content/Intent;

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    const-class v8, Lcom/aio/downloader/activity/VideoViewActivity;

    invoke-direct {v6, v7, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 217
    .local v6, "tiplay":Landroid/content/Intent;
    const-string v7, "playurl"

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v6}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 308
    .end local v6    # "tiplay":Landroid/content/Intent;
    :cond_0
    :goto_2
    return-void

    .line 196
    .end local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v3

    .line 197
    .local v3, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    const/4 v8, 0x0

    invoke-static {v7, v8}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$1(Lcom/aio/downloader/adapter/AppDownloadedAdapter;Landroid/content/pm/PackageInfo;)V

    .line 198
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 204
    .end local v3    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_1
    move-exception v2

    .line 206
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 220
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v7

    const-string v8, "mp3"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 221
    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    .line 222
    .local v5, "timp3":Landroid/content/Intent;
    const-string v7, "mymp3play"

    invoke-virtual {v5, v7}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 223
    const-string v7, "mp3positiontitle"

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    const-string v7, "mp3position"

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 225
    const-string v7, "mp3position"

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v5}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_2

    .line 231
    .end local v5    # "timp3":Landroid/content/Intent;
    :cond_2
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v7

    if-ne v7, v11, :cond_5

    .line 232
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;

    move-result-object v7

    if-eqz v7, :cond_3

    .line 233
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    .line 234
    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->myVer_c:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 237
    :try_start_2
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 239
    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v8

    .line 238
    invoke-virtual {v7, v8}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    .line 240
    .local v4, "intent":Landroid/content/Intent;
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 241
    const-string v7, "sss"

    const-string v8, "2222"

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_2

    .line 243
    .end local v4    # "intent":Landroid/content/Intent;
    :catch_2
    move-exception v7

    goto/16 :goto_2

    .line 247
    :cond_3
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;

    move-result-object v7

    if-nez v7, :cond_4

    .line 248
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v7

    if-eq v7, v11, :cond_4

    .line 250
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 251
    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    .line 250
    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openimgpath:Ljava/lang/String;

    .line 252
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->opentitle:Ljava/lang/String;

    .line 253
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 255
    const-string v7, "sss"

    const-string v8, "11111"

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 256
    new-instance v0, Landroid/content/Intent;

    const-string v7, "android.intent.action.VIEW"

    invoke-direct {v0, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 258
    .local v0, "aa":Landroid/content/Intent;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "file://"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 259
    const-string v8, "application/vnd.android.package-archive"

    .line 257
    invoke-virtual {v0, v7, v8}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 260
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 262
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_4
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 263
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v7

    if-ne v7, v11, :cond_0

    .line 265
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 266
    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    .line 265
    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openimgpath:Ljava/lang/String;

    .line 267
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->opentitle:Ljava/lang/String;

    .line 268
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 270
    const-string v7, "sss"

    const-string v8, "11111"

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 271
    new-instance v0, Landroid/content/Intent;

    const-string v7, "android.intent.action.VIEW"

    invoke-direct {v0, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 273
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "file://"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 274
    const-string v8, "application/vnd.android.package-archive"

    .line 272
    invoke-virtual {v0, v7, v8}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 275
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 278
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_5
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;

    move-result-object v7

    if-eqz v7, :cond_6

    .line 281
    :try_start_3
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 283
    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v8

    .line 282
    invoke-virtual {v7, v8}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    .line 284
    .restart local v4    # "intent":Landroid/content/Intent;
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 285
    const-string v7, "sss"

    const-string v8, "2222"

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto/16 :goto_2

    .line 287
    .end local v4    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v7

    goto/16 :goto_2

    .line 291
    :cond_6
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;

    move-result-object v7

    if-nez v7, :cond_0

    .line 293
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 294
    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    .line 293
    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openimgpath:Ljava/lang/String;

    .line 295
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->opentitle:Ljava/lang/String;

    .line 296
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 298
    const-string v7, "sss"

    const-string v8, "11111"

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 299
    new-instance v0, Landroid/content/Intent;

    const-string v7, "android.intent.action.VIEW"

    invoke-direct {v0, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 301
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "file://"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 302
    const-string v8, "application/vnd.android.package-archive"

    .line 300
    invoke-virtual {v0, v7, v8}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 303
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v7}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_2
.end method
