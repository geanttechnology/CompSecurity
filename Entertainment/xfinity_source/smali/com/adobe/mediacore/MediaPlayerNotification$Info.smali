.class public Lcom/adobe/mediacore/MediaPlayerNotification$Info;
.super Lcom/adobe/mediacore/MediaPlayerNotification;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerNotification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Info"
.end annotation


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerNotification;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->INFO:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->_type:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->_code:Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->_description:Ljava/lang/String;

    return-void
.end method
