.class Lcom/poshmark/ui/fragments/UserListFragment$7;
.super Ljava/lang/Object;
.source "UserListFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserListFragment;->setupListView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserListFragment;)V
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserListFragment$7;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 3
    .param p1, "isPagination"    # Z

    .prologue
    .line 286
    if-eqz p1, :cond_0

    .line 287
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment$7;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    # getter for: Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/UserListFragment;->access$100(Lcom/poshmark/ui/fragments/UserListFragment;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment$7;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/UserReferenceList;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/UserListFragment$7$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserListFragment$7$1;-><init>(Lcom/poshmark/ui/fragments/UserListFragment$7;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getDiscoveredClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 294
    :cond_0
    return-void
.end method
