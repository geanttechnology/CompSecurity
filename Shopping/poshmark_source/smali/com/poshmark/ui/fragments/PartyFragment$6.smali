.class Lcom/poshmark/ui/fragments/PartyFragment$6;
.super Ljava/lang/Object;
.source "PartyFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyFragment;->loadFilterResults(Z)V
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
        "Lcom/poshmark/data_model/models/SearchResults;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyFragment;)V
    .locals 0

    .prologue
    .line 294
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$6;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

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
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    const/4 v1, 0x0

    .line 297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$6;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PartyFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$6;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # invokes: Lcom/poshmark/ui/fragments/PartyFragment;->handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->access$200(Lcom/poshmark/ui/fragments/PartyFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 299
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$6;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PartyFragment;->hideFilterButtonsForSingleFacet()V

    .line 300
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$6;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/PartyFragment;->access$300(Lcom/poshmark/ui/fragments/PartyFragment;)Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 302
    :cond_0
    return-void
.end method
