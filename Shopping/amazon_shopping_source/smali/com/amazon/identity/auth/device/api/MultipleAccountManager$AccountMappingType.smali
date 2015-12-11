.class public abstract Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
.super Ljava/lang/Object;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AccountMappingType"
.end annotation


# instance fields
.field private final mType:Ljava/lang/String;

.field private final mValue:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 63
    if-ne p0, p1, :cond_1

    .line 75
    :cond_0
    :goto_0
    return v1

    .line 68
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 70
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 73
    check-cast v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .line 75
    .local v0, "other":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getAccountMappingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    return-object v0
.end method

.method public getAccountMappingValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 53
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 56
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    if-nez v3, :cond_1

    :goto_1
    add-int/2addr v1, v2

    .line 57
    return v1

    .line 53
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mType:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 56
    .restart local v0    # "result":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->mValue:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_1
.end method
