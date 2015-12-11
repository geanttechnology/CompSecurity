.class public Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
.super Ljava/lang/Object;
.source "PandaAuthenticateAccountResponse.java"


# instance fields
.field private final mAccessToken:Ljava/lang/String;

.field private final mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

.field private final mDirectedId:Ljava/lang/String;

.field private final mError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0, v0, v0, v0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    .line 25
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)V
    .locals 2
    .param p1, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    .prologue
    const/4 v1, 0x0

    .line 34
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-direct {p0, v1, v1, p1, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/PandaError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 19
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->fromPandaError(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "accessToken"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0, p1, p2, v0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    .line 30
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V
    .locals 0
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "accessToken"    # Ljava/lang/String;
    .param p3, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .param p4, "error"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mDirectedId:Ljava/lang/String;

    .line 43
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mAccessToken:Ljava/lang/String;

    .line 44
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    .line 45
    iput-object p4, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 46
    return-void
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mAccessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getChallenge()Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method public getError()Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    if-eqz v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "[PandaAuthenticateAccountResponse Error: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 77
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "[PandaAuthenticateAccountResponse Success: DirectedId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
