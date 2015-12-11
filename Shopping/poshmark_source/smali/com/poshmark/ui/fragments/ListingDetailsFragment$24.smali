.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/support/v4/widget/DrawerLayout$DrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 1417
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1434
    return-void
.end method

.method public onDrawerOpened(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1425
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    if-eqz v0, :cond_0

    .line 1426
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "listing_actions_button_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1427
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->updateDrawer(Z)V

    .line 1429
    :cond_0
    return-void
.end method

.method public onDrawerSlide(Landroid/view/View;F)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "v"    # F

    .prologue
    .line 1421
    return-void
.end method

.method public onDrawerStateChanged(I)V
    .locals 0
    .param p1, "i"    # I

    .prologue
    .line 1439
    return-void
.end method
