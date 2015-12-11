.class public final enum Lcom/amazon/mobile/mash/error/OpenFileChooserError;
.super Ljava/lang/Enum;
.source "OpenFileChooserError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/OpenFileChooserError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/OpenFileChooserError;

.field public static final enum CANNOT_OPEN_CAPTURE_MECHANISM:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

.field public static final enum FILE_NOT_FOUND:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

.field public static final enum FILE_SIZE_EXCEEDED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

.field public static final enum MIME_TYPE_NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x0

    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 20
    new-instance v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    const-string/jumbo v1, "CANNOT_OPEN_CAPTURE_MECHANISM"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->CANNOT_OPEN_CAPTURE_MECHANISM:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    .line 24
    new-instance v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    const-string/jumbo v1, "FILE_SIZE_EXCEEDED"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_SIZE_EXCEEDED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    .line 28
    new-instance v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    const-string/jumbo v1, "FILE_NOT_FOUND"

    invoke-direct {v0, v1, v3, v4}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_NOT_FOUND:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    .line 32
    new-instance v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    const-string/jumbo v1, "MIME_TYPE_NOT_SUPPORTED"

    invoke-direct {v0, v1, v4, v6}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->MIME_TYPE_NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    .line 16
    new-array v0, v6, [Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    sget-object v1, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->CANNOT_OPEN_CAPTURE_MECHANISM:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_SIZE_EXCEEDED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_NOT_FOUND:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->MIME_TYPE_NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->$VALUES:[Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    .line 36
    const-class v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->TAG:Ljava/lang/String;

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
    .line 41
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 42
    iput p3, p0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->mErrorCode:I

    .line 43
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->$VALUES:[Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/OpenFileChooserError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    return-object v0
.end method


# virtual methods
.method public getCode()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->mErrorCode:I

    return v0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 9

    .prologue
    .line 59
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 60
    .local v3, "errorObject":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->values()[Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 61
    .local v2, "errorConstant":Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->getCode()I

    move-result v7

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 60
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 63
    .end local v2    # "errorConstant":Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    :cond_0
    const-string/jumbo v6, "code"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->getCode()I

    move-result v7

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    .end local v0    # "arr$":[Lcom/amazon/mobile/mash/error/OpenFileChooserError;
    .end local v3    # "errorObject":Lorg/json/JSONObject;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_1
    return-object v3

    .line 65
    :catch_0
    move-exception v1

    .line 66
    .local v1, "e":Lorg/json/JSONException;
    sget-object v6, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "bad JSON: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 67
    const/4 v3, 0x0

    goto :goto_1
.end method
