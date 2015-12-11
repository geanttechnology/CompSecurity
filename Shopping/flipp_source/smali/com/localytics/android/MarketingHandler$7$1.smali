.class Lcom/localytics/android/MarketingHandler$7$1;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/localytics/android/MarketingHandler$7;

.field final synthetic val$pushRegID:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler$7;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1806
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iput-object p2, p0, Lcom/localytics/android/MarketingHandler$7$1;->val$pushRegID:Ljava/lang/String;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1806
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$7$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v1, 0x0

    const/4 v5, 0x0

    .line 1823
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->val$pushRegID:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1825
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$7;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getInstallationId()Ljava/lang/String;

    move-result-object v2

    .line 1826
    const-string v0, "http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s"

    const/4 v3, 0x5

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v4, v4, Lcom/localytics/android/MarketingHandler$7;->val$campaign:Ljava/lang/String;

    aput-object v4, v3, v5

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v5, v5, Lcom/localytics/android/MarketingHandler$7;->val$creative:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler$7$1;->val$pushRegID:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x3

    aput-object v2, v3, v4

    const/4 v4, 0x4

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v5, v5, Lcom/localytics/android/MarketingHandler$7;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v5, v5, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getCurrentTimeMillis()J

    move-result-wide v6

    long-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1830
    :try_start_0
    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$7;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getProxy()Ljava/net/Proxy;

    move-result-object v3

    .line 1831
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-static {v4, v3}, Lcom/localytics/android/BaseUploadThread;->createURLConnection(Ljava/net/URL;Ljava/net/Proxy;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1832
    const/16 v3, 0x1388

    :try_start_1
    invoke-virtual {v0, v3}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 1833
    const/16 v3, 0x1388

    invoke-virtual {v0, v3}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 1834
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 1835
    const-string v3, "x-install-id"

    invoke-virtual {v0, v3, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 1836
    const-string v2, "x-app-id"

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$7;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 1837
    const-string v2, "x-client-version"

    const-string v3, "androida_3.4.0"

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 1838
    const-string v2, "x-app-version"

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$7;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 1839
    const-string v2, "x-customer-id"

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$7;->val$customerID:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 1840
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1855
    if-eqz v0, :cond_0

    .line 1857
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_0
    move-object v0, v1

    .line 1862
    :cond_1
    :goto_0
    return-object v0

    .line 1842
    :catch_0
    move-exception v0

    .line 1844
    :goto_1
    :try_start_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unfortunately, something went wrong. Push test activation was unsuccessful."

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1845
    invoke-static {}, Lcom/localytics/android/Localytics;->isLoggingEnabled()Z

    move-result v3

    if-eqz v3, :cond_2

    instance-of v3, v0, Ljava/io/FileNotFoundException;

    if-eqz v3, :cond_2

    .line 1847
    const-string v3, "\n\nCause:\nPush registration token has not yet been processed. Please wait a few minutes and try again."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1848
    const-string v3, "Activating push test has failed"

    invoke-static {v3, v0}, Lcom/localytics/android/Localytics$Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1851
    :cond_2
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    .line 1855
    if-eqz v1, :cond_1

    .line 1857
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 1855
    :catchall_0
    move-exception v0

    :goto_2
    if-eqz v1, :cond_3

    .line 1857
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 1858
    :cond_3
    throw v0

    .line 1855
    :catchall_1
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto :goto_2

    .line 1842
    :catch_1
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1806
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$7$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1868
    if-eqz p1, :cond_0

    .line 1870
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$7;->val$appContext:Landroid/content/Context;

    const/4 v1, 0x1

    invoke-static {v0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1872
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1810
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->val$pushRegID:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1812
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$7;->val$appContext:Landroid/content/Context;

    const-string v1, "Push Test Activated\nYou should receive a notification soon."

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1818
    :goto_0
    return-void

    .line 1816
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$7$1;->this$1:Lcom/localytics/android/MarketingHandler$7;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$7;->val$appContext:Landroid/content/Context;

    const-string v1, "App isn\'t registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called."

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
