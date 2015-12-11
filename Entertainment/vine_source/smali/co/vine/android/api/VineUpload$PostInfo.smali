.class public Lco/vine/android/api/VineUpload$PostInfo;
.super Ljava/lang/Object;
.source "VineUpload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/api/VineUpload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PostInfo"
.end annotation


# instance fields
.field public final caption:Ljava/lang/String;

.field public channelId:J

.field public created:J

.field public final entities:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;"
        }
    .end annotation
.end field

.field public final maxLoops:I

.field public final message:Ljava/lang/String;

.field public final postId:J

.field public postToFacebook:Z

.field public postToTwitter:Z

.field public recipients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation
.end field

.field public final sharedPostThumbUrl:Ljava/lang/String;

.field public final sharedPostVideoUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 3
    .param p1, "caption"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    if-nez p1, :cond_0

    .line 186
    const-string p1, ""

    .line 188
    :cond_0
    iput-object p1, p0, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    .line 189
    iput-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    .line 190
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    .line 191
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    .line 192
    iput-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    .line 193
    iput-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostThumbUrl:Ljava/lang/String;

    .line 194
    iput-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostVideoUrl:Ljava/lang/String;

    .line 195
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/ArrayList;I)V
    .locals 0
    .param p1, "caption"    # Ljava/lang/String;
    .param p2, "postToTwitter"    # Z
    .param p3, "postToFacebook"    # Z
    .param p4, "channelId"    # J
    .param p7, "message"    # Ljava/lang/String;
    .param p8, "postId"    # J
    .param p10, "videoUrl"    # Ljava/lang/String;
    .param p11, "thumbUrl"    # Ljava/lang/String;
    .param p12, "created"    # J
    .param p15, "maxLoops"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "ZZJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "J",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 199
    .local p6, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    .local p14, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 200
    if-nez p1, :cond_0

    .line 201
    const-string p1, ""

    .line 203
    :cond_0
    iput-object p1, p0, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    .line 204
    iput-boolean p2, p0, Lco/vine/android/api/VineUpload$PostInfo;->postToTwitter:Z

    .line 205
    iput-boolean p3, p0, Lco/vine/android/api/VineUpload$PostInfo;->postToFacebook:Z

    .line 206
    iput-object p6, p0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    .line 207
    iput-wide p4, p0, Lco/vine/android/api/VineUpload$PostInfo;->channelId:J

    .line 208
    iput-wide p12, p0, Lco/vine/android/api/VineUpload$PostInfo;->created:J

    .line 209
    iput-object p7, p0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    .line 210
    iput-wide p8, p0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    .line 211
    iput-object p14, p0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    .line 212
    iput p15, p0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    .line 213
    iput-object p10, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostVideoUrl:Ljava/lang/String;

    .line 214
    iput-object p11, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostThumbUrl:Ljava/lang/String;

    .line 215
    return-void
.end method

.method public static entitiesToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 264
    .local p0, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 265
    .local v2, "mapEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineEntity;

    .line 266
    .local v0, "entity":Lco/vine/android/api/VineEntity;
    invoke-virtual {v0}, Lco/vine/android/api/VineEntity;->toMap()Ljava/util/HashMap;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 268
    .end local v0    # "entity":Lco/vine/android/api/VineEntity;
    :cond_0
    return-object v2
.end method

.method public static fromJsonString(Ljava/lang/String;)Lco/vine/android/api/VineUpload$PostInfo;
    .locals 4
    .param p0, "json"    # Ljava/lang/String;

    .prologue
    .line 219
    :try_start_0
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->createParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v1

    .line 220
    .local v1, "parser":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v1}, Lco/vine/android/api/VineUploadParsers;->parsePostInfo(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUpload$PostInfo;
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonParseException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v2

    return-object v2

    .line 221
    .end local v1    # "parser":Lcom/fasterxml/jackson/core/JsonParser;
    :catch_0
    move-exception v0

    .line 222
    .local v0, "e":Lcom/fasterxml/jackson/core/JsonParseException;
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "This should never happen."

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 223
    .end local v0    # "e":Lcom/fasterxml/jackson/core/JsonParseException;
    :catch_1
    move-exception v0

    .line 224
    .local v0, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "This should never happen."

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 225
    .end local v0    # "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :catch_2
    move-exception v0

    .line 226
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "This should never happen."

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method public static recipientsToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 272
    .local p0, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 273
    .local v1, "mapRecipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineRecipient;

    .line 274
    .local v2, "recipient":Lco/vine/android/api/VineRecipient;
    invoke-virtual {v2}, Lco/vine/android/api/VineRecipient;->toMap()Ljava/util/HashMap;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 276
    .end local v2    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_0
    return-object v1
.end method

.method private toJson()Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 5

    .prologue
    .line 236
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 237
    .local v1, "objectHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "description"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 238
    const-string v2, "postToTwitter"

    iget-boolean v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->postToTwitter:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    const-string v2, "postToFacebook"

    iget-boolean v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->postToFacebook:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 240
    const-string v2, "channelId"

    iget-wide v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->channelId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 241
    const-string v2, "maxLoops"

    iget v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 243
    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostVideoUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 244
    const-string v2, "videoUrl"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostVideoUrl:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    :cond_0
    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostThumbUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 247
    const-string v2, "thumbUrl"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostThumbUrl:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 250
    :cond_1
    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 251
    const-string v2, "entities"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    invoke-static {v3}, Lco/vine/android/api/VineUpload$PostInfo;->entitiesToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    :cond_2
    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    .line 254
    const-string v2, "recipients"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    invoke-static {v3}, Lco/vine/android/api/VineUpload$PostInfo;->recipientsToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    :cond_3
    const-string v2, "message"

    iget-object v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 257
    const-string v2, "postId"

    iget-wide v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    const-string v2, "created"

    iget-wide v3, p0, Lco/vine/android/api/VineUpload$PostInfo;->created:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    new-instance v2, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    invoke-virtual {v2, v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->valueToTree(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 260
    .local v0, "json":Lcom/fasterxml/jackson/databind/JsonNode;
    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    invoke-direct {p0}, Lco/vine/android/api/VineUpload$PostInfo;->toJson()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
