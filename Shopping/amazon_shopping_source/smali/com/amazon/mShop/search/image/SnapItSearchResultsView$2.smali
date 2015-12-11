.class Lcom/amazon/mShop/search/image/SnapItSearchResultsView$2;
.super Ljava/lang/Object;
.source "SnapItSearchResultsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getMismatchFooter()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$2;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 324
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$2;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->reportMismatch()V

    .line 325
    return-void
.end method
