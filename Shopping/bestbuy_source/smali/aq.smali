.class final Laq;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Lm;

.field private final b:Lb$1;

.field private final c:Ljava/util/List;


# direct methods
.method constructor <init>(Lm;Lb$1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p2, p0, Laq;->b:Lb$1;

    .line 56
    iput-object p1, p0, Laq;->a:Lm;

    .line 57
    iput-object p3, p0, Laq;->c:Ljava/util/List;

    .line 58
    return-void
.end method

.method private a(Le;)V
    .locals 3

    .prologue
    .line 65
    iget-object v0, p0, Laq;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_0

    .line 69
    :cond_0
    const-string v0, "mat"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Laq;->b:Lb$1;

    invoke-virtual {v2}, Lb$1;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    iget-object v0, p0, Laq;->b:Lb$1;

    invoke-virtual {v0}, Lb$1;->b()Ljava/lang/String;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_1

    .line 72
    const-string v1, "di"

    invoke-virtual {p1, v1, v0}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    :cond_1
    return-void
.end method

.method private a(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    .line 78
    if-nez p1, :cond_1

    .line 104
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v0, p0, Laq;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Las;

    .line 83
    invoke-virtual {v0}, Las;->a()V

    goto :goto_1

    .line 86
    :cond_2
    const-string v0, "command"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 87
    const-string v0, "command"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 88
    const-string v1, "disable-agent"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    const-string v0, "until"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 91
    new-instance v0, Lar;

    const-string v1, "until"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Lar;-><init>(J)V

    .line 96
    :goto_2
    const-string v1, "Agent Registration was denied by the collector. Throwing exception"

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 97
    throw v0

    .line 93
    :cond_3
    new-instance v0, Lar;

    invoke-direct {v0}, Lar;-><init>()V

    goto :goto_2

    .line 99
    :cond_4
    const-string v0, "mat"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    const-string v0, "mat"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 101
    iget-object v1, p0, Laq;->b:Lb$1;

    invoke-virtual {v1, v0}, Lb$1;->a(Ljava/lang/String;)V

    .line 102
    invoke-static {}, Lbc;->a()Z

    move-result v0

    if-eqz v0, :cond_5

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Calling url: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Laq;->a:Lm;

    iget-object v1, v1, Lm;->c:Ljava/net/URL;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " to register agent."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    :cond_5
    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Laq;->a:Lm;

    invoke-virtual {v0}, Lm;->a()Le;

    move-result-object v0

    const-string v2, "POST"

    invoke-virtual {v0, v2}, Le;->a(Ljava/lang/String;)V

    const-string v2, "sr"

    const-string v3, "true"

    invoke-virtual {v0, v2, v3}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Le;->g()Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v0}, Le;->g()Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/io/InputStream;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    goto/16 :goto_0

    :catch_0
    move-exception v0

    :try_start_1
    const-string v2, "Exception while trying to register with collector"

    invoke-static {v2, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    throw v0
.end method

.method private a(Ljava/lang/String;)Z
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 131
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 132
    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "["

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "] Agent sending message to collector ("

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v4, p0, Laq;->a:Lm;

    iget-object v4, v4, Lm;->b:Ljava/net/URL;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ") ["

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v4, p0, Laq;->a:Lm;

    iget-object v4, v4, Lm;->a:Lam;

    invoke-virtual {v4}, Lam;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "]:"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 135
    invoke-static {p1}, Lbc;->a(Ljava/lang/String;)V

    .line 136
    const-string v1, "-----------------------------------"

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 141
    :cond_0
    :try_start_0
    iget-object v1, p0, Laq;->a:Lm;

    invoke-virtual {v1}, Lm;->b()Le;

    move-result-object v1

    .line 142
    if-eqz p1, :cond_1

    .line 143
    const-string v4, "gzip"

    const-string v5, "true"

    invoke-virtual {v1, v4, v5}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    invoke-direct {p0, v1}, Laq;->a(Le;)V

    .line 146
    new-instance v4, Ljava/util/zip/GZIPOutputStream;

    invoke-virtual {v1}, Le;->f()Ljava/io/OutputStream;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 147
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/zip/GZIPOutputStream;->write([B)V

    .line 148
    invoke-virtual {v4}, Ljava/util/zip/GZIPOutputStream;->close()V

    .line 151
    :cond_1
    invoke-virtual {v1}, Le;->g()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v4

    .line 153
    :try_start_1
    invoke-virtual {v1}, Le;->h()I

    move-result v1

    .line 154
    invoke-static {}, Lbc;->a()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 155
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Agent received response code: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lbc;->a(Ljava/lang/String;)V

    .line 158
    :cond_2
    const/16 v5, 0xc8

    if-ne v1, v5, :cond_5

    .line 159
    invoke-static {v4}, Lbb;->a(Ljava/io/InputStream;)Lorg/json/JSONObject;

    move-result-object v1

    .line 160
    invoke-direct {p0, v1}, Laq;->a(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 161
    :try_start_2
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 175
    invoke-static {}, Lbc;->a()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 176
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] Total time taken to complete request is "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " ms."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    :cond_3
    const/4 v0, 0x1

    :cond_4
    :goto_0
    return v0

    .line 163
    :cond_5
    :try_start_3
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 175
    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 176
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "["

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "] Total time taken to complete request is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ms."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 165
    :catch_0
    move-exception v1

    .line 166
    :try_start_4
    const-string v5, "Error processing JSON"

    invoke-static {v5, v1}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 167
    :try_start_5
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 175
    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 176
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "["

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "] Total time taken to complete request is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ms."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 169
    :catchall_0
    move-exception v1

    :try_start_6
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    throw v1
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 171
    :catch_1
    move-exception v1

    .line 172
    :try_start_7
    const-string v4, "Error sending message to collector"

    invoke-static {v4, v1}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 173
    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 176
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "["

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "] Total time taken to complete request is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ms."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 175
    :catchall_1
    move-exception v0

    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 176
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "["

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lbc;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "] Total time taken to complete request is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ms."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    :cond_6
    throw v0
.end method


# virtual methods
.method final a()Lm;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Laq;->a:Lm;

    return-object v0
.end method

.method final a(Lorg/json/JSONArray;)Z
    .locals 1

    .prologue
    .line 61
    invoke-virtual {p1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Laq;->a(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
