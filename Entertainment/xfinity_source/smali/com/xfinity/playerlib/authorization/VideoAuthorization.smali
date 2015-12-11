.class public Lcom/xfinity/playerlib/authorization/VideoAuthorization;
.super Ljava/lang/Object;
.source "VideoAuthorization.java"


# instance fields
.field private final deviceAuthorizationToken:Ljava/lang/String;

.field private final deviceId:Ljava/lang/String;

.field private final devicePlaybackToken:Ljava/lang/String;

.field private final sessionToken:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceAuthorizationToken"    # Ljava/lang/String;
    .param p2, "deviceId"    # Ljava/lang/String;
    .param p3, "sessionToken"    # Ljava/lang/String;
    .param p4, "devicePlaybackToken"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->deviceAuthorizationToken:Ljava/lang/String;

    .line 12
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->deviceId:Ljava/lang/String;

    .line 13
    iput-object p3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->sessionToken:Ljava/lang/String;

    .line 14
    iput-object p4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->devicePlaybackToken:Ljava/lang/String;

    .line 15
    return-void
.end method


# virtual methods
.method public getDeviceAuthorizationToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->deviceAuthorizationToken:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getDevicePlaybackToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->devicePlaybackToken:Ljava/lang/String;

    return-object v0
.end method

.method public getSessionToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->sessionToken:Ljava/lang/String;

    return-object v0
.end method
