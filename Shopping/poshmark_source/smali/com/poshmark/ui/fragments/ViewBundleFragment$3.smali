.class Lcom/poshmark/ui/fragments/ViewBundleFragment$3;
.super Ljava/lang/Object;
.source "ViewBundleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ViewBundleFragment;->createAllViews(Landroid/view/View;)V
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
    .line 176
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$3;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 179
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$3;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "bundle"

    const-string v4, "view_my_bundles_tapped"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 181
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "MODE"

    sget-object v2, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$3;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    const-class v2, Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v1, v0, v2, v5}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 183
    return-void
.end method
