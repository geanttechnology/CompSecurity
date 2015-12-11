.class Lcom/poshmark/ui/fragments/ViewBundleFragment$5;
.super Ljava/lang/Object;
.source "ViewBundleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ViewBundleFragment;->setupBottomBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V
    .locals 0

    .prologue
    .line 294
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 297
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "bundle"

    const-string v4, "buy_bundle_tapped"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-static {v1}, Lcom/poshmark/utils/FBDPAHelper;->trackBundlePurchaseInitiated(Lcom/poshmark/data_model/models/PMBundle;)V

    .line 299
    new-instance v0, Lcom/poshmark/utils/BundleFlowHandler;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/BundleFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 300
    .local v0, "checkoutFlowHandler":Lcom/poshmark/utils/BundleFlowHandler;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/BundleFlowHandler;->beginCheckoutForBundle(Lcom/poshmark/data_model/models/PMBundle;)V

    .line 301
    return-void
.end method
