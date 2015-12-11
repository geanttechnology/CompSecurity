.class public Lcom/amazon/identity/auth/accounts/SessionUserChanger;
.super Ljava/lang/Object;
.source "SessionUserChanger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 1
    .param p1, "amznAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mListeners:Ljava/util/List;

    .line 32
    return-void
.end method

.method private accountCanBeSessionUser(Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 192
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 197
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isAccountDeregistering(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private changeToSessionUsers(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    .local p1, "newSessionDirectedIdsToAdd":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .local p2, "sessionDirectedIdsToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v3

    if-gtz v3, :cond_0

    invoke-interface {p2}, Ljava/util/Collection;->size()I

    move-result v3

    if-lez v3, :cond_3

    .line 142
    :cond_0
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 144
    .local v2, "newDirectedId":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setAccountAsSessionUser(Ljava/lang/String;)V

    goto :goto_0

    .line 147
    .end local v2    # "newDirectedId":Ljava/lang/String;
    :cond_1
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 149
    .local v0, "directedIdToRemove":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->removeAccountAsSessionUser(Ljava/lang/String;)V

    goto :goto_1

    .line 152
    .end local v0    # "directedIdToRemove":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;

    invoke-interface {v3, p1, p2}, Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;->onChanged(Ljava/util/Collection;Ljava/util/Collection;)V

    goto :goto_2

    .line 156
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    sget-object v3, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "No New Session Users to add"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    :cond_4
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v3

    return-object v3
.end method


# virtual methods
.method public addSessionUsers(Ljava/util/Set;)Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v0

    .line 42
    .local v0, "currentSessionUsersIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 44
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->changeSessionUsers(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    return-object v1
.end method

.method public changeSessionUsers(Ljava/util/Set;)Ljava/util/Set;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 101
    .local p1, "givenSessionDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v0

    .line 103
    .local v0, "currentSessionUsers":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-nez p1, :cond_2

    const/4 v2, 0x0

    .line 104
    .local v2, "newSessionDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    if-eqz v2, :cond_1

    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v5

    if-nez v5, :cond_4

    .line 106
    :cond_1
    sget-object v5, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Cannot remove all session users. Change aborted"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    .end local v0    # "currentSessionUsers":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :goto_0
    return-object v0

    .line 103
    .end local v2    # "newSessionDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v0    # "currentSessionUsers":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_2
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_3
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->accountCanBeSessionUser(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 117
    .restart local v2    # "newSessionDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_4
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v1

    .line 119
    .local v1, "currentSessionUsersDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 120
    .local v3, "newSessionUsersDirectedIdsToAdd":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v3, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 121
    invoke-interface {v3, v1}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 123
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 124
    .local v4, "sessionUsersDirectedIdsToRemove":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v4, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 125
    invoke-interface {v4, v2}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 127
    invoke-direct {p0, v3, v4}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->changeToSessionUsers(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Set;

    move-result-object v0

    goto :goto_0
.end method

.method public onSessionUserDeregistered(Ljava/lang/String;)Ljava/util/Set;
    .locals 6
    .param p1, "directedIdToRemove"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v0, 0x0

    const/4 v4, 0x1

    .line 49
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 51
    sget-object v2, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "%s is not a session user, so nothing to notify about it being deregistered"

    new-array v3, v4, [Ljava/lang/Object;

    aput-object p1, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 53
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v2

    .line 64
    :goto_0
    return-object v2

    .line 56
    :cond_0
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 58
    .local v1, "sessionUserIdsToAdd":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSecondaryAmazonAccount(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 59
    .local v0, "primaryDirectedId":Ljava/lang/String;
    :cond_1
    :goto_1
    if-eqz v0, :cond_2

    .line 61
    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 64
    :cond_2
    new-array v2, v4, [Ljava/lang/String;

    aput-object p1, v2, v5

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ArrayUtil;->asSet([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->changeToSessionUsers(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Set;

    move-result-object v2

    goto :goto_0

    .line 58
    .end local v0    # "primaryDirectedId":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v2

    if-ne v2, v4, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->accountCanBeSessionUser(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    move-object v0, v2

    goto :goto_1
.end method

.method public removeSessionUsers(Ljava/util/Set;)Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    .local p1, "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mAmazonAccountMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v0

    .line 94
    .local v0, "currentSessionDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 96
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->changeSessionUsers(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    return-object v1
.end method

.method public setListener(Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/SessionUserChanger$OnSessionUsersChangedListener;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 37
    return-void
.end method
