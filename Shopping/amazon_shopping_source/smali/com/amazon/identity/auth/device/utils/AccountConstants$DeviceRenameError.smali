.class public final enum Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
.super Ljava/lang/Enum;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DeviceRenameError"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum INVALID_INPUT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum NAME_ALREADY_USED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum NETWORK_FAILURE:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum NO_AMAZON_ACCOUNT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum PARSE_ERROR:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

.field public static final enum UNRECOGNIZED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;


# instance fields
.field private final mName:Ljava/lang/String;

.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 15
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "NETWORK_FAILURE"

    const-string/jumbo v2, "NetworkFailure"

    invoke-direct {v0, v1, v5, v5, v2}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 16
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "AUTHENTICATION_FAILED"

    const-string/jumbo v2, "AuthenticationFailed"

    invoke-direct {v0, v1, v6, v6, v2}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 17
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "PARSE_ERROR"

    const-string/jumbo v2, "ParseError"

    invoke-direct {v0, v1, v7, v7, v2}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 18
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "NO_AMAZON_ACCOUNT"

    const-string/jumbo v2, "NoAmazonAccount"

    invoke-direct {v0, v1, v8, v8, v2}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NO_AMAZON_ACCOUNT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 19
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "NAME_ALREADY_USED"

    const-string/jumbo v2, "NameAlreadyUsed"

    invoke-direct {v0, v1, v9, v9, v2}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NAME_ALREADY_USED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 20
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "INVALID_INPUT"

    const/4 v2, 0x5

    const/4 v3, 0x5

    const-string/jumbo v4, "InvalidInputs"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->INVALID_INPUT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 21
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    const-string/jumbo v1, "UNRECOGNIZED"

    const/4 v2, 0x6

    const/4 v3, 0x6

    const-string/jumbo v4, "Unrecognized"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    .line 13
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NO_AMAZON_ACCOUNT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v1, v0, v8

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->NAME_ALREADY_USED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v1, v0, v9

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->INVALID_INPUT:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->$VALUES:[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # I
    .param p4, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput p3, p0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->mValue:I

    .line 29
    iput-object p4, p0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->mName:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 44
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->values()[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 46
    .local v1, "error":Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 48
    return-object v1

    .line 44
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 52
    .end local v1    # "error":Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    :cond_1
    new-instance v4, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->$VALUES:[Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public value()I
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;->mValue:I

    return v0
.end method
