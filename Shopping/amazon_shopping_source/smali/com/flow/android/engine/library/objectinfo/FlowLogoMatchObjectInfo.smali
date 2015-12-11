.class public Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;
.super Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.source "FlowLogoMatchObjectInfo.java"


# instance fields
.field private mDisplayName:Ljava/lang/String;

.field private mImageName:Ljava/lang/String;

.field private mMetrics:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mTagObject:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 5
    .param p1, "a_objectInfo"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 31
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    iget-object v4, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    invoke-virtual {v4}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    .line 32
    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "displayedName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "displayedName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    :goto_0
    iput-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mDisplayName:Ljava/lang/String;

    .line 33
    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "imageName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "imageName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    :goto_1
    iput-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mImageName:Ljava/lang/String;

    .line 34
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iput-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mMetrics:Ljava/util/HashMap;

    .line 35
    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "metrics"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 36
    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mTagObject:Lorg/json/JSONObject;

    const-string/jumbo v4, "metrics"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 37
    .local v2, "metricsObj":Lorg/json/JSONObject;
    invoke-virtual {v2}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 38
    .local v1, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 39
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 40
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->mMetrics:Ljava/util/HashMap;

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 43
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v2    # "metricsObj":Lorg/json/JSONObject;
    :catch_0
    move-exception v3

    .line 46
    :cond_0
    return-void

    .line 32
    :cond_1
    invoke-virtual {p0}, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->getBrandFilterName()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 33
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getBrandFilterName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getContent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
