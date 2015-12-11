.class Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;
.super Ljava/lang/Object;
.source "HttpRequestWrapperFactory.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DummyAuthenticatedHttpRequest"
.end annotation


# instance fields
.field private final mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 29
    return-void
.end method


# virtual methods
.method public getAuthenticationMethod()Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    return-object v0
.end method
