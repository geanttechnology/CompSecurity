.class Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$1;
.super Ljava/lang/Object;
.source "HttpClientProvider.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/TrustStrategy;


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
    .line 65
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$1;->this$0:Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)Z
    .locals 1
    .param p1, "chain"    # [Ljava/security/cert/X509Certificate;
    .param p2, "authType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/cert/CertificateException;
        }
    .end annotation

    .prologue
    .line 67
    const/4 v0, 0x1

    return v0
.end method
