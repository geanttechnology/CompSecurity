.class public Lcom/amazon/dcp/messaging/Message;
.super Ljava/lang/Object;
.source "Message.java"


# instance fields
.field private final mId:Ljava/lang/String;

.field private final mPayload:[B

.field private final mTopic:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "topic"    # Ljava/lang/String;
    .param p3, "payload"    # [B

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 21
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Id cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 24
    :cond_1
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 26
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Topic cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_3
    if-nez p3, :cond_4

    .line 31
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Payload cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_4
    iput-object p1, p0, Lcom/amazon/dcp/messaging/Message;->mId:Ljava/lang/String;

    .line 35
    iput-object p2, p0, Lcom/amazon/dcp/messaging/Message;->mTopic:Ljava/lang/String;

    .line 36
    array-length v0, p3

    invoke-static {p3, v0}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/messaging/Message;->mPayload:[B

    .line 37
    return-void
.end method

.method public static constructMessageFromIntent(Landroid/content/Intent;)Lcom/amazon/dcp/messaging/Message;
    .locals 4
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 62
    invoke-static {p0}, Lcom/amazon/dcp/messaging/Message;->getIdFromIntent(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, "id":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/dcp/messaging/Message;->getPayloadFromIntent(Landroid/content/Intent;)[B

    move-result-object v1

    .line 64
    .local v1, "payload":[B
    invoke-static {p0}, Lcom/amazon/dcp/messaging/Message;->getTopicFromIntent(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "topic":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-nez v2, :cond_1

    .line 68
    :cond_0
    const/4 v3, 0x0

    .line 71
    :goto_0
    return-object v3

    :cond_1
    new-instance v3, Lcom/amazon/dcp/messaging/Message;

    invoke-direct {v3, v0, v2, v1}, Lcom/amazon/dcp/messaging/Message;-><init>(Ljava/lang/String;Ljava/lang/String;[B)V

    goto :goto_0
.end method

.method private static getIdFromIntent(Landroid/content/Intent;)Ljava/lang/String;
    .locals 1
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 76
    const-string/jumbo v0, "com.amazon.dcp.messaging.MESSAGE_ID"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getPayloadFromIntent(Landroid/content/Intent;)[B
    .locals 1
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 93
    const-string/jumbo v0, "com.amazon.dcp.messaging.MESSAGE_PAYLOAD"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method private static getTopicFromIntent(Landroid/content/Intent;)Ljava/lang/String;
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 81
    invoke-virtual {p0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 83
    .local v0, "action":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.messaging.topic."

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 85
    :cond_0
    const/4 v1, 0x0

    .line 88
    :goto_0
    return-object v1

    :cond_1
    const-string/jumbo v1, "com.amazon.dcp.messaging.topic."

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/dcp/messaging/Message;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getPayload()[B
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/dcp/messaging/Message;->mPayload:[B

    iget-object v1, p0, Lcom/amazon/dcp/messaging/Message;->mPayload:[B

    array-length v1, v1

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    return-object v0
.end method

.method public getTopic()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/dcp/messaging/Message;->mTopic:Ljava/lang/String;

    return-object v0
.end method
