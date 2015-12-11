.class Lcom/amazon/mShop/gno/GNOMenuItemController$4;
.super Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
.source "GNOMenuItemController.java"


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

.field final synthetic val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/navigation/AppNavigator$Target;)V
    .locals 1

    .prologue
    .line 382
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$4;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$4;->val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOMenuItemController$1;)V

    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 386
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$4;->val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-static {p1, v0}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;)V

    .line 387
    return-void
.end method
