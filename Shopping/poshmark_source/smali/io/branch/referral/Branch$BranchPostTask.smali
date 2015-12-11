.class Lio/branch/referral/Branch$BranchPostTask;
.super Landroid/os/AsyncTask;
.source "Branch.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BranchPostTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lio/branch/referral/ServerResponse;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field final synthetic this$0:Lio/branch/referral/Branch;

.field thisReq_:Lio/branch/referral/ServerRequest;

.field timeOut_:I


# direct methods
.method public constructor <init>(Lio/branch/referral/Branch;Lio/branch/referral/ServerRequest;)V
    .locals 1
    .param p2, "request"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 3247
    iput-object p1, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 3244
    const/4 v0, 0x0

    iput v0, p0, Lio/branch/referral/Branch$BranchPostTask;->timeOut_:I

    .line 3248
    iput-object p2, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    .line 3249
    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {p1}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v0

    iput v0, p0, Lio/branch/referral/Branch$BranchPostTask;->timeOut_:I

    .line 3250
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lio/branch/referral/Branch$BranchPostTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Lio/branch/referral/ServerResponse;
    .locals 5
    .param p1, "voids"    # [Ljava/lang/Void;

    .prologue
    .line 3256
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v0, v0, Lio/branch/referral/ServerRequestInitSession;

    if-nez v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v0, v0, Lio/branch/referral/ServerRequestRegisterView;

    if-eqz v0, :cond_1

    .line 3258
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    iget-object v1, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;
    invoke-static {v1}, Lio/branch/referral/Branch;->access$300(Lio/branch/referral/Branch;)Lio/branch/referral/SystemObserver;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->updateGAdsParams(Lio/branch/referral/SystemObserver;)V

    .line 3260
    :cond_1
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v0}, Lio/branch/referral/ServerRequest;->isGetRequest()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 3261
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1500(Lio/branch/referral/Branch;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequest;->getRequestUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v2}, Lio/branch/referral/ServerRequest;->getRequestPath()Ljava/lang/String;

    move-result-object v2

    iget v3, p0, Lio/branch/referral/Branch$BranchPostTask;->timeOut_:I

    invoke-virtual {v0, v1, v2, v3}, Lio/branch/referral/BranchRemoteInterface;->make_restful_get(Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;

    move-result-object v0

    .line 3263
    :goto_0
    return-object v0

    :cond_2
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1500(Lio/branch/referral/Branch;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v1

    iget-object v2, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v2}, Lio/branch/referral/ServerRequest;->getRequestUrl()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v3}, Lio/branch/referral/ServerRequest;->getRequestPath()Ljava/lang/String;

    move-result-object v3

    iget v4, p0, Lio/branch/referral/Branch$BranchPostTask;->timeOut_:I

    invoke-virtual {v0, v1, v2, v3, v4}, Lio/branch/referral/BranchRemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;

    move-result-object v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "Branch$BranchPostTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 3243
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lio/branch/referral/Branch$BranchPostTask;->doInBackground([Ljava/lang/Void;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "Branch$BranchPostTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPostExecute(Lio/branch/referral/ServerResponse;)V
    .locals 12
    .param p1, "serverResponse"    # Lio/branch/referral/ServerResponse;

    .prologue
    .line 3269
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 3270
    if-eqz p1, :cond_2

    .line 3272
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getStatusCode()I

    move-result v6

    .line 3273
    .local v6, "status":I
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x1

    # setter for: Lio/branch/referral/Branch;->hasNetwork_:Z
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$1602(Lio/branch/referral/Branch;Z)Z

    .line 3276
    const/16 v9, 0xc8

    if-eq v6, v9, :cond_a

    .line 3278
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestInitSession;

    if-eqz v9, :cond_0

    .line 3279
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    sget-object v10, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    # setter for: Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$1702(Lio/branch/referral/Branch;Lio/branch/referral/Branch$SESSION_STATE;)Lio/branch/referral/Branch$SESSION_STATE;

    .line 3282
    :cond_0
    const/16 v9, 0x199

    if-ne v6, v9, :cond_4

    .line 3283
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    iget-object v10, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    invoke-virtual {v9, v10}, Lio/branch/referral/ServerRequestQueue;->remove(Lio/branch/referral/ServerRequest;)Z

    .line 3284
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestCreateUrl;

    if-eqz v9, :cond_3

    .line 3285
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    check-cast v9, Lio/branch/referral/ServerRequestCreateUrl;

    invoke-virtual {v9}, Lio/branch/referral/ServerRequestCreateUrl;->handleDuplicateURLError()V

    .line 3383
    :cond_1
    :goto_0
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x0

    # setter for: Lio/branch/referral/Branch;->networkCount_:I
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$2002(Lio/branch/referral/Branch;I)I

    .line 3384
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->hasNetwork_:Z
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1600(Lio/branch/referral/Branch;)Z

    move-result v9

    if-eqz v9, :cond_2

    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1700(Lio/branch/referral/Branch;)Lio/branch/referral/Branch$SESSION_STATE;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    if-eq v9, v10, :cond_2

    .line 3385
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->processNextQueueItem()V
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2600(Lio/branch/referral/Branch;)V

    .line 3391
    .end local v6    # "status":I
    :cond_2
    :goto_1
    return-void

    .line 3287
    .restart local v6    # "status":I
    :cond_3
    const-string v9, "BranchSDK"

    const-string v10, "Branch API Error: Conflicting resource error code from API"

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 3288
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x0

    # invokes: Lio/branch/referral/Branch;->handleFailure(II)V
    invoke-static {v9, v10, v6}, Lio/branch/referral/Branch;->access$1900(Lio/branch/referral/Branch;II)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 3387
    .end local v6    # "status":I
    :catch_0
    move-exception v0

    .line 3388
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 3294
    .end local v0    # "ex":Lorg/json/JSONException;
    .restart local v6    # "status":I
    :cond_4
    :try_start_1
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x0

    # setter for: Lio/branch/referral/Branch;->hasNetwork_:Z
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$1602(Lio/branch/referral/Branch;Z)Z

    .line 3296
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 3297
    .local v5, "requestToFail":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lio/branch/referral/ServerRequest;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_2
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    invoke-virtual {v9}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v9

    if-ge v1, v9, :cond_5

    .line 3298
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    invoke-virtual {v9, v1}, Lio/branch/referral/ServerRequestQueue;->peekAt(I)Lio/branch/referral/ServerRequest;

    move-result-object v9

    invoke-virtual {v5, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3297
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 3301
    :cond_5
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_6
    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/branch/referral/ServerRequest;

    .line 3302
    .local v4, "req":Lio/branch/referral/ServerRequest;
    if-eqz v4, :cond_7

    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->shouldRetryOnFail()Z

    move-result v9

    if-nez v9, :cond_6

    .line 3303
    :cond_7
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    invoke-virtual {v9, v4}, Lio/branch/referral/ServerRequestQueue;->remove(Lio/branch/referral/ServerRequest;)Z

    goto :goto_3

    .line 3307
    .end local v4    # "req":Lio/branch/referral/ServerRequest;
    :cond_8
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x0

    # setter for: Lio/branch/referral/Branch;->networkCount_:I
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$2002(Lio/branch/referral/Branch;I)I

    .line 3310
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_9
    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/branch/referral/ServerRequest;

    .line 3311
    .restart local v4    # "req":Lio/branch/referral/ServerRequest;
    if-eqz v4, :cond_9

    .line 3312
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getFailReason()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v6, v9}, Lio/branch/referral/ServerRequest;->handleFailure(ILjava/lang/String;)V

    .line 3314
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->shouldRetryOnFail()Z

    move-result v9

    if-eqz v9, :cond_9

    .line 3315
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->clearCallbacks()V

    goto :goto_4

    .line 3322
    .end local v1    # "i":I
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "req":Lio/branch/referral/ServerRequest;
    .end local v5    # "requestToFail":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lio/branch/referral/ServerRequest;>;"
    :cond_a
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    const/4 v10, 0x1

    # setter for: Lio/branch/referral/Branch;->hasNetwork_:Z
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$1602(Lio/branch/referral/Branch;Z)Z

    .line 3324
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestCreateUrl;

    if-eqz v9, :cond_11

    .line 3325
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    if-eqz v9, :cond_b

    .line 3326
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "url"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 3328
    .local v8, "url":Ljava/lang/String;
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2100(Lio/branch/referral/Branch;)Ljava/util/Map;

    move-result-object v9

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getLinkData()Lio/branch/referral/BranchLinkData;

    move-result-object v10

    invoke-interface {v9, v10, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3336
    .end local v8    # "url":Ljava/lang/String;
    :cond_b
    :goto_5
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    invoke-virtual {v9}, Lio/branch/referral/ServerRequestQueue;->dequeue()Lio/branch/referral/ServerRequest;

    .line 3339
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestInitSession;

    if-nez v9, :cond_c

    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestIdentifyUserRequest;

    if-eqz v9, :cond_13

    .line 3342
    :cond_c
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    if-eqz v9, :cond_1

    .line 3343
    const/4 v7, 0x0

    .line 3344
    .local v7, "updateRequestsInQueue":Z
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_d

    .line 3345
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v9

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v10

    sget-object v11, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v11}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lio/branch/referral/PrefHelper;->setSessionID(Ljava/lang/String;)V

    .line 3346
    const/4 v7, 0x1

    .line 3348
    :cond_d
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_e

    .line 3349
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 3350
    .local v3, "new_Identity_Id":Ljava/lang/String;
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v9

    invoke-virtual {v9}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_e

    .line 3352
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2100(Lio/branch/referral/Branch;)Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Map;->clear()V

    .line 3353
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v9

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v10

    sget-object v11, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v11}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lio/branch/referral/PrefHelper;->setIdentityID(Ljava/lang/String;)V

    .line 3354
    const/4 v7, 0x1

    .line 3357
    .end local v3    # "new_Identity_Id":Ljava/lang/String;
    :cond_e
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_f

    .line 3358
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v9

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v10

    sget-object v11, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v11}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lio/branch/referral/PrefHelper;->setDeviceFingerPrintID(Ljava/lang/String;)V

    .line 3359
    const/4 v7, 0x1

    .line 3362
    :cond_f
    if-eqz v7, :cond_10

    .line 3363
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->updateAllRequestsInQueue()V
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2200(Lio/branch/referral/Branch;)V

    .line 3366
    :cond_10
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestInitSession;

    if-eqz v9, :cond_12

    .line 3367
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    sget-object v10, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    # setter for: Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;
    invoke-static {v9, v10}, Lio/branch/referral/Branch;->access$1702(Lio/branch/referral/Branch;Lio/branch/referral/Branch$SESSION_STATE;)Lio/branch/referral/Branch$SESSION_STATE;

    .line 3369
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    # getter for: Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;
    invoke-static {}, Lio/branch/referral/Branch;->access$2300()Lio/branch/referral/Branch;

    move-result-object v10

    invoke-virtual {v9, p1, v10}, Lio/branch/referral/ServerRequest;->onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V

    .line 3371
    iget-object v10, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    check-cast v9, Lio/branch/referral/ServerRequestInitSession;

    invoke-virtual {v9}, Lio/branch/referral/ServerRequestInitSession;->hasCallBack()Z

    move-result v9

    # setter for: Lio/branch/referral/Branch;->isInitReportedThroughCallBack:Z
    invoke-static {v10, v9}, Lio/branch/referral/Branch;->access$2402(Lio/branch/referral/Branch;Z)Z

    .line 3372
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->checkForAutoDeepLinkConfiguration()V
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2500(Lio/branch/referral/Branch;)V

    goto/16 :goto_0

    .line 3332
    .end local v7    # "updateRequestsInQueue":Z
    :cond_11
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    instance-of v9, v9, Lio/branch/referral/ServerRequestLogout;

    if-eqz v9, :cond_b

    .line 3333
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$2100(Lio/branch/referral/Branch;)Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Map;->clear()V

    .line 3334
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;
    invoke-static {v9}, Lio/branch/referral/Branch;->access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v9

    invoke-virtual {v9}, Lio/branch/referral/ServerRequestQueue;->clear()V

    goto/16 :goto_5

    .line 3375
    .restart local v7    # "updateRequestsInQueue":Z
    :cond_12
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    # getter for: Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;
    invoke-static {}, Lio/branch/referral/Branch;->access$2300()Lio/branch/referral/Branch;

    move-result-object v10

    invoke-virtual {v9, p1, v10}, Lio/branch/referral/ServerRequest;->onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V

    goto/16 :goto_0

    .line 3380
    .end local v7    # "updateRequestsInQueue":Z
    :cond_13
    iget-object v9, p0, Lio/branch/referral/Branch$BranchPostTask;->thisReq_:Lio/branch/referral/ServerRequest;

    # getter for: Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;
    invoke-static {}, Lio/branch/referral/Branch;->access$2300()Lio/branch/referral/Branch;

    move-result-object v10

    invoke-virtual {v9, p1, v10}, Lio/branch/referral/ServerRequest;->onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/Branch$BranchPostTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "Branch$BranchPostTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 3243
    :goto_0
    check-cast p1, Lio/branch/referral/ServerResponse;

    invoke-virtual {p0, p1}, Lio/branch/referral/Branch$BranchPostTask;->onPostExecute(Lio/branch/referral/ServerResponse;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "Branch$BranchPostTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
