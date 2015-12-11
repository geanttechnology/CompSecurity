.class public Lxx;
.super Lyn;

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Landroid/app/Activity;

.field private final b:Lya;

.field private c:Landroid/content/Context;

.field private d:Lyg;

.field private e:Lxu;

.field private f:Lxy;

.field private g:Lyd;

.field private h:Lye;

.field private i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1

    invoke-direct {p0}, Lyn;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lxx;->i:Ljava/lang/String;

    iput-object p1, p0, Lxx;->a:Landroid/app/Activity;

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lya;->a(Landroid/content/Context;)Lya;

    move-result-object v0

    iput-object v0, p0, Lxx;->b:Lya;

    return-void
.end method

.method public static a(Landroid/content/Context;ZLcom/google/android/gms/internal/ea;)V
    .locals 2

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "com.google.android.gms.ads.purchase.InAppPurchaseActivity"

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "com.google.android.gms.ads.internal.purchase.useClientJar"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    invoke-static {v0, p2}, Lcom/google/android/gms/internal/ea;->a(Landroid/content/Intent;Lcom/google/android/gms/internal/ea;)V

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private a(Ljava/lang/String;ZILandroid/content/Intent;)V
    .locals 6

    iget-object v0, p0, Lxx;->g:Lyd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lxx;->g:Lyd;

    iget-object v5, p0, Lxx;->f:Lxy;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    invoke-interface/range {v0 .. v5}, Lyd;->a(Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/ea;->a(Landroid/content/Intent;)Lcom/google/android/gms/internal/ea;

    move-result-object v0

    iget-object v1, v0, Lcom/google/android/gms/internal/ea;->e:Lyd;

    iput-object v1, p0, Lxx;->g:Lyd;

    iget-object v1, v0, Lcom/google/android/gms/internal/ea;->b:Lye;

    iput-object v1, p0, Lxx;->h:Lye;

    iget-object v1, v0, Lcom/google/android/gms/internal/ea;->c:Lyg;

    iput-object v1, p0, Lxx;->d:Lyg;

    new-instance v1, Lxu;

    iget-object v2, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lxu;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lxx;->e:Lxu;

    iget-object v0, v0, Lcom/google/android/gms/internal/ea;->d:Landroid/content/Context;

    iput-object v0, p0, Lxx;->c:Landroid/content/Context;

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    :goto_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.android.vending.billing.InAppBillingService.BIND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "com.android.vending"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v1, p0, Lxx;->a:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, p0, v2}, Landroid/app/Activity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    return-void

    :cond_0
    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    goto :goto_0
.end method

.method public a(IILandroid/content/Intent;)V
    .locals 5

    const/4 v4, 0x0

    const/16 v0, 0x3e9

    if-ne p1, v0, :cond_1

    const/4 v0, 0x0

    :try_start_0
    invoke-static {p3}, Lyc;->a(Landroid/content/Intent;)I

    move-result v1

    const/4 v2, -0x1

    if-ne p2, v2, :cond_2

    if-nez v1, :cond_2

    iget-object v2, p0, Lxx;->h:Lye;

    iget-object v3, p0, Lxx;->i:Ljava/lang/String;

    invoke-virtual {v2, v3, p2, p3}, Lye;->a(Ljava/lang/String;ILandroid/content/Intent;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x1

    :cond_0
    :goto_0
    iget-object v2, p0, Lxx;->d:Lyg;

    invoke-interface {v2, v1}, Lyg;->c(I)V

    iget-object v1, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->finish()V

    iget-object v1, p0, Lxx;->d:Lyg;

    invoke-interface {v1}, Lyg;->a()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0, p2, p3}, Lxx;->a(Ljava/lang/String;ZILandroid/content/Intent;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iput-object v4, p0, Lxx;->i:Ljava/lang/String;

    :cond_1
    :goto_1
    return-void

    :cond_2
    :try_start_1
    iget-object v2, p0, Lxx;->b:Lya;

    iget-object v3, p0, Lxx;->f:Lxy;

    invoke-virtual {v2, v3}, Lya;->a(Lxy;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    const-string v0, "Fail to process purchase result."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    iput-object v4, p0, Lxx;->i:Ljava/lang/String;

    goto :goto_1

    :catchall_0
    move-exception v0

    iput-object v4, p0, Lxx;->i:Ljava/lang/String;

    throw v0
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v0, p0}, Landroid/app/Activity;->unbindService(Landroid/content/ServiceConnection;)V

    iget-object v0, p0, Lxx;->e:Lxu;

    invoke-virtual {v0}, Lxu;->a()V

    return-void
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 8

    iget-object v1, p0, Lxx;->e:Lxu;

    invoke-virtual {v1, p2}, Lxu;->a(Landroid/os/IBinder;)V

    :try_start_0
    iget-object v1, p0, Lxx;->h:Lye;

    invoke-virtual {v1}, Lye;->a()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lxx;->i:Ljava/lang/String;

    iget-object v1, p0, Lxx;->e:Lxu;

    iget-object v2, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lxx;->d:Lyg;

    invoke-interface {v3}, Lyg;->a()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lxx;->i:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4}, Lxu;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    const-string v1, "BUY_INTENT"

    invoke-virtual {v3, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Landroid/app/PendingIntent;

    move-object v2, v0

    if-nez v2, :cond_0

    invoke-static {v3}, Lyc;->a(Landroid/os/Bundle;)I

    move-result v1

    iget-object v2, p0, Lxx;->d:Lyg;

    invoke-interface {v2, v1}, Lyg;->c(I)V

    iget-object v2, p0, Lxx;->d:Lyg;

    invoke-interface {v2}, Lyg;->a()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-direct {p0, v2, v3, v1, v4}, Lxx;->a(Ljava/lang/String;ZILandroid/content/Intent;)V

    iget-object v1, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->finish()V

    :goto_0
    return-void

    :cond_0
    new-instance v1, Lxy;

    iget-object v3, p0, Lxx;->d:Lyg;

    invoke-interface {v3}, Lyg;->a()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lxx;->i:Ljava/lang/String;

    invoke-direct {v1, v3, v4}, Lxy;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, p0, Lxx;->f:Lxy;

    iget-object v1, p0, Lxx;->b:Lya;

    iget-object v3, p0, Lxx;->f:Lxy;

    invoke-virtual {v1, v3}, Lya;->b(Lxy;)V

    iget-object v1, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/PendingIntent;->getIntentSender()Landroid/content/IntentSender;

    move-result-object v2

    const/16 v3, 0x3e9

    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4}, Landroid/content/Intent;-><init>()V

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-virtual/range {v1 .. v7}, Landroid/app/Activity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    :catch_0
    move-exception v1

    :goto_1
    const-string v2, "Error when connecting in-app billing service"

    invoke-static {v2, v1}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v1, p0, Lxx;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->finish()V

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 1

    const-string v0, "In-app billing service disconnected."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lxx;->e:Lxu;

    invoke-virtual {v0}, Lxu;->a()V

    return-void
.end method
