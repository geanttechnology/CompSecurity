.class Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;
.super Ljava/lang/Object;
.source "UnregisterDeviceClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->unregisterDevice(Lcom/comcast/cim/model/user/AuthKeys;Ljava/lang/String;)V
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
        "Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    .prologue
    .line 34
    .local p0, "this":Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;->this$0:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;
    .locals 2

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;->this$0:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    # getter for: Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->access$000(Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;->get()Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;

    move-result-object v0

    return-object v0
.end method
