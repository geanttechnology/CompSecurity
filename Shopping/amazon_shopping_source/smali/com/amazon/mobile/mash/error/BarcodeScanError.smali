.class public final enum Lcom/amazon/mobile/mash/error/BarcodeScanError;
.super Ljava/lang/Enum;
.source "BarcodeScanError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/BarcodeScanError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/BarcodeScanError;

.field public static final enum CANNOT_OPEN_CAMERA:Lcom/amazon/mobile/mash/error/BarcodeScanError;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;

    const-string/jumbo v1, "CANNOT_OPEN_CAMERA"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/BarcodeScanError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->CANNOT_OPEN_CAMERA:Lcom/amazon/mobile/mash/error/BarcodeScanError;

    .line 18
    new-array v0, v3, [Lcom/amazon/mobile/mash/error/BarcodeScanError;

    sget-object v1, Lcom/amazon/mobile/mash/error/BarcodeScanError;->CANNOT_OPEN_CAMERA:Lcom/amazon/mobile/mash/error/BarcodeScanError;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->$VALUES:[Lcom/amazon/mobile/mash/error/BarcodeScanError;

    .line 26
    const-class v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->TAG:Ljava/lang/String;

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
    .line 31
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 32
    iput p3, p0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->mErrorCode:I

    .line 33
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/BarcodeScanError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/BarcodeScanError;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->$VALUES:[Lcom/amazon/mobile/mash/error/BarcodeScanError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/BarcodeScanError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/BarcodeScanError;

    return-object v0
.end method


# virtual methods
.method public getCode()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lcom/amazon/mobile/mash/error/BarcodeScanError;->mErrorCode:I

    return v0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 9

    .prologue
    .line 49
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 50
    .local v3, "errorObject":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/mobile/mash/error/BarcodeScanError;->values()[Lcom/amazon/mobile/mash/error/BarcodeScanError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mobile/mash/error/BarcodeScanError;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v1, v0, v4

    .line 51
    .local v1, "barcodeError":Lcom/amazon/mobile/mash/error/BarcodeScanError;
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/error/BarcodeScanError;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/error/BarcodeScanError;->getCode()I

    move-result v7

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 50
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 53
    .end local v1    # "barcodeError":Lcom/amazon/mobile/mash/error/BarcodeScanError;
    :cond_0
    const-string/jumbo v6, "code"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/error/BarcodeScanError;->getCode()I

    move-result v7

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    .end local v0    # "arr$":[Lcom/amazon/mobile/mash/error/BarcodeScanError;
    .end local v3    # "errorObject":Lorg/json/JSONObject;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_1
    return-object v3

    .line 55
    :catch_0
    move-exception v2

    .line 56
    .local v2, "e":Lorg/json/JSONException;
    sget-object v6, Lcom/amazon/mobile/mash/error/BarcodeScanError;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "bad JSON: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    const/4 v3, 0x0

    goto :goto_1
.end method
