.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->showUseCurrentLocationConfirmationDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 350
    const/4 v1, -0x2

    if-ne p2, v1, :cond_1

    .line 351
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 358
    :cond_0
    :goto_0
    return-void

    .line 352
    :cond_1
    const/4 v1, -0x1

    if-ne p2, v1, :cond_0

    .line 354
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 355
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "allowUseUserCurrentlocation"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 356
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation()V
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    goto :goto_0
.end method
