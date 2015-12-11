.class public final enum Lcom/amazon/identity/auth/device/api/RegistrationType;
.super Ljava/lang/Enum;
.source "RegistrationType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/RegistrationType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum FROM_ACCESS_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum FROM_ATMAIN:Lcom/amazon/identity/auth/device/api/RegistrationType;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum WITH_EXPLICIT_URL:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field public static final enum WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 22
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "WITH_LOGIN_CREDENTIALS"

    const-string/jumbo v2, "LoginCredentials"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 29
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "WITH_DEVICE_SECRET"

    const-string/jumbo v2, "DeviceSecret"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 42
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "WITH_EXPLICIT_URL"

    const-string/jumbo v2, "ExplicitUrl"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_EXPLICIT_URL:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 49
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "FROM_ATMAIN"

    const-string/jumbo v2, "ATMain"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ATMAIN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 68
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "FROM_AUTH_TOKEN"

    const-string/jumbo v2, "AuthToken"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 78
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "FROM_ACCESS_TOKEN"

    const/4 v2, 0x5

    const-string/jumbo v3, "AccessToken"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ACCESS_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 88
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "REGISTER_DELEGATED_ACCOUNT"

    const/4 v2, 0x6

    const-string/jumbo v3, "RegisterDelegatedAccount"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 98
    new-instance v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    const-string/jumbo v1, "WITH_DIRECTEDID_CREDENTIALS"

    const/4 v2, 0x7

    const-string/jumbo v3, "DirectedIdCredentials"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/api/RegistrationType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    .line 11
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/RegistrationType;

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_EXPLICIT_URL:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ATMAIN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ACCESS_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->$VALUES:[Lcom/amazon/identity/auth/device/api/RegistrationType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 103
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 104
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/RegistrationType;->mName:Ljava/lang/String;

    .line 105
    return-void
.end method

.method public static fromName(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/RegistrationType;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 114
    invoke-static {}, Lcom/amazon/identity/auth/device/api/RegistrationType;->values()[Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/api/RegistrationType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 116
    .local v3, "type":Lcom/amazon/identity/auth/device/api/RegistrationType;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 122
    .end local v3    # "type":Lcom/amazon/identity/auth/device/api/RegistrationType;
    :goto_1
    return-object v3

    .line 114
    .restart local v3    # "type":Lcom/amazon/identity/auth/device/api/RegistrationType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 122
    .end local v3    # "type":Lcom/amazon/identity/auth/device/api/RegistrationType;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/RegistrationType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/RegistrationType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/RegistrationType;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/identity/auth/device/api/RegistrationType;->$VALUES:[Lcom/amazon/identity/auth/device/api/RegistrationType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/RegistrationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/RegistrationType;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/RegistrationType;->mName:Ljava/lang/String;

    return-object v0
.end method
