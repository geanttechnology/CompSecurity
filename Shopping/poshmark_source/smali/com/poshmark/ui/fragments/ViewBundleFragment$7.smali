.class Lcom/poshmark/ui/fragments/ViewBundleFragment$7;
.super Ljava/lang/Object;
.source "ViewBundleFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ViewBundleFragment;->removeItemFromBundle(I)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

.field final synthetic val$bundleItems:Ljava/util/List;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;Ljava/util/List;I)V
    .locals 0

    .prologue
    .line 337
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->val$bundleItems:Ljava/util/List;

    iput p3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
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
    .line 340
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->hideProgressDialog()V

    .line 341
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 342
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->val$bundleItems:Ljava/util/List;

    iget v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 343
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 344
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/PMBundle;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 345
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 346
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->notifyDataSetChanged()V

    .line 348
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    # invokes: Lcom/poshmark/ui/fragments/ViewBundleFragment;->fetchBundleData()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->access$100(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    .line 350
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method
