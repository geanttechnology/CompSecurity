.class Lcom/kochava/android/tracker/Feature$4;
.super Ljava/lang/Object;
.source "Feature.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/Feature;

.field private final synthetic val$sendOnStart:Z


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/Feature;Z)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    iput-boolean p2, p0, Lcom/kochava/android/tracker/Feature$4;->val$sendOnStart:Z

    .line 667
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 27
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 675
    :try_start_0
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_0

    const-string v23, "KochavaTracker"

    const-string v24, "getKVinit thread started."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 676
    :cond_0
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_1

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "getKVinit post: "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    instance-of v0, v0, Lorg/json/JSONObject;

    move/from16 v26, v0

    if-nez v26, :cond_9

    invoke-virtual/range {v23 .. v23}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_0
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 679
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    const/16 v24, 0x1

    # invokes: Lcom/kochava/android/tracker/Feature;->createHttpClient(Z)Lorg/apache/http/client/HttpClient;
    invoke-static/range {v23 .. v24}, Lcom/kochava/android/tracker/Feature;->access$38(Lcom/kochava/android/tracker/Feature;Z)Lorg/apache/http/client/HttpClient;

    move-result-object v13

    .line 681
    .local v13, "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-interface {v13}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v23

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v24, v0

    # getter for: Lcom/kochava/android/tracker/Feature;->mUserAgent:Ljava/lang/String;
    invoke-static/range {v24 .. v24}, Lcom/kochava/android/tracker/Feature;->access$39(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 685
    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v23

    if-eqz v23, :cond_2

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->isEmpty()Z

    move-result v23

    if-eqz v23, :cond_4

    .line 687
    :cond_2
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_3

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit - hostControl was empty, using default"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 688
    :cond_3
    const-string v23, "control.kochava.com"

    invoke-static/range {v23 .. v23}, Lcom/kochava/android/tracker/Feature;->access$41(Ljava/lang/String;)V

    .line 691
    :cond_4
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_5

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "KVinit - posting to "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v25, "https://"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, "/track/kvinit"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 692
    :cond_5
    new-instance v14, Lorg/apache/http/client/methods/HttpPost;

    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "https://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$40()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, "/track/kvinit"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v23

    invoke-direct {v14, v0}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 697
    .local v14, "httppost":Lorg/apache/http/client/methods/HttpPost;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    instance-of v0, v0, Lorg/json/JSONObject;

    move/from16 v24, v0

    if-nez v24, :cond_a

    invoke-virtual/range {v23 .. v23}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    .line 698
    .local v8, "data":Ljava/lang/String;
    :goto_1
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_6

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "kvinit data:"

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 700
    :cond_6
    new-instance v22, Lorg/apache/http/entity/StringEntity;

    const-string v23, "UTF-8"

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-direct {v0, v8, v1}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 701
    .local v22, "sentity":Lorg/apache/http/entity/StringEntity;
    new-instance v4, Lorg/apache/http/message/BasicHeader;

    const-string v23, "Content-Type"

    const-string v24, "application/xml"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-direct {v4, v0, v1}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 702
    .local v4, "basicHeader":Lorg/apache/http/message/BasicHeader;
    invoke-virtual {v14}, Lorg/apache/http/client/methods/HttpPost;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v23

    const-string v24, "http.protocol.expect-continue"

    const/16 v25, 0x0

    invoke-interface/range {v23 .. v25}, Lorg/apache/http/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lorg/apache/http/params/HttpParams;

    .line 703
    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Lorg/apache/http/entity/StringEntity;->setContentType(Lorg/apache/http/Header;)V

    .line 704
    move-object/from16 v0, v22

    invoke-virtual {v14, v0}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 706
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_7

    const-string v23, "KochavaTracker"

    const-string v24, "Trying to post to KVinit."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 707
    :cond_7
    instance-of v0, v13, Lorg/apache/http/client/HttpClient;

    move/from16 v23, v0

    if-nez v23, :cond_b

    invoke-interface {v13, v14}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v20

    .line 708
    .end local v13    # "httpclient":Lorg/apache/http/client/HttpClient;
    .local v20, "response":Lorg/apache/http/HttpResponse;
    :goto_2
    invoke-interface/range {v20 .. v20}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v10

    .line 710
    .local v10, "entity":Lorg/apache/http/HttpEntity;
    if-nez v10, :cond_c

    .line 712
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v23, :cond_8

    const-string v23, "KochavaTracker"

    const-string v24, "Could not get a response entity from KVinit."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 932
    .end local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v8    # "data":Ljava/lang/String;
    .end local v10    # "entity":Lorg/apache/http/HttpEntity;
    .end local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v20    # "response":Lorg/apache/http/HttpResponse;
    .end local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_8
    :goto_3
    return-void

    .line 676
    :cond_9
    check-cast v23, Lorg/json/JSONObject;

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v23

    goto/16 :goto_0

    .line 697
    .restart local v13    # "httpclient":Lorg/apache/http/client/HttpClient;
    .restart local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    :cond_a
    check-cast v23, Lorg/json/JSONObject;

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    goto :goto_1

    .line 707
    .restart local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v8    # "data":Ljava/lang/String;
    .restart local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_b
    check-cast v13, Lorg/apache/http/client/HttpClient;

    .end local v13    # "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-static {v13, v14}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7

    move-result-object v20

    goto :goto_2

    .line 718
    .restart local v10    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v20    # "response":Lorg/apache/http/HttpResponse;
    :cond_c
    :try_start_1
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_d

    const-string v23, "KochavaTracker"

    const-string v24, "(KVinit) Grabbing Result..."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 719
    :cond_d
    invoke-interface {v10}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Lcom/kochava/android/util/StringUtils;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v21

    .line 720
    .local v21, "result":Ljava/lang/String;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_e

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "(KVinit) Result: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_7

    .line 721
    :cond_e
    const/16 v19, 0x0

    .line 727
    .local v19, "parsedResult":Lorg/json/JSONObject;
    :try_start_2
    new-instance v23, Lorg/json/JSONObject;

    invoke-static/range {v21 .. v21}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_2 .. :try_end_2} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_7

    move-result-object v19

    .line 734
    :cond_f
    :goto_4
    if-eqz v19, :cond_20

    .line 736
    :try_start_3
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_10

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "(KVinit) Parsed result: "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v19

    instance-of v0, v0, Lorg/json/JSONObject;

    move/from16 v23, v0

    if-nez v23, :cond_22

    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_5
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_3 .. :try_end_3} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_7

    .line 741
    :cond_10
    const/4 v3, 0x0

    .line 745
    .local v3, "attributionData":Lorg/json/JSONObject;
    :try_start_4
    const-string v23, "attribution"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_4 .. :try_end_4} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_7

    move-result-object v3

    .line 753
    :cond_11
    :goto_6
    :try_start_5
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_12

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "attribution data null? "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-nez v3, :cond_23

    const/16 v23, 0x1

    :goto_7
    move-object/from16 v0, v25

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 754
    :cond_12
    if-eqz v3, :cond_15

    invoke-virtual {v3}, Lorg/json/JSONObject;->length()I

    move-result v23

    if-lez v23, :cond_15

    .line 756
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_13

    const-string v23, "KochavaTracker"

    const-string v24, "Found attribution data"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 757
    :cond_13
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_14

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "attribution data: "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    instance-of v0, v3, Lorg/json/JSONObject;

    move/from16 v23, v0

    if-nez v23, :cond_24

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_8
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_5 .. :try_end_5} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_7

    .line 760
    :cond_14
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    # getter for: Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;
    invoke-static/range {v23 .. v23}, Lcom/kochava/android/tracker/Feature;->access$42(Lcom/kochava/android/tracker/Feature;)Landroid/content/SharedPreferences;

    move-result-object v23

    invoke-interface/range {v23 .. v23}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v24

    const-string v25, "attributionData"

    instance-of v0, v3, Lorg/json/JSONObject;

    move/from16 v23, v0

    if-nez v23, :cond_25

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_9
    move-object/from16 v0, v24

    move-object/from16 v1, v25

    move-object/from16 v2, v23

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v23

    invoke-interface/range {v23 .. v23}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 762
    # getter for: Lcom/kochava/android/tracker/Feature;->attributionDataHandler:Landroid/os/Handler;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$43()Landroid/os/Handler;

    move-result-object v23

    if-eqz v23, :cond_15

    .line 764
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v17

    .line 765
    .local v17, "message":Landroid/os/Message;
    new-instance v18, Landroid/os/Bundle;

    invoke-direct/range {v18 .. v18}, Landroid/os/Bundle;-><init>()V

    .line 766
    .local v18, "messageData":Landroid/os/Bundle;
    const-string v24, "attributionData"

    instance-of v0, v3, Lorg/json/JSONObject;

    move/from16 v23, v0

    if-nez v23, :cond_26

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    .end local v3    # "attributionData":Lorg/json/JSONObject;
    :goto_a
    move-object/from16 v0, v18

    move-object/from16 v1, v24

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 767
    invoke-virtual/range {v17 .. v18}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 768
    # getter for: Lcom/kochava/android/tracker/Feature;->attributionDataHandler:Landroid/os/Handler;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$43()Landroid/os/Handler;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_e
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_6 .. :try_end_6} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_6 .. :try_end_6} :catch_2

    .line 777
    .end local v17    # "message":Landroid/os/Message;
    .end local v18    # "messageData":Landroid/os/Bundle;
    :cond_15
    :goto_b
    const/4 v12, 0x0

    .line 780
    .local v12, "flags":Lorg/json/JSONObject;
    :try_start_7
    const-string v23, "flags"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 781
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_16

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "Flags: "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    instance-of v0, v12, Lorg/json/JSONObject;

    move/from16 v23, v0

    if-nez v23, :cond_27

    invoke-virtual {v12}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_c
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_6
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_7 .. :try_end_7} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_7

    .line 790
    :cond_16
    :goto_d
    if-eqz v12, :cond_1d

    .line 795
    :try_start_8
    const-string v23, "kochava_app_id"

    move-object/from16 v0, v23

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 796
    .local v16, "kochava_app_id":Ljava/lang/String;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_17

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "kochava_app_id: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 797
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, v16

    invoke-static {v0, v1}, Lcom/kochava/android/tracker/Feature;->access$44(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_8 .. :try_end_8} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_8 .. :try_end_8} :catch_2
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_7

    .line 806
    .end local v16    # "kochava_app_id":Ljava/lang/String;
    :cond_18
    :goto_e
    :try_start_9
    const-string v23, "session_tracking"

    move-object/from16 v0, v23

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    const-string v24, "none"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_19

    .line 807
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-static/range {v23 .. v24}, Lcom/kochava/android/tracker/Feature;->access$45(Lcom/kochava/android/tracker/Feature;Z)V
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_9 .. :try_end_9} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_7

    .line 816
    :cond_19
    :goto_f
    :try_start_a
    const-string v23, "currency"

    move-object/from16 v0, v23

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/String;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v7

    .line 817
    .local v7, "currency":Ljava/lang/String;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_1a

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "setting currency to: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 818
    :cond_1a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    # invokes: Lcom/kochava/android/tracker/Feature;->setCurrency(Ljava/lang/String;)V
    invoke-static {v0, v7}, Lcom/kochava/android/tracker/Feature;->access$46(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_d
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_a .. :try_end_a} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_a .. :try_end_a} :catch_2

    .line 826
    .end local v7    # "currency":Ljava/lang/String;
    :goto_10
    :try_start_b
    const-string v23, "resend_initial"

    move-object/from16 v0, v23

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    const-string v24, "true"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-nez v23, :cond_1b

    const-string v23, "resend_initial"

    move-object/from16 v0, v23

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    const-string v24, "detailed"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_1d

    .line 828
    :cond_1b
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_1c

    const-string v23, "KochavaTracker"

    const-string v24, "resend_initial flag triggered."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 829
    :cond_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v24, v0

    # getter for: Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;
    invoke-static/range {v24 .. v24}, Lcom/kochava/android/tracker/Feature;->access$9(Lcom/kochava/android/tracker/Feature;)Landroid/content/Context;

    move-result-object v24

    const-string v25, "initPrefs"

    const/16 v26, 0x0

    invoke-virtual/range {v24 .. v26}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Lcom/kochava/android/tracker/Feature;->access$20(Lcom/kochava/android/tracker/Feature;Landroid/content/SharedPreferences;)V

    .line 830
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    # getter for: Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;
    invoke-static/range {v23 .. v23}, Lcom/kochava/android/tracker/Feature;->access$21(Lcom/kochava/android/tracker/Feature;)Landroid/content/SharedPreferences;

    move-result-object v23

    invoke-interface/range {v23 .. v23}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v23

    const-string v24, "initBool"

    const-string v25, "false"

    invoke-interface/range {v23 .. v25}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v23

    invoke-interface/range {v23 .. v23}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_c
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_b .. :try_end_b} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_b .. :try_end_b} :catch_2

    .line 841
    :cond_1d
    :goto_11
    :try_start_c
    const-string v23, "blacklist"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 842
    .local v5, "blacklist":Lorg/json/JSONArray;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_1e

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v23, "blacklist: "

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    instance-of v0, v5, Lorg/json/JSONArray;

    move/from16 v23, v0

    if-nez v23, :cond_28

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v23

    :goto_12
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 843
    :cond_1e
    const/4 v6, 0x0

    .line 844
    .local v6, "blacklistedOpenUDID":Z
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_13
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I
    :try_end_c
    .catch Lorg/json/JSONException; {:try_start_c .. :try_end_c} :catch_a
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_c .. :try_end_c} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_c .. :try_end_c} :catch_2
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_7

    move-result v23

    move/from16 v0, v23

    if-lt v15, v0, :cond_29

    .line 887
    .end local v5    # "blacklist":Lorg/json/JSONArray;
    .end local v6    # "blacklistedOpenUDID":Z
    .end local v15    # "i":I
    :cond_1f
    :goto_14
    :try_start_d
    const-string v23, "error"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 888
    .local v11, "error":Ljava/lang/String;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v23, :cond_20

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "There was a problem getting the KVinit response: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_d
    .catch Lorg/json/JSONException; {:try_start_d .. :try_end_d} :catch_b
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_d .. :try_end_d} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_d .. :try_end_d} :catch_2
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_7

    .line 924
    .end local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v8    # "data":Ljava/lang/String;
    .end local v10    # "entity":Lorg/apache/http/HttpEntity;
    .end local v11    # "error":Ljava/lang/String;
    .end local v12    # "flags":Lorg/json/JSONObject;
    .end local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v19    # "parsedResult":Lorg/json/JSONObject;
    .end local v20    # "response":Lorg/apache/http/HttpResponse;
    .end local v21    # "result":Ljava/lang/String;
    .end local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_20
    :goto_15
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_21

    const-string v23, "KochavaTracker"

    const-string v24, "getKVinit thread ended, sending message to initHandler."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 925
    :cond_21
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v17

    .line 926
    .restart local v17    # "message":Landroid/os/Message;
    new-instance v18, Landroid/os/Bundle;

    invoke-direct/range {v18 .. v18}, Landroid/os/Bundle;-><init>()V

    .line 927
    .restart local v18    # "messageData":Landroid/os/Bundle;
    const-string v23, "sendonstart"

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/kochava/android/tracker/Feature$4;->val$sendOnStart:Z

    move/from16 v24, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 928
    invoke-virtual/range {v17 .. v18}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 929
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature$4;->this$0:Lcom/kochava/android/tracker/Feature;

    move-object/from16 v23, v0

    # getter for: Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;
    invoke-static/range {v23 .. v23}, Lcom/kochava/android/tracker/Feature;->access$48(Lcom/kochava/android/tracker/Feature;)Landroid/os/Handler;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_3

    .line 729
    .end local v17    # "message":Landroid/os/Message;
    .end local v18    # "messageData":Landroid/os/Bundle;
    .restart local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v8    # "data":Ljava/lang/String;
    .restart local v10    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v19    # "parsedResult":Lorg/json/JSONObject;
    .restart local v20    # "response":Lorg/apache/http/HttpResponse;
    .restart local v21    # "result":Ljava/lang/String;
    .restart local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_0
    move-exception v9

    .line 731
    .local v9, "e":Lorg/json/JSONException;
    :try_start_e
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v23, :cond_f

    const-string v23, "KochavaTracker"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "Error while parsing result json: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_e .. :try_end_e} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_e .. :try_end_e} :catch_2
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_7

    goto/16 :goto_4

    .line 896
    .end local v9    # "e":Lorg/json/JSONException;
    .end local v19    # "parsedResult":Lorg/json/JSONObject;
    .end local v21    # "result":Ljava/lang/String;
    :catch_1
    move-exception v9

    .line 898
    .local v9, "e":Ljava/io/IOException;
    :try_start_f
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_8

    const-string v23, "KochavaTracker"

    const-string v24, "TrackTask"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_f
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_f .. :try_end_f} :catch_2
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_5
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_7

    goto/16 :goto_3

    .line 907
    .end local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v8    # "data":Ljava/lang/String;
    .end local v9    # "e":Ljava/io/IOException;
    .end local v10    # "entity":Lorg/apache/http/HttpEntity;
    .end local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v20    # "response":Lorg/apache/http/HttpResponse;
    .end local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_2
    move-exception v9

    .line 909
    .local v9, "e":Lorg/apache/http/client/ClientProtocolException;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_8

    const-string v23, "KochavaTracker"

    const-string v24, "TrackTask"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_3

    .line 736
    .end local v9    # "e":Lorg/apache/http/client/ClientProtocolException;
    .restart local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v8    # "data":Ljava/lang/String;
    .restart local v10    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v19    # "parsedResult":Lorg/json/JSONObject;
    .restart local v20    # "response":Lorg/apache/http/HttpResponse;
    .restart local v21    # "result":Ljava/lang/String;
    .restart local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_22
    :try_start_10
    move-object/from16 v0, v19

    check-cast v0, Lorg/json/JSONObject;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v23

    goto/16 :goto_5

    .line 747
    .restart local v3    # "attributionData":Lorg/json/JSONObject;
    :catch_3
    move-exception v9

    .line 749
    .local v9, "e":Lorg/json/JSONException;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_11

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain attribution data (or it was not requested)."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_10 .. :try_end_10} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_10 .. :try_end_10} :catch_2
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_7

    goto/16 :goto_6

    .line 901
    .end local v3    # "attributionData":Lorg/json/JSONObject;
    .end local v9    # "e":Lorg/json/JSONException;
    .end local v19    # "parsedResult":Lorg/json/JSONObject;
    .end local v21    # "result":Ljava/lang/String;
    :catch_4
    move-exception v9

    .line 903
    .local v9, "e":Ljava/lang/OutOfMemoryError;
    :try_start_11
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_8

    const-string v23, "KochavaTracker"

    const-string v24, "TrackTask"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_11
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_11 .. :try_end_11} :catch_2
    .catch Ljava/io/IOException; {:try_start_11 .. :try_end_11} :catch_5
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_7

    goto/16 :goto_3

    .line 912
    .end local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v8    # "data":Ljava/lang/String;
    .end local v9    # "e":Ljava/lang/OutOfMemoryError;
    .end local v10    # "entity":Lorg/apache/http/HttpEntity;
    .end local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v20    # "response":Lorg/apache/http/HttpResponse;
    .end local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_5
    move-exception v9

    .line 914
    .local v9, "e":Ljava/io/IOException;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_8

    const-string v23, "KochavaTracker"

    const-string v24, "TrackTask"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_3

    .line 753
    .end local v9    # "e":Ljava/io/IOException;
    .restart local v3    # "attributionData":Lorg/json/JSONObject;
    .restart local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v8    # "data":Ljava/lang/String;
    .restart local v10    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v19    # "parsedResult":Lorg/json/JSONObject;
    .restart local v20    # "response":Lorg/apache/http/HttpResponse;
    .restart local v21    # "result":Ljava/lang/String;
    .restart local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :cond_23
    const/16 v23, 0x0

    goto/16 :goto_7

    .line 757
    :cond_24
    :try_start_12
    move-object v0, v3

    check-cast v0, Lorg/json/JSONObject;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_12} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_12 .. :try_end_12} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_12 .. :try_end_12} :catch_2
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_7

    move-result-object v23

    goto/16 :goto_8

    .line 760
    :cond_25
    :try_start_13
    move-object v0, v3

    check-cast v0, Lorg/json/JSONObject;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v23

    goto/16 :goto_9

    .line 766
    .restart local v17    # "message":Landroid/os/Message;
    .restart local v18    # "messageData":Landroid/os/Bundle;
    :cond_26
    check-cast v3, Lorg/json/JSONObject;

    .end local v3    # "attributionData":Lorg/json/JSONObject;
    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_e
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_13} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_13 .. :try_end_13} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_13 .. :try_end_13} :catch_2

    move-result-object v23

    goto/16 :goto_a

    .line 781
    .end local v17    # "message":Landroid/os/Message;
    .end local v18    # "messageData":Landroid/os/Bundle;
    .restart local v12    # "flags":Lorg/json/JSONObject;
    :cond_27
    :try_start_14
    move-object v0, v12

    check-cast v0, Lorg/json/JSONObject;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_14
    .catch Lorg/json/JSONException; {:try_start_14 .. :try_end_14} :catch_6
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_14} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_14 .. :try_end_14} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_14 .. :try_end_14} :catch_2
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_14} :catch_7

    move-result-object v23

    goto/16 :goto_c

    .line 783
    :catch_6
    move-exception v9

    .line 785
    .local v9, "e":Lorg/json/JSONException;
    :try_start_15
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_16

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain flags."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_15
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_15} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_15 .. :try_end_15} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_15 .. :try_end_15} :catch_2
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_7

    goto/16 :goto_d

    .line 917
    .end local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v8    # "data":Ljava/lang/String;
    .end local v9    # "e":Lorg/json/JSONException;
    .end local v10    # "entity":Lorg/apache/http/HttpEntity;
    .end local v12    # "flags":Lorg/json/JSONObject;
    .end local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .end local v19    # "parsedResult":Lorg/json/JSONObject;
    .end local v20    # "response":Lorg/apache/http/HttpResponse;
    .end local v21    # "result":Ljava/lang/String;
    .end local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_7
    move-exception v9

    .line 919
    .local v9, "e":Ljava/lang/Exception;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v23, :cond_20

    const-string v23, "KochavaTracker"

    const-string v24, "Unexpected error during KVinit communication."

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_15

    .line 799
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v4    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .restart local v8    # "data":Ljava/lang/String;
    .restart local v10    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v12    # "flags":Lorg/json/JSONObject;
    .restart local v14    # "httppost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v19    # "parsedResult":Lorg/json/JSONObject;
    .restart local v20    # "response":Lorg/apache/http/HttpResponse;
    .restart local v21    # "result":Ljava/lang/String;
    .restart local v22    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_8
    move-exception v9

    .line 801
    .local v9, "e":Lorg/json/JSONException;
    :try_start_16
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_18

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain a kochava_app_id."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_e

    .line 809
    .end local v9    # "e":Lorg/json/JSONException;
    :catch_9
    move-exception v9

    .line 811
    .restart local v9    # "e":Lorg/json/JSONException;
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_19

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain flags."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_16
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_16} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_16 .. :try_end_16} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_16 .. :try_end_16} :catch_2
    .catch Ljava/lang/Exception; {:try_start_16 .. :try_end_16} :catch_7

    goto/16 :goto_f

    .line 842
    .end local v9    # "e":Lorg/json/JSONException;
    .restart local v5    # "blacklist":Lorg/json/JSONArray;
    :cond_28
    :try_start_17
    move-object v0, v5

    check-cast v0, Lorg/json/JSONArray;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v23

    goto/16 :goto_12

    .line 846
    .restart local v6    # "blacklistedOpenUDID":Z
    .restart local v15    # "i":I
    :cond_29
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "android_id"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_2c

    .line 848
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_2a

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: android_id"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 849
    :cond_2a
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "android_id"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 844
    :cond_2b
    :goto_16
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_13

    .line 851
    :cond_2c
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "fb_attribution_id"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_2e

    .line 853
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_2d

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: fb_attribution_id"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 854
    :cond_2d
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "fb_attribution_id"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_17
    .catch Lorg/json/JSONException; {:try_start_17 .. :try_end_17} :catch_a
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_17} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_17 .. :try_end_17} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_17 .. :try_end_17} :catch_2
    .catch Ljava/lang/Exception; {:try_start_17 .. :try_end_17} :catch_7

    goto :goto_16

    .line 880
    .end local v5    # "blacklist":Lorg/json/JSONArray;
    .end local v6    # "blacklistedOpenUDID":Z
    .end local v15    # "i":I
    :catch_a
    move-exception v9

    .line 882
    .restart local v9    # "e":Lorg/json/JSONException;
    :try_start_18
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_1f

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain a blacklist."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_18 .. :try_end_18} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_18 .. :try_end_18} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_18 .. :try_end_18} :catch_2
    .catch Ljava/lang/Exception; {:try_start_18 .. :try_end_18} :catch_7

    goto/16 :goto_14

    .line 856
    .end local v9    # "e":Lorg/json/JSONException;
    .restart local v5    # "blacklist":Lorg/json/JSONArray;
    .restart local v6    # "blacklistedOpenUDID":Z
    .restart local v15    # "i":I
    :cond_2e
    :try_start_19
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "imei"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_30

    .line 858
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_2f

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: imei"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 859
    :cond_2f
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "imei"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_16

    .line 861
    :cond_30
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "mac"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_32

    .line 863
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_31

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: mac"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 864
    :cond_31
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "mac"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_16

    .line 866
    :cond_32
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "odin"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_34

    .line 868
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_33

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: odin"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 869
    :cond_33
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "odin"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_16

    .line 871
    :cond_34
    invoke-virtual {v5, v15}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v23

    const-string v24, "open_udid"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_2b

    .line 873
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_35

    const-string v23, "KochavaTracker"

    const-string v24, "disabling: open_udid"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 874
    :cond_35
    # getter for: Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;
    invoke-static {}, Lcom/kochava/android/tracker/Feature;->access$47()Ljava/util/HashMap;

    move-result-object v23

    const-string v24, "open_udid"

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    invoke-virtual/range {v23 .. v25}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_19
    .catch Lorg/json/JSONException; {:try_start_19 .. :try_end_19} :catch_a
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_19} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_19 .. :try_end_19} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_19 .. :try_end_19} :catch_2
    .catch Ljava/lang/Exception; {:try_start_19 .. :try_end_19} :catch_7

    .line 875
    const/4 v6, 0x1

    goto/16 :goto_16

    .line 890
    .end local v5    # "blacklist":Lorg/json/JSONArray;
    .end local v6    # "blacklistedOpenUDID":Z
    .end local v15    # "i":I
    :catch_b
    move-exception v9

    .line 892
    .restart local v9    # "e":Lorg/json/JSONException;
    :try_start_1a
    sget-boolean v23, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v23, :cond_20

    const-string v23, "KochavaTracker"

    const-string v24, "KVinit response did not contain an error."

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1a} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1a .. :try_end_1a} :catch_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1a .. :try_end_1a} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1a .. :try_end_1a} :catch_7

    goto/16 :goto_15

    .line 833
    .end local v9    # "e":Lorg/json/JSONException;
    :catch_c
    move-exception v23

    goto/16 :goto_11

    .line 820
    :catch_d
    move-exception v23

    goto/16 :goto_10

    .line 771
    .end local v12    # "flags":Lorg/json/JSONObject;
    :catch_e
    move-exception v23

    goto/16 :goto_b
.end method
