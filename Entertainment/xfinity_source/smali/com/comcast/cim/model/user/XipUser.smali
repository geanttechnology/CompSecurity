.class public Lcom/comcast/cim/model/user/XipUser;
.super Ljava/lang/Object;
.source "XipUser.java"

# interfaces
.implements Lcom/comcast/cim/model/user/User;


# instance fields
.field private authKeys:Lcom/comcast/cim/model/user/AuthKeys;

.field private greetingName:Ljava/lang/String;

.field private userName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 1
    .param p1, "userCredentials"    # Lcom/comcast/cim/android/authentication/UserCredentials;
    .param p2, "keys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/UserCredentials;->getUsername()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->userName:Ljava/lang/String;

    .line 15
    invoke-virtual {p2}, Lcom/comcast/cim/model/user/AuthKeys;->getGreetingName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->greetingName:Ljava/lang/String;

    .line 16
    iput-object p2, p0, Lcom/comcast/cim/model/user/XipUser;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    .line 17
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 39
    if-ne p0, p1, :cond_1

    .line 46
    :cond_0
    :goto_0
    return v1

    .line 40
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 42
    check-cast v0, Lcom/comcast/cim/model/user/XipUser;

    .line 44
    .local v0, "user":Lcom/comcast/cim/model/user/XipUser;
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    goto :goto_0

    :cond_4
    invoke-virtual {v0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    return-object v0
.end method

.method public getGreetingName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->greetingName:Ljava/lang/String;

    return-object v0
.end method

.method public getOmnitureTrackingKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    if-nez v0, :cond_0

    .line 62
    const/4 v0, 0x0

    .line 65
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getOmnitureTrackingKey()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUserKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->userName:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->userName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/model/user/XipUser;->getUserKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setAuthKeys(Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 1
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/comcast/cim/model/user/XipUser;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    .line 29
    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getGreetingName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/user/XipUser;->userName:Ljava/lang/String;

    .line 30
    return-void
.end method
