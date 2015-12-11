.class Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

.field final synthetic val$pendingNotificationIntent:Landroid/app/PendingIntent;

.field final synthetic val$pendingNotificationIntentPlay:Landroid/app/PendingIntent;

.field final synthetic val$pendingNotificationIntentSubscribe:Landroid/app/PendingIntent;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntent:Landroid/app/PendingIntent;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntentSubscribe:Landroid/app/PendingIntent;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntentPlay:Landroid/app/PendingIntent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const v6, 0x7f080134

    const v5, 0x7f080133

    const v3, 0x7f080132

    const/16 v4, 0x10

    .line 119
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 122
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080135

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "false"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 123
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 127
    :cond_0
    new-instance v1, Landroid/support/v4/app/NotificationCompat$Builder;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-direct {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    const v2, 0x7f02010e

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0200df

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntent:Landroid/app/PendingIntent;

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080131

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    .line 137
    iput v4, v0, Landroid/app/Notification;->flags:I

    .line 139
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->sound:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 140
    const/4 v1, -0x1

    iput v1, v0, Landroid/app/Notification;->defaults:I

    .line 144
    :cond_1
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v4, :cond_2

    .line 145
    new-instance v1, Landroid/widget/RemoteViews;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f03003e

    invoke-direct {v1, v2, v3}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 146
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->url:Ljava/lang/String;

    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getBitmapFromURL(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 147
    const v3, 0x7f07004a

    invoke-virtual {v1, v3, v2}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 148
    const v2, 0x7f0700b3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->artist:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->playlistName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 149
    const v2, 0x7f0700b4

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntentSubscribe:Landroid/app/PendingIntent;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 150
    const v2, 0x7f0700b5

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->val$pendingNotificationIntentPlay:Landroid/app/PendingIntent;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 151
    iput-object v1, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 154
    :cond_2
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    # getter for: Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->mManager:Landroid/app/NotificationManager;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->access$000(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;)Landroid/app/NotificationManager;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    invoke-virtual {v1, v2, v0}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 156
    return-void
.end method
