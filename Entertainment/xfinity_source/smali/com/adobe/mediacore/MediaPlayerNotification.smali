.class public abstract Lcom/adobe/mediacore/MediaPlayerNotification;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;,
        Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;,
        Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;,
        Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;,
        Lcom/adobe/mediacore/MediaPlayerNotification$Error;,
        Lcom/adobe/mediacore/MediaPlayerNotification$Warning;,
        Lcom/adobe/mediacore/MediaPlayerNotification$Info;,
        Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;
    }
.end annotation


# instance fields
.field protected _code:Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

.field protected _description:Ljava/lang/String;

.field protected _inner:Lcom/adobe/mediacore/MediaPlayerNotification;

.field protected _metadata:Lcom/adobe/mediacore/metadata/Metadata;

.field protected _type:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    return-object v0
.end method

.method public static createInfoNotification(Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Info;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    return-object v0
.end method

.method public static createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_code:Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_description:Ljava/lang/String;

    return-object v0
.end method

.method public getInnerNotification()Lcom/adobe/mediacore/MediaPlayerNotification;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_inner:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-object v0
.end method

.method public getMetadata()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getType()Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_type:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    return-object v0
.end method

.method public setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_inner:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-void
.end method

.method public setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "{"

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    const-string v1, "\"description\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_description:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, "\"type\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_type:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, "\"name\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_code:Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, "\"code\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_code:Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    if-eqz v1, :cond_0

    const-string v1, "\"metadata\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :goto_0
    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_inner:Lcom/adobe/mediacore/MediaPlayerNotification;

    if-eqz v1, :cond_1

    const-string v1, "\"inner-notification\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerNotification;->_inner:Lcom/adobe/mediacore/MediaPlayerNotification;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    :goto_1
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v1, "\"metadata\":null,"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    :cond_1
    const-string v1, "\"inner-notification\":null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1
.end method
