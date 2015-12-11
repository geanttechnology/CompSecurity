.class Lcom/amazon/mShop/gno/GNOMenuItemController$5;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController;->buildGNODrawerItem(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;)Lcom/amazon/mShop/gno/GNODrawerItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

.field final synthetic val$onClickRunnable:Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;)V
    .locals 0

    .prologue
    .line 449
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$5;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$5;->val$onClickRunnable:Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 452
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$5;->val$onClickRunnable:Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;->run(Lcom/amazon/mShop/AmazonActivity;)V

    .line 453
    return-void
.end method
