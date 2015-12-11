.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->setIconListner()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V
    .locals 0

    .prologue
    .line 454
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 458
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->isRightMenuUnLock()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 459
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 460
    :cond_0
    return-void
.end method
