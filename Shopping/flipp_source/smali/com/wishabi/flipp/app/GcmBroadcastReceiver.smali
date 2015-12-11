.class public Lcom/wishabi/flipp/app/GcmBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    .prologue
    .line 22
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 23
    if-nez v0, :cond_1

    .line 67
    :cond_0
    :goto_0
    return-void

    .line 26
    :cond_1
    const-string v1, "title"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 27
    if-eqz v1, :cond_0

    .line 30
    const-string v2, "message"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 31
    if-eqz v2, :cond_0

    .line 34
    const-string v3, "url"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 35
    if-nez v0, :cond_3

    const/4 v0, 0x0

    .line 37
    :goto_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 38
    if-eqz v3, :cond_0

    .line 41
    new-instance v4, Landroid/content/Intent;

    const-class v5, Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {v4, p1, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 42
    if-eqz v0, :cond_2

    .line 43
    invoke-virtual {v4, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 44
    :cond_2
    const-string v0, "EXTRA_OPENED_BY_PUSH_PLATFORM"

    const-string v5, "gcm"

    invoke-virtual {v4, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 47
    const/4 v0, 0x1

    const/high16 v5, 0x8000000

    invoke-static {p1, v0, v4, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 52
    new-instance v4, Landroid/support/v4/app/bq;

    invoke-direct {v4, p1}, Landroid/support/v4/app/bq;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v1}, Landroid/support/v4/app/bq;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/bq;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;

    move-result-object v1

    new-instance v4, Landroid/support/v4/app/bp;

    invoke-direct {v4}, Landroid/support/v4/app/bp;-><init>()V

    invoke-virtual {v4, v2}, Landroid/support/v4/app/bp;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bp;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/bq;->a(Landroid/support/v4/app/cb;)Landroid/support/v4/app/bq;

    move-result-object v1

    const v2, 0x7f0200c9

    invoke-virtual {v1, v2}, Landroid/support/v4/app/bq;->a(I)Landroid/support/v4/app/bq;

    move-result-object v1

    const v2, 0x7f09005d

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, v1, Landroid/support/v4/app/bq;->y:I

    iput-object v0, v1, Landroid/support/v4/app/bq;->d:Landroid/app/PendingIntent;

    const/4 v0, 0x2

    iput v0, v1, Landroid/support/v4/app/bq;->j:I

    invoke-virtual {v1}, Landroid/support/v4/app/bq;->a()Landroid/support/v4/app/bq;

    move-result-object v0

    invoke-static {}, Landroid/support/v4/app/bl;->a()Landroid/support/v4/app/bs;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/support/v4/app/bs;->a(Landroid/support/v4/app/bq;)Landroid/app/Notification;

    move-result-object v1

    .line 63
    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 66
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto/16 :goto_0

    .line 35
    :cond_3
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_1
.end method
