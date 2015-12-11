.class public Ltwitter4j/TwitterException;
.super Ljava/lang/Exception;
.source "TwitterException.java"

# interfaces
.implements Ltwitter4j/TwitterResponse;
.implements Ltwitter4j/internal/http/HttpResponseCode;


# static fields
.field private static final FILTER:[Ljava/lang/String;

.field private static final serialVersionUID:J = -0x2467dddfd16c8207L


# instance fields
.field private errorCode:I

.field private errorMessage:Ljava/lang/String;

.field private exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

.field nested:Z

.field private response:Ltwitter4j/internal/http/HttpResponse;

.field private statusCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 211
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "twitter4j"

    aput-object v2, v0, v1

    sput-object v0, Ltwitter4j/TwitterException;->FILTER:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "cause"    # Ljava/lang/Exception;

    .prologue
    .line 54
    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 55
    instance-of v0, p1, Ltwitter4j/TwitterException;

    if-eqz v0, :cond_0

    .line 56
    check-cast p1, Ltwitter4j/TwitterException;

    .end local p1    # "cause":Ljava/lang/Exception;
    invoke-virtual {p1}, Ltwitter4j/TwitterException;->setNested()V

    .line 58
    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x0

    check-cast v0, Ljava/lang/Throwable;

    invoke-direct {p0, p1, v0}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 50
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Exception;I)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Exception;
    .param p3, "statusCode"    # I

    .prologue
    .line 67
    invoke-direct {p0, p1, p2}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 68
    iput p3, p0, Ltwitter4j/TwitterException;->statusCode:I

    .line 69
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 36
    iput v0, p0, Ltwitter4j/TwitterException;->statusCode:I

    .line 37
    iput v0, p0, Ltwitter4j/TwitterException;->errorCode:I

    .line 39
    iput-object v1, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    .line 41
    iput-object v1, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    .line 234
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltwitter4j/TwitterException;->nested:Z

    .line 45
    invoke-direct {p0, p1}, Ltwitter4j/TwitterException;->decode(Ljava/lang/String;)V

    .line 46
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ltwitter4j/internal/http/HttpResponse;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "res"    # Ltwitter4j/internal/http/HttpResponse;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;)V

    .line 62
    iput-object p2, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    .line 63
    invoke-virtual {p2}, Ltwitter4j/internal/http/HttpResponse;->getStatusCode()I

    move-result v0

    iput v0, p0, Ltwitter4j/TwitterException;->statusCode:I

    .line 64
    return-void
.end method

.method private decode(Ljava/lang/String;)V
    .locals 4
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 93
    if-eqz p1, :cond_0

    const-string v2, "{"

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 95
    :try_start_0
    new-instance v1, Ltwitter4j/internal/org/json/JSONObject;

    invoke-direct {v1, p1}, Ltwitter4j/internal/org/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 96
    .local v1, "json":Ltwitter4j/internal/org/json/JSONObject;
    const-string v2, "errors"

    invoke-virtual {v1, v2}, Ltwitter4j/internal/org/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 97
    const-string v2, "errors"

    invoke-virtual {v1, v2}, Ltwitter4j/internal/org/json/JSONObject;->getJSONArray(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ltwitter4j/internal/org/json/JSONArray;->getJSONObject(I)Ltwitter4j/internal/org/json/JSONObject;

    move-result-object v0

    .line 98
    .local v0, "error":Ltwitter4j/internal/org/json/JSONObject;
    const-string v2, "message"

    invoke-virtual {v0, v2}, Ltwitter4j/internal/org/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    .line 99
    const-string v2, "code"

    invoke-static {v2, v0}, Ltwitter4j/internal/json/z_T4JInternalParseUtil;->getInt(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)I

    move-result v2

    iput v2, p0, Ltwitter4j/TwitterException;->errorCode:I
    :try_end_0
    .catch Ltwitter4j/internal/org/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    .end local v0    # "error":Ltwitter4j/internal/org/json/JSONObject;
    .end local v1    # "json":Ltwitter4j/internal/org/json/JSONObject;
    :cond_0
    :goto_0
    return-void

    .line 101
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private static getCause(I)Ljava/lang/String;
    .locals 3
    .param p0, "statusCode"    # I

    .prologue
    .line 307
    sparse-switch p0, :sswitch_data_0

    .line 355
    const-string v0, ""

    .line 357
    .local v0, "cause":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 309
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_0
    const-string v0, "There was no new data to return."

    .line 310
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 312
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_1
    const-string v0, "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response."

    .line 313
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 315
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_2
    const-string v0, "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync."

    .line 316
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 318
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_3
    const-string v0, "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following)."

    .line 319
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 321
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_4
    const-string v0, "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method."

    .line 322
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 324
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_5
    const-string v0, "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read."

    .line 330
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 332
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_6
    const-string v0, "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name."

    .line 335
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 337
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_7
    const-string v0, "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed."

    .line 338
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 340
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_8
    const-string v0, "Returned in API v1.1 when a request cannot be served due to the application\'s rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)"

    .line 341
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 343
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_9
    const-string v0, "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate."

    .line 344
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 346
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_a
    const-string v0, "Twitter is down or being upgraded."

    .line 347
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 349
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_b
    const-string v0, "The Twitter servers are up, but overloaded with requests. Try again later."

    .line 350
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 352
    .end local v0    # "cause":Ljava/lang/String;
    :sswitch_c
    const-string v0, "The Twitter servers are up, but the request couldn\'t be serviced due to some failure within our stack. Try again later."

    .line 353
    .restart local v0    # "cause":Ljava/lang/String;
    goto :goto_0

    .line 307
    :sswitch_data_0
    .sparse-switch
        0x130 -> :sswitch_0
        0x190 -> :sswitch_1
        0x191 -> :sswitch_2
        0x193 -> :sswitch_3
        0x194 -> :sswitch_4
        0x196 -> :sswitch_5
        0x1a4 -> :sswitch_6
        0x1a6 -> :sswitch_7
        0x1ad -> :sswitch_8
        0x1f4 -> :sswitch_9
        0x1f6 -> :sswitch_a
        0x1f7 -> :sswitch_b
        0x1f8 -> :sswitch_c
    .end sparse-switch
.end method

.method private getExceptionDiagnosis()Ltwitter4j/ExceptionDiagnosis;
    .locals 2

    .prologue
    .line 228
    iget-object v0, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    if-nez v0, :cond_0

    .line 229
    new-instance v0, Ltwitter4j/ExceptionDiagnosis;

    sget-object v1, Ltwitter4j/TwitterException;->FILTER:[Ljava/lang/String;

    invoke-direct {v0, p0, v1}, Ltwitter4j/ExceptionDiagnosis;-><init>(Ljava/lang/Throwable;[Ljava/lang/String;)V

    iput-object v0, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    .line 231
    :cond_0
    iget-object v0, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    return-object v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 262
    if-ne p0, p1, :cond_1

    .line 275
    :cond_0
    :goto_0
    return v1

    .line 263
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 265
    check-cast v0, Ltwitter4j/TwitterException;

    .line 267
    .local v0, "that":Ltwitter4j/TwitterException;
    iget v3, p0, Ltwitter4j/TwitterException;->errorCode:I

    iget v4, v0, Ltwitter4j/TwitterException;->errorCode:I

    if-eq v3, v4, :cond_4

    move v1, v2

    goto :goto_0

    .line 268
    :cond_4
    iget-boolean v3, p0, Ltwitter4j/TwitterException;->nested:Z

    iget-boolean v4, v0, Ltwitter4j/TwitterException;->nested:Z

    if-eq v3, v4, :cond_5

    move v1, v2

    goto :goto_0

    .line 269
    :cond_5
    iget v3, p0, Ltwitter4j/TwitterException;->statusCode:I

    iget v4, v0, Ltwitter4j/TwitterException;->statusCode:I

    if-eq v3, v4, :cond_6

    move v1, v2

    goto :goto_0

    .line 270
    :cond_6
    iget-object v3, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    iget-object v4, v0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    goto :goto_0

    :cond_8
    iget-object v3, v0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 271
    :cond_9
    iget-object v3, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    if-eqz v3, :cond_b

    iget-object v3, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    iget-object v4, v0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    invoke-virtual {v3, v4}, Ltwitter4j/ExceptionDiagnosis;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 272
    goto :goto_0

    .line 271
    :cond_b
    iget-object v3, v0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    if-nez v3, :cond_a

    .line 273
    :cond_c
    iget-object v3, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    if-eqz v3, :cond_d

    iget-object v3, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    iget-object v4, v0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    goto :goto_0

    :cond_d
    iget-object v3, v0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getAccessLevel()I
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    invoke-static {v0}, Ltwitter4j/internal/json/z_T4JInternalParseUtil;->toAccessLevel(Ltwitter4j/internal/http/HttpResponse;)I

    move-result v0

    return v0
.end method

.method public getErrorCode()I
    .locals 1

    .prologue
    .line 111
    iget v0, p0, Ltwitter4j/TwitterException;->errorCode:I

    return v0
.end method

.method public getErrorMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getExceptionCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 224
    invoke-direct {p0}, Ltwitter4j/TwitterException;->getExceptionDiagnosis()Ltwitter4j/ExceptionDiagnosis;

    move-result-object v0

    invoke-virtual {v0}, Ltwitter4j/ExceptionDiagnosis;->asHexString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 76
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 77
    .local v0, "value":Ljava/lang/StringBuilder;
    iget-object v1, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget v1, p0, Ltwitter4j/TwitterException;->errorCode:I

    if-eq v1, v3, :cond_0

    .line 78
    const-string v1, "message - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 80
    const-string v1, "code - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Ltwitter4j/TwitterException;->errorCode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 85
    :goto_0
    iget v1, p0, Ltwitter4j/TwitterException;->statusCode:I

    if-eq v1, v3, :cond_1

    .line 86
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Ltwitter4j/TwitterException;->statusCode:I

    invoke-static {v2}, Ltwitter4j/TwitterException;->getCause(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 88
    :goto_1
    return-object v1

    .line 83
    :cond_0
    invoke-super {p0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 88
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public getResponseHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 115
    const/4 v1, 0x0

    .line 116
    .local v1, "value":Ljava/lang/String;
    iget-object v2, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    if-eqz v2, :cond_0

    .line 117
    iget-object v2, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    invoke-virtual {v2}, Ltwitter4j/internal/http/HttpResponse;->getResponseHeaderFields()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 118
    .local v0, "header":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 119
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "value":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 122
    .end local v0    # "header":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v1    # "value":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public getRetryAfter()I
    .locals 4

    .prologue
    .line 160
    const/4 v0, -0x1

    .line 161
    .local v0, "retryAfter":I
    iget v2, p0, Ltwitter4j/TwitterException;->statusCode:I

    const/16 v3, 0x190

    if-ne v2, v3, :cond_1

    .line 175
    :cond_0
    :goto_0
    return v0

    .line 166
    :cond_1
    iget v2, p0, Ltwitter4j/TwitterException;->statusCode:I

    const/16 v3, 0x1a4

    if-ne v2, v3, :cond_0

    .line 168
    :try_start_0
    iget-object v2, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    const-string v3, "Retry-After"

    invoke-virtual {v2, v3}, Ltwitter4j/internal/http/HttpResponse;->getResponseHeader(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 169
    .local v1, "retryAfterStr":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 170
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_0

    .line 172
    .end local v1    # "retryAfterStr":Ljava/lang/String;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 107
    iget v0, p0, Ltwitter4j/TwitterException;->statusCode:I

    return v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 280
    iget v0, p0, Ltwitter4j/TwitterException;->statusCode:I

    .line 281
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v3, p0, Ltwitter4j/TwitterException;->errorCode:I

    add-int v0, v1, v3

    .line 282
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    if-eqz v1, :cond_1

    iget-object v1, p0, Ltwitter4j/TwitterException;->exceptionDiagnosis:Ltwitter4j/ExceptionDiagnosis;

    invoke-virtual {v1}, Ltwitter4j/ExceptionDiagnosis;->hashCode()I

    move-result v1

    :goto_0
    add-int v0, v3, v1

    .line 283
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    if-eqz v1, :cond_2

    iget-object v1, p0, Ltwitter4j/TwitterException;->response:Ltwitter4j/internal/http/HttpResponse;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v3, v1

    .line 284
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_2
    add-int v0, v3, v1

    .line 285
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v3, p0, Ltwitter4j/TwitterException;->nested:Z

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    :cond_0
    add-int v0, v1, v2

    .line 286
    return v0

    :cond_1
    move v1, v2

    .line 282
    goto :goto_0

    :cond_2
    move v1, v2

    .line 283
    goto :goto_1

    :cond_3
    move v1, v2

    .line 284
    goto :goto_2
.end method

.method public isCausedByNetworkIssue()Z
    .locals 1

    .prologue
    .line 185
    invoke-virtual {p0}, Ltwitter4j/TwitterException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Ljava/io/IOException;

    return v0
.end method

.method public isErrorMessageAvailable()Z
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public resourceNotFound()Z
    .locals 2

    .prologue
    .line 208
    iget v0, p0, Ltwitter4j/TwitterException;->statusCode:I

    const/16 v1, 0x194

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method setNested()V
    .locals 1

    .prologue
    .line 237
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltwitter4j/TwitterException;->nested:Z

    .line 238
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 291
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ltwitter4j/TwitterException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Ltwitter4j/TwitterException;->nested:Z

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\nTwitterException{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Ltwitter4j/TwitterException;->nested:Z

    if-eqz v0, :cond_1

    const-string v0, ""

    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "statusCode="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltwitter4j/TwitterException;->statusCode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", message="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/TwitterException;->errorMessage:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", code="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltwitter4j/TwitterException;->errorCode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", retryAfter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ltwitter4j/TwitterException;->getRetryAfter()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ltwitter4j/Version;->getVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltwitter4j/TwitterException;->getExceptionDiagnosis()Ltwitter4j/ExceptionDiagnosis;

    move-result-object v2

    invoke-virtual {v2}, Ltwitter4j/ExceptionDiagnosis;->getStackLineHashAsHex()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " or\n\thttp://www.google.co.jp/search?q="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltwitter4j/TwitterException;->getExceptionDiagnosis()Ltwitter4j/ExceptionDiagnosis;

    move-result-object v2

    invoke-virtual {v2}, Ltwitter4j/ExceptionDiagnosis;->getLineNumberHashAsHex()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "exceptionCode=["

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ltwitter4j/TwitterException;->getExceptionCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "], "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1
.end method
