.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DrawerToggler"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)V
    .locals 0

    .prologue
    .line 1045
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;
    .param p2, "x1"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$1;

    .prologue
    .line 1045
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1047
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLocked:Z
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1059
    :goto_0
    return-void

    .line 1054
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimateOnClick:Z
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1055
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateToggle()V

    goto :goto_0

    .line 1057
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->toggle()V

    goto :goto_0
.end method
