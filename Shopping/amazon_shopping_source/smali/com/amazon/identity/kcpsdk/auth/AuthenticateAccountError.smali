.class public final enum Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
.super Ljava/lang/Enum;
.source "AuthenticateAccountError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorServerError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

.field public static final enum AuthenticateAccountErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;


# instance fields
.field private final mBaseError:Lcom/amazon/identity/kcpsdk/auth/PandaError;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 13
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorMissingValue"

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorInvalidValue"

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorCredentialError"

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 16
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorServerError"

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServerError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorServerError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 17
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorServiceUnavailable"

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 18
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorUnknown"

    const/4 v2, 0x5

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 19
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    const-string/jumbo v1, "AuthenticateAccountErrorChallengeException"

    const/4 v2, 0x6

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;-><init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    .line 11
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorServerError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/amazon/identity/kcpsdk/auth/PandaError;)V
    .locals 0
    .param p3, "baseError"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/kcpsdk/auth/PandaError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 25
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->mBaseError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 26
    return-void
.end method

.method public static fromPandaError(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    .locals 5
    .param p0, "baseError"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 41
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->values()[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 43
    .local v1, "err":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    iget-object v4, v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->mBaseError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    if-ne v4, p0, :cond_0

    .line 48
    .end local v1    # "err":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    :goto_1
    return-object v1

    .line 41
    .restart local v1    # "err":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 48
    .end local v1    # "err":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    return-object v0
.end method


# virtual methods
.method public getErrorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->mBaseError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/PandaError;->getErrorString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->mBaseError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/PandaError;->getErrorString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
