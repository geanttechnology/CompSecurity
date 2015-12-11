.class final Lcom/poshmark/data_model/models/PMErrorType$1;
.super Ljava/util/HashMap;
.source "PMErrorType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/PMErrorType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Lcom/poshmark/data_model/models/PMErrorType;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 40
    const-string v0, "UsernameTakenError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->USERNAME_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    const-string v0, "EmailTakenError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->EMAIL_TAKEN:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    const-string v0, "InvalidReferralCodeError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_REFERRAL_CODE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    const-string v0, "InsufficientPrivilegesError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->INSUFFICIENT_PRIVILEGES_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    const-string v0, "ExternalUserIdTakenError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    const-string v0, "PostValidationError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_LISTING:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    const-string v0, "BrandChangeError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_CHANGE_LIMIT_EXCEEDED:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    const-string v0, "ExternalAuthenticationError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_AUTH_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    const-string v0, "BrandFollowingListError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_FOLLOWING_LIST_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    const-string v0, "AlreadyExistsError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->ALREADY_EXISTS_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    const-string v0, "NotFoundError"

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/data_model/models/PMErrorType$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    return-void
.end method
