.class public final enum Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
.super Ljava/lang/Enum;
.source "LaunchIntentURLError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/LaunchIntentURLError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

.field public static final enum INTENT_NOT_FOUND:Lcom/amazon/mobile/mash/error/LaunchIntentURLError;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    const-string/jumbo v1, "INTENT_NOT_FOUND"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->INTENT_NOT_FOUND:Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    .line 11
    new-array v0, v3, [Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    sget-object v1, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->INTENT_NOT_FOUND:Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->$VALUES:[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "code"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 24
    iput p3, p0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->mErrorCode:I

    .line 25
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->$VALUES:[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    return-object v0
.end method


# virtual methods
.method public toJSONObejct()Lorg/json/JSONObject;
    .locals 9

    .prologue
    .line 32
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 33
    .local v3, "errorObject":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->values()[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 34
    .local v2, "errorConstant":Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->name()Ljava/lang/String;

    move-result-object v6

    iget v7, v2, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->mErrorCode:I

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 33
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 36
    .end local v2    # "errorConstant":Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    :cond_0
    const-string/jumbo v6, "code"

    iget v7, p0, Lcom/amazon/mobile/mash/error/LaunchIntentURLError;->mErrorCode:I

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    .end local v0    # "arr$":[Lcom/amazon/mobile/mash/error/LaunchIntentURLError;
    .end local v3    # "errorObject":Lorg/json/JSONObject;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_1
    return-object v3

    .line 38
    :catch_0
    move-exception v1

    .line 39
    .local v1, "e":Lorg/json/JSONException;
    const-string/jumbo v6, "LaunchIntentURLError"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Bad JSON: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 40
    const/4 v3, 0x0

    goto :goto_1
.end method
