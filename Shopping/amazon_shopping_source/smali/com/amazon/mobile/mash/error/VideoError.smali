.class public final enum Lcom/amazon/mobile/mash/error/VideoError;
.super Ljava/lang/Enum;
.source "VideoError.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/error/VideoError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/error/VideoError;

.field public static final enum NO_VIDEO_PLAYER_FOUND:Lcom/amazon/mobile/mash/error/VideoError;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mErrorCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 20
    new-instance v0, Lcom/amazon/mobile/mash/error/VideoError;

    const-string/jumbo v1, "NO_VIDEO_PLAYER_FOUND"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/error/VideoError;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/error/VideoError;->NO_VIDEO_PLAYER_FOUND:Lcom/amazon/mobile/mash/error/VideoError;

    .line 16
    new-array v0, v3, [Lcom/amazon/mobile/mash/error/VideoError;

    sget-object v1, Lcom/amazon/mobile/mash/error/VideoError;->NO_VIDEO_PLAYER_FOUND:Lcom/amazon/mobile/mash/error/VideoError;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mobile/mash/error/VideoError;->$VALUES:[Lcom/amazon/mobile/mash/error/VideoError;

    .line 24
    const-class v0, Lcom/amazon/mobile/mash/error/VideoError;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/error/VideoError;->TAG:Ljava/lang/String;

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
    .line 29
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 30
    iput p3, p0, Lcom/amazon/mobile/mash/error/VideoError;->mErrorCode:I

    .line 31
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/error/VideoError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/amazon/mobile/mash/error/VideoError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/error/VideoError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/error/VideoError;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/amazon/mobile/mash/error/VideoError;->$VALUES:[Lcom/amazon/mobile/mash/error/VideoError;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/error/VideoError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/error/VideoError;

    return-object v0
.end method


# virtual methods
.method public getCode()I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/amazon/mobile/mash/error/VideoError;->mErrorCode:I

    return v0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 9

    .prologue
    .line 47
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 48
    .local v2, "errorObject":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/mobile/mash/error/VideoError;->values()[Lcom/amazon/mobile/mash/error/VideoError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mobile/mash/error/VideoError;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v5, v0, v3

    .line 49
    .local v5, "videoError":Lcom/amazon/mobile/mash/error/VideoError;
    invoke-virtual {v5}, Lcom/amazon/mobile/mash/error/VideoError;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/error/VideoError;->getCode()I

    move-result v7

    invoke-virtual {v2, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 48
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 51
    .end local v5    # "videoError":Lcom/amazon/mobile/mash/error/VideoError;
    :cond_0
    const-string/jumbo v6, "code"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/error/VideoError;->getCode()I

    move-result v7

    invoke-virtual {v2, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 55
    .end local v0    # "arr$":[Lcom/amazon/mobile/mash/error/VideoError;
    .end local v2    # "errorObject":Lorg/json/JSONObject;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :goto_1
    return-object v2

    .line 53
    :catch_0
    move-exception v1

    .line 54
    .local v1, "e":Lorg/json/JSONException;
    sget-object v6, Lcom/amazon/mobile/mash/error/VideoError;->TAG:Ljava/lang/String;

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

    .line 55
    const/4 v2, 0x0

    goto :goto_1
.end method
