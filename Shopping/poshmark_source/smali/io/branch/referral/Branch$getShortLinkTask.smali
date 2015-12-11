.class Lio/branch/referral/Branch$getShortLinkTask;
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
    name = "getShortLinkTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Lio/branch/referral/ServerRequest;",
        "Ljava/lang/Void;",
        "Lio/branch/referral/ServerResponse;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field final synthetic this$0:Lio/branch/referral/Branch;


# direct methods
.method private constructor <init>(Lio/branch/referral/Branch;)V
    .locals 0

    .prologue
    .line 3230
    iput-object p1, p0, Lio/branch/referral/Branch$getShortLinkTask;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lio/branch/referral/Branch;Lio/branch/referral/Branch$1;)V
    .locals 0
    .param p1, "x0"    # Lio/branch/referral/Branch;
    .param p2, "x1"    # Lio/branch/referral/Branch$1;

    .prologue
    .line 3230
    invoke-direct {p0, p1}, Lio/branch/referral/Branch$getShortLinkTask;-><init>(Lio/branch/referral/Branch;)V

    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lio/branch/referral/Branch$getShortLinkTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected varargs doInBackground([Lio/branch/referral/ServerRequest;)Lio/branch/referral/ServerResponse;
    .locals 2
    .param p1, "serverRequests"    # [Lio/branch/referral/ServerRequest;

    .prologue
    .line 3233
    iget-object v0, p0, Lio/branch/referral/Branch$getShortLinkTask;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$1500(Lio/branch/referral/Branch;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v1}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/branch/referral/BranchRemoteInterface;->createCustomUrlSync(Lorg/json/JSONObject;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/Branch$getShortLinkTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "Branch$getShortLinkTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 3230
    :goto_0
    check-cast p1, [Lio/branch/referral/ServerRequest;

    invoke-virtual {p0, p1}, Lio/branch/referral/Branch$getShortLinkTask;->doInBackground([Lio/branch/referral/ServerRequest;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "Branch$getShortLinkTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
