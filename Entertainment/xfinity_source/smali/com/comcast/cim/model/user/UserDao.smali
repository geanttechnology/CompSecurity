.class public abstract Lcom/comcast/cim/model/user/UserDao;
.super Ljava/lang/Object;
.source "UserDao.java"

# interfaces
.implements Lcom/comcast/cim/model/services/KeyValueDao;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/model/user/User;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/model/services/KeyValueDao",
        "<",
        "Ljava/lang/String;",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final store:Lcom/comcast/cim/model/services/KeyValueStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/services/KeyValueStore",
            "<",
            "Ljava/lang/String;",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/services/KeyValueStore;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/services/KeyValueStore",
            "<",
            "Ljava/lang/String;",
            "TT;>;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TT;>;"
    .local p1, "store":Lcom/comcast/cim/model/services/KeyValueStore;, "Lcom/comcast/cim/model/services/KeyValueStore<Ljava/lang/String;TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/model/user/UserDao;->store:Lcom/comcast/cim/model/services/KeyValueStore;

    .line 12
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Lcom/comcast/cim/model/user/User;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "this":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserDao;->store:Lcom/comcast/cim/model/services/KeyValueStore;

    invoke-interface {v0, p1}, Lcom/comcast/cim/model/services/KeyValueStore;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/User;

    return-object v0
.end method

.method public put(Lcom/comcast/cim/model/user/User;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TT;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    invoke-interface {p1}, Lcom/comcast/cim/model/user/User;->getUserKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/model/user/UserDao;->put(Ljava/lang/String;Lcom/comcast/cim/model/user/User;)V

    .line 28
    return-void
.end method

.method public put(Ljava/lang/String;Lcom/comcast/cim/model/user/User;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "TT;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/model/user/UserDao;, "Lcom/comcast/cim/model/user/UserDao<TT;>;"
    .local p2, "value":Lcom/comcast/cim/model/user/User;, "TT;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/UserDao;->store:Lcom/comcast/cim/model/services/KeyValueStore;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/model/services/KeyValueStore;->put(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 16
    return-void
.end method
