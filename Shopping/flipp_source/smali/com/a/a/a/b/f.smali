.class final Lcom/a/a/a/b/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/b/b;


# instance fields
.field private final a:Ljava/io/DataInputStream;


# direct methods
.method constructor <init>(Ljava/io/InputStream;)V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Ljava/io/DataInputStream;

    invoke-direct {v0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v0, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    .line 56
    return-void
.end method

.method private static varargs a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
    .locals 2

    .prologue
    .line 191
    new-instance v0, Ljava/io/IOException;

    invoke-static {p0, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public final a(Lcom/a/a/a/b/c;)Z
    .locals 10

    .prologue
    const v9, 0x7fffffff

    const/16 v8, 0x8

    const/4 v7, 0x4

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 61
    :try_start_0
    iget-object v2, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 65
    iget-object v3, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    .line 67
    const v4, 0xffff

    and-int/2addr v4, v2

    .line 68
    const/high16 v5, 0xff0000

    and-int/2addr v5, v2

    shr-int/lit8 v5, v5, 0x10

    .line 69
    const/high16 v6, -0x1000000

    and-int/2addr v2, v6

    shr-int/lit8 v2, v2, 0x18

    .line 71
    and-int/2addr v3, v9

    .line 73
    packed-switch v5, :pswitch_data_0

    .line 107
    :pswitch_0
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "TODO"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :catch_0
    move-exception v1

    move v1, v0

    .line 104
    :goto_0
    :pswitch_1
    return v1

    .line 75
    :pswitch_2
    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_0

    move v0, v1

    :cond_0
    iget-object v2, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-interface {p1, v0, v3, v2, v4}, Lcom/a/a/a/b/c;->a(ZILjava/io/InputStream;I)V

    goto :goto_0

    .line 79
    :pswitch_3
    if-eq v4, v7, :cond_1

    const-string v2, "TYPE_PRIORITY length: %d != 4"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_1
    if-nez v3, :cond_2

    const-string v1, "TYPE_PRIORITY streamId == 0"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    goto :goto_0

    .line 83
    :pswitch_4
    if-eq v4, v7, :cond_3

    const-string v2, "TYPE_RST_STREAM length: %d != 4"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_3
    if-nez v3, :cond_4

    const-string v1, "TYPE_RST_STREAM streamId == 0"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_4
    iget-object v2, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    move-result v2

    invoke-static {v2}, Lcom/a/a/a/b/a;->b(I)Lcom/a/a/a/b/a;

    move-result-object v4

    if-nez v4, :cond_5

    const-string v3, "TYPE_RST_STREAM unexpected error code: %d"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v0

    invoke-static {v3, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_5
    invoke-interface {p1, v3, v4}, Lcom/a/a/a/b/c;->a(ILcom/a/a/a/b/a;)V

    goto :goto_0

    .line 87
    :pswitch_5
    rem-int/lit8 v2, v4, 0x8

    if-eqz v2, :cond_6

    const-string v2, "TYPE_SETTINGS length %% 8 != 0: %s"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_6
    if-eqz v3, :cond_7

    const-string v1, "TYPE_SETTINGS streamId != 0"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_7
    new-instance v3, Lcom/a/a/a/b/k;

    invoke-direct {v3}, Lcom/a/a/a/b/k;-><init>()V

    move v2, v0

    :goto_1
    if-ge v2, v4, :cond_8

    iget-object v5, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v5}, Ljava/io/DataInputStream;->readInt()I

    move-result v5

    iget-object v6, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v6}, Ljava/io/DataInputStream;->readInt()I

    move-result v6

    const v7, 0xffffff

    and-int/2addr v5, v7

    invoke-virtual {v3, v5, v0, v6}, Lcom/a/a/a/b/k;->a(III)V

    add-int/lit8 v2, v2, 0x8

    goto :goto_1

    :cond_8
    invoke-interface {p1, v0, v3}, Lcom/a/a/a/b/c;->a(ZLcom/a/a/a/b/k;)V

    goto/16 :goto_0

    .line 95
    :pswitch_6
    if-eq v4, v8, :cond_9

    const-string v2, "TYPE_PING length != 8: %s"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_9
    if-eqz v3, :cond_a

    const-string v1, "TYPE_PING streamId != 0"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v1, v0}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_a
    iget-object v3, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    iget-object v4, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v4}, Ljava/io/DataInputStream;->readInt()I

    move-result v4

    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_b

    move v0, v1

    :cond_b
    invoke-interface {p1, v0, v3, v4}, Lcom/a/a/a/b/c;->a(ZII)V

    goto/16 :goto_0

    .line 99
    :pswitch_7
    if-ge v4, v8, :cond_c

    const-string v2, "TYPE_GOAWAY length < 8: %s"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_c
    iget-object v2, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/DataInputStream;->readInt()I

    move-result v2

    iget-object v3, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    add-int/lit8 v4, v4, -0x8

    invoke-static {v3}, Lcom/a/a/a/b/a;->b(I)Lcom/a/a/a/b/a;

    move-result-object v5

    if-nez v5, :cond_d

    const-string v2, "TYPE_RST_STREAM unexpected error code: %d"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Lcom/a/a/a/b/f;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_d
    iget-object v0, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    int-to-long v6, v4

    invoke-static {v0, v6, v7}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;J)J

    move-result-wide v6

    int-to-long v4, v4

    cmp-long v0, v6, v4

    if-eqz v0, :cond_e

    new-instance v0, Ljava/io/IOException;

    const-string v1, "TYPE_GOAWAY opaque data was truncated"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_e
    invoke-interface {p1, v2}, Lcom/a/a/a/b/c;->a(I)V

    goto/16 :goto_0

    .line 103
    :pswitch_8
    iget-object v0, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    and-int/2addr v0, v9

    invoke-interface {p1, v3, v0}, Lcom/a/a/a/b/c;->a(II)V

    goto/16 :goto_0

    .line 73
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_1
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_8
    .end packed-switch
.end method

.method public final close()V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/a/a/a/b/f;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->close()V

    .line 196
    return-void
.end method
