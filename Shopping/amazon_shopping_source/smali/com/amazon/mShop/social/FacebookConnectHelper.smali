.class public Lcom/amazon/mShop/social/FacebookConnectHelper;
.super Ljava/lang/Object;
.source "FacebookConnectHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;
    }
.end annotation


# static fields
.field protected static final DEBUG_ENABLED:Z


# instance fields
.field private callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

.field private context:Landroid/content/Context;

.field private publishPermissions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private readPermissions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/social/FacebookConnectHelper;->DEBUG_ENABLED:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->readPermissions:Ljava/util/List;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->publishPermissions:Ljava/util/List;

    .line 148
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/social/FacebookConnectHelper;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/social/FacebookConnectHelper;
    .param p1, "x1"    # Lcom/facebook/Session;
    .param p2, "x2"    # Lcom/facebook/SessionState;
    .param p3, "x3"    # Ljava/lang/Exception;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/social/FacebookConnectHelper;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    return-void
.end method

.method private onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 4
    .param p1, "session"    # Lcom/facebook/Session;
    .param p2, "state"    # Lcom/facebook/SessionState;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 109
    sget-boolean v1, Lcom/amazon/mShop/social/FacebookConnectHelper;->DEBUG_ENABLED:Z

    if-eqz v1, :cond_0

    .line 110
    const-string/jumbo v1, "FacebookConnectActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Facebook session state changed: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/facebook/Session;->getDeclinedPermissions()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    :cond_0
    if-eqz p3, :cond_1

    .line 114
    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    invoke-virtual {p3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->executeFailureCallback(Ljava/lang/String;)V

    .line 117
    :cond_1
    sget-object v1, Lcom/facebook/SessionState;->OPENED:Lcom/facebook/SessionState;

    invoke-virtual {v1, p2}, Lcom/facebook/SessionState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 118
    invoke-virtual {p1}, Lcom/facebook/Session;->getDeclinedPermissions()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 120
    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    const-string/jumbo v2, "PERMISSIONS_DENIED"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->executeFailureCallback(Ljava/lang/String;)V

    .line 141
    :cond_2
    :goto_0
    return-void

    .line 121
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->publishPermissions:Ljava/util/List;

    invoke-virtual {p1}, Lcom/facebook/Session;->getPermissions()Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/facebook/internal/Utility;->isSubset(Ljava/util/Collection;Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 124
    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    invoke-virtual {p1}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->executeSuccessCallback(Ljava/lang/String;)V

    goto :goto_0

    .line 127
    :cond_4
    new-instance v0, Lcom/facebook/Session$NewPermissionsRequest;

    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->context:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->publishPermissions:Ljava/util/List;

    invoke-direct {v0, v1, v2}, Lcom/facebook/Session$NewPermissionsRequest;-><init>(Landroid/app/Activity;Ljava/util/List;)V

    .line 128
    .local v0, "newPermissionsRequest":Lcom/facebook/Session$NewPermissionsRequest;
    new-instance v1, Lcom/amazon/mShop/social/FacebookConnectHelper$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/social/FacebookConnectHelper$2;-><init>(Lcom/amazon/mShop/social/FacebookConnectHelper;)V

    invoke-virtual {v0, v1}, Lcom/facebook/Session$NewPermissionsRequest;->setCallback(Lcom/facebook/Session$StatusCallback;)Lcom/facebook/Session$NewPermissionsRequest;

    .line 134
    invoke-virtual {p1, v0}, Lcom/facebook/Session;->requestNewPublishPermissions(Lcom/facebook/Session$NewPermissionsRequest;)V

    goto :goto_0

    .line 137
    .end local v0    # "newPermissionsRequest":Lcom/facebook/Session$NewPermissionsRequest;
    :cond_5
    sget-object v1, Lcom/facebook/SessionState;->OPENED_TOKEN_UPDATED:Lcom/facebook/SessionState;

    invoke-virtual {v1, p2}, Lcom/facebook/SessionState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 139
    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    invoke-virtual {p1}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->executeSuccessCallback(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public launchFacebookLogin(Lcom/amazon/mShop/web/MShopWebView;Landroid/os/Bundle;Landroid/content/Context;)V
    .locals 12
    .param p1, "webView"    # Lcom/amazon/mShop/web/MShopWebView;
    .param p2, "bundle"    # Landroid/os/Bundle;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    iput-object p3, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->context:Landroid/content/Context;

    .line 58
    const/4 v10, 0x1

    invoke-static {v10}, Lcom/facebook/Settings;->setPlatformCompatibilityEnabled(Z)V

    .line 60
    const-string/jumbo v10, "permissions"

    invoke-virtual {p2, v10}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 61
    .local v6, "permissionString":Ljava/lang/String;
    const-string/jumbo v10, "appID"

    invoke-virtual {p2, v10}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 62
    .local v2, "fbApplicationId":Ljava/lang/String;
    const-string/jumbo v10, "successCallback"

    invoke-virtual {p2, v10}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 63
    .local v9, "successCallback":Ljava/lang/String;
    const-string/jumbo v10, "failureCallback"

    invoke-virtual {p2, v10}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 66
    .local v1, "failureCallback":Ljava/lang/String;
    new-instance v10, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    invoke-direct {v10, p0, p1, v9, v1}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;-><init>(Lcom/amazon/mShop/social/FacebookConnectHelper;Lcom/amazon/mShop/web/MShopWebView;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v10, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    .line 71
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectHelper;->isFacebookSDKLoaded()Z

    move-result v10

    if-nez v10, :cond_0

    .line 72
    iget-object v10, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->callback:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    const-string/jumbo v11, "FB_SDK_LOAD_FAILED"

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->executeFailureCallback(Ljava/lang/String;)V

    .line 104
    .end local p3    # "context":Landroid/content/Context;
    :goto_0
    return-void

    .line 78
    .restart local p3    # "context":Landroid/content/Context;
    :cond_0
    const-string/jumbo v10, ","

    invoke-virtual {v6, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 79
    .local v5, "permissionArray":[Ljava/lang/String;
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_2

    aget-object v8, v0, v3

    .line 80
    .local v8, "string":Ljava/lang/String;
    invoke-static {v8}, Lcom/facebook/Session;->isPublishPermission(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 81
    iget-object v10, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->publishPermissions:Ljava/util/List;

    invoke-interface {v10, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 79
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 83
    :cond_1
    iget-object v10, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->readPermissions:Ljava/util/List;

    invoke-interface {v10, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 88
    .end local v8    # "string":Ljava/lang/String;
    :cond_2
    new-instance v10, Lcom/facebook/Session$Builder;

    invoke-direct {v10, p3}, Lcom/facebook/Session$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v10, v2}, Lcom/facebook/Session$Builder;->setApplicationId(Ljava/lang/String;)Lcom/facebook/Session$Builder;

    move-result-object v10

    invoke-virtual {v10}, Lcom/facebook/Session$Builder;->build()Lcom/facebook/Session;

    move-result-object v7

    .line 91
    .local v7, "session":Lcom/facebook/Session;
    invoke-virtual {v7}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v10

    sget-object v11, Lcom/facebook/SessionState;->CREATED_TOKEN_LOADED:Lcom/facebook/SessionState;

    if-ne v10, v11, :cond_3

    .line 92
    invoke-virtual {v7}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    .line 93
    new-instance v10, Lcom/facebook/Session$Builder;

    invoke-direct {v10, p3}, Lcom/facebook/Session$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v10, v2}, Lcom/facebook/Session$Builder;->setApplicationId(Ljava/lang/String;)Lcom/facebook/Session$Builder;

    move-result-object v10

    invoke-virtual {v10}, Lcom/facebook/Session$Builder;->build()Lcom/facebook/Session;

    move-result-object v7

    .line 95
    :cond_3
    invoke-static {v7}, Lcom/facebook/Session;->setActiveSession(Lcom/facebook/Session;)V

    .line 98
    new-instance v10, Lcom/facebook/Session$OpenRequest;

    check-cast p3, Landroid/app/Activity;

    .end local p3    # "context":Landroid/content/Context;
    invoke-direct {v10, p3}, Lcom/facebook/Session$OpenRequest;-><init>(Landroid/app/Activity;)V

    new-instance v11, Lcom/amazon/mShop/social/FacebookConnectHelper$1;

    invoke-direct {v11, p0}, Lcom/amazon/mShop/social/FacebookConnectHelper$1;-><init>(Lcom/amazon/mShop/social/FacebookConnectHelper;)V

    invoke-virtual {v10, v11}, Lcom/facebook/Session$OpenRequest;->setCallback(Lcom/facebook/Session$StatusCallback;)Lcom/facebook/Session$OpenRequest;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/mShop/social/FacebookConnectHelper;->readPermissions:Ljava/util/List;

    invoke-virtual {v10, v11}, Lcom/facebook/Session$OpenRequest;->setPermissions(Ljava/util/List;)Lcom/facebook/Session$OpenRequest;

    move-result-object v10

    invoke-virtual {v7, v10}, Lcom/facebook/Session;->openForRead(Lcom/facebook/Session$OpenRequest;)V

    goto :goto_0
.end method
