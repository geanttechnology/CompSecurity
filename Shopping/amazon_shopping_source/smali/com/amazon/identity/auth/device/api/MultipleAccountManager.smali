.class public final Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.super Ljava/lang/Object;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$1;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;,
        Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 246
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 247
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 248
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mContext:Landroid/content/Context;

    .line 249
    new-instance v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    .line 250
    return-void
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 296
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v0

    return v0
.end method

.method public varargs getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 1
    .param p1, "accountMappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 260
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public varargs removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v0

    return v0
.end method

.method public varargs setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->mMultipleAccountsCommunication:Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v0

    return v0
.end method
