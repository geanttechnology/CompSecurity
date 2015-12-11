.class public Lcom/poshmark/notifications/ListingNotificationManager;
.super Ljava/lang/Object;
.source "ListingNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/notifications/ListingNotificationManager$MODE;
    }
.end annotation


# static fields
.field static listingNotificationManager:Lcom/poshmark/notifications/ListingNotificationManager;


# instance fields
.field private LISTING_COMMENT_ADDED:I

.field private LISTING_EDITED:I

.field private LISTING_LIKED:I

.field private handlerList:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/poshmark/notifications/ListingNotificationHandler;",
            ">;"
        }
    .end annotation
.end field

.field public listingNotificationMsgHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationManager:Lcom/poshmark/notifications/ListingNotificationManager;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    .line 23
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->LISTING_EDITED:I

    .line 24
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->LISTING_LIKED:I

    .line 25
    const/4 v0, 0x2

    iput v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->LISTING_COMMENT_ADDED:I

    .line 129
    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager$2;

    invoke-direct {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager$2;-><init>(Lcom/poshmark/notifications/ListingNotificationManager;)V

    iput-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationMsgHandler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/notifications/ListingNotificationManager;Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/notifications/ListingNotificationManager;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/poshmark/notifications/ListingNotificationManager;->launchAllEditMessages(Lcom/poshmark/data_model/models/ListingDetails;)V

    return-void
.end method

.method public static getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationManager:Lcom/poshmark/notifications/ListingNotificationManager;

    if-nez v0, :cond_0

    .line 31
    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager;

    invoke-direct {v0}, Lcom/poshmark/notifications/ListingNotificationManager;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationManager:Lcom/poshmark/notifications/ListingNotificationManager;

    .line 33
    :cond_0
    sget-object v0, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationManager:Lcom/poshmark/notifications/ListingNotificationManager;

    return-object v0
.end method

.method private declared-synchronized launchAllCommentMessages(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 80
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 81
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 82
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .line 83
    .local v0, "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    invoke-interface {v0, p1, p2}, Lcom/poshmark/notifications/ListingNotificationHandler;->addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 80
    .end local v0    # "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 85
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized launchAllDeleteMessages(Ljava/lang/String;)V
    .locals 3
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 72
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 73
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 74
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .line 75
    .local v0, "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    invoke-interface {v0, p1}, Lcom/poshmark/notifications/ListingNotificationHandler;->deleteListing(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 72
    .end local v0    # "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 77
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized launchAllEditMessages(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 3
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 56
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 57
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 58
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .line 59
    .local v0, "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    invoke-interface {v0, p1}, Lcom/poshmark/notifications/ListingNotificationHandler;->updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 56
    .end local v0    # "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 61
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized launchAllLikeMessages(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "status"    # Z

    .prologue
    .line 64
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 65
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 66
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .line 67
    .local v0, "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    invoke-interface {v0, p1, p2}, Lcom/poshmark/notifications/ListingNotificationHandler;->likeListing(Ljava/lang/String;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 64
    .end local v0    # "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 69
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized launchAllNewListingCreatedMessages()V
    .locals 3

    .prologue
    .line 88
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 89
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 90
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .line 91
    .local v0, "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    invoke-interface {v0}, Lcom/poshmark/notifications/ListingNotificationHandler;->newListingCreated()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 88
    .end local v0    # "handler":Lcom/poshmark/notifications/ListingNotificationHandler;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 93
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/ListingNotificationHandler;>;"
    :cond_0
    monitor-exit p0

    return-void
.end method


# virtual methods
.method public declared-synchronized fireListingCommentMessage(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 117
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/poshmark/notifications/ListingNotificationManager;->launchAllCommentMessages(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 118
    monitor-exit p0

    return-void

    .line 117
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized fireListingDeletedMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 121
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lcom/poshmark/notifications/ListingNotificationManager;->launchAllDeleteMessages(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 122
    monitor-exit p0

    return-void

    .line 121
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized fireListingEditedMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 97
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/poshmark/notifications/ListingNotificationManager$1;

    invoke-direct {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager$1;-><init>(Lcom/poshmark/notifications/ListingNotificationManager;)V

    invoke-static {p1, v0}, Lcom/poshmark/http/api/PMApi;->getListingDetails(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 110
    monitor-exit p0

    return-void

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized fireListingLikedMessage(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "status"    # Z

    .prologue
    .line 113
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/poshmark/notifications/ListingNotificationManager;->launchAllLikeMessages(Ljava/lang/String;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 114
    monitor-exit p0

    return-void

    .line 113
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized fireNewListingCreatedMessage()V
    .locals 1

    .prologue
    .line 125
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/poshmark/notifications/ListingNotificationManager;->launchAllNewListingCreatedMessages()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 126
    monitor-exit p0

    return-void

    .line 125
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/poshmark/notifications/ListingNotificationHandler;

    .prologue
    .line 43
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 46
    :cond_0
    monitor-exit p0

    return-void

    .line 43
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized unregisterListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/poshmark/notifications/ListingNotificationHandler;

    .prologue
    .line 50
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/poshmark/notifications/ListingNotificationManager;->handlerList:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 53
    :cond_0
    monitor-exit p0

    return-void

    .line 50
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
