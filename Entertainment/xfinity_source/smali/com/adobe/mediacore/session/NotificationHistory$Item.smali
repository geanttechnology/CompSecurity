.class public Lcom/adobe/mediacore/session/NotificationHistory$Item;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/session/NotificationHistory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Item"
.end annotation


# instance fields
.field private final _index:J

.field private final _notification:Lcom/adobe/mediacore/MediaPlayerNotification;

.field private final _timeStamp:J

.field final synthetic this$0:Lcom/adobe/mediacore/session/NotificationHistory;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/session/NotificationHistory;JJLcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->this$0:Lcom/adobe/mediacore/session/NotificationHistory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p2, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_index:J

    iput-wide p4, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_timeStamp:J

    iput-object p6, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-void
.end method


# virtual methods
.method public getIndex()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_index:J

    return-wide v0
.end method

.method public getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-object v0
.end method

.method public getTimeStamp()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_timeStamp:J

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "{"

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    const-string v1, "\"index\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_index:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, "\"timestamp\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_timeStamp:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    if-eqz v1, :cond_0

    const-string v1, "\"notification\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/session/NotificationHistory$Item;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    :goto_0
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v1, "\"notification\":null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method
