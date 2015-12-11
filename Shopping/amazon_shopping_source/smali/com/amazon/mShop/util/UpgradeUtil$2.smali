.class final Lcom/amazon/mShop/util/UpgradeUtil$2;
.super Ljava/lang/Object;
.source "UpgradeUtil.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UpgradeUtil;->showForceUpdateDialog(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/mShop/util/UpgradeUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/util/UpgradeUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 106
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->goToUpgradePage()V

    .line 107
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->exitApp()V

    .line 108
    return-void
.end method
