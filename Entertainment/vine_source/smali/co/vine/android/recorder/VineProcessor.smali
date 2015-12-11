.class public Lco/vine/android/recorder/VineProcessor;
.super Ljava/lang/Object;
.source "VineProcessor.java"


# instance fields
.field private final mProcessor:Lco/vine/android/recorder/Processor;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "nativeDir"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineLoggingException;
        }
    .end annotation

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    :try_start_0
    new-instance v1, Lco/vine/android/recorder/Processor;

    invoke-direct {v1, p1}, Lco/vine/android/recorder/Processor;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 20
    return-void

    .line 17
    :catch_0
    move-exception v0

    .line 18
    .local v0, "e":Ljava/lang/UnsatisfiedLinkError;
    new-instance v1, Lco/vine/android/VineLoggingException;

    invoke-direct {v1, v0}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public combineVideoAndAudio(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p1, "video"    # Ljava/lang/String;
    .param p2, "audio"    # Ljava/lang/String;
    .param p3, "output"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "0:0"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setMap(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "1:0"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setMap(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public combineVideoAndAudio(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)I
    .locals 2
    .param p1, "video"    # Ljava/lang/String;
    .param p2, "audio"    # Ljava/lang/String;
    .param p3, "output"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 90
    .local p4, "metaData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "0:0"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setMap(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "1:0"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setMap(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p4}, Lco/vine/android/recorder/Processor;->setMetaData(Ljava/util/HashMap;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public concat(Ljava/util/List;Ljava/lang/String;Ljava/util/HashMap;)I
    .locals 5
    .param p2, "output"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 102
    .local p1, "inputs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p3, "metaData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v3, "concat:"

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 103
    .local v0, "files":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v2, v3, -0x1

    .line 104
    .local v2, "n":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 105
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 106
    const-string v3, "|"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 104
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 108
    :cond_0
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    iget-object v3, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v3}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v3

    const-string v4, "aac_adtstoasc"

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/Processor;->setBsfA(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v3

    invoke-virtual {v3, p3}, Lco/vine/android/recorder/Processor;->setMetaData(Ljava/util/HashMap;)Lco/vine/android/recorder/Processor;

    move-result-object v3

    invoke-virtual {v3, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v3

    return v3
.end method

.method public cropTo480(Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;

    .prologue
    const/16 v1, 0x1e0

    .line 128
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setAudioCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Lco/vine/android/recorder/Processor;->filterCrop(II)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public cropTo480andRotate(Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;

    .prologue
    const/16 v1, 0x1e0

    .line 58
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setAudioCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Lco/vine/android/recorder/Processor;->filterCrop(II)Lco/vine/android/recorder/Processor;

    move-result-object v0

    sget-object v1, Lco/vine/android/recorder/Processor$Rotation;->NO_FLIP_90_CLOCKWISE:Lco/vine/android/recorder/Processor$Rotation;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->filterRotation(Lco/vine/android/recorder/Processor$Rotation;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getImageForFrame(Ljava/lang/String;JIILjava/lang/String;)I
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "time"    # J
    .param p4, "sizeX"    # I
    .param p5, "sizeY"    # I
    .param p6, "output"    # Ljava/lang/String;

    .prologue
    .line 146
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lco/vine/android/recorder/Processor;->setStart(J)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setVFrames(I)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "image2"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setFormat(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p6}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public init()V
    .locals 4

    .prologue
    .line 23
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "ffmpeg"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "-h"

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->process([Ljava/lang/String;)I

    .line 24
    return-void
.end method

.method public rotate(Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;

    .prologue
    .line 137
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setAudioCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    sget-object v1, Lco/vine/android/recorder/Processor$Rotation;->NO_FLIP_90_CLOCKWISE:Lco/vine/android/recorder/Processor$Rotation;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->filterRotation(Lco/vine/android/recorder/Processor$Rotation;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public setMetadata(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)I
    .locals 1
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 27
    .local p3, "metaData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->setMetaData(Ljava/util/HashMap;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public split(Ljava/lang/String;Lco/vine/android/recorder/RelativeTime;Ljava/lang/String;I)I
    .locals 3
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "time"    # Lco/vine/android/recorder/RelativeTime;
    .param p3, "output"    # Ljava/lang/String;
    .param p4, "frameRate"    # I

    .prologue
    .line 117
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    iget-wide v1, p2, Lco/vine/android/recorder/RelativeTime;->start:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/Processor;->setStart(J)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {p2, p4}, Lco/vine/android/recorder/RelativeTime;->getDuration(I)J

    move-result-wide v1

    invoke-virtual {v0, v1, v2, p4}, Lco/vine/android/recorder/Processor;->setFrames(JI)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setVideoCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setAudioCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public splitTs(Ljava/lang/String;Lco/vine/android/recorder/RelativeTime;Ljava/lang/String;I)I
    .locals 3
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "time"    # Lco/vine/android/recorder/RelativeTime;
    .param p3, "output"    # Ljava/lang/String;
    .param p4, "frameRate"    # I

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    iget-wide v1, p2, Lco/vine/android/recorder/RelativeTime;->start:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/Processor;->setStart(J)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {p2, p4}, Lco/vine/android/recorder/RelativeTime;->getDuration(I)J

    move-result-wide v1

    invoke-virtual {v0, v1, v2, p4}, Lco/vine/android/recorder/Processor;->setFrames(JI)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "h264_mp4toannexb"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setBsfV(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "mpegts"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setFormat(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public toH264(Ljava/lang/String;Lco/vine/android/recorder/Processor$Preset;Ljava/lang/String;Ljava/util/HashMap;)I
    .locals 1
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "preset"    # Lco/vine/android/recorder/Processor$Preset;
    .param p3, "output"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lco/vine/android/recorder/Processor$Preset;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 36
    .local p4, "metaData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->useX264()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->setPreset(Lco/vine/android/recorder/Processor$Preset;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setAudioCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p4}, Lco/vine/android/recorder/Processor;->setMetaData(Ljava/util/HashMap;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p3}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public toTs(Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "output"    # Ljava/lang/String;

    .prologue
    .line 80
    iget-object v0, p0, Lco/vine/android/recorder/VineProcessor;->mProcessor:Lco/vine/android/recorder/Processor;

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->newCommand()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/Processor;->addInputPath(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->setCopy()Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "h264_mp4toannexb"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setBsfV(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    const-string v1, "mpegts"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/Processor;->setFormat(Ljava/lang/String;)Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/Processor;->enableOverwrite()Lco/vine/android/recorder/Processor;

    move-result-object v0

    invoke-virtual {v0, p2}, Lco/vine/android/recorder/Processor;->processToOutput(Ljava/lang/String;)I

    move-result v0

    return v0
.end method
