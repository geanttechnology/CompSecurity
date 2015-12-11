.class Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;
.super Landroid/os/AsyncTask;
.source "GCMRegistrationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMRegistrationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GCMRegisterTask"
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
.field private mUserId:J

.field final synthetic this$0:Lco/vine/android/service/GCMRegistrationService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/GCMRegistrationService;J)V
    .locals 0
    .param p2, "userId"    # J

    .prologue
    .line 201
    iput-object p1, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 202
    iput-wide p2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->mUserId:J

    .line 203
    return-void
.end method

.method private getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    return-object v0
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 197
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 207
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-static {v2}, Lco/vine/android/service/GCMRegistrationService;->access$100(Lco/vine/android/service/GCMRegistrationService;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v2

    if-nez v2, :cond_0

    .line 208
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v3

    # setter for: Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-static {v2, v3}, Lco/vine/android/service/GCMRegistrationService;->access$102(Lco/vine/android/service/GCMRegistrationService;Lcom/google/android/gms/gcm/GoogleCloudMessaging;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .line 212
    :cond_0
    :try_start_0
    const-string v2, "GCMRegService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Registering with senderId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mSenderId:Ljava/lang/String;
    invoke-static {v4}, Lco/vine/android/service/GCMRegistrationService;->access$200(Lco/vine/android/service/GCMRegistrationService;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-static {v2}, Lco/vine/android/service/GCMRegistrationService;->access$100(Lco/vine/android/service/GCMRegistrationService;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mSenderId:Ljava/lang/String;
    invoke-static {v5}, Lco/vine/android/service/GCMRegistrationService;->access$200(Lco/vine/android/service/GCMRegistrationService;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->register([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 215
    .local v1, "regId":Ljava/lang/String;
    const-string v2, "GCM: Registration complete with regId={}"

    invoke-static {v2, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 216
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # invokes: Lco/vine/android/service/GCMRegistrationService;->setRegistrationId(Ljava/lang/String;)V
    invoke-static {v2, v1}, Lco/vine/android/service/GCMRegistrationService;->access$300(Lco/vine/android/service/GCMRegistrationService;Ljava/lang/String;)V

    .line 217
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v2}, Lco/vine/android/service/GCMRegistrationService;->access$400(Lco/vine/android/service/GCMRegistrationService;)Lco/vine/android/client/AppController;

    move-result-object v2

    iget-wide v3, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->mUserId:J

    invoke-virtual {v2, v1, v3, v4}, Lco/vine/android/client/AppController;->sendGcmRegId(Ljava/lang/String;J)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    .line 223
    .end local v1    # "regId":Ljava/lang/String;
    :goto_0
    const/4 v2, 0x0

    return-object v2

    .line 218
    :catch_0
    move-exception v0

    .line 219
    .local v0, "e":Ljava/io/IOException;
    const-string v2, "GCMRegService"

    const-string v3, "Failed to register with GCM service."

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 220
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 197
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 228
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # invokes: Lco/vine/android/service/GCMRegistrationService;->stopService()V
    invoke-static {v0}, Lco/vine/android/service/GCMRegistrationService;->access$500(Lco/vine/android/service/GCMRegistrationService;)V

    .line 229
    return-void
.end method
