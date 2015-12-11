.class final Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient$1;
.super Ljava/lang/Object;
.source "ServiceClient.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;


# direct methods
.method constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient$1;->val$webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient$1;->val$webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    return-object v0
.end method
