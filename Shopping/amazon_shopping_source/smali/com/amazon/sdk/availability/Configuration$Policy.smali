.class public Lcom/amazon/sdk/availability/Configuration$Policy;
.super Ljava/lang/Object;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Policy"
.end annotation


# instance fields
.field private custom:Lorg/json/JSONObject;

.field private excludedNetworks:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/sdk/availability/Connectivity$Network;",
            ">;"
        }
    .end annotation
.end field

.field private packageNamePatternRestriction:Ljava/lang/String;

.field private period:Ljava/lang/Long;


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 11
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    const/4 v10, 0x0

    .line 164
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 165
    new-instance v7, Ljava/util/HashSet;

    invoke-direct {v7}, Ljava/util/HashSet;-><init>()V

    iput-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->excludedNetworks:Ljava/util/Set;

    .line 166
    if-eqz p1, :cond_4

    .line 167
    const-string/jumbo v7, "period"

    const-wide/16 v8, -0x1

    invoke-virtual {p1, v7, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->period:Ljava/lang/Long;

    .line 168
    const-string/jumbo v7, "restrictions"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 169
    .local v6, "restrictions":Lorg/json/JSONObject;
    if-eqz v6, :cond_2

    .line 171
    const-string/jumbo v7, "metadataPatterns"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 172
    .local v2, "metadataPatterns":Lorg/json/JSONObject;
    if-nez v2, :cond_0

    .line 173
    const-string/jumbo v7, "metadataExpression"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 175
    :cond_0
    if-eqz v2, :cond_2

    .line 176
    const-string/jumbo v7, "packageName"

    invoke-static {v2, v7, v10}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 177
    .local v5, "packageNamePattern":Ljava/lang/String;
    if-eqz v5, :cond_1

    .line 178
    iput-object v5, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->packageNamePatternRestriction:Ljava/lang/String;

    .line 181
    :cond_1
    const-string/jumbo v7, "custom"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    .line 182
    iget-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    if-nez v7, :cond_2

    .line 183
    const-string/jumbo v7, "expression"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    .line 187
    .end local v2    # "metadataPatterns":Lorg/json/JSONObject;
    .end local v5    # "packageNamePattern":Ljava/lang/String;
    :cond_2
    const-string/jumbo v7, "excludedNetworks"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 188
    .local v4, "networks":Lorg/json/JSONArray;
    if-eqz v4, :cond_4

    .line 189
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v1, v7, :cond_4

    .line 190
    invoke-virtual {v4, v1, v10}, Lorg/json/JSONArray;->optString(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 191
    .local v3, "networkName":Ljava/lang/String;
    if-eqz v3, :cond_3

    .line 193
    :try_start_0
    iget-object v7, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->excludedNetworks:Ljava/util/Set;

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Connectivity$Network;->valueOf(Ljava/lang/String;)Lcom/amazon/sdk/availability/Connectivity$Network;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 189
    :cond_3
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 194
    :catch_0
    move-exception v0

    .line 195
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "invalid network name: %s"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 201
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "i":I
    .end local v3    # "networkName":Ljava/lang/String;
    .end local v4    # "networks":Lorg/json/JSONArray;
    .end local v6    # "restrictions":Lorg/json/JSONObject;
    :cond_4
    return-void
.end method


# virtual methods
.method public applies(Lorg/json/JSONObject;)Z
    .locals 3
    .param p1, "data"    # Lorg/json/JSONObject;

    .prologue
    const/4 v1, 0x1

    .line 259
    if-nez p1, :cond_1

    .line 260
    const/4 v1, 0x0

    .line 273
    :cond_0
    :goto_0
    return v1

    .line 263
    :cond_1
    const-string/jumbo v2, "metadata"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 264
    .local v0, "metaDataVals":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 269
    iget-object v2, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    if-eqz v2, :cond_0

    .line 273
    new-instance v1, Lcom/amazon/sdk/availability/Evaluator;

    iget-object v2, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/Evaluator;-><init>(Lorg/json/JSONObject;)V

    invoke-virtual {v1, v0}, Lcom/amazon/sdk/availability/Evaluator;->evaluate(Lorg/json/JSONObject;)Z

    move-result v1

    goto :goto_0
.end method

.method public getPeriod()J
    .locals 3

    .prologue
    .line 244
    const-wide/16 v0, -0x1

    .line 245
    .local v0, "result":J
    iget-object v2, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->period:Ljava/lang/Long;

    if-eqz v2, :cond_0

    .line 246
    iget-object v2, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->period:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 248
    :cond_0
    return-wide v0
.end method

.method public isExcluded(Lcom/amazon/sdk/availability/Connectivity$Network;)Z
    .locals 1
    .param p1, "network"    # Lcom/amazon/sdk/availability/Connectivity$Network;

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->excludedNetworks:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isPackageSpecific()Z
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->packageNamePatternRestriction:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPackageSupported(Ljava/lang/String;)Z
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 230
    const/4 v2, 0x1

    .line 231
    .local v2, "result":Z
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->packageNamePatternRestriction:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 232
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->packageNamePatternRestriction:Ljava/lang/String;

    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    .line 233
    .local v1, "p":Ljava/util/regex/Pattern;
    invoke-virtual {v1, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 234
    .local v0, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    .line 236
    .end local v0    # "m":Ljava/util/regex/Matcher;
    .end local v1    # "p":Ljava/util/regex/Pattern;
    :cond_0
    return v2
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 281
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 282
    .local v2, "sb":Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "{\n\t\"period\" : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->period:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ",\n\t\"packageNamePatternRestriction\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->packageNamePatternRestriction:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"excludedNetworks\" : ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 284
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->excludedNetworks:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 285
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/amazon/sdk/availability/Connectivity$Network;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 286
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/sdk/availability/Connectivity$Network;

    .line 287
    .local v1, "network":Lcom/amazon/sdk/availability/Connectivity$Network;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Connectivity$Network;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 289
    .end local v1    # "network":Lcom/amazon/sdk/availability/Connectivity$Network;
    :cond_0
    const-string/jumbo v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 290
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "\t\"custom\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$Policy;->custom:Lorg/json/JSONObject;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 291
    const-string/jumbo v3, "\n}\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 292
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
