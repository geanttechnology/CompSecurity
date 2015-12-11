.class Lcom/poshmark/ui/fragments/BrandFragment$5;
.super Ljava/lang/Object;
.source "BrandFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment;->setupHeaderViewHolder(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 329
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 330
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/BrandFragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/BrandFragment;->access$100(Lcom/poshmark/ui/fragments/BrandFragment;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 331
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/triggers/PMTriggerManager;->getBrandShareTrigger()Lcom/poshmark/triggers/BrandShareTrigger;

    move-result-object v2

    .line 332
    .local v2, "trigger":Lcom/poshmark/triggers/BrandShareTrigger;
    if-eqz v2, :cond_0

    .line 333
    sget-object v3, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INTERACTED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v2, v3}, Lcom/poshmark/triggers/BrandShareTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 334
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "brand"

    const-string v6, "brand_share_banner_invite_friends_button_tapped"

    iget-object v7, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/BrandFragment;->access$200(Lcom/poshmark/ui/fragments/BrandFragment;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 337
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "MODE"

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    const-class v3, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandFragment$5;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/BrandFragment;->access$100(Lcom/poshmark/ui/fragments/BrandFragment;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 340
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "trigger":Lcom/poshmark/triggers/BrandShareTrigger;
    :cond_1
    return-void
.end method
