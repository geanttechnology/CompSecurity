.class public final Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
.super Ljava/lang/Object;
.source "AuthenticationChallenge.java"


# static fields
.field public static final KEY_AUTHENTICATION_CHALLENGE:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException"

.field public static final KEY_AUTHENTICATION_CHALLENGE_CONTEXT:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException.Context"

.field public static final KEY_AUTHENTICATION_CHALLENGE_OAUTH_URI:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException.oAuthURI"

.field public static final KEY_AUTHENTICATION_CHALLENGE_REASON:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException.Reason"

.field public static final KEY_AUTHENTICATION_CHALLENGE_REQUIRED_AUTHENTICATION_METHOD:Ljava/lang/String; = "com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod"

.field public static final PANDA_CHALLENGE_CONTEXT_KEY:Ljava/lang/String; = "challenge_context"

.field public static final PANDA_CHALLENGE_OAUTH_URI_KEY:Ljava/lang/String; = "uri"

.field public static final PANDA_CHALLENGE_REASON_KEY:Ljava/lang/String; = "challenge_reason"

.field public static final PANDA_CHALLENGE_REQUIRED_AUTHENTICATION_METHOD:Ljava/lang/String; = "required_authentication_method"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Ljava/lang/String;

.field private mOAuthURI:Ljava/lang/String;

.field private mReason:Ljava/lang/String;

.field private mRequiredAuthenticationMethod:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "reason"    # Ljava/lang/String;
    .param p2, "oAuthURI"    # Ljava/lang/String;
    .param p3, "context"    # Ljava/lang/String;
    .param p4, "requiredAuthenticationMethod"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mReason:Ljava/lang/String;

    .line 40
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mContext:Ljava/lang/String;

    .line 41
    invoke-direct {p0, p2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->sanitizeOAuthURI(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mOAuthURI:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mRequiredAuthenticationMethod:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public static fromPandaChallengeBody(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .locals 6
    .param p0, "challengeJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 47
    const-string/jumbo v4, "challenge_reason"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 48
    .local v2, "reason":Ljava/lang/String;
    const-string/jumbo v4, "uri"

    invoke-virtual {p0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 49
    .local v1, "oAuthURI":Ljava/lang/String;
    const-string/jumbo v4, "challenge_context"

    invoke-virtual {p0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "context":Ljava/lang/String;
    const-string/jumbo v4, "required_authentication_method"

    invoke-virtual {p0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "requiredAuthenticationMethod":Ljava/lang/String;
    new-instance v4, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    invoke-direct {v4, v2, v1, v0, v3}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v4
.end method

.method private sanitizeOAuthURI(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "oAuthURI"    # Ljava/lang/String;

    .prologue
    .line 86
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    .local v0, "url":Ljava/net/URL;
    invoke-virtual {v0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    .end local v0    # "url":Ljava/net/URL;
    :goto_0
    return-object v1

    .line 90
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, " Malformed URL received: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mContext:Ljava/lang/String;

    return-object v0
.end method

.method public getOAuthURI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mOAuthURI:Ljava/lang/String;

    return-object v0
.end method

.method public getReason()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mReason:Ljava/lang/String;

    return-object v0
.end method

.method public toBundle()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 72
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 73
    .local v0, "bundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.identity.auth.ChallengeException.Reason"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mReason:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const-string/jumbo v1, "com.amazon.identity.auth.ChallengeException.oAuthURI"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mOAuthURI:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const-string/jumbo v1, "com.amazon.identity.auth.ChallengeException.Context"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mContext:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string/jumbo v1, "com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->mRequiredAuthenticationMethod:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    return-object v0
.end method
