.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$7;
.super Landroid/view/View$AccessibilityDelegate;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showResults(Ljava/util/List;)V
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
    .line 499
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$7;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Landroid/view/View$AccessibilityDelegate;-><init>()V

    return-void
.end method


# virtual methods
.method public performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "action"    # I
    .param p3, "args"    # Landroid/os/Bundle;

    .prologue
    .line 502
    invoke-super {p0, p1, p2, p3}, Landroid/view/View$AccessibilityDelegate;->performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method
