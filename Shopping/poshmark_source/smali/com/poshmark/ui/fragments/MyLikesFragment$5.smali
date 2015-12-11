.class Lcom/poshmark/ui/fragments/MyLikesFragment$5;
.super Ljava/lang/Object;
.source "MyLikesFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyLikes(Z)V
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
        "Lcom/poshmark/data_model/models/MyLikes;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V
    .locals 0

    .prologue
    .line 344
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$5;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

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
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/MyLikes;>;"
    const/4 v1, 0x0

    .line 347
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$5;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 348
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$5;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    # invokes: Lcom/poshmark/ui/fragments/MyLikesFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->access$200(Lcom/poshmark/ui/fragments/MyLikesFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 349
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$5;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MyLikesFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    if-eqz v0, :cond_0

    .line 350
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$5;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MyLikesFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setVisibility(I)V

    .line 353
    :cond_0
    return-void
.end method
