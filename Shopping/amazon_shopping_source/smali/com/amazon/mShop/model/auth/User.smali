.class public Lcom/amazon/mShop/model/auth/User;
.super Ljava/lang/Object;
.source "User.java"


# static fields
.field private static volatile sUser:Lcom/amazon/mShop/model/auth/User;

.field private static final sUserListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/amazon/mShop/model/auth/UserListener;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private mCharity:Ljava/lang/String;

.field private final mDob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

.field private final mEmail:Ljava/lang/String;

.field private final mFullName:Ljava/lang/String;

.field private mIsPrimeEligible:Z

.field private mOneClick:Z

.field private mPrime:Z

.field private mPrimeFunnelUrl:Ljava/lang/String;

.field private mSmile:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 417
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V
    .locals 10
    .param p1, "email"    # Ljava/lang/String;
    .param p2, "fullName"    # Ljava/lang/String;
    .param p3, "prime"    # Z
    .param p4, "oneClick"    # Z
    .param p5, "dob"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .param p6, "isPrimeEligible"    # Ljava/lang/Boolean;
    .param p7, "primeFunnelUrl"    # Ljava/lang/String;

    .prologue
    .line 439
    const-string/jumbo v8, ""

    const/4 v9, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 440
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1
    .param p1, "email"    # Ljava/lang/String;
    .param p2, "fullName"    # Ljava/lang/String;
    .param p3, "prime"    # Z
    .param p4, "oneClick"    # Z
    .param p5, "dob"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .param p6, "isPrimeEligible"    # Ljava/lang/Boolean;
    .param p7, "primeFunnelUrl"    # Ljava/lang/String;
    .param p8, "charityName"    # Ljava/lang/String;
    .param p9, "isSmile"    # Z

    .prologue
    .line 450
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 451
    iput-object p1, p0, Lcom/amazon/mShop/model/auth/User;->mEmail:Ljava/lang/String;

    .line 452
    if-nez p2, :cond_0

    const-string/jumbo p2, ""

    .end local p2    # "fullName":Ljava/lang/String;
    :cond_0
    iput-object p2, p0, Lcom/amazon/mShop/model/auth/User;->mFullName:Ljava/lang/String;

    .line 453
    iput-boolean p3, p0, Lcom/amazon/mShop/model/auth/User;->mPrime:Z

    .line 454
    iput-boolean p4, p0, Lcom/amazon/mShop/model/auth/User;->mOneClick:Z

    .line 455
    iput-object p5, p0, Lcom/amazon/mShop/model/auth/User;->mDob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .line 456
    if-nez p6, :cond_1

    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/model/auth/User;->mIsPrimeEligible:Z

    .line 457
    iput-object p7, p0, Lcom/amazon/mShop/model/auth/User;->mPrimeFunnelUrl:Ljava/lang/String;

    .line 458
    iput-boolean p9, p0, Lcom/amazon/mShop/model/auth/User;->mSmile:Z

    .line 459
    iput-object p8, p0, Lcom/amazon/mShop/model/auth/User;->mCharity:Ljava/lang/String;

    .line 460
    return-void

    .line 456
    :cond_1
    invoke-virtual {p6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_0
.end method

.method public static addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V
    .locals 5
    .param p0, "listener"    # Lcom/amazon/mShop/model/auth/UserListener;

    .prologue
    .line 95
    const/4 v1, 0x0

    .line 96
    .local v1, "added":Z
    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 98
    .local v2, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 99
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 100
    .local v0, "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_1

    .line 101
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 102
    :cond_1
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-ne v3, p0, :cond_0

    .line 103
    const/4 v1, 0x1

    .line 108
    .end local v0    # "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    :cond_2
    if-nez v1, :cond_3

    .line 109
    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    :cond_3
    return-void
.end method

.method public static declared-synchronized clearUser()V
    .locals 2

    .prologue
    .line 87
    const-class v0, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    sput-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 88
    monitor-exit v0

    return-void

    .line 87
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static getDateFromString(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .locals 4
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 398
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 411
    :cond_0
    :goto_0
    return-object v0

    .line 403
    :cond_1
    const-string/jumbo v2, "-"

    invoke-virtual {p0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 404
    .local v1, "strArray":[Ljava/lang/String;
    array-length v2, v1

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    .line 405
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Date;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;-><init>()V

    .line 406
    .local v0, "date":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    const/4 v2, 0x0

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->setYear(I)V

    .line 407
    const/4 v2, 0x1

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->setMonth(I)V

    .line 408
    const/4 v2, 0x2

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->setDay(I)V

    goto :goto_0
.end method

.method public static getLastUserEmail()Ljava/lang/String;
    .locals 2

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "userEmail"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getStringFromDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)Ljava/lang/String;
    .locals 2
    .param p0, "date"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .prologue
    .line 383
    if-nez p0, :cond_0

    .line 384
    const-string/jumbo v1, ""

    .line 394
    :goto_0
    return-object v1

    .line 387
    :cond_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 388
    .local v0, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getYear()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 389
    const-string/jumbo v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 390
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getMonth()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 391
    const-string/jumbo v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 392
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getDay()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 394
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static declared-synchronized getUser()Lcom/amazon/mShop/model/auth/User;
    .locals 12

    .prologue
    .line 63
    const-class v11, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v11

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    if-nez v0, :cond_0

    .line 64
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v10

    .line 65
    .local v10, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v0, "userFullName"

    invoke-interface {v10, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 67
    .local v2, "fullName":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 69
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v1, "userEmail"

    invoke-interface {v10, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v3, "userPrime"

    invoke-interface {v10, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    const-string/jumbo v4, "userOneClick"

    invoke-interface {v10, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    const-string/jumbo v5, "userDob"

    invoke-interface {v10, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/model/auth/User;->getDateFromString(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v5

    const-string/jumbo v6, "userPrimeEligible"

    invoke-interface {v10, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    const-string/jumbo v7, "userPrimeFunnelUrl"

    invoke-interface {v10, v7}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v8, "userCharity"

    invoke-interface {v10, v8}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "userIsSmile"

    invoke-interface {v10, v9}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    .line 80
    :cond_0
    sget-object v0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v11

    return-object v0

    .line 63
    .end local v2    # "fullName":Ljava/lang/String;
    :catchall_0
    move-exception v0

    monitor-exit v11

    throw v0
.end method

.method private static isCharityNameChanged(Ljava/lang/String;)Z
    .locals 1
    .param p0, "charityName"    # Ljava/lang/String;

    .prologue
    .line 274
    if-nez p0, :cond_0

    sget-object v0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    iget-object v0, v0, Lcom/amazon/mShop/model/auth/User;->mCharity:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    if-eqz p0, :cond_2

    sget-object v0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    iget-object v0, v0, Lcom/amazon/mShop/model/auth/User;->mCharity:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized isLoggedIn()Z
    .locals 2

    .prologue
    .line 91
    const-class v1, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static notifyUserUpdate(Lcom/amazon/mShop/model/auth/User;)V
    .locals 5
    .param p0, "newUser"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 293
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 294
    new-instance v2, Ljava/util/ArrayList;

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 296
    .local v2, "tempListListeners":Ljava/util/List;, "Ljava/util/List<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 299
    .local v1, "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 300
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 301
    .local v0, "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 302
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/model/auth/UserListener;

    sget-object v4, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-interface {v3, v4}, Lcom/amazon/mShop/model/auth/UserListener;->userUpdated(Lcom/amazon/mShop/model/auth/User;)V

    goto :goto_0

    .line 305
    .end local v0    # "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    :cond_1
    return-void
.end method

.method public static removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V
    .locals 3
    .param p0, "listener"    # Lcom/amazon/mShop/model/auth/UserListener;

    .prologue
    .line 114
    sget-object v2, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 116
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 117
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 119
    .local v0, "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    if-ne v2, p0, :cond_0

    .line 120
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 123
    .end local v0    # "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    :cond_2
    return-void
.end method

.method public static declared-synchronized saveUser(Lcom/amazon/mShop/model/auth/User;)V
    .locals 4
    .param p0, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 133
    const-class v2, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v2

    :try_start_0
    sput-object p0, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    .line 135
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 136
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-nez p0, :cond_0

    .line 139
    const-string/jumbo v1, "userFullName"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 140
    const-string/jumbo v1, "userPrime"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 141
    const-string/jumbo v1, "userOneClick"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 142
    const-string/jumbo v1, "userDob"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 143
    const-string/jumbo v1, "userPrimeEligible"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 144
    const-string/jumbo v1, "userPrimeFunnelUrl"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 145
    const-string/jumbo v1, "userIsSmile"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 146
    const-string/jumbo v1, "userCharity"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 159
    :goto_0
    monitor-exit v2

    return-void

    .line 149
    :cond_0
    :try_start_1
    const-string/jumbo v1, "userEmail"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    const-string/jumbo v1, "userFullName"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    const-string/jumbo v1, "userPrime"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 152
    const-string/jumbo v1, "userOneClick"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 153
    const-string/jumbo v1, "userDob"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/model/auth/User;->getStringFromDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    const-string/jumbo v1, "userPrimeEligible"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 155
    const-string/jumbo v1, "userPrimeFunnelUrl"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    const-string/jumbo v1, "userIsSmile"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 157
    const-string/jumbo v1, "userCharity"

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 133
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static saveUser(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V
    .locals 11
    .param p0, "email"    # Ljava/lang/String;
    .param p1, "loginData"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    .prologue
    .line 210
    const/4 v3, 0x0

    .line 211
    .local v3, "isPrime":Z
    const/4 v4, 0x0

    .line 212
    .local v4, "isOneClickEnabled":Z
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 213
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v3

    .line 214
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v4

    .line 216
    :cond_0
    const/4 v9, 0x0

    .line 217
    .local v9, "isSmile":Z
    const-string/jumbo v8, ""

    .line 218
    .local v8, "charityName":Ljava/lang/String;
    sget-object v10, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    .line 219
    .local v10, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v10, :cond_1

    .line 220
    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v9

    .line 221
    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v8

    .line 223
    :cond_1
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getIsPrimeFunnelEligible()Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    move-object v1, p0

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 232
    .local v0, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 233
    return-void
.end method

.method public static declared-synchronized setOneClickEnabled(Z)V
    .locals 4
    .param p0, "oneClickEnabled"    # Z

    .prologue
    .line 367
    const-class v2, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_1

    .line 377
    :cond_0
    :goto_0
    monitor-exit v2

    return-void

    .line 370
    :cond_1
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    iget-boolean v1, v1, Lcom/amazon/mShop/model/auth/User;->mOneClick:Z

    if-eq v1, p0, :cond_0

    .line 373
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 374
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    iput-boolean p0, v1, Lcom/amazon/mShop/model/auth/User;->mOneClick:Z

    .line 375
    const-string/jumbo v1, "userOneClick"

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v3}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 367
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static declared-synchronized setPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V
    .locals 4
    .param p0, "status"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    .prologue
    .line 350
    const-class v2, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 364
    :goto_0
    monitor-exit v2

    return-void

    .line 355
    :cond_0
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    iget-boolean v1, v1, Lcom/amazon/mShop/model/auth/User;->mPrime:Z

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v3

    if-eq v1, v3, :cond_1

    .line 359
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 360
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/mShop/model/auth/User;->mPrime:Z

    .line 361
    const-string/jumbo v1, "userPrime"

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v3}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    invoke-interface {v0, v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 363
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v1

    invoke-static {v1}, Lcom/amazon/mShop/model/auth/User;->setOneClickEnabled(Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 350
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static declared-synchronized userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 5
    .param p0, "newUser"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 240
    const-class v4, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v4

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 242
    new-instance v2, Ljava/util/ArrayList;

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 243
    .local v2, "tempListListeners":Ljava/util/List;, "Ljava/util/List<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 245
    .local v1, "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 246
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 247
    .local v0, "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 248
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/model/auth/UserListener;

    invoke-interface {v3, p0}, Lcom/amazon/mShop/model/auth/UserListener;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 240
    .end local v0    # "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    .end local v1    # "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    .end local v2    # "tempListListeners":Ljava/util/List;, "Ljava/util/List<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3

    .line 251
    .restart local v1    # "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    .restart local v2    # "tempListListeners":Ljava/util/List;, "Ljava/util/List<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_1
    monitor-exit v4

    return-void
.end method

.method public static userSignedIn(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V
    .locals 11
    .param p0, "email"    # Ljava/lang/String;
    .param p1, "loginData"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    .prologue
    .line 184
    const/4 v3, 0x0

    .line 185
    .local v3, "isPrime":Z
    const/4 v4, 0x0

    .line 186
    .local v4, "isOneClickEnabled":Z
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 187
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v3

    .line 188
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v4

    .line 190
    :cond_0
    const/4 v9, 0x0

    .line 191
    .local v9, "isSmile":Z
    const-string/jumbo v8, ""

    .line 192
    .local v8, "charityName":Ljava/lang/String;
    sget-object v10, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    .line 193
    .local v10, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v10, :cond_1

    .line 194
    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v9

    .line 195
    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v8

    .line 197
    :cond_1
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getIsPrimeFunnelEligible()Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    move-object v1, p0

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 206
    .local v0, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V

    .line 207
    return-void
.end method

.method public static declared-synchronized userSignedOut()V
    .locals 5

    .prologue
    .line 166
    const-class v4, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v4

    const/4 v3, 0x0

    :try_start_0
    invoke-static {v3}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 168
    new-instance v2, Ljava/util/ArrayList;

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 169
    .local v2, "tempListListeners":Ljava/util/List;, "Ljava/util/List<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUserListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 171
    .local v1, "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 172
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 173
    .local v0, "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 174
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/model/auth/UserListener;

    invoke-interface {v3}, Lcom/amazon/mShop/model/auth/UserListener;->userSignedOut()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 166
    .end local v0    # "aListener":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;"
    .end local v1    # "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3

    .line 177
    .restart local v1    # "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/ref/WeakReference<Lcom/amazon/mShop/model/auth/UserListener;>;>;"
    :cond_1
    monitor-exit v4

    return-void
.end method

.method public static declared-synchronized userUpdated(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V
    .locals 13
    .param p0, "loginData"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    .prologue
    .line 314
    const-class v12, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v12

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    if-eqz v1, :cond_1

    .line 318
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getFullName()Ljava/lang/String;

    move-result-object v11

    .line 319
    .local v11, "fullNameInLoginData":Ljava/lang/String;
    if-eqz v11, :cond_2

    invoke-virtual {v11}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    move-object v2, v11

    .line 320
    .local v2, "fullName":Ljava/lang/String;
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v10

    .line 321
    .local v10, "dateOfBirthdayInLoginData":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    if-eqz v10, :cond_3

    move-object v5, v10

    .line 325
    .local v5, "dateOfbirthday":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    :goto_1
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    .line 326
    .local v6, "isPrimeFunnelEligible":Ljava/lang/Boolean;
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    .line 328
    .local v7, "primeFunnelUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getIsPrimeFunnelEligible()Ljava/lang/Boolean;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 329
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getIsPrimeFunnelEligible()Ljava/lang/Boolean;

    move-result-object v6

    .line 330
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    .line 332
    :cond_0
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v9

    .line 333
    .local v9, "isSmile":Z
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v8

    .line 334
    .local v8, "charity":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v3

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v4

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 344
    .local v0, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->notifyUserUpdate(Lcom/amazon/mShop/model/auth/User;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 346
    .end local v0    # "newUser":Lcom/amazon/mShop/model/auth/User;
    .end local v2    # "fullName":Ljava/lang/String;
    .end local v5    # "dateOfbirthday":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .end local v6    # "isPrimeFunnelEligible":Ljava/lang/Boolean;
    .end local v7    # "primeFunnelUrl":Ljava/lang/String;
    .end local v8    # "charity":Ljava/lang/String;
    .end local v9    # "isSmile":Z
    .end local v10    # "dateOfBirthdayInLoginData":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .end local v11    # "fullNameInLoginData":Ljava/lang/String;
    :cond_1
    monitor-exit v12

    return-void

    .line 319
    .restart local v11    # "fullNameInLoginData":Ljava/lang/String;
    :cond_2
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 321
    .restart local v2    # "fullName":Ljava/lang/String;
    .restart local v10    # "dateOfBirthdayInLoginData":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    :cond_3
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    goto :goto_1

    .line 314
    .end local v2    # "fullName":Ljava/lang/String;
    .end local v10    # "dateOfBirthdayInLoginData":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .end local v11    # "fullNameInLoginData":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit v12

    throw v1
.end method

.method public static declared-synchronized userUpdated(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;)V
    .locals 4
    .param p0, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;

    .prologue
    .line 258
    const-class v3, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    if-eqz v2, :cond_0

    .line 259
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;->getCharityName()Ljava/lang/String;

    move-result-object v0

    .line 261
    .local v0, "charityName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->isCharityNameChanged(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 262
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    const/4 v1, 0x1

    .line 263
    .local v1, "isSmile":Z
    :goto_0
    invoke-static {v1, v0}, Lcom/amazon/mShop/model/auth/User;->userUpdated(ZLjava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 266
    .end local v0    # "charityName":Ljava/lang/String;
    .end local v1    # "isSmile":Z
    :cond_0
    monitor-exit v3

    return-void

    .line 262
    .restart local v0    # "charityName":Ljava/lang/String;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 258
    .end local v0    # "charityName":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public static declared-synchronized userUpdated(ZLjava/lang/String;)V
    .locals 11
    .param p0, "isSmile"    # Z
    .param p1, "charityName"    # Ljava/lang/String;

    .prologue
    .line 283
    const-class v10, Lcom/amazon/mShop/model/auth/User;

    monitor-enter v10

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    if-eqz v1, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/model/auth/User;->isCharityNameChanged(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 284
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    sget-object v1, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getEmail()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v2}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v3}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    sget-object v4, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v4}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v4

    sget-object v5, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v5}, Lcom/amazon/mShop/model/auth/User;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v5

    sget-object v6, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v6}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    sget-object v7, Lcom/amazon/mShop/model/auth/User;->sUser:Lcom/amazon/mShop/model/auth/User;

    invoke-virtual {v7}, Lcom/amazon/mShop/model/auth/User;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    move-object v8, p1

    move v9, p0

    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 288
    .local v0, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->notifyUserUpdate(Lcom/amazon/mShop/model/auth/User;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 290
    .end local v0    # "newUser":Lcom/amazon/mShop/model/auth/User;
    :cond_0
    monitor-exit v10

    return-void

    .line 283
    :catchall_0
    move-exception v1

    monitor-exit v10

    throw v1
.end method


# virtual methods
.method public getCharity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 535
    iget-object v0, p0, Lcom/amazon/mShop/model/auth/User;->mCharity:Ljava/lang/String;

    return-object v0
.end method

.method public getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .locals 1

    .prologue
    .line 500
    iget-object v0, p0, Lcom/amazon/mShop/model/auth/User;->mDob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 467
    iget-object v0, p0, Lcom/amazon/mShop/model/auth/User;->mEmail:Ljava/lang/String;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 475
    iget-object v0, p0, Lcom/amazon/mShop/model/auth/User;->mFullName:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimeFunnelUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 519
    iget-object v0, p0, Lcom/amazon/mShop/model/auth/User;->mPrimeFunnelUrl:Ljava/lang/String;

    return-object v0
.end method

.method public isOneClick()Z
    .locals 1

    .prologue
    .line 491
    iget-boolean v0, p0, Lcom/amazon/mShop/model/auth/User;->mOneClick:Z

    return v0
.end method

.method public isPrime()Z
    .locals 1

    .prologue
    .line 483
    iget-boolean v0, p0, Lcom/amazon/mShop/model/auth/User;->mPrime:Z

    return v0
.end method

.method public isPrimeEligible()Z
    .locals 1

    .prologue
    .line 511
    iget-boolean v0, p0, Lcom/amazon/mShop/model/auth/User;->mIsPrimeEligible:Z

    return v0
.end method

.method public isSmile()Z
    .locals 1

    .prologue
    .line 527
    iget-boolean v0, p0, Lcom/amazon/mShop/model/auth/User;->mSmile:Z

    return v0
.end method
