.class Lcom/poshmark/utils/ListingManager$2;
.super Ljava/lang/Object;
.source "ListingManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ListingManager;->postNewListingNextImage()V
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
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ListingManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ListingManager;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 179
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v0, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v0, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 181
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 182
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    iget v1, v0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    .line 183
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    # invokes: Lcom/poshmark/utils/ListingManager;->resumeUpload()V
    invoke-static {v0}, Lcom/poshmark/utils/ListingManager;->access$000(Lcom/poshmark/utils/ListingManager;)V

    .line 189
    :cond_0
    :goto_0
    return-void

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager$2;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    # invokes: Lcom/poshmark/utils/ListingManager;->getRetryMessageForError(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/poshmark/utils/ListingManager;->access$100(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/poshmark/utils/ListingManager;->presentRetryAlert(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/poshmark/utils/ListingManager;->access$200(Lcom/poshmark/utils/ListingManager;Ljava/lang/String;)V

    goto :goto_0
.end method
