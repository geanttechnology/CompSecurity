.class public Lcom/amazon/communication/InputStreamMessageImpl;
.super Ljava/lang/Object;
.source "InputStreamMessageImpl.java"

# interfaces
.implements Lamazon/communication/Message;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mInputStream:Ljava/io/InputStream;

.field private mIsGetPayloadInvoked:Z

.field private final mPrependedData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/nio/ByteBuffer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.InputStreamMessageImpl"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 1
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 186
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 187
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mPrependedData:Ljava/util/List;

    .line 188
    iput-object p1, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;

    .line 189
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mIsGetPayloadInvoked:Z

    .line 190
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/communication/InputStreamMessageImpl;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mPrependedData:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/communication/InputStreamMessageImpl;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;

    return-object v0
.end method

.method static synthetic access$200()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method


# virtual methods
.method public getPayload()Ljava/io/InputStream;
    .locals 2

    .prologue
    .line 225
    iget-boolean v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mIsGetPayloadInvoked:Z

    if-eqz v0, :cond_0

    .line 226
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "getPayload can only be called once for InputStream based message."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 229
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mIsGetPayloadInvoked:Z

    .line 230
    new-instance v0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;

    invoke-direct {v0, p0}, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;-><init>(Lcom/amazon/communication/InputStreamMessageImpl;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 243
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "InputStreamMessageImpl [PrependedData="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mPrependedData:Ljava/util/List;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "] [InputStream="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
