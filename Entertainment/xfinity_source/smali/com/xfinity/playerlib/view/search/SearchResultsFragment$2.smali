.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$2;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
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
    .line 239
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$2;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$2;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->performSearchIfReady()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    .line 251
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 242
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 246
    return-void
.end method
