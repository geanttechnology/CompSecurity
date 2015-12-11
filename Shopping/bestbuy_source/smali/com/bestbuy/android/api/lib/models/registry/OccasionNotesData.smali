.class public Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public location:Ljava/lang/String;

.field public school_name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;
    .locals 2

    .prologue
    .line 25
    new-instance v1, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;-><init>()V

    .line 27
    :try_start_0
    const-string v0, "school-name"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;->school_name:Ljava/lang/String;

    .line 28
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;->location:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 32
    :goto_0
    return-object v1

    .line 29
    :catch_0
    move-exception v0

    .line 30
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public toJsonString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 37
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 39
    :try_start_0
    const-string v0, "school-name"

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;->school_name:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 40
    const-string v0, "location"

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/registry/OccasionNotesData;->location:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 41
    :catch_0
    move-exception v0

    .line 42
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
