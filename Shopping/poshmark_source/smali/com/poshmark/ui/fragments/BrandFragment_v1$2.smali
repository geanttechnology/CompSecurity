.class Lcom/poshmark/ui/fragments/BrandFragment_v1$2;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupHeader()V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

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
    .line 163
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Brand;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 165
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    # setter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$102(Lcom/poshmark/ui/fragments/BrandFragment_v1;Lcom/poshmark/data_model/models/Brand;)Lcom/poshmark/data_model/models/Brand;

    .line 166
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$100(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    # setter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$202(Lcom/poshmark/ui/fragments/BrandFragment_v1;Ljava/lang/String;)Ljava/lang/String;

    .line 167
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandUnknown:Z

    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment_v1;->handleBrandShareTrigger()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$300(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    .line 172
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment_v1;->populateHeaderViews()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$400(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    .line 174
    :cond_0
    return-void

    .line 170
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandUnknown:Z

    goto :goto_0
.end method
