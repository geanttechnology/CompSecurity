.class public Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
.super Ljava/lang/Object;
.source "RetailSearchAndroidPlatform.java"

# interfaces
.implements Lcom/amazon/retailsearch/j2me/client/util/Platform;


# instance fields
.field private handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->handler:Landroid/os/Handler;

    .line 24
    return-void
.end method


# virtual methods
.method public invokeLater(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 30
    return-void
.end method

.method public invokeLater(Ljava/lang/Runnable;J)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p2, "delayMillis"    # J

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 36
    return-void
.end method
