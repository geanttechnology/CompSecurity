.class public final enum Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
.super Ljava/lang/Enum;
.source "CredentialStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

.field public static final enum CredentialStatusInvalid:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

.field public static final enum CredentialStatusOK:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

.field public static final enum CredentialStatusStale:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

.field public static final enum CredentialStatusUnknownError:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

.field public static final enum CredentialStatusUnknownWarning:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;


# instance fields
.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 6
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    const-string/jumbo v1, "CredentialStatusOK"

    invoke-direct {v0, v1, v2, v2}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusOK:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 7
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    const-string/jumbo v1, "CredentialStatusStale"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusStale:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    const-string/jumbo v1, "CredentialStatusInvalid"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusInvalid:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    const-string/jumbo v1, "CredentialStatusUnknownWarning"

    invoke-direct {v0, v1, v5, v5}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownWarning:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    const-string/jumbo v1, "CredentialStatusUnknownError"

    invoke-direct {v0, v1, v6, v6}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownError:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 4
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusOK:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusStale:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusInvalid:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownWarning:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownError:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "val"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 16
    iput p3, p0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->mValue:I

    .line 17
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    return-object v0
.end method


# virtual methods
.method public getValue()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->mValue:I

    return v0
.end method
