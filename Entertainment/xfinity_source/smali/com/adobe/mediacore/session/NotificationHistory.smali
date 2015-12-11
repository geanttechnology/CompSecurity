.class public Lcom/adobe/mediacore/session/NotificationHistory;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/session/NotificationHistory$EventListener;,
        Lcom/adobe/mediacore/session/NotificationHistory$Item;
    }
.end annotation


# static fields
.field private static final DEFAULT_SIZE:I = 0x64


# instance fields
.field private _index:J

.field private _listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/session/NotificationHistory$EventListener;",
            ">;"
        }
    .end annotation
.end field

.field private _notifications:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/session/NotificationHistory$Item;",
            ">;"
        }
    .end annotation
.end field

.field private _size:J


# direct methods
.method public constructor <init>()V
    .locals 2

    const-wide/16 v0, 0x64

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/session/NotificationHistory;-><init>(J)V

    return-void
.end method

.method public constructor <init>(J)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    iput-wide p1, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_size:J

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_index:J

    return-void
.end method

.method private dispatchNewItemAddedEvent(Lcom/adobe/mediacore/session/NotificationHistory$Item;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/session/NotificationHistory$EventListener;

    invoke-interface {v0, p1}, Lcom/adobe/mediacore/session/NotificationHistory$EventListener;->onNewItemAdded(Lcom/adobe/mediacore/session/NotificationHistory$Item;)V

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method public addListener(Lcom/adobe/mediacore/session/NotificationHistory$EventListener;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-long v0, v0

    iget-wide v2, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_size:J

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    iget-object v1, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/session/NotificationHistory$Item;

    iget-wide v2, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_index:J

    const-wide/16 v4, 0x1

    add-long/2addr v4, v2

    iput-wide v4, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_index:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    move-object v1, p0

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/session/NotificationHistory$Item;-><init>(Lcom/adobe/mediacore/session/NotificationHistory;JJLcom/adobe/mediacore/MediaPlayerNotification;)V

    iget-object v1, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2, v0}, Ljava/util/List;->add(ILjava/lang/Object;)V

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/session/NotificationHistory;->dispatchNewItemAddedEvent(Lcom/adobe/mediacore/session/NotificationHistory$Item;)V

    return-void
.end method

.method public clear()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public getNotifications()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/session/NotificationHistory$Item;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public removeAllListeners()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public removeListener(Lcom/adobe/mediacore/session/NotificationHistory$EventListener;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/session/NotificationHistory$EventListener;

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    return-void
.end method

.method public setSize(J)V
    .locals 5

    const-wide/16 v0, 0x1

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Player session size must a positive integer value."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-wide v0, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_size:J

    cmp-long v0, p1, v0

    if-gez v0, :cond_2

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    const/4 v0, 0x0

    :goto_0
    int-to-long v2, v0

    cmp-long v2, v2, p1

    if-gez v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    iput-object v1, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_notifications:Ljava/util/List;

    :cond_2
    iput-wide p1, p0, Lcom/adobe/mediacore/session/NotificationHistory;->_size:J

    return-void
.end method
