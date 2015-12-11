.class abstract Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;
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
    name = "TagCalloutClickListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/xfinity/playerlib/model/tags/Tag;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/view/View$OnClickListener;"
    }
.end annotation


# instance fields
.field private final tagMatch:Lcom/xfinity/playerlib/model/tags/Tag;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 778
    .local p0, "this":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<TT;>;"
    .local p2, "tagMatch":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 779
    iput-object p2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->tagMatch:Lcom/xfinity/playerlib/model/tags/Tag;

    .line 780
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 784
    .local p0, "this":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<TT;>;"
    iget-object v7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->tagMatch:Lcom/xfinity/playerlib/model/tags/Tag;

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->onTagSelected(Lcom/xfinity/playerlib/model/tags/Tag;)V

    .line 786
    iget-object v7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->tagMatch:Lcom/xfinity/playerlib/model/tags/Tag;

    invoke-interface {v7}, Lcom/xfinity/playerlib/model/tags/Tag;->getName()Ljava/lang/String;

    move-result-object v5

    .line 787
    .local v5, "tagName":Ljava/lang/String;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v2

    .line 788
    .local v2, "searchEditable":Landroid/text/Editable;
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 791
    .local v3, "searchQuery":Ljava/lang/String;
    invoke-static {v3, v5}, Lorg/apache/commons/lang3/StringUtils;->indexOfIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I

    move-result v4

    .line 792
    .local v4, "start":I
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v7

    add-int v0, v4, v7

    .line 793
    .local v0, "end":I
    invoke-virtual {v3, v4, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 796
    .local v1, "matchedSubstring":Ljava/lang/String;
    const-string v7, ""

    invoke-virtual {v3, v1, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lorg/apache/commons/lang3/StringUtils;->normalizeSpace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 799
    .local v6, "updatedQuery":Ljava/lang/String;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/view/View;

    move-result-object v7

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    .line 800
    const/4 v7, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    invoke-interface {v2, v7, v8, v6}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 801
    iget-object v7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/EditText;->setSelection(I)V

    .line 803
    return-void
.end method

.method protected abstract onTagSelected(Lcom/xfinity/playerlib/model/tags/Tag;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method
