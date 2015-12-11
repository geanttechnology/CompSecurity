.class Lcom/poshmark/ui/fragments/UserSharesFragment$2;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;->setupClosetList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$2;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 181
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$2;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # invokes: Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserShares(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$200(Lcom/poshmark/ui/fragments/UserSharesFragment;Z)V

    .line 182
    return-void
.end method
