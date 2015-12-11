.class Lcom/comcast/cim/container/CALContainer$1;
.super Ljava/lang/Object;
.source "CALContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/CALContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
        "<",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/CALContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/CALContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/CALContainer;

    .prologue
    .line 218
    iput-object p1, p0, Lcom/comcast/cim/container/CALContainer$1;->this$0:Lcom/comcast/cim/container/CALContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 221
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;

    invoke-direct {v0, p1}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 226
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
