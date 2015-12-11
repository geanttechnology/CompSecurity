.class public Lcom/amazon/mShop/TimeChangedReceiver;
.super Landroid/content/BroadcastReceiver;
.source "TimeChangedReceiver.java"


# static fields
.field public static final INTENT_FILTER:Landroid/content/IntentFilter;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 18
    new-instance v0, Landroid/content/IntentFilter;

    const-string/jumbo v1, "android.intent.action.TIME_SET"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/TimeChangedReceiver;->INTENT_FILTER:Landroid/content/IntentFilter;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    .line 24
    .local v0, "cartController":Lcom/amazon/mShop/control/cart/CartController;
    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->hasTimedCartItem()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 25
    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->cartIsLoading()Z

    move-result v1

    if-nez v1, :cond_0

    .line 26
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/cart/CartController;->loadCart(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 29
    :cond_0
    return-void
.end method
