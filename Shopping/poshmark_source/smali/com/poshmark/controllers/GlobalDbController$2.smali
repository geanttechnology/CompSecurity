.class Lcom/poshmark/controllers/GlobalDbController$2;
.super Ljava/lang/Object;
.source "GlobalDbController.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/controllers/GlobalDbController;->reloadAllBrands()V
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
        "Lcom/poshmark/db/AllBrandsModel;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/GlobalDbController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/GlobalDbController;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/poshmark/controllers/GlobalDbController$2;->this$0:Lcom/poshmark/controllers/GlobalDbController;

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
            "Lcom/poshmark/db/AllBrandsModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 165
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/db/AllBrandsModel;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 166
    new-instance v0, Lcom/poshmark/db/AllBrandsUpdater;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/db/AllBrandsModel;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/poshmark/db/AllBrandsUpdater;-><init>(Lcom/poshmark/db/AllBrandsModel;Z)V

    .line 167
    .local v0, "updater":Lcom/poshmark/db/AllBrandsUpdater;
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    instance-of v2, v0, Landroid/os/AsyncTask;

    if-nez v2, :cond_1

    invoke-virtual {v0, v1}, Lcom/poshmark/db/AllBrandsUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 169
    .end local v0    # "updater":Lcom/poshmark/db/AllBrandsUpdater;
    :cond_0
    :goto_0
    return-void

    .line 167
    .restart local v0    # "updater":Lcom/poshmark/db/AllBrandsUpdater;
    :cond_1
    check-cast v0, Landroid/os/AsyncTask;

    .end local v0    # "updater":Lcom/poshmark/db/AllBrandsUpdater;
    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
