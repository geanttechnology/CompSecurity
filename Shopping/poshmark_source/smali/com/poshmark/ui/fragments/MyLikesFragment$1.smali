.class Lcom/poshmark/ui/fragments/MyLikesFragment$1;
.super Ljava/lang/Object;
.source "MyLikesFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$1;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 2
    .param p1, "isPagination"    # Z

    .prologue
    .line 130
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$1;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyLikes(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->access$000(Lcom/poshmark/ui/fragments/MyLikesFragment;Z)V

    .line 131
    return-void
.end method
