.class Lcom/facebook/AuthorizationClient$WebViewAuthHandler;
.super Lcom/facebook/AuthorizationClient$AuthHandler;
.source "AuthorizationClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/AuthorizationClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "WebViewAuthHandler"
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private transient loginDialog:Lcom/facebook/widget/WebDialog;

.field final synthetic this$0:Lcom/facebook/AuthorizationClient;


# direct methods
.method constructor <init>(Lcom/facebook/AuthorizationClient;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    invoke-direct {p0, p1}, Lcom/facebook/AuthorizationClient$AuthHandler;-><init>(Lcom/facebook/AuthorizationClient;)V

    return-void
.end method

.method private loadCookieToken()Ljava/lang/String;
    .locals 4

    .prologue
    .line 487
    iget-object v2, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    invoke-virtual {v2}, Lcom/facebook/AuthorizationClient;->getStartActivityDelegate()Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    move-result-object v2

    invoke-interface {v2}, Lcom/facebook/AuthorizationClient$StartActivityDelegate;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    .line 488
    .local v0, "context":Landroid/content/Context;
    const-string v2, "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 491
    .local v1, "sharedPreferences":Landroid/content/SharedPreferences;
    const-string v2, "TOKEN"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private saveCookieToken(Ljava/lang/String;)V
    .locals 5
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 475
    iget-object v3, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    invoke-virtual {v3}, Lcom/facebook/AuthorizationClient;->getStartActivityDelegate()Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/AuthorizationClient$StartActivityDelegate;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    .line 476
    .local v0, "context":Landroid/content/Context;
    const-string v3, "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY"

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 479
    .local v2, "sharedPreferences":Landroid/content/SharedPreferences;
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 480
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v3, "TOKEN"

    invoke-interface {v1, v3, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 481
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v3

    if-nez v3, :cond_0

    .line 482
    const-string v3, "Facebook-AuthorizationClient"

    const-string v4, "Could not update saved web view auth handler token."

    invoke-static {v3, v4}, Lcom/facebook/internal/Utility;->logd(Ljava/lang/String;Ljava/lang/String;)V

    .line 484
    :cond_0
    return-void
.end method


# virtual methods
.method cancel()V
    .locals 1

    .prologue
    .line 406
    iget-object v0, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loginDialog:Lcom/facebook/widget/WebDialog;

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loginDialog:Lcom/facebook/widget/WebDialog;

    invoke-virtual {v0}, Lcom/facebook/widget/WebDialog;->dismiss()V

    .line 408
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loginDialog:Lcom/facebook/widget/WebDialog;

    .line 410
    :cond_0
    return-void
.end method

.method needsRestart()Z
    .locals 1

    .prologue
    .line 401
    const/4 v0, 0x1

    return v0
.end method

.method onWebDialogComplete(Lcom/facebook/AuthorizationClient$AuthorizationRequest;Landroid/os/Bundle;Lcom/facebook/FacebookException;)V
    .locals 5
    .param p1, "request"    # Lcom/facebook/AuthorizationClient$AuthorizationRequest;
    .param p2, "values"    # Landroid/os/Bundle;
    .param p3, "error"    # Lcom/facebook/FacebookException;

    .prologue
    .line 453
    if-eqz p2, :cond_0

    .line 454
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getPermissions()Ljava/util/List;

    move-result-object v3

    sget-object v4, Lcom/facebook/AccessTokenSource;->WEB_VIEW:Lcom/facebook/AccessTokenSource;

    invoke-static {v3, p2, v4}, Lcom/facebook/AccessToken;->createFromWebBundle(Ljava/util/List;Landroid/os/Bundle;Lcom/facebook/AccessTokenSource;)Lcom/facebook/AccessToken;

    move-result-object v2

    .line 456
    .local v2, "token":Lcom/facebook/AccessToken;
    invoke-static {v2}, Lcom/facebook/AuthorizationClient$Result;->createTokenResult(Lcom/facebook/AccessToken;)Lcom/facebook/AuthorizationClient$Result;

    move-result-object v0

    .line 461
    .local v0, "outcome":Lcom/facebook/AuthorizationClient$Result;
    iget-object v3, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    iget-object v3, v3, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    invoke-static {v3}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    move-result-object v1

    .line 462
    .local v1, "syncManager":Landroid/webkit/CookieSyncManager;
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 463
    invoke-virtual {v2}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->saveCookieToken(Ljava/lang/String;)V

    .line 471
    .end local v1    # "syncManager":Landroid/webkit/CookieSyncManager;
    .end local v2    # "token":Lcom/facebook/AccessToken;
    :goto_0
    iget-object v3, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    invoke-virtual {v3, v0}, Lcom/facebook/AuthorizationClient;->completeAndValidate(Lcom/facebook/AuthorizationClient$Result;)V

    .line 472
    return-void

    .line 465
    .end local v0    # "outcome":Lcom/facebook/AuthorizationClient$Result;
    :cond_0
    instance-of v3, p3, Lcom/facebook/FacebookOperationCanceledException;

    if-eqz v3, :cond_1

    .line 466
    const-string v3, "User canceled log in."

    invoke-static {v3}, Lcom/facebook/AuthorizationClient$Result;->createCancelResult(Ljava/lang/String;)Lcom/facebook/AuthorizationClient$Result;

    move-result-object v0

    .restart local v0    # "outcome":Lcom/facebook/AuthorizationClient$Result;
    goto :goto_0

    .line 468
    .end local v0    # "outcome":Lcom/facebook/AuthorizationClient$Result;
    :cond_1
    invoke-virtual {p3}, Lcom/facebook/FacebookException;->getMessage()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/facebook/AuthorizationClient$Result;->createErrorResult(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/AuthorizationClient$Result;

    move-result-object v0

    .restart local v0    # "outcome":Lcom/facebook/AuthorizationClient$Result;
    goto :goto_0
.end method

.method tryAuthorize(Lcom/facebook/AuthorizationClient$AuthorizationRequest;)Z
    .locals 9
    .param p1, "request"    # Lcom/facebook/AuthorizationClient$AuthorizationRequest;

    .prologue
    .line 414
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getApplicationId()Ljava/lang/String;

    move-result-object v0

    .line 415
    .local v0, "applicationId":Ljava/lang/String;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 416
    .local v3, "parameters":Landroid/os/Bundle;
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getPermissions()Ljava/util/List;

    move-result-object v6

    invoke-static {v6}, Lcom/facebook/internal/Utility;->isNullOrEmpty(Ljava/util/Collection;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 417
    const-string v6, "scope"

    const-string v7, ","

    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getPermissions()Ljava/util/List;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    :cond_0
    invoke-virtual {p1}, Lcom/facebook/AuthorizationClient$AuthorizationRequest;->getPreviousAccessToken()Ljava/lang/String;

    move-result-object v4

    .line 421
    .local v4, "previousToken":Ljava/lang/String;
    invoke-static {v4}, Lcom/facebook/internal/Utility;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    invoke-direct {p0}, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loadCookieToken()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 422
    const-string v6, "access_token"

    invoke-virtual {v3, v6, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    :goto_0
    new-instance v2, Lcom/facebook/AuthorizationClient$WebViewAuthHandler$1;

    invoke-direct {v2, p0, p1}, Lcom/facebook/AuthorizationClient$WebViewAuthHandler$1;-><init>(Lcom/facebook/AuthorizationClient$WebViewAuthHandler;Lcom/facebook/AuthorizationClient$AuthorizationRequest;)V

    .line 441
    .local v2, "listener":Lcom/facebook/widget/WebDialog$OnCompleteListener;
    new-instance v6, Lcom/facebook/AuthorizationClient$AuthDialogBuilder;

    iget-object v7, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    invoke-virtual {v7}, Lcom/facebook/AuthorizationClient;->getStartActivityDelegate()Lcom/facebook/AuthorizationClient$StartActivityDelegate;

    move-result-object v7

    invoke-interface {v7}, Lcom/facebook/AuthorizationClient$StartActivityDelegate;->getActivityContext()Landroid/app/Activity;

    move-result-object v7

    invoke-direct {v6, v7, v0, v3}, Lcom/facebook/AuthorizationClient$AuthDialogBuilder;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V

    invoke-virtual {v6, v2}, Lcom/facebook/AuthorizationClient$AuthDialogBuilder;->setOnCompleteListener(Lcom/facebook/widget/WebDialog$OnCompleteListener;)Lcom/facebook/widget/WebDialog$BuilderBase;

    move-result-object v1

    check-cast v1, Lcom/facebook/widget/WebDialog$Builder;

    .line 444
    .local v1, "builder":Lcom/facebook/widget/WebDialog$Builder;
    invoke-virtual {v1}, Lcom/facebook/widget/WebDialog$Builder;->build()Lcom/facebook/widget/WebDialog;

    move-result-object v6

    iput-object v6, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loginDialog:Lcom/facebook/widget/WebDialog;

    .line 445
    iget-object v6, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->loginDialog:Lcom/facebook/widget/WebDialog;

    invoke-virtual {v6}, Lcom/facebook/widget/WebDialog;->show()V

    .line 447
    const/4 v6, 0x1

    return v6

    .line 425
    .end local v1    # "builder":Lcom/facebook/widget/WebDialog$Builder;
    .end local v2    # "listener":Lcom/facebook/widget/WebDialog$OnCompleteListener;
    :cond_1
    sget-boolean v6, Lcom/facebook/AuthorizationClient;->CLEAR_COOKIE:Z

    if-eqz v6, :cond_2

    .line 426
    iget-object v6, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    iget-object v6, v6, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    invoke-static {v6}, Lcom/facebook/internal/Utility;->clearFacebookCookies(Landroid/content/Context;)V

    .line 427
    const/4 v6, 0x0

    sput-boolean v6, Lcom/facebook/AuthorizationClient;->CLEAR_COOKIE:Z

    goto :goto_0

    .line 429
    :cond_2
    iget-object v6, p0, Lcom/facebook/AuthorizationClient$WebViewAuthHandler;->this$0:Lcom/facebook/AuthorizationClient;

    iget-object v6, v6, Lcom/facebook/AuthorizationClient;->context:Landroid/content/Context;

    invoke-static {v6}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    move-result-object v5

    .line 430
    .local v5, "syncManager":Landroid/webkit/CookieSyncManager;
    invoke-virtual {v5}, Landroid/webkit/CookieSyncManager;->sync()V

    goto :goto_0
.end method
