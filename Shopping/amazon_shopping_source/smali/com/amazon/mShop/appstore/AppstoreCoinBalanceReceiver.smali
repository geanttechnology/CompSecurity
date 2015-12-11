.class public Lcom/amazon/mShop/appstore/AppstoreCoinBalanceReceiver;
.super Landroid/content/BroadcastReceiver;
.source "AppstoreCoinBalanceReceiver.java"


# instance fields
.field private final COINS_BALANCE:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 12
    const-string/jumbo v0, "coinValue"

    iput-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreCoinBalanceReceiver;->COINS_BALANCE:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 15
    const-string/jumbo v2, "coinValue"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 16
    .local v1, "coins":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    .line 17
    .local v0, "adapter":Lcom/amazon/mShop/gno/GNOItemAdapter;
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setAppstoreCoinsCount(Ljava/lang/String;)V

    .line 18
    return-void
.end method
