.class public final Lag;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/util/HashSet;


# instance fields
.field private final b:Lam;

.field private c:J

.field private final d:Laz;

.field private final e:La;

.field private final f:Lb$1;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 26
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 28
    sput-object v0, Lag;->a:Ljava/util/HashSet;

    const-string v1, "network-request"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 29
    sget-object v0, Lag;->a:Ljava/util/HashSet;

    const-string v1, "ui"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 30
    sget-object v0, Lag;->a:Ljava/util/HashSet;

    const-string v1, "method-call"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 31
    sget-object v0, Lag;->a:Ljava/util/HashSet;

    const-string v1, "crash-report"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 32
    return-void
.end method

.method constructor <init>(Lam;La;Laz;Lb$1;)V
    .locals 2

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lag;->b:Lam;

    .line 45
    iput-object p2, p0, Lag;->e:La;

    .line 46
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lag;->c:J

    .line 47
    iput-object p3, p0, Lag;->d:Laz;

    .line 48
    iput-object p4, p0, Lag;->f:Lb$1;

    .line 49
    return-void
.end method

.method private a(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 6

    .prologue
    .line 289
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 291
    iget-wide v2, p0, Lag;->c:J

    const-wide/32 v4, 0xea60

    add-long/2addr v2, v4

    cmp-long v2, v2, v0

    if-lez v2, :cond_0

    .line 292
    const-string v0, "Unknown"

    .line 298
    :goto_0
    return-object v0

    .line 294
    :cond_0
    iput-wide v0, p0, Lag;->c:J

    .line 295
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 296
    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 297
    invoke-virtual {p1, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 298
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 2

    .prologue
    .line 270
    invoke-static {}, Laz;->a()Lorg/json/JSONObject;

    move-result-object v0

    .line 271
    iget-object v1, p0, Lag;->b:Lam;

    invoke-virtual {v1, v0}, Lam;->a(Lorg/json/JSONObject;)V

    .line 272
    const-string v1, "type"

    invoke-virtual {v0, v1, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 273
    return-object v0
.end method

.method private a(Lorg/json/JSONObject;[Ljava/lang/StackTraceElement;)V
    .locals 7

    .prologue
    .line 329
    invoke-static {}, Laz;->b()Lorg/json/JSONArray;

    move-result-object v1

    .line 330
    array-length v2, p2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, p2, v0

    .line 331
    invoke-static {}, Laz;->a()Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "c"

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "m"

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "f"

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "l"

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v3

    invoke-virtual {v4, v5, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 330
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 340
    :cond_0
    const-string v0, "stackTraceElements"

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 341
    return-void
.end method

.method private b(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6

    .prologue
    .line 277
    invoke-direct {p0, p1}, Lag;->a(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 278
    iget-object v0, p0, Lag;->b:Lam;

    invoke-virtual {v0, v2}, Lam;->b(Lorg/json/JSONObject;)V

    .line 279
    iget-object v0, p0, Lag;->e:La;

    invoke-virtual {v0}, La;->b()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_1

    invoke-static {}, Laz;->a()Lorg/json/JSONObject;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v3, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    :cond_0
    const-string v0, "userdata"

    invoke-virtual {v2, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 281
    :cond_1
    sget-object v0, Lag;->a:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 282
    const-string v0, "ec"

    iget-object v1, p0, Lag;->f:Lb$1;

    invoke-virtual {v1}, Lb$1;->f()J

    move-result-wide v4

    invoke-virtual {v2, v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 285
    :cond_2
    return-object v2
.end method


# virtual methods
.method final a(JJ[Ljava/lang/StackTraceElement;)Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 165
    :try_start_0
    const-string v0, "crash-report"

    invoke-direct {p0, v0}, Lag;->b(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 166
    invoke-static {}, Laz;->a()Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "st"

    invoke-virtual {v1, v2, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "et"

    invoke-virtual {v1, v2, p3, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    move-result-object v1

    .line 172
    invoke-static {}, Laz;->a()Lorg/json/JSONObject;

    move-result-object v2

    .line 173
    invoke-direct {p0, v2, p5}, Lag;->a(Lorg/json/JSONObject;[Ljava/lang/StackTraceElement;)V

    .line 174
    const-string v3, "mainStackTrace"

    invoke-virtual {v1, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 176
    const-string v2, "androidNotRespondingReport"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 182
    :goto_0
    return-object v0

    .line 179
    :catch_0
    move-exception v0

    .line 180
    const-string v1, "Exception creating anr message"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 182
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final a(Lbj;)Lorg/json/JSONObject;
    .locals 4

    .prologue
    .line 207
    :try_start_0
    const-string v0, "ui"

    invoke-direct {p0, v0}, Lag;->b(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 209
    const-string v1, "st"

    iget-wide v2, p1, Lbj;->c:J

    invoke-virtual {v0, v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 210
    const-string v1, "activity"

    iget-object v2, p1, Lbj;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 211
    const-string v1, "event"

    iget-object v2, p1, Lbj;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 218
    :goto_0
    return-object v0

    .line 214
    :catch_0
    move-exception v0

    .line 215
    const-string v1, "Exception creating UI message"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 218
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final a(Ljava/lang/String;Ljava/lang/Throwable;I)Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 53
    :try_start_0
    const-string v0, "log-event"

    invoke-direct {p0, v0}, Lag;->a(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 54
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 55
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 57
    invoke-direct {p0, p2}, Lag;->a(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 59
    if-lez p3, :cond_0

    .line 60
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    const-string v2, "Dropped "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 62
    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 63
    const-string v2, " previous log messages."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 64
    const-string v2, "droppedMessages"

    invoke-virtual {v0, v2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 67
    :cond_0
    const-string v2, "text"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method final a(Ljava/net/URL;JJILjava/lang/String;Lt;)Lorg/json/JSONObject;
    .locals 10

    .prologue
    .line 87
    :try_start_0
    const-string v2, "network-request"

    invoke-direct {p0, v2}, Lag;->b(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 88
    const-string v2, "url"

    invoke-virtual {p1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 89
    const-string v2, "st"

    invoke-virtual {v3, v2, p2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 90
    const-string v2, "et"

    invoke-virtual {v3, v2, p4, p5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 91
    if-lez p6, :cond_0

    .line 92
    const-string v2, "hrc"

    move/from16 v0, p6

    invoke-virtual {v3, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 94
    :cond_0
    if-eqz p7, :cond_1

    .line 95
    const-string v2, "hsl"

    move-object/from16 v0, p7

    invoke-virtual {v3, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 97
    :cond_1
    if-eqz p8, :cond_4

    .line 98
    invoke-virtual/range {p8 .. p8}, Lt;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lbc;->a(Ljava/lang/String;)V

    .line 99
    const-string v2, "crg"

    move-object/from16 v0, p8

    iget-object v4, v0, Lt;->a:Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 100
    move-object/from16 v0, p8

    iget-object v2, v0, Lt;->b:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 101
    const-string v2, "sst"

    move-object/from16 v0, p8

    iget-object v4, v0, Lt;->b:Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 103
    :cond_2
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 104
    move-object/from16 v0, p8

    iget-object v2, v0, Lt;->c:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lu;

    .line 105
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 106
    const-string v7, "btId"

    iget-object v8, v2, Lu;->a:Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 107
    const-string v7, "time"

    iget-wide v8, v2, Lu;->c:J

    invoke-virtual {v6, v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 108
    const-string v7, "estimatedTime"

    iget-wide v8, v2, Lu;->b:J

    invoke-virtual {v6, v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 109
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 115
    :catch_0
    move-exception v2

    .line 116
    const-string v3, "Exception creating network request message"

    invoke-static {v3, v2}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 118
    const/4 v2, 0x0

    :goto_1
    return-object v2

    .line 111
    :cond_3
    :try_start_1
    const-string v2, "bts"

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 112
    const-string v2, "see"

    move-object/from16 v0, p8

    iget-boolean v4, v0, Lt;->d:Z

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    :cond_4
    move-object v2, v3

    .line 114
    goto :goto_1
.end method

.method final a(Ljava/net/URL;Ljava/lang/Exception;)Lorg/json/JSONObject;
    .locals 8

    .prologue
    const-wide/16 v4, -0x1

    .line 122
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-wide v6, v4

    invoke-virtual/range {v1 .. v7}, Lag;->a(Ljava/net/URL;Ljava/lang/Exception;JJ)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method final a(Ljava/net/URL;Ljava/lang/Exception;JJ)Lorg/json/JSONObject;
    .locals 9

    .prologue
    const/16 v1, 0x3e8

    .line 130
    const-string v2, "unknown"

    .line 131
    if-eqz p2, :cond_0

    .line 132
    invoke-virtual {p2}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    .line 134
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 135
    const/4 v0, 0x0

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 139
    :cond_0
    invoke-direct {p0, p2}, Lag;->a(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    move-object v0, p0

    move-object v1, p1

    move-wide v4, p3

    move-wide v6, p5

    invoke-virtual/range {v0 .. v7}, Lag;->a(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;JJ)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method final a(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;JJ)Lorg/json/JSONObject;
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 144
    :try_start_0
    const-string v0, "network-request"

    invoke-direct {p0, v0}, Lag;->b(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 145
    const-string v1, "url"

    invoke-virtual {p1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 146
    const-string v1, "ne"

    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 147
    if-eqz p3, :cond_0

    .line 148
    const-string v1, "stackTrace"

    invoke-virtual {v0, v1, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 150
    :cond_0
    cmp-long v1, p4, v4

    if-lez v1, :cond_1

    .line 151
    const-string v1, "st"

    invoke-virtual {v0, v1, p4, p5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 153
    :cond_1
    cmp-long v1, p6, v4

    if-lez v1, :cond_2

    .line 154
    const-string v1, "et"

    invoke-virtual {v0, v1, p6, p7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :cond_2
    :goto_0
    return-object v0

    .line 157
    :catch_0
    move-exception v0

    .line 158
    const-string v1, "Exception creating network request message"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 160
    const/4 v0, 0x0

    goto :goto_0
.end method
