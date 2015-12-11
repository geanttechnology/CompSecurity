.class Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;
.super Ljava/lang/Object;
.source "UnavailableBundleItemsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->removeItemFromBundle(I)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;I)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iput p2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
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
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/4 v4, 0x1

    .line 143
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->hideProgressDialog()V

    .line 144
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 145
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    iget v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 146
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    sget-object v2, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v2, v1, v4

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 147
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    # invokes: Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->access$000(Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 148
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 149
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->notifyDataSetChanged()V

    .line 150
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;->this$0:Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iput-boolean v4, v1, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->countChanged:Z

    .line 152
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method
