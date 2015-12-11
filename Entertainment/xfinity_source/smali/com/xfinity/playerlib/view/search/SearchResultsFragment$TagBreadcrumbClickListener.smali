.class abstract Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "TagBreadcrumbClickListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0

    .prologue
    .line 809
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;

    .prologue
    .line 809
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    return-void
.end method


# virtual methods
.method protected abstract onBreadcrumbClicked()V
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 811
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;->onBreadcrumbClicked()V

    .line 812
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 813
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->performSearchIfReady()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    .line 814
    return-void
.end method
