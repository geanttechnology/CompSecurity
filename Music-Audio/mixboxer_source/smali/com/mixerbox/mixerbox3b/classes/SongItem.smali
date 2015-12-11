.class public Lcom/mixerbox/mixerbox3b/classes/SongItem;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field id:Ljava/lang/String;

.field name:Ljava/lang/String;

.field order:I

.field source:I

.field thumbnail:Ljava/lang/String;

.field time:Ljava/lang/String;

.field tm:I

.field ytId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->id:Ljava/lang/String;

    .line 16
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->name:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->time:Ljava/lang/String;

    .line 18
    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->ytId:Ljava/lang/String;

    .line 19
    iput p5, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->order:I

    .line 20
    iput p6, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->source:I

    .line 21
    iput-object p7, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->thumbnail:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public getSongId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getSongName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getSongOrder()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->order:I

    return v0
.end method

.method public getSongSource()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->source:I

    return v0
.end method

.method public getSongThumbnail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->thumbnail:Ljava/lang/String;

    return-object v0
.end method

.method public getSongTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->time:Ljava/lang/String;

    return-object v0
.end method

.method public getSongYtId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/SongItem;->ytId:Ljava/lang/String;

    return-object v0
.end method
