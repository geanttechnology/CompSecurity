.class public Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;
.super Landroid/os/AsyncTask;
.source "GCMUtils.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/GCMUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "RegisterAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field cntx:Landroid/content/Context;

.field pushToken:Ljava/lang/String;

.field retryCount:I

.field final synthetic this$0:Lcom/poshmark/utils/GCMUtils;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/GCMUtils;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->this$0:Lcom/poshmark/utils/GCMUtils;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 97
    const/4 v0, 0x3

    iput v0, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->retryCount:I

    .line 101
    iput-object p2, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->cntx:Landroid/content/Context;

    .line 102
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "GCMUtils$RegisterAsyncTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 95
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "GCMUtils$RegisterAsyncTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 105
    :goto_0
    iget v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->retryCount:I

    if-lez v3, :cond_0

    .line 107
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->cntx:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v2

    .line 108
    .local v2, "gcm":Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    sget-object v5, Lcom/poshmark/config/EnvConfig;->GCM_PROJECT_ID:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->register([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->pushToken:Ljava/lang/String;

    .line 109
    const-string v3, "PM New token"

    iget-object v4, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->pushToken:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->pushToken:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/poshmark/application/PMApplicationSession;->setGCMRegId(Ljava/lang/String;)V

    .line 112
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/poshmark/application/PMApplicationSession;->setGCMAppVersion(Ljava/lang/String;)V

    .line 113
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3, v4}, Lcom/poshmark/application/PMApplicationSession;->setGCMLastRegisteredTime(Ljava/util/Date;)V

    .line 114
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/poshmark/application/PMApplicationSession;->setGCMRegIdSentFlag(Z)V

    .line 116
    iget-object v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->this$0:Lcom/poshmark/utils/GCMUtils;

    invoke-virtual {v3}, Lcom/poshmark/utils/GCMUtils;->sendGcmPushTokenToServer()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 127
    .end local v2    # "gcm":Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    :cond_0
    const/4 v3, 0x0

    return-object v3

    .line 118
    :catch_0
    move-exception v0

    .line 120
    .local v0, "e":Ljava/io/IOException;
    const-wide/16 v4, 0x3e8

    :try_start_1
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 124
    :goto_1
    iget v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->retryCount:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->retryCount:I

    goto :goto_0

    .line 121
    :catch_1
    move-exception v1

    .line 122
    .local v1, "e1":Ljava/lang/InterruptedException;
    invoke-virtual {v1}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1
.end method
