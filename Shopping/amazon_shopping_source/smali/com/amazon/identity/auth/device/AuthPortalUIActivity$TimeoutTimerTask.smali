.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;
.super Ljava/util/TimerTask;
.source "AuthPortalUIActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TimeoutTimerTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p2, "x1"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;

    .prologue
    .line 181
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 187
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTimeoutMetricsName:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ":NetworkState:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$100(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/platform/metric/MetricUtils;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "appendNetworkStateMetricName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 191
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "Unable to render content. Request timed out."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    .line 193
    return-void
.end method
