.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;
.super Ljava/lang/Object;
.source "MetaItemListViewFragment.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupSearchListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 335
    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-boolean v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showBrandFollowButton:Z

    if-eqz v0, :cond_0

    .line 336
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "brand"

    const-string v3, "brand_searched"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    :cond_0
    return-void
.end method
