.class public Lcom/aio/downloader/floatwindow/MyFloatService;
.super Landroid/app/Service;
.source "MyFloatService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field mAlarmManager:Landroid/app/AlarmManager;

.field mPendingIntent:Landroid/app/PendingIntent;

.field onClickReceiver:Landroid/content/BroadcastReceiver;

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 33
    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mAlarmManager:Landroid/app/AlarmManager;

    .line 34
    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 37
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->handler:Landroid/os/Handler;

    .line 169
    new-instance v0, Lcom/aio/downloader/floatwindow/MyFloatService$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/floatwindow/MyFloatService$1;-><init>(Lcom/aio/downloader/floatwindow/MyFloatService;)V

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->onClickReceiver:Landroid/content/BroadcastReceiver;

    .line 32
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/floatwindow/MyFloatService;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method public static collapseStatusBar(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 215
    :try_start_0
    const-string v3, "statusbar"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 217
    .local v2, "statusBarManager":Ljava/lang/Object;
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-gt v3, v4, :cond_0

    .line 218
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string v4, "collapse"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 223
    .local v0, "collapse":Ljava/lang/reflect/Method;
    :goto_0
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    .end local v0    # "collapse":Ljava/lang/reflect/Method;
    .end local v2    # "statusBarManager":Ljava/lang/Object;
    :goto_1
    return-void

    .line 220
    .restart local v2    # "statusBarManager":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    .line 221
    const-string v4, "collapsePanels"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    .line 220
    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .restart local v0    # "collapse":Ljava/lang/reflect/Method;
    goto :goto_0

    .line 224
    .end local v0    # "collapse":Ljava/lang/reflect/Method;
    .end local v2    # "statusBarManager":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 225
    .local v1, "localException":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private getHomes()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 156
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 157
    .local v1, "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/MyFloatService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 158
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v0, Landroid/content/Intent;

    const-string v5, "android.intent.action.MAIN"

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 159
    .local v0, "intent":Landroid/content/Intent;
    const-string v5, "android.intent.category.HOME"

    invoke-virtual {v0, v5}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 161
    const/high16 v5, 0x10000

    .line 160
    invoke-virtual {v2, v0, v5}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v3

    .line 163
    .local v3, "resolveInfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_0

    .line 167
    return-object v1

    .line 163
    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ResolveInfo;

    .line 165
    .local v4, "ri":Landroid/content/pm/ResolveInfo;
    iget-object v6, v4, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v6, v6, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private isHome()Z
    .locals 4

    .prologue
    .line 143
    const-string v2, "activity"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 144
    .local v0, "mActivityManager":Landroid/app/ActivityManager;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/app/ActivityManager;->getRunningTasks(I)Ljava/util/List;

    move-result-object v1

    .line 147
    .local v1, "rti":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningTaskInfo;>;"
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/MyFloatService;->getHomes()Ljava/util/List;

    move-result-object v3

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningTaskInfo;

    iget-object v2, v2, Landroid/app/ActivityManager$RunningTaskInfo;->topActivity:Landroid/content/ComponentName;

    invoke-virtual {v2}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v3, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    return v2
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 80
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 9

    .prologue
    .line 45
    new-instance v8, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 46
    const-class v1, Lcom/aio/downloader/floatwindow/MyFloatService;

    .line 45
    invoke-direct {v8, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 47
    .local v8, "intent":Landroid/content/Intent;
    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mAlarmManager:Landroid/app/AlarmManager;

    .line 48
    const/4 v0, 0x0

    .line 49
    const/high16 v1, 0x10000000

    .line 48
    invoke-static {p0, v0, v8, v1}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 50
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 51
    .local v2, "now":J
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mAlarmManager:Landroid/app/AlarmManager;

    const/4 v1, 0x1

    const-wide/16 v4, 0x2710

    .line 52
    iget-object v6, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 51
    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 53
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 55
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 56
    .local v7, "filter":Landroid/content/IntentFilter;
    const-string v0, "home"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 57
    const-string v0, "boost"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 58
    const-string v0, "games"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 59
    const-string v0, "camera"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 60
    const-string v0, "set"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 61
    const-string v0, "flash"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService;->onClickReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0, v7}, Lcom/aio/downloader/floatwindow/MyFloatService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 64
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 86
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 91
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 75
    const/4 v0, 0x1

    return v0
.end method
