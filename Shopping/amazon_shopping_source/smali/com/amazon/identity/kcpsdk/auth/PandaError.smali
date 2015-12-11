.class public final enum Lcom/amazon/identity/kcpsdk/auth/PandaError;
.super Ljava/lang/Enum;
.source "PandaError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/PandaError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorServerError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/PandaError;

.field public static final enum PandaErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/PandaError;


# instance fields
.field private final mErrorString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorMissingValue"

    const-string/jumbo v2, "One or more required values are missing"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorInvalidValue"

    const-string/jumbo v2, "One or more required valeus are invalid"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 11
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorCredentialError"

    const-string/jumbo v2, "The credential is invalid e.g. The email/password does not match our record"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 12
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorServerError"

    const-string/jumbo v2, "The server has encountered a runtime error"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServerError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 13
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorServiceUnavailable"

    const-string/jumbo v2, "The service is temporarily overloaded or unavailable, try again later"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorUnknown"

    const/4 v2, 0x5

    const-string/jumbo v3, "Unknown error"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    const-string/jumbo v1, "PandaErrorChallengeException"

    const/4 v2, 0x6

    const-string/jumbo v3, "Additional credentials are required"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaError;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .line 7
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/PandaError;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServerError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorChallengeException:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/PandaError;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "errorString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 21
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->mErrorString:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/PandaError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/PandaError;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/PandaError;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/PandaError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/PandaError;

    return-object v0
.end method


# virtual methods
.method public getErrorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->mErrorString:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 32
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaError;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaError;->mErrorString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
