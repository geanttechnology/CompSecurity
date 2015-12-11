.class Lcom/poshmark/ui/fragments/NewFeedFragment$1;
.super Ljava/lang/Object;
.source "NewFeedFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/NewFeedFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$1;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 2
    .param p1, "isPagination"    # Z

    .prologue
    .line 84
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$1;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->access$000(Lcom/poshmark/ui/fragments/NewFeedFragment;Z)V

    .line 85
    return-void
.end method
