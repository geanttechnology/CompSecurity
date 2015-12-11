.class public Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;
.super Ljava/lang/Object;
.source "SystemPropertiesWrapper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    return-void
.end method

.method private varargs invokeHiddenMethod(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "methodName"    # Ljava/lang/String;
    .param p2, "paramTypes"    # [Ljava/lang/Class;
    .param p3, "args"    # [Ljava/lang/Object;

    .prologue
    .line 23
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v1, "android.os.SystemProperties"

    invoke-virtual {v0, p1, v1, p2, p3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 30
    :goto_0
    return-object v0

    .line 27
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot get SystemProperties"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public get(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 16
    const-string/jumbo v0, "get"

    new-array v1, v4, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    aput-object v2, v1, v3

    new-array v2, v4, [Ljava/lang/Object;

    aput-object p1, v2, v3

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->invokeHiddenMethod(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method
