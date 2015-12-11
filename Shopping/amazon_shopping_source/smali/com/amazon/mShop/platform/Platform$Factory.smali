.class public Lcom/amazon/mShop/platform/Platform$Factory;
.super Ljava/lang/Object;
.source "Platform.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/platform/Platform;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# static fields
.field private static instance:Lcom/amazon/mShop/platform/Platform;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/platform/Platform;
    .locals 2

    .prologue
    .line 25
    const-class v0, Lcom/amazon/mShop/platform/Platform$Factory;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/platform/Platform$Factory;->instance:Lcom/amazon/mShop/platform/Platform;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setInstance(Lcom/amazon/mShop/platform/Platform;)V
    .locals 2
    .param p0, "newInstance"    # Lcom/amazon/mShop/platform/Platform;

    .prologue
    .line 29
    const-class v0, Lcom/amazon/mShop/platform/Platform$Factory;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/mShop/platform/Platform$Factory;->instance:Lcom/amazon/mShop/platform/Platform;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    monitor-exit v0

    return-void

    .line 29
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method
