.class final Lcom/adobe/mobile/MessageTemplateCallback;
.super Lcom/adobe/mobile/Message;
.source "MessageTemplateCallback.java"


# static fields
.field private static final ADB_TEMPLATE_CALLBACK_BODY:Ljava/lang/String; = "templatebody"

.field private static final ADB_TEMPLATE_CALLBACK_TIMEOUT:Ljava/lang/String; = "timeout"

.field private static final ADB_TEMPLATE_CALLBACK_TYPE:Ljava/lang/String; = "contenttype"

.field private static final ADB_TEMPLATE_CALLBACK_URL:Ljava/lang/String; = "templateurl"

.field private static final ADB_TEMPLATE_TIMEOUT_DEFAULT:I = 0x2

.field private static final ADB_TEMPLATE_TOKEN_END:C = '}'

.field private static final ADB_TEMPLATE_TOKEN_START:C = '{'

.field private static final tokenDataMask:[Z


# instance fields
.field private _combinedVariablesCopy:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected contentType:Ljava/lang/String;

.field private final randomGen:Ljava/security/SecureRandom;

.field protected templateBody:Ljava/lang/String;

.field protected templateUrl:Ljava/lang/String;

.field protected timeout:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 251
    const/16 v0, 0x100

    new-array v0, v0, [Z

    fill-array-data v0, :array_0

    sput-object v0, Lcom/adobe/mobile/MessageTemplateCallback;->tokenDataMask:[Z

    return-void

    :array_0
    .array-data 1
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x1t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x1t
        0x0t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x0t
        0x0t
        0x0t
        0x0t
        0x1t
        0x0t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
    .end array-data
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/adobe/mobile/Message;-><init>()V

    .line 39
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    iput-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->randomGen:Ljava/security/SecureRandom;

    return-void
.end method

.method private buildExpansionsForTokens(Ljava/util/ArrayList;)Ljava/util/HashMap;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "tokens":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-direct {v1, v5}, Ljava/util/HashMap;-><init>(I)V

    .line 192
    .local v1, "expansions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 193
    .local v2, "token":Ljava/lang/String;
    const/4 v6, 0x1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v2, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 194
    .local v0, "cleanToken":Ljava/lang/String;
    iget-object v6, p0, Lcom/adobe/mobile/MessageTemplateCallback;->_combinedVariablesCopy:Ljava/util/HashMap;

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 195
    .local v3, "tokenObject":Ljava/lang/Object;
    if-nez v3, :cond_0

    const-string v4, ""

    .line 196
    .local v4, "tokenString":Ljava/lang/String;
    :goto_1
    invoke-static {v4}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v2, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 195
    .end local v4    # "tokenString":Ljava/lang/String;
    :cond_0
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 199
    .end local v0    # "cleanToken":Ljava/lang/String;
    .end local v2    # "token":Ljava/lang/String;
    .end local v3    # "tokenObject":Ljava/lang/Object;
    :cond_1
    return-object v1
.end method

.method private findTokensForExpansion(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 7
    .param p1, "input"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 203
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-gtz v5, :cond_2

    .line 204
    :cond_0
    const/4 v0, 0x0

    .line 245
    :cond_1
    return-object v0

    .line 208
    :cond_2
    new-instance v0, Ljava/util/ArrayList;

    const/16 v5, 0x20

    invoke-direct {v0, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 210
    .local v0, "foundList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    .line 213
    .local v2, "inputLength":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 215
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x7b

    if-ne v5, v6, :cond_4

    .line 218
    add-int/lit8 v3, v1, 0x1

    .local v3, "j":I
    :goto_1
    if-ge v3, v2, :cond_3

    .line 219
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x7d

    if-ne v5, v6, :cond_5

    .line 225
    :cond_3
    if-eq v3, v2, :cond_1

    .line 230
    add-int/lit8 v5, v3, 0x1

    invoke-virtual {p1, v1, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 233
    .local v4, "token":Ljava/lang/String;
    const/4 v5, 0x1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/adobe/mobile/MessageTemplateCallback;->tokenIsValid(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 213
    .end local v3    # "j":I
    .end local v4    # "token":Ljava/lang/String;
    :cond_4
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 218
    .restart local v3    # "j":I
    :cond_5
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 238
    .restart local v4    # "token":Ljava/lang/String;
    :cond_6
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 241
    move v1, v3

    goto :goto_2
.end method

.method private getMapForTemplatedTokens()Ljava/util/HashMap;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 177
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 179
    .local v0, "tokens":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "%sdkver%"

    const-string v2, "4.6.0-AN"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    const-string v1, "%cachebust%"

    iget-object v2, p0, Lcom/adobe/mobile/MessageTemplateCallback;->randomGen:Ljava/security/SecureRandom;

    const v3, 0x5f5e100

    invoke-virtual {v2, v3}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    const-string v1, "%timestampu%"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    const-string v1, "%timestampz%"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getIso8601Date()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    const-string v1, "%adid%"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    const-string v1, "%pushid%"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getPushIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    return-object v0
.end method

.method private tokenIsValid(Ljava/lang/String;)Z
    .locals 9
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 272
    :try_start_0
    const-string v5, "UTF-8"

    invoke-virtual {p1, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    .line 275
    .local v2, "utf8Token":[B
    array-length v6, v2

    move v5, v3

    :goto_0
    if-ge v5, v6, :cond_1

    aget-byte v0, v2, v5

    .line 277
    .local v0, "currentByte":B
    sget-object v7, Lcom/adobe/mobile/MessageTemplateCallback;->tokenDataMask:[Z

    and-int/lit16 v8, v0, 0xff

    aget-boolean v7, v7, v8
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    if-nez v7, :cond_0

    .line 287
    .end local v0    # "currentByte":B
    .end local v2    # "utf8Token":[B
    :goto_1
    return v3

    .line 275
    .restart local v0    # "currentByte":B
    .restart local v2    # "utf8Token":[B
    :cond_0
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 282
    .end local v0    # "currentByte":B
    .end local v2    # "utf8Token":[B
    :catch_0
    move-exception v1

    .line 283
    .local v1, "ex":Ljava/io/UnsupportedEncodingException;
    const-string v5, "Data Callback - Unable to validate token (%s)"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/UnsupportedEncodingException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v3

    invoke-static {v5, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .end local v1    # "ex":Ljava/io/UnsupportedEncodingException;
    .restart local v2    # "utf8Token":[B
    :cond_1
    move v3, v4

    .line 287
    goto :goto_1
.end method


# virtual methods
.method protected initWithPayloadObject(Lorg/json/JSONObject;)Z
    .locals 11
    .param p1, "dictionary"    # Lorg/json/JSONObject;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 57
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONObject;->length()I

    move-result v7

    if-gtz v7, :cond_1

    .line 138
    :cond_0
    :goto_0
    return v5

    .line 62
    :cond_1
    invoke-super {p0, p1}, Lcom/adobe/mobile/Message;->initWithPayloadObject(Lorg/json/JSONObject;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 69
    :try_start_0
    const-string v7, "payload"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 70
    .local v3, "jsonPayload":Lorg/json/JSONObject;
    invoke-virtual {v3}, Lorg/json/JSONObject;->length()I

    move-result v7

    if-gtz v7, :cond_2

    .line 71
    const-string v7, "Data Callback - Unable to create data callback \"%s\", \"payload\" is empty"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/adobe/mobile/MessageTemplateCallback;->messageId:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 75
    .end local v3    # "jsonPayload":Lorg/json/JSONObject;
    :catch_0
    move-exception v2

    .line 76
    .local v2, "ex":Lorg/json/JSONException;
    const-string v7, "Data Callback - Unable to create create data callback \"%s\", \"payload\" is required"

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/adobe/mobile/MessageTemplateCallback;->messageId:Ljava/lang/String;

    aput-object v8, v6, v5

    invoke-static {v7, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 82
    .end local v2    # "ex":Lorg/json/JSONException;
    .restart local v3    # "jsonPayload":Lorg/json/JSONObject;
    :cond_2
    :try_start_1
    const-string v7, "templateurl"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateUrl:Ljava/lang/String;

    .line 83
    iget-object v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateUrl:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-gtz v7, :cond_3

    .line 84
    const-string v7, "Data Callback - Unable to create data callback \"%s\", \"templateurl\" is empty"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/adobe/mobile/MessageTemplateCallback;->messageId:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 88
    :catch_1
    move-exception v2

    .line 89
    .restart local v2    # "ex":Lorg/json/JSONException;
    const-string v7, "Data Callback - Unable to create data callback \"%s\", \"templateurl\" is required"

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/adobe/mobile/MessageTemplateCallback;->messageId:Ljava/lang/String;

    aput-object v8, v6, v5

    invoke-static {v7, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 95
    .end local v2    # "ex":Lorg/json/JSONException;
    :cond_3
    :try_start_2
    const-string v7, "timeout"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v7

    iput v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->timeout:I
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 105
    :goto_1
    :try_start_3
    const-string v7, "templatebody"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 106
    .local v4, "tempBody":Ljava/lang/String;
    if-eqz v4, :cond_4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_4

    .line 108
    const/4 v7, 0x0

    invoke-static {v4, v7}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 110
    .local v1, "decodedBytes":[B
    if-eqz v1, :cond_4

    .line 111
    new-instance v0, Ljava/lang/String;

    const-string v7, "UTF-8"

    invoke-direct {v0, v1, v7}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 112
    .local v0, "decodedBody":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_4

    .line 113
    iput-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_5

    .line 129
    .end local v0    # "decodedBody":Ljava/lang/String;
    .end local v1    # "decodedBytes":[B
    .end local v4    # "tempBody":Ljava/lang/String;
    :cond_4
    :goto_2
    iget-object v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_5

    .line 131
    :try_start_4
    const-string v7, "contenttype"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->contentType:Ljava/lang/String;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_6

    :cond_5
    :goto_3
    move v5, v6

    .line 138
    goto/16 :goto_0

    .line 97
    :catch_2
    move-exception v2

    .line 98
    .restart local v2    # "ex":Lorg/json/JSONException;
    const-string v7, "Data Callback - Tried to read \"timeout\" for data callback, but found none.  Using default value of two (2) seconds"

    new-array v8, v5, [Ljava/lang/Object;

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 99
    const/4 v7, 0x2

    iput v7, p0, Lcom/adobe/mobile/MessageTemplateCallback;->timeout:I

    goto :goto_1

    .line 118
    .end local v2    # "ex":Lorg/json/JSONException;
    :catch_3
    move-exception v2

    .line 119
    .restart local v2    # "ex":Lorg/json/JSONException;
    const-string v7, "Data Callback - Tried to read \"templatebody\" for data callback, but found none.  This is not a required field"

    new-array v8, v5, [Ljava/lang/Object;

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 121
    .end local v2    # "ex":Lorg/json/JSONException;
    :catch_4
    move-exception v2

    .line 122
    .local v2, "ex":Ljava/io/UnsupportedEncodingException;
    const-string v7, "Data Callback - Failed to decode \"templatebody\" for data callback (%s).  This is not a required field"

    new-array v8, v6, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/io/UnsupportedEncodingException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 124
    .end local v2    # "ex":Ljava/io/UnsupportedEncodingException;
    :catch_5
    move-exception v2

    .line 125
    .local v2, "ex":Ljava/lang/IllegalArgumentException;
    const-string v7, "Data Callback - Failed to decode \"templatebody\" for data callback (%s).  This is not a required field"

    new-array v8, v6, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/IllegalArgumentException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 133
    .end local v2    # "ex":Ljava/lang/IllegalArgumentException;
    :catch_6
    move-exception v2

    .line 134
    .local v2, "ex":Lorg/json/JSONException;
    const-string v7, "Data Callback - Tried to read \"contenttype\" for data callback, but found none.  This is not a required field"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v7, v5}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3
.end method

.method protected shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "vars":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p3, "lifecycleData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_2

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p2}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 145
    .local v0, "combinedVars":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    if-eqz p1, :cond_0

    .line 146
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 149
    :cond_0
    if-eqz p3, :cond_1

    .line 150
    invoke-virtual {v0, p3}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 153
    :cond_1
    invoke-direct {p0}, Lcom/adobe/mobile/MessageTemplateCallback;->getMapForTemplatedTokens()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 155
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1, v0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v1, p0, Lcom/adobe/mobile/MessageTemplateCallback;->_combinedVariablesCopy:Ljava/util/HashMap;

    .line 157
    invoke-super {p0, p1, p2, p3}, Lcom/adobe/mobile/Message;->shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v1

    return v1

    .line 143
    .end local v0    # "combinedVars":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    goto :goto_0
.end method

.method protected show()V
    .locals 10

    .prologue
    .line 164
    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateUrl:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/adobe/mobile/MessageTemplateCallback;->findTokensForExpansion(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mobile/MessageTemplateCallback;->buildExpansionsForTokens(Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v9

    .line 165
    .local v9, "urlExpansions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateUrl:Ljava/lang/String;

    invoke-static {v0, v9}, Lcom/adobe/mobile/StaticMethods;->expandTokens(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    .line 167
    .local v1, "expandedUrl":Ljava/lang/String;
    const/4 v2, 0x0

    .line 168
    .local v2, "expandedBody":Ljava/lang/String;
    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 169
    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/adobe/mobile/MessageTemplateCallback;->findTokensForExpansion(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mobile/MessageTemplateCallback;->buildExpansionsForTokens(Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v8

    .line 170
    .local v8, "bodyExpansions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/adobe/mobile/MessageTemplateCallback;->templateBody:Ljava/lang/String;

    invoke-static {v0, v8}, Lcom/adobe/mobile/StaticMethods;->expandTokens(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    .line 172
    .end local v8    # "bodyExpansions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    const-string v0, "Data Callback - Attempting to send request (url:%s body:%s contentType:%s)"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    const/4 v4, 0x1

    aput-object v2, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lcom/adobe/mobile/MessageTemplateCallback;->contentType:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 173
    invoke-static {}, Lcom/adobe/mobile/ThirdPartyQueue;->sharedInstance()Lcom/adobe/mobile/ThirdPartyQueue;

    move-result-object v0

    iget-object v3, p0, Lcom/adobe/mobile/MessageTemplateCallback;->contentType:Ljava/lang/String;

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v4

    iget v6, p0, Lcom/adobe/mobile/MessageTemplateCallback;->timeout:I

    int-to-long v6, v6

    invoke-virtual/range {v0 .. v7}, Lcom/adobe/mobile/ThirdPartyQueue;->queue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V

    .line 174
    return-void
.end method
