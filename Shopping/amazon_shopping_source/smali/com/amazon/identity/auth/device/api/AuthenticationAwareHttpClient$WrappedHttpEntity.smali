.class Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;
.super Ljava/lang/Object;
.source "AuthenticationAwareHttpClient.java"

# interfaces
.implements Ljava/lang/Cloneable;
.implements Lorg/apache/http/HttpEntity;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WrappedHttpEntity"
.end annotation


# static fields
.field private static sSyncObj:[Ljava/lang/Object;


# instance fields
.field private mContentBytes:[B

.field private final mInnerHttpEntity:Lorg/apache/http/HttpEntity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->sSyncObj:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lorg/apache/http/HttpEntity;)V
    .locals 0
    .param p1, "innerHttpEntity"    # Lorg/apache/http/HttpEntity;

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    .line 80
    return-void
.end method

.method private constructor <init>(Lorg/apache/http/HttpEntity;[B)V
    .locals 0
    .param p1, "innerHttpEntity"    # Lorg/apache/http/HttpEntity;
    .param p2, "contentBytes"    # [B

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    .line 86
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mContentBytes:[B

    .line 87
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 165
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    instance-of v1, v1, Ljava/lang/Cloneable;

    if-nez v1, :cond_0

    .line 167
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    .line 197
    :goto_0
    return-object v1

    .line 170
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string/jumbo v2, "clone"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/HttpEntity;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_4

    .line 197
    .local v0, "clonedInnerHttpEntity":Lorg/apache/http/HttpEntity;
    new-instance v1, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mContentBytes:[B

    invoke-direct {v1, v0, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;-><init>(Lorg/apache/http/HttpEntity;[B)V

    goto :goto_0

    .line 178
    .end local v0    # "clonedInnerHttpEntity":Lorg/apache/http/HttpEntity;
    :catch_0
    move-exception v1

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 182
    :catch_1
    move-exception v1

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 186
    :catch_2
    move-exception v1

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 190
    :catch_3
    move-exception v1

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 194
    :catch_4
    move-exception v1

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public consumeContent()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 93
    return-void
.end method

.method public getContent()Ljava/io/InputStream;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 103
    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->sSyncObj:[Ljava/lang/Object;

    monitor-enter v1

    .line 105
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->isRepeatable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    monitor-exit v1

    .line 115
    :goto_0
    return-object v0

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mContentBytes:[B

    if-nez v0, :cond_1

    .line 112
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mContentBytes:[B

    .line 115
    :cond_1
    new-instance v0, Ljava/io/ByteArrayInputStream;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mContentBytes:[B

    invoke-direct {v0, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 116
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getContentEncoding()Lorg/apache/http/Header;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContentEncoding()Lorg/apache/http/Header;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v0

    return-wide v0
.end method

.method public getContentType()Lorg/apache/http/Header;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContentType()Lorg/apache/http/Header;

    move-result-object v0

    return-object v0
.end method

.method public isChunked()Z
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->isChunked()Z

    move-result v0

    return v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->isRepeatable()Z

    move-result v0

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->isStreaming()Z

    move-result v0

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 1
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;->mInnerHttpEntity:Lorg/apache/http/HttpEntity;

    invoke-interface {v0, p1}, Lorg/apache/http/HttpEntity;->writeTo(Ljava/io/OutputStream;)V

    .line 159
    return-void
.end method
