.class public Lcom/amazon/sdk/availability/SubmissionState$Submission;
.super Ljava/lang/Object;
.source "SubmissionState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/SubmissionState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Submission"
.end annotation


# instance fields
.field private attempts:J

.field private numMeasurements:J

.field private succeeded:Z

.field private timestamp:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public toJson()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 143
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 145
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_0
    const-string/jumbo v2, "numMeasurements"

    iget-wide v3, p0, Lcom/amazon/sdk/availability/SubmissionState$Submission;->numMeasurements:J

    invoke-virtual {v1, v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 146
    const-string/jumbo v2, "timestamp"

    iget-wide v3, p0, Lcom/amazon/sdk/availability/SubmissionState$Submission;->timestamp:J

    invoke-virtual {v1, v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 147
    const-string/jumbo v2, "attempts"

    iget-wide v3, p0, Lcom/amazon/sdk/availability/SubmissionState$Submission;->attempts:J

    invoke-virtual {v1, v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 148
    iget-boolean v2, p0, Lcom/amazon/sdk/availability/SubmissionState$Submission;->succeeded:Z

    if-eqz v2, :cond_0

    .line 149
    const-string/jumbo v2, "status"

    const-string/jumbo v3, "Succeeded"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 156
    :goto_0
    return-object v1

    .line 151
    :cond_0
    const-string/jumbo v2, "status"

    const-string/jumbo v3, "Failed"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 153
    :catch_0
    move-exception v0

    .line 154
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v2, "failed to serialize object"

    invoke-static {v2, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/SubmissionState$Submission;->toJson()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
