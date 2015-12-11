.class final Lcom/amazon/identity/platform/metric/MetricsHelper$2;
.super Ljava/lang/Object;
.source "MetricsHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-object p2, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    iput-object p3, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 207
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v0, :cond_1

    .line 209
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 212
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_2

    .line 214
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 216
    :cond_2
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 188
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v0, :cond_1

    .line 190
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 193
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_2

    .line 195
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 197
    :cond_2
    return-void
.end method
