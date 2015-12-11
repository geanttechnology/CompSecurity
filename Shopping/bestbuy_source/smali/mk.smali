.class final Lmk;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static final b:Ljava/lang/Object;

.field private static final c:Ljava/lang/reflect/Method;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    const-class v0, Lmk;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmk;->a:Ljava/lang/String;

    .line 17
    invoke-static {}, Lmk;->b()Ljava/lang/Object;

    move-result-object v0

    sput-object v0, Lmk;->b:Ljava/lang/Object;

    .line 18
    sget-object v0, Lmk;->b:Ljava/lang/Object;

    invoke-static {v0}, Lmk;->a(Ljava/lang/Object;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lmk;->c:Ljava/lang/reflect/Method;

    .line 19
    sget-object v0, Lmk;->b:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 20
    sget-object v0, Lmk;->a:Ljava/lang/String;

    const-string v1, "This device does supports control of a flashlight"

    invoke-static {v0, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    :goto_0
    return-void

    .line 22
    :cond_0
    sget-object v0, Lmk;->a:Ljava/lang/String;

    const-string v1, "This device does not support control of a flashlight"

    invoke-static {v0, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/Class;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 71
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 78
    :goto_0
    return-object v0

    .line 72
    :catch_0
    move-exception v1

    goto :goto_0

    .line 75
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private static varargs a(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 98
    :try_start_0
    invoke-virtual {p0, p1, p2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v0

    .line 108
    :goto_0
    return-object v0

    .line 99
    :catch_0
    move-exception v1

    goto :goto_0

    .line 102
    :catch_1
    move-exception v1

    goto :goto_0

    .line 106
    :catch_2
    move-exception v1

    goto :goto_0
.end method

.method private static varargs a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 85
    :try_start_0
    invoke-virtual {p0, p1, p2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 92
    :goto_0
    return-object v0

    .line 86
    :catch_0
    move-exception v1

    goto :goto_0

    .line 89
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private static a(Ljava/lang/Object;)Ljava/lang/reflect/Method;
    .locals 5

    .prologue
    .line 62
    if-nez p0, :cond_0

    .line 63
    const/4 v0, 0x0

    .line 66
    :goto_0
    return-object v0

    .line 65
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 66
    const-string v1, "setFlashlightEnabled"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    sget-object v4, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lmk;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    goto :goto_0
.end method

.method static a()V
    .locals 1

    .prologue
    .line 117
    const/4 v0, 0x0

    invoke-static {v0}, Lmk;->a(Z)V

    .line 118
    return-void
.end method

.method private static a(Z)V
    .locals 5

    .prologue
    .line 121
    sget-object v0, Lmk;->b:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 122
    sget-object v0, Lmk;->c:Ljava/lang/reflect/Method;

    sget-object v1, Lmk;->b:Ljava/lang/Object;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lmk;->a(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    :cond_0
    return-void
.end method

.method private static b()Ljava/lang/Object;
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v0, 0x0

    .line 31
    const-string v1, "android.os.ServiceManager"

    invoke-static {v1}, Lmk;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 32
    if-nez v1, :cond_1

    .line 58
    :cond_0
    :goto_0
    return-object v0

    .line 36
    :cond_1
    const-string v2, "getService"

    new-array v3, v7, [Ljava/lang/Class;

    const-class v4, Ljava/lang/String;

    aput-object v4, v3, v6

    invoke-static {v1, v2, v3}, Lmk;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 38
    if-eqz v1, :cond_0

    .line 42
    new-array v2, v7, [Ljava/lang/Object;

    const-string v3, "hardware"

    aput-object v3, v2, v6

    invoke-static {v1, v0, v2}, Lmk;->a(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 43
    if-eqz v1, :cond_0

    .line 47
    const-string v2, "android.os.IHardwareService$Stub"

    invoke-static {v2}, Lmk;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 48
    if-eqz v2, :cond_0

    .line 52
    const-string v3, "asInterface"

    new-array v4, v7, [Ljava/lang/Class;

    const-class v5, Landroid/os/IBinder;

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lmk;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 54
    if-eqz v2, :cond_0

    .line 58
    new-array v3, v7, [Ljava/lang/Object;

    aput-object v1, v3, v6

    invoke-static {v2, v0, v3}, Lmk;->a(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method
