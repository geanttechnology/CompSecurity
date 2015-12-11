.class Lcom/poshmark/ui/fragments/ShowroomFragment$5;
.super Ljava/lang/Object;
.source "ShowroomFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShowroomFragment;->loadFilterResults(Z)V
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
        "Lcom/poshmark/data_model/models/ShowroomListings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

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
            "Lcom/poshmark/data_model/models/ShowroomListings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ShowroomListings;>;"
    const/4 v1, 0x0

    .line 335
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 336
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShowroomFragment;->handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$400(Lcom/poshmark/ui/fragments/ShowroomFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 337
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->hideFilterButtonsForSingleFacet()V

    .line 338
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$5;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    # getter for: Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidgetLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$500(Lcom/poshmark/ui/fragments/ShowroomFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 340
    :cond_0
    return-void
.end method
