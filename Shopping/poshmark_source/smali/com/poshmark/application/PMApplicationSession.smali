.class public Lcom/poshmark/application/PMApplicationSession;
.super Ljava/lang/Object;
.source "PMApplicationSession.java"


# static fields
.field static session:Lcom/poshmark/application/PMApplicationSession;


# instance fields
.field fbPrefs:Landroid/content/SharedPreferences;

.field fb_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field gpPrefs:Landroid/content/SharedPreferences;

.field isLoggedIn:Z

.field ptPrefs:Landroid/content/SharedPreferences;

.field tmPrefs:Landroid/content/SharedPreferences;

.field tm_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field twPrefs:Landroid/content/SharedPreferences;

.field tw_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field userPrefs:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/application/PMApplicationSession;->session:Lcom/poshmark/application/PMApplicationSession;

    return-void
.end method

.method constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-boolean v4, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    .line 47
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "userPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    .line 50
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "fbPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    .line 53
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "gpPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    .line 56
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "twPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    .line 59
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "tmPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    .line 62
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "ptPrefs"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    .line 66
    iget-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v2, "accessToken"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "accessToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 69
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    .line 74
    :goto_0
    return-void

    .line 71
    :cond_0
    iput-boolean v4, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    goto :goto_0
.end method

.method public static GetPMSession()Lcom/poshmark/application/PMApplicationSession;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/poshmark/application/PMApplicationSession;->session:Lcom/poshmark/application/PMApplicationSession;

    if-nez v0, :cond_0

    .line 24
    new-instance v0, Lcom/poshmark/application/PMApplicationSession;

    invoke-direct {v0}, Lcom/poshmark/application/PMApplicationSession;-><init>()V

    sput-object v0, Lcom/poshmark/application/PMApplicationSession;->session:Lcom/poshmark/application/PMApplicationSession;

    .line 26
    :cond_0
    sget-object v0, Lcom/poshmark/application/PMApplicationSession;->session:Lcom/poshmark/application/PMApplicationSession;

    return-object v0
.end method

.method private hasFbTokenExpired()Z
    .locals 8

    .prologue
    .line 77
    const/4 v4, 0x0

    .line 78
    .local v4, "retVal":Z
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 79
    .local v0, "currentDate":Ljava/util/Date;
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplicationSession;->getFacebookTokenExpirationDate()Ljava/util/Date;

    move-result-object v1

    .line 80
    .local v1, "date":Ljava/util/Date;
    if-eqz v1, :cond_0

    .line 81
    sget-object v5, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->DAYS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v0, v1, v5}, Lcom/poshmark/utils/DateUtils;->getDiffBetweenDates(Ljava/util/Date;Ljava/util/Date;Lcom/poshmark/utils/DateUtils$TIME_UNIT;)J

    move-result-wide v2

    .line 82
    .local v2, "daysToGo":J
    const-wide/16 v6, 0xa

    cmp-long v5, v2, v6

    if-gtz v5, :cond_0

    .line 83
    const/4 v4, 0x1

    .line 86
    .end local v2    # "daysToGo":J
    :cond_0
    return v4
.end method


# virtual methods
.method public canPerformActionForRole(Ljava/lang/String;)Z
    .locals 1
    .param p1, "role"    # Ljava/lang/String;

    .prologue
    .line 204
    const/4 v0, 0x0

    return v0
.end method

.method public clearFacebookInfo()V
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 301
    return-void
.end method

.method public clearGoogleInfo()V
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 343
    return-void
.end method

.method public clearPinterestInfo()V
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 437
    return-void
.end method

.method public clearTumblrInfo()V
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 379
    return-void
.end method

.method public clearTwitterInfo()V
    .locals 1

    .prologue
    .line 241
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 242
    return-void
.end method

.method public getAccessToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 164
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "accessToken"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDevIP()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 508
    sget-object v2, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v3, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-ne v2, v3, :cond_0

    .line 509
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "DEV"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 511
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    const-string v2, "IP"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 513
    .end local v0    # "regInfo":Landroid/content/SharedPreferences;
    :cond_0
    return-object v1
.end method

.method public getDisplayHandle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 184
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "displayHandle"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFacebookInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 268
    new-instance v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/ExternalServiceInfo;-><init>()V

    .line 269
    .local v0, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplicationSession;->getFacebookToken()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    .line 270
    iget-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v2, "ext_token_expr"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    .line 271
    iget-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v2, "ext_user_id"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    .line 272
    new-instance v1, Lcom/poshmark/data_model/models/ExternalPermissions;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/ExternalPermissions;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    .line 274
    iget-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v3, "email_permission"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->email:I

    .line 275
    iget-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v3, "public_profile_permission"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->public_profile:I

    .line 276
    iget-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v3, "user_friends_permission"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->user_friends:I

    .line 277
    iget-object v1, v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v3, "publish_actions_permission"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lcom/poshmark/data_model/models/ExternalPermissions;->publish_actions:I

    .line 278
    return-object v0
.end method

.method public getFacebookSharingFlag()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 282
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v1, "fb_sharing"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public getFacebookToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 260
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_access_token"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFacebookTokenExpirationDate()Ljava/util/Date;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 286
    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v3, "ext_token_expr"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 287
    .local v0, "date":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 289
    invoke-static {v0}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 292
    :cond_0
    return-object v1
.end method

.method public getFacebookUserId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 264
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_user_id"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 188
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "firstName"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 192
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v2, "firstName"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v2, "lastName"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getGCMAppVersion()Ljava/lang/String;
    .locals 4

    .prologue
    .line 454
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 457
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    const-string v1, "GCMAppVersion"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getGCMLastRegisteredTime()Ljava/util/Date;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 467
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 470
    .local v2, "regInfo":Landroid/content/SharedPreferences;
    const-string v3, "GCMLastRegisteredTime"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 471
    .local v0, "date":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 473
    invoke-static {v0}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 476
    :cond_0
    return-object v1
.end method

.method public getGCMRegId()Ljava/lang/String;
    .locals 4

    .prologue
    .line 441
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 444
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    const-string v1, "GCMRegId"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getGCMRegIdSentFlag()Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 494
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 496
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    const-string v1, "GCMRegIdSentFlag"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    return v1
.end method

.method public getGoogleSharingFlag()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 324
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    const-string v1, "gp_sharing"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public getGoogleToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 316
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_access_token"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getGoogleTokenExpirationDate()Ljava/util/Date;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 328
    iget-object v2, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    const-string v3, "ext_token_expr"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 329
    .local v0, "date":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 331
    invoke-static {v0}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 334
    :cond_0
    return-object v1
.end method

.method public getGoogleUserId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 320
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_user_id"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPicUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 180
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "picUrl"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPinterestSharingFlag()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 411
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    const-string v1, "pin_sharing"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public getPinterestToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 393
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_access_token"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPinterestUserName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 407
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_username"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTumblrSharingFlag()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 366
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    const-string v1, "tm_sharing"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public getTumblrToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 358
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_access_token"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTumblrUsername()Ljava/lang/String;
    .locals 3

    .prologue
    .line 362
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_username"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTwitterSharingFlag()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 233
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    const-string v1, "tw_sharing"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public getTwitterToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 225
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_access_token"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTwitterUsername()Ljava/lang/String;
    .locals 3

    .prologue
    .line 229
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    const-string v1, "ext_username"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserABSegment()Ljava/lang/String;
    .locals 3

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "absegment"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 176
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "id"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 374
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "username"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isLoggedIn()Z
    .locals 1

    .prologue
    .line 147
    iget-boolean v0, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    return v0
.end method

.method public isPinterestPostDialogShown()Z
    .locals 3

    .prologue
    .line 428
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "pin_post_dialog"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isPinterestPreDialogShown()Z
    .locals 3

    .prologue
    .line 420
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "pin_pre_dialog"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isUserAdmin()Z
    .locals 3

    .prologue
    .line 208
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    const-string v1, "isAdmin"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public logout()V
    .locals 1

    .prologue
    .line 151
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    .line 154
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 155
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 156
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 157
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 158
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 159
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 160
    return-void
.end method

.method public saveSession(Lcom/poshmark/user/UserInfo;)V
    .locals 3
    .param p1, "userInfo"    # Lcom/poshmark/user/UserInfo;

    .prologue
    .line 92
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfo;->getInfoDetails()Lcom/poshmark/user/UserInfoDetails;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/application/PMApplicationSession;->updateUserInfo(Lcom/poshmark/user/UserInfoDetails;)V

    .line 94
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "accessToken"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfo;->getAccessToken()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 95
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "createdAppVersion"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfo;->getUserCreatedAppVersion()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 96
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "createdApiVersion "

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfo;->getUserCreatedApiVersion()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 98
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn:Z

    .line 99
    return-void
.end method

.method public setDevIP(Ljava/lang/String;)V
    .locals 4
    .param p1, "ip"    # Ljava/lang/String;

    .prologue
    .line 500
    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-ne v1, v2, :cond_0

    .line 501
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "DEV"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 503
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "IP"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 505
    .end local v0    # "regInfo":Landroid/content/SharedPreferences;
    :cond_0
    return-void
.end method

.method public setFacebookPostToTimelineFlag(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 200
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "postToTimeline"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 201
    return-void
.end method

.method public setFacebookSharingFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "sharingFlag"    # Ljava/lang/Boolean;

    .prologue
    .line 296
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "fb_sharing"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 297
    return-void
.end method

.method public setGCMAppVersion(Ljava/lang/String;)V
    .locals 4
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 461
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 463
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "GCMAppVersion"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 464
    return-void
.end method

.method public setGCMLastRegisteredTime(Ljava/util/Date;)V
    .locals 5
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 481
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 483
    .local v1, "regInfo":Landroid/content/SharedPreferences;
    invoke-static {p1}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 484
    .local v0, "dateString":Ljava/lang/String;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "GCMLastRegisteredTime"

    invoke-interface {v2, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 485
    return-void
.end method

.method public setGCMRegId(Ljava/lang/String;)V
    .locals 4
    .param p1, "regid"    # Ljava/lang/String;

    .prologue
    .line 448
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 450
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "GCMRegId"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 451
    return-void
.end method

.method public setGCMRegIdSentFlag(Z)V
    .locals 4
    .param p1, "b"    # Z

    .prologue
    .line 488
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "GCMInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 490
    .local v0, "regInfo":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "GCMRegIdSentFlag"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 491
    return-void
.end method

.method public setGoogleSharingFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "sharingFlag"    # Ljava/lang/Boolean;

    .prologue
    .line 338
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "gp_sharing"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 339
    return-void
.end method

.method public setPinterestPostDialogShown(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "flag"    # Ljava/lang/Boolean;

    .prologue
    .line 432
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pin_post_dialog"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 433
    return-void
.end method

.method public setPinterestPreDialogShownFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "flag"    # Ljava/lang/Boolean;

    .prologue
    .line 424
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pin_pre_dialog"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 425
    return-void
.end method

.method public setPinterestSharingFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "flag"    # Ljava/lang/Boolean;

    .prologue
    .line 415
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pin_sharing"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 416
    return-void
.end method

.method public setPinterestToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 398
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 399
    return-void
.end method

.method public setPinterestUserName(Ljava/lang/String;)V
    .locals 2
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 403
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 404
    return-void
.end method

.method public setSearchVisibilityFlag(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 196
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "searchVisibility"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 197
    return-void
.end method

.method public setTumblrSharingFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "sharingFlag"    # Ljava/lang/Boolean;

    .prologue
    .line 370
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "tm_sharing"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 371
    return-void
.end method

.method public setTwitterSharingFlag(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "sharingFlag"    # Ljava/lang/Boolean;

    .prologue
    .line 237
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "tw_sharing"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 238
    return-void
.end method

.method public setUserABSegment(Ljava/lang/String;)V
    .locals 2
    .param p1, "segment"    # Ljava/lang/String;

    .prologue
    .line 172
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "absegment"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 173
    return-void
.end method

.method public updateFacebookData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .prologue
    .line 247
    if-eqz p1, :cond_0

    .line 248
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_user_id"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 249
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_token_expr"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 250
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_username:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 251
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 252
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "email_permission"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v2, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->email:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 253
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "public_profile_permission"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v2, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->public_profile:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 254
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "publish_actions_permission"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v2, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->publish_actions:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 255
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->fbPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "user_friends_permission"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_permissions:Lcom/poshmark/data_model/models/ExternalPermissions;

    iget v2, v2, Lcom/poshmark/data_model/models/ExternalPermissions;->user_friends:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 257
    :cond_0
    return-void
.end method

.method public updateGoogleData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .prologue
    .line 306
    if-eqz p1, :cond_0

    .line 307
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_user_id"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 308
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_token_expr"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 309
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_username:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 310
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->gpPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 311
    const-string v0, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 313
    :cond_0
    return-void
.end method

.method public updatePinterestData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .prologue
    .line 384
    if-eqz p1, :cond_0

    .line 385
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_user_id"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 386
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_token_expr"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 387
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_username:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 388
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->ptPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 389
    const-string v0, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 391
    :cond_0
    return-void
.end method

.method public updateTumblrData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .prologue
    .line 348
    if-eqz p1, :cond_0

    .line 349
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_user_id"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 350
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_token_expr"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 351
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_username:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 352
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->tmPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 353
    const-string v0, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 355
    :cond_0
    return-void
.end method

.method public updateTwitterData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .prologue
    .line 215
    if-eqz p1, :cond_0

    .line 216
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_user_id"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_user_id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 217
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_token_expr"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_token_expr:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 218
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_username"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_username:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 219
    iget-object v0, p0, Lcom/poshmark/application/PMApplicationSession;->twPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ext_access_token"

    iget-object v2, p1, Lcom/poshmark/data_model/models/ExternalServiceInfo;->ext_access_token:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 220
    const-string v0, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 222
    :cond_0
    return-void
.end method

.method public updateUserInfo(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 8
    .param p1, "info"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 103
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getFbInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/poshmark/application/PMApplicationSession;->updateFacebookData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 104
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getTwitterInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/poshmark/application/PMApplicationSession;->updateTwitterData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 105
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getTumblrInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/poshmark/application/PMApplicationSession;->updateTumblrData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 106
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getGPInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/poshmark/application/PMApplicationSession;->updateGoogleData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 107
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getPnInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/poshmark/application/PMApplicationSession;->updatePinterestData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 111
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "id"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 113
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "displayHandle"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserDisplayHandle()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 114
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "email"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserEmail()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 115
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "firstName"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserFirstName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 116
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "lastName"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserLastName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 117
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "username"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 118
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "picUrl"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 119
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "shoeSize"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserShoeSize()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 120
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "dressSize"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserDressSize()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 121
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "city"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserCity()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 122
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "state"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserState()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 123
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "website"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserWebsite()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 124
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "username"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 125
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "loginConnectionType"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getUserLoginConnectionType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 126
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "searchVisibility"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getSearchVisibilityFlag()Z

    move-result v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 127
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "postToTimeline"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getPostToTimelineFlag()Z

    move-result v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 128
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "absegment"

    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getABSegment()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 131
    invoke-virtual {p1}, Lcom/poshmark/user/UserInfoDetails;->getRoles()[Ljava/lang/String;

    move-result-object v4

    .line 132
    .local v4, "roles":[Ljava/lang/String;
    const/4 v1, 0x0

    .line 133
    .local v1, "isAdmin":Z
    if-eqz v4, :cond_1

    .line 134
    array-length v2, v4

    .line 135
    .local v2, "numRoles":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_1

    .line 136
    aget-object v3, v4, v0

    .line 137
    .local v3, "role":Ljava/lang/String;
    if-eqz v3, :cond_0

    const-string v5, "admin"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 138
    const/4 v1, 0x1

    .line 135
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 142
    .end local v0    # "i":I
    .end local v2    # "numRoles":I
    .end local v3    # "role":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Lcom/poshmark/application/PMApplicationSession;->userPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "isAdmin"

    invoke-interface {v5, v6, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 144
    return-void
.end method
