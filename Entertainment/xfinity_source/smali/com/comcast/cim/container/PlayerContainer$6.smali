.class Lcom/comcast/cim/container/PlayerContainer$6;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
        "<",
        "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 802
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$6;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "secret"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 805
    new-instance v0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/http/signing/OAuthRequestSigner;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
