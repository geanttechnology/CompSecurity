.class public Lcom/penthera/virtuososdk/service/VirtuosoServiceStarter;
.super Landroid/content/BroadcastReceiver;
.source "VirtuosoServiceStarter.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private static startService(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 63
    new-instance v0, Landroid/content/ComponentName;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    .local v0, "comp":Landroid/content/ComponentName;
    invoke-virtual {p1, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 66
    invoke-virtual {p0, p1}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 67
    return-void
.end method


# virtual methods
.method handleBoot(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 52
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 53
    invoke-static {p1, v0}, Lcom/penthera/virtuososdk/service/VirtuosoServiceStarter;->startService(Landroid/content/Context;Landroid/content/Intent;)V

    .line 54
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aIntent"    # Landroid/content/Intent;

    .prologue
    .line 23
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 42
    :goto_0
    return-void

    .line 28
    :cond_0
    const-string v1, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 29
    const-string v1, "VirtuosoServiceStarter"

    const-string v2, "ServiceStarter(): INTENT_BOOT"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/service/VirtuosoServiceStarter;->handleBoot(Landroid/content/Context;)V

    goto :goto_0

    .line 31
    :cond_1
    const-string v1, "virtuoso.intent.action.DOWNLOAD_UPDATE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 32
    const-string v1, "VirtuosoServiceStarter"

    const-string v2, "ServiceStarter(): INTENT_DOWNLOAD_UPDATE"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    invoke-static {p1, p2}, Lcom/penthera/virtuososdk/service/VirtuosoServiceStarter;->startService(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0

    .line 34
    :cond_2
    const-string v1, "virtuoso.intent.action.START_VIRTUOSO_SERVICE_LOGGING"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 35
    const-string v1, "VirtuosoServiceStarter"

    const-string v2, "ServiceStarter(): START_VIRTUOSO_SERVICE_LOGGING"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    invoke-static {p1, p2}, Lcom/penthera/virtuososdk/service/VirtuosoServiceStarter;->startService(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0

    .line 40
    :cond_3
    const-string v1, "VirtuosoServiceStarter"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "ServiceStarter(): Uknown Intent Action: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
