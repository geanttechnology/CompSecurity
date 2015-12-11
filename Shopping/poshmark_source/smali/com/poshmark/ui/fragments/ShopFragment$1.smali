.class Lcom/poshmark/ui/fragments/ShopFragment$1;
.super Ljava/lang/Object;
.source "ShopFragment.java"

# interfaces
.implements Lcom/poshmark/utils/PMSearchViewListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShopFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShopFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShopFragment;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clearSearchString()V
    .locals 2

    .prologue
    .line 139
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public fireKeywordSearch(Landroid/os/Bundle;Lcom/poshmark/utils/SearchFilterModel;Z)V
    .locals 3
    .param p1, "searchTriggerBundle"    # Landroid/os/Bundle;
    .param p2, "model"    # Lcom/poshmark/utils/SearchFilterModel;
    .param p3, "fireBrandSearch"    # Z

    .prologue
    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {p2}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 130
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    if-eqz p3, :cond_0

    .line 131
    const-class v1, Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v0, p1, v1, p2}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 135
    :goto_0
    return-void

    .line 133
    :cond_0
    const-class v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, p1, v1, p2}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method
