.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$2$1;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2$1;->this$1:Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 169
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 171
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "allowUseUserCurrentlocation"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 172
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2$1;->this$1:Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;

    iget-object v0, v0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 173
    :cond_1
    const/4 v0, -0x2

    if-ne p2, v0, :cond_0

    goto :goto_0
.end method
