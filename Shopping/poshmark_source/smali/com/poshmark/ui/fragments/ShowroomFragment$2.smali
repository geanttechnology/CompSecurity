.class Lcom/poshmark/ui/fragments/ShowroomFragment$2;
.super Ljava/lang/Object;
.source "ShowroomFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShowroomFragment;->setupListView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$2;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 257
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$2;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShowroomFragment;->getShowroomListings(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$100(Lcom/poshmark/ui/fragments/ShowroomFragment;Z)V

    .line 258
    return-void
.end method
