.class Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$2;
.super Ljava/lang/Object;
.source "HttpClientProvider.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$2;->this$0:Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$2;->this$0:Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    # getter for: Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->access$000(Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;)Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 96
    return-void
.end method
