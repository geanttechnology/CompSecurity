.class Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;
.super Ljava/lang/Object;
.source "ThePlatformClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/authorization/ThePlatformClient;->getSMILResource(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;
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
        "Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/authorization/ThePlatformClient;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/authorization/ThePlatformClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    .prologue
    .line 23
    .local p0, "this":Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;, "Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;->this$0:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;
    .locals 1

    .prologue
    .line 26
    .local p0, "this":Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;, "Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;

    invoke-direct {v0}, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;, "Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;->get()Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;

    move-result-object v0

    return-object v0
.end method
