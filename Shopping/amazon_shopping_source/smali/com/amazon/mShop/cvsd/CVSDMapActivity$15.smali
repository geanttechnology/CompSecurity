.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->onTap(Lcom/google/android/maps/OverlayItem;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

.field final synthetic val$selectedAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 0

    .prologue
    .line 851
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;->val$selectedAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 856
    invoke-static {}, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->reset()V

    .line 857
    const/4 v1, 0x0

    sput v1, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedType:I

    .line 858
    sget-object v1, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;->val$selectedAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 860
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    const-class v2, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 861
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    const/4 v2, 0x7

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 863
    return-void
.end method
