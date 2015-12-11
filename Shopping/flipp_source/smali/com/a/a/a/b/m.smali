.class final Lcom/a/a/a/b/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/b/b;


# instance fields
.field final a:Ljava/io/DataInputStream;

.field b:I

.field private final c:Ljava/io/DataInputStream;

.field private final d:Z


# direct methods
.method constructor <init>(Ljava/io/InputStream;Z)V
    .locals 4

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    new-instance v0, Ljava/io/DataInputStream;

    invoke-direct {v0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    .line 112
    new-instance v0, Lcom/a/a/a/b/n;

    invoke-direct {v0, p0}, Lcom/a/a/a/b/n;-><init>(Lcom/a/a/a/b/m;)V

    new-instance v1, Lcom/a/a/a/b/o;

    invoke-direct {v1, p0}, Lcom/a/a/a/b/o;-><init>(Lcom/a/a/a/b/m;)V

    new-instance v2, Ljava/io/DataInputStream;

    new-instance v3, Ljava/util/zip/InflaterInputStream;

    invoke-direct {v3, v0, v1}, Ljava/util/zip/InflaterInputStream;-><init>(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V

    invoke-direct {v2, v3}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v2, p0, Lcom/a/a/a/b/m;->c:Ljava/io/DataInputStream;

    .line 113
    iput-boolean p2, p0, Lcom/a/a/a/b/m;->d:Z

    .line 114
    return-void
.end method

.method private static varargs a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
    .locals 2

    .prologue
    .line 350
    new-instance v0, Ljava/io/IOException;

    invoke-static {p0, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private a()Ljava/lang/String;
    .locals 5

    .prologue
    .line 308
    iget-object v0, p0, Lcom/a/a/a/b/m;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    .line 309
    new-array v1, v0, [B

    .line 310
    iget-object v2, p0, Lcom/a/a/a/b/m;->c:Ljava/io/DataInputStream;

    invoke-static {v2, v1}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;[B)V

    .line 311
    new-instance v2, Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "UTF-8"

    invoke-direct {v2, v1, v3, v0, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    return-object v2
.end method

.method private a(I)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 281
    iget v1, p0, Lcom/a/a/a/b/m;->b:I

    add-int/2addr v1, p1

    iput v1, p0, Lcom/a/a/a/b/m;->b:I

    .line 283
    :try_start_0
    iget-object v1, p0, Lcom/a/a/a/b/m;->c:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/DataInputStream;->readInt()I

    move-result v1

    .line 284
    mul-int/lit8 v2, v1, 0x2

    if-gez v2, :cond_0

    .line 285
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "numberOfPairs < 0: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    .line 286
    const-string v0, "numberOfPairs < 0"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0
    :try_end_0
    .catch Ljava/util/zip/DataFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 302
    :catch_0
    move-exception v0

    .line 303
    new-instance v1, Ljava/io/IOException;

    invoke-virtual {v0}, Ljava/util/zip/DataFormatException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 288
    :cond_0
    :try_start_1
    new-instance v2, Ljava/util/ArrayList;

    mul-int/lit8 v3, v1, 0x2

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 289
    :goto_0
    if-ge v0, v1, :cond_2

    .line 290
    invoke-direct {p0}, Lcom/a/a/a/b/m;->a()Ljava/lang/String;

    move-result-object v3

    .line 291
    invoke-direct {p0}, Lcom/a/a/a/b/m;->a()Ljava/lang/String;

    move-result-object v4

    .line 292
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    const-string v0, "name.length == 0"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    .line 293
    :cond_1
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 294
    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 289
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 297
    :cond_2
    iget v0, p0, Lcom/a/a/a/b/m;->b:I

    if-eqz v0, :cond_3

    .line 298
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "compressedLimit > 0: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcom/a/a/a/b/m;->b:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/util/zip/DataFormatException; {:try_start_1 .. :try_end_1} :catch_0

    .line 301
    :cond_3
    return-object v2
.end method

.method private a(Lcom/a/a/a/b/c;II)V
    .locals 9

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 333
    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    .line 334
    mul-int/lit8 v2, v3, 0x8

    add-int/lit8 v2, v2, 0x4

    if-eq p3, v2, :cond_0

    .line 335
    const-string v2, "TYPE_SETTINGS length: %d != 4 + 8 * %d"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v4, v0

    invoke-static {v2, v4}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    .line 337
    :cond_0
    new-instance v4, Lcom/a/a/a/b/k;

    invoke-direct {v4}, Lcom/a/a/a/b/k;-><init>()V

    move v2, v1

    .line 338
    :goto_0
    if-ge v2, v3, :cond_1

    .line 339
    iget-object v5, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v5}, Ljava/io/DataInputStream;->readInt()I

    move-result v5

    .line 340
    iget-object v6, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v6}, Ljava/io/DataInputStream;->readInt()I

    move-result v6

    .line 341
    const/high16 v7, -0x1000000

    and-int/2addr v7, v5

    ushr-int/lit8 v7, v7, 0x18

    .line 342
    const v8, 0xffffff

    and-int/2addr v5, v8

    .line 343
    invoke-virtual {v4, v5, v7, v6}, Lcom/a/a/a/b/k;->a(III)V

    .line 338
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 345
    :cond_1
    and-int/lit8 v2, p2, 0x1

    if-eqz v2, :cond_2

    .line 346
    :goto_1
    invoke-interface {p1, v0, v4}, Lcom/a/a/a/b/c;->a(ZLcom/a/a/a/b/k;)V

    .line 347
    return-void

    :cond_2
    move v0, v1

    .line 345
    goto :goto_1
.end method


# virtual methods
.method public final a(Lcom/a/a/a/b/c;)Z
    .locals 10

    .prologue
    const/16 v9, 0x8

    const v5, 0x7fffffff

    const/4 v1, 0x0

    const/4 v7, 0x1

    .line 123
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 127
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    .line 129
    const/high16 v0, -0x80000000

    and-int/2addr v0, v2

    if-eqz v0, :cond_1

    move v0, v7

    .line 130
    :goto_0
    const/high16 v4, -0x1000000

    and-int/2addr v4, v3

    ushr-int/lit8 v8, v4, 0x18

    .line 131
    const v4, 0xffffff

    and-int v6, v3, v4

    .line 133
    if-eqz v0, :cond_e

    .line 134
    const/high16 v0, 0x7fff0000

    and-int/2addr v0, v2

    ushr-int/lit8 v0, v0, 0x10

    .line 135
    const v3, 0xffff

    and-int/2addr v2, v3

    .line 137
    const/4 v3, 0x3

    if-eq v0, v3, :cond_2

    .line 138
    new-instance v1, Ljava/net/ProtocolException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "version != 3: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 125
    :catch_0
    move-exception v0

    move v7, v1

    .line 190
    :cond_0
    :goto_1
    return v7

    :cond_1
    move v0, v1

    .line 129
    goto :goto_0

    .line 141
    :cond_2
    packed-switch v2, :pswitch_data_0

    .line 184
    :pswitch_0
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Unexpected frame"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :pswitch_1
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readShort()S

    move-result v2

    and-int v3, v0, v5

    const v0, 0xe000

    and-int/2addr v0, v2

    ushr-int/lit8 v4, v0, 0xd

    and-int/lit16 v5, v2, 0xff

    add-int/lit8 v0, v6, -0xa

    invoke-direct {p0, v0}, Lcom/a/a/a/b/m;->a(I)Ljava/util/List;

    move-result-object v6

    and-int/lit8 v0, v8, 0x1

    if-eqz v0, :cond_4

    move v2, v7

    :goto_2
    and-int/lit8 v0, v8, 0x2

    if-eqz v0, :cond_3

    move v1, v7

    :cond_3
    move-object v0, p1

    invoke-interface/range {v0 .. v6}, Lcom/a/a/a/b/c;->a(ZZIIILjava/util/List;)V

    goto :goto_1

    :cond_4
    move v2, v1

    goto :goto_2

    .line 147
    :pswitch_2
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    and-int/2addr v0, v5

    add-int/lit8 v2, v6, -0x4

    invoke-direct {p0, v2}, Lcom/a/a/a/b/m;->a(I)Ljava/util/List;

    move-result-object v2

    and-int/lit8 v3, v8, 0x1

    if-eqz v3, :cond_5

    move v1, v7

    :cond_5
    invoke-interface {p1, v1, v0, v2}, Lcom/a/a/a/b/c;->a(ZILjava/util/List;)V

    goto :goto_1

    .line 151
    :pswitch_3
    if-eq v6, v9, :cond_6

    const-string v0, "TYPE_RST_STREAM length: %d != 8"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_6
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    and-int/2addr v0, v5

    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    move-result v2

    invoke-static {v2}, Lcom/a/a/a/b/a;->a(I)Lcom/a/a/a/b/a;

    move-result-object v3

    if-nez v3, :cond_7

    const-string v0, "TYPE_RST_STREAM unexpected error code: %d"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v3, v1

    invoke-static {v0, v3}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_7
    invoke-interface {p1, v0, v3}, Lcom/a/a/a/b/c;->a(ILcom/a/a/a/b/a;)V

    goto/16 :goto_1

    .line 155
    :pswitch_4
    invoke-direct {p0, p1, v8, v6}, Lcom/a/a/a/b/m;->a(Lcom/a/a/a/b/c;II)V

    goto/16 :goto_1

    .line 159
    :pswitch_5
    if-eqz v6, :cond_0

    const-string v0, "TYPE_NOOP length: %d != 0"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    .line 164
    :pswitch_6
    const/4 v0, 0x4

    if-eq v6, v0, :cond_8

    const-string v0, "TYPE_PING length: %d != 4"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_8
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v2

    iget-boolean v3, p0, Lcom/a/a/a/b/m;->d:Z

    rem-int/lit8 v0, v2, 0x2

    if-ne v0, v7, :cond_9

    move v0, v7

    :goto_3
    if-ne v3, v0, :cond_a

    move v0, v7

    :goto_4
    invoke-interface {p1, v0, v2, v1}, Lcom/a/a/a/b/c;->a(ZII)V

    goto/16 :goto_1

    :cond_9
    move v0, v1

    goto :goto_3

    :cond_a
    move v0, v1

    goto :goto_4

    .line 168
    :pswitch_7
    if-eq v6, v9, :cond_b

    const-string v0, "TYPE_GOAWAY length: %d != 8"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    and-int/2addr v0, v5

    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    move-result v2

    invoke-static {v2}, Lcom/a/a/a/b/a;->c(I)Lcom/a/a/a/b/a;

    move-result-object v3

    if-nez v3, :cond_c

    const-string v0, "TYPE_GOAWAY unexpected error code: %d"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v3, v1

    invoke-static {v0, v3}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_c
    invoke-interface {p1, v0}, Lcom/a/a/a/b/c;->a(I)V

    goto/16 :goto_1

    .line 172
    :pswitch_8
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    and-int/2addr v0, v5

    add-int/lit8 v1, v6, -0x4

    invoke-direct {p0, v1}, Lcom/a/a/a/b/m;->a(I)Ljava/util/List;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/a/a/a/b/c;->a(ILjava/util/List;)V

    goto/16 :goto_1

    .line 176
    :pswitch_9
    if-eq v6, v9, :cond_d

    const-string v0, "TYPE_WINDOW_UPDATE length: %d != 8"

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Lcom/a/a/a/b/m;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_d
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    iget-object v1, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/DataInputStream;->readInt()I

    move-result v1

    and-int/2addr v0, v5

    and-int/2addr v1, v5

    invoke-interface {p1, v0, v1}, Lcom/a/a/a/b/c;->a(II)V

    goto/16 :goto_1

    .line 180
    :pswitch_a
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    int-to-long v2, v6

    invoke-static {v0, v2, v3}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;J)J

    .line 181
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "TODO"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 187
    :cond_e
    and-int v0, v2, v5

    .line 188
    and-int/lit8 v2, v8, 0x1

    if-eqz v2, :cond_f

    move v1, v7

    .line 189
    :cond_f
    iget-object v2, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-interface {p1, v1, v0, v2, v6}, Lcom/a/a/a/b/c;->a(ZILjava/io/InputStream;I)V

    goto/16 :goto_1

    .line 141
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_a
    .end packed-switch
.end method

.method public final close()V
    .locals 2

    .prologue
    .line 354
    iget-object v0, p0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    iget-object v1, p0, Lcom/a/a/a/b/m;->c:Ljava/io/DataInputStream;

    invoke-static {v0, v1}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;Ljava/io/Closeable;)V

    .line 355
    return-void
.end method
