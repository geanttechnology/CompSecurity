.class public Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
.super Ljava/lang/Object;
.source "AuthenticateAccountAction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticatedAccountInfo"
.end annotation


# instance fields
.field public final accessToken:Ljava/lang/String;

.field public final challenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

.field public final directedId:Ljava/lang/String;

.field public final error:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    .locals 1
    .param p1, "givenError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    const/4 v0, 0x0

    .line 52
    invoke-direct {p0, v0, v0, v0, p1}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    .line 53
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    .locals 1
    .param p1, "givenChallenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .param p2, "givenError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0, v0, v0, p1, p2}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    .line 59
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "givenAccessToken"    # Ljava/lang/String;
    .param p2, "givenDirectedId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 47
    invoke-direct {p0, p1, p2, v0, v0}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    .line 48
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    .locals 0
    .param p1, "givenAccessToken"    # Ljava/lang/String;
    .param p2, "givenDirectedId"    # Ljava/lang/String;
    .param p3, "givenChallenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .param p4, "givenError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->accessToken:Ljava/lang/String;

    .line 67
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->directedId:Ljava/lang/String;

    .line 68
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->challenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    .line 69
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->error:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .line 70
    return-void
.end method


# virtual methods
.method public isError()Z
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->error:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
