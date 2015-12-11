.class public Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;
.super Landroid/app/Service;
.source "SourceFile"


# instance fields
.field artist:Ljava/lang/String;

.field artistId:Ljava/lang/String;

.field context:Ljava/lang/String;

.field itemCount:Ljava/lang/String;

.field private mManager:Landroid/app/NotificationManager;

.field playlistId:Ljava/lang/String;

.field playlistName:Ljava/lang/String;

.field serviceId:I

.field smallContext:Ljava/lang/String;

.field smallTitle:Ljava/lang/String;

.field sound:Ljava/lang/Boolean;

.field tab:I

.field type:I

.field url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->mManager:Landroid/app/NotificationManager;

    return-object v0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    return-object v0
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 11
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/high16 v5, 0x24000000

    const/high16 v4, 0x8000000

    .line 50
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 51
    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->type:I

    .line 52
    const-string v1, "sound"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->sound:Ljava/lang/Boolean;

    .line 53
    const-string v1, "tab"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->tab:I

    .line 54
    const-string v1, "serviceId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    .line 55
    iget v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->type:I

    if-nez v1, :cond_1

    .line 56
    const-string v1, "artist"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    .line 57
    const-string v1, "playlistId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistId:Ljava/lang/String;

    .line 58
    const-string v1, "artistId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artistId:Ljava/lang/String;

    .line 59
    const-string v1, "playlistName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    .line 60
    const-string v1, "url"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    .line 61
    const-string v1, "itemCount"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->itemCount:Ljava/lang/String;

    .line 63
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "notification"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->mManager:Landroid/app/NotificationManager;

    .line 64
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 65
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 66
    const-string v2, "tab"

    iget v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->tab:I

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 67
    const-string v2, "play"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 68
    const-string v2, "subscribe"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 69
    const-string v2, "playlistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    const-string v2, "itemCount"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->itemCount:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string v2, "artistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v2, "artist"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    const-string v2, "url"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const-string v2, "playlistName"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 76
    invoke-virtual {v0, v5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 77
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    add-int/lit16 v2, v2, 0x1c8

    invoke-static {v1, v2, v0, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 80
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 81
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 82
    const-string v2, "tab"

    iget v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->tab:I

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 83
    const-string v2, "play"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 84
    const-string v2, "subscribe"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 85
    const-string v2, "playlistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string v2, "playlistName"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-string v2, "itemCount"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->itemCount:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    const-string v2, "artistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string v2, "artist"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v2, "url"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 92
    invoke-virtual {v0, v5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 93
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    add-int/lit8 v2, v2, 0x7b

    invoke-static {v1, v2, v0, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v9

    .line 96
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 97
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 98
    const-string v2, "tab"

    iget v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->tab:I

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 99
    const-string v2, "play"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 100
    const-string v2, "subscribe"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 101
    const-string v2, "playlistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-string v2, "playlistName"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    const-string v2, "itemCount"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->itemCount:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    const-string v2, "artistId"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artistId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    const-string v2, "artist"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    const-string v2, "url"

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 108
    invoke-virtual {v0, v5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 109
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    add-int/lit16 v2, v2, 0xea

    invoke-static {v1, v2, v0, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v10

    .line 112
    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;-><init>(Landroid/content/Context;)V

    .line 114
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistId:Ljava/lang/String;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artistId:Ljava/lang/String;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->itemCount:Ljava/lang/String;

    const-string v6, "0"

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    invoke-virtual/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->putHasPushed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->close()V

    .line 117
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;

    invoke-direct {v1, p0, v8, v10, v9}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;-><init>(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 201
    :cond_0
    :goto_0
    const/4 v0, 0x2

    return v0

    .line 158
    :cond_1
    iget v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->type:I

    if-ne v1, v7, :cond_0

    .line 159
    const-string v1, "smallTitle"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->smallTitle:Ljava/lang/String;

    .line 160
    const-string v1, "smallContext"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->smallContext:Ljava/lang/String;

    .line 161
    const-string v1, "context"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->context:Ljava/lang/String;

    .line 163
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "notification"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->mManager:Landroid/app/NotificationManager;

    .line 165
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 166
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 167
    const-string v2, "tab"

    iget v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->tab:I

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 168
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 169
    invoke-virtual {v0, v5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 170
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    add-int/lit16 v2, v2, 0x1c8

    invoke-static {v1, v2, v0, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 173
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;-><init>(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;Landroid/app/PendingIntent;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method
