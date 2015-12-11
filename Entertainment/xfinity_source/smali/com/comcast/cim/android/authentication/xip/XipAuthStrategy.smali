.class public abstract Lcom/comcast/cim/android/authentication/xip/XipAuthStrategy;
.super Ljava/lang/Object;
.source "XipAuthStrategy.java"

# interfaces
.implements Lcom/comcast/cim/android/authentication/AuthenticationStrategy;


# instance fields
.field private final userManager:Lcom/comcast/cim/model/user/UserManager;


# virtual methods
.method public isAuthenticated()Z
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/xip/XipAuthStrategy;->userManager:Lcom/comcast/cim/model/user/UserManager;

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
