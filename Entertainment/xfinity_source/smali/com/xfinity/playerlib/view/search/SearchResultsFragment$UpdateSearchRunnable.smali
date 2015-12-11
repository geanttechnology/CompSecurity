.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UpdateSearchRunnable"
.end annotation


# instance fields
.field final searchTerms:Ljava/lang/String;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "searchTerms"    # Ljava/lang/String;

    .prologue
    .line 925
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 926
    iput-object p2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;->searchTerms:Ljava/lang/String;

    .line 927
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 931
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;->searchTerms:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 932
    return-void
.end method
