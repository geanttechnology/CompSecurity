.class Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;
.super Ljava/lang/Object;
.source "RequestSigner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CorpusBuilder"
.end annotation


# instance fields
.field private mBody:[B

.field private mCorpus:Ljava/io/ByteArrayOutputStream;

.field private mIsValid:Z

.field private mPath:Ljava/lang/String;

.field private mTimestamp:Ljava/lang/String;

.field private mToken:Ljava/lang/String;

.field private mVerb:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;)V
    .locals 10
    .param p2, "authProvider"    # Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;
    .param p3, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p4, "overriddenTimestamp"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 46
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->this$0:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const-string/jumbo v7, ""

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    .line 48
    new-array v7, v9, [B

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mBody:[B

    .line 50
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    .line 51
    iput-object p4, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    .line 52
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    if-nez v7, :cond_0

    .line 55
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string/jumbo v7, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    sget-object v8, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v1, v7, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 56
    .local v1, "dateFormatter":Ljava/text/SimpleDateFormat;
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    .line 58
    .local v3, "now":Ljava/util/Date;
    invoke-virtual {v1, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    .line 61
    .end local v1    # "dateFormatter":Ljava/text/SimpleDateFormat;
    .end local v3    # "now":Ljava/util/Date;
    :cond_0
    if-eqz p2, :cond_1

    .line 63
    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;->getToken()Ljava/lang/String;

    move-result-object v5

    .line 64
    .local v5, "token":Ljava/lang/String;
    if-eqz v5, :cond_1

    .line 66
    iput-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mToken:Ljava/lang/String;

    .line 70
    .end local v5    # "token":Ljava/lang/String;
    :cond_1
    if-eqz p3, :cond_4

    .line 72
    invoke-virtual {p3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getVerbAsString()Ljava/lang/String;

    move-result-object v6

    .line 73
    .local v6, "verb":Ljava/lang/String;
    if-eqz v6, :cond_2

    .line 75
    iput-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mVerb:Ljava/lang/String;

    .line 79
    :cond_2
    # getter for: Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseBustedIdentityBehavior:Z
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->access$000(Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 81
    invoke-virtual {p3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    .line 96
    :cond_3
    :goto_0
    # getter for: Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->mUseBustedIdentityBehavior:Z
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->access$000(Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 98
    new-array v7, v9, [B

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mBody:[B

    .line 110
    .end local v6    # "verb":Ljava/lang/String;
    :cond_4
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->validateComponents()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 114
    :try_start_0
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v9, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mVerb:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "\n"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 115
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v9, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "\n"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 116
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v9, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "\n"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 117
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mBody:[B

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 118
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    const-string/jumbo v8, "\n"

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 119
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mToken:Ljava/lang/String;

    const-string/jumbo v9, "UTF-8"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 121
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mIsValid:Z
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 132
    :cond_5
    :goto_2
    return-void

    .line 85
    .restart local v6    # "verb":Ljava/lang/String;
    :cond_6
    invoke-virtual {p3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getPathAndQueryString()Ljava/lang/String;

    move-result-object v4

    .line 86
    .local v4, "path":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 88
    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    .line 89
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    const-string/jumbo v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 91
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mPath:Ljava/lang/String;

    goto/16 :goto_0

    .line 102
    .end local v4    # "path":Ljava/lang/String;
    :cond_7
    invoke-virtual {p3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getBodyBytes()[B

    move-result-object v0

    .line 103
    .local v0, "body":[B
    if-eqz v0, :cond_4

    .line 105
    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mBody:[B

    goto/16 :goto_1

    .line 123
    .end local v0    # "body":[B
    .end local v6    # "verb":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 125
    .local v2, "e":Ljava/io/UnsupportedEncodingException;
    # getter for: Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->access$100()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "corpusbuilder: UnsupportedEncodingException error: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 127
    .end local v2    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_1
    move-exception v2

    .line 129
    .local v2, "e":Ljava/io/IOException;
    # getter for: Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->access$100()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "corpusbuilder: IOException error: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method


# virtual methods
.method public getCorpus()[B
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mCorpus:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    return-object v0
.end method

.method public getTimestamp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    return-object v0
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mIsValid:Z

    return v0
.end method

.method public validateComponents()Z
    .locals 2

    .prologue
    .line 136
    const/4 v0, 0x1

    .line 137
    .local v0, "result":Z
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mVerb:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mTimestamp:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner$CorpusBuilder;->mToken:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 139
    :cond_0
    const/4 v0, 0x0

    .line 141
    :cond_1
    return v0
.end method
