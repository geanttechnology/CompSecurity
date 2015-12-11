.class Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;
.super Ljava/lang/Object;
.source "HalHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->fetchMicroData(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

.field final synthetic val$halSource:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;->this$0:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;->val$halSource:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;
    .locals 3

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient.1;"
    new-instance v0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;->this$0:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    # getter for: Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->access$000(Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/microdata/client/HypermediaClient;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;->val$halSource:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;-><init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;->get()Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;

    move-result-object v0

    return-object v0
.end method
