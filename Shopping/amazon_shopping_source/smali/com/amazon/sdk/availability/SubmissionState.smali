.class Lcom/amazon/sdk/availability/SubmissionState;
.super Ljava/lang/Object;
.source "SubmissionState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/SubmissionState$Submission;
    }
.end annotation


# instance fields
.field private submissions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/SubmissionState$Submission;",
            ">;"
        }
    .end annotation
.end field

.field private token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 178
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 179
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/sdk/availability/SubmissionState;->submissions:Ljava/util/List;

    .line 180
    return-void
.end method


# virtual methods
.method public toJson()Lorg/json/JSONObject;
    .locals 7

    .prologue
    .line 273
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 274
    .local v2, "json":Lorg/json/JSONObject;
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 276
    .local v4, "subs":Lorg/json/JSONArray;
    :try_start_0
    iget-object v5, p0, Lcom/amazon/sdk/availability/SubmissionState;->submissions:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/sdk/availability/SubmissionState$Submission;

    .line 277
    .local v3, "submission":Lcom/amazon/sdk/availability/SubmissionState$Submission;
    invoke-virtual {v3}, Lcom/amazon/sdk/availability/SubmissionState$Submission;->toJson()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 281
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "submission":Lcom/amazon/sdk/availability/SubmissionState$Submission;
    :catch_0
    move-exception v0

    .line 282
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v5, "failed to serialize object"

    invoke-static {v5, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 284
    .end local v0    # "e":Lorg/json/JSONException;
    :goto_1
    return-object v2

    .line 279
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    const-string/jumbo v5, "submissions"

    invoke-virtual {v2, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 280
    const-string/jumbo v5, "token"

    iget-object v6, p0, Lcom/amazon/sdk/availability/SubmissionState;->token:Ljava/lang/String;

    invoke-virtual {v2, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/SubmissionState;->toJson()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
