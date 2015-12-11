.class public Lcom/wishabi/flipp/util/p;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Landroid/content/SharedPreferences;
    .locals 4

    .prologue
    .line 57
    const-class v1, Lcom/wishabi/flipp/util/p;

    monitor-enter v1

    .line 58
    :try_start_0
    sget-object v0, Lcom/wishabi/flipp/util/p;->a:Landroid/content/SharedPreferences;

    if-nez v0, :cond_1

    .line 59
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    .line 60
    if-nez v0, :cond_0

    .line 61
    const/4 v0, 0x0

    monitor-exit v1

    .line 67
    :goto_0
    return-object v0

    .line 62
    :cond_0
    const-string v2, "com.wishabi.flipp.preferences"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/util/p;->a:Landroid/content/SharedPreferences;

    .line 65
    :cond_1
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    sget-object v0, Lcom/wishabi/flipp/util/p;->a:Landroid/content/SharedPreferences;

    goto :goto_0

    .line 65
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
