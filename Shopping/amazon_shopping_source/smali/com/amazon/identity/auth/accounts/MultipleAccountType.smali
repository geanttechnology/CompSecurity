.class public final enum Lcom/amazon/identity/auth/accounts/MultipleAccountType;
.super Ljava/lang/Enum;
.source "MultipleAccountType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/accounts/MultipleAccountType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/accounts/MultipleAccountType;

.field public static final enum Default:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

.field public static final enum Profile:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    const-string/jumbo v1, "Profile"

    const-string/jumbo v2, "Profile"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Profile:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    .line 12
    new-instance v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    const-string/jumbo v1, "Default"

    const-string/jumbo v2, "Default"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Default:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    .line 9
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Profile:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Default:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->$VALUES:[Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    .line 14
    const-class v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 20
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->mValue:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public static getCurrentProfileType(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v5

    const-string/jumbo v6, "multiple.account.type"

    const-string/jumbo v7, "Default"

    invoke-virtual {v5, v6, v7}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 28
    .local v4, "profileTypeValue":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->values()[Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 30
    .local v3, "possibleProfileType":Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    iget-object v5, v3, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->mValue:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 38
    .end local v3    # "possibleProfileType":Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    :goto_1
    return-object v3

    .line 28
    .restart local v3    # "possibleProfileType":Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 36
    .end local v3    # "possibleProfileType":Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    :cond_1
    sget-object v5, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Do not recongize %s as a profile type. Returning default"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v4, v7, v8

    invoke-static {v5, v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 38
    sget-object v3, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->Default:Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/accounts/MultipleAccountType;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountType;->$VALUES:[Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/accounts/MultipleAccountType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/accounts/MultipleAccountType;

    return-object v0
.end method
