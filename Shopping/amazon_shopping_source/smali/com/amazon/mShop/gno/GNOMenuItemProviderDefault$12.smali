.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDefault.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field res:Landroid/content/res/Resources;

.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$stringId:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;I)V
    .locals 1

    .prologue
    .line 567
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->val$context:Landroid/content/Context;

    iput p3, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->val$stringId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 568
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->val$context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->res:Landroid/content/res/Resources;

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 3
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 572
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->res:Landroid/content/res/Resources;

    iget v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;->val$stringId:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 575
    .local v0, "targetUrl":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 576
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getTargetUrlOverride(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 579
    invoke-static {}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->isUrlToastEnabled()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 580
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 584
    :cond_0
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 585
    return-void
.end method
