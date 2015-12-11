.class Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;
.super Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
.source "BackwardsCompatiableDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field final synthetic val$encryptKey:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;->this$0:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;->val$encryptKey:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;-><init>()V

    return-void
.end method


# virtual methods
.method protected getEncryptionKey()[B
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;->val$encryptKey:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    return-object v0
.end method
