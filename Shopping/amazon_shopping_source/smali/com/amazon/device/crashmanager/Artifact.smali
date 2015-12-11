.class public Lcom/amazon/device/crashmanager/Artifact;
.super Ljava/lang/Object;
.source "Artifact.java"

# interfaces
.implements Ljava/io/Closeable;


# instance fields
.field private mCrashDescriptor:Ljava/lang/String;

.field private final mCreationTimeUTCMillis:J

.field private final mInputStream:Ljava/io/InputStream;

.field private final mTag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/io/InputStream;J)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "inputStream"    # Ljava/io/InputStream;
    .param p3, "creationTimeMillis"    # J

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    if-nez p1, :cond_0

    .line 36
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Artifact tag cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 38
    :cond_0
    if-nez p2, :cond_1

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Artifact InputSteam cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_1
    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-gez v0, :cond_2

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Creation Time cannot be negative"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_2
    iput-object p1, p0, Lcom/amazon/device/crashmanager/Artifact;->mTag:Ljava/lang/String;

    .line 45
    iput-object p2, p0, Lcom/amazon/device/crashmanager/Artifact;->mInputStream:Ljava/io/InputStream;

    .line 46
    iput-wide p3, p0, Lcom/amazon/device/crashmanager/Artifact;->mCreationTimeUTCMillis:J

    .line 47
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mInputStream:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 86
    :cond_0
    return-void
.end method

.method public getCrashDescriptor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mCrashDescriptor:Ljava/lang/String;

    return-object v0
.end method

.method public getCreationTimeUTCMillis()J
    .locals 2

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mCreationTimeUTCMillis:J

    return-wide v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mInputStream:Ljava/io/InputStream;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/device/crashmanager/Artifact;->mTag:Ljava/lang/String;

    return-object v0
.end method

.method public setCrashDescriptor(Ljava/lang/String;)V
    .locals 0
    .param p1, "crashDescriptor"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/device/crashmanager/Artifact;->mCrashDescriptor:Ljava/lang/String;

    .line 75
    return-void
.end method
