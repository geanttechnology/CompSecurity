.class public Lcom/poshmark/fb_tmblr_twitter/FbHelper;
.super Ljava/lang/Object;
.source "FbHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;,
        Lcom/poshmark/fb_tmblr_twitter/FbHelper$SingletonHolder;
    }
.end annotation


# static fields
.field public static CALLING_CODE_BASEMENT:I = 0x0

.field public static FB_CONNECT_AUTO_TIMELINE_REQUEST:I = 0x0

.field public static FB_CONNECT_FRIENDS_REQUEST:I = 0x0

.field public static FB_CONNECT_PUBLISH_REQUEST:I = 0x0

.field public static FB_CONNECT_READ_REQUEST:I = 0x0

.field public static final SERVICE_ID:Ljava/lang/String; = "fb"


# instance fields
.field public FB_REQUEST_FROM_PM_ACTIVITY:I

.field accessTokenTracker:Lcom/facebook/AccessTokenTracker;

.field private callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

.field callbackManager:Lcom/facebook/CallbackManager;

.field fragment:Lcom/poshmark/ui/fragments/PMFragment;

.field private fragmentId:Ljava/util/UUID;

.field handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

.field loginCallback:Lcom/facebook/FacebookCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/FacebookCallback",
            "<",
            "Lcom/facebook/login/LoginResult;",
            ">;"
        }
    .end annotation
.end field

.field private savedCallingFragmentBundle:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 71
    const/16 v0, 0x7d0

    sput v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->CALLING_CODE_BASEMENT:I

    .line 72
    const/16 v0, 0x320

    sput v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    .line 73
    const/16 v0, 0x321

    sput v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_PUBLISH_REQUEST:I

    .line 74
    const/16 v0, 0x322

    sput v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_READ_REQUEST:I

    .line 75
    const/16 v0, 0x323

    sput v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_AUTO_TIMELINE_REQUEST:I

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 83
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;

    invoke-direct {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;-><init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->accessTokenTracker:Lcom/facebook/AccessTokenTracker;

    .line 164
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;

    invoke-direct {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;-><init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->loginCallback:Lcom/facebook/FacebookCallback;

    .line 108
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->accessTokenTracker:Lcom/facebook/AccessTokenTracker;

    invoke-virtual {v0}, Lcom/facebook/AccessTokenTracker;->startTracking()V

    .line 109
    invoke-static {}, Lcom/facebook/CallbackManager$Factory;->create()Lcom/facebook/CallbackManager;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callbackManager:Lcom/facebook/CallbackManager;

    .line 110
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callbackManager:Lcom/facebook/CallbackManager;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->loginCallback:Lcom/facebook/FacebookCallback;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/login/LoginManager;->registerCallback(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V

    .line 111
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;-><init>()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/facebook/AccessToken;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->createTokenFromPMData()Lcom/facebook/AccessToken;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .param p1, "x1"    # Lcom/facebook/AccessToken;
    .param p2, "x2"    # Lcom/facebook/AccessToken;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isTokenUpdated(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;)Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .param p1, "x1"    # Lcom/facebook/AccessToken;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getExternalConnectionInfoFromAccessToken(Lcom/facebook/AccessToken;)Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Ljava/util/Set;)I
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .param p1, "x1"    # Ljava/util/Set;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->inferCurrentAccessLevelFromSet(Ljava/util/Set;)I

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    return-object v0
.end method

.method static synthetic access$600(Lcom/poshmark/fb_tmblr_twitter/FbHelper;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->returnResult(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$700(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/poshmark/http/api/PMApiError;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->returnError(Lcom/poshmark/http/api/PMApiError;)V

    return-void
.end method

.method private createTokenFromPMData()Lcom/facebook/AccessToken;
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v2, 0x1

    .line 369
    const/4 v0, 0x0

    .line 370
    .local v0, "accessToken":Lcom/facebook/AccessToken;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getFacebookInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v9

    .line 371
    .local v9, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 373
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 374
    .local v4, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 375
    .local v5, "declinedPermissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    if-eqz v1, :cond_0

    .line 376
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v1, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->public_profile:I

    if-ne v1, v2, :cond_2

    .line 377
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 382
    :goto_0
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v1, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->publish_actions:I

    if-ne v1, v2, :cond_3

    .line 383
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 388
    :goto_1
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v1, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->email:I

    if-ne v1, v2, :cond_4

    .line 389
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->EMAIL_PERMISSION:Ljava/lang/String;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 394
    :goto_2
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v1, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->user_friends:I

    if-ne v1, v2, :cond_5

    .line 395
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 400
    :cond_0
    :goto_3
    new-instance v0, Lcom/facebook/AccessToken;

    .end local v0    # "accessToken":Lcom/facebook/AccessToken;
    iget-object v1, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06010b

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    iget-object v7, v9, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-static {v7}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    move-object v8, v6

    invoke-direct/range {v0 .. v8}, Lcom/facebook/AccessToken;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;)V

    .line 403
    .end local v4    # "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "declinedPermissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v0    # "accessToken":Lcom/facebook/AccessToken;
    :cond_1
    return-object v0

    .line 379
    .restart local v4    # "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v5    # "declinedPermissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 385
    :cond_3
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 391
    :cond_4
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->EMAIL_PERMISSION:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 397
    :cond_5
    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3
.end method

.method private getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 229
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v2

    .line 230
    .local v2, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v2, :cond_0

    .line 232
    :try_start_0
    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 238
    :goto_0
    return-object v1

    .line 234
    :catch_0
    move-exception v0

    .local v0, "exception":Ljava/lang/IllegalStateException;
    move-object v1, v3

    .line 235
    goto :goto_0

    .end local v0    # "exception":Ljava/lang/IllegalStateException;
    :cond_0
    move-object v1, v3

    .line 238
    goto :goto_0
.end method

.method private getExternalConnectionInfoFromAccessToken(Lcom/facebook/AccessToken;)Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 4
    .param p1, "currentAccessToken"    # Lcom/facebook/AccessToken;

    .prologue
    const/4 v3, 0x1

    .line 346
    new-instance v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/ExternalServiceInfo;-><init>()V

    .line 347
    .local v0, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    .line 348
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getUserId()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    .line 349
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getExpires()Ljava/util/Date;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    .line 350
    new-instance v2, Lcom/poshmark/data_model/models/ExternalPermissions;

    invoke-direct {v2}, Lcom/poshmark/data_model/models/ExternalPermissions;-><init>()V

    iput-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    .line 351
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getPermissions()Ljava/util/Set;

    move-result-object v1

    .line 352
    .local v1, "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 353
    iget-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iput v3, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->user_friends:I

    .line 355
    :cond_0
    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 356
    iget-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iput v3, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->public_profile:I

    .line 358
    :cond_1
    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 359
    iget-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iput v3, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->publish_actions:I

    .line 361
    :cond_2
    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->EMAIL_PERMISSION:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 362
    iget-object v2, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iput v3, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->email:I

    .line 365
    :cond_3
    return-object v0
.end method

.method public static getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$SingletonHolder;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    return-object v0
.end method

.method private inferCurrentAccessLevelFromSet(Ljava/util/Set;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 148
    .local p1, "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .line 149
    .local v2, "permissionMask":I
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 150
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 151
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 152
    .local v1, "permission":Ljava/lang/String;
    invoke-static {v1}, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->getMaskFromString(Ljava/lang/String;)I

    move-result v3

    or-int/2addr v2, v3

    .line 155
    goto :goto_0

    .line 156
    .end local v1    # "permission":Ljava/lang/String;
    :cond_0
    return v2
.end method

.method private isTokenUpdated(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)Z
    .locals 9
    .param p1, "oldAccessToken"    # Lcom/facebook/AccessToken;
    .param p2, "currentAccessToken"    # Lcom/facebook/AccessToken;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 425
    new-instance v1, Ljava/util/HashSet;

    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getPermissions()Ljava/util/Set;

    move-result-object v7

    invoke-direct {v1, v7}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 426
    .local v1, "oldPermissionsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v0, Ljava/util/HashSet;

    invoke-virtual {p2}, Lcom/facebook/AccessToken;->getPermissions()Ljava/util/Set;

    move-result-object v7

    invoke-direct {v0, v7}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 430
    .local v0, "newPermissionsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string v7, "contact_email"

    invoke-interface {v1, v7}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 431
    const-string v7, "contact_email"

    invoke-interface {v0, v7}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 433
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    move v3, v5

    .line 434
    .local v3, "tokenUpdated":Z
    :goto_0
    invoke-interface {v1, v0}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_3

    move v2, v5

    .line 435
    .local v2, "permissionsUpdated":Z
    :goto_1
    invoke-virtual {p1}, Lcom/facebook/AccessToken;->getUserId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2}, Lcom/facebook/AccessToken;->getUserId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    .line 437
    .local v4, "userIdsMatch":Z
    if-nez v3, :cond_0

    if-eqz v2, :cond_1

    :cond_0
    if-eqz v4, :cond_1

    move v6, v5

    .line 440
    :cond_1
    return v6

    .end local v2    # "permissionsUpdated":Z
    .end local v3    # "tokenUpdated":Z
    .end local v4    # "userIdsMatch":Z
    :cond_2
    move v3, v6

    .line 433
    goto :goto_0

    .restart local v3    # "tokenUpdated":Z
    :cond_3
    move v2, v6

    .line 434
    goto :goto_1
.end method

.method private link(Lcom/poshmark/ui/fragments/PMFragment;II)V
    .locals 5
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "minimumAccessLevel"    # I
    .param p3, "maximumAccessLevel"    # I

    .prologue
    .line 124
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/login/LoginManager;->logOut()V

    .line 125
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 126
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    .line 127
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragmentId:Ljava/util/UUID;

    .line 128
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1, v2, v3, v4}, Landroid/support/v4/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V

    .line 130
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 131
    .local v0, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v0, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->populatePermissionRequestList(Ljava/util/List;II)V

    .line 132
    and-int/lit8 v1, p2, 0x8

    if-eqz v1, :cond_0

    .line 134
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/facebook/login/LoginManager;->logInWithPublishPermissions(Landroid/app/Activity;Ljava/util/Collection;)V

    .line 139
    :goto_0
    return-void

    .line 136
    :cond_0
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/facebook/login/LoginManager;->logInWithReadPermissions(Landroid/app/Activity;Ljava/util/Collection;)V

    goto :goto_0
.end method

.method private populatePermissionRequestList(Ljava/util/List;II)V
    .locals 1
    .param p2, "minimumAccessLevel"    # I
    .param p3, "maximumAccessLevel"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p3}, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->getPermissionStringSet(I)Ljava/util/Set;

    move-result-object v0

    .line 144
    .local v0, "requestedMaximumPermissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {p1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 145
    return-void
.end method

.method private returnError(Lcom/poshmark/http/api/PMApiError;)V
    .locals 5
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 312
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 313
    .local v1, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    .line 315
    :try_start_0
    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 316
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v2, :cond_0

    .line 317
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 318
    .local v0, "result":Landroid/os/Bundle;
    const-string v2, "HAS_ERROR"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 319
    const-string v2, "ERROR_JSON"

    invoke-static {p1}, Lcom/poshmark/http/api/PMApiError;->serialize(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_REQUEST_FROM_PM_ACTIVITY:I

    invoke-virtual {v2, v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 327
    .end local v0    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 322
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private returnResult(ILjava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "grantedPermissions"    # I
    .param p2, "accessToken"    # Ljava/lang/String;
    .param p3, "formattedDate"    # Ljava/lang/String;

    .prologue
    .line 293
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 294
    .local v1, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    .line 296
    :try_start_0
    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 297
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v2, :cond_0

    .line 298
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 299
    .local v0, "result":Landroid/os/Bundle;
    const-string v2, "HAS_ERROR"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 300
    const-string v2, "ACCESS_LEVEL"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 301
    const-string v2, "ACCESS_TOKEN"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    const-string v2, "FB_DATE"

    invoke-virtual {v0, v2, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 303
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_REQUEST_FROM_PM_ACTIVITY:I

    invoke-virtual {v2, v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 309
    .end local v0    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 305
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p0, "apiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 330
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-static {p0, p1, v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .line 331
    return-void
.end method

.method public static showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V
    .locals 7
    .param p0, "apiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "severity"    # Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .prologue
    const/4 v3, 0x0

    .line 334
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 335
    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v0, v1, :cond_1

    .line 336
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_FACEBOOK:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v1, 0x7f0600dc

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object v1, p0

    move-object v4, p2

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 343
    :cond_0
    :goto_0
    return-void

    .line 339
    :cond_1
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_FACEBOOK:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v2, 0x7f0600db

    invoke-virtual {p1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2, p2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method


# virtual methods
.method public getCallbackManager()Lcom/facebook/CallbackManager;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callbackManager:Lcom/facebook/CallbackManager;

    return-object v0
.end method

.method public getMe(Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V
    .locals 5
    .param p1, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    .prologue
    .line 247
    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v0

    .line 248
    .local v0, "accessToken":Lcom/facebook/AccessToken;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 249
    new-instance v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;

    invoke-direct {v3, p0, v0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;-><init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V

    invoke-static {v0, v3}, Lcom/facebook/GraphRequest;->newMeRequest(Lcom/facebook/AccessToken;Lcom/facebook/GraphRequest$GraphJSONObjectCallback;)Lcom/facebook/GraphRequest;

    move-result-object v2

    .line 284
    .local v2, "request":Lcom/facebook/GraphRequest;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 285
    .local v1, "parameters":Landroid/os/Bundle;
    const-string v3, "fields"

    const-string v4, "id, email,name, first_name,last_name, link"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 286
    invoke-virtual {v2, v1}, Lcom/facebook/GraphRequest;->setParameters(Landroid/os/Bundle;)V

    .line 287
    invoke-virtual {v2}, Lcom/facebook/GraphRequest;->executeAsync()Lcom/facebook/GraphRequestAsyncTask;

    .line 289
    .end local v1    # "parameters":Landroid/os/Bundle;
    .end local v2    # "request":Lcom/facebook/GraphRequest;
    :cond_0
    return-void
.end method

.method public isPermissionEnabled(Ljava/lang/String;)Z
    .locals 4
    .param p1, "permission"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 446
    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v1

    .line 447
    .local v1, "token":Lcom/facebook/AccessToken;
    if-eqz v1, :cond_0

    .line 448
    invoke-virtual {v1}, Lcom/facebook/AccessToken;->getPermissions()Ljava/util/Set;

    move-result-object v0

    .line 449
    .local v0, "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 450
    const/4 v2, 0x1

    .line 455
    .end local v0    # "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    return v2
.end method

.method public link(Lcom/poshmark/ui/fragments/PMFragment;III)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "minimumAccessLevel"    # I
    .param p3, "maximumAccessLevel"    # I
    .param p4, "requestCode"    # I

    .prologue
    .line 119
    iput p4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_REQUEST_FROM_PM_ACTIVITY:I

    .line 120
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;II)V

    .line 121
    return-void
.end method

.method public link(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/FBConnectCallback;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "minimumAccessLevel"    # I
    .param p3, "maximumAccessLevel"    # I
    .param p4, "callback"    # Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    .prologue
    .line 114
    iput-object p4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    .line 115
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;II)V

    .line 116
    return-void
.end method

.method public linkWithPM(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 2
    .param p1, "accessToken"    # Ljava/lang/String;
    .param p2, "formattedDate"    # Ljava/lang/String;
    .param p3, "currentGrantedPermissions"    # I

    .prologue
    .line 198
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 200
    const-string v0, "FB_STATUS"

    const-string v1, "linkWithPM called"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 201
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;

    invoke-direct {v0, p0, p3, p1, p2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;-><init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;ILjava/lang/String;Ljava/lang/String;)V

    invoke-static {p1, p2, v0}, Lcom/poshmark/http/api/PMApi;->fbLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 226
    return-void
.end method

.method public logout()V
    .locals 1

    .prologue
    .line 243
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/login/LoginManager;->logOut()V

    .line 244
    return-void
.end method

.method public refreshAndSyncFbTokenState()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 408
    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v1

    .line 409
    .local v1, "token":Lcom/facebook/AccessToken;
    if-nez v1, :cond_1

    .line 411
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->createTokenFromPMData()Lcom/facebook/AccessToken;

    move-result-object v0

    .line 412
    .local v0, "pmToken":Lcom/facebook/AccessToken;
    if-eqz v0, :cond_0

    .line 413
    invoke-static {v0}, Lcom/facebook/AccessToken;->setCurrentAccessToken(Lcom/facebook/AccessToken;)V

    .line 414
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 415
    invoke-static {}, Lcom/facebook/AccessToken;->refreshCurrentAccessTokenAsync()V

    .line 421
    .end local v0    # "pmToken":Lcom/facebook/AccessToken;
    :cond_0
    :goto_0
    return-void

    .line 418
    :cond_1
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 419
    invoke-static {}, Lcom/facebook/AccessToken;->refreshCurrentAccessTokenAsync()V

    goto :goto_0
.end method
