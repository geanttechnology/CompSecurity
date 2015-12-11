.class Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;
.super Ljava/lang/Object;
.source "VideoAuthTokenClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/VideoAuthToken;
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
        "Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;

    .prologue
    .line 49
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;->this$0:Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;
    .locals 1

    .prologue
    .line 52
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;

    invoke-direct {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;->get()Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;

    move-result-object v0

    return-object v0
.end method
