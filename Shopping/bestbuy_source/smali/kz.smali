.class public Lkz;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field a:Landroid/content/BroadcastReceiver;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private c:Landroid/content/Context;

.field private d:Lno;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lno;)V
    .locals 2

    .prologue
    .line 27
    const v0, 0x103000a

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 49
    new-instance v0, Lkz$1;

    invoke-direct {v0, p0}, Lkz$1;-><init>(Lkz;)V

    iput-object v0, p0, Lkz;->a:Landroid/content/BroadcastReceiver;

    .line 28
    iput-object p1, p0, Lkz;->c:Landroid/content/Context;

    .line 29
    iput-object p2, p0, Lkz;->d:Lno;

    .line 30
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lkz;->setCancelable(Z)V

    .line 31
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 32
    iget-object v1, p0, Lkz;->a:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 33
    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 58
    iget-object v0, p0, Lkz;->c:Landroid/content/Context;

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 59
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 60
    invoke-virtual {v0, v2}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v0

    .line 61
    if-nez v1, :cond_0

    if-eqz v0, :cond_1

    .line 62
    :cond_0
    iget-object v0, p0, Lkz;->c:Landroid/content/Context;

    invoke-static {v0}, Llm;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 69
    :cond_1
    :goto_0
    return-void

    .line 64
    :cond_2
    invoke-virtual {p0}, Lkz;->dismiss()V

    .line 65
    sput-boolean v2, Lnm;->d:Z

    .line 66
    iget-object v0, p0, Lkz;->d:Lno;

    invoke-interface {v0}, Lno;->a()V

    goto :goto_0
.end method

.method static synthetic a(Lkz;)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lkz;->a()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 44
    iget-object v0, p0, Lkz;->b:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_0

    .line 45
    iget-object v0, p0, Lkz;->c:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 47
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 36
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 37
    const v0, 0x7f030080

    invoke-virtual {p0, v0}, Lkz;->setContentView(I)V

    .line 38
    const v0, 0x7f0c01ea

    invoke-virtual {p0, v0}, Lkz;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lkz;->b:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 39
    iget-object v0, p0, Lkz;->b:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    return-void
.end method
