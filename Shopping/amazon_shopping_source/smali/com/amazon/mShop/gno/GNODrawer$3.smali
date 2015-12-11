.class Lcom/amazon/mShop/gno/GNODrawer$3;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawer;->buildMenu()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawer$3;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 372
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 374
    .local v0, "callingActivity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz v0, :cond_0

    .line 375
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 376
    .local v1, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawer$3;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v1, v2, v3}, Lcom/amazon/mShop/gno/GNODrawerItem;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 378
    .end local v1    # "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    :cond_0
    return-void
.end method
