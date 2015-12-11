.class public Lv;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lv;->a:Ljava/util/List;

    .line 18
    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/Long;
    .locals 6

    .prologue
    .line 97
    :try_start_0
    invoke-static {p0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    .line 98
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    .line 104
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 109
    :try_start_0
    const-string v0, "UTF-8"

    invoke-static {p0, v0}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 110
    :catch_0
    move-exception v0

    .line 111
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public final a()Lt;
    .locals 13

    .prologue
    .line 49
    iget-object v0, p0, Lv;->a:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 51
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 53
    const/4 v3, 0x0

    .line 54
    const-wide/16 v6, -0x1

    const-wide/16 v4, -0x1

    .line 55
    const/4 v2, 0x0

    .line 56
    const/4 v1, 0x0

    .line 57
    const/4 v0, 0x0

    .line 58
    iget-object v8, p0, Lv;->a:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    move-object v8, v3

    move-object v3, v2

    move-object v2, v1

    move v1, v0

    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lw;

    .line 59
    invoke-static {v0}, Lw;->a(Lw;)Ljava/lang/String;

    move-result-object v0

    const-string v11, ":"

    invoke-virtual {v0, v11}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 60
    array-length v11, v0

    const/4 v12, 0x2

    if-ne v11, v12, :cond_9

    .line 61
    const-string v11, "btERT"

    const/4 v12, 0x0

    aget-object v12, v0, v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 62
    const/4 v6, 0x1

    aget-object v0, v0, v6

    invoke-static {v0}, Lv;->a(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    goto :goto_0

    .line 63
    :cond_0
    const-string v11, "btDuration"

    const/4 v12, 0x0

    aget-object v12, v0, v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 64
    const/4 v4, 0x1

    aget-object v0, v0, v4

    invoke-static {v0}, Lv;->a(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    goto :goto_0

    .line 65
    :cond_1
    const-string v11, "btId"

    const/4 v12, 0x0

    aget-object v12, v0, v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 69
    if-eqz v8, :cond_2

    .line 70
    new-instance v11, Lu;

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {v11, v8, v6, v4}, Lu;-><init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V

    invoke-interface {v9, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 72
    const-wide/16 v6, -0x1

    .line 73
    const-wide/16 v4, -0x1

    .line 75
    :cond_2
    const/4 v8, 0x1

    aget-object v0, v0, v8

    move-object v8, v0

    goto :goto_0

    .line 76
    :cond_3
    const-string v11, "clientRequestGUID"

    const/4 v12, 0x0

    aget-object v12, v0, v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_4

    .line 77
    const/4 v3, 0x1

    aget-object v0, v0, v3

    move-object v3, v0

    goto :goto_0

    .line 78
    :cond_4
    const-string v11, "serverSnapshotType"

    const/4 v12, 0x0

    aget-object v12, v0, v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 79
    const/4 v2, 0x1

    aget-object v0, v0, v2

    move-object v2, v0

    goto/16 :goto_0

    .line 80
    :cond_5
    const-string v11, "hasEntryPointErrors"

    const/4 v12, 0x0

    aget-object v0, v0, v12

    invoke-virtual {v11, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 81
    const/4 v1, 0x1

    move v0, v1

    :goto_1
    move v1, v0

    .line 84
    goto/16 :goto_0

    .line 85
    :cond_6
    if-eqz v8, :cond_7

    .line 86
    new-instance v0, Lu;

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {v0, v8, v6, v4}, Lu;-><init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 88
    :cond_7
    if-nez v3, :cond_8

    .line 89
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    .line 92
    :cond_8
    new-instance v0, Lt;

    invoke-direct {v0, v3, v2, v9, v1}, Lt;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V

    return-object v0

    :cond_9
    move v0, v1

    goto :goto_1
.end method

.method public final a(Ljava/lang/String;Ljava/util/List;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 34
    if-eqz p1, :cond_0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 35
    const-string v0, "_"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 36
    array-length v1, v0

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    const-string v1, "ADRUM"

    aget-object v2, v0, v3

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 37
    aget-object v0, v0, v4

    invoke-static {v0}, Lv;->a(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    .line 38
    if-eqz v1, :cond_0

    .line 39
    new-instance v2, Lw;

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lv;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v1, v0, v3}, Lw;-><init>(Ljava/lang/Long;Ljava/lang/String;B)V

    .line 40
    iget-object v0, p0, Lv;->a:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 44
    :cond_0
    return-void
.end method
