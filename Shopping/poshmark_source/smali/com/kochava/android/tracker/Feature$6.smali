.class Lcom/kochava/android/tracker/Feature$6;
.super Ljava/lang/Thread;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/Feature;->getAd(Landroid/webkit/WebView;Landroid/app/Activity;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/Feature;

.field private final synthetic val$adWebview:Landroid/webkit/WebView;

.field private final synthetic val$context:Landroid/app/Activity;

.field private final synthetic val$height:I

.field private final synthetic val$width:I


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/Feature;Landroid/app/Activity;IILandroid/webkit/WebView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    iput-object p2, p0, Lcom/kochava/android/tracker/Feature$6;->val$context:Landroid/app/Activity;

    iput p3, p0, Lcom/kochava/android/tracker/Feature$6;->val$width:I

    iput p4, p0, Lcom/kochava/android/tracker/Feature$6;->val$height:I

    iput-object p5, p0, Lcom/kochava/android/tracker/Feature$6;->val$adWebview:Landroid/webkit/WebView;

    .line 2072
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 28
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 2083
    const-string v25, ""

    .line 2088
    .local v25, "responseString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/kochava/android/tracker/Feature$6;->val$context:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v21

    .line 2091
    .local v21, "pm":Landroid/content/pm/PackageManager;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    # invokes: Lcom/kochava/android/tracker/Feature;->getAppPackageName()Ljava/lang/String;
    invoke-static {v3}, Lcom/kochava/android/tracker/Feature;->access$50(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    .line 2095
    .local v9, "ai":Landroid/content/pm/ApplicationInfo;
    :goto_0
    if-eqz v9, :cond_6

    move-object/from16 v0, v21

    invoke-virtual {v0, v9}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v10

    :goto_1
    check-cast v10, Ljava/lang/String;

    .line 2098
    .local v10, "applicationName":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    const/4 v4, 0x0

    # invokes: Lcom/kochava/android/tracker/Feature;->createHttpClient(Z)Lorg/apache/http/client/HttpClient;
    invoke-static {v3, v4}, Lcom/kochava/android/tracker/Feature;->access$38(Lcom/kochava/android/tracker/Feature;Z)Lorg/apache/http/client/HttpClient;

    move-result-object v15

    .line 2100
    .local v15, "httpclient":Lorg/apache/http/client/HttpClient;
    const/16 v22, 0x0

    .line 2102
    .local v22, "reader":Ljava/io/Reader;
    const/16 v24, 0x0

    .line 2105
    .local v24, "response":Lorg/apache/http/HttpResponse;
    :try_start_1
    # getter for: Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$51()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    # getter for: Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$51()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 2106
    :cond_0
    const-string v3, "bidder.kochava.com"

    invoke-static {v3}, Lcom/kochava/android/tracker/Feature;->access$52(Ljava/lang/String;)V

    .line 2108
    :cond_1
    new-instance v16, Lorg/apache/http/client/methods/HttpGet;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$51()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/adserver/request/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2109
    const-string v4, "?w="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/kochava/android/tracker/Feature$6;->val$width:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2110
    const-string v4, "&h="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/kochava/android/tracker/Feature$6;->val$height:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2111
    const-string v4, "&odin="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    # invokes: Lcom/kochava/android/tracker/Feature;->getOdin()Ljava/lang/String;
    invoke-static {v4}, Lcom/kochava/android/tracker/Feature;->access$53(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2112
    const-string v4, "&aid="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    # getter for: Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;
    invoke-static {v4}, Lcom/kochava/android/tracker/Feature;->access$49(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2113
    const-string v4, "&an="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2114
    const-string v4, "&av="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "Android20140428"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2115
    const-string v4, "&kochava_device_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/kochava/android/tracker/Feature$6;->this$0:Lcom/kochava/android/tracker/Feature;

    # invokes: Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;
    invoke-static {v4}, Lcom/kochava/android/tracker/Feature;->access$18(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 2108
    move-object/from16 v0, v16

    invoke-direct {v0, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 2120
    .local v16, "httppost":Lorg/apache/http/client/methods/HttpGet;
    instance-of v3, v15, Lorg/apache/http/client/HttpClient;

    if-nez v3, :cond_7

    invoke-interface/range {v15 .. v16}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v24

    .line 2123
    .end local v15    # "httpclient":Lorg/apache/http/client/HttpClient;
    :goto_2
    invoke-interface/range {v24 .. v24}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v14

    .line 2126
    .local v14, "entity":Lorg/apache/http/HttpEntity;
    if-eqz v14, :cond_2

    .line 2128
    invoke-interface {v14}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v17

    .line 2129
    .local v17, "is":Ljava/io/InputStream;
    new-instance v23, Ljava/io/InputStreamReader;

    const-string v3, "ISO-8859-1"

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_2

    .line 2130
    .end local v22    # "reader":Ljava/io/Reader;
    .local v23, "reader":Ljava/io/Reader;
    :try_start_2
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    .line 2131
    .local v11, "buffer":Ljava/lang/StringBuilder;
    const/16 v3, 0x400

    new-array v0, v3, [C

    move-object/from16 v27, v0

    .line 2133
    .local v27, "tmp":[C
    :goto_3
    move-object/from16 v0, v23

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/io/Reader;->read([C)I

    move-result v18

    .local v18, "l":I
    const/4 v3, -0x1

    move/from16 v0, v18

    if-ne v0, v3, :cond_8

    .line 2138
    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_2 .. :try_end_2} :catch_3

    move-result-object v25

    move-object/from16 v22, v23

    .line 2158
    .end local v11    # "buffer":Ljava/lang/StringBuilder;
    .end local v14    # "entity":Lorg/apache/http/HttpEntity;
    .end local v16    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .end local v17    # "is":Ljava/io/InputStream;
    .end local v18    # "l":I
    .end local v23    # "reader":Ljava/io/Reader;
    .end local v27    # "tmp":[C
    .restart local v22    # "reader":Ljava/io/Reader;
    :cond_2
    :goto_4
    const-string v26, ""

    .line 2159
    .local v26, "temp":Ljava/lang/String;
    const-string v8, ""

    .line 2161
    .local v8, "adUrl":Ljava/lang/String;
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_3

    .line 2162
    const-string v3, "KochavaAds"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "Response:"

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2164
    :cond_3
    const-string v3, "href=\'(.*?)\'"

    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v20

    .line 2165
    .local v20, "pattern":Ljava/util/regex/Pattern;
    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v19

    .line 2166
    .local v19, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual/range {v19 .. v19}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 2168
    const/4 v3, 0x1

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v26

    .line 2171
    :cond_4
    move-object/from16 v7, v26

    .line 2174
    .local v7, "clickUrl":Ljava/lang/String;
    const-string v3, "src=\'(.*?)\'"

    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v20

    .line 2175
    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v19

    .line 2176
    invoke-virtual/range {v19 .. v19}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 2178
    const/4 v3, 0x1

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    .line 2181
    :cond_5
    move-object v5, v8

    .line 2184
    .local v5, "fAdUrl":Ljava/lang/String;
    new-instance v2, Lcom/kochava/android/tracker/Feature$6$1;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/kochava/android/tracker/Feature$6;->val$adWebview:Landroid/webkit/WebView;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/kochava/android/tracker/Feature$6;->val$context:Landroid/app/Activity;

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lcom/kochava/android/tracker/Feature$6$1;-><init>(Lcom/kochava/android/tracker/Feature$6;Landroid/webkit/WebView;Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;)V

    .line 2256
    .local v2, "updateUI":Ljava/lang/Thread;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/kochava/android/tracker/Feature$6;->val$context:Landroid/app/Activity;

    invoke-virtual {v3, v2}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2262
    return-void

    .line 2092
    .end local v2    # "updateUI":Ljava/lang/Thread;
    .end local v5    # "fAdUrl":Ljava/lang/String;
    .end local v7    # "clickUrl":Ljava/lang/String;
    .end local v8    # "adUrl":Ljava/lang/String;
    .end local v9    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v10    # "applicationName":Ljava/lang/String;
    .end local v19    # "matcher":Ljava/util/regex/Matcher;
    .end local v20    # "pattern":Ljava/util/regex/Pattern;
    .end local v22    # "reader":Ljava/io/Reader;
    .end local v24    # "response":Lorg/apache/http/HttpResponse;
    .end local v26    # "temp":Ljava/lang/String;
    :catch_0
    move-exception v12

    .line 2093
    .local v12, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v9, 0x0

    .restart local v9    # "ai":Landroid/content/pm/ApplicationInfo;
    goto/16 :goto_0

    .line 2095
    .end local v12    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    const-string v10, "(unknown)"

    goto/16 :goto_1

    .line 2120
    .restart local v10    # "applicationName":Ljava/lang/String;
    .restart local v15    # "httpclient":Lorg/apache/http/client/HttpClient;
    .restart local v16    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .restart local v22    # "reader":Ljava/io/Reader;
    .restart local v24    # "response":Lorg/apache/http/HttpResponse;
    :cond_7
    :try_start_3
    check-cast v15, Lorg/apache/http/client/HttpClient;

    .end local v15    # "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-static/range {v15 .. v16}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v24

    goto/16 :goto_2

    .line 2135
    .end local v22    # "reader":Ljava/io/Reader;
    .restart local v11    # "buffer":Ljava/lang/StringBuilder;
    .restart local v14    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v17    # "is":Ljava/io/InputStream;
    .restart local v18    # "l":I
    .restart local v23    # "reader":Ljava/io/Reader;
    .restart local v27    # "tmp":[C
    :cond_8
    const/4 v3, 0x0

    :try_start_4
    move-object/from16 v0, v27

    move/from16 v1, v18

    invoke-virtual {v11, v0, v3, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_4 .. :try_end_4} :catch_3

    goto/16 :goto_3

    .line 2142
    .end local v11    # "buffer":Ljava/lang/StringBuilder;
    .end local v18    # "l":I
    .end local v27    # "tmp":[C
    :catch_1
    move-exception v12

    move-object/from16 v22, v23

    .line 2144
    .end local v14    # "entity":Lorg/apache/http/HttpEntity;
    .end local v16    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .end local v17    # "is":Ljava/io/InputStream;
    .end local v23    # "reader":Ljava/io/Reader;
    .local v12, "e":Ljava/io/IOException;
    .restart local v22    # "reader":Ljava/io/Reader;
    :goto_5
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_9

    .line 2145
    const-string v3, "KochavaAds"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "Problem grabbing ad: "

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2146
    :cond_9
    invoke-virtual {v12}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_4

    .line 2148
    .end local v12    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v13

    .line 2150
    .local v13, "e1":Ljava/security/NoSuchAlgorithmException;
    :goto_6
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_a

    .line 2151
    const-string v3, "KochavaAds"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "Problem grabbing ad: "

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v13}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2152
    :cond_a
    invoke-virtual {v13}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto/16 :goto_4

    .line 2148
    .end local v13    # "e1":Ljava/security/NoSuchAlgorithmException;
    .end local v22    # "reader":Ljava/io/Reader;
    .restart local v14    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v16    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .restart local v17    # "is":Ljava/io/InputStream;
    .restart local v23    # "reader":Ljava/io/Reader;
    :catch_3
    move-exception v13

    move-object/from16 v22, v23

    .end local v23    # "reader":Ljava/io/Reader;
    .restart local v22    # "reader":Ljava/io/Reader;
    goto :goto_6

    .line 2142
    .end local v14    # "entity":Lorg/apache/http/HttpEntity;
    .end local v16    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .end local v17    # "is":Ljava/io/InputStream;
    :catch_4
    move-exception v12

    goto :goto_5
.end method
