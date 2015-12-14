.class public Lcom/livemixtapes/MediaButtonHelper;
.super Ljava/lang/Object;
.source "MediaButtonHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MediaButtonHelper"

.field static sMethodRegisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

.field static sMethodUnregisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 14
    invoke-static {}, Lcom/livemixtapes/MediaButtonHelper;->initializeStaticCompatMethods()V

    .line 17
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static initializeStaticCompatMethods()V
    .locals 5

    .prologue
    .line 20
    :try_start_0
    const-class v0, Landroid/media/AudioManager;

    .line 21
    const-string v1, "registerMediaButtonEventReceiver"

    .line 22
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/ComponentName;

    aput-object v4, v2, v3

    .line 20
    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/MediaButtonHelper;->sMethodRegisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

    .line 23
    const-class v0, Landroid/media/AudioManager;

    .line 24
    const-string v1, "unregisterMediaButtonEventReceiver"

    .line 25
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/ComponentName;

    aput-object v4, v2, v3

    .line 23
    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/MediaButtonHelper;->sMethodUnregisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    :goto_0
    return-void

    .line 26
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static registerMediaButtonEventReceiverCompat(Landroid/media/AudioManager;Landroid/content/ComponentName;)V
    .locals 5
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "receiver"    # Landroid/content/ComponentName;

    .prologue
    .line 32
    sget-object v2, Lcom/livemixtapes/MediaButtonHelper;->sMethodRegisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

    if-nez v2, :cond_0

    .line 51
    :goto_0
    return-void

    .line 35
    :cond_0
    :try_start_0
    sget-object v2, Lcom/livemixtapes/MediaButtonHelper;->sMethodRegisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v2, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 36
    :catch_0
    move-exception v1

    .line 38
    .local v1, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v1}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 39
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v2, v0, Ljava/lang/RuntimeException;

    if-eqz v2, :cond_1

    .line 40
    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 41
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_1
    instance-of v2, v0, Ljava/lang/Error;

    if-eqz v2, :cond_2

    .line 42
    check-cast v0, Ljava/lang/Error;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 45
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_2
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 47
    .end local v0    # "cause":Ljava/lang/Throwable;
    .end local v1    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_1
    move-exception v1

    .line 48
    .local v1, "e":Ljava/lang/IllegalAccessException;
    const-string v2, "MediaButtonHelper"

    const-string v3, "IllegalAccessException invoking registerMediaButtonEventReceiver."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method public static unregisterMediaButtonEventReceiverCompat(Landroid/media/AudioManager;Landroid/content/ComponentName;)V
    .locals 5
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "receiver"    # Landroid/content/ComponentName;

    .prologue
    .line 55
    sget-object v2, Lcom/livemixtapes/MediaButtonHelper;->sMethodUnregisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

    if-nez v2, :cond_0

    .line 74
    :goto_0
    return-void

    .line 58
    :cond_0
    :try_start_0
    sget-object v2, Lcom/livemixtapes/MediaButtonHelper;->sMethodUnregisterMediaButtonEventReceiver:Ljava/lang/reflect/Method;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v2, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 59
    :catch_0
    move-exception v1

    .line 61
    .local v1, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v1}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 62
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v2, v0, Ljava/lang/RuntimeException;

    if-eqz v2, :cond_1

    .line 63
    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 64
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_1
    instance-of v2, v0, Ljava/lang/Error;

    if-eqz v2, :cond_2

    .line 65
    check-cast v0, Ljava/lang/Error;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 68
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_2
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 70
    .end local v0    # "cause":Ljava/lang/Throwable;
    .end local v1    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_1
    move-exception v1

    .line 71
    .local v1, "e":Ljava/lang/IllegalAccessException;
    const-string v2, "MediaButtonHelper"

    const-string v3, "IllegalAccessException invoking unregisterMediaButtonEventReceiver."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method
