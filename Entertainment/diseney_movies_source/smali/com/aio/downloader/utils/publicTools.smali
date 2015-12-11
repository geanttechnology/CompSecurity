.class public Lcom/aio/downloader/utils/publicTools;
.super Ljava/lang/Object;
.source "publicTools.java"


# static fields
.field private static aiokey:Ljava/lang/String; = null

.field public static app_detail_handler:Landroid/os/Handler; = null

.field public static app_popular_handler:Landroid/os/Handler; = null

.field public static app_recent_handler:Landroid/os/Handler; = null

.field public static app_search_handler:Landroid/os/Handler; = null

.field public static appdownload:Z = false

.field public static apppopularhandler:Landroid/os/Handler; = null

.field public static apprecenthandler:Landroid/os/Handler; = null

.field public static apps_in_downloading_list:Lorg/json/JSONObject; = null

.field public static appsearchhandler:Landroid/os/Handler; = null

.field public static cleanertag:Z = false

.field public static cookieManager:Ljava/net/CookieManager; = null

.field public static ctx:Landroid/content/Context; = null

.field public static detailtag:Z = false

.field public static dmhandler:Landroid/os/Handler; = null

.field public static downkey:Ljava/lang/String; = null

.field public static game_popular_handler:Landroid/os/Handler; = null

.field public static game_recent_handler:Landroid/os/Handler; = null

.field public static isbu:Ljava/lang/Boolean; = null

.field public static keyid:Ljava/lang/String; = null

.field public static mp3_popular_handler:Landroid/os/Handler; = null

.field public static mp3_recent_handler:Landroid/os/Handler; = null

.field public static mp3_search_handler:Landroid/os/Handler; = null

.field public static mp3popularhandler:Landroid/os/Handler; = null

.field public static mp3recenthandler:Landroid/os/Handler; = null

.field public static mp3searchhandler:Landroid/os/Handler; = null

.field public static noticomplete:I = 0x0

.field public static openid:Ljava/lang/String; = null

.field public static openimgpath:Ljava/lang/String; = null

.field public static opentitle:Ljava/lang/String; = null

.field public static popuhandler:Landroid/os/Handler; = null

.field public static ringtone_popular_handler:Landroid/os/Handler; = null

.field public static ringtone_recent_handler:Landroid/os/Handler; = null

.field public static ringtone_search_handler:Landroid/os/Handler; = null

.field public static ringtonepopularhandler:Landroid/os/Handler; = null

.field public static ringtonerecenthandler:Landroid/os/Handler; = null

.field public static ringtonesearchhandler:Landroid/os/Handler; = null

.field public static final secret:Ljava/lang/String; = "this_is_mobile_2014"

.field public static serial:I = 0x0

.field public static sp:Landroid/content/SharedPreferences; = null

.field public static spkey:Landroid/content/SharedPreferences; = null

.field public static tagfeatured:Ljava/lang/String; = null

.field public static tagtanchuang:Z = false

.field public static final timeurl1:Ljava/lang/String; = "http://android.downloadatoz.com/_201409/market/time.php"

.field public static final timeurl2:Ljava/lang/String; = "http://93app.com/time.php"

.field public static final timeurl3:Ljava/lang/String; = "http://www.convert-unix-time.com/api?timestamp=now"

.field public static toptoast:Z = false

.field public static final video_ga_tongji:Ljava/lang/String; = "http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id="


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 97
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->isbu:Ljava/lang/Boolean;

    .line 99
    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->detailtag:Z

    .line 100
    sput-boolean v2, Lcom/aio/downloader/utils/publicTools;->appdownload:Z

    .line 102
    sput v2, Lcom/aio/downloader/utils/publicTools;->noticomplete:I

    .line 104
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 109
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 112
    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 116
    sput v1, Lcom/aio/downloader/utils/publicTools;->serial:I

    .line 121
    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->tagtanchuang:Z

    .line 122
    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->toptoast:Z

    .line 124
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->tagfeatured:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 127
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->ctx:Landroid/content/Context;

    .line 128
    const-string v0, "datatime"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->sp:Landroid/content/SharedPreferences;

    .line 129
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->apps_in_downloading_list:Lorg/json/JSONObject;

    .line 130
    const-string v0, "keydata"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->spkey:Landroid/content/SharedPreferences;

    .line 131
    return-void
.end method

.method static synthetic access$0(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    sput-object p0, Lcom/aio/downloader/utils/publicTools;->aiokey:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    sget-object v0, Lcom/aio/downloader/utils/publicTools;->aiokey:Ljava/lang/String;

    return-object v0
.end method

.method public static copyFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p0, "oldPath"    # Ljava/lang/String;
    .param p1, "newPath"    # Ljava/lang/String;

    .prologue
    .line 625
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "oldPath:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 626
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "newPath:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 628
    :try_start_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 629
    .local v2, "file":Ljava/io/File;
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 630
    .local v3, "fis":Ljava/io/FileInputStream;
    new-instance v4, Ljava/io/FileOutputStream;

    const/4 v6, 0x0

    invoke-direct {v4, p1, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;Z)V

    .line 632
    .local v4, "fos":Ljava/io/FileOutputStream;
    const/16 v6, 0x400

    new-array v0, v6, [B

    .line 633
    .local v0, "buffer":[B
    const/4 v5, 0x0

    .line 634
    .local v5, "read":I
    :goto_0
    const/4 v6, -0x1

    if-gt v5, v6, :cond_0

    .line 638
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V

    .line 639
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->flush()V

    .line 640
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 645
    .end local v0    # "buffer":[B
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fis":Ljava/io/FileInputStream;
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "read":I
    :goto_1
    return-void

    .line 635
    .restart local v0    # "buffer":[B
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "fis":Ljava/io/FileInputStream;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "read":I
    :cond_0
    invoke-virtual {v3, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v5

    .line 636
    const/4 v6, 0x0

    invoke-virtual {v4, v0, v6, v5}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 641
    .end local v0    # "buffer":[B
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fis":Ljava/io/FileInputStream;
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "read":I
    :catch_0
    move-exception v1

    .line 642
    .local v1, "e":Ljava/lang/Exception;
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "error:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 643
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method public static doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
    .locals 15
    .param p0, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 649
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/16 v0, 0x1388

    .line 650
    .local v0, "TIMEOUT":I
    const/4 v11, 0x1

    new-array v5, v11, [Lorg/apache/http/message/BasicHeader;

    .line 651
    .local v5, "headers":[Lorg/apache/http/Header;
    const/4 v11, 0x0

    new-instance v12, Lorg/apache/http/message/BasicHeader;

    const-string v13, "User-Agent"

    .line 652
    const-string v14, "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)"

    invoke-direct {v12, v13, v14}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 651
    aput-object v12, v5, v11

    .line 654
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 655
    .local v1, "client":Lorg/apache/http/client/HttpClient;
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    invoke-static {v11, v0}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 656
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    invoke-static {v11, v0}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 657
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    int-to-long v12, v0

    invoke-static {v11, v12, v13}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 658
    new-instance v8, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v8, p0}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 659
    .local v8, "post":Lorg/apache/http/client/methods/HttpPost;
    invoke-virtual {v8, v5}, Lorg/apache/http/client/methods/HttpPost;->setHeaders([Lorg/apache/http/Header;)V

    .line 660
    const-string v10, "ERROR"

    .line 661
    .local v10, "result":Ljava/lang/String;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 662
    .local v7, "pairList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    if-eqz p1, :cond_0

    .line 663
    invoke-virtual/range {p1 .. p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_1

    .line 671
    :cond_0
    :try_start_0
    new-instance v3, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v11, "UTF-8"

    invoke-direct {v3, v7, v11}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 672
    .local v3, "entity":Lorg/apache/http/HttpEntity;
    invoke-virtual {v8, v3}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 673
    invoke-interface {v1, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    .line 675
    .local v9, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v11

    const/16 v12, 0xc8

    if-ne v11, v12, :cond_2

    .line 677
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    const-string v12, "UTF-8"

    invoke-static {v11, v12}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v10

    .line 691
    .end local v3    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :goto_1
    return-object v10

    .line 663
    :cond_1
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 664
    .local v4, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    .line 665
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 664
    invoke-direct {v6, v11, v12}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 666
    .local v6, "pair":Lorg/apache/http/message/BasicNameValuePair;
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 680
    .end local v4    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "pair":Lorg/apache/http/message/BasicNameValuePair;
    .restart local v3    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v9    # "response":Lorg/apache/http/HttpResponse;
    :cond_2
    :try_start_1
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v12

    const-string v13, "UTF-8"

    invoke-static {v12, v13}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 681
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "ERROR"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 680
    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v10

    goto :goto_1

    .line 684
    .end local v3    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_0
    move-exception v2

    .line 685
    .local v2, "e":Lorg/apache/http/conn/ConnectTimeoutException;
    const-string v10, "TIMEOUTERROR"

    goto :goto_1

    .line 686
    .end local v2    # "e":Lorg/apache/http/conn/ConnectTimeoutException;
    :catch_1
    move-exception v2

    .line 687
    .local v2, "e":Ljava/lang/Exception;
    const-string v10, "OTHERERROR"

    .line 688
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method public static getCode(Ljava/lang/String;J)Ljava/lang/String;
    .locals 3
    .param p0, "id"    # Ljava/lang/String;
    .param p1, "local_time"    # J

    .prologue
    .line 558
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "this_is_mobile_2014"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/aio/downloader/utils/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 560
    .local v0, "s":Ljava/lang/String;
    return-object v0
.end method

.method public static getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
    .locals 22
    .param p0, "url"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 165
    .local p1, "options":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    const/4 v15, 0x0

    .line 166
    .local v15, "sb":Ljava/lang/StringBuffer;
    const/4 v13, 0x0

    .line 167
    .local v13, "reader":Ljava/io/BufferedReader;
    const/4 v10, 0x0

    .line 168
    .local v10, "key":Ljava/lang/String;
    const-string v12, "X"

    .line 169
    .local v12, "msg":Ljava/lang/String;
    const-string v17, "http.keepAlive"

    const-string v18, "false"

    invoke-static/range {v17 .. v18}, Ljava/lang/System;->setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 171
    :try_start_0
    new-instance v17, Ljava/net/URL;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v17}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v4

    check-cast v4, Ljava/net/HttpURLConnection;

    .line 172
    .local v4, "conn":Ljava/net/HttpURLConnection;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "a/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 174
    const-string v17, "redirect"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    if-nez v17, :cond_0

    .line 175
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 177
    :cond_0
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "a2/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 179
    const-string v17, "send_cookie"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_1

    .line 180
    sget-object v17, Lcom/aio/downloader/utils/publicTools;->cookieManager:Ljava/net/CookieManager;

    invoke-virtual/range {v17 .. v17}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/net/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    if-lez v17, :cond_1

    .line 181
    const-string v17, "Set-Cookie"

    const-string v18, ","

    .line 182
    sget-object v19, Lcom/aio/downloader/utils/publicTools;->cookieManager:Ljava/net/CookieManager;

    invoke-virtual/range {v19 .. v19}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ljava/net/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v19

    .line 181
    invoke-static/range {v18 .. v19}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    :cond_1
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "b/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 191
    const-string v17, "GET"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 192
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "c1/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 193
    const/16 v17, 0x3a98

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 194
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "c2/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 196
    const-string v17, "User-Agent"

    const-string v18, "\tMozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "c3/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 199
    const-string v17, "AIO"

    new-instance v18, Ljava/lang/StringBuilder;

    sget-object v19, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    invoke-static/range {v19 .. v19}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v19, Lcom/aio/downloader/utils/publicTools;->spkey:Landroid/content/SharedPreferences;

    const-string v20, "aiokey"

    const-string v21, "aio_fingerprint"

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/aio/downloader/utils/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "c4/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 206
    new-instance v16, Ljava/lang/StringBuffer;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuffer;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 207
    .end local v15    # "sb":Ljava/lang/StringBuffer;
    .local v16, "sb":Ljava/lang/StringBuffer;
    :try_start_1
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    .line 208
    .local v3, "code":I
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "d:"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 209
    const-string v17, "koko"

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-static/range {p0 .. p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v19, "==="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 211
    const/16 v17, 0x12e

    move/from16 v0, v17

    if-eq v3, v0, :cond_2

    const/16 v17, 0x12d

    move/from16 v0, v17

    if-ne v3, v0, :cond_5

    .line 213
    :cond_2
    const-string v17, "show_header"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_3

    .line 214
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Location: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "Location"

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 215
    const-string v17, "\n"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 216
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "aio_swf_download_link: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 217
    const-string v18, "aio_swf_download_link"

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 216
    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 223
    :cond_3
    const-string v17, "koko"

    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "302sb="

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 244
    :goto_0
    const-string v17, ""

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 245
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "e/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 248
    const-string v17, "save_cookie"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_4

    .line 249
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v8

    .line 250
    .local v8, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    const-string v17, "Set-Cookie"

    move-object/from16 v0, v17

    invoke-interface {v8, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 251
    .local v6, "cookiesHeader":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v6, :cond_4

    .line 252
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v18

    :goto_1
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-nez v17, :cond_a

    .line 258
    .end local v6    # "cookiesHeader":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :cond_4
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, "f/"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 259
    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v15, v16

    .line 263
    .end local v3    # "code":I
    .end local v4    # "conn":Ljava/net/HttpURLConnection;
    .end local v16    # "sb":Ljava/lang/StringBuffer;
    .restart local v15    # "sb":Ljava/lang/StringBuffer;
    :goto_2
    return-object v17

    .line 224
    .end local v15    # "sb":Ljava/lang/StringBuffer;
    .restart local v3    # "code":I
    .restart local v4    # "conn":Ljava/net/HttpURLConnection;
    .restart local v16    # "sb":Ljava/lang/StringBuffer;
    :cond_5
    const/16 v17, 0xc8

    move/from16 v0, v17

    if-ne v3, v0, :cond_9

    .line 226
    const/4 v9, 0x1

    .local v9, "i":I
    :goto_3
    invoke-virtual {v4, v9}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v10

    if-nez v10, :cond_6

    .line 233
    new-instance v14, Ljava/io/BufferedReader;

    new-instance v17, Ljava/io/InputStreamReader;

    .line 234
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 233
    move-object/from16 v0, v17

    invoke-direct {v14, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 235
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .local v14, "reader":Ljava/io/BufferedReader;
    :try_start_2
    const-string v11, ""

    .line 236
    .local v11, "len":Ljava/lang/String;
    :goto_4
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v11

    if-nez v11, :cond_8

    .line 239
    const-string v17, "koko"

    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "200sb="

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-object v13, v14

    .line 240
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    goto/16 :goto_0

    .line 228
    .end local v11    # "len":Ljava/lang/String;
    :cond_6
    :try_start_3
    const-string v17, "show_header"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_7

    .line 229
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, ":"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual {v4, v9}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 231
    :cond_7
    const-string v17, "etet"

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v19, ":"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual {v4, v9}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 226
    add-int/lit8 v9, v9, 0x1

    goto/16 :goto_3

    .line 237
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "len":Ljava/lang/String;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    :cond_8
    :try_start_4
    move-object/from16 v0, v16

    invoke-virtual {v0, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_4

    .line 260
    .end local v11    # "len":Ljava/lang/String;
    :catch_0
    move-exception v7

    move-object v13, v14

    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    move-object/from16 v15, v16

    .line 261
    .end local v3    # "code":I
    .end local v4    # "conn":Ljava/net/HttpURLConnection;
    .end local v9    # "i":I
    .end local v16    # "sb":Ljava/lang/StringBuffer;
    .local v7, "e":Ljava/lang/Exception;
    .restart local v15    # "sb":Ljava/lang/StringBuffer;
    :goto_5
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    .line 263
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "***msg="

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    goto/16 :goto_2

    .line 242
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v15    # "sb":Ljava/lang/StringBuffer;
    .restart local v3    # "code":I
    .restart local v4    # "conn":Ljava/net/HttpURLConnection;
    .restart local v16    # "sb":Ljava/lang/StringBuffer;
    :cond_9
    :try_start_5
    const-string v17, "koko"

    const-string v18, "\u975e\u6b63\u5e38\u8bf7\u6c42\uff0c\u6bd4\u5982\u7f51\u9875\u6253\u4e0d\u5f00\uff0c\u6216\u8005\u6ca1\u6709\u6743\u9650"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 260
    .end local v3    # "code":I
    :catch_1
    move-exception v7

    move-object/from16 v15, v16

    .end local v16    # "sb":Ljava/lang/StringBuffer;
    .restart local v15    # "sb":Ljava/lang/StringBuffer;
    goto :goto_5

    .line 252
    .end local v15    # "sb":Ljava/lang/StringBuffer;
    .restart local v3    # "code":I
    .restart local v6    # "cookiesHeader":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v8    # "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .restart local v16    # "sb":Ljava/lang/StringBuffer;
    :cond_a
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 253
    .local v5, "cookie":Ljava/lang/String;
    sget-object v17, Lcom/aio/downloader/utils/publicTools;->cookieManager:Ljava/net/CookieManager;

    invoke-virtual/range {v17 .. v17}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v19

    const/16 v20, 0x0

    .line 254
    invoke-static {v5}, Ljava/net/HttpCookie;->parse(Ljava/lang/String;)Ljava/util/List;

    move-result-object v17

    const/16 v21, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v21

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/net/HttpCookie;

    .line 253
    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-object/from16 v2, v17

    invoke-interface {v0, v1, v2}, Ljava/net/CookieStore;->add(Ljava/net/URI;Ljava/net/HttpCookie;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_1

    .line 260
    .end local v3    # "code":I
    .end local v4    # "conn":Ljava/net/HttpURLConnection;
    .end local v5    # "cookie":Ljava/lang/String;
    .end local v6    # "cookiesHeader":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v16    # "sb":Ljava/lang/StringBuffer;
    .restart local v15    # "sb":Ljava/lang/StringBuffer;
    :catch_2
    move-exception v7

    goto :goto_5
.end method

.method public static getKey()V
    .locals 2

    .prologue
    .line 695
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/utils/publicTools$2;

    invoke-direct {v1}, Lcom/aio/downloader/utils/publicTools$2;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 714
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 716
    return-void
.end method

.method public static getServerTime()Ljava/lang/Long;
    .locals 6

    .prologue
    .line 538
    const-wide/16 v0, 0x0

    .line 543
    .local v0, "time_offset":J
    :try_start_0
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "time_offset"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 544
    const-string v2, "wewe"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "time_offset==="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 548
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    long-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    long-to-double v4, v0

    add-double/2addr v2, v4

    double-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    return-object v2

    .line 545
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static getUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 391
    const/4 v5, 0x0

    .line 392
    .local v5, "sb":Ljava/lang/StringBuffer;
    const/4 v3, 0x0

    .line 393
    .local v3, "reader":Ljava/io/BufferedReader;
    const-string v7, "ccc"

    const-string v8, "\u8bf7\u6c42\u7f51\u7edc"

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 395
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 396
    invoke-virtual {v7}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 395
    check-cast v0, Ljava/net/HttpURLConnection;

    .line 397
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const-string v7, "GET"

    invoke-virtual {v0, v7}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 398
    const/16 v7, 0x3a98

    invoke-virtual {v0, v7}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 400
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 401
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .local v6, "sb":Ljava/lang/StringBuffer;
    :try_start_1
    const-string v7, "ttt"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "+++"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 402
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v7

    const/16 v8, 0xc8

    if-ne v7, v8, :cond_0

    .line 403
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    .line 404
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 403
    invoke-direct {v4, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 405
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .local v4, "reader":Ljava/io/BufferedReader;
    :try_start_2
    const-string v2, ""

    .line 406
    .local v2, "len":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v2

    if-nez v2, :cond_1

    move-object v3, v4

    .line 410
    .end local v2    # "len":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    :cond_0
    :try_start_3
    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 411
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v7

    move-object v5, v6

    .line 415
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    :goto_1
    return-object v7

    .line 407
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .restart local v0    # "conn":Ljava/net/HttpURLConnection;
    .restart local v2    # "len":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "sb":Ljava/lang/StringBuffer;
    :cond_1
    :try_start_4
    invoke-virtual {v6, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_0

    .line 412
    .end local v2    # "len":Ljava/lang/String;
    :catch_0
    move-exception v1

    move-object v3, v4

    .end local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .line 413
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .local v1, "e":Ljava/lang/Exception;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    :goto_2
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 414
    const-string v7, "ttt"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 415
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 412
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    goto :goto_2

    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .restart local v0    # "conn":Ljava/net/HttpURLConnection;
    .restart local v6    # "sb":Ljava/lang/StringBuffer;
    :catch_2
    move-exception v1

    move-object v5, v6

    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    goto :goto_2
.end method

.method public static getUrl2(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 421
    const/4 v5, 0x0

    .line 422
    .local v5, "sb":Ljava/lang/StringBuffer;
    const/4 v3, 0x0

    .line 425
    .local v3, "reader":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 426
    invoke-virtual {v7}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 425
    check-cast v0, Ljava/net/HttpURLConnection;

    .line 427
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const-string v7, "GET"

    invoke-virtual {v0, v7}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 428
    const/16 v7, 0x3a98

    invoke-virtual {v0, v7}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 430
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 431
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .local v6, "sb":Ljava/lang/StringBuffer;
    :try_start_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v7

    const/16 v8, 0xc8

    if-ne v7, v8, :cond_0

    .line 432
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    .line 433
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 432
    invoke-direct {v4, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 434
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .local v4, "reader":Ljava/io/BufferedReader;
    :try_start_2
    const-string v2, ""

    .line 435
    .local v2, "len":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v2

    if-nez v2, :cond_1

    move-object v3, v4

    .line 439
    .end local v2    # "len":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    :cond_0
    :try_start_3
    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 440
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v7

    move-object v5, v6

    .line 444
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    :goto_1
    return-object v7

    .line 436
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .restart local v0    # "conn":Ljava/net/HttpURLConnection;
    .restart local v2    # "len":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "sb":Ljava/lang/StringBuffer;
    :cond_1
    :try_start_4
    invoke-virtual {v6, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_0

    .line 441
    .end local v2    # "len":Ljava/lang/String;
    :catch_0
    move-exception v1

    move-object v3, v4

    .end local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .line 442
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .local v1, "e":Ljava/lang/Exception;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    :goto_2
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 443
    const-string v7, "ttt"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 444
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 441
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    goto :goto_2

    .end local v5    # "sb":Ljava/lang/StringBuffer;
    .restart local v0    # "conn":Ljava/net/HttpURLConnection;
    .restart local v6    # "sb":Ljava/lang/StringBuffer;
    :catch_2
    move-exception v1

    move-object v5, v6

    .end local v6    # "sb":Ljava/lang/StringBuffer;
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    goto :goto_2
.end method

.method public static get_a_random_user_webview()Ljava/lang/String;
    .locals 13

    .prologue
    .line 352
    const-string v6, "http://m.downloadatoz.com/apps/com.about.wapdam.mp3.music,1186371/download.html"

    .line 353
    .local v6, "mywebview":Ljava/lang/String;
    sget-object v9, Lcom/aio/downloader/utils/publicTools;->ctx:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f050002

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 356
    .local v3, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {v3}, Ljava/io/InputStream;->available()I

    move-result v5

    .line 358
    .local v5, "length":I
    new-array v1, v5, [B

    .line 360
    .local v1, "buffer":[B
    invoke-virtual {v3, v1}, Ljava/io/InputStream;->read([B)I

    .line 361
    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, v1}, Ljava/lang/String;-><init>([B)V

    .line 362
    .local v4, "json":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 363
    const-string v9, "lolo"

    invoke-static {v9, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 364
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, v4}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 366
    .local v0, "array":Lorg/json/JSONArray;
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v9

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v11

    int-to-double v11, v11

    mul-double/2addr v9, v11

    invoke-static {v9, v10}, Ljava/lang/Math;->floor(D)D

    move-result-wide v9

    double-to-int v8, v9

    .line 368
    .local v8, "rand":I
    invoke-virtual {v0, v8}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 369
    .local v7, "object":Lorg/json/JSONObject;
    const-string v9, "text"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 375
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v1    # "buffer":[B
    .end local v4    # "json":Ljava/lang/String;
    .end local v5    # "length":I
    .end local v7    # "object":Lorg/json/JSONObject;
    .end local v8    # "rand":I
    :goto_0
    return-object v6

    .line 371
    :catch_0
    move-exception v2

    .line 372
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static isNetworkAvailable(Landroid/content/Context;)Z
    .locals 5
    .param p0, "ctx"    # Landroid/content/Context;

    .prologue
    .line 147
    .line 148
    const-string v3, "connectivity"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 147
    check-cast v2, Landroid/net/ConnectivityManager;

    .line 149
    .local v2, "mgr":Landroid/net/ConnectivityManager;
    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getAllNetworkInfo()[Landroid/net/NetworkInfo;

    move-result-object v1

    .line 150
    .local v1, "info":[Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    .line 151
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, v1

    if-lt v0, v3, :cond_1

    .line 157
    .end local v0    # "i":I
    :cond_0
    const/4 v3, 0x0

    :goto_1
    return v3

    .line 152
    .restart local v0    # "i":I
    :cond_1
    aget-object v3, v1, v0

    invoke-virtual {v3}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v3

    sget-object v4, Landroid/net/NetworkInfo$State;->CONNECTED:Landroid/net/NetworkInfo$State;

    if-ne v3, v4, :cond_2

    .line 153
    const/4 v3, 0x1

    goto :goto_1

    .line 151
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static is_app_downloading(Ljava/lang/String;)Z
    .locals 4
    .param p0, "packagename"    # Ljava/lang/String;

    .prologue
    .line 565
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 567
    .local v0, "found":Ljava/lang/Boolean;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    :try_start_0
    sget-object v2, Lcom/aio/downloader/utils/publicTools;->apps_in_downloading_list:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->length()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-lt v1, v2, :cond_0

    .line 576
    :goto_1
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    return v2

    .line 568
    :cond_0
    :try_start_1
    sget-object v2, Lcom/aio/downloader/utils/publicTools;->apps_in_downloading_list:Lorg/json/JSONObject;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 569
    const-string v3, "url_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 570
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    .line 571
    goto :goto_1

    .line 567
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 574
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method public static is_good_domain(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 381
    const-string v0, "93app.com/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "downloadatoz.com/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 382
    const-string v0, "liveloading.com/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 383
    const-string v0, "xkee.com/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 384
    :cond_0
    const/4 v0, 0x1

    .line 386
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static make_path_ready(Ljava/lang/String;)V
    .locals 2
    .param p0, "folder_name"    # Ljava/lang/String;

    .prologue
    .line 136
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 137
    .local v0, "folder":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 138
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 140
    :cond_0
    return-void
.end method

.method public static readFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "filename"    # Ljava/lang/String;

    .prologue
    .line 580
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "filename:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 581
    const-string v2, ""

    .line 583
    .local v2, "content":Ljava/lang/String;
    :try_start_0
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 584
    .local v4, "file":Ljava/io/File;
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 585
    .local v5, "fis":Ljava/io/FileInputStream;
    const/16 v6, 0x400

    new-array v0, v6, [B

    .line 586
    .local v0, "b":[B
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 587
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    :goto_0
    invoke-virtual {v5, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v6

    const/4 v7, -0x1

    if-ne v6, v7, :cond_0

    .line 590
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 591
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V

    .line 592
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 597
    .end local v0    # "b":[B
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "file":Ljava/io/File;
    .end local v5    # "fis":Ljava/io/FileInputStream;
    :goto_1
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "content length:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 598
    return-object v2

    .line 588
    .restart local v0    # "b":[B
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "file":Ljava/io/File;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    :cond_0
    const/4 v6, 0x0

    :try_start_1
    array-length v7, v0

    invoke-virtual {v1, v0, v6, v7}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 593
    .end local v0    # "b":[B
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "file":Ljava/io/File;
    .end local v5    # "fis":Ljava/io/FileInputStream;
    :catch_0
    move-exception v3

    .line 594
    .local v3, "e":Ljava/lang/Exception;
    const-string v6, "xxxx"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "error:"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 595
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method public static read_json_from_file(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 12
    .param p0, "file_name"    # Ljava/lang/String;

    .prologue
    .line 268
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    .line 270
    .local v8, "jsondata":Lorg/json/JSONObject;
    :try_start_0
    new-instance v11, Ljava/io/FileInputStream;

    invoke-direct {v11, p0}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    .line 271
    .local v11, "stream":Ljava/io/FileInputStream;
    const-string v10, ""
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 273
    .local v10, "str":Ljava/lang/String;
    :try_start_1
    invoke-virtual {v11}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 274
    .local v0, "fc":Ljava/nio/channels/FileChannel;
    sget-object v1, Ljava/nio/channels/FileChannel$MapMode;->READ_ONLY:Ljava/nio/channels/FileChannel$MapMode;

    const-wide/16 v2, 0x0

    .line 275
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    .line 274
    invoke-virtual/range {v0 .. v5}, Ljava/nio/channels/FileChannel;->map(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;

    move-result-object v6

    .line 277
    .local v6, "bb":Ljava/nio/MappedByteBuffer;
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v1

    invoke-virtual {v1, v6}, Ljava/nio/charset/Charset;->decode(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/nio/CharBuffer;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v10

    .line 279
    :try_start_2
    invoke-virtual {v11}, Ljava/io/FileInputStream;->close()V

    .line 281
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9, v10}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .end local v8    # "jsondata":Lorg/json/JSONObject;
    .local v9, "jsondata":Lorg/json/JSONObject;
    move-object v8, v9

    .line 285
    .end local v0    # "fc":Ljava/nio/channels/FileChannel;
    .end local v6    # "bb":Ljava/nio/MappedByteBuffer;
    .end local v9    # "jsondata":Lorg/json/JSONObject;
    .end local v10    # "str":Ljava/lang/String;
    .end local v11    # "stream":Ljava/io/FileInputStream;
    .restart local v8    # "jsondata":Lorg/json/JSONObject;
    :goto_0
    return-object v8

    .line 278
    .restart local v10    # "str":Ljava/lang/String;
    .restart local v11    # "stream":Ljava/io/FileInputStream;
    :catchall_0
    move-exception v1

    .line 279
    invoke-virtual {v11}, Ljava/io/FileInputStream;->close()V

    .line 280
    throw v1
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 282
    .end local v10    # "str":Ljava/lang/String;
    .end local v11    # "stream":Ljava/io/FileInputStream;
    :catch_0
    move-exception v7

    .line 283
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static resetServerTime()V
    .locals 2

    .prologue
    .line 449
    new-instance v0, Lcom/aio/downloader/utils/publicTools$1;

    invoke-direct {v0}, Lcom/aio/downloader/utils/publicTools$1;-><init>()V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 532
    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/publicTools$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 534
    return-void
.end method

.method public static save_json_to_file(Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 4
    .param p0, "file_name"    # Ljava/lang/String;
    .param p1, "jsondata"    # Lorg/json/JSONObject;

    .prologue
    .line 291
    :try_start_0
    new-instance v2, Ljava/io/FileWriter;

    invoke-direct {v2, p0}, Ljava/io/FileWriter;-><init>(Ljava/lang/String;)V

    .line 292
    .local v2, "fw":Ljava/io/FileWriter;
    new-instance v0, Ljava/io/BufferedWriter;

    invoke-direct {v0, v2}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 293
    .local v0, "bw":Ljava/io/BufferedWriter;
    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 294
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 298
    .end local v0    # "bw":Ljava/io/BufferedWriter;
    .end local v2    # "fw":Ljava/io/FileWriter;
    :goto_0
    return-void

    .line 295
    :catch_0
    move-exception v1

    .line 296
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public static set_a_random_user_agent()Ljava/lang/String;
    .locals 15

    .prologue
    .line 302
    const-string v0, "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36"

    .line 303
    .local v0, "agent":Ljava/lang/String;
    sget-object v11, Lcom/aio/downloader/utils/publicTools;->ctx:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f050001

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v5

    .line 306
    .local v5, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {v5}, Ljava/io/InputStream;->available()I

    move-result v7

    .line 308
    .local v7, "length":I
    new-array v2, v7, [B

    .line 310
    .local v2, "buffer":[B
    invoke-virtual {v5, v2}, Ljava/io/InputStream;->read([B)I

    .line 311
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, v2}, Ljava/lang/String;-><init>([B)V

    .line 312
    .local v6, "json":Ljava/lang/String;
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 314
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1, v6}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 315
    .local v1, "array":Lorg/json/JSONArray;
    const/4 v8, 0x0

    .local v8, "max":I
    const/4 v4, 0x0

    .line 316
    .local v4, "i":I
    const/4 v4, 0x0

    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v11

    if-lt v4, v11, :cond_0

    .line 322
    const-string v11, "max"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 324
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v11

    int-to-double v13, v8

    mul-double/2addr v11, v13

    invoke-static {v11, v12}, Ljava/lang/Math;->floor(D)D

    move-result-wide v11

    double-to-int v10, v11

    .line 325
    .local v10, "rand":I
    const/4 v4, 0x0

    :goto_1
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v11

    if-lt v4, v11, :cond_1

    .line 338
    .end local v1    # "array":Lorg/json/JSONArray;
    .end local v2    # "buffer":[B
    .end local v4    # "i":I
    .end local v6    # "json":Ljava/lang/String;
    .end local v7    # "length":I
    .end local v8    # "max":I
    .end local v10    # "rand":I
    :goto_2
    :try_start_1
    sget-object v11, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v12, "agent"

    invoke-virtual {v11, v12, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 339
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 345
    :goto_3
    return-object v0

    .line 317
    .restart local v1    # "array":Lorg/json/JSONArray;
    .restart local v2    # "buffer":[B
    .restart local v4    # "i":I
    .restart local v6    # "json":Ljava/lang/String;
    .restart local v7    # "length":I
    .restart local v8    # "max":I
    :cond_0
    :try_start_2
    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 318
    .local v9, "object":Lorg/json/JSONObject;
    const-string v11, "start"

    invoke-virtual {v9, v11, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 319
    const-string v11, "n"

    invoke-virtual {v9, v11}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v11

    add-int/2addr v8, v11

    .line 320
    const-string v11, "end"

    add-int/lit8 v12, v8, -0x1

    invoke-virtual {v9, v11, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 316
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 326
    .end local v9    # "object":Lorg/json/JSONObject;
    .restart local v10    # "rand":I
    :cond_1
    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 327
    .restart local v9    # "object":Lorg/json/JSONObject;
    const-string v11, "start"

    invoke-virtual {v9, v11}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v11

    if-lt v10, v11, :cond_2

    .line 328
    const-string v11, "end"

    invoke-virtual {v9, v11}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v11

    if-ge v10, v11, :cond_2

    .line 329
    const-string v11, "text"

    invoke-virtual {v9, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v0

    .line 330
    goto :goto_2

    .line 325
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 333
    .end local v1    # "array":Lorg/json/JSONArray;
    .end local v2    # "buffer":[B
    .end local v4    # "i":I
    .end local v6    # "json":Ljava/lang/String;
    .end local v7    # "length":I
    .end local v8    # "max":I
    .end local v9    # "object":Lorg/json/JSONObject;
    .end local v10    # "rand":I
    :catch_0
    move-exception v3

    .line 334
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 340
    .end local v3    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v3

    .line 342
    .local v3, "e":Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_3
.end method

.method public static writeFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "filename"    # Ljava/lang/String;

    .prologue
    .line 602
    const-string v2, "xxxx"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "content length2:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 606
    :try_start_0
    new-instance v1, Ljava/io/FileOutputStream;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;Z)V

    .line 607
    .local v1, "fw":Ljava/io/FileOutputStream;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/FileOutputStream;->write([B)V

    .line 608
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 613
    .end local v1    # "fw":Ljava/io/FileOutputStream;
    :goto_0
    return-void

    .line 609
    :catch_0
    move-exception v0

    .line 610
    .local v0, "e":Ljava/io/IOException;
    const-string v2, "xxxx"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "error2:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 611
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method
