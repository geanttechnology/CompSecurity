.class public Lcom/amazon/identity/auth/device/api/AuthenticatedHttpHead;
.super Lorg/apache/http/client/methods/HttpHead;
.source "AuthenticatedHttpHead.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;


# instance fields
.field private final mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 19
    invoke-direct {p0}, Lorg/apache/http/client/methods/HttpHead;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpHead;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 21
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lorg/apache/http/client/methods/HttpHead;-><init>(Ljava/lang/String;)V

    .line 32
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpHead;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 33
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lorg/apache/http/client/methods/HttpHead;-><init>(Ljava/net/URI;)V

    .line 26
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpHead;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 27
    return-void
.end method


# virtual methods
.method public getAuthenticationMethod()Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpHead;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    return-object v0
.end method
