.class public final Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
.super Landroid/content/BroadcastReceiver;
.source "BatteryMonitor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;,
        Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
    }
.end annotation


# static fields
.field public static BATTERY_LEVEL_LOW:I

.field public static BATTERY_LEVEL_VERY_LOW:I

.field private static iInstance:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;


# instance fields
.field private final LOG_TAG:Ljava/lang/String;

.field private iBatteryCharging:Z

.field private iBatteryConnected:Z

.field private iBatteryLevel:I

.field private iBatteryPluggedState:I

.field private iBatteryStatus:I

.field iEvent:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

.field private iObservers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;",
            ">;"
        }
    .end annotation
.end field

.field private iPreviousRawLevel:I

.field isInit:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iInstance:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .line 29
    const/16 v0, 0x4b

    sput v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->BATTERY_LEVEL_LOW:I

    .line 31
    const/16 v0, 0x14

    sput v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->BATTERY_LEVEL_VERY_LOW:I

    .line 20
    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, -0x1

    const/4 v1, 0x0

    .line 97
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 23
    const-class v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    .line 34
    iput-boolean v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    .line 39
    iput v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    .line 41
    const/4 v0, 0x1

    iput v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryStatus:I

    .line 43
    iput v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    .line 46
    iput-boolean v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryConnected:Z

    .line 47
    iput v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iPreviousRawLevel:I

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    .line 53
    sget-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->NONE:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iEvent:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    .line 55
    iput-boolean v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->isInit:Z

    .line 99
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    .line 100
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
    .locals 3

    .prologue
    .line 82
    const-class v2, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    monitor-enter v2

    const/4 v0, 0x0

    .line 83
    .local v0, "instance":Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iInstance:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    if-eqz v1, :cond_0

    .line 84
    sget-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iInstance:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .line 87
    :cond_0
    if-nez v0, :cond_1

    .line 88
    new-instance v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
    invoke-direct {v0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;-><init>()V

    .line 89
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iInstance:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    :cond_1
    monitor-exit v2

    return-object v0

    .line 82
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private declared-synchronized notifyObservers(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;)V
    .locals 5
    .param p1, "event"    # Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    .prologue
    .line 252
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_1

    .line 266
    monitor-exit p0

    return-void

    .line 252
    :cond_1
    :try_start_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;

    .line 254
    .local v0, "bo":Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
    if-eqz v0, :cond_0

    .line 257
    sget-object v2, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->CONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    if-ne p1, v2, :cond_2

    .line 258
    invoke-interface {v0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;->onPowerConnected()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 252
    .end local v0    # "bo":Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 259
    .restart local v0    # "bo":Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
    :cond_2
    :try_start_2
    sget-object v2, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->DISCONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    if-ne p1, v2, :cond_3

    .line 260
    invoke-interface {v0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;->onPowerDisconnected()V

    goto :goto_0

    .line 261
    :cond_3
    sget-object v2, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->LEVEL_CHANGED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    if-ne p1, v2, :cond_4

    .line 262
    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    invoke-interface {v0, v2}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;->onBatteryLevelChanged(I)V

    goto :goto_0

    .line 264
    :cond_4
    iget-object v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "notifyObservers(): Unhandled event: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private registerReceivers()V
    .locals 3

    .prologue
    .line 146
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 147
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.ACTION_POWER_CONNECTED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 148
    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.ACTION_POWER_DISCONNECTED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 149
    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.BATTERY_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 150
    return-void
.end method

.method private updateInternalState()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 273
    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryStatus:I

    packed-switch v2, :pswitch_data_0

    .line 305
    :goto_0
    return-void

    .line 277
    :pswitch_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Handling BATTERY_STATUS_CHARGING"

    invoke-static {v0, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 278
    iput-boolean v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    goto :goto_0

    .line 285
    :pswitch_1
    iget-object v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Handling BATTERY_STATUS_NOT_CHARGING and BATTERY_STATUS_DISCHARGING"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    if-eq v2, v1, :cond_0

    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    if-eq v2, v4, :cond_0

    :goto_1
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    goto :goto_0

    :cond_0
    move v0, v1

    goto :goto_1

    .line 292
    :pswitch_2
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Handling BATTERY_STATUS_UNKNOWN"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    .line 294
    const/4 v0, -0x1

    iput v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    goto :goto_0

    .line 299
    :pswitch_3
    iget-object v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Handling BATTERY_STATUS_FULL"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    if-eq v2, v1, :cond_1

    iget v2, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    if-eq v2, v4, :cond_1

    :goto_2
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    .line 301
    const/16 v0, 0x64

    iput v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    goto :goto_0

    :cond_1
    move v0, v1

    .line 300
    goto :goto_2

    .line 273
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public declared-synchronized addObserver(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;)V
    .locals 1
    .param p1, "aObserver"    # Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;

    .prologue
    .line 170
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 171
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->registerReceivers()V

    .line 174
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 176
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 179
    :cond_1
    monitor-exit p0

    return-void

    .line 170
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getLevel()I
    .locals 1

    .prologue
    .line 108
    iget v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    return v0
.end method

.method public isCharging()Z
    .locals 1

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    return v0
.end method

.method public declared-synchronized onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aIntent"    # Landroid/content/Intent;

    .prologue
    const/4 v6, 0x0

    const/4 v1, 0x1

    .line 196
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 197
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 198
    iget-object v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v7, "onReceive(): null action"

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 245
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 203
    :cond_1
    :try_start_1
    const-string v7, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 204
    const-string v7, "level"

    const/4 v8, -0x1

    invoke-virtual {p2, v7, v8}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v4

    .line 205
    .local v4, "rawlevel":I
    const-string v7, "plugged"

    const/4 v8, 0x0

    invoke-virtual {p2, v7, v8}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v7

    iput v7, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    .line 206
    iget v7, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    if-lez v7, :cond_4

    .line 208
    .local v1, "charging":Z
    :goto_1
    iget v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iPreviousRawLevel:I

    if-ne v4, v6, :cond_2

    iget-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    if-eq v1, v6, :cond_0

    .line 210
    :cond_2
    iput v4, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iPreviousRawLevel:I

    .line 212
    iget-object v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "+ Battery info level ("

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") status ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryStatus:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") plugged ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->isInit:Z

    .line 216
    const-string v6, "scale"

    const/4 v7, -0x1

    invoke-virtual {p2, v6, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v5

    .line 217
    .local v5, "scale":I
    const-string v6, "status"

    const/4 v7, 0x1

    invoke-virtual {p2, v6, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    iput v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryStatus:I

    .line 220
    const-string v6, "health"

    const/4 v7, -0x1

    invoke-virtual {p2, v6, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    .line 221
    .local v3, "health":I
    const/4 v6, -0x1

    iput v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    .line 222
    if-ltz v4, :cond_3

    if-lez v5, :cond_3

    .line 223
    mul-int/lit8 v6, v4, 0x64

    div-int/2addr v6, v5

    iput v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    .line 225
    :cond_3
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->updateInternalState()V

    .line 226
    sget-object v6, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->LEVEL_CHANGED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    invoke-direct {p0, v6}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->notifyObservers(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;)V

    .line 228
    const-string v6, "virtuoso.intent.action.BATTERY_CHANGE"

    invoke-static {v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;)V

    .line 230
    iget-object v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "- Battery info charging ("

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryCharging:Z

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") level ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryLevel:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") status ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryStatus:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") plugged ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryPluggedState:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 241
    .end local v1    # "charging":Z
    .end local v3    # "health":I
    .end local v4    # "rawlevel":I
    .end local v5    # "scale":I
    :catch_0
    move-exception v2

    .line 242
    .local v2, "e":Ljava/lang/Exception;
    :try_start_2
    iget-object v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v7, "Exception in battery monitor -- ignoring: "

    invoke-static {v6, v7, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_0

    .line 196
    .end local v0    # "action":Ljava/lang/String;
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .restart local v0    # "action":Ljava/lang/String;
    .restart local v4    # "rawlevel":I
    :cond_4
    move v1, v6

    .line 206
    goto/16 :goto_1

    .line 231
    .end local v4    # "rawlevel":I
    :cond_5
    :try_start_3
    const-string v6, "android.intent.action.ACTION_POWER_CONNECTED"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 232
    iget-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryConnected:Z

    if-nez v6, :cond_0

    .line 233
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryConnected:Z

    .line 234
    sget-object v6, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->CONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    invoke-direct {p0, v6}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->notifyObservers(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;)V

    goto/16 :goto_0

    .line 236
    :cond_6
    const-string v6, "android.intent.action.ACTION_POWER_DISCONNECTED"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 237
    iget-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryConnected:Z

    if-eqz v6, :cond_0

    .line 238
    const/4 v6, 0x0

    iput-boolean v6, p0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->iBatteryConnected:Z

    .line 239
    sget-object v6, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->DISCONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    invoke-direct {p0, v6}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->notifyObservers(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0
.end method
