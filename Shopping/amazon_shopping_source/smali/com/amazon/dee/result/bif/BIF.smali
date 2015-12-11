.class public Lcom/amazon/dee/result/bif/BIF;
.super Ljava/lang/Object;
.source "BIF.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# static fields
.field private static final JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

.field private static final OBJECT_MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;


# instance fields
.field private mInterpretations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Interpretation;",
            ">;"
        }
    .end annotation
.end field

.field private mRequestId:Ljava/lang/String;

.field private mSessionId:Ljava/lang/String;

.field private mUtteranceId:Ljava/lang/String;

.field private mVersion:Ljava/lang/String;

.field private mWakeWordFalsePositive:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 498
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    sput-object v0, Lcom/amazon/dee/result/bif/BIF;->OBJECT_MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 502
    new-instance v0, Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-direct {v0}, Lcom/fasterxml/jackson/core/JsonFactory;-><init>()V

    sput-object v0, Lcom/amazon/dee/result/bif/BIF;->JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 83
    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/BIF;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V

    .line 84
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 6
    .param p1, "sessionId"    # Ljava/lang/String;
    .param p2, "requestId"    # Ljava/lang/String;
    .param p3, "utteranceId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Interpretation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 75
    .local p4, "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/BIF;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V

    .line 76
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "sessionId"    # Ljava/lang/String;
    .param p2, "requestId"    # Ljava/lang/String;
    .param p3, "utteranceId"    # Ljava/lang/String;
    .param p5, "wakeWordFalsePositive"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Interpretation;",
            ">;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .line 50
    .local p4, "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 493
    const-string/jumbo v0, "2.0"

    iput-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    .line 51
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    .line 53
    iput-object p3, p0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    .line 54
    if-eqz p4, :cond_0

    .end local p4    # "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    :goto_0
    iput-object p4, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    .line 56
    iput-object p5, p0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    .line 57
    return-void

    .line 54
    .restart local p4    # "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    :cond_0
    new-instance p4, Ljava/util/ArrayList;

    .end local p4    # "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    invoke-direct {p4}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public static fromJson(Ljava/io/File;)Lcom/amazon/dee/result/bif/BIF;
    .locals 5
    .param p0, "jsonFile"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/dee/result/bif/BIFException;
        }
    .end annotation

    .prologue
    .line 401
    const/4 v1, 0x0

    .line 404
    .local v1, "object":Lcom/amazon/dee/result/bif/BIF;
    :try_start_0
    sget-object v2, Lcom/amazon/dee/result/bif/BIF;->OBJECT_MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v3, Lcom/amazon/dee/result/bif/BIF;

    invoke-virtual {v2, p0, v3}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/File;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    check-cast v1, Lcom/amazon/dee/result/bif/BIF;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 412
    .restart local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    return-object v1

    .line 406
    .end local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    :catch_0
    move-exception v0

    .line 408
    .local v0, "ex":Ljava/lang/Exception;
    new-instance v2, Lcom/amazon/dee/result/bif/BIFException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Exception in contructing BIF from JSON file: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/amazon/dee/result/bif/BIFException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method public static fromJson(Ljava/lang/String;)Lcom/amazon/dee/result/bif/BIF;
    .locals 4
    .param p0, "jsonString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/dee/result/bif/BIFException;
        }
    .end annotation

    .prologue
    .line 377
    const/4 v1, 0x0

    .line 380
    .local v1, "object":Lcom/amazon/dee/result/bif/BIF;
    :try_start_0
    sget-object v2, Lcom/amazon/dee/result/bif/BIF;->OBJECT_MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v3, Lcom/amazon/dee/result/bif/BIF;

    invoke-virtual {v2, p0, v3}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    check-cast v1, Lcom/amazon/dee/result/bif/BIF;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 387
    .restart local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    return-object v1

    .line 382
    .end local v1    # "object":Lcom/amazon/dee/result/bif/BIF;
    :catch_0
    move-exception v0

    .line 384
    .local v0, "ex":Ljava/lang/Exception;
    new-instance v2, Lcom/amazon/dee/result/bif/BIFException;

    const-string/jumbo v3, "Exception in constructing BIF from JSON string"

    invoke-direct {v2, v3, v0}, Lcom/amazon/dee/result/bif/BIFException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method public static toJson(Lcom/amazon/dee/result/bif/BIF;Z)Ljava/lang/String;
    .locals 5
    .param p0, "bif"    # Lcom/amazon/dee/result/bif/BIF;
    .param p1, "prettyPrint"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/dee/result/bif/BIFException;
        }
    .end annotation

    .prologue
    .line 337
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    .line 342
    .local v2, "writer":Ljava/io/StringWriter;
    :try_start_0
    sget-object v3, Lcom/amazon/dee/result/bif/BIF;->JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v3, v2}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 348
    .local v1, "generator":Lcom/fasterxml/jackson/core/JsonGenerator;
    if-eqz p1, :cond_0

    .line 350
    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->useDefaultPrettyPrinter()Lcom/fasterxml/jackson/core/JsonGenerator;

    .line 355
    :cond_0
    :try_start_1
    sget-object v3, Lcom/amazon/dee/result/bif/BIF;->OBJECT_MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v3, v1, p0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 362
    invoke-virtual {v2}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 344
    .end local v1    # "generator":Lcom/fasterxml/jackson/core/JsonGenerator;
    :catch_0
    move-exception v0

    .line 346
    .local v0, "ex":Ljava/io/IOException;
    new-instance v3, Lcom/amazon/dee/result/bif/BIFException;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lcom/amazon/dee/result/bif/BIFException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 357
    .end local v0    # "ex":Ljava/io/IOException;
    .restart local v1    # "generator":Lcom/fasterxml/jackson/core/JsonGenerator;
    :catch_1
    move-exception v0

    .line 359
    .local v0, "ex":Ljava/lang/Exception;
    new-instance v3, Lcom/amazon/dee/result/bif/BIFException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lcom/amazon/dee/result/bif/BIFException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method


# virtual methods
.method public final addInterpretation(Lcom/amazon/dee/result/bif/Interpretation;)V
    .locals 1
    .param p1, "input"    # Lcom/amazon/dee/result/bif/Interpretation;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 95
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 418
    instance-of v2, p1, Lcom/amazon/dee/result/bif/BIF;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 420
    check-cast v0, Lcom/amazon/dee/result/bif/BIF;

    .line 421
    .local v0, "other":Lcom/amazon/dee/result/bif/BIF;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 430
    .end local v0    # "other":Lcom/amazon/dee/result/bif/BIF;
    :cond_0
    return v1
.end method

.method public final getBestTokenString()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 297
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/dee/result/bif/BIF;->getTokenString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getInterpretations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Interpretation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    if-nez v0, :cond_0

    .line 116
    const/4 v0, 0x0

    .line 118
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public final getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public final getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    return-object v0
.end method

.method public final getTokenString(I)Ljava/lang/String;
    .locals 3
    .param p1, "index"    # I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 313
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/dee/result/bif/BIF;->getTokensAsStringList()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 317
    :goto_0
    return-object v1

    .line 315
    :catch_0
    move-exception v0

    .line 317
    .local v0, "ex":Ljava/lang/IndexOutOfBoundsException;
    const-string/jumbo v1, ""

    goto :goto_0
.end method

.method public final getTokensAsStringList()Ljava/util/List;
    .locals 11
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 255
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 256
    .local v6, "stringList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v9, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/dee/result/bif/Interpretation;

    .line 260
    .local v4, "interpretation":Lcom/amazon/dee/result/bif/Interpretation;
    :try_start_0
    invoke-virtual {v4}, Lcom/amazon/dee/result/bif/Interpretation;->getIntent()Lcom/amazon/dee/result/bif/Intent;

    move-result-object v3

    .line 261
    .local v3, "intent":Lcom/amazon/dee/result/bif/Intent;
    invoke-virtual {v3}, Lcom/amazon/dee/result/bif/Intent;->getTokens()Ljava/util/List;

    move-result-object v8

    .line 262
    .local v8, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 263
    .local v5, "stringBuilder":Ljava/lang/StringBuilder;
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/dee/result/bif/Token;

    .line 265
    .local v7, "token":Lcom/amazon/dee/result/bif/Token;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7}, Lcom/amazon/dee/result/bif/Token;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 269
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "intent":Lcom/amazon/dee/result/bif/Intent;
    .end local v5    # "stringBuilder":Ljava/lang/StringBuilder;
    .end local v7    # "token":Lcom/amazon/dee/result/bif/Token;
    .end local v8    # "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    :catch_0
    move-exception v0

    .line 281
    .local v0, "ex":Ljava/lang/NullPointerException;
    const/4 v9, 0x0

    invoke-interface {v6, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 267
    .end local v0    # "ex":Ljava/lang/NullPointerException;
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "intent":Lcom/amazon/dee/result/bif/Intent;
    .restart local v5    # "stringBuilder":Ljava/lang/StringBuilder;
    .restart local v8    # "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    :cond_0
    :try_start_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v6, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 284
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "intent":Lcom/amazon/dee/result/bif/Intent;
    .end local v4    # "interpretation":Lcom/amazon/dee/result/bif/Interpretation;
    .end local v5    # "stringBuilder":Ljava/lang/StringBuilder;
    .end local v8    # "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    :cond_1
    return-object v6
.end method

.method public final getUtteranceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    return-object v0
.end method

.method public final getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    return-object v0
.end method

.method public final getWakeWordFalsePositive()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 437
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    iget-object v2, p0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final setInterpretations(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Interpretation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 141
    .local p1, "interpretations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Interpretation;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mInterpretations:Ljava/util/List;

    .line 142
    return-void
.end method

.method public final setRequestId(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestId"    # Ljava/lang/String;

    .prologue
    .line 214
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mRequestId:Ljava/lang/String;

    .line 215
    return-void
.end method

.method public final setSessionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "sessionId"    # Ljava/lang/String;

    .prologue
    .line 188
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mSessionId:Ljava/lang/String;

    .line 189
    return-void
.end method

.method public final setUtteranceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "utteranceId"    # Ljava/lang/String;

    .prologue
    .line 237
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mUtteranceId:Ljava/lang/String;

    .line 238
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mVersion:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public final setWakeWordFalsePositive(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "wakeWordFalsePositive"    # Ljava/lang/Boolean;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/amazon/dee/result/bif/BIF;->mWakeWordFalsePositive:Ljava/lang/Boolean;

    .line 130
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 451
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lcom/amazon/dee/result/bif/BIF;->toJson(Lcom/amazon/dee/result/bif/BIF;Z)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/dee/result/bif/BIFException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 455
    :goto_0
    return-object v1

    .line 453
    :catch_0
    move-exception v0

    .line 455
    .local v0, "ex":Lcom/amazon/dee/result/bif/BIFException;
    invoke-virtual {v0}, Lcom/amazon/dee/result/bif/BIFException;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method
