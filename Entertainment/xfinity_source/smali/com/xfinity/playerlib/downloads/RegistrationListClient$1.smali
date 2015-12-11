.class Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;
.super Ljava/lang/Object;
.source "RegistrationListClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/RegistrationListClient;->getDeviceRegistrationList(Lcom/comcast/cim/model/user/AuthKeys;)Ljava/util/List;
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
        "Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/RegistrationListClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/RegistrationListClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    .prologue
    .line 41
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;, "Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;->this$0:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;
    .locals 2

    .prologue
    .line 44
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;, "Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;

    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;->this$0:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    # getter for: Lcom/xfinity/playerlib/downloads/RegistrationListClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->access$000(Lcom/xfinity/playerlib/downloads/RegistrationListClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 41
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;, "Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;->get()Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;

    move-result-object v0

    return-object v0
.end method
