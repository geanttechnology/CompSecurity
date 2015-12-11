.class public final Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
.super Ljava/lang/Object;
.source "AuthenticationMethodFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory$1;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDirectedId:Ljava/lang/String;

.field private mPackageName:Ljava/lang/String;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 36
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 48
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    .line 50
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 55
    return-void
.end method

.method private useCentralService()Z
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 159
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->hasCentralApk()Z

    move-result v4

    if-nez v4, :cond_1

    .line 200
    :cond_0
    :goto_0
    return v2

    .line 165
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isOtter()Z

    move-result v4

    if-nez v4, :cond_0

    .line 173
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 175
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isLocalApplicationUsingDeviceCredentials(Landroid/content/Context;)Z

    move-result v2

    goto :goto_0

    .line 180
    :cond_2
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    if-nez v4, :cond_3

    move v2, v3

    .line 182
    goto :goto_0

    .line 185
    :cond_3
    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v1

    .line 186
    .local v1, "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-nez v1, :cond_4

    .line 188
    new-instance v4, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v5, "Cannot sign request with %s credentials since it is not a map application"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    aput-object v6, v3, v2

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 194
    :cond_4
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 196
    :catch_0
    move-exception v0

    .line 198
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v3, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Couldn\'t determine device type for "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .locals 4
    .param p1, "authType"    # Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .prologue
    .line 75
    if-nez p1, :cond_0

    .line 77
    const/4 v0, 0x0

    .line 86
    :goto_0
    return-object v0

    .line 80
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->useCentralService()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 82
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory$1;->$SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType:[I

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    new-instance v0, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    :pswitch_0
    new-instance v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p1}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    goto :goto_0

    .line 86
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory$1;->$SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType:[I

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_1

    new-instance v0, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    :pswitch_1
    new-instance v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, p1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    goto :goto_0

    :pswitch_2
    new-instance v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, p1}, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    goto :goto_0

    .line 82
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch

    .line 86
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public newAuthenticationMethod(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .locals 5
    .param p1, "authTypeString"    # Ljava/lang/String;

    .prologue
    .line 121
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->parse(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-result-object v0

    .line 123
    .local v0, "authType":Lcom/amazon/identity/auth/device/api/AuthenticationType;
    if-eqz v0, :cond_0

    .line 125
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v1

    .line 134
    :goto_0
    return-object v1

    .line 128
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->useCentralService()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 130
    new-instance v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    invoke-direct {v1, v2, v3, p1}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 134
    :cond_1
    const-string/jumbo v1, "BustedIdentityADPAuthenticator"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    new-instance v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mDirectedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4, p1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const-string/jumbo v1, "Authentication Type %s is not supported on this build"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v2, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->mPackageName:Ljava/lang/String;

    .line 66
    return-void
.end method
