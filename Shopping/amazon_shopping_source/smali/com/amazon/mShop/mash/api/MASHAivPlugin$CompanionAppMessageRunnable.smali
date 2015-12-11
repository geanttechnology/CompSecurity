.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;
.super Ljava/lang/Object;
.source "MASHAivPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/api/MASHAivPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CompanionAppMessageRunnable"
.end annotation


# instance fields
.field final mActivity:Landroid/app/Activity;

.field private final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 318
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 319
    invoke-static {p1}, Lcom/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    iput-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mActivity:Landroid/app/Activity;

    .line 320
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 321
    return-void
.end method

.method static synthetic access$600(Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;)Lcom/amazon/client/metrics/MetricsFactory;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

    .prologue
    .line 307
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    const/4 v2, 0x0

    .line 325
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v4, "ATVAndroid"

    const-string/jumbo v5, "CompanionAppInstallationNotifier:ContinueClick"

    invoke-interface {v3, v4, v5}, Lcom/amazon/client/metrics/MetricsFactory;->createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;

    move-result-object v7

    .line 326
    .local v7, "clickMetrics":Lcom/amazon/client/metrics/MetricEvent;
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v4, "ATVAndroid"

    const-string/jumbo v5, "CompanionAppInstallationNotifier:DialogDisplay"

    invoke-interface {v3, v4, v5}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v8

    .line 328
    .local v8, "displayMetrics":Lcom/amazon/client/metrics/MetricEvent;
    const/4 v10, 0x0

    .line 329
    .local v10, "noPadding":I
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mActivity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v9

    .line 330
    .local v9, "inflater":Landroid/view/LayoutInflater;
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->aiv_companion_app_installation_dialog:I

    const/4 v4, 0x0

    invoke-virtual {v9, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 331
    .local v1, "dialogContent":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->continue_button:I

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 332
    .local v6, "button":Landroid/widget/Button;
    new-instance v3, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mActivity:Landroid/app/Activity;

    invoke-direct {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .local v0, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    move v3, v2

    move v4, v2

    move v5, v2

    .line 333
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setView(Landroid/view/View;IIII)V

    .line 335
    new-instance v2, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;

    invoke-direct {v2, p0, v7, v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable$1;-><init>(Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/mShop/AmazonAlertDialog;)V

    invoke-virtual {v6, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 350
    const-string/jumbo v2, "Counter"

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    invoke-interface {v8, v2, v3, v4}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 351
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v2, v8}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 352
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 353
    return-void
.end method
