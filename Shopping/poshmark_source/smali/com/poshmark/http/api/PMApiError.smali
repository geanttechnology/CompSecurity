.class public Lcom/poshmark/http/api/PMApiError;
.super Lcom/poshmark/http/PMHttpError;
.source "PMApiError.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/http/api/PMApiError$2;
    }
.end annotation


# static fields
.field private static exceptionsToErrorType:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class;",
            "Lcom/poshmark/data_model/models/PMErrorType;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final httpCode:I

.field public final pmError:Lcom/poshmark/data_model/models/PMError;

.field public final pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 117
    new-instance v0, Lcom/poshmark/http/api/PMApiError$1;

    invoke-direct {v0}, Lcom/poshmark/http/api/PMApiError$1;-><init>()V

    sput-object v0, Lcom/poshmark/http/api/PMApiError;->exceptionsToErrorType:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V
    .locals 4
    .param p1, "pmError"    # Lcom/poshmark/data_model/models/PMError;
    .param p2, "exception"    # Ljava/lang/Throwable;
    .param p3, "httpCode"    # I
    .param p4, "pmErrorType"    # Lcom/poshmark/data_model/models/PMErrorType;

    .prologue
    const/4 v3, 0x0

    .line 36
    invoke-direct {p0, p2}, Lcom/poshmark/http/PMHttpError;-><init>(Ljava/lang/Throwable;)V

    .line 38
    iput-object p1, p0, Lcom/poshmark/http/api/PMApiError;->pmError:Lcom/poshmark/data_model/models/PMError;

    .line 39
    iput p3, p0, Lcom/poshmark/http/api/PMApiError;->httpCode:I

    .line 41
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-eq p4, v0, :cond_1

    move-object v0, p4

    :goto_0
    iput-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    .line 44
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne p4, v0, :cond_2

    .line 45
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "error"

    const-string v2, "request_timeout_error"

    invoke-virtual {v0, v3, v1, v2, v3}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    :cond_0
    :goto_1
    return-void

    .line 41
    :cond_1
    invoke-static {p1, p2, p3, p4}, Lcom/poshmark/http/api/PMApiError;->getErrorType(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)Lcom/poshmark/data_model/models/PMErrorType;

    move-result-object v0

    goto :goto_0

    .line 47
    :cond_2
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne p4, v0, :cond_0

    .line 48
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "error"

    const-string v2, "unknown_error"

    invoke-virtual {v0, v3, v1, v2, v3}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;
    .locals 5
    .param p0, "errorJson"    # Ljava/lang/String;

    .prologue
    .line 166
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 167
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 168
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v3, Lcom/poshmark/http/api/PMApiError;

    instance-of v4, v2, Lcom/google/gson/Gson;

    if-nez v4, :cond_0

    invoke-virtual {v2, p0, v3}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v2    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v1, Lcom/poshmark/http/api/PMApiError;

    .line 169
    .local v1, "error":Lcom/poshmark/http/api/PMApiError;
    return-object v1

    .line 168
    .end local v1    # "error":Lcom/poshmark/http/api/PMApiError;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, p0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method private static getErrorType(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)Lcom/poshmark/data_model/models/PMErrorType;
    .locals 3
    .param p0, "pmError"    # Lcom/poshmark/data_model/models/PMError;
    .param p1, "exception"    # Ljava/lang/Throwable;
    .param p2, "httpCode"    # I
    .param p3, "pmErrorType"    # Lcom/poshmark/data_model/models/PMErrorType;

    .prologue
    .line 55
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne p3, v1, :cond_0

    if-eqz p0, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    iget-object v1, v1, Lcom/poshmark/data_model/models/PMError$Error;->error_type:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    iget-object v1, v1, Lcom/poshmark/data_model/models/PMError$Error;->error_type:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 59
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->errorMap:Ljava/util/Map;

    iget-object v2, p0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    iget-object v2, v2, Lcom/poshmark/data_model/models/PMError$Error;->error_type:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    .end local p3    # "pmErrorType":Lcom/poshmark/data_model/models/PMErrorType;
    check-cast p3, Lcom/poshmark/data_model/models/PMErrorType;

    .line 60
    .restart local p3    # "pmErrorType":Lcom/poshmark/data_model/models/PMErrorType;
    if-nez p3, :cond_0

    .line 61
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 66
    :cond_0
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne p3, v1, :cond_1

    if-eqz p2, :cond_1

    const/16 v1, 0xc8

    if-eq p2, v1, :cond_1

    .line 67
    sparse-switch p2, :sswitch_data_0

    .line 91
    if-nez p1, :cond_1

    .line 92
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 100
    :cond_1
    :goto_0
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne p3, v1, :cond_3

    if-eqz p1, :cond_3

    .line 102
    sget-object v1, Lcom/poshmark/http/api/PMApiError;->exceptionsToErrorType:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMErrorType;

    .line 103
    .local v0, "pmErrorTypeException":Lcom/poshmark/data_model/models/PMErrorType;
    if-nez v0, :cond_2

    .line 104
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/io/IOException;

    invoke-virtual {v1, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 106
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 109
    :cond_2
    if-eqz v0, :cond_3

    .line 110
    move-object p3, v0

    .line 114
    .end local v0    # "pmErrorTypeException":Lcom/poshmark/data_model/models/PMErrorType;
    :cond_3
    return-object p3

    .line 69
    :sswitch_0
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_BAD_REQUEST:Lcom/poshmark/data_model/models/PMErrorType;

    .line 70
    goto :goto_0

    .line 72
    :sswitch_1
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_UNAUTHORIZED:Lcom/poshmark/data_model/models/PMErrorType;

    .line 73
    goto :goto_0

    .line 75
    :sswitch_2
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_ACCESS_FORBIDDEN:Lcom/poshmark/data_model/models/PMErrorType;

    .line 76
    goto :goto_0

    .line 78
    :sswitch_3
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    .line 79
    goto :goto_0

    .line 81
    :sswitch_4
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 85
    :sswitch_5
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_INTERNAL_SERVER_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 86
    goto :goto_0

    .line 88
    :sswitch_6
    sget-object p3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_SERVER_UNAVAILABLE:Lcom/poshmark/data_model/models/PMErrorType;

    .line 89
    goto :goto_0

    .line 67
    nop

    :sswitch_data_0
    .sparse-switch
        0x190 -> :sswitch_0
        0x191 -> :sswitch_1
        0x193 -> :sswitch_2
        0x194 -> :sswitch_3
        0x19a -> :sswitch_4
        0x1f4 -> :sswitch_5
        0x1f5 -> :sswitch_5
        0x1f6 -> :sswitch_5
        0x1f7 -> :sswitch_6
    .end sparse-switch
.end method

.method public static lookupServerErrorType(Ljava/lang/String;)Lcom/poshmark/data_model/models/PMErrorType;
    .locals 2
    .param p0, "errorTypeString"    # Ljava/lang/String;

    .prologue
    .line 131
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->errorMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMErrorType;

    .line 132
    .local v0, "pmErrorType":Lcom/poshmark/data_model/models/PMErrorType;
    if-nez v0, :cond_0

    .line 133
    sget-object v0, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 135
    :cond_0
    return-object v0
.end method

.method public static serialize(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    .locals 5
    .param p0, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 159
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 160
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 161
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v3, Lcom/poshmark/http/api/PMApiError;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_0

    invoke-virtual {v1, p0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 162
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v2, "serializedError":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 161
    .end local v2    # "serializedError":Ljava/lang/String;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, p0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method


# virtual methods
.method public getUserMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmError:Lcom/poshmark/data_model/models/PMError;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmError:Lcom/poshmark/data_model/models/PMError;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmError:Lcom/poshmark/data_model/models/PMError;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMError;->error:Lcom/poshmark/data_model/models/PMError$Error;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMError$Error;->user_message:Ljava/lang/String;

    .line 142
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAlreadyExistsError()Z
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->ALREADY_EXISTS_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isNetworkDomainError()Z
    .locals 2

    .prologue
    .line 146
    sget-object v0, Lcom/poshmark/http/api/PMApiError$2;->$SwitchMap$com$poshmark$data_model$models$PMErrorType:[I

    iget-object v1, p0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMErrorType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 151
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 149
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 146
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
