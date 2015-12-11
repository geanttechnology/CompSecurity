.class public Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
.super Ljava/lang/Object;
.source "AuthEndpointErrorParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthEndpointError"
.end annotation


# instance fields
.field private final mAuthErrorType:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field private final mDetail:Ljava/lang/String;

.field private final mMessage:Ljava/lang/String;

.field private final mRequestId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "authErrorType"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "detail"    # Ljava/lang/String;
    .param p4, "requestId"    # Ljava/lang/String;

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mAuthErrorType:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 93
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mMessage:Ljava/lang/String;

    .line 94
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mDetail:Ljava/lang/String;

    .line 95
    iput-object p4, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mRequestId:Ljava/lang/String;

    .line 96
    return-void
.end method


# virtual methods
.method public getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mAuthErrorType:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    return-object v0
.end method

.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mDetail:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getRegistrationError()Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mAuthErrorType:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getRegistrationError()Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v0

    return-object v0
.end method

.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public shouldRetry()Z
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->mAuthErrorType:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getRetry()Z

    move-result v0

    return v0
.end method
