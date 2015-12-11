.class public Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;
.super Ljava/lang/Object;
.source "PlayerAuthenticationStrategy.java"

# interfaces
.implements Lcom/comcast/cim/android/authentication/AuthenticationStrategy;


# instance fields
.field private final userManager:Lcom/comcast/cim/model/user/UserManager;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/UserManager;)V
    .locals 0
    .param p1, "userManager"    # Lcom/comcast/cim/model/user/UserManager;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 11
    return-void
.end method


# virtual methods
.method public getAuthenticationActivityClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;

    return-object v0
.end method

.method public isAuthenticated()Z
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
