.class public Lfr;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a()V
    .locals 2

    .prologue
    .line 69
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 70
    if-eqz v0, :cond_0

    .line 71
    const-string v1, "user_profile"

    invoke-virtual {v0, v1}, Lfo;->a(Ljava/lang/String;)I

    .line 72
    :cond_0
    return-void
.end method

.method public static a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V
    .locals 5

    .prologue
    .line 17
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 19
    :try_start_0
    invoke-virtual {v1}, Lfo;->c()V

    .line 20
    invoke-static {}, Lfr;->a()V

    .line 21
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 22
    const-string v3, "uuid"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getUuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    const-string v3, "type"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    const-string v3, "created"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getCreated()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    const-string v3, "modified"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getModified()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    const-string v3, "username"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getUsername()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    const-string v3, "activated"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getActivated()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    const-string v3, "invalidLogins"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getLocked()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    const-string v3, "transient"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getTransientValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    const-string v3, "firstName"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    const-string v3, "lastName"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getLastName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    const-string v3, "lockedAt"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getLockedAt()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    const-string v3, "postalCode"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const-string v3, "rzLinkStatus"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzLinkStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    const-string v3, "rzMemberId"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzMemberId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v3, "rzStatus"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    const-string v3, "rzTierStatus"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v0, "access_token"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getAccess_token()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    const-string v3, "expires_in"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getExpires_in()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string v0, "cg_token"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getAccess_token()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string v0, "cg_expires_in"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getExpires_in()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    const-string v0, "has_registry"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isHasWeddingRegistry()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    const-string v3, "points_balance"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getPointsBalance()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const-string v3, "certs_value"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getCertTotalAvailableValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    const-string v3, "rz_member_id"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzMemberId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    const-string v3, "rz_tier_status"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzTierStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    const-string v3, "rz_status"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const-string v0, "is_attached_user"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isAttachedUser()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getRegistry()Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 50
    const-string v0, "registry_name"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getRegistry()Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    :cond_0
    if-eqz v1, :cond_1

    .line 52
    const-string v0, "user_profile"

    invoke-virtual {v1, v0, v2}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 54
    :cond_1
    invoke-virtual {v1}, Lfo;->d()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 59
    invoke-virtual {v1}, Lfo;->e()V

    .line 62
    :goto_0
    return-void

    .line 55
    :catch_0
    move-exception v0

    .line 56
    :try_start_1
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 59
    invoke-virtual {v1}, Lfo;->e()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Lfo;->e()V

    throw v0
.end method

.method public static a(Ljava/lang/String;)Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 187
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v2

    .line 188
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v3

    .line 189
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 190
    const-string v5, "has_registry"

    invoke-virtual {v4, v5, p0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string v5, "user_profile"

    const-string v6, "firstName=?"

    new-array v7, v0, [Ljava/lang/String;

    aput-object v2, v7, v1

    invoke-virtual {v3, v5, v4, v6, v7}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static b()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 90
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 91
    if-eqz v1, :cond_0

    .line 92
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "access_token"

    aput-object v3, v2, v4

    .line 93
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 94
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 95
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "access_token"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 98
    :cond_0
    return-object v0
.end method

.method public static b(Ljava/lang/String;)Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 195
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    .line 196
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v3

    .line 197
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 198
    const-string v5, "registry_name"

    invoke-virtual {v4, v5, p0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    const-string v5, "user_profile"

    const-string v6, "username=?"

    new-array v7, v0, [Ljava/lang/String;

    aput-object v2, v7, v1

    invoke-virtual {v3, v5, v4, v6, v7}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static c()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 106
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 107
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "username"

    aput-object v3, v2, v4

    .line 109
    if-eqz v1, :cond_0

    .line 110
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 111
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 112
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "username"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 115
    :cond_0
    return-object v0
.end method

.method public static d()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 123
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 124
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "uuid"

    aput-object v3, v2, v4

    .line 126
    if-eqz v1, :cond_0

    .line 127
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 128
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 129
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 132
    :cond_0
    return-object v0
.end method

.method public static e()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 140
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 141
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "firstName"

    aput-object v3, v2, v4

    .line 143
    if-eqz v1, :cond_0

    .line 144
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 145
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 146
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "firstName"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 149
    :cond_0
    return-object v0
.end method

.method public static f()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 157
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 158
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "lastName"

    aput-object v3, v2, v4

    .line 160
    if-eqz v1, :cond_0

    .line 161
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 162
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 163
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "lastName"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 166
    :cond_0
    return-object v0
.end method

.method public static g()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 174
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 175
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "has_registry"

    aput-object v3, v2, v4

    .line 177
    if-eqz v1, :cond_0

    .line 178
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 179
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 180
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "has_registry"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 183
    :cond_0
    return-object v0
.end method

.method public static h()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 207
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 208
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "points_balance"

    aput-object v3, v2, v4

    .line 210
    if-eqz v1, :cond_0

    .line 211
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 212
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 213
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "points_balance"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 216
    :cond_0
    return-object v0
.end method

.method public static i()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 224
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 225
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "certs_value"

    aput-object v3, v2, v4

    .line 227
    if-eqz v1, :cond_0

    .line 228
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 229
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 230
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "certs_value"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 233
    :cond_0
    return-object v0
.end method

.method public static j()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 258
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 259
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "rz_tier_status"

    aput-object v3, v2, v4

    .line 261
    if-eqz v1, :cond_0

    .line 262
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 263
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 264
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "rz_tier_status"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 267
    :cond_0
    return-object v0
.end method

.method public static k()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 292
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 293
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "registry_name"

    aput-object v3, v2, v4

    .line 295
    if-eqz v1, :cond_0

    .line 296
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v0, v0}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 297
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 298
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "registry_name"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 301
    :cond_0
    return-object v0
.end method

.method public static l()Z
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 305
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v1

    .line 306
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "is_attached_user"

    aput-object v3, v2, v0

    .line 308
    if-eqz v1, :cond_0

    .line 309
    const-string v3, "user_profile"

    invoke-virtual {v1, v3, v2, v4, v4}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 310
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 311
    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "is_attached_user"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 312
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 315
    :cond_0
    return v0
.end method
