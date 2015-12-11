.class Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;
.super Ljava/lang/Object;
.source "FastBrowseActivity.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->initLayout()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBlockGno()V
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->lock()V

    .line 171
    return-void
.end method

.method public onCloseGno()V
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setVisibility(I)V

    .line 183
    return-void
.end method

.method public onReturn(Ljava/lang/String;)V
    .locals 4
    .param p1, "browseUrl"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 150
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 151
    .local v1, "uri":Landroid/net/Uri;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->buildCategoryBrowseLink(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 152
    .local v0, "link":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->calcWebviewStartTime()V

    .line 153
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # invokes: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->clearWebViewData()V
    invoke-static {v2}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$000(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V

    .line 155
    const-string/jumbo v2, "/s/browse/categories"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 156
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    const/4 v3, 0x1

    # setter for: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$102(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Z)Z

    .line 157
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setVisibility(I)V

    .line 164
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # invokes: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V
    invoke-static {v2, v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$200(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Ljava/lang/String;)V

    .line 166
    return-void

    .line 159
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # setter for: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$102(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Z)Z

    .line 160
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 161
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setVisibility(I)V

    goto :goto_0
.end method

.method public onReturnAIV()V
    .locals 6

    .prologue
    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getActivity()Landroid/app/Activity;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    iget-object v3, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_url:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "forceClearHistory"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 190
    return-void
.end method

.method public onReturnAPP()V
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getActivity()Landroid/app/Activity;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-virtual {v1}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->name()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method public onUnblockGno()V
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 176
    return-void
.end method
