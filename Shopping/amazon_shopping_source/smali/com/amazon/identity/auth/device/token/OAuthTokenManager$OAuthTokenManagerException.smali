.class public final Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
.super Ljava/lang/Exception;
.source "OAuthTokenManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/OAuthTokenManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "OAuthTokenManagerException"
.end annotation


# instance fields
.field private mAuthEndpointError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

.field private final mErrorCode:I

.field private final mErrorMsg:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "errorCode"    # I
    .param p2, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 67
    iput p1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorCode:I

    .line 68
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorMsg:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    .locals 0
    .param p1, "errorCode"    # I
    .param p2, "errorMsg"    # Ljava/lang/String;
    .param p3, "authEndpointError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    .line 82
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 83
    iput p1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorCode:I

    .line 84
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorMsg:Ljava/lang/String;

    .line 85
    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mAuthEndpointError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .line 86
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "errorCode"    # I
    .param p2, "errorMsg"    # Ljava/lang/String;
    .param p3, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 73
    invoke-direct {p0, p2, p3}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 74
    iput p1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorCode:I

    .line 75
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorMsg:Ljava/lang/String;

    .line 76
    return-void
.end method


# virtual methods
.method public getAuthEndpointError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mAuthEndpointError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    return-object v0
.end method

.method public getErrorCode()I
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorCode:I

    return v0
.end method

.method public getErrorMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->mErrorMsg:Ljava/lang/String;

    return-object v0
.end method
