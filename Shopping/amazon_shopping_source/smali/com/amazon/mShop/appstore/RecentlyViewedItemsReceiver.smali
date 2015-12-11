.class public Lcom/amazon/mShop/appstore/RecentlyViewedItemsReceiver;
.super Landroid/content/BroadcastReceiver;
.source "RecentlyViewedItemsReceiver.java"


# instance fields
.field private final ASIN_EXTRA:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 11
    const-string/jumbo v0, "asin"

    iput-object v0, p0, Lcom/amazon/mShop/appstore/RecentlyViewedItemsReceiver;->ASIN_EXTRA:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 15
    const-string/jumbo v1, "asin"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 16
    .local v0, "asin":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 17
    invoke-static {p1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->logViewHistory(Landroid/content/Context;Ljava/lang/String;)V

    .line 19
    :cond_0
    return-void
.end method
