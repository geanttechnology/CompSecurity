.class Lcom/livemixtapes/MainActivity$7;
.super Landroid/os/AsyncTask;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MainActivity;->gcm(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MainActivity;

.field private final synthetic val$RegistrationId:Ljava/lang/String;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MainActivity;Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MainActivity$7;->this$0:Lcom/livemixtapes/MainActivity;

    iput-object p2, p0, Lcom/livemixtapes/MainActivity$7;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/livemixtapes/MainActivity$7;->val$RegistrationId:Ljava/lang/String;

    .line 406
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 410
    new-instance v3, Ljava/util/ArrayList;

    .line 411
    const/4 v4, 0x3

    .line 410
    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 413
    .local v3, "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    iget-object v4, p0, Lcom/livemixtapes/MainActivity$7;->val$context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    .line 414
    const-string v5, "android_id"

    .line 413
    invoke-static {v4, v5}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 416
    .local v0, "android_id":Ljava/lang/String;
    new-instance v2, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v2}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 417
    .local v2, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "device_id"

    .line 418
    invoke-direct {v4, v5, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 417
    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 419
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    .line 420
    const-string v5, "device_token"

    iget-object v6, p0, Lcom/livemixtapes/MainActivity$7;->val$RegistrationId:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 419
    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    .line 422
    const-string v5, "device_description"

    new-instance v6, Ljava/lang/StringBuilder;

    .line 423
    invoke-static {}, Lcom/livemixtapes/GCMIntentService;->getDeviceName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 424
    const-string v7, " - "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 425
    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 421
    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 429
    const-string v4, "https://api.livemixtapes.com/api/user/android_push"

    .line 428
    invoke-virtual {v2, v4, v3}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 431
    .local v1, "jObj":Lorg/json/JSONObject;
    invoke-virtual {v2, v1}, Lcom/livemixtapes/library/JSONParser;->isSuccessfulRequest(Lorg/json/JSONObject;)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    return-object v4
.end method

.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/MainActivity$7;->doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Boolean;

    .prologue
    .line 436
    iget-object v0, p0, Lcom/livemixtapes/MainActivity$7;->this$0:Lcom/livemixtapes/MainActivity;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/livemixtapes/MainActivity;->mRegisterTask:Landroid/os/AsyncTask;

    .line 437
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 438
    iget-object v0, p0, Lcom/livemixtapes/MainActivity$7;->val$context:Landroid/content/Context;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/google/android/gcm/GCMRegistrar;->setRegisteredOnServer(Landroid/content/Context;Z)V

    .line 439
    :cond_0
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/MainActivity$7;->onPostExecute(Ljava/lang/Boolean;)V

    return-void
.end method
