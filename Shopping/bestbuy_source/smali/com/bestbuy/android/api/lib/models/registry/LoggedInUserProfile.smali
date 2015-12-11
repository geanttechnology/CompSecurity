.class public Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private access_token:Ljava/lang/String;

.field private entities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entity;",
            ">;"
        }
    .end annotation
.end field

.field private errorCode:Ljava/lang/String;

.field private expires_in:Ljava/lang/String;

.field private hasError:Z

.field private hasWeddingRegistry:Z

.field private isAttachedUser:Z

.field private refreshToken:Ljava/lang/String;

.field private registry:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isAttachedUser:Z

    return-void
.end method


# virtual methods
.method public getAccess_token()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->access_token:Ljava/lang/String;

    return-object v0
.end method

.method public getEntities()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->entities:Ljava/util/List;

    return-object v0
.end method

.method public getErrorCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->errorCode:Ljava/lang/String;

    return-object v0
.end method

.method public getExpires_in()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->expires_in:Ljava/lang/String;

    return-object v0
.end method

.method public getRefreshToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->refreshToken:Ljava/lang/String;

    return-object v0
.end method

.method public getRegistry()Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->registry:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method public isAttachedUser()Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isAttachedUser:Z

    return v0
.end method

.method public isHasError()Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->hasError:Z

    return v0
.end method

.method public isHasWeddingRegistry()Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->hasWeddingRegistry:Z

    return v0
.end method

.method public setAccess_token(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->access_token:Ljava/lang/String;

    .line 125
    return-void
.end method

.method public setAttachedUser(Z)V
    .locals 0

    .prologue
    .line 112
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isAttachedUser:Z

    .line 113
    return-void
.end method

.method public setEntities(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->entities:Ljava/util/List;

    .line 40
    return-void
.end method

.method public setErrorCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->errorCode:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setExpires_in(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->expires_in:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setHasError(Z)V
    .locals 0

    .prologue
    .line 75
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->hasError:Z

    .line 76
    return-void
.end method

.method public setHasWeddingRegistry(Z)V
    .locals 0

    .prologue
    .line 63
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->hasWeddingRegistry:Z

    .line 64
    return-void
.end method

.method public setRefreshToken(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->refreshToken:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setRegistry(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->registry:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 101
    return-void
.end method
