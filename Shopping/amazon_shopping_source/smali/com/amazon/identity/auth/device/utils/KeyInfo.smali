.class public final Lcom/amazon/identity/auth/device/utils/KeyInfo;
.super Ljava/lang/Object;
.source "KeyInfo.java"


# instance fields
.field private final mKey:Ljava/lang/String;

.field private final mPackageName:Ljava/lang/String;

.field private final mRawKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mRawKey:Ljava/lang/String;

    .line 26
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mPackageName:Ljava/lang/String;

    .line 27
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mKey:Ljava/lang/String;

    .line 28
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "rawKey"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mRawKey:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mPackageName:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mKey:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public static parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .locals 4
    .param p0, "rawKey"    # Ljava/lang/String;

    .prologue
    .line 39
    const/16 v3, 0x2f

    invoke-virtual {p0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 42
    .local v2, "separatorIndex":I
    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 44
    const/4 v1, 0x0

    .line 45
    .local v1, "packageName":Ljava/lang/String;
    move-object v0, p0

    .line 52
    .local v0, "key":Ljava/lang/String;
    :goto_0
    new-instance v3, Lcom/amazon/identity/auth/device/utils/KeyInfo;

    invoke-direct {v3, p0, v1, v0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    .line 49
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "packageName":Ljava/lang/String;
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {p0, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 50
    .restart local v1    # "packageName":Ljava/lang/String;
    add-int/lit8 v3, v2, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "key":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mKey:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method public getPackagelessKeyInfo()Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .locals 3

    .prologue
    .line 72
    new-instance v0, Lcom/amazon/identity/auth/device/utils/KeyInfo;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public getRawKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/KeyInfo;->mRawKey:Ljava/lang/String;

    return-object v0
.end method
