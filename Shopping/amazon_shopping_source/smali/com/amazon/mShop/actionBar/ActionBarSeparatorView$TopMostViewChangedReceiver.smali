.class Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ActionBarSeparatorView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TopMostViewChangedReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;->this$0:Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;
    .param p2, "x1"    # Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$1;

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;-><init>(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 53
    const-string/jumbo v0, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView$TopMostViewChangedReceiver;->this$0:Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;

    # invokes: Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->updateVisiblity()V
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;->access$100(Lcom/amazon/mShop/actionBar/ActionBarSeparatorView;)V

    .line 57
    :cond_0
    return-void
.end method
