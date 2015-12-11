.class public Lcom/poshmark/user/UserInfo;
.super Ljava/lang/Object;
.source "UserInfo.java"


# instance fields
.field access_token:Ljava/lang/String;

.field created_at:I

.field expires_at:Ljava/lang/String;

.field generation:I

.field public user:Lcom/poshmark/user/UserInfoDetails;

.field user_status:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/poshmark/user/UserInfo;->access_token:Ljava/lang/String;

    return-object v0
.end method

.method public getInfoDetails()Lcom/poshmark/user/UserInfoDetails;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/user/UserInfo;->user:Lcom/poshmark/user/UserInfoDetails;

    return-object v0
.end method

.method public getUserCreatedApiVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    return-object v0
.end method

.method public getUserCreatedAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    return-object v0
.end method
