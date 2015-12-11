.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;
.super Ljava/lang/Object;
.source "MASHAivPlugin.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

.field final synthetic val$clickMetrics:Lcom/amazon/client/metrics/MetricEvent;

.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->this$0:Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->val$clickMetrics:Lcom/amazon/client/metrics/MetricEvent;

    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 339
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->val$clickMetrics:Lcom/amazon/client/metrics/MetricEvent;

    const-string/jumbo v2, "Counter"

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    invoke-interface {v1, v2, v3, v4}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 340
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->this$0:Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

    # getter for: Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;
    invoke-static {v1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->access$600(Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->val$clickMetrics:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 342
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 343
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->isAIVBeta()Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v0, "B00N2886IU"

    .line 346
    .local v0, "companionAsin":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;->this$0:Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mActivity:Landroid/app/Activity;

    invoke-static {v1, v0, v5, v5, v5}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityWithAsin(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    return-void

    .line 343
    .end local v0    # "companionAsin":Ljava/lang/String;
    :cond_0
    const-string/jumbo v0, "B00N28818A"

    goto :goto_0
.end method
