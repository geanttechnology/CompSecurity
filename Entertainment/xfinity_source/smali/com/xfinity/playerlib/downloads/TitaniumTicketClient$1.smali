.class Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;
.super Ljava/lang/Object;
.source "TitaniumTicketClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->getTitaniumTicket(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;
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
        "Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .prologue
    .line 56
    .local p0, "this":Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;, "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;->this$0:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;
    .locals 2

    .prologue
    .line 59
    .local p0, "this":Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;, "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;->this$0:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    # getter for: Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->access$000(Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 56
    .local p0, "this":Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;, "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;->get()Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;

    move-result-object v0

    return-object v0
.end method
