.class Lcom/comcast/cim/android/authentication/AuthenticationClient$1;
.super Ljava/lang/Object;
.source "AuthenticationClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationClient;->authenticate(Lcom/comcast/cim/android/authentication/UserCredentials;)Lcom/comcast/cim/model/user/AuthKeys;
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
        "Lcom/comcast/cim/android/authentication/AuthResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationClient;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationClient;

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationClient$1;, "Lcom/comcast/cim/android/authentication/AuthenticationClient$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient$1;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/authentication/AuthResponseHandler;
    .locals 2

    .prologue
    .line 49
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationClient$1;, "Lcom/comcast/cim/android/authentication/AuthenticationClient$1;"
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient$1;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    # getter for: Lcom/comcast/cim/android/authentication/AuthenticationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {v1}, Lcom/comcast/cim/android/authentication/AuthenticationClient;->access$000(Lcom/comcast/cim/android/authentication/AuthenticationClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/authentication/AuthResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationClient$1;, "Lcom/comcast/cim/android/authentication/AuthenticationClient$1;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationClient$1;->get()Lcom/comcast/cim/android/authentication/AuthResponseHandler;

    move-result-object v0

    return-object v0
.end method
