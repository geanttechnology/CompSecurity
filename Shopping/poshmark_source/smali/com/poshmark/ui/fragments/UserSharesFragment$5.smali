.class Lcom/poshmark/ui/fragments/UserSharesFragment$5;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserShares(Z)V
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
        "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$5;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

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
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 231
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$5;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 232
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$5;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/UserSharesFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$400(Lcom/poshmark/ui/fragments/UserSharesFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 234
    :cond_0
    return-void
.end method
