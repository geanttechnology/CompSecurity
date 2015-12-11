.class Lcom/comcast/cim/model/ParentalControlsCache$1;
.super Ljava/lang/Object;
.source "ParentalControlsCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/model/ParentalControlsCache;->fetchResourceWithNoCache()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
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
        "Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/model/ParentalControlsCache;


# direct methods
.method constructor <init>(Lcom/comcast/cim/model/ParentalControlsCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/model/ParentalControlsCache;

    .prologue
    .line 56
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache$1;, "Lcom/comcast/cim/model/ParentalControlsCache$1;"
    iput-object p1, p0, Lcom/comcast/cim/model/ParentalControlsCache$1;->this$0:Lcom/comcast/cim/model/ParentalControlsCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;
    .locals 2

    .prologue
    .line 58
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache$1;, "Lcom/comcast/cim/model/ParentalControlsCache$1;"
    new-instance v0, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;

    iget-object v1, p0, Lcom/comcast/cim/model/ParentalControlsCache$1;->this$0:Lcom/comcast/cim/model/ParentalControlsCache;

    # getter for: Lcom/comcast/cim/model/ParentalControlsCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/comcast/cim/model/ParentalControlsCache;->access$000(Lcom/comcast/cim/model/ParentalControlsCache;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 56
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache$1;, "Lcom/comcast/cim/model/ParentalControlsCache$1;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/ParentalControlsCache$1;->get()Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;

    move-result-object v0

    return-object v0
.end method
