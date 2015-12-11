.class public Lcom/aio/downloader/utils/Myutils;
.super Ljava/lang/Object;
.source "Myutils.java"


# static fields
.field public static final APP_CACAHE_DIRNAME:Ljava/lang/String; = "webcache"

.field public static final BasehitsUrl:Ljava/lang/String; = "http://android.downloadatoz.com/_201409/market/hits.php?type="

.field public static final TYPE_ALARM:I = 0x4

.field public static final TYPE_ALL:I = 0x7

.field public static final TYPE_NOTIFICATION:I = 0x2

.field public static final TYPE_RINGTONE:I = 0x1

.field public static final andmob_full:Ljava/lang/String; = "ca-app-pub-1054623928013334/3671172209"

.field public static final banner_type_name:Ljava/lang/String; = "ca-app-pub-2192624499353475/5842010949"

.field public static big_ad_interval:I = 0x0

.field public static final cachePath:Ljava/lang/String;

.field public static contactus_url_home:Ljava/lang/String; = null

.field public static contactus_url_setting:Ljava/lang/String; = null

.field public static detail_save:Z = false

.field public static dir:Ljava/io/File; = null

.field public static final facebookgift:Ljava/lang/String; = "340186902832477_401790893338744"

.field public static final facebooklist:Ljava/lang/String; = "340186902832477_394762884041545"

.field public static fb_ad:Z = false

.field public static final fbappfeature:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbdownloadgift:Ljava/lang/String; = "340186902832477_436045469913286"

.field public static final fbdownloadmanager:Ljava/lang/String; = "340186902832477_436045399913293"

.field public static final fbgamefeature:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbhome:Ljava/lang/String; = "340186902832477_436045309913302"

.field public static final fbmusthave:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbmyapp:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbtodaypick:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbuninstall:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static final fbupdategift:Ljava/lang/String; = "340186902832477_436045659913267"

.field public static final fbupdatetop:Ljava/lang/String; = "340186902832477_388101491374351"

.field public static gamefan:Z = false

.field public static getoffset:Ljava/lang/Long; = null

.field public static hint:Ljava/lang/String; = null

.field public static hintid:Ljava/lang/String; = null

.field public static final inmobbannerid:Ljava/lang/String; = "bf34144de1cf4616bca0c4acbdd94860"

.field public static final inmobigift:Ljava/lang/String; = "dd15bc6e28814b60a1b162840af80d88"

.field public static final inmobilist:Ljava/lang/String; = "cabf4e2618d24d6c84d7b2d7562f6b7d"

.field private static instance:Lcom/aio/downloader/utils/Myutils; = null

.field public static iscleaner:Z = false

.field public static iswidget:Z = false

.field public static iswidget2:Z = false

.field public static iswidget_float:Z = false

.field public static jsonfile:Ljava/lang/String; = null

.field public static last_time_show_big_ad:J = 0x0L

.field public static laststate:I = 0x0

.field public static list:Ljava/util/List; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field public static list_array:Ljava/util/ArrayList; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation
.end field

.field public static number:I = 0x0

.field public static packagename:Ljava/lang/String; = null

.field public static packagename2:Ljava/lang/String; = null

.field public static searchkeywords:Ljava/lang/String; = null

.field public static setting_json:Lorg/json/JSONObject; = null

.field public static shotcut:Z = false

.field public static showimg:Ljava/lang/Boolean; = null

.field public static status:I = 0x0

.field public static successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem; = null

.field public static today_save:Z = false

.field public static type_current:Ljava/lang/String; = null

.field public static final version:Ljava/lang/String; = "3.3.9"


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 125
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->dir:Ljava/io/File;

    .line 130
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    .line 131
    const-string v0, "com.aio.downloader"

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->packagename2:Ljava/lang/String;

    .line 133
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->jsonfile:Ljava/lang/String;

    .line 140
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->detail_save:Z

    .line 141
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->today_save:Z

    .line 143
    sput-object v3, Lcom/aio/downloader/utils/Myutils;->instance:Lcom/aio/downloader/utils/Myutils;

    .line 146
    const-string v0, "http://android.downloadatoz.com/_201409/market/contact.php?type=more_features"

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->contactus_url_home:Ljava/lang/String;

    .line 147
    const-string v0, "http://android.downloadatoz.com/_201409/market/contact.php"

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->contactus_url_setting:Ljava/lang/String;

    .line 148
    const v0, 0xea60

    sput v0, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    .line 149
    const-wide/16 v0, 0x0

    sput-wide v0, Lcom/aio/downloader/utils/Myutils;->last_time_show_big_ad:J

    .line 150
    sput-object v3, Lcom/aio/downloader/utils/Myutils;->searchkeywords:Ljava/lang/String;

    .line 151
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->hint:Ljava/lang/String;

    .line 152
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->hintid:Ljava/lang/String;

    .line 153
    sput-object v3, Lcom/aio/downloader/utils/Myutils;->getoffset:Ljava/lang/Long;

    .line 155
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->showimg:Ljava/lang/Boolean;

    .line 156
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget:Z

    .line 157
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    .line 158
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget_float:Z

    .line 159
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iscleaner:Z

    .line 160
    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->gamefan:Z

    .line 161
    sput-boolean v4, Lcom/aio/downloader/utils/Myutils;->shotcut:Z

    .line 162
    sput-boolean v4, Lcom/aio/downloader/utils/Myutils;->fb_ad:Z

    .line 163
    sput v2, Lcom/aio/downloader/utils/Myutils;->laststate:I

    .line 164
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 165
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "com.allinone.free"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 164
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->cachePath:Ljava/lang/String;

    .line 169
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 193
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    .line 195
    return-void
.end method

.method public static MaoPao()V
    .locals 6

    .prologue
    .line 382
    const/16 v4, 0xa

    new-array v2, v4, [I

    fill-array-data v2, :array_0

    .line 385
    .local v2, "numbs":[I
    const/4 v3, 0x0

    .line 386
    .local v3, "temp":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v4, v2

    if-lt v0, v4, :cond_0

    .line 397
    return-void

    .line 387
    :cond_0
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    if-lt v1, v4, :cond_1

    .line 386
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 388
    :cond_1
    aget v4, v2, v0

    aget v5, v2, v1

    if-lt v4, v5, :cond_2

    .line 390
    aget v3, v2, v0

    .line 391
    aget v4, v2, v1

    aput v4, v2, v0

    .line 392
    aput v3, v2, v1

    .line 387
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 382
    nop

    :array_0
    .array-data 4
        0x57
        0x19
        0x4
        0x16
        0x2
        0x38
        0xb
        0x1c
        0x23
        0xf
    .end array-data
.end method

.method public static copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    .locals 5
    .param p0, "fromFile"    # Ljava/io/File;
    .param p1, "toFile"    # Ljava/io/File;
    .param p2, "rewrite"    # Ljava/lang/Boolean;

    .prologue
    .line 1095
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1124
    :cond_0
    :goto_0
    return-void

    .line 1098
    :cond_1
    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1101
    invoke-virtual {p0}, Ljava/io/File;->canRead()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1104
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_2

    .line 1105
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->mkdirs()Z

    .line 1107
    :cond_2
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 1108
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    .line 1111
    :cond_3
    :try_start_0
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 1113
    .local v2, "fosfrom":Ljava/io/FileInputStream;
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 1114
    .local v3, "fosto":Ljava/io/FileOutputStream;
    const/16 v4, 0x400

    new-array v0, v4, [B

    .line 1116
    .local v0, "bt":[B
    :goto_1
    invoke-virtual {v2, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v1

    .local v1, "c":I
    if-gtz v1, :cond_4

    .line 1119
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    .line 1120
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    goto :goto_0

    .line 1121
    .end local v0    # "bt":[B
    .end local v1    # "c":I
    .end local v2    # "fosfrom":Ljava/io/FileInputStream;
    .end local v3    # "fosto":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v4

    goto :goto_0

    .line 1117
    .restart local v0    # "bt":[B
    .restart local v1    # "c":I
    .restart local v2    # "fosfrom":Ljava/io/FileInputStream;
    .restart local v3    # "fosto":Ljava/io/FileOutputStream;
    :cond_4
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

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
    .line 1153
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/16 v0, 0x1388

    .line 1154
    .local v0, "TIMEOUT":I
    const/4 v11, 0x1

    new-array v5, v11, [Lorg/apache/http/message/BasicHeader;

    .line 1155
    .local v5, "headers":[Lorg/apache/http/Header;
    const/4 v11, 0x0

    new-instance v12, Lorg/apache/http/message/BasicHeader;

    const-string v13, "User-Agent"

    .line 1156
    const-string v14, "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)"

    invoke-direct {v12, v13, v14}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1155
    aput-object v12, v5, v11

    .line 1158
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 1159
    .local v1, "client":Lorg/apache/http/client/HttpClient;
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    invoke-static {v11, v0}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1160
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    invoke-static {v11, v0}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1161
    invoke-interface {v1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v11

    int-to-long v12, v0

    invoke-static {v11, v12, v13}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 1162
    new-instance v8, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v8, p0}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 1163
    .local v8, "post":Lorg/apache/http/client/methods/HttpPost;
    invoke-virtual {v8, v5}, Lorg/apache/http/client/methods/HttpPost;->setHeaders([Lorg/apache/http/Header;)V

    .line 1164
    const-string v10, "ERROR"

    .line 1165
    .local v10, "result":Ljava/lang/String;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 1166
    .local v7, "pairList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    if-eqz p1, :cond_0

    .line 1167
    invoke-virtual/range {p1 .. p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_1

    .line 1175
    :cond_0
    :try_start_0
    new-instance v3, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v11, "UTF-8"

    invoke-direct {v3, v7, v11}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 1176
    .local v3, "entity":Lorg/apache/http/HttpEntity;
    invoke-virtual {v8, v3}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 1177
    invoke-interface {v1, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    .line 1179
    .local v9, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v11

    const/16 v12, 0xc8

    if-ne v11, v12, :cond_2

    .line 1181
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    const-string v12, "UTF-8"

    invoke-static {v11, v12}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 1182
    const-string v11, "gog"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "result="

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 1197
    .end local v3    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :goto_1
    return-object v10

    .line 1167
    :cond_1
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 1168
    .local v4, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    .line 1169
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 1168
    invoke-direct {v6, v11, v12}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1170
    .local v6, "pair":Lorg/apache/http/message/BasicNameValuePair;
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1185
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

    .line 1186
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "ERROR"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 1185
    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 1187
    const-string v11, "gog"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "ERRORresult="

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 1190
    .end local v3    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    :catch_0
    move-exception v2

    .line 1191
    .local v2, "e":Lorg/apache/http/conn/ConnectTimeoutException;
    const-string v10, "TIMEOUTERROR"

    goto :goto_1

    .line 1192
    .end local v2    # "e":Lorg/apache/http/conn/ConnectTimeoutException;
    :catch_1
    move-exception v2

    .line 1193
    .local v2, "e":Ljava/lang/Exception;
    const-string v10, "OTHERERROR"

    .line 1194
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method public static excuteSuCMD(Ljava/lang/String;)I
    .locals 6
    .param p0, "cmd"    # Ljava/lang/String;

    .prologue
    .line 335
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v4

    const-string v5, "su"

    invoke-virtual {v4, v5}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v2

    .line 336
    .local v2, "process":Ljava/lang/Process;
    new-instance v0, Ljava/io/DataOutputStream;

    .line 337
    invoke-virtual {v2}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    .line 336
    invoke-direct {v0, v4}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 339
    .local v0, "dos":Ljava/io/DataOutputStream;
    const-string v4, "export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 340
    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    .line 341
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 342
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 343
    const-string v4, "exit\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 344
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 345
    invoke-virtual {v2}, Ljava/lang/Process;->waitFor()I

    .line 346
    invoke-virtual {v2}, Ljava/lang/Process;->exitValue()I

    move-result v3

    .line 347
    .local v3, "result":I
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 350
    .end local v0    # "dos":Ljava/io/DataOutputStream;
    .end local v2    # "process":Ljava/lang/Process;
    .end local v3    # "result":I
    :goto_0
    return v4

    .line 348
    :catch_0
    move-exception v1

    .line 349
    .local v1, "localException":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 350
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public static formatTime(J)Ljava/lang/String;
    .locals 8
    .param p0, "time"    # J

    .prologue
    const/4 v7, 0x2

    const-wide/32 v5, 0xea60

    .line 361
    new-instance v2, Ljava/lang/StringBuilder;

    div-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 362
    .local v0, "min":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    rem-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 363
    .local v1, "sec":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v2, v7, :cond_1

    .line 364
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    div-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 368
    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_2

    .line 369
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 377
    :cond_0
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 366
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    div-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 370
    :cond_2
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_3

    .line 371
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "00"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 372
    goto :goto_1

    :cond_3
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-ne v2, v7, :cond_4

    .line 373
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "000"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 374
    goto :goto_1

    :cond_4
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 375
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0000"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public static funList(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 15
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 478
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 479
    .local v6, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/FunModel;>;"
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    sput-object v13, Lcom/aio/downloader/utils/Myutils;->list_array:Ljava/util/ArrayList;

    .line 480
    const/4 v7, 0x0

    .line 481
    .local v7, "model":Lcom/aio/downloader/model/FunModel;
    const/4 v9, 0x0

    .line 483
    .local v9, "model_array":Lcom/aio/downloader/model/FunModel;
    :try_start_0
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 484
    .local v11, "object":Lorg/json/JSONObject;
    const-string v13, "has_next_page"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    .line 485
    .local v10, "next":I
    const-string v13, "status"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    const/4 v14, 0x1

    if-ne v13, v14, :cond_0

    .line 486
    const-string v13, "list"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 487
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    .line 488
    .local v5, "length":I
    const/4 v3, 0x0

    .local v3, "i":I
    move-object v8, v7

    .end local v7    # "model":Lcom/aio/downloader/model/FunModel;
    .local v8, "model":Lcom/aio/downloader/model/FunModel;
    :goto_0
    if-lt v3, v5, :cond_1

    move-object v7, v8

    .line 519
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v3    # "i":I
    .end local v5    # "length":I
    .end local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .end local v10    # "next":I
    .end local v11    # "object":Lorg/json/JSONObject;
    .restart local v7    # "model":Lcom/aio/downloader/model/FunModel;
    :cond_0
    :goto_1
    return-object v6

    .line 489
    .end local v7    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v3    # "i":I
    .restart local v5    # "length":I
    .restart local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v10    # "next":I
    .restart local v11    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v7, Lcom/aio/downloader/model/FunModel;

    invoke-direct {v7}, Lcom/aio/downloader/model/FunModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 490
    .end local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/FunModel;
    :try_start_2
    invoke-virtual {v0, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v12

    .line 491
    .local v12, "object2":Lorg/json/JSONObject;
    const-string v13, "title"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setTitle(Ljava/lang/String;)V

    .line 492
    const-string v13, "thu_path"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setThu_path(Ljava/lang/String;)V

    .line 493
    const-string v13, "like_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setLike_count(Ljava/lang/String;)V

    .line 494
    const-string v13, "share_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setShare_count(Ljava/lang/String;)V

    .line 495
    const-string v13, "img_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setImg_count(I)V

    .line 496
    const-string v13, "create_time"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setCreate_time(Ljava/lang/String;)V

    .line 497
    const-string v13, "video_src"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setVideo_src(Ljava/lang/String;)V

    .line 498
    const-string v13, "img_src"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setImg_src(Ljava/lang/String;)V

    .line 499
    const-string v13, "serial"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setSerial(Ljava/lang/String;)V

    .line 500
    const-string v13, "cat"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setCat(Ljava/lang/String;)V

    .line 501
    const-string v13, "score"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setSave(Ljava/lang/String;)V

    .line 503
    invoke-virtual {v7, v10}, Lcom/aio/downloader/model/FunModel;->setHas_next_page(I)V

    .line 504
    const-string v13, "img_src_array"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 506
    .local v1, "array2":Lorg/json/JSONArray;
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/FunModel;->setFunlist(Ljava/util/ArrayList;)V

    .line 508
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v13

    if-lt v4, v13, :cond_2

    .line 512
    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 488
    add-int/lit8 v3, v3, 0x1

    move-object v8, v7

    .end local v7    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v8    # "model":Lcom/aio/downloader/model/FunModel;
    goto/16 :goto_0

    .line 510
    .end local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/FunModel;
    :cond_2
    iget-object v13, v7, Lcom/aio/downloader/model/FunModel;->funlist:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 508
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 515
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v1    # "array2":Lorg/json/JSONArray;
    .end local v3    # "i":I
    .end local v4    # "j":I
    .end local v5    # "length":I
    .end local v10    # "next":I
    .end local v11    # "object":Lorg/json/JSONObject;
    .end local v12    # "object2":Lorg/json/JSONObject;
    :catch_0
    move-exception v2

    .line 517
    .local v2, "e":Lorg/json/JSONException;
    :goto_3
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_1

    .line 515
    .end local v2    # "e":Lorg/json/JSONException;
    .end local v7    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v3    # "i":I
    .restart local v5    # "length":I
    .restart local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v10    # "next":I
    .restart local v11    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v2

    move-object v7, v8

    .end local v8    # "model":Lcom/aio/downloader/model/FunModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/FunModel;
    goto :goto_3
.end method

.method public static fun_appList(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 15
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/Fun_appModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 524
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 525
    .local v6, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/Fun_appModel;>;"
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    sput-object v13, Lcom/aio/downloader/utils/Myutils;->list_array:Ljava/util/ArrayList;

    .line 526
    const/4 v7, 0x0

    .line 527
    .local v7, "model":Lcom/aio/downloader/model/Fun_appModel;
    const/4 v9, 0x0

    .line 529
    .local v9, "model_array":Lcom/aio/downloader/model/Fun_appModel;
    :try_start_0
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 530
    .local v11, "object":Lorg/json/JSONObject;
    const-string v13, "has_next_page"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    .line 531
    .local v10, "next":I
    const-string v13, "status"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    const/4 v14, 0x1

    if-ne v13, v14, :cond_0

    .line 532
    const-string v13, "list"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 533
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    .line 534
    .local v5, "length":I
    const/4 v3, 0x0

    .local v3, "i":I
    move-object v8, v7

    .end local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .local v8, "model":Lcom/aio/downloader/model/Fun_appModel;
    :goto_0
    if-lt v3, v5, :cond_1

    move-object v7, v8

    .line 565
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v3    # "i":I
    .end local v5    # "length":I
    .end local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .end local v10    # "next":I
    .end local v11    # "object":Lorg/json/JSONObject;
    .restart local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    :cond_0
    :goto_1
    return-object v6

    .line 535
    .end local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v3    # "i":I
    .restart local v5    # "length":I
    .restart local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v10    # "next":I
    .restart local v11    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v7, Lcom/aio/downloader/model/Fun_appModel;

    invoke-direct {v7}, Lcom/aio/downloader/model/Fun_appModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 536
    .end local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    :try_start_2
    invoke-virtual {v0, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v12

    .line 537
    .local v12, "object2":Lorg/json/JSONObject;
    const-string v13, "title"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setTitle(Ljava/lang/String;)V

    .line 538
    const-string v13, "thu_path"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setThu_path(Ljava/lang/String;)V

    .line 539
    const-string v13, "like_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setLike_count(Ljava/lang/String;)V

    .line 540
    const-string v13, "share_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setShare_count(Ljava/lang/String;)V

    .line 541
    const-string v13, "img_count"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setImg_count(I)V

    .line 542
    const-string v13, "create_time"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setCreate_time(Ljava/lang/String;)V

    .line 543
    const-string v13, "video_src"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setVideo_src(Ljava/lang/String;)V

    .line 544
    const-string v13, "img_src"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setImg_src(Ljava/lang/String;)V

    .line 545
    const-string v13, "serial"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setSerial(Ljava/lang/String;)V

    .line 546
    const-string v13, "cat"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setCat(Ljava/lang/String;)V

    .line 547
    const-string v13, "score"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setSave(Ljava/lang/String;)V

    .line 549
    invoke-virtual {v7, v10}, Lcom/aio/downloader/model/Fun_appModel;->setHas_next_page(I)V

    .line 550
    const-string v13, "img_src_array"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 552
    .local v1, "array2":Lorg/json/JSONArray;
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v7, v13}, Lcom/aio/downloader/model/Fun_appModel;->setFunlist(Ljava/util/ArrayList;)V

    .line 554
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v13

    if-lt v4, v13, :cond_2

    .line 558
    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 534
    add-int/lit8 v3, v3, 0x1

    move-object v8, v7

    .end local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    goto/16 :goto_0

    .line 556
    .end local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    :cond_2
    iget-object v13, v7, Lcom/aio/downloader/model/Fun_appModel;->funlist:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 554
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 561
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v1    # "array2":Lorg/json/JSONArray;
    .end local v3    # "i":I
    .end local v4    # "j":I
    .end local v5    # "length":I
    .end local v10    # "next":I
    .end local v11    # "object":Lorg/json/JSONObject;
    .end local v12    # "object2":Lorg/json/JSONObject;
    :catch_0
    move-exception v2

    .line 563
    .local v2, "e":Lorg/json/JSONException;
    :goto_3
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_1

    .line 561
    .end local v2    # "e":Lorg/json/JSONException;
    .end local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v3    # "i":I
    .restart local v5    # "length":I
    .restart local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v10    # "next":I
    .restart local v11    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v2

    move-object v7, v8

    .end local v8    # "model":Lcom/aio/downloader/model/Fun_appModel;
    .restart local v7    # "model":Lcom/aio/downloader/model/Fun_appModel;
    goto :goto_3
.end method

.method private static getBytes(Ljava/io/InputStream;)[B
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 803
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 804
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    const/16 v4, 0x400

    new-array v1, v4, [B

    .line 805
    .local v1, "buffer":[B
    const/4 v2, 0x0

    .line 806
    .local v2, "len":I
    :goto_0
    invoke-virtual {p0, v1}, Ljava/io/InputStream;->read([B)I

    move-result v2

    const/4 v4, -0x1

    if-ne v2, v4, :cond_0

    .line 809
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V

    .line 810
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 811
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    .line 812
    .local v3, "result":[B
    return-object v3

    .line 807
    .end local v3    # "result":[B
    :cond_0
    const/4 v4, 0x0

    invoke-virtual {v0, v1, v4, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_0
.end method

.method public static getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 8
    .param p0, "address"    # Ljava/lang/String;

    .prologue
    .line 787
    :try_start_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 788
    .local v2, "file":Ljava/io/File;
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 789
    .local v3, "fis":Ljava/io/FileInputStream;
    invoke-static {v3}, Lcom/aio/downloader/utils/Myutils;->getBytes(Ljava/io/InputStream;)[B

    move-result-object v4

    .line 790
    .local v4, "imagebytes":[B
    new-instance v5, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v5}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 791
    .local v5, "opt":Landroid/graphics/BitmapFactory$Options;
    sget-object v6, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    iput-object v6, v5, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 792
    const/4 v6, 0x1

    iput-boolean v6, v5, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 793
    const/4 v6, 0x1

    iput-boolean v6, v5, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 794
    const/4 v6, 0x0

    .line 795
    array-length v7, v4

    .line 794
    invoke-static {v4, v6, v7, v5}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 798
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fis":Ljava/io/FileInputStream;
    .end local v4    # "imagebytes":[B
    .end local v5    # "opt":Landroid/graphics/BitmapFactory$Options;
    :goto_0
    return-object v0

    .line 797
    :catch_0
    move-exception v1

    .line 798
    .local v1, "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getInstance()Lcom/aio/downloader/utils/Myutils;
    .locals 1

    .prologue
    .line 185
    sget-object v0, Lcom/aio/downloader/utils/Myutils;->instance:Lcom/aio/downloader/utils/Myutils;

    if-nez v0, :cond_0

    .line 186
    new-instance v0, Lcom/aio/downloader/utils/Myutils;

    invoke-direct {v0}, Lcom/aio/downloader/utils/Myutils;-><init>()V

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->instance:Lcom/aio/downloader/utils/Myutils;

    .line 188
    :cond_0
    sget-object v0, Lcom/aio/downloader/utils/Myutils;->instance:Lcom/aio/downloader/utils/Myutils;

    return-object v0
.end method

.method public static getVersionName(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 774
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 776
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    .line 775
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 777
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v3, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 782
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v2    # "packageManager":Landroid/content/pm/PackageManager;
    :goto_0
    return-object v3

    .line 779
    :catch_0
    move-exception v0

    .line 780
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 782
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static parseAppdetail(Ljava/lang/String;)Lcom/aio/downloader/model/AppdetailModel;
    .locals 7
    .param p0, "jsonData"    # Ljava/lang/String;

    .prologue
    .line 570
    const/4 v1, 0x0

    .line 572
    .local v1, "model":Lcom/aio/downloader/model/AppdetailModel;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 573
    .local v3, "object":Lorg/json/JSONObject;
    const-string v5, "status"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 574
    new-instance v2, Lcom/aio/downloader/model/AppdetailModel;

    invoke-direct {v2}, Lcom/aio/downloader/model/AppdetailModel;-><init>()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 575
    .end local v1    # "model":Lcom/aio/downloader/model/AppdetailModel;
    .local v2, "model":Lcom/aio/downloader/model/AppdetailModel;
    :try_start_1
    const-string v5, "pdt"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 576
    .local v4, "object2":Lorg/json/JSONObject;
    const-string v5, "id"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setId(Ljava/lang/String;)V

    .line 577
    const-string v5, "title"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setTitle(Ljava/lang/String;)V

    .line 578
    const-string v5, "author_title"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setAuthor_title(Ljava/lang/String;)V

    .line 579
    const-string v5, "icon"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setIcon(Ljava/lang/String;)V

    .line 580
    const-string v5, "rating"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setRating(F)V

    .line 581
    const-string v5, "version"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setVersion(Ljava/lang/String;)V

    .line 582
    const-string v5, "release_date"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setRelease_date(Ljava/lang/String;)V

    .line 583
    const-string v5, "downloads"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setDownloads(Ljava/lang/String;)V

    .line 584
    const-string v5, "size"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setSize(Ljava/lang/String;)V

    .line 585
    const-string v5, "price"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setPrice(Ljava/lang/String;)V

    .line 586
    const-string v5, "detail"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setDetail(Ljava/lang/String;)V

    .line 587
    const-string v5, "screenshots"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setScreenshots(Ljava/lang/String;)V

    .line 588
    const-string v5, "has_apk"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/aio/downloader/model/AppdetailModel;->setHas_apk(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, v2

    .line 596
    .end local v2    # "model":Lcom/aio/downloader/model/AppdetailModel;
    .end local v3    # "object":Lorg/json/JSONObject;
    .end local v4    # "object2":Lorg/json/JSONObject;
    .restart local v1    # "model":Lcom/aio/downloader/model/AppdetailModel;
    :cond_0
    :goto_0
    return-object v1

    .line 591
    :catch_0
    move-exception v0

    .line 593
    .local v0, "e":Lorg/json/JSONException;
    :goto_1
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 591
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "model":Lcom/aio/downloader/model/AppdetailModel;
    .restart local v2    # "model":Lcom/aio/downloader/model/AppdetailModel;
    .restart local v3    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "model":Lcom/aio/downloader/model/AppdetailModel;
    .restart local v1    # "model":Lcom/aio/downloader/model/AppdetailModel;
    goto :goto_1
.end method

.method public static parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 442
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 443
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v5, 0x0

    .line 445
    .local v5, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 446
    .local v8, "object":Lorg/json/JSONObject;
    const-string v10, "has_next_page"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 447
    .local v7, "next":I
    const-string v10, "status"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_0

    .line 448
    const-string v10, "list"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 449
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 450
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v6, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 474
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    :goto_1
    return-object v4

    .line 451
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 452
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 453
    .local v9, "object2":Lorg/json/JSONObject;
    const-string v10, "id"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 454
    const-string v10, "serial"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 455
    const-string v10, "title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 456
    const-string v10, "author_title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 457
    const-string v10, "icon"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 458
    const-string v10, "size"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 460
    const-string v10, "rating"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 459
    invoke-static {v10}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 461
    const-string v10, "price"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPrice(Ljava/lang/String;)V

    .line 462
    const-string v10, "has_apk"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 463
    const-string v10, "is_official"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIs_official(Ljava/lang/String;)V

    .line 465
    invoke-virtual {v5, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_next_page(I)V

    .line 466
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 450
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_0

    .line 469
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .end local v9    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    .line 471
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 469
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_2
.end method

.method public static parseMp3list(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 600
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 601
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v5, 0x0

    .line 603
    .local v5, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 604
    .local v8, "object":Lorg/json/JSONObject;
    const-string v10, "has_next_page"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 605
    .local v7, "next":I
    const-string v10, "status"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_0

    .line 606
    const-string v10, "list"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 607
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 608
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v6, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 628
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    :goto_1
    return-object v4

    .line 609
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 610
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 612
    .local v9, "object2":Lorg/json/JSONObject;
    const-string v10, "id"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 613
    const-string v10, "title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 614
    const-string v10, "album_title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAlbum_title(Ljava/lang/String;)V

    .line 615
    const-string v10, "artist_title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setArtist_title(Ljava/lang/String;)V

    .line 616
    const-string v10, "size"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 619
    invoke-virtual {v5, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_next_page(I)V

    .line 620
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 608
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_0

    .line 623
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .end local v9    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    .line 625
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 623
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_2
.end method

.method public static parseRingtonelist(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 632
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 633
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v5, 0x0

    .line 635
    .local v5, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 636
    .local v8, "object":Lorg/json/JSONObject;
    const-string v10, "has_next_page"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 637
    .local v7, "next":I
    const-string v10, "status"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_0

    .line 638
    const-string v10, "list"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 639
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 640
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v6, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 661
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    :goto_1
    return-object v4

    .line 641
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 642
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 644
    .local v9, "object2":Lorg/json/JSONObject;
    const-string v10, "id"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 645
    const-string v10, "title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 646
    const-string v10, "cat"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCat(Ljava/lang/String;)V

    .line 648
    const-string v10, "rating"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 647
    invoke-static {v10}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 649
    const-string v10, "size"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 652
    invoke-virtual {v5, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_next_page(I)V

    .line 653
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 640
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_0

    .line 656
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .end local v9    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    .line 658
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 656
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_2
.end method

.method public static parseSearchKeywords(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsondata"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 690
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 691
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/SearchkeywordModel;>;"
    const/4 v5, 0x0

    .line 693
    .local v5, "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 694
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 695
    .local v3, "length":I
    sget v8, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search1:I

    .line 696
    .local v8, "sear":I
    const-string v9, "qwa"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "sear="

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 697
    move v2, v8

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .local v6, "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :goto_0
    add-int/lit8 v9, v8, 0xa

    if-lt v2, v9, :cond_0

    move-object v5, v6

    .line 710
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .end local v8    # "sear":I
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :goto_1
    return-object v4

    .line 698
    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v8    # "sear":I
    :cond_0
    :try_start_1
    new-instance v5, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-direct {v5}, Lcom/aio/downloader/model/SearchkeywordModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 699
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 700
    .local v7, "object":Lorg/json/JSONObject;
    const-string v9, "id"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/model/SearchkeywordModel;->setId(Ljava/lang/String;)V

    .line 701
    const-string v9, "keyword"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/model/SearchkeywordModel;->setKeyword(Ljava/lang/String;)V

    .line 702
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 697
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    goto :goto_0

    .line 705
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .end local v7    # "object":Lorg/json/JSONObject;
    .end local v8    # "sear":I
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :catch_0
    move-exception v1

    .line 707
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 705
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v8    # "sear":I
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    goto :goto_2
.end method

.method public static parsearchpromitlist(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 9
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/SearcherPromitModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 753
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 754
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/SearcherPromitModel;>;"
    const/4 v5, 0x0

    .line 756
    .local v5, "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 757
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 758
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .local v6, "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :goto_0
    if-lt v2, v3, :cond_0

    move-object v5, v6

    .line 768
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :goto_1
    return-object v4

    .line 759
    .end local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :cond_0
    :try_start_1
    new-instance v5, Lcom/aio/downloader/model/SearcherPromitModel;

    invoke-direct {v5}, Lcom/aio/downloader/model/SearcherPromitModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 760
    .end local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 761
    .local v7, "object":Lorg/json/JSONObject;
    const-string v8, "t"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/aio/downloader/model/SearcherPromitModel;->setT(Ljava/lang/String;)V

    .line 762
    const-string v8, "s"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/aio/downloader/model/SearcherPromitModel;->setS(Ljava/lang/String;)V

    .line 763
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 758
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    goto :goto_0

    .line 765
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .end local v7    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :catch_0
    move-exception v1

    .line 766
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 765
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearcherPromitModel;
    goto :goto_2
.end method

.method public static parsefeatured(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 39
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 952
    new-instance v22, Ljava/util/ArrayList;

    invoke-direct/range {v22 .. v22}, Ljava/util/ArrayList;-><init>()V

    .line 953
    .local v22, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;>;"
    const/16 v26, 0x0

    .line 955
    .local v26, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v29, Lorg/json/JSONObject;

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 956
    .local v29, "object":Lorg/json/JSONObject;
    const-string v37, "has_next_page"

    move-object/from16 v0, v29

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v28

    .line 957
    .local v28, "next":I
    const-string v37, "status"

    move-object/from16 v0, v29

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v37

    const/16 v38, 0x1

    move/from16 v0, v37

    move/from16 v1, v38

    if-ne v0, v1, :cond_0

    .line 958
    const-string v37, "list"

    move-object/from16 v0, v29

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 960
    .local v2, "array":Lorg/json/JSONArray;
    const/16 v18, 0x0

    .end local v26    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v18, "i":I
    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v37

    move/from16 v0, v18

    move/from16 v1, v37

    if-lt v0, v1, :cond_1

    .line 1091
    .end local v2    # "array":Lorg/json/JSONArray;
    .end local v18    # "i":I
    .end local v28    # "next":I
    .end local v29    # "object":Lorg/json/JSONObject;
    :cond_0
    :goto_1
    return-object v22

    .line 961
    .restart local v2    # "array":Lorg/json/JSONArray;
    .restart local v18    # "i":I
    .restart local v28    # "next":I
    .restart local v29    # "object":Lorg/json/JSONObject;
    :cond_1
    new-instance v23, Ljava/util/ArrayList;

    invoke-direct/range {v23 .. v23}, Ljava/util/ArrayList;-><init>()V

    .line 962
    .local v23, "list2":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    move/from16 v0, v18

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v30

    .line 963
    .local v30, "object2":Lorg/json/JSONObject;
    const/16 v36, 0x0

    .line 964
    .local v36, "title":Ljava/lang/String;
    const/16 v35, 0x0

    .line 968
    .local v35, "search_keyword":Ljava/lang/String;
    :try_start_1
    new-instance v31, Lorg/json/JSONObject;

    .line 969
    const-string v37, "info"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    .line 968
    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 970
    .local v31, "object3":Lorg/json/JSONObject;
    const-string v37, "title"

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    .line 971
    const-string v37, "search_keyword"

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v35

    .line 977
    .end local v31    # "object3":Lorg/json/JSONObject;
    :goto_2
    const/4 v14, 0x0

    .line 978
    .local v14, "bannerstatus":Ljava/lang/String;
    const/4 v7, 0x0

    .line 979
    .local v7, "bannerid":Ljava/lang/String;
    const/4 v12, 0x0

    .line 980
    .local v12, "bannerserial":Ljava/lang/String;
    const/4 v15, 0x0

    .line 981
    .local v15, "bannertitle":Ljava/lang/String;
    const/4 v4, 0x0

    .line 982
    .local v4, "bannerauthor_title":Ljava/lang/String;
    const/4 v6, 0x0

    .line 983
    .local v6, "bannericon":Ljava/lang/String;
    const/4 v13, 0x0

    .line 984
    .local v13, "bannersize":Ljava/lang/String;
    const/4 v11, 0x0

    .line 985
    .local v11, "bannerrating":Ljava/lang/String;
    const/4 v10, 0x0

    .line 986
    .local v10, "bannerprice":Ljava/lang/String;
    const/4 v8, 0x0

    .line 987
    .local v8, "bannerisoffical":Ljava/lang/String;
    const/4 v9, 0x0

    .line 988
    .local v9, "bannerlink_url":Ljava/lang/String;
    const/4 v5, 0x0

    .line 991
    .local v5, "bannerhas_apk":Ljava/lang/String;
    :try_start_2
    new-instance v33, Lorg/json/JSONObject;

    .line 992
    const-string v37, "banner"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    .line 991
    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 993
    .local v33, "object6":Lorg/json/JSONObject;
    const-string v37, "status"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 994
    const-string v37, "1"

    move-object/from16 v0, v37

    invoke-virtual {v14, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_2

    .line 995
    const-string v37, "id"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 996
    const-string v37, "serial"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 997
    const-string v37, "title"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 999
    const-string v37, "author_title"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1000
    const-string v37, "icon"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1001
    const-string v37, "size"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 1002
    const-string v37, "rating"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 1003
    const-string v37, "price"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 1004
    const-string v37, "is_official"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 1005
    const-string v37, "link_url"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 1006
    const-string v37, "has_apk"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1008
    :cond_2
    const-string v37, "yyyy"

    move-object/from16 v0, v37

    invoke-static {v0, v14}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 1014
    .end local v33    # "object6":Lorg/json/JSONObject;
    :goto_3
    const/16 v25, 0x0

    .line 1015
    .local v25, "minigametitle":Ljava/lang/String;
    const/16 v16, 0x0

    .line 1016
    .local v16, "detail":Ljava/lang/String;
    const/16 v19, 0x0

    .line 1017
    .local v19, "icon":Ljava/lang/String;
    const/16 v21, 0x0

    .line 1018
    .local v21, "link":Ljava/lang/String;
    const/16 v24, 0x0

    .line 1020
    .local v24, "minigamestatus":Ljava/lang/String;
    :try_start_3
    new-instance v34, Lorg/json/JSONObject;

    .line 1021
    const-string v37, "minigame"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    .line 1020
    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1022
    .local v34, "object7":Lorg/json/JSONObject;
    const-string v37, "status"

    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 1023
    const-string v37, "1"

    move-object/from16 v0, v24

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_3

    .line 1024
    const-string v37, "title"

    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 1025
    const-string v37, "detail"

    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 1026
    const-string v37, "icon"

    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 1027
    const-string v37, "link"

    move-object/from16 v0, v34

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 1029
    :cond_3
    const-string v37, "serty"

    move-object/from16 v0, v37

    move-object/from16 v1, v24

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    .line 1034
    .end local v34    # "object7":Lorg/json/JSONObject;
    :goto_4
    :try_start_4
    new-instance v3, Lorg/json/JSONArray;

    const-string v37, "app"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v37

    invoke-direct {v3, v0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0

    .line 1035
    .local v3, "array2":Lorg/json/JSONArray;
    const/16 v20, 0x0

    .local v20, "j":I
    move-object/from16 v27, v26

    .local v27, "model":Ljava/lang/Object;
    :goto_5
    :try_start_5
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v37

    move/from16 v0, v20

    move/from16 v1, v37

    if-lt v0, v1, :cond_4

    .line 1083
    invoke-virtual/range {v22 .. v23}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 960
    add-int/lit8 v18, v18, 0x1

    move-object/from16 v26, v27

    .end local v27    # "model":Ljava/lang/Object;
    .local v26, "model":Ljava/lang/Object;
    goto/16 :goto_0

    .line 1036
    .end local v26    # "model":Ljava/lang/Object;
    .restart local v27    # "model":Ljava/lang/Object;
    :cond_4
    new-instance v26, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct/range {v26 .. v26}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_1

    .line 1038
    .local v26, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_6
    move-object/from16 v0, v26

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_next_page(I)V

    .line 1041
    .end local v27    # "model":Ljava/lang/Object;
    move-object/from16 v0, v26

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setInfotitle(Ljava/lang/String;)V

    .line 1042
    move-object/from16 v0, v26

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSearch_keyword(Ljava/lang/String;)V

    .line 1045
    move-object/from16 v0, v26

    invoke-virtual {v0, v14}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerstatus(Ljava/lang/String;)V

    .line 1046
    move-object/from16 v0, v26

    invoke-virtual {v0, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerid(Ljava/lang/String;)V

    .line 1047
    move-object/from16 v0, v26

    invoke-virtual {v0, v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerserial(Ljava/lang/String;)V

    .line 1048
    move-object/from16 v0, v26

    invoke-virtual {v0, v15}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannertitle(Ljava/lang/String;)V

    .line 1049
    move-object/from16 v0, v26

    invoke-virtual {v0, v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerauthor_title(Ljava/lang/String;)V

    .line 1050
    move-object/from16 v0, v26

    invoke-virtual {v0, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannericon(Ljava/lang/String;)V

    .line 1051
    move-object/from16 v0, v26

    invoke-virtual {v0, v13}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannersize(Ljava/lang/String;)V

    .line 1052
    move-object/from16 v0, v26

    invoke-virtual {v0, v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerrating(Ljava/lang/String;)V

    .line 1053
    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerprice(Ljava/lang/String;)V

    .line 1054
    move-object/from16 v0, v26

    invoke-virtual {v0, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerisoffical(Ljava/lang/String;)V

    .line 1055
    move-object/from16 v0, v26

    invoke-virtual {v0, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerlink_url(Ljava/lang/String;)V

    .line 1056
    move-object/from16 v0, v26

    invoke-virtual {v0, v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setBannerhas_apk(Ljava/lang/String;)V

    .line 1059
    move-object/from16 v0, v26

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMinigamestatus(Ljava/lang/String;)V

    .line 1060
    move-object/from16 v0, v26

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMinigametitle(Ljava/lang/String;)V

    .line 1061
    move-object/from16 v0, v26

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDetail(Ljava/lang/String;)V

    .line 1062
    move-object/from16 v0, v26

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMinigameicon(Ljava/lang/String;)V

    .line 1063
    move-object/from16 v0, v26

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setLink(Ljava/lang/String;)V

    .line 1065
    move/from16 v0, v20

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v32

    .line 1066
    .local v32, "object4":Lorg/json/JSONObject;
    const-string v37, "id"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 1067
    const-string v37, "serial"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v37

    move-object/from16 v0, v26

    move/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 1068
    const-string v37, "title"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 1069
    const-string v37, "author_title"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 1070
    const-string v37, "icon"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 1071
    const-string v37, "size"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 1073
    const-string v37, "rating"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    .line 1072
    invoke-static/range {v37 .. v37}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v37

    invoke-static/range {v37 .. v37}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 1074
    const-string v37, "price"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPrice(Ljava/lang/String;)V

    .line 1075
    const-string v37, "is_official"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIs_official(Ljava/lang/String;)V

    .line 1076
    const-string v37, "link_url"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setLink_url(Ljava/lang/String;)V

    .line 1077
    const-string v37, "has_apk"

    move-object/from16 v0, v32

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 1078
    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0

    .line 1080
    const/16 v26, 0x0

    .line 1035
    add-int/lit8 v20, v20, 0x1

    move-object/from16 v27, v26

    .restart local v27    # "model":Ljava/lang/Object;
    goto/16 :goto_5

    .line 1087
    .end local v2    # "array":Lorg/json/JSONArray;
    .end local v3    # "array2":Lorg/json/JSONArray;
    .end local v4    # "bannerauthor_title":Ljava/lang/String;
    .end local v5    # "bannerhas_apk":Ljava/lang/String;
    .end local v6    # "bannericon":Ljava/lang/String;
    .end local v7    # "bannerid":Ljava/lang/String;
    .end local v8    # "bannerisoffical":Ljava/lang/String;
    .end local v9    # "bannerlink_url":Ljava/lang/String;
    .end local v10    # "bannerprice":Ljava/lang/String;
    .end local v11    # "bannerrating":Ljava/lang/String;
    .end local v12    # "bannerserial":Ljava/lang/String;
    .end local v13    # "bannersize":Ljava/lang/String;
    .end local v14    # "bannerstatus":Ljava/lang/String;
    .end local v15    # "bannertitle":Ljava/lang/String;
    .end local v16    # "detail":Ljava/lang/String;
    .end local v18    # "i":I
    .end local v19    # "icon":Ljava/lang/String;
    .end local v20    # "j":I
    .end local v21    # "link":Ljava/lang/String;
    .end local v23    # "list2":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    .end local v24    # "minigamestatus":Ljava/lang/String;
    .end local v25    # "minigametitle":Ljava/lang/String;
    .end local v26    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v27    # "model":Ljava/lang/Object;
    .end local v28    # "next":I
    .end local v29    # "object":Lorg/json/JSONObject;
    .end local v30    # "object2":Lorg/json/JSONObject;
    .end local v32    # "object4":Lorg/json/JSONObject;
    .end local v35    # "search_keyword":Ljava/lang/String;
    .end local v36    # "title":Ljava/lang/String;
    :catch_0
    move-exception v17

    .line 1088
    .local v17, "e":Lorg/json/JSONException;
    :goto_6
    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_1

    .line 1087
    .end local v17    # "e":Lorg/json/JSONException;
    .restart local v2    # "array":Lorg/json/JSONArray;
    .restart local v3    # "array2":Lorg/json/JSONArray;
    .restart local v4    # "bannerauthor_title":Ljava/lang/String;
    .restart local v5    # "bannerhas_apk":Ljava/lang/String;
    .restart local v6    # "bannericon":Ljava/lang/String;
    .restart local v7    # "bannerid":Ljava/lang/String;
    .restart local v8    # "bannerisoffical":Ljava/lang/String;
    .restart local v9    # "bannerlink_url":Ljava/lang/String;
    .restart local v10    # "bannerprice":Ljava/lang/String;
    .restart local v11    # "bannerrating":Ljava/lang/String;
    .restart local v12    # "bannerserial":Ljava/lang/String;
    .restart local v13    # "bannersize":Ljava/lang/String;
    .restart local v14    # "bannerstatus":Ljava/lang/String;
    .restart local v15    # "bannertitle":Ljava/lang/String;
    .restart local v16    # "detail":Ljava/lang/String;
    .restart local v18    # "i":I
    .restart local v19    # "icon":Ljava/lang/String;
    .restart local v20    # "j":I
    .restart local v21    # "link":Ljava/lang/String;
    .restart local v23    # "list2":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    .restart local v24    # "minigamestatus":Ljava/lang/String;
    .restart local v25    # "minigametitle":Ljava/lang/String;
    .restart local v27    # "model":Ljava/lang/Object;
    .restart local v28    # "next":I
    .restart local v29    # "object":Lorg/json/JSONObject;
    .restart local v30    # "object2":Lorg/json/JSONObject;
    .restart local v35    # "search_keyword":Ljava/lang/String;
    .restart local v36    # "title":Ljava/lang/String;
    :catch_1
    move-exception v17

    move-object/from16 v26, v27

    .restart local v26    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_6

    .line 1030
    .end local v3    # "array2":Lorg/json/JSONArray;
    .end local v20    # "j":I
    .end local v26    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v27    # "model":Ljava/lang/Object;
    :catch_2
    move-exception v37

    goto/16 :goto_4

    .line 1009
    .end local v16    # "detail":Ljava/lang/String;
    .end local v19    # "icon":Ljava/lang/String;
    .end local v21    # "link":Ljava/lang/String;
    .end local v24    # "minigamestatus":Ljava/lang/String;
    .end local v25    # "minigametitle":Ljava/lang/String;
    :catch_3
    move-exception v37

    goto/16 :goto_3

    .line 972
    .end local v4    # "bannerauthor_title":Ljava/lang/String;
    .end local v5    # "bannerhas_apk":Ljava/lang/String;
    .end local v6    # "bannericon":Ljava/lang/String;
    .end local v7    # "bannerid":Ljava/lang/String;
    .end local v8    # "bannerisoffical":Ljava/lang/String;
    .end local v9    # "bannerlink_url":Ljava/lang/String;
    .end local v10    # "bannerprice":Ljava/lang/String;
    .end local v11    # "bannerrating":Ljava/lang/String;
    .end local v12    # "bannerserial":Ljava/lang/String;
    .end local v13    # "bannersize":Ljava/lang/String;
    .end local v14    # "bannerstatus":Ljava/lang/String;
    .end local v15    # "bannertitle":Ljava/lang/String;
    :catch_4
    move-exception v37

    goto/16 :goto_2
.end method

.method public static parseminigamelist(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 715
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 716
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/MiniGameModel;>;"
    const/4 v5, 0x0

    .line 718
    .local v5, "model":Lcom/aio/downloader/model/MiniGameModel;
    :try_start_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 719
    .local v8, "object":Lorg/json/JSONObject;
    const-string v10, "next"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 720
    .local v7, "next":I
    const-string v10, "status"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_0

    .line 721
    const-string v10, "game_list"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 722
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 723
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .local v6, "model":Lcom/aio/downloader/model/MiniGameModel;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 747
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    :cond_0
    :goto_1
    return-object v4

    .line 724
    .end local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/model/MiniGameModel;

    invoke-direct {v5}, Lcom/aio/downloader/model/MiniGameModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 725
    .end local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 726
    .local v9, "object2":Lorg/json/JSONObject;
    const-string v10, "serial"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setSerial(Ljava/lang/String;)V

    .line 727
    const-string v10, "title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setTitle(Ljava/lang/String;)V

    .line 728
    const-string v10, "icon"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setIcon(Ljava/lang/String;)V

    .line 729
    const-string v10, "play_url"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setPlay_url(Ljava/lang/String;)V

    .line 730
    const-string v10, "proc"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setProc(Ljava/lang/String;)V

    .line 731
    const-string v10, "sound"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setSound(Ljava/lang/String;)V

    .line 732
    const-string v10, "short_desc"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setShort_desc(Ljava/lang/String;)V

    .line 733
    const-string v10, "detail"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setDetail(Ljava/lang/String;)V

    .line 734
    const-string v10, "hits"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setHits(Ljava/lang/String;)V

    .line 735
    const-string v10, "create_time"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setCreate_time(Ljava/lang/String;)V

    .line 736
    const-string v10, "is_safe"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/model/MiniGameModel;->setIs_safe(Ljava/lang/String;)V

    .line 738
    invoke-virtual {v5, v7}, Lcom/aio/downloader/model/MiniGameModel;->setNext(I)V

    .line 739
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 723
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    goto :goto_0

    .line 742
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .end local v9    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    :catch_0
    move-exception v1

    .line 744
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 742
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/model/MiniGameModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/MiniGameModel;
    goto :goto_2
.end method

.method public static parseminikeywords(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 10
    .param p0, "jsondata"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 666
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 667
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/SearchkeywordModel;>;"
    const/4 v5, 0x0

    .line 669
    .local v5, "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :try_start_0
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 670
    .local v7, "object":Lorg/json/JSONObject;
    const-string v8, "status"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    const/4 v9, 0x1

    if-ne v8, v9, :cond_0

    .line 671
    const-string v8, "keyword_list"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 672
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 673
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .local v6, "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 684
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .end local v7    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :cond_0
    :goto_1
    return-object v4

    .line 674
    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v7    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-direct {v5}, Lcom/aio/downloader/model/SearchkeywordModel;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 675
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/aio/downloader/model/SearchkeywordModel;->setKeyword(Ljava/lang/String;)V

    .line 676
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 673
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    goto :goto_0

    .line 679
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .end local v7    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    :catch_0
    move-exception v1

    .line 681
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 679
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v7    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    .restart local v5    # "model":Lcom/aio/downloader/model/SearchkeywordModel;
    goto :goto_2
.end method

.method public static parsetodaypick(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 816
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 817
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v5, 0x0

    .line 819
    .local v5, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 820
    .local v8, "object":Lorg/json/JSONObject;
    const-string v10, "has_next_page"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 821
    .local v7, "next":I
    const-string v10, "status"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_0

    .line 822
    const-string v10, "list"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 823
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 824
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v6, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 848
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    :goto_1
    return-object v4

    .line 825
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 826
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 827
    .local v9, "object2":Lorg/json/JSONObject;
    const-string v10, "id"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 828
    const-string v10, "serial"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 829
    const-string v10, "show_time"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 830
    const-string v10, "title"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 831
    const-string v10, "icon"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 832
    const-string v10, "short_desc"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPpshort_desc(Ljava/lang/String;)V

    .line 833
    const-string v10, "img"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 835
    const-string v10, "rating"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 834
    invoke-static {v10}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 836
    const-string v10, "has_apk"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 837
    const-string v10, "rating_count"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSetCount(Ljava/lang/String;)V

    .line 839
    invoke-virtual {v5, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_next_page(I)V

    .line 840
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 824
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_0

    .line 843
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "next":I
    .end local v8    # "object":Lorg/json/JSONObject;
    .end local v9    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    .line 845
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 843
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "next":I
    .restart local v8    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_2
.end method

.method public static parseupdata(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 11
    .param p0, "jsonData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 852
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 853
    .local v4, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v5, 0x0

    .line 855
    .local v5, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_0
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 856
    .local v7, "object":Lorg/json/JSONObject;
    const-string v9, "status"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    sput v9, Lcom/aio/downloader/utils/Myutils;->status:I

    .line 857
    const-string v9, "status"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    .line 858
    const-string v9, "app_list"

    invoke-virtual {v7, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 859
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 860
    .local v3, "length":I
    const/4 v2, 0x0

    .local v2, "i":I
    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .local v6, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :goto_0
    if-lt v2, v3, :cond_1

    move-object v5, v6

    .line 875
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "object":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    :goto_1
    return-object v4

    .line 861
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "object":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 862
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :try_start_2
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    .line 863
    .local v8, "object2":Lorg/json/JSONObject;
    const-string v9, "id"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 864
    const-string v9, "version"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setVersion(Ljava/lang/String;)V

    .line 865
    const-string v9, "apk_download_url"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setLink_url(Ljava/lang/String;)V

    .line 866
    const-string v9, "size"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 867
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 860
    add-int/lit8 v2, v2, 0x1

    move-object v6, v5

    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_0

    .line 870
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "length":I
    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v7    # "object":Lorg/json/JSONObject;
    .end local v8    # "object2":Lorg/json/JSONObject;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :catch_0
    move-exception v1

    .line 872
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 870
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "length":I
    .restart local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v7    # "object":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    move-object v5, v6

    .end local v6    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    goto :goto_2
.end method

.method public static record_run_times()V
    .locals 3

    .prologue
    .line 429
    const/4 v0, 0x0

    .line 431
    .local v0, "run_times":I
    :try_start_0
    sget-object v1, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v2, "run_times"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v0

    .line 434
    :goto_0
    add-int/lit8 v0, v0, 0x1

    .line 436
    :try_start_1
    sget-object v1, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v2, "run_times"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 439
    :goto_1
    return-void

    .line 437
    :catch_0
    move-exception v1

    goto :goto_1

    .line 432
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method public static recoverSetting()V
    .locals 2

    .prologue
    .line 418
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->dir:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 419
    sget-object v1, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/setting.json"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 418
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->read_json_from_file(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    .line 420
    return-void
.end method

.method public static saveSetting()V
    .locals 2

    .prologue
    .line 423
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->dir:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 424
    const-string v1, "/setting.json"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 423
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 424
    sget-object v1, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    .line 423
    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->save_json_to_file(Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 425
    return-void
.end method

.method public static save_download_data(Ljava/lang/String;Ljava/util/List;)V
    .locals 9
    .param p0, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/json/JSONObject;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 309
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lorg/json/JSONObject;>;"
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 310
    .local v3, "listarray":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    if-lt v2, v6, :cond_1

    .line 314
    const-string v6, "apk"

    invoke-virtual {p0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 315
    const-string v6, "apk.json"

    sput-object v6, Lcom/aio/downloader/utils/Myutils;->jsonfile:Ljava/lang/String;

    .line 322
    :cond_0
    :goto_1
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v8

    .line 323
    invoke-virtual {v8}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sget-object v8, Lcom/aio/downloader/utils/Myutils;->jsonfile:Ljava/lang/String;

    .line 322
    invoke-direct {v6, v7, v8}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 324
    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    .line 325
    .local v5, "path":Ljava/lang/String;
    new-instance v1, Ljava/io/FileWriter;

    invoke-direct {v1, v5}, Ljava/io/FileWriter;-><init>(Ljava/lang/String;)V

    .line 326
    .local v1, "fw":Ljava/io/FileWriter;
    new-instance v0, Ljava/io/BufferedWriter;

    invoke-direct {v0, v1}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 327
    .local v0, "bw":Ljava/io/BufferedWriter;
    invoke-virtual {v3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 328
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V

    .line 330
    return-void

    .line 311
    .end local v0    # "bw":Ljava/io/BufferedWriter;
    .end local v1    # "fw":Ljava/io/FileWriter;
    .end local v5    # "path":Ljava/lang/String;
    :cond_1
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/json/JSONObject;

    .line 312
    .local v4, "obj":Lorg/json/JSONObject;
    invoke-virtual {v3, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 310
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 316
    .end local v4    # "obj":Lorg/json/JSONObject;
    :cond_2
    const-string v6, "mp3"

    invoke-virtual {p0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 317
    const-string v6, "mp3.json"

    sput-object v6, Lcom/aio/downloader/utils/Myutils;->jsonfile:Ljava/lang/String;

    goto :goto_1

    .line 318
    :cond_3
    const-string v6, "ringtone"

    invoke-virtual {p0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 319
    const-string v6, "ringtone.json"

    sput-object v6, Lcom/aio/downloader/utils/Myutils;->jsonfile:Ljava/lang/String;

    goto :goto_1
.end method

.method public static setListViewHeightBasedOnChildren(Landroid/widget/ListView;)V
    .locals 7
    .param p0, "listView"    # Landroid/widget/ListView;

    .prologue
    const/4 v6, 0x0

    .line 208
    invoke-virtual {p0}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    .line 209
    .local v1, "listAdapter":Landroid/widget/ListAdapter;
    if-nez v1, :cond_0

    .line 224
    :goto_0
    return-void

    .line 213
    :cond_0
    const/4 v4, 0x0

    .line 214
    .local v4, "totalHeight":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v5

    if-lt v0, v5, :cond_1

    .line 220
    invoke-virtual {p0}, Landroid/widget/ListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 222
    .local v3, "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p0}, Landroid/widget/ListView;->getDividerHeight()I

    move-result v5

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    mul-int/2addr v5, v6

    add-int/2addr v5, v4

    .line 221
    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 223
    invoke-virtual {p0, v3}, Landroid/widget/ListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 215
    .end local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_1
    const/4 v5, 0x0

    invoke-interface {v1, v0, v5, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 216
    .local v2, "listItem":Landroid/view/View;
    invoke-virtual {v2, v6, v6}, Landroid/view/View;->measure(II)V

    .line 217
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    add-int/2addr v4, v5

    .line 214
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static timezhuanhua(J)Ljava/lang/String;
    .locals 2
    .param p0, "time"    # J

    .prologue
    .line 918
    const-string v1, "MM"

    invoke-static {v1, p0, p1}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 919
    .local v0, "month":Ljava/lang/String;
    const-string v1, "01"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 920
    const-string v0, "January"

    .line 945
    :cond_0
    :goto_0
    return-object v0

    .line 921
    :cond_1
    const-string v1, "02"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 922
    const-string v0, "February"

    .line 923
    goto :goto_0

    :cond_2
    const-string v1, "03"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 924
    const-string v0, "March"

    .line 925
    goto :goto_0

    :cond_3
    const-string v1, "04"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 926
    const-string v0, "April"

    .line 927
    goto :goto_0

    :cond_4
    const-string v1, "05"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 928
    const-string v0, "May"

    .line 929
    goto :goto_0

    :cond_5
    const-string v1, "06"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 930
    const-string v0, "June"

    .line 931
    goto :goto_0

    :cond_6
    const-string v1, "07"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 932
    const-string v0, "July"

    .line 933
    goto :goto_0

    :cond_7
    const-string v1, "08"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 934
    const-string v0, "August"

    .line 935
    goto :goto_0

    :cond_8
    const-string v1, "09"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 936
    const-string v0, "September"

    .line 937
    goto :goto_0

    :cond_9
    const-string v1, "10"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 938
    const-string v0, "October"

    .line 939
    goto :goto_0

    :cond_a
    const-string v1, "11"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 940
    const-string v0, "November"

    .line 941
    goto :goto_0

    :cond_b
    const-string v1, "12"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 942
    const-string v0, "December"

    goto :goto_0
.end method

.method private toTime(I)Ljava/lang/String;
    .locals 7
    .param p1, "time"    # I

    .prologue
    const/16 v6, 0xa

    .line 400
    div-int/lit16 v4, p1, 0x3e8

    div-int/lit8 v0, v4, 0x3c

    .line 401
    .local v0, "minute":I
    div-int/lit16 v4, p1, 0x3e8

    rem-int/lit8 v2, v4, 0x3c

    .line 402
    .local v2, "s":I
    const/4 v1, 0x0

    .line 403
    .local v1, "mm":Ljava/lang/String;
    const/4 v3, 0x0

    .line 404
    .local v3, "ss":Ljava/lang/String;
    if-ge v0, v6, :cond_0

    .line 405
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "0"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 409
    :goto_0
    if-ge v2, v6, :cond_1

    .line 410
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "0"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 414
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 407
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 412
    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_1
.end method

.method public static to_show_big_ad()Ljava/lang/Boolean;
    .locals 4

    .prologue
    .line 172
    sget-wide v0, Lcom/aio/downloader/utils/Myutils;->last_time_show_big_ad:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 173
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 174
    sget v2, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    div-int/lit8 v2, v2, 0x2

    int-to-long v2, v2

    .line 173
    sub-long/2addr v0, v2

    sput-wide v0, Lcom/aio/downloader/utils/Myutils;->last_time_show_big_ad:J

    .line 176
    :cond_0
    sget v0, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    if-lez v0, :cond_1

    .line 177
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/aio/downloader/utils/Myutils;->last_time_show_big_ad:J

    sub-long/2addr v0, v2

    sget v2, Lcom/aio/downloader/utils/Myutils;->big_ad_interval:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 178
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/aio/downloader/utils/Myutils;->last_time_show_big_ad:J

    .line 179
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 181
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method
