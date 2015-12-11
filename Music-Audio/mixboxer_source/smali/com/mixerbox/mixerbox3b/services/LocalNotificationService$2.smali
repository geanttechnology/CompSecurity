.class Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

.field final synthetic val$pendingNotificationIntent:Landroid/app/PendingIntent;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;Landroid/app/PendingIntent;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->val$pendingNotificationIntent:Landroid/app/PendingIntent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/16 v3, 0x10

    .line 175
    new-instance v0, Landroid/support/v4/app/NotificationCompat$Builder;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-direct {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    const v1, 0x7f02010e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->val$pendingNotificationIntent:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->smallTitle:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200df

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->smallContext:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->context:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    .line 184
    iput v3, v0, Landroid/app/Notification;->flags:I

    .line 187
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->sound:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 188
    const/4 v1, -0x1

    iput v1, v0, Landroid/app/Notification;->defaults:I

    .line 190
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v3, :cond_1

    .line 191
    new-instance v1, Landroid/widget/RemoteViews;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f03003f

    invoke-direct {v1, v2, v3}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 192
    const v2, 0x7f070075

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->context:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 193
    iput-object v1, v0, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 196
    :cond_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    # getter for: Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->mManager:Landroid/app/NotificationManager;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->access$000(Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;)Landroid/app/NotificationManager;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService$2;->this$0:Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/services/LocalNotificationService;->serviceId:I

    invoke-virtual {v1, v2, v0}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 197
    return-void
.end method
