.class final Lbe;
.super Ljava/io/Writer;
.source "SourceFile"


# instance fields
.field private final a:[C

.field private b:C

.field private synthetic c:Lbd;


# direct methods
.method public constructor <init>(Lbd;)V
    .locals 1

    .prologue
    .line 153
    iput-object p1, p0, Lbe;->c:Lbd;

    .line 154
    invoke-static {p1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/io/Writer;-><init>(Ljava/lang/Object;)V

    .line 150
    const/4 v0, 0x1

    new-array v0, v0, [C

    iput-object v0, p0, Lbe;->a:[C

    .line 151
    const/4 v0, 0x0

    iput-char v0, p0, Lbe;->b:C

    .line 155
    return-void
.end method

.method private a(C)V
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lbe;->a:[C

    const/4 v1, 0x0

    aput-char p1, v0, v1

    .line 159
    iget-object v0, p0, Lbe;->c:Lbd;

    invoke-static {v0}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v0

    iget-object v1, p0, Lbe;->a:[C

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write([C)V

    .line 160
    return-void
.end method


# virtual methods
.method public final close()V
    .locals 0

    .prologue
    .line 165
    return-void
.end method

.method public final flush()V
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lbe;->c:Lbd;

    invoke-static {v0}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V

    .line 170
    return-void
.end method

.method public final write(I)V
    .locals 6

    .prologue
    const/16 v3, 0x5c

    .line 187
    int-to-char v0, p1

    .line 188
    sparse-switch v0, :sswitch_data_0

    .line 216
    const/16 v1, 0x20

    if-lt v0, v1, :cond_1

    const/16 v1, 0x80

    if-lt v0, v1, :cond_0

    const/16 v1, 0xa0

    if-lt v0, v1, :cond_1

    :cond_0
    const/16 v1, 0x2000

    if-lt v0, v1, :cond_2

    const/16 v1, 0x2100

    if-ge v0, v1, :cond_2

    .line 218
    :cond_1
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\u"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 219
    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    .line 220
    iget-object v2, p0, Lbe;->c:Lbd;

    invoke-static {v2}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v2

    const-string v3, "0000"

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    rsub-int/lit8 v5, v5, 0x4

    invoke-virtual {v2, v3, v4, v5}, Ljava/io/Writer;->write(Ljava/lang/String;II)V

    .line 221
    iget-object v2, p0, Lbe;->c:Lbd;

    invoke-static {v2}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 226
    :goto_0
    iput-char v0, p0, Lbe;->b:C

    .line 227
    return-void

    .line 191
    :sswitch_0
    invoke-direct {p0, v3}, Lbe;->a(C)V

    .line 223
    :cond_2
    invoke-direct {p0, v0}, Lbe;->a(C)V

    goto :goto_0

    .line 195
    :sswitch_1
    iget-char v1, p0, Lbe;->b:C

    const/16 v2, 0x3c

    if-ne v1, v2, :cond_3

    .line 196
    invoke-direct {p0, v3}, Lbe;->a(C)V

    .line 198
    :cond_3
    invoke-direct {p0, v0}, Lbe;->a(C)V

    goto :goto_0

    .line 201
    :sswitch_2
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\b"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 204
    :sswitch_3
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\t"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 207
    :sswitch_4
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 210
    :sswitch_5
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\f"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 213
    :sswitch_6
    iget-object v1, p0, Lbe;->c:Lbd;

    invoke-static {v1}, Lbd;->a(Lbd;)Ljava/io/Writer;

    move-result-object v1

    const-string v2, "\\r"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 188
    nop

    :sswitch_data_0
    .sparse-switch
        0x8 -> :sswitch_2
        0x9 -> :sswitch_3
        0xa -> :sswitch_4
        0xc -> :sswitch_5
        0xd -> :sswitch_6
        0x22 -> :sswitch_0
        0x2f -> :sswitch_1
        0x5c -> :sswitch_0
    .end sparse-switch
.end method

.method public final write([CII)V
    .locals 1

    .prologue
    .line 174
    :goto_0
    if-ge p2, p3, :cond_0

    .line 175
    aget-char v0, p1, p2

    invoke-virtual {p0, v0}, Lbe;->write(I)V

    .line 174
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 177
    :cond_0
    return-void
.end method
