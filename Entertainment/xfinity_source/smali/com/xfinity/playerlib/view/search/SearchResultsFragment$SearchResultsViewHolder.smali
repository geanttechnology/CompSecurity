.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SearchResultsViewHolder"
.end annotation


# instance fields
.field private title:Landroid/widget/TextView;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 729
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;

    .prologue
    .line 729
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;-><init>()V

    return-void
.end method

.method static synthetic access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;

    .prologue
    .line 729
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$2402(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;Landroid/widget/TextView;)Landroid/widget/TextView;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
    .param p1, "x1"    # Landroid/widget/TextView;

    .prologue
    .line 729
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;

    return-object p1
.end method
