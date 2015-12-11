.class Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;
.super Ljava/lang/Object;
.source "VideoEntitlementCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
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
        "Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;

    .prologue
    .line 55
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;->this$0:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;
    .locals 2

    .prologue
    .line 58
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;"
    new-instance v0, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;->this$0:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;

    # getter for: Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->access$000(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;->get()Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;

    move-result-object v0

    return-object v0
.end method
