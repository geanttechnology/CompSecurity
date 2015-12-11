.class Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;
.super Ljava/lang/Object;
.source "VideoAuthorizationClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/xfinity/playerlib/authorization/VideoAuthorization;
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
        "Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;

    .prologue
    .line 63
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;->this$0:Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;
    .locals 2

    .prologue
    .line 66
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;->this$0:Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;

    # getter for: Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->access$000(Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 63
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;->get()Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;

    move-result-object v0

    return-object v0
.end method
