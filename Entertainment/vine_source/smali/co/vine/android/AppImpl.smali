.class public Lco/vine/android/AppImpl;
.super Ljava/lang/Object;
.source "AppImpl.java"

# interfaces
.implements Lco/vine/android/AppInterface;


# static fields
.field private static sInstance:Lco/vine/android/AppImpl;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method public static getInstance()Lco/vine/android/AppImpl;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lco/vine/android/AppImpl;->sInstance:Lco/vine/android/AppImpl;

    if-nez v0, :cond_0

    .line 34
    new-instance v0, Lco/vine/android/AppImpl;

    invoke-direct {v0}, Lco/vine/android/AppImpl;-><init>()V

    sput-object v0, Lco/vine/android/AppImpl;->sInstance:Lco/vine/android/AppImpl;

    .line 36
    :cond_0
    sget-object v0, Lco/vine/android/AppImpl;->sInstance:Lco/vine/android/AppImpl;

    return-object v0
.end method


# virtual methods
.method public appendDebugInfo(Landroid/content/Context;Ljava/lang/StringBuilder;Z)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "debugInfo"    # Ljava/lang/StringBuilder;
    .param p3, "hideSensitiveData"    # Z

    .prologue
    .line 75
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    .line 77
    .local v0, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    const-string v1, "\n\nDefault Recording Configuration: "

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nRecording enabled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->recordingEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nZoom enabled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->zoomEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 80
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nCamera Switch enabled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->cameraSwitchEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nFlash Switch enabled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->flashSwitchEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 82
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nBuffer Pre-allocation enabled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocateBuffer:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nBuffer count: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nPreview width: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 85
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nTarget Frame Rate: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    if-nez p3, :cond_0

    .line 87
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nProcess path: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processDir:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nTarget Size: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetSize:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 91
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    .line 93
    const-string v1, "\n\nDefault Message Recording Configuration: "

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 94
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nBuffer count: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 95
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nPreview width: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 96
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nPreview height: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 97
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nTarget Frame Rate: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 98
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nTarget Size: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetSize:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 99
    return-void
.end method

.method public clearUploadCaptchas(Landroid/content/Context;)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 134
    invoke-static {p1}, Lco/vine/android/util/UploadManager;->clearUploadCaptchas(Landroid/content/Context;)V

    .line 135
    return-void
.end method

.method public doAddWidget(Landroid/content/Context;Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z
    .locals 1
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "am"    # Landroid/accounts/AccountManager;
    .param p3, "acc"    # Landroid/accounts/Account;

    .prologue
    .line 103
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->loadWasEverSuccessful(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p2, p3}, Lco/vine/android/client/VineAccountHelper;->needsAddwidget(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-static {p1}, Lco/vine/android/service/VineUploadService;->getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public getDiscardAllIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 58
    invoke-static {p1}, Lco/vine/android/service/VineUploadService;->getDiscardAllIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 63
    invoke-static {p1}, Lco/vine/android/service/VineUploadService;->getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public getRecordingIntent(Landroid/app/Activity;ILjava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "flags"    # I
    .param p3, "callingActivity"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-static {p1, p2, p3}, Lco/vine/android/AbstractRecordingActivity;->getIntentForGeneric(Landroid/content/Context;ILjava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public setupWidget(Landroid/app/Activity;)V
    .locals 0
    .param p1, "a"    # Landroid/app/Activity;

    .prologue
    .line 119
    invoke-static {p1}, Lco/vine/android/CameraWidgetConfigureActivity;->setupShortcut(Landroid/content/Context;)V

    .line 120
    return-void
.end method

.method public startCameraService(Landroid/app/Activity;)V
    .locals 2
    .param p1, "parent"    # Landroid/app/Activity;

    .prologue
    .line 114
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/ResourceService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p1, v0}, Landroid/app/Activity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 115
    return-void
.end method

.method public startCapture(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 68
    const/high16 v0, 0x20000

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Base options: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lco/vine/android/AbstractRecordingActivity;->getIntentForGeneric(Landroid/content/Context;ILjava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Lco/vine/android/util/Util;->startActionOnRecordingAvailable(Landroid/app/Activity;Landroid/content/Intent;I)V

    .line 71
    return-void
.end method

.method public startConversationActivity(Landroid/app/Activity;JLjava/lang/String;JZ)V
    .locals 9
    .param p1, "parent"    # Landroid/app/Activity;
    .param p2, "conversationId"    # J
    .param p4, "username"    # Ljava/lang/String;
    .param p5, "userId"    # J
    .param p7, "amFollowing"    # Z

    .prologue
    .line 129
    const/4 v7, 0x0

    move-object v0, p1

    move-wide v1, p2

    move-object v3, p4

    move-wide v4, p5

    move/from16 v6, p7

    invoke-static/range {v0 .. v7}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v8

    .line 130
    .local v8, "i":Landroid/content/Intent;
    invoke-virtual {p1, v8}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 131
    return-void
.end method

.method public startUploadsListActivity(Landroid/app/Activity;)V
    .locals 0
    .param p1, "a"    # Landroid/app/Activity;

    .prologue
    .line 109
    invoke-static {p1}, Lco/vine/android/UploadsListActivity;->start(Landroid/content/Context;)V

    .line 110
    return-void
.end method

.method public updateClientProfile(Landroid/content/Context;Lco/vine/android/client/AppController;Z)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "record"    # Z

    .prologue
    .line 41
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->needsUpdate(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    if-nez p3, :cond_0

    .line 42
    invoke-virtual {p2}, Lco/vine/android/client/AppController;->updateClientProfile()Ljava/lang/String;

    .line 44
    :cond_0
    return-void
.end method

.method public updateRecordConfigs(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "object"    # Lorg/json/JSONObject;

    .prologue
    .line 124
    invoke-static {p1, p2}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->update(Landroid/content/Context;Lorg/json/JSONObject;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .line 125
    return-void
.end method
