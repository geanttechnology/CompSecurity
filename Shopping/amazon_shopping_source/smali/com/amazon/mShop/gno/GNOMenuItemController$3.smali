.class Lcom/amazon/mShop/gno/GNOMenuItemController$3;
.super Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
.source "GNOMenuItemController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController;->buildGNODrawerItem(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Lcom/amazon/mShop/gno/GNODrawerItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

.field final synthetic val$isAIVGateway:Z

.field final synthetic val$isIdContainingAIV:Z

.field final synthetic val$targetUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;ZZ)V
    .locals 1

    .prologue
    .line 350
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$targetUrl:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$isIdContainingAIV:Z

    iput-boolean p4, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$isAIVGateway:Z

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOMenuItemController$1;)V

    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 5
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v4, 0x0

    .line 355
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 356
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$targetUrl:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getTargetUrlOverride(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 359
    .local v0, "url":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->isUrlToastEnabled()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 360
    invoke-static {p1, v0, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 366
    :cond_0
    :goto_0
    iget-boolean v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$isIdContainingAIV:Z

    if-eqz v1, :cond_3

    .line 367
    iget-boolean v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$isAIVGateway:Z

    if-eqz v1, :cond_2

    .line 369
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$targetUrl:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 379
    :goto_1
    return-void

    .line 363
    .end local v0    # "url":Ljava/lang/String;
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$3;->val$targetUrl:Ljava/lang/String;

    .restart local v0    # "url":Ljava/lang/String;
    goto :goto_0

    .line 372
    :cond_2
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    const-string/jumbo v3, "forceClearHistory"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v2, v0, v3, v4}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    goto :goto_1

    .line 377
    :cond_3
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    goto :goto_1
.end method
