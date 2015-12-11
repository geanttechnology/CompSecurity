.class Lcom/amazon/mShop/gno/GNODrawerItemSBD$1;
.super Ljava/lang/Object;
.source "GNODrawerItemSBD.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSBD;-><init>(Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemSBD;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSBD;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSBD$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 29
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->shop_by_department:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 30
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    .line 31
    return-void
.end method
