.class Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Landroid/support/v4/widget/DrawerLayout$DrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DrawerListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawer;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/gno/GNODrawer;Lcom/amazon/mShop/gno/GNODrawer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/gno/GNODrawer;
    .param p2, "x1"    # Lcom/amazon/mShop/gno/GNODrawer$1;

    .prologue
    .line 407
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;-><init>(Lcom/amazon/mShop/gno/GNODrawer;)V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 417
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # invokes: Lcom/amazon/mShop/gno/GNODrawer;->getListenersCopy()Ljava/util/Set;
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawer;->access$300(Lcom/amazon/mShop/gno/GNODrawer;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .line 418
    .local v1, "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;->onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V

    goto :goto_0

    .line 420
    .end local v1    # "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    :cond_0
    return-void
.end method

.method public onDrawerOpened(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 424
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # invokes: Lcom/amazon/mShop/gno/GNODrawer;->getListenersCopy()Ljava/util/Set;
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawer;->access$300(Lcom/amazon/mShop/gno/GNODrawer;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .line 425
    .local v1, "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;->onDrawerOpened(Lcom/amazon/mShop/gno/GNODrawer;)V

    goto :goto_0

    .line 427
    .end local v1    # "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    :cond_0
    return-void
.end method

.method public onDrawerSlide(Landroid/view/View;F)V
    .locals 3
    .param p1, "drawerView"    # Landroid/view/View;
    .param p2, "slideOffset"    # F

    .prologue
    .line 410
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # invokes: Lcom/amazon/mShop/gno/GNODrawer;->getListenersCopy()Ljava/util/Set;
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawer;->access$300(Lcom/amazon/mShop/gno/GNODrawer;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .line 411
    .local v1, "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v1, v2, p2}, Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;->onDrawerSlide(Lcom/amazon/mShop/gno/GNODrawer;F)V

    goto :goto_0

    .line 413
    .end local v1    # "listener":Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;
    :cond_0
    return-void
.end method

.method public onDrawerStateChanged(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 431
    packed-switch p1, :pswitch_data_0

    .line 445
    :cond_0
    :goto_0
    return-void

    .line 437
    :pswitch_0
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 438
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz v0, :cond_0

    .line 439
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    goto :goto_0

    .line 431
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
