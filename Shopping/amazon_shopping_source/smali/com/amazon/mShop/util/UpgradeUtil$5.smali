.class final Lcom/amazon/mShop/util/UpgradeUtil$5;
.super Ljava/lang/Object;
.source "UpgradeUtil.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UpgradeUtil;->showUpgradeNotificationDialog(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field final synthetic val$store:Lcom/amazon/rio/j2me/client/persistence/DataStore;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonAlertDialog;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/amazon/mShop/util/UpgradeUtil$5;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    iput-object p2, p0, Lcom/amazon/mShop/util/UpgradeUtil$5;->val$store:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/util/UpgradeUtil$5;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 185
    const-string/jumbo v0, "up_no_thanks"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 186
    iget-object v0, p0, Lcom/amazon/mShop/util/UpgradeUtil$5;->val$store:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    const-string/jumbo v1, "upgradeShouldShowDialog"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 187
    return-void
.end method
