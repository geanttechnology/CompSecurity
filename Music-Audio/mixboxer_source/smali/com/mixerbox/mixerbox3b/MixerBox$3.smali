.class Lcom/mixerbox/mixerbox3b/MixerBox$3;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MixerBox;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MixerBox;)V
    .locals 0

    .prologue
    .line 416
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 416
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MixerBox$3;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 419
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MixerBox;->gcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    if-nez v0, :cond_0

    .line 422
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v1

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MixerBox;->gcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .line 424
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MixerBox;->gcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/MixerBox;->SENDER_ID:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->register([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    .line 425
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Device registered, registration ID="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$3;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 429
    :goto_0
    return-object v0

    .line 426
    :catch_0
    move-exception v0

    .line 427
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error :"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 416
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MixerBox$3;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 434
    return-void
.end method
