.class public Lcom/facebook/AuthorizationClient;
.super Ljava/lang/Object;
.source "AuthorizationClient.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/AuthorizationClient$Result;,
        Lcom/facebook/AuthorizationClient$AuthorizationRequest;,
        Lcom/facebook/AuthorizationClient$AuthDialogBuilder;,
        Lcom/facebook/AuthorizationClient$KatanaProxyAuthHandler;,
        Lcom/facebook/AuthorizationClient$KatanaLoginDialogAuthHandler;,
        Lcom/facebook/AuthorizationClient$KatanaAuthHandler;,
        Lcom/facebook/AuthorizationClient$GetTokenAuthHandler;,
        Lcom/facebook/AuthorizationClient$WebViewAuthHandler;,
        Lcom/facebook/AuthorizationClient$AuthHandler;,
        Lcom/facebook/AuthorizationClient$StartActivityDelegate;,
        Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;,
        Lcom/facebook/AuthorizationClient$OnCompletedListener;
    }
.end annotation


# static fields
.field public static CLEAR_COOKIE:Z = false

.field private static final TAG:Ljava/lang/String; = "Facebook-AuthorizationClient"

.field private static final WEB_VIEW_AUTH_HANDLER_STORE:Ljava/lang/String; = "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY"

.field private static final WEB_VIEW_AUTH_HANDLER_TOKEN_KEY:Ljava/lang/String; = "TOKEN"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field transient backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

.field transient checkedInternetPermission:Z

.field transient context:Landroid/content/Context;

.field currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

.field handlersToTry:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/AuthorizationClient$AuthHandler;",
            ">;"
        }
    .end annotation
.end field

.field transient onCompletedListener:Lcom/facebook/AuthorizationClient$OnCompletedListener;

.field pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

.field transient startActivityDelegate:Lcom/facebook/AuthorizationClient$StartActivityDelegate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 391
    const/4 v0, 0x0

    sput-boolean v0, Lcom/facebook/AuthorizationClient;->CLEAR_COOKIE:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 778
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/AuthorizationClient;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/AuthorizationClient;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/facebook/AuthorizationClient;->notifyBackgroundProcessingStop()V

    return-void
.end method

.method static synthetic access$100(Lcom/facebook/AuthorizationClient;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/AuthorizationClient;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/facebook/AuthorizationClient;->notifyBackgroundProcessingStart()V

    return-void
.end method

.method private completeWithFailure()V
    .locals 2

    .prologue
    .line 185
    const-string v0, "Login attempt failed."

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/facebook/AuthorizationClient$Result;->createErrorResult(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/AuthorizationClient$Result;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/facebook/AuthorizationClient;->complete(Lcom/facebook/AuthorizationClient$Result;)V

    .line 186
    return-void
.end method

.method private getHandlerTypes(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)Ljava/util/List;
    .locals 3
    .param p1, "request"    # Lcom/facebook/AuthorizationClient$AuthorizationRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/AuthorizationClient$AuthorizationRequest;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/AuthorizationClient$AuthHandler;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 151
    .local v1, "handlers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/AuthorizationClient$AuthHandler;>;"
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getLoginBehavior()Lcom/facebook/SessionLoginBehavior;

    move-result-object v0

    .line 152
    .local v0, "behavior":Lcom/facebook/SessionLoginBehavior;
    invoke-virtual {v0}, Lcom/facebook/SessionLoginBehavior;->allowsKatanaAuth()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 153
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->isLegacy()Z

    move-result v2

    if-nez v2, :cond_0

    .line 154
    new-instance v2, Lcom/facebook/AuthorizationClient$GetTokenAuthHandler;

    invoke-direct {v2, p0}, Lcom/facebook/AuthorizationClient$GetTokenAuthHandler;-><init>(Lcom/facebook/AuthorizationClient;)V

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 155
    new-instance v2, Lcom/facebook/AuthorizationClient$KatanaLoginDialogAuthHandler;

    invoke-direct {v2, p0}, Lcom/facebook/AuthorizationClient$KatanaLoginDialogAuthHandler;-><init>(Lcom/facebook/AuthorizationClient;)V

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 157
    :cond_0
    new-instance v2, Lcom/facebook/AuthorizationClient$KatanaProxyAuthHandler;

    invoke-direct {v2, p0}, Lcom/facebook/AuthorizationClient$KatanaProxyAuthHandler;-><init>(Lcom/facebook/AuthorizationClient;)V

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 160
    :cond_1
    invoke-virtual {v0}, Lcom/facebook/SessionLoginBehavior;->allowsWebViewAuth()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 161
    new-instance v2, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;

    invoke-direct {v2, p0}, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;-><init>(Lcom/facebook/AuthorizationClient;)V

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 164
    :cond_2
    return-object v1
.end method

.method private notifyBackgroundProcessingStart()V
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    invoke-interface {v0}, Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;->onBackgroundProcessingStarted()V

    .line 366
    :cond_0
    return-void
.end method

.method private notifyBackgroundProcessingStop()V
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    if-eqz v0, :cond_0

    .line 370
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    invoke-interface {v0}, Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;->onBackgroundProcessingStopped()V

    .line 372
    :cond_0
    return-void
.end method

.method private notifyOnCompleteListener(Lcom/facebook/AuthorizationClient$Result;)V
    .locals 1
    .param p1, "outcome"    # Lcom/facebook/AuthorizationClient$Result;

    .prologue
    .line 357
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->onCompletedListener:Lcom/facebook/AuthorizationClient$OnCompletedListener;

    if-eqz v0, :cond_0

    .line 358
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->onCompletedListener:Lcom/facebook/AuthorizationClient$OnCompletedListener;

    invoke-interface {v0, p1}, Lcom/facebook/AuthorizationClient$OnCompletedListener;->onCompleted(Lcom/facebook/AuthorizationClient$Result;)V

    .line 360
    :cond_0
    return-void
.end method


# virtual methods
.method authorize(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    .prologue
    .line 105
    if-nez p1, :cond_1

    .line 120
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    if-eqz v0, :cond_2

    .line 110
    new-instance v0, Lcom/facebook/FacebookException;

    const-string v1, "Attempted to authorize while a request is pending."

    invoke-direct {v0, v1}, Lcom/facebook/FacebookException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 113
    :cond_2
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->needsNewTokenValidation()Z

    move-result v0

    if-nez v0, :cond_0

    .line 117
    iput-object p1, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    .line 118
    invoke-direct {p0, p1}, Lcom/facebook/AuthorizationClient;->getHandlerTypes(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->handlersToTry:Ljava/util/List;

    .line 119
    invoke-virtual {p0}, Lcom/facebook/AuthorizationClient;->tryNextHandler()V

    goto :goto_0
.end method

.method cancelCurrentHandler()V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    invoke-virtual {v0}, Lcom/facebook/AuthorizationClient$AuthHandler;->cancel()V

    .line 141
    :cond_0
    return-void
.end method

.method checkPermission(Ljava/lang/String;)I
    .locals 1
    .param p1, "permission"    # Ljava/lang/String;

    .prologue
    .line 247
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method complete(Lcom/facebook/AuthorizationClient$Result;)V
    .locals 1
    .param p1, "outcome"    # Lcom/facebook/AuthorizationClient$Result;

    .prologue
    const/4 v0, 0x0

    .line 203
    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->handlersToTry:Ljava/util/List;

    .line 204
    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    .line 205
    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    .line 207
    invoke-direct {p0, p1}, Lcom/facebook/AuthorizationClient;->notifyOnCompleteListener(Lcom/facebook/AuthorizationClient$Result;)V

    .line 208
    return-void
.end method

.method completeAndValidate(Lcom/facebook/AuthorizationClient$Result;)V
    .locals 1
    .param p1, "outcome"    # Lcom/facebook/AuthorizationClient$Result;

    .prologue
    .line 194
    iget-object v0, p1, Lcom/facebook/AuthorizationClient$Result;->token:Lcom/facebook/AccessToken;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    invoke-virtual {v0}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->needsNewTokenValidation()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 195
    invoke-virtual {p0, p1}, Lcom/facebook/AuthorizationClient;->validateSameFbidAndFinish(Lcom/facebook/AuthorizationClient$Result;)V

    .line 200
    :goto_0
    return-void

    .line 198
    :cond_0
    invoke-virtual {p0, p1}, Lcom/facebook/AuthorizationClient;->complete(Lcom/facebook/AuthorizationClient$Result;)V

    goto :goto_0
.end method

.method continueAuth()V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    if-nez v0, :cond_1

    .line 124
    :cond_0
    new-instance v0, Lcom/facebook/FacebookException;

    const-string v1, "Attempted to continue authorization without a pending request."

    invoke-direct {v0, v1}, Lcom/facebook/FacebookException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 127
    :cond_1
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    invoke-virtual {v0}, Lcom/facebook/AuthorizationClient$AuthHandler;->needsRestart()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 128
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    invoke-virtual {v0}, Lcom/facebook/AuthorizationClient$AuthHandler;->cancel()V

    .line 129
    invoke-virtual {p0}, Lcom/facebook/AuthorizationClient;->tryCurrentHandler()Z

    .line 131
    :cond_2
    return-void
.end method

.method createGetPermissionsRequest(Ljava/lang/String;)Lcom/facebook/Request;
    .locals 6
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 343
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 344
    .local v3, "parameters":Landroid/os/Bundle;
    const-string v0, "fields"

    const-string v2, "id"

    invoke-virtual {v3, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 345
    const-string v0, "access_token"

    invoke-virtual {v3, v0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    new-instance v0, Lcom/facebook/Request;

    const-string v2, "me/permissions"

    sget-object v4, Lcom/facebook/HttpMethod;->GET:Lcom/facebook/HttpMethod;

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lcom/facebook/Request;-><init>(Lcom/facebook/Session;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/Request$Callback;)V

    return-object v0
.end method

.method createGetProfileIdRequest(Ljava/lang/String;)Lcom/facebook/Request;
    .locals 6
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 350
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 351
    .local v3, "parameters":Landroid/os/Bundle;
    const-string v0, "fields"

    const-string v2, "id"

    invoke-virtual {v3, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    const-string v0, "access_token"

    invoke-virtual {v3, v0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    new-instance v0, Lcom/facebook/Request;

    const-string v2, "me"

    sget-object v4, Lcom/facebook/HttpMethod;->GET:Lcom/facebook/HttpMethod;

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lcom/facebook/Request;-><init>(Lcom/facebook/Session;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/Request$Callback;)V

    return-object v0
.end method

.method createReauthValidationBatch(Lcom/facebook/AuthorizationClient$Result;)Lcom/facebook/RequestBatch;
    .locals 11
    .param p1, "pendingResult"    # Lcom/facebook/AuthorizationClient$Result;

    .prologue
    .line 267
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 268
    .local v1, "fbids":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 269
    .local v7, "tokenPermissions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v9, p1, Lcom/facebook/AuthorizationClient$Result;->token:Lcom/facebook/AccessToken;

    invoke-virtual {v9}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v3

    .line 271
    .local v3, "newToken":Ljava/lang/String;
    new-instance v2, Lcom/facebook/AuthorizationClient$3;

    invoke-direct {v2, p0, v1}, Lcom/facebook/AuthorizationClient$3;-><init>(Lcom/facebook/AuthorizationClient;Ljava/util/ArrayList;)V

    .line 284
    .local v2, "meCallback":Lcom/facebook/Request$Callback;
    iget-object v9, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    invoke-virtual {v9}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getPreviousAccessToken()Ljava/lang/String;

    move-result-object v8

    .line 285
    .local v8, "validateSameFbidAsToken":Ljava/lang/String;
    invoke-virtual {p0, v8}, Lcom/facebook/AuthorizationClient;->createGetProfileIdRequest(Ljava/lang/String;)Lcom/facebook/Request;

    move-result-object v4

    .line 286
    .local v4, "requestCurrentTokenMe":Lcom/facebook/Request;
    invoke-virtual {v4, v2}, Lcom/facebook/Request;->setCallback(Lcom/facebook/Request$Callback;)V

    .line 288
    invoke-virtual {p0, v3}, Lcom/facebook/AuthorizationClient;->createGetProfileIdRequest(Ljava/lang/String;)Lcom/facebook/Request;

    move-result-object v6

    .line 289
    .local v6, "requestNewTokenMe":Lcom/facebook/Request;
    invoke-virtual {v6, v2}, Lcom/facebook/Request;->setCallback(Lcom/facebook/Request$Callback;)V

    .line 291
    invoke-virtual {p0, v8}, Lcom/facebook/AuthorizationClient;->createGetPermissionsRequest(Ljava/lang/String;)Lcom/facebook/Request;

    move-result-object v5

    .line 292
    .local v5, "requestCurrentTokenPermissions":Lcom/facebook/Request;
    new-instance v9, Lcom/facebook/AuthorizationClient$4;

    invoke-direct {v9, p0, v7}, Lcom/facebook/AuthorizationClient$4;-><init>(Lcom/facebook/AuthorizationClient;Ljava/util/ArrayList;)V

    invoke-virtual {v5, v9}, Lcom/facebook/Request;->setCallback(Lcom/facebook/Request$Callback;)V

    .line 311
    new-instance v0, Lcom/facebook/RequestBatch;

    const/4 v9, 0x3

    new-array v9, v9, [Lcom/facebook/Request;

    const/4 v10, 0x0

    aput-object v4, v9, v10

    const/4 v10, 0x1

    aput-object v6, v9, v10

    const/4 v10, 0x2

    aput-object v5, v9, v10

    invoke-direct {v0, v9}, Lcom/facebook/RequestBatch;-><init>([Lcom/facebook/Request;)V

    .line 313
    .local v0, "batch":Lcom/facebook/RequestBatch;
    iget-object v9, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    invoke-virtual {v9}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getApplicationId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Lcom/facebook/RequestBatch;->setBatchApplicationId(Ljava/lang/String;)V

    .line 314
    new-instance v9, Lcom/facebook/AuthorizationClient$5;

    invoke-direct {v9, p0, v1, p1, v7}, Lcom/facebook/AuthorizationClient$5;-><init>(Lcom/facebook/AuthorizationClient;Ljava/util/ArrayList;Lcom/facebook/AuthorizationClient$Result;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v9}, Lcom/facebook/RequestBatch;->addCallback(Lcom/facebook/RequestBatch$Callback;)V

    .line 339
    return-object v0
.end method

.method getBackgroundProcessingListener()Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    return-object v0
.end method

.method getInProgress()Z
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getOnCompletedListener()Lcom/facebook/AuthorizationClient$OnCompletedListener;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->onCompletedListener:Lcom/facebook/AuthorizationClient$OnCompletedListener;

    return-object v0
.end method

.method getStartActivityDelegate()Lcom/facebook/AuthorizationClient$StartActivityDelegate;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->startActivityDelegate:Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->startActivityDelegate:Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    .line 243
    :goto_0
    return-object v0

    .line 229
    :cond_0
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    if-eqz v0, :cond_1

    .line 231
    new-instance v0, Lcom/facebook/AuthorizationClient$2;

    invoke-direct {v0, p0}, Lcom/facebook/AuthorizationClient$2;-><init>(Lcom/facebook/AuthorizationClient;)V

    goto :goto_0

    .line 243
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method onActivityResult(IILandroid/content/Intent;)Z
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    invoke-virtual {v0}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getRequestCode()I

    move-result v0

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/AuthorizationClient$AuthHandler;->onActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method setBackgroundProcessingListener(Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;)V
    .locals 0
    .param p1, "backgroundProcessingListener"    # Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    .prologue
    .line 223
    iput-object p1, p0, Lcom/facebook/AuthorizationClient;->backgroundProcessingListener:Lcom/facebook/AuthorizationClient$BackgroundProcessingListener;

    .line 224
    return-void
.end method

.method setContext(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    .line 83
    new-instance v0, Lcom/facebook/AuthorizationClient$1;

    invoke-direct {v0, p0, p1}, Lcom/facebook/AuthorizationClient$1;-><init>(Lcom/facebook/AuthorizationClient;Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->startActivityDelegate:Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    .line 94
    return-void
.end method

.method setContext(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    .line 75
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/AuthorizationClient;->startActivityDelegate:Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    .line 76
    return-void
.end method

.method setOnCompletedListener(Lcom/facebook/AuthorizationClient$OnCompletedListener;)V
    .locals 0
    .param p1, "onCompletedListener"    # Lcom/facebook/AuthorizationClient$OnCompletedListener;

    .prologue
    .line 215
    iput-object p1, p0, Lcom/facebook/AuthorizationClient;->onCompletedListener:Lcom/facebook/AuthorizationClient$OnCompletedListener;

    .line 216
    return-void
.end method

.method startOrContinueAuth(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/facebook/AuthorizationClient;->getInProgress()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/facebook/AuthorizationClient;->continueAuth()V

    .line 102
    :goto_0
    return-void

    .line 100
    :cond_0
    invoke-virtual {p0, p1}, Lcom/facebook/AuthorizationClient;->authorize(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)V

    goto :goto_0
.end method

.method tryCurrentHandler()Z
    .locals 2

    .prologue
    .line 189
    iget-object v0, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    iget-object v1, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    invoke-virtual {v0, v1}, Lcom/facebook/AuthorizationClient$AuthHandler;->tryAuthorize(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)Z

    move-result v0

    return v0
.end method

.method tryNextHandler()V
    .locals 3

    .prologue
    .line 168
    :cond_0
    iget-object v1, p0, Lcom/facebook/AuthorizationClient;->handlersToTry:Ljava/util/List;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/facebook/AuthorizationClient;->handlersToTry:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 169
    iget-object v1, p0, Lcom/facebook/AuthorizationClient;->handlersToTry:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/AuthorizationClient$AuthHandler;

    iput-object v1, p0, Lcom/facebook/AuthorizationClient;->currentHandler:Lcom/facebook/AuthorizationClient$AuthHandler;

    .line 171
    invoke-virtual {p0}, Lcom/facebook/AuthorizationClient;->tryCurrentHandler()Z

    move-result v0

    .line 173
    .local v0, "started":Z
    if-eqz v0, :cond_0

    .line 182
    .end local v0    # "started":Z
    :cond_1
    :goto_0
    return-void

    .line 178
    :cond_2
    iget-object v1, p0, Lcom/facebook/AuthorizationClient;->pendingRequest:Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    if-eqz v1, :cond_1

    .line 180
    invoke-direct {p0}, Lcom/facebook/AuthorizationClient;->completeWithFailure()V

    goto :goto_0
.end method

.method validateSameFbidAndFinish(Lcom/facebook/AuthorizationClient$Result;)V
    .locals 3
    .param p1, "pendingResult"    # Lcom/facebook/AuthorizationClient$Result;

    .prologue
    .line 251
    iget-object v1, p1, Lcom/facebook/AuthorizationClient$Result;->token:Lcom/facebook/AccessToken;

    if-nez v1, :cond_0

    .line 252
    new-instance v1, Lcom/facebook/FacebookException;

    const-string v2, "Can\'t validate without a token"

    invoke-direct {v1, v2}, Lcom/facebook/FacebookException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 255
    :cond_0
    invoke-virtual {p0, p1}, Lcom/facebook/AuthorizationClient;->createReauthValidationBatch(Lcom/facebook/AuthorizationClient$Result;)Lcom/facebook/RequestBatch;

    move-result-object v0

    .line 257
    .local v0, "batch":Lcom/facebook/RequestBatch;
    invoke-direct {p0}, Lcom/facebook/AuthorizationClient;->notifyBackgroundProcessingStart()V

    .line 259
    invoke-virtual {v0}, Lcom/facebook/RequestBatch;->executeAsync()Lcom/facebook/RequestAsyncTask;

    .line 260
    return-void
.end method
