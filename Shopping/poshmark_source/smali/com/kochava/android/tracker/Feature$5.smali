.class Lcom/kochava/android/tracker/Feature$5;
.super Ljava/lang/Thread;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/Feature;->setAppLimitTracking(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/Feature;

.field private final synthetic val$shouldLimit:Z


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/Feature;Z)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$5;->this$0:Lcom/kochava/android/tracker/Feature;

    iput-boolean p2, p0, Lcom/kochava/android/tracker/Feature$5;->val$shouldLimit:Z

    .line 944
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 15
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 952
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 953
    .local v1, "appLimitDataHolder":Lorg/json/JSONObject;
    const-string v12, "action"

    const-string v13, "options"

    invoke-virtual {v1, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 955
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    .line 956
    .local v8, "optionsHolder":Lorg/json/JSONObject;
    iget-boolean v12, p0, Lcom/kochava/android/tracker/Feature$5;->val$shouldLimit:Z

    if-eqz v12, :cond_8

    .line 957
    const-string v12, "app_limit_tracking"

    const-string v13, "1"

    invoke-virtual {v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 961
    :goto_0
    const-string v12, "device_limit_tracking"

    const-string v13, "0"

    invoke-virtual {v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 963
    const-string v12, "data"

    invoke-virtual {v1, v12, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 965
    const-string v12, "kochava_app_id"

    iget-object v13, p0, Lcom/kochava/android/tracker/Feature$5;->this$0:Lcom/kochava/android/tracker/Feature;

    # getter for: Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;
    invoke-static {v13}, Lcom/kochava/android/tracker/Feature;->access$49(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v1, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 966
    const-string v12, "kochava_device_id"

    iget-object v13, p0, Lcom/kochava/android/tracker/Feature$5;->this$0:Lcom/kochava/android/tracker/Feature;

    # invokes: Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;
    invoke-static {v13}, Lcom/kochava/android/tracker/Feature;->access$18(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v1, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 968
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_0

    const-string v12, "KochavaTracker"

    const-string v13, "kv_options thread started."

    invoke-static {v12, v13}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 969
    :cond_0
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_1

    const-string v13, "KochavaTracker"

    new-instance v14, Ljava/lang/StringBuilder;

    const-string v12, "kv_options post: "

    invoke-direct {v14, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    instance-of v12, v1, Lorg/json/JSONObject;

    if-nez v12, :cond_9

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v12

    :goto_1
    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v13, v12}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 972
    :cond_1
    iget-object v12, p0, Lcom/kochava/android/tracker/Feature$5;->this$0:Lcom/kochava/android/tracker/Feature;

    const/4 v13, 0x1

    # invokes: Lcom/kochava/android/tracker/Feature;->createHttpClient(Z)Lorg/apache/http/client/HttpClient;
    invoke-static {v12, v13}, Lcom/kochava/android/tracker/Feature;->access$38(Lcom/kochava/android/tracker/Feature;Z)Lorg/apache/http/client/HttpClient;

    move-result-object v6

    .line 974
    .local v6, "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-interface {v6}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v12

    iget-object v13, p0, Lcom/kochava/android/tracker/Feature$5;->this$0:Lcom/kochava/android/tracker/Feature;

    # getter for: Lcom/kochava/android/tracker/Feature;->mUserAgent:Ljava/lang/String;
    invoke-static {v13}, Lcom/kochava/android/tracker/Feature;->access$39(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 976
    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_2

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->isEmpty()Z

    move-result v12

    if-eqz v12, :cond_4

    .line 978
    :cond_2
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_3

    const-string v12, "KochavaTracker"

    const-string v13, "setAppLimitTracking - hostControl was empty, using default"

    invoke-static {v12, v13}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 979
    :cond_3
    const-string v12, "control.kochava.com"

    invoke-static {v12}, Lcom/kochava/android/tracker/Feature;->access$41(Ljava/lang/String;)V

    .line 982
    :cond_4
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_5

    const-string v12, "KochavaTracker"

    new-instance v13, Ljava/lang/StringBuilder;

    const-string v14, "setAppLimitTracking - posting to "

    invoke-direct {v13, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v14, "https://"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "/track/kv_options.php"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 983
    :cond_5
    new-instance v7, Lorg/apache/http/client/methods/HttpPost;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "https://"

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "/track/kv_options.php"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v7, v12}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 986
    .local v7, "httppost":Lorg/apache/http/client/methods/HttpPost;
    instance-of v12, v1, Lorg/json/JSONObject;

    if-nez v12, :cond_a

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    .line 988
    .end local v1    # "appLimitDataHolder":Lorg/json/JSONObject;
    .local v3, "data":Ljava/lang/String;
    :goto_2
    new-instance v11, Lorg/apache/http/entity/StringEntity;

    const-string v12, "UTF-8"

    invoke-direct {v11, v3, v12}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 989
    .local v11, "sentity":Lorg/apache/http/entity/StringEntity;
    new-instance v2, Lorg/apache/http/message/BasicHeader;

    const-string v12, "Content-Type"

    const-string v13, "application/xml"

    invoke-direct {v2, v12, v13}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 990
    .local v2, "basicHeader":Lorg/apache/http/message/BasicHeader;
    invoke-virtual {v7}, Lorg/apache/http/client/methods/HttpPost;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v12

    const-string v13, "http.protocol.expect-continue"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Lorg/apache/http/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lorg/apache/http/params/HttpParams;

    .line 991
    invoke-virtual {v11, v2}, Lorg/apache/http/entity/StringEntity;->setContentType(Lorg/apache/http/Header;)V

    .line 992
    invoke-virtual {v7, v11}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 993
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_6

    const-string v12, "KochavaTracker"

    const-string v13, "Trying to post to kv_options."

    invoke-static {v12, v13}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 994
    :cond_6
    instance-of v12, v6, Lorg/apache/http/client/HttpClient;

    if-nez v12, :cond_b

    invoke-interface {v6, v7}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    .line 995
    .end local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    .local v9, "response":Lorg/apache/http/HttpResponse;
    :goto_3
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v5

    .line 996
    .local v5, "entity":Lorg/apache/http/HttpEntity;
    if-nez v5, :cond_c

    .line 998
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v12, :cond_7

    const-string v12, "KochavaTracker"

    const-string v13, "Could not get a response entity from kv_options."

    invoke-static {v12, v13}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1021
    .end local v2    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v3    # "data":Ljava/lang/String;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v7    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v8    # "optionsHolder":Lorg/json/JSONObject;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_7
    :goto_4
    return-void

    .line 959
    .restart local v1    # "appLimitDataHolder":Lorg/json/JSONObject;
    .restart local v8    # "optionsHolder":Lorg/json/JSONObject;
    :cond_8
    const-string v12, "app_limit_tracking"

    const-string v13, "0"

    invoke-virtual {v8, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto/16 :goto_0

    .line 1006
    .end local v1    # "appLimitDataHolder":Lorg/json/JSONObject;
    .end local v8    # "optionsHolder":Lorg/json/JSONObject;
    :catch_0
    move-exception v4

    .line 1008
    .local v4, "e":Lorg/apache/http/client/ClientProtocolException;
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_7

    const-string v12, "KochavaTracker"

    const-string v13, "TrackTask"

    invoke-static {v12, v13, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_4

    .line 969
    .end local v4    # "e":Lorg/apache/http/client/ClientProtocolException;
    .restart local v1    # "appLimitDataHolder":Lorg/json/JSONObject;
    .restart local v8    # "optionsHolder":Lorg/json/JSONObject;
    :cond_9
    :try_start_1
    move-object v0, v1

    check-cast v0, Lorg/json/JSONObject;

    move-object v12, v0

    invoke-static {v12}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v12

    goto/16 :goto_1

    .line 986
    .restart local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    .restart local v7    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    :cond_a
    check-cast v1, Lorg/json/JSONObject;

    .end local v1    # "appLimitDataHolder":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v3

    goto :goto_2

    .line 994
    .restart local v2    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v3    # "data":Ljava/lang/String;
    .restart local v11    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_b
    check-cast v6, Lorg/apache/http/client/HttpClient;

    .end local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-static {v6, v7}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    goto :goto_3

    .line 1002
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v9    # "response":Lorg/apache/http/HttpResponse;
    :cond_c
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_d

    const-string v12, "KochavaTracker"

    const-string v13, "(kv_options) Grabbing Result..."

    invoke-static {v12, v13}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1003
    :cond_d
    invoke-interface {v5}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v12

    invoke-static {v12}, Lcom/kochava/android/util/StringUtils;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v10

    .line 1004
    .local v10, "result":Ljava/lang/String;
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_7

    const-string v12, "KochavaTracker"

    new-instance v13, Ljava/lang/StringBuilder;

    const-string v14, "(kv_options) Result: "

    invoke-direct {v13, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v13, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_4

    .line 1011
    .end local v2    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v3    # "data":Ljava/lang/String;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v7    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v8    # "optionsHolder":Lorg/json/JSONObject;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    .end local v10    # "result":Ljava/lang/String;
    .end local v11    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_1
    move-exception v4

    .line 1013
    .local v4, "e":Ljava/io/IOException;
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v12, :cond_7

    const-string v12, "KochavaTracker"

    const-string v13, "TrackTask"

    invoke-static {v12, v13, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_4

    .line 1016
    .end local v4    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v4

    .line 1018
    .local v4, "e":Ljava/lang/Exception;
    sget-boolean v12, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v12, :cond_7

    const-string v12, "KochavaTracker"

    const-string v13, "Unexpected error during kv_options communication."

    invoke-static {v12, v13, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_4
.end method
