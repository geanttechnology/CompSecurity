.class public Lcom/adobe/mediacore/info/AudioTrack;
.super Lcom/adobe/mediacore/info/Track;


# instance fields
.field private final _isAutoSelect:Z

.field private final _isForced:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZZ)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/mediacore/info/Track;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    iput-boolean p4, p0, Lcom/adobe/mediacore/info/AudioTrack;->_isAutoSelect:Z

    iput-boolean p5, p0, Lcom/adobe/mediacore/info/AudioTrack;->_isForced:Z

    return-void
.end method


# virtual methods
.method public isAutoSelect()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/info/AudioTrack;->_isAutoSelect:Z

    return v0
.end method

.method public isForced()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/info/AudioTrack;->_isForced:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Name: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/AudioTrack;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". Language: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/AudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
