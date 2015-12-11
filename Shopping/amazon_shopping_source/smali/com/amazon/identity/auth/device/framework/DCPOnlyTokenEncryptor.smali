.class public Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;
.super Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
.source "DCPOnlyTokenEncryptor.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sDcpOnlyEncryptionKey:[B


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;-><init>()V

    .line 22
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->mContext:Landroid/content/Context;

    .line 23
    return-void
.end method


# virtual methods
.method protected declared-synchronized getEncryptionKey()[B
    .locals 2

    .prologue
    .line 28
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->sDcpOnlyEncryptionKey:[B

    if-nez v0, :cond_0

    .line 30
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGetter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->getTokenKey()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not generate a MAP only encryption key. Aborting."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    sput-object v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->sDcpOnlyEncryptionKey:[B

    .line 33
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->sDcpOnlyEncryptionKey:[B
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 30
    :cond_1
    const/4 v1, 0x0

    :try_start_1
    invoke-static {v0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 28
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
