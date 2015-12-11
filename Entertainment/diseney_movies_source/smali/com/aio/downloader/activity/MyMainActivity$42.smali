.class Lcom/aio/downloader/activity/MyMainActivity$42;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->neiTui()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private min_version:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 3979
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity$42;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 3979
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 21

    .prologue
    .line 3984
    const-string v3, "version"

    const-string v4, "11111111getversion"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 3986
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://app.loveitsomuch.com/gonglue_xilie/ping.php?id="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3987
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->packagename2:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 3988
    const-string v4, "&version="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 3989
    const-string v4, "3.3.9"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 3986
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 3990
    .local v18, "path":Ljava/lang/String;
    const-string v3, "path"

    move-object/from16 v0, v18

    invoke-static {v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3991
    new-instance v3, Ljava/net/URL;

    move-object/from16 v0, v18

    invoke-direct {v3, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 3992
    invoke-virtual {v3}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v8

    .line 3991
    check-cast v8, Ljava/net/HttpURLConnection;

    .line 3993
    .local v8, "conn":Ljava/net/HttpURLConnection;
    const v3, 0xea60

    invoke-virtual {v8, v3}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 3994
    const-string v3, "GET"

    invoke-virtual {v8, v3}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 3995
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    const/16 v4, 0xc8

    if-ne v3, v4, :cond_7

    .line 3996
    new-instance v20, Ljava/lang/StringBuffer;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuffer;-><init>()V

    .line 3997
    .local v20, "sb":Ljava/lang/StringBuffer;
    new-instance v19, Ljava/io/BufferedReader;

    .line 3998
    new-instance v3, Ljava/io/InputStreamReader;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 3997
    move-object/from16 v0, v19

    invoke-direct {v0, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 3999
    .local v19, "reader":Ljava/io/BufferedReader;
    const-string v14, ""

    .line 4000
    .local v14, "len":Ljava/lang/String;
    :goto_0
    invoke-virtual/range {v19 .. v19}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v14

    if-nez v14, :cond_8

    .line 4003
    new-instance v16, Lorg/json/JSONObject;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v16

    invoke-direct {v0, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 4004
    .local v16, "object":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const-string v4, "status"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/aio/downloader/activity/MyMainActivity;->status:I

    .line 4005
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const-string v4, "in_control"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/aio/downloader/activity/MyMainActivity;->in_control:I

    .line 4006
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const-string v4, "ad_banner"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$94(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V

    .line 4008
    const-string v3, "min_version_in_maintenance"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4007
    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->min_version:Ljava/lang/String;

    .line 4010
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->min_version:Ljava/lang/String;

    const-string v4, "3.3.9"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 4011
    const-string v3, "eee"

    const-string v4, "min_version=null"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4014
    :cond_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->banner_type_name:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$95(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "admob"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 4015
    new-instance v15, Landroid/os/Message;

    invoke-direct {v15}, Landroid/os/Message;-><init>()V

    .line 4016
    .local v15, "msg":Landroid/os/Message;
    const/16 v3, 0xa

    iput v3, v15, Landroid/os/Message;->what:I

    .line 4017
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->handlertimer:Landroid/os/Handler;

    invoke-virtual {v3, v15}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 4021
    .end local v15    # "msg":Landroid/os/Message;
    :cond_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->sp_config:Landroid/content/SharedPreferences;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$96(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 4022
    const-string v4, "banner_type"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->banner_type_name:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$95(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 4023
    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 4025
    const-string v3, "aaaa"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "22222222status:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->status:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4026
    const-string v3, "aaaa"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "3333333in_control"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget v5, v5, Lcom/aio/downloader/activity/MyMainActivity;->in_control:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4027
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->status:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_7

    .line 4028
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->in_control:I

    if-nez v3, :cond_7

    .line 4030
    new-instance v13, Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-direct {v13}, Lcom/aio/downloader/model/GameInfosVersionModel;-><init>()V

    .line 4032
    .local v13, "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    const-string v3, "update_url"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4031
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setUpdatePath(Ljava/lang/String;)V

    .line 4034
    invoke-virtual {v13}, Lcom/aio/downloader/model/GameInfosVersionModel;->getUpdatePath()Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 4035
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$55(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_9

    .line 4036
    const-string v3, "www"

    const-string v4, "eeeeee"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4037
    new-instance v10, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$55(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 4038
    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 4039
    const-string v4, "aioupdate.apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 4037
    invoke-direct {v10, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 4040
    .local v10, "file":Ljava/io/File;
    invoke-virtual {v10}, Ljava/io/File;->delete()Z

    .line 4049
    .end local v10    # "file":Ljava/io/File;
    :goto_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$97(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/thin/downloadmanager/ThinDownloadManager;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$58(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/thin/downloadmanager/ThinDownloadManager;->query(I)I

    move-result v3

    const/16 v4, 0x20

    if-ne v3, v4, :cond_2

    .line 4051
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v3

    const/4 v4, 0x1

    .line 4050
    if-ne v3, v4, :cond_2

    .line 4052
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$97(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/thin/downloadmanager/ThinDownloadManager;

    move-result-object v4

    .line 4053
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->request1:Lcom/thin/downloadmanager/DownloadRequest;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$98(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v4

    .line 4052
    invoke-static {v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$99(Lcom/aio/downloader/activity/MyMainActivity;I)V

    .line 4054
    const-string v3, "www"

    const-string v4, "download"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4062
    :cond_2
    const-string v3, "big_ad_interval"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4061
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 4060
    mul-int/lit16 v3, v3, 0x3e8

    sput v3, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    .line 4063
    const-string v3, "fdfd"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "dd"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v5, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 4064
    const-string v3, "big_ad_interval"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4065
    const-string v4, "0"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 4066
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    .line 4067
    .local v1, "timer":Ljava/util/Timer;
    new-instance v2, Lcom/aio/downloader/activity/MyMainActivity$42$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/activity/MyMainActivity$42$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$42;)V

    .line 4079
    .local v2, "task":Ljava/util/TimerTask;
    const-wide/16 v3, 0x0

    .line 4080
    sget v5, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    int-to-long v5, v5

    .line 4079
    invoke-virtual/range {v1 .. v6}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 4083
    .end local v1    # "timer":Ljava/util/Timer;
    .end local v2    # "task":Ljava/util/TimerTask;
    :cond_3
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    .line 4084
    .local v11, "has_neitui":Ljava/lang/Boolean;
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v12

    .line 4087
    .local v12, "has_update":Ljava/lang/Boolean;
    :try_start_1
    const-string v3, "neitui_list"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 4088
    .local v7, "array":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lez v3, :cond_4

    .line 4089
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    .line 4091
    const/4 v3, 0x0

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v17

    .line 4093
    .local v17, "object2":Lorg/json/JSONObject;
    const-string v3, "headline"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4092
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setNtTitle(Ljava/lang/String;)V

    .line 4095
    const-string v3, "description"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4094
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setNtMsg(Ljava/lang/String;)V

    .line 4097
    const-string v3, "thumb_url"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4096
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setPicPath(Ljava/lang/String;)V

    .line 4098
    const-string v3, "url"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setNtPath(Ljava/lang/String;)V

    .line 4100
    const-string v3, "url_scheme"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4099
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setNtId(Ljava/lang/String;)V

    .line 4102
    const-string v3, "version"

    const-string v4, "44444"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 4107
    .end local v7    # "array":Lorg/json/JSONArray;
    .end local v17    # "object2":Lorg/json/JSONObject;
    :cond_4
    :goto_2
    :try_start_2
    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_5

    .line 4108
    const-string v3, "update_url"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4109
    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 4110
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    .line 4112
    const-string v3, "update_url"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4111
    invoke-virtual {v13, v3}, Lcom/aio/downloader/model/GameInfosVersionModel;->setNtPath(Ljava/lang/String;)V

    .line 4113
    const-string v3, "version"

    const-string v4, "55555"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 4117
    :cond_5
    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_6

    invoke-virtual {v12}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 4118
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/MyMainActivity;->handlerversoin:Landroid/os/Handler;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v4, v4, Lcom/aio/downloader/activity/MyMainActivity;->handlerversoin:Landroid/os/Handler;

    .line 4119
    const/16 v5, 0x234

    invoke-virtual {v4, v5, v13}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    .line 4118
    invoke-virtual {v3, v4}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 4120
    const-string v3, "version"

    const-string v4, "66666"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 4128
    .end local v8    # "conn":Ljava/net/HttpURLConnection;
    .end local v11    # "has_neitui":Ljava/lang/Boolean;
    .end local v12    # "has_update":Ljava/lang/Boolean;
    .end local v13    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    .end local v14    # "len":Ljava/lang/String;
    .end local v16    # "object":Lorg/json/JSONObject;
    .end local v18    # "path":Ljava/lang/String;
    .end local v19    # "reader":Ljava/io/BufferedReader;
    .end local v20    # "sb":Ljava/lang/StringBuffer;
    :cond_7
    :goto_3
    return-void

    .line 4001
    .restart local v8    # "conn":Ljava/net/HttpURLConnection;
    .restart local v14    # "len":Ljava/lang/String;
    .restart local v18    # "path":Ljava/lang/String;
    .restart local v19    # "reader":Ljava/io/BufferedReader;
    .restart local v20    # "sb":Ljava/lang/StringBuffer;
    :cond_8
    move-object/from16 v0, v20

    invoke-virtual {v0, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 4125
    .end local v8    # "conn":Ljava/net/HttpURLConnection;
    .end local v14    # "len":Ljava/lang/String;
    .end local v18    # "path":Ljava/lang/String;
    .end local v19    # "reader":Ljava/io/BufferedReader;
    .end local v20    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v9

    .line 4126
    .local v9, "e":Ljava/lang/Exception;
    invoke-virtual {v9}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 4045
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v8    # "conn":Ljava/net/HttpURLConnection;
    .restart local v13    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    .restart local v14    # "len":Ljava/lang/String;
    .restart local v16    # "object":Lorg/json/JSONObject;
    .restart local v18    # "path":Ljava/lang/String;
    .restart local v19    # "reader":Ljava/io/BufferedReader;
    .restart local v20    # "sb":Ljava/lang/StringBuffer;
    :cond_9
    :try_start_3
    const-string v3, "www"

    const-string v4, "nnnnn"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto/16 :goto_1

    .line 4104
    .restart local v11    # "has_neitui":Ljava/lang/Boolean;
    .restart local v12    # "has_update":Ljava/lang/Boolean;
    :catch_1
    move-exception v3

    goto :goto_2
.end method
