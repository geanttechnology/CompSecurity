.class public final enum Lcom/amazon/mobile/mash/error/MASHError;
.super Ljava/lang/Enum;
.source "MASHError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/MASHError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum OPERATION_IN_PROGRESS:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum OUT_OF_MEM:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum PERMISSION_DENIED:Lcom/amazon/mobile/mash/error/MASHError;

.field private static final TAG:Ljava/lang/String;

.field public static final enum TIMEOUT:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

.field public static final enum USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 18
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "PERMISSION_DENIED"

    const/16 v2, 0x3e9

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->PERMISSION_DENIED:Lcom/amazon/mobile/mash/error/MASHError;

    .line 22
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "TIMEOUT"

    const/16 v2, 0x3ea

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->TIMEOUT:Lcom/amazon/mobile/mash/error/MASHError;

    .line 26
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "NOT_SUPPORTED"

    const/16 v2, 0x3eb

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    .line 30
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "OUT_OF_MEM"

    const/16 v2, 0x3ec

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->OUT_OF_MEM:Lcom/amazon/mobile/mash/error/MASHError;

    .line 34
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "UNKNOWN"

    const/16 v2, 0x3ed

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    .line 38
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "USER_CANCELLED"

    const/4 v2, 0x5

    const/16 v3, 0x3ee

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    .line 42
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "INVALID_ARGUMENTS"

    const/4 v2, 0x6

    const/16 v3, 0x3ef

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    .line 46
    new-instance v0, Lcom/amazon/mobile/mash/error/MASHError;

    const-string/jumbo v1, "OPERATION_IN_PROGRESS"

    const/4 v2, 0x7

    const/16 v3, 0x3f0

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/MASHError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->OPERATION_IN_PROGRESS:Lcom/amazon/mobile/mash/error/MASHError;

    .line 14
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/mobile/mash/error/MASHError;

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->PERMISSION_DENIED:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->TIMEOUT:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->OUT_OF_MEM:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->OPERATION_IN_PROGRESS:Lcom/amazon/mobile/mash/error/MASHError;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->$VALUES:[Lcom/amazon/mobile/mash/error/MASHError;

    .line 50
    const-class v0, Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/error/MASHError;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "error"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 57
    iput p3, p0, Lcom/amazon/mobile/mash/error/MASHError;->mErrorCode:I

    .line 58
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/MASHError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/mobile/mash/error/MASHError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/MASHError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/MASHError;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/mobile/mash/error/MASHError;->$VALUES:[Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/MASHError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/MASHError;

    return-object v0
.end method


# virtual methods
.method public getCode()I
    .locals 1

    .prologue
    .line 65
    iget v0, p0, Lcom/amazon/mobile/mash/error/MASHError;->mErrorCode:I

    return v0
.end method

.method public toJSONObejct()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 75
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 76
    .local v1, "errorObject":Lorg/json/JSONObject;
    const-string/jumbo v2, "code"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/error/MASHError;->getCode()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    .end local v1    # "errorObject":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 78
    :catch_0
    move-exception v0

    .line 79
    .local v0, "e":Lorg/json/JSONException;
    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Created a bad JSON object for MASH error. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    const/4 v1, 0x0

    goto :goto_0
.end method
