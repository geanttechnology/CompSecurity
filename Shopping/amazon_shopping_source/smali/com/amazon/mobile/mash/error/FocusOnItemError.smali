.class public final enum Lcom/amazon/mobile/mash/error/FocusOnItemError;
.super Ljava/lang/Enum;
.source "FocusOnItemError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/FocusOnItemError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/FocusOnItemError;

.field public static final enum ITEM_CAN_NOT_BE_IN_FOCUS:Lcom/amazon/mobile/mash/error/FocusOnItemError;

.field public static final enum NOT_FOUND:Lcom/amazon/mobile/mash/error/FocusOnItemError;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 14
    new-instance v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;

    const-string/jumbo v1, "NOT_FOUND"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/mobile/mash/error/FocusOnItemError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->NOT_FOUND:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    .line 18
    new-instance v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;

    const-string/jumbo v1, "ITEM_CAN_NOT_BE_IN_FOCUS"

    invoke-direct {v0, v1, v2, v4}, Lcom/amazon/mobile/mash/error/FocusOnItemError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->ITEM_CAN_NOT_BE_IN_FOCUS:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    .line 10
    new-array v0, v4, [Lcom/amazon/mobile/mash/error/FocusOnItemError;

    sget-object v1, Lcom/amazon/mobile/mash/error/FocusOnItemError;->NOT_FOUND:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mobile/mash/error/FocusOnItemError;->ITEM_CAN_NOT_BE_IN_FOCUS:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->$VALUES:[Lcom/amazon/mobile/mash/error/FocusOnItemError;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 26
    iput p3, p0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->mErrorCode:I

    .line 27
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/FocusOnItemError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/FocusOnItemError;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->$VALUES:[Lcom/amazon/mobile/mash/error/FocusOnItemError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/FocusOnItemError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/FocusOnItemError;

    return-object v0
.end method


# virtual methods
.method public toJSONObejct()Lorg/json/JSONObject;
    .locals 9

    .prologue
    .line 33
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 34
    .local v3, "errorObject":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/mobile/mash/error/FocusOnItemError;->values()[Lcom/amazon/mobile/mash/error/FocusOnItemError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mobile/mash/error/FocusOnItemError;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 35
    .local v2, "errorConstant":Lcom/amazon/mobile/mash/error/FocusOnItemError;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/FocusOnItemError;->name()Ljava/lang/String;

    move-result-object v6

    iget v7, v2, Lcom/amazon/mobile/mash/error/FocusOnItemError;->mErrorCode:I

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 34
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 37
    .end local v2    # "errorConstant":Lcom/amazon/mobile/mash/error/FocusOnItemError;
    :cond_0
    const-string/jumbo v6, "code"

    iget v7, p0, Lcom/amazon/mobile/mash/error/FocusOnItemError;->mErrorCode:I

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    .end local v0    # "arr$":[Lcom/amazon/mobile/mash/error/FocusOnItemError;
    .end local v3    # "errorObject":Lorg/json/JSONObject;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_1
    return-object v3

    .line 39
    :catch_0
    move-exception v1

    .line 40
    .local v1, "e":Lorg/json/JSONException;
    const-string/jumbo v6, "FocusOnItemError"

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

    .line 41
    const/4 v3, 0x0

    goto :goto_1
.end method
