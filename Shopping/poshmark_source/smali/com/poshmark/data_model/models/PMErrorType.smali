.class public final enum Lcom/poshmark/data_model/models/PMErrorType;
.super Ljava/lang/Enum;
.source "PMErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/PMErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum ALREADY_EXISTS_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum BRAND_CHANGE_LIMIT_EXCEEDED:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum BRAND_FOLLOWING_LIST_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum EMAIL_TAKEN:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum EXTERNAL_AUTH_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum FB_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum GOOGLE_PLUS_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_ACCESS_FORBIDDEN:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_BAD_REQUEST:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_INTERNAL_SERVER_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_SERVER_UNAVAILABLE:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum HTTP_UNAUTHORIZED:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum INSUFFICIENT_PRIVILEGES_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum INVALID_LISTING:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum INVALID_REFERRAL_CODE:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum JSON_PARSING_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum PINTEREST_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum TM_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum TW_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static final enum USERNAME_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

.field public static errorMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/PMErrorType;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "UNKNOWN_ERROR"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 10
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "CONNECTION_FAILURE"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 11
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "CONNECTION_TIMEOUT"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

    .line 12
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "JSON_PARSING_ERROR"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->JSON_PARSING_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 13
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_NOT_FOUND"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    .line 14
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_GONE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 15
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_INTERNAL_SERVER_ERROR"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_INTERNAL_SERVER_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 16
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_BAD_REQUEST"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_BAD_REQUEST:Lcom/poshmark/data_model/models/PMErrorType;

    .line 17
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_UNAUTHORIZED"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_UNAUTHORIZED:Lcom/poshmark/data_model/models/PMErrorType;

    .line 18
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_ACCESS_FORBIDDEN"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ACCESS_FORBIDDEN:Lcom/poshmark/data_model/models/PMErrorType;

    .line 19
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_SERVER_UNAVAILABLE"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_SERVER_UNAVAILABLE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 20
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "HTTP_ERROR"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 21
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "USERNAME_TAKEN_ERROR"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->USERNAME_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 22
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "EMAIL_TAKEN"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->EMAIL_TAKEN:Lcom/poshmark/data_model/models/PMErrorType;

    .line 23
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "INVALID_REFERRAL_CODE"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_REFERRAL_CODE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 24
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "INSUFFICIENT_PRIVILEGES_ERROR"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->INSUFFICIENT_PRIVILEGES_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 25
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "FB_LOGIN_ERROR"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->FB_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 26
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "GOOGLE_PLUS_LOGIN_ERROR"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->GOOGLE_PLUS_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 27
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "EXTERNAL_ID_TAKEN_ERROR"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 28
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "TW_LOGIN_ERROR"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->TW_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 29
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "INVALID_LISTING"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_LISTING:Lcom/poshmark/data_model/models/PMErrorType;

    .line 30
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "BRAND_CHANGE_LIMIT_EXCEEDED"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_CHANGE_LIMIT_EXCEEDED:Lcom/poshmark/data_model/models/PMErrorType;

    .line 31
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "BRAND_FOLLOWING_LIST_ERROR"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_FOLLOWING_LIST_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 32
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "TM_LOGIN_ERROR"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->TM_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 33
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "EXTERNAL_AUTH_ERROR"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_AUTH_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 34
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "ALREADY_EXISTS_ERROR"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->ALREADY_EXISTS_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 35
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType;

    const-string v1, "PINTEREST_LOGIN_ERROR"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->PINTEREST_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 6
    const/16 v0, 0x1b

    new-array v0, v0, [Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->JSON_PARSING_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_INTERNAL_SERVER_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_BAD_REQUEST:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_UNAUTHORIZED:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ACCESS_FORBIDDEN:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_SERVER_UNAVAILABLE:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->USERNAME_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->EMAIL_TAKEN:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_REFERRAL_CODE:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->INSUFFICIENT_PRIVILEGES_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->FB_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->GOOGLE_PLUS_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->TW_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_LISTING:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_CHANGE_LIMIT_EXCEEDED:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_FOLLOWING_LIST_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->TM_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_AUTH_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->ALREADY_EXISTS_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->PINTEREST_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->$VALUES:[Lcom/poshmark/data_model/models/PMErrorType;

    .line 38
    new-instance v0, Lcom/poshmark/data_model/models/PMErrorType$1;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/PMErrorType$1;-><init>()V

    sput-object v0, Lcom/poshmark/data_model/models/PMErrorType;->errorMap:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/PMErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/poshmark/data_model/models/PMErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMErrorType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/PMErrorType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->$VALUES:[Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/PMErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/PMErrorType;

    return-object v0
.end method
