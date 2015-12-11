.class Lcom/poshmark/ui/fragments/UserListFragment$7$1;
.super Ljava/lang/Object;
.source "UserListFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserListFragment$7;->loadItems(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/UserReferenceList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/UserListFragment$7;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserListFragment$7;)V
    .locals 0

    .prologue
    .line 287
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserListFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/UserListFragment$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 290
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/UserListFragment$7;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/UserListFragment$7;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/UserListFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/UserListFragment;->access$000(Lcom/poshmark/ui/fragments/UserListFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 291
    return-void
.end method
