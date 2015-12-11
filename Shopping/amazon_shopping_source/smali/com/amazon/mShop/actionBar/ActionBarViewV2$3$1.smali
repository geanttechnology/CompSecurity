.class Lcom/amazon/mShop/actionBar/ActionBarViewV2$3$1;
.super Ljava/lang/Object;
.source "ActionBarViewV2.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3$1;->this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 110
    new-instance v1, Lcom/amazon/mShop/search/SearchIntentBuilder;

    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3$1;->this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;

    iget-object v2, v2, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v0

    .line 115
    .local v0, "searchIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3$1;->this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;

    iget-object v1, v1, Lcom/amazon/mShop/actionBar/ActionBarViewV2$3;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    .line 116
    const-string/jumbo v1, "gno_sr"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 117
    return-void
.end method
