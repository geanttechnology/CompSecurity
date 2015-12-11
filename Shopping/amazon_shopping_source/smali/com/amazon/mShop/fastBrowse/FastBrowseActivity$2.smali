.class Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;
.super Ljava/lang/Object;
.source "FastBrowseActivity.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->initLayout()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # getter for: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
    invoke-static {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$300(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->isListRoot()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 219
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # getter for: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
    invoke-static {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$300(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->openAndLockRightMenu()V

    .line 222
    :cond_0
    return-void
.end method

.method public onDrawerOpened(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    # getter for: Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
    invoke-static {v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->access$300(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->unlockAndCloseRightMenu()V

    .line 213
    return-void
.end method

.method public onDrawerSlide(Lcom/amazon/mShop/gno/GNODrawer;F)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;
    .param p2, "slideOffset"    # F

    .prologue
    .line 208
    return-void
.end method
