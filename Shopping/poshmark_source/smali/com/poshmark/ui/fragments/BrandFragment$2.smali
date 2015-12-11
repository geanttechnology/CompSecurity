.class Lcom/poshmark/ui/fragments/BrandFragment$2;
.super Ljava/lang/Object;
.source "BrandFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment;->setupHeader()V
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
        "Lcom/poshmark/data_model/models/Brand;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

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
            "Lcom/poshmark/data_model/models/Brand;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 175
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Brand;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    # setter for: Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->access$102(Lcom/poshmark/ui/fragments/BrandFragment;Lcom/poshmark/data_model/models/Brand;)Lcom/poshmark/data_model/models/Brand;

    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/BrandFragment;->access$100(Lcom/poshmark/ui/fragments/BrandFragment;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    # setter for: Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/BrandFragment;->access$202(Lcom/poshmark/ui/fragments/BrandFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 179
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/BrandFragment;->brandUnknown:Z

    .line 180
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment;->handleBrandShareTrigger()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment;->access$300(Lcom/poshmark/ui/fragments/BrandFragment;)V

    .line 184
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandFragment;->setupActionBar()V

    .line 185
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment;->populateHeaderViews()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment;->access$400(Lcom/poshmark/ui/fragments/BrandFragment;)V

    .line 187
    :cond_0
    return-void

    .line 182
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/BrandFragment;->brandUnknown:Z

    goto :goto_0
.end method
