.class Lcom/amazon/mShop/gno/GNODrawer$1;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawer;-><init>(Lcom/amazon/mShop/AmazonActivity;)V
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
    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawer$1;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer$1;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # getter for: Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawer;->access$100(Lcom/amazon/mShop/gno/GNODrawer;)Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->onNavDrawerClosed()V

    .line 79
    return-void
.end method

.method public onDrawerOpened(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer$1;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # getter for: Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawer;->access$100(Lcom/amazon/mShop/gno/GNODrawer;)Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->onNavDrawerOpened()V

    .line 74
    return-void
.end method

.method public onDrawerSlide(Lcom/amazon/mShop/gno/GNODrawer;F)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;
    .param p2, "slideOffset"    # F

    .prologue
    .line 69
    return-void
.end method
