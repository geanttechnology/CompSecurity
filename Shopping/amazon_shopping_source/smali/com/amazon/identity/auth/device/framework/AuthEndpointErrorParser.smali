.class public Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;
.super Ljava/lang/Object;
.source "AuthEndpointErrorParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;,
        Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    }
.end annotation


# static fields
.field static final CODE_STRING_KEY:Ljava/lang/String; = "code"

.field static final DETAIL_STRING_KEY:Ljava/lang/String; = "detail"

.field static final ERROR_OBEJCT_KEY:Ljava/lang/String; = "error"

.field public static final GENERIC_ERROR:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

.field static final MESSAGE_STRING_KEY:Ljava/lang/String; = "message"

.field static final REQUEST_ID_STRING_KEY:Ljava/lang/String; = "request_id"

.field static final RESPONSE_OBJECT_KEY:Ljava/lang/String; = "response"

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 129
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->GenericError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v2, "Generic Error"

    const-string/jumbo v3, "Generic Error"

    const-string/jumbo v4, "No Request Id"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->GENERIC_ERROR:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .line 141
    const-class v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    return-void
.end method


# virtual methods
.method public hasAuthenticationChallenge(Lorg/json/JSONObject;)Z
    .locals 3
    .param p1, "rootObj"    # Lorg/json/JSONObject;

    .prologue
    const/4 v1, 0x0

    .line 185
    if-nez p1, :cond_0

    .line 200
    :goto_0
    return v1

    .line 193
    :cond_0
    :try_start_0
    const-string/jumbo v2, "response"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 200
    .local v0, "responseObj":Lorg/json/JSONObject;
    const-string/jumbo v1, "challenge"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0

    .line 197
    .end local v0    # "responseObj":Lorg/json/JSONObject;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public isFailure(I)Z
    .locals 1
    .param p1, "responseCode"    # I

    .prologue
    .line 145
    const/16 v0, 0xc8

    if-lt p1, v0, :cond_0

    const/16 v0, 0x12c

    if-lt p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/json/JSONObject;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .locals 10
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    const/4 v7, 0x0

    .line 152
    if-nez p1, :cond_0

    .line 179
    :goto_0
    return-object v7

    .line 159
    :cond_0
    :try_start_0
    const-string/jumbo v8, "response"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 161
    .local v6, "response":Lorg/json/JSONObject;
    const-string/jumbo v8, "request_id"

    const/4 v9, 0x0

    invoke-static {v6, v8, v9}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 163
    .local v5, "requestId":Ljava/lang/String;
    const-string/jumbo v8, "error"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 166
    .local v2, "error":Lorg/json/JSONObject;
    const-string/jumbo v8, "code"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 167
    invoke-static {v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getAuthErrorTypeFromCode(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v3

    .line 170
    .local v3, "errorType":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    const-string/jumbo v8, "message"

    const/4 v9, 0x0

    invoke-static {v2, v8, v9}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 171
    .local v4, "message":Ljava/lang/String;
    const-string/jumbo v8, "detail"

    const/4 v9, 0x0

    invoke-static {v2, v8, v9}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 173
    .local v0, "detail":Ljava/lang/String;
    new-instance v8, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    invoke-direct {v8, v3, v4, v0, v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v7, v8

    goto :goto_0

    .line 175
    .end local v0    # "detail":Ljava/lang/String;
    .end local v2    # "error":Lorg/json/JSONObject;
    .end local v3    # "errorType":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .end local v4    # "message":Ljava/lang/String;
    .end local v5    # "requestId":Ljava/lang/String;
    .end local v6    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 177
    .local v1, "e":Lorg/json/JSONException;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Given JSON is not in Auth Error format. Error: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 178
    .restart local v4    # "message":Ljava/lang/String;
    sget-object v8, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->TAG:Ljava/lang/String;

    .line 179
    new-instance v8, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v9, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    invoke-direct {v8, v9, v4, v7, v7}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v7, v8

    goto :goto_0
.end method
