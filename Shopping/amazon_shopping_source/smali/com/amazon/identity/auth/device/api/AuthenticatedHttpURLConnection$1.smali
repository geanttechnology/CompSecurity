.class Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection$1;
.super Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;
.source "AuthenticatedHttpURLConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->performOnConnectionRequested()Ljava/net/HttpURLConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter",
        "<",
        "Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection$1;->this$0:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;-><init>(Ljava/net/HttpURLConnection;)V

    return-void
.end method


# virtual methods
.method public getBody()[B
    .locals 1

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection$1;->getUrlConnection()Ljava/net/HttpURLConnection;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getCurrentBody()[B

    move-result-object v0

    return-object v0
.end method
