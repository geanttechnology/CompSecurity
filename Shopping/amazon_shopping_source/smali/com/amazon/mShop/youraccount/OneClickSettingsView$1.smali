.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 104
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickStatusEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    # invokes: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->setOneClickSetting(Z)V
    invoke-static {v1, v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$100(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Z)V

    .line 105
    return-void

    .line 104
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
