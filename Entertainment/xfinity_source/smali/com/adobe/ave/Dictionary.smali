.class public Lcom/adobe/ave/Dictionary;
.super Ljava/lang/Object;
.source "Dictionary.java"


# instance fields
.field private mNativeContext:J


# direct methods
.method private constructor <init>(J)V
    .locals 1
    .param p1, "nativeContext"    # J

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-wide p1, p0, Lcom/adobe/ave/Dictionary;->mNativeContext:J

    .line 39
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Dictionary;->nativeCreateDictionary(J)V

    .line 40
    return-void
.end method

.method private native nativeCreateDictionary(J)V
.end method

.method private native nativeFinalize()V
.end method

.method private native nativeGetByteArrayByKey(Ljava/lang/String;)[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetCount()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetKeyByIndex(I)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetValueByKey(Ljava/lang/String;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeRelease()V
.end method


# virtual methods
.method protected finalize()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/adobe/ave/Dictionary;->nativeFinalize()V

    .line 59
    return-void
.end method

.method public getByteArrayByKey(Ljava/lang/String;)[B
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 103
    invoke-direct {p0, p1}, Lcom/adobe/ave/Dictionary;->nativeGetByteArrayByKey(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/adobe/ave/Dictionary;->nativeGetCount()I

    move-result v0

    return v0
.end method

.method public getKeyByIndex(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/adobe/ave/Dictionary;->nativeGetKeyByIndex(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValueByKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 92
    invoke-direct {p0, p1}, Lcom/adobe/ave/Dictionary;->nativeGetValueByKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public release()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/adobe/ave/Dictionary;->nativeRelease()V

    .line 49
    return-void
.end method
