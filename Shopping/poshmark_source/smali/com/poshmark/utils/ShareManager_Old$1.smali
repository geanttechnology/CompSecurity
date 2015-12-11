.class Lcom/poshmark/utils/ShareManager_Old$1;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->setBrand(Lcom/poshmark/data_model/models/Brand;)V
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
        "Lcom/poshmark/data_model/models/BrandShareMessageContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$1;->this$0:Lcom/poshmark/utils/ShareManager_Old;

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
            "Lcom/poshmark/data_model/models/BrandShareMessageContainer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 156
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/BrandShareMessageContainer;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$1;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/BrandShareMessageContainer;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/BrandShareMessageContainer;->getBrandShareMessages()Lcom/poshmark/data_model/models/BrandShareMessages;

    move-result-object v0

    # setter for: Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;
    invoke-static {v1, v0}, Lcom/poshmark/utils/ShareManager_Old;->access$102(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/data_model/models/BrandShareMessages;)Lcom/poshmark/data_model/models/BrandShareMessages;

    .line 159
    :cond_0
    return-void
.end method
