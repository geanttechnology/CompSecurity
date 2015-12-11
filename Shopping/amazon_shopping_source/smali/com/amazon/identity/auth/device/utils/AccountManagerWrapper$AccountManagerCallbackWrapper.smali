.class Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;
.super Ljava/lang/Object;
.source "AccountManagerWrapper.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountManagerCallbackWrapper"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mCallback:Landroid/accounts/AccountManagerCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/accounts/AccountManagerCallback",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;


# direct methods
.method constructor <init>(Landroid/accounts/AccountManagerCallback;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)V
    .locals 0
    .param p2, "timer"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerCallback",
            "<TT;>;",
            "Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;",
            ")V"
        }
    .end annotation

    .prologue
    .line 454
    .local p0, "this":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;, "Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper<TT;>;"
    .local p1, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 455
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;->mCallback:Landroid/accounts/AccountManagerCallback;

    .line 456
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;->mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 457
    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 462
    .local p0, "this":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;, "Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper<TT;>;"
    .local p1, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;->mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 463
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;->mCallback:Landroid/accounts/AccountManagerCallback;

    if-eqz v0, :cond_0

    .line 465
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AccountManagerCallbackWrapper;->mCallback:Landroid/accounts/AccountManagerCallback;

    invoke-interface {v0, p1}, Landroid/accounts/AccountManagerCallback;->run(Landroid/accounts/AccountManagerFuture;)V

    .line 467
    :cond_0
    return-void
.end method
