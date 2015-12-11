.class public final enum Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
.super Ljava/lang/Enum;
.source "BuildConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/utils/BuildConfiguration;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

.field public static final enum Eng:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

.field public static final enum ReleaseDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

.field public static final enum User:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

.field public static final enum UserDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;


# instance fields
.field private final mSignedWith:Lcom/amazon/identity/auth/device/utils/KeyType;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    const-string/jumbo v1, "Eng"

    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyType;->Debug:Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/utils/KeyType;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->Eng:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    .line 12
    new-instance v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    const-string/jumbo v1, "UserDebug"

    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyType;->Release:Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/utils/KeyType;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->UserDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    .line 13
    new-instance v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    const-string/jumbo v1, "User"

    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyType;->Release:Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/utils/KeyType;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->User:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    .line 16
    new-instance v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    const-string/jumbo v1, "ReleaseDebug"

    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyType;->ReleaseDebug:Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/utils/KeyType;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->ReleaseDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    .line 9
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    sget-object v1, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->Eng:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->UserDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->User:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->ReleaseDebug:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->$VALUES:[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/utils/KeyType;)V
    .locals 0
    .param p3, "key"    # Lcom/amazon/identity/auth/device/utils/KeyType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/utils/KeyType;",
            ")V"
        }
    .end annotation

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 22
    iput-object p3, p0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->mSignedWith:Lcom/amazon/identity/auth/device/utils/KeyType;

    .line 23
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    .locals 7
    .param p0, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException;
        }
    .end annotation

    .prologue
    .line 32
    if-nez p0, :cond_0

    .line 34
    new-instance v4, Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException;

    const-string/jumbo v5, "Null is not a valid BuildType"

    invoke-direct {v4, v5}, Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 37
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->values()[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 39
    .local v3, "type":Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->toString()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v4, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 41
    return-object v3

    .line 37
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 45
    .end local v3    # "type":Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    :cond_2
    new-instance v4, Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Unknown build type: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->$VALUES:[Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    return-object v0
.end method


# virtual methods
.method public isSignedWith(Lcom/amazon/identity/auth/device/utils/KeyType;)Z
    .locals 1
    .param p1, "key"    # Lcom/amazon/identity/auth/device/utils/KeyType;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->mSignedWith:Lcom/amazon/identity/auth/device/utils/KeyType;

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
