.class public Lcom/livemixtapes/SplashActivity;
.super Landroid/app/Activity;
.source "SplashActivity.java"


# instance fields
.field private loading:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 13
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/SplashActivity;->loading:Ljava/lang/Boolean;

    .line 12
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/SplashActivity;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/livemixtapes/SplashActivity;->openMain()V

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/SplashActivity;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/livemixtapes/SplashActivity;->openLogin()V

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/SplashActivity;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 13
    iput-object p1, p0, Lcom/livemixtapes/SplashActivity;->loading:Ljava/lang/Boolean;

    return-void
.end method

.method private openLogin()V
    .locals 2

    .prologue
    .line 44
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/livemixtapes/Login;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 45
    return-void
.end method

.method private openMain()V
    .locals 2

    .prologue
    .line 48
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/livemixtapes/MainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 49
    return-void
.end method

.method private refreshAuth()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/livemixtapes/SplashActivity;->loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    :goto_0
    return-void

    .line 55
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/SplashActivity;->loading:Ljava/lang/Boolean;

    .line 57
    new-instance v0, Lcom/livemixtapes/SplashActivity$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SplashActivity$1;-><init>(Lcom/livemixtapes/SplashActivity;)V

    invoke-static {v0}, Lcom/livemixtapes/User;->refresh(Lcom/livemixtapes/User$UserCallback;)V

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 29
    .local v0, "mNotifyManager":Landroid/app/NotificationManager;
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 31
    invoke-virtual {p0}, Lcom/livemixtapes/SplashActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ActionBar;->hide()V

    .line 33
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 34
    invoke-direct {p0}, Lcom/livemixtapes/SplashActivity;->openMain()V

    .line 41
    :goto_0
    return-void

    .line 35
    :cond_0
    invoke-static {}, Lcom/livemixtapes/User;->hasAuth()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_1

    .line 36
    invoke-direct {p0}, Lcom/livemixtapes/SplashActivity;->openLogin()V

    goto :goto_0

    .line 38
    :cond_1
    const v1, 0x7f03003d

    invoke-virtual {p0, v1}, Lcom/livemixtapes/SplashActivity;->setContentView(I)V

    .line 39
    invoke-direct {p0}, Lcom/livemixtapes/SplashActivity;->refreshAuth()V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 22
    new-array v1, v4, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 18
    const-string v3, "SPLASH DESTROYED"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 19
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 20
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 21
    .local v0, "mNotifyManager":Landroid/app/NotificationManager;
    invoke-virtual {v0, v4}, Landroid/app/NotificationManager;->cancel(I)V

    return-void
.end method
