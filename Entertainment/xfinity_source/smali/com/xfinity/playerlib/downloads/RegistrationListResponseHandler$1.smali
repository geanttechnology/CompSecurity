.class Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler$1;
.super Lcom/fasterxml/jackson/core/type/TypeReference;
.source "RegistrationListResponseHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/core/type/TypeReference",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler$1;->this$0:Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/type/TypeReference;-><init>()V

    return-void
.end method
