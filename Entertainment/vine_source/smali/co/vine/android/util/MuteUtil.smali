.class public Lco/vine/android/util/MuteUtil;
.super Ljava/lang/Object;
.source "MuteUtil.java"


# static fields
.field public static final ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

.field public static final ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

.field public static final BROADCAST_PERMISSION:Ljava/lang/String; = "co.vine.android.BROADCAST"

.field public static final MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

.field private static final PREF_MUTE:Ljava/lang/String; = "mute"

.field private static sp:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 14
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".muted"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    .line 15
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".un_muted"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

    .line 20
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/util/MuteUtil;->MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

    .line 23
    sget-object v0, Lco/vine/android/util/MuteUtil;->MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 24
    sget-object v0, Lco/vine/android/util/MuteUtil;->MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 25
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized isMuted(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    const-class v1, Lco/vine/android/util/MuteUtil;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 40
    const-string v0, "mute"

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    .line 42
    :cond_0
    sget-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    const-string v2, "mute"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit v1

    return v0

    .line 39
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setMuted(Landroid/content/Context;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "mute"    # Z

    .prologue
    .line 30
    const-class v1, Lco/vine/android/util/MuteUtil;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 31
    const-string v0, "mute"

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    .line 33
    :cond_0
    sget-object v0, Lco/vine/android/util/MuteUtil;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "mute"

    invoke-interface {v0, v2, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 34
    const-string v0, "Mute state change send."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 35
    new-instance v2, Landroid/content/Intent;

    if-eqz p1, :cond_1

    sget-object v0, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    :goto_0
    invoke-direct {v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v0, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v2, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    monitor-exit v1

    return-void

    .line 35
    :cond_1
    :try_start_1
    sget-object v0, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 30
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
