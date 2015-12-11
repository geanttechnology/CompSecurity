.class Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;
.super Ljava/lang/Object;
.source "RegisterDeviceClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->registerDevice(Lcom/comcast/cim/model/user/XipUser;)Lcom/xfinity/playerlib/downloads/DeviceRegistration;
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
        "Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    .prologue
    .line 45
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;->this$0:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;
    .locals 2

    .prologue
    .line 48
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;->this$0:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    # getter for: Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->access$000(Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 45
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;, "Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;->get()Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;

    move-result-object v0

    return-object v0
.end method
