.class public final enum Lcom/amazon/identity/auth/device/api/AuthenticationType;
.super Ljava/lang/Enum;
.source "AuthenticationType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/AuthenticationType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/AuthenticationType;

.field public static final enum ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

.field public static final enum DeviceAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

.field public static final enum None:Lcom/amazon/identity/auth/device/api/AuthenticationType;

.field public static final enum OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;


# instance fields
.field private final mRequireHttps:Z

.field private final mValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    const-string/jumbo v1, "None"

    const-string/jumbo v2, "None"

    invoke-direct {v0, v1, v3, v2, v3}, Lcom/amazon/identity/auth/device/api/AuthenticationType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->None:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .line 13
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    const-string/jumbo v1, "DeviceAuthenticator"

    const-string/jumbo v2, "DeviceAuthenticator"

    invoke-direct {v0, v1, v4, v2, v3}, Lcom/amazon/identity/auth/device/api/AuthenticationType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->DeviceAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .line 17
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    const-string/jumbo v1, "ADPAuthenticator"

    const-string/jumbo v2, "ADPAuthenticator"

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/amazon/identity/auth/device/api/AuthenticationType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .line 21
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    const-string/jumbo v1, "OAuth"

    const-string/jumbo v2, "OAuth"

    invoke-direct {v0, v1, v6, v2, v4}, Lcom/amazon/identity/auth/device/api/AuthenticationType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .line 4
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/AuthenticationType;

    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationType;->None:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationType;->DeviceAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->$VALUES:[Lcom/amazon/identity/auth/device/api/AuthenticationType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "requireHttps"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->mValue:Ljava/lang/String;

    .line 29
    iput-boolean p4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->mRequireHttps:Z

    .line 30
    return-void
.end method

.method public static parse(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;
    .locals 6
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 48
    if-nez p0, :cond_1

    move-object v1, v4

    .line 61
    :cond_0
    :goto_0
    return-object v1

    .line 53
    :cond_1
    invoke-static {}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->values()[Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/api/AuthenticationType;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_2

    aget-object v1, v0, v2

    .line 55
    .local v1, "authType":Lcom/amazon/identity/auth/device/api/AuthenticationType;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 53
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v1    # "authType":Lcom/amazon/identity/auth/device/api/AuthenticationType;
    :cond_2
    move-object v1, v4

    .line 61
    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/AuthenticationType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->$VALUES:[Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/AuthenticationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/AuthenticationType;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public requireHttps()Z
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->mRequireHttps:Z

    return v0
.end method
