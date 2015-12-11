.class Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;
.super Ljava/lang/Object;
.source "RetryingHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;

.field final synthetic val$request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;->this$0:Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;->val$request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public executeRequest()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;->this$0:Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;

    # getter for: Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->delegate:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->access$000(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;->val$request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method
