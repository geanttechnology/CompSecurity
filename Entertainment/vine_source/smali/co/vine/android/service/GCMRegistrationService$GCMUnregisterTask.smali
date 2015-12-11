.class Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;
.super Landroid/os/AsyncTask;
.source "GCMRegistrationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMRegistrationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GCMUnregisterTask"
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
.field private mRegId:Ljava/lang/String;

.field private mSessionKey:Ljava/lang/String;

.field private mUserId:J

.field final synthetic this$0:Lco/vine/android/service/GCMRegistrationService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/GCMRegistrationService;Ljava/lang/String;JLjava/lang/String;)V
    .locals 0
    .param p2, "regId"    # Ljava/lang/String;
    .param p3, "userId"    # J
    .param p5, "key"    # Ljava/lang/String;

    .prologue
    .line 247
    iput-object p1, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 248
    iput-object p2, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mRegId:Ljava/lang/String;

    .line 249
    iput-wide p3, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mUserId:J

    .line 250
    iput-object p5, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mSessionKey:Ljava/lang/String;

    .line 251
    return-void
.end method

.method private getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    return-object v0
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 241
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 5
    .param p1, "voids"    # [Ljava/lang/Void;

    .prologue
    .line 255
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-static {v0}, Lco/vine/android/service/GCMRegistrationService;->access$100(Lco/vine/android/service/GCMRegistrationService;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v0

    if-nez v0, :cond_0

    .line 256
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v1

    # setter for: Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-static {v0, v1}, Lco/vine/android/service/GCMRegistrationService;->access$102(Lco/vine/android/service/GCMRegistrationService;Lcom/google/android/gms/gcm/GoogleCloudMessaging;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .line 259
    :cond_0
    const-string v0, "GCMRegService"

    const-string v1, "Unregistering..."

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # getter for: Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v0}, Lco/vine/android/service/GCMRegistrationService;->access$400(Lco/vine/android/service/GCMRegistrationService;)Lco/vine/android/client/AppController;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mRegId:Ljava/lang/String;

    iget-wide v2, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mUserId:J

    iget-object v4, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->mSessionKey:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/client/AppController;->clearGcmRegId(Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;

    .line 261
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 262
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 241
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    .line 267
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->getContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lco/vine/android/service/GCMNotificationService;->getClearNotificationIntent(Landroid/content/Context;I)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/service/GCMRegistrationService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 268
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->getContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x2

    invoke-static {v1, v2}, Lco/vine/android/service/GCMNotificationService;->getClearNotificationIntent(Landroid/content/Context;I)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/service/GCMRegistrationService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 269
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->this$0:Lco/vine/android/service/GCMRegistrationService;

    # invokes: Lco/vine/android/service/GCMRegistrationService;->stopService()V
    invoke-static {v0}, Lco/vine/android/service/GCMRegistrationService;->access$500(Lco/vine/android/service/GCMRegistrationService;)V

    .line 270
    return-void
.end method
