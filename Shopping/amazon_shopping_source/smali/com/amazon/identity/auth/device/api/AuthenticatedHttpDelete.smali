.class public Lcom/amazon/identity/auth/device/api/AuthenticatedHttpDelete;
.super Lorg/apache/http/client/methods/HttpDelete;
.source "AuthenticatedHttpDelete.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;


# instance fields
.field private final mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 23
    invoke-direct {p0}, Lorg/apache/http/client/methods/HttpDelete;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpDelete;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    .line 48
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpDelete;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/net/URI;)V

    .line 36
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpDelete;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 37
    return-void
.end method


# virtual methods
.method public getAuthenticationMethod()Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpDelete;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    return-object v0
.end method
