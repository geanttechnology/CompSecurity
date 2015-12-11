.class Lcom/poshmark/ui/fragments/ClosetFragment$1;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;->setupClosetList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$1;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 189
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment$1;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # invokes: Lcom/poshmark/ui/fragments/ClosetFragment;->getUserCloset(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$000(Lcom/poshmark/ui/fragments/ClosetFragment;Z)V

    .line 190
    return-void
.end method
