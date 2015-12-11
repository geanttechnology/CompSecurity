.class final Lcom/amazon/identity/auth/device/framework/GenericIPCSender$2;
.super Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
.source "GenericIPCSender.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getGenericIpcManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
        "<",
        "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Executor;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 481
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Executor;)V

    return-void
.end method


# virtual methods
.method protected asInterface(Landroid/os/IBinder;)Lcom/amazon/identity/auth/device/callback/IGenericIPC;
    .locals 1
    .param p1, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 485
    invoke-static {p1}, Lcom/amazon/identity/auth/device/callback/IGenericIPC$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/identity/auth/device/callback/IGenericIPC;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic asInterface(Landroid/os/IBinder;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/IBinder;

    .prologue
    .line 481
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$2;->asInterface(Landroid/os/IBinder;)Lcom/amazon/identity/auth/device/callback/IGenericIPC;

    move-result-object v0

    return-object v0
.end method
