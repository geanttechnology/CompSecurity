.class Lcom/poshmark/ui/fragments/UserListFragment$8;
.super Ljava/lang/Object;
.source "UserListFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserListFragment;->fetchNewlyJoinedClosets()V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserListFragment;)V
    .locals 0

    .prologue
    .line 342
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserListFragment$8;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

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
    .line 345
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment$8;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/UserListFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/UserListFragment;->access$000(Lcom/poshmark/ui/fragments/UserListFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 346
    return-void
.end method
