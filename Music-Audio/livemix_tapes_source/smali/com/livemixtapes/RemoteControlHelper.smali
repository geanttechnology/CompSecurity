.class public Lcom/livemixtapes/RemoteControlHelper;
.super Ljava/lang/Object;
.source "RemoteControlHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "RemoteControlHelper"

.field private static sHasRemoteControlAPIs:Z

.field private static sRegisterRemoteControlClientMethod:Ljava/lang/reflect/Method;

.field private static sUnregisterRemoteControlClientMethod:Ljava/lang/reflect/Method;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 11
    sput-boolean v2, Lcom/livemixtapes/RemoteControlHelper;->sHasRemoteControlAPIs:Z

    .line 18
    :try_start_0
    const-class v2, Lcom/livemixtapes/RemoteControlHelper;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 20
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    invoke-static {v0}, Lcom/livemixtapes/RemoteControlClientCompat;->getActualRemoteControlClientClass(Ljava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v1

    .line 21
    .local v1, "sRemoteControlClientClass":Ljava/lang/Class;
    const-class v2, Landroid/media/AudioManager;

    .line 22
    const-string v3, "registerRemoteControlClient"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    .line 21
    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    sput-object v2, Lcom/livemixtapes/RemoteControlHelper;->sRegisterRemoteControlClientMethod:Ljava/lang/reflect/Method;

    .line 23
    const-class v2, Landroid/media/AudioManager;

    .line 24
    const-string v3, "unregisterRemoteControlClient"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    .line 23
    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    sput-object v2, Lcom/livemixtapes/RemoteControlHelper;->sUnregisterRemoteControlClientMethod:Ljava/lang/reflect/Method;

    .line 25
    const/4 v2, 0x1

    sput-boolean v2, Lcom/livemixtapes/RemoteControlHelper;->sHasRemoteControlAPIs:Z
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 35
    .end local v1    # "sRemoteControlClientClass":Ljava/lang/Class;
    :goto_0
    return-void

    .line 32
    :catch_0
    move-exception v2

    goto :goto_0

    .line 30
    :catch_1
    move-exception v2

    goto :goto_0

    .line 28
    :catch_2
    move-exception v2

    goto :goto_0

    .line 26
    :catch_3
    move-exception v2

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static registerRemoteControlClient(Landroid/media/AudioManager;Lcom/livemixtapes/RemoteControlClientCompat;)V
    .locals 5
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "remoteControlClient"    # Lcom/livemixtapes/RemoteControlClientCompat;

    .prologue
    .line 39
    sget-boolean v1, Lcom/livemixtapes/RemoteControlHelper;->sHasRemoteControlAPIs:Z

    if-nez v1, :cond_0

    .line 49
    :goto_0
    return-void

    .line 44
    :cond_0
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlHelper;->sRegisterRemoteControlClientMethod:Ljava/lang/reflect/Method;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 45
    invoke-virtual {p1}, Lcom/livemixtapes/RemoteControlClientCompat;->getActualRemoteControlClientObject()Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v2, v3

    .line 44
    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "RemoteControlHelper"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static unregisterRemoteControlClient(Landroid/media/AudioManager;Lcom/livemixtapes/RemoteControlClientCompat;)V
    .locals 5
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "remoteControlClient"    # Lcom/livemixtapes/RemoteControlClientCompat;

    .prologue
    .line 54
    sget-boolean v1, Lcom/livemixtapes/RemoteControlHelper;->sHasRemoteControlAPIs:Z

    if-nez v1, :cond_0

    .line 64
    :goto_0
    return-void

    .line 59
    :cond_0
    :try_start_0
    sget-object v1, Lcom/livemixtapes/RemoteControlHelper;->sUnregisterRemoteControlClientMethod:Ljava/lang/reflect/Method;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 60
    invoke-virtual {p1}, Lcom/livemixtapes/RemoteControlClientCompat;->getActualRemoteControlClientObject()Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v2, v3

    .line 59
    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 61
    :catch_0
    move-exception v0

    .line 62
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "RemoteControlHelper"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
