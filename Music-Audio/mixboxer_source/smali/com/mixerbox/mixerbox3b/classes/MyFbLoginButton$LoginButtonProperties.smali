.class Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

.field private defaultAudience:Lcom/facebook/SessionDefaultAudience;

.field private loginBehavior:Lcom/facebook/SessionLoginBehavior;

.field private onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

.field private permissions:Ljava/util/List;

.field private sessionStatusCallback:Lcom/facebook/Session$StatusCallback;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    sget-object v0, Lcom/facebook/SessionDefaultAudience;->FRIENDS:Lcom/facebook/SessionDefaultAudience;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->defaultAudience:Lcom/facebook/SessionDefaultAudience;

    .line 50
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    .line 53
    sget-object v0, Lcom/facebook/SessionLoginBehavior;->SSO_WITH_FALLBACK:Lcom/facebook/SessionLoginBehavior;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->loginBehavior:Lcom/facebook/SessionLoginBehavior;

    return-void
.end method

.method static synthetic access$1000(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Ljava/util/List;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/SessionLoginBehavior;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->loginBehavior:Lcom/facebook/SessionLoginBehavior;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/internal/SessionAuthorizationType;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/Session$StatusCallback;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    return-object v0
.end method

.method static synthetic access$900(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/SessionDefaultAudience;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->defaultAudience:Lcom/facebook/SessionDefaultAudience;

    return-object v0
.end method

.method private validatePermissions(Ljava/util/List;Lcom/facebook/internal/SessionAuthorizationType;Lcom/facebook/Session;)Z
    .locals 2

    .prologue
    .line 96
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->PUBLISH:Lcom/facebook/internal/SessionAuthorizationType;

    invoke-virtual {v0, p2}, Lcom/facebook/internal/SessionAuthorizationType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    invoke-static {p1}, Lcom/facebook/internal/Utility;->isNullOrEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Permissions for publish actions cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 101
    :cond_0
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Lcom/facebook/Session;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 102
    invoke-virtual {p3}, Lcom/facebook/Session;->getPermissions()Ljava/util/List;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/facebook/internal/Utility;->isSubset(Ljava/util/Collection;Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 103
    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$000()Ljava/lang/String;

    .line 104
    const/4 v0, 0x0

    .line 107
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public clearPermissions()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 115
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    .line 116
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    .line 117
    return-void
.end method

.method public getDefaultAudience()Lcom/facebook/SessionDefaultAudience;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->defaultAudience:Lcom/facebook/SessionDefaultAudience;

    return-object v0
.end method

.method public getLoginBehavior()Lcom/facebook/SessionLoginBehavior;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->loginBehavior:Lcom/facebook/SessionLoginBehavior;

    return-object v0
.end method

.method public getOnErrorListener()Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    return-object v0
.end method

.method getPermissions()Ljava/util/List;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    return-object v0
.end method

.method public getSessionStatusCallback()Lcom/facebook/Session$StatusCallback;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    return-object v0
.end method

.method public setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->defaultAudience:Lcom/facebook/SessionDefaultAudience;

    .line 66
    return-void
.end method

.method public setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->loginBehavior:Lcom/facebook/SessionLoginBehavior;

    .line 121
    return-void
.end method

.method public setOnErrorListener(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    .line 58
    return-void
.end method

.method public setPublishPermissions(Ljava/util/List;Lcom/facebook/Session;)V
    .locals 2

    .prologue
    .line 84
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->READ:Lcom/facebook/internal/SessionAuthorizationType;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    invoke-virtual {v0, v1}, Lcom/facebook/internal/SessionAuthorizationType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Cannot call setPublishPermissions after setReadPermissions has been called."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 88
    :cond_0
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->PUBLISH:Lcom/facebook/internal/SessionAuthorizationType;

    invoke-direct {p0, p1, v0, p2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->validatePermissions(Ljava/util/List;Lcom/facebook/internal/SessionAuthorizationType;Lcom/facebook/Session;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 89
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    .line 90
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->PUBLISH:Lcom/facebook/internal/SessionAuthorizationType;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    .line 92
    :cond_1
    return-void
.end method

.method public setReadPermissions(Ljava/util/List;Lcom/facebook/Session;)V
    .locals 2

    .prologue
    .line 73
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->PUBLISH:Lcom/facebook/internal/SessionAuthorizationType;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    invoke-virtual {v0, v1}, Lcom/facebook/internal/SessionAuthorizationType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Cannot call setReadPermissions after setPublishPermissions has been called."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_0
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->READ:Lcom/facebook/internal/SessionAuthorizationType;

    invoke-direct {p0, p1, v0, p2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->validatePermissions(Ljava/util/List;Lcom/facebook/internal/SessionAuthorizationType;Lcom/facebook/Session;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 78
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;

    .line 79
    sget-object v0, Lcom/facebook/internal/SessionAuthorizationType;->READ:Lcom/facebook/internal/SessionAuthorizationType;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;

    .line 81
    :cond_1
    return-void
.end method

.method public setSessionStatusCallback(Lcom/facebook/Session$StatusCallback;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    .line 129
    return-void
.end method
