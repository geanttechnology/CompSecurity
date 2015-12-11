.class public Lcom/aio/downloader/floatwindow/FloatWindowService;
.super Landroid/app/Service;
.source "FloatWindowService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 27
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->handler:Landroid/os/Handler;

    .line 24
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/floatwindow/FloatWindowService;)Z
    .locals 1

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->isHome()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/floatwindow/FloatWindowService;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->handler:Landroid/os/Handler;

    return-object v0
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
    .line 119
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 120
    .local v1, "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 121
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v0, Landroid/content/Intent;

    const-string v5, "android.intent.action.MAIN"

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 122
    .local v0, "intent":Landroid/content/Intent;
    const-string v5, "android.intent.category.HOME"

    invoke-virtual {v0, v5}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    const/high16 v5, 0x10000

    invoke-virtual {v2, v0, v5}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v3

    .line 125
    .local v3, "resolveInfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_0

    .line 129
    return-object v1

    .line 125
    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ResolveInfo;

    .line 127
    .local v4, "ri":Landroid/content/pm/ResolveInfo;
    iget-object v6, v4, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v6, v6, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private isHome()Z
    .locals 4

    .prologue
    .line 107
    const-string v2, "activity"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/floatwindow/FloatWindowService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 108
    .local v0, "mActivityManager":Landroid/app/ActivityManager;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/app/ActivityManager;->getRunningTasks(I)Ljava/util/List;

    move-result-object v1

    .line 111
    .local v1, "rti":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningTaskInfo;>;"
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->getHomes()Ljava/util/List;

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
    .line 34
    const/4 v0, 0x0

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 49
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 52
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 53
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->timer:Ljava/util/Timer;

    .line 55
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->timer:Ljava/util/Timer;

    if-nez v0, :cond_0

    .line 41
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->timer:Ljava/util/Timer;

    .line 42
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService;->timer:Ljava/util/Timer;

    new-instance v1, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowService;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1f4

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 44
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method
