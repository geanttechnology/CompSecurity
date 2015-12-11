.class Lcom/amazon/mShop/home/HomeView$5;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->updateYourAccountButton(Lcom/amazon/mShop/model/auth/User;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;)V
    .locals 0

    .prologue
    .line 593
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$5;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 597
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$5;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;)Z

    .line 599
    const-string/jumbo v0, "hm_ya"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 600
    return-void
.end method
