.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 153
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 158
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "allowUseUserCurrentlocation"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 159
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation()V
    invoke-static {v2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 186
    :goto_0
    return-void

    .line 162
    :cond_0
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_use_current_location_confirm:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 164
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2$1;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;)V

    .line 179
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 180
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 182
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto :goto_0
.end method
