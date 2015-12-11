.class Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;
.super Ljava/lang/Object;
.source "ActionBarViewV2.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/actionBar/ActionBarViewV2;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$1;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->toggle()V

    .line 76
    const-string/jumbo v0, "gno_buger"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 77
    return-void
.end method
