.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$3;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->performSearchIfReady()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 288
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$3;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 290
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$3;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showNoResults()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$200(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    .line 291
    return-void
.end method
