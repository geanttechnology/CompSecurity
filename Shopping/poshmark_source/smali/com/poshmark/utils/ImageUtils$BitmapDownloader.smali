.class public Lcom/poshmark/utils/ImageUtils$BitmapDownloader;
.super Landroid/os/AsyncTask;
.source "ImageUtils.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ImageUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BitmapDownloader"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Landroid/net/Uri;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field public callingFragment:Lcom/poshmark/ui/fragments/CameraPreviewFragment;


# direct methods
.method public constructor <init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0
    .param p1, "callingFragment"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 309
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 310
    iput-object p1, p0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->callingFragment:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .line 311
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    iget-object v0, p0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "ImageUtils$BitmapDownloader#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 306
    :goto_0
    check-cast p1, [Landroid/net/Uri;

    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->doInBackground([Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "ImageUtils$BitmapDownloader#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Landroid/net/Uri;)Ljava/lang/String;
    .locals 2
    .param p1, "uris"    # [Landroid/net/Uri;

    .prologue
    .line 318
    invoke-static {}, Lcom/poshmark/utils/ImageUtils;->generateFileName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-static {v0, v1}, Lcom/poshmark/utils/ImageUtils;->downloadBitmap(Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "ImageUtils$BitmapDownloader#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 306
    :goto_0
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->onPostExecute(Ljava/lang/String;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "ImageUtils$BitmapDownloader#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 322
    iget-object v0, p0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->callingFragment:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cropImage(Ljava/lang/String;)V

    .line 323
    return-void
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 315
    return-void
.end method
