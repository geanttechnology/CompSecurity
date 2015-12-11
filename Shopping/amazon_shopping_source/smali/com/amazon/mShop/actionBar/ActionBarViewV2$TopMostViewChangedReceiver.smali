.class Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ActionBarViewV2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/actionBar/ActionBarViewV2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TopMostViewChangedReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V
    .locals 0

    .prologue
    .line 239
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/actionBar/ActionBarViewV2;
    .param p2, "x1"    # Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;

    .prologue
    .line 239
    invoke-direct {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 242
    const-string/jumbo v0, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$TopMostViewChangedReceiver;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    invoke-virtual {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->update()V

    .line 246
    :cond_0
    return-void
.end method
