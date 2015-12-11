.class Lcom/google/gdata/util/common/base/UnicodeEscaper$1;
.super Ljava/lang/Object;
.source "UnicodeEscaper.java"

# interfaces
.implements Ljava/lang/Appendable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/gdata/util/common/base/UnicodeEscaper;->escape(Ljava/lang/Appendable;)Ljava/lang/Appendable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final decodedChars:[C

.field pendingHighSurrogate:I

.field final synthetic this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

.field final synthetic val$out:Ljava/lang/Appendable;


# direct methods
.method constructor <init>(Lcom/google/gdata/util/common/base/UnicodeEscaper;Ljava/lang/Appendable;)V
    .locals 1

    .prologue
    .line 255
    iput-object p1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    iput-object p2, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 256
    const/4 v0, -0x1

    iput v0, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    .line 257
    const/4 v0, 0x2

    new-array v0, v0, [C

    iput-object v0, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->decodedChars:[C

    return-void
.end method

.method private outputChars([CI)V
    .locals 3
    .param p1, "chars"    # [C
    .param p2, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 367
    const/4 v0, 0x0

    .local v0, "n":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 368
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    aget-char v2, p1, v0

    invoke-interface {v1, v2}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    .line 367
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 370
    :cond_0
    return-void
.end method


# virtual methods
.method public append(C)Ljava/lang/Appendable;
    .locals 4
    .param p1, "c"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, -0x1

    .line 329
    iget v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    if-eq v1, v3, :cond_2

    .line 332
    invoke-static {p1}, Ljava/lang/Character;->isLowSurrogate(C)Z

    move-result v1

    if-nez v1, :cond_0

    .line 333
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Expected low surrogate character but got \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' with value "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 337
    :cond_0
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    iget v2, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    int-to-char v2, v2

    invoke-static {v2, p1}, Ljava/lang/Character;->toCodePoint(CC)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->escape(I)[C

    move-result-object v0

    .line 339
    .local v0, "escaped":[C
    if-eqz v0, :cond_1

    .line 340
    array-length v1, v0

    invoke-direct {p0, v0, v1}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->outputChars([CI)V

    .line 345
    :goto_0
    iput v3, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    .line 363
    .end local v0    # "escaped":[C
    :goto_1
    return-object p0

    .line 342
    .restart local v0    # "escaped":[C
    :cond_1
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    iget v2, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    int-to-char v2, v2

    invoke-interface {v1, v2}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    .line 343
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    invoke-interface {v1, p1}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    goto :goto_0

    .line 346
    .end local v0    # "escaped":[C
    :cond_2
    invoke-static {p1}, Ljava/lang/Character;->isHighSurrogate(C)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 348
    iput p1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    goto :goto_1

    .line 350
    :cond_3
    invoke-static {p1}, Ljava/lang/Character;->isLowSurrogate(C)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 351
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unexpected low surrogate character \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' with value "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 356
    :cond_4
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    invoke-virtual {v1, p1}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->escape(I)[C

    move-result-object v0

    .line 357
    .restart local v0    # "escaped":[C
    if-eqz v0, :cond_5

    .line 358
    array-length v1, v0

    invoke-direct {p0, v0, v1}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->outputChars([CI)V

    goto :goto_1

    .line 360
    :cond_5
    iget-object v1, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    invoke-interface {v1, p1}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    goto :goto_1
.end method

.method public append(Ljava/lang/CharSequence;)Ljava/lang/Appendable;
    .locals 2
    .param p1, "csq"    # Ljava/lang/CharSequence;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 260
    const/4 v0, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;
    .locals 10
    .param p1, "csq"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "end"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v9, -0x1

    .line 265
    move v3, p2

    .line 266
    .local v3, "index":I
    if-ge v3, p3, :cond_3

    .line 270
    move v6, v3

    .line 271
    .local v6, "unescapedChunkStart":I
    iget v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    if-eq v7, v9, :cond_1

    .line 274
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "index":I
    .local v4, "index":I
    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 275
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isLowSurrogate(C)Z

    move-result v7

    if-nez v7, :cond_0

    .line 276
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Expected low surrogate character but got "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 279
    :cond_0
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    iget v8, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    int-to-char v8, v8

    invoke-static {v8, v0}, Ljava/lang/Character;->toCodePoint(CC)I

    move-result v8

    invoke-virtual {v7, v8}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->escape(I)[C

    move-result-object v2

    .line 281
    .local v2, "escaped":[C
    if-eqz v2, :cond_4

    .line 284
    array-length v7, v2

    invoke-direct {p0, v2, v7}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->outputChars([CI)V

    .line 285
    add-int/lit8 v6, v6, 0x1

    .line 291
    :goto_0
    iput v9, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    move v3, v4

    .line 295
    .end local v0    # "c":C
    .end local v2    # "escaped":[C
    .end local v4    # "index":I
    .restart local v3    # "index":I
    :cond_1
    :goto_1
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    invoke-virtual {v7, p1, v3, p3}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->nextEscapeIndex(Ljava/lang/CharSequence;II)I

    move-result v3

    .line 296
    if-le v3, v6, :cond_2

    .line 297
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    invoke-interface {v7, p1, v6, v3}, Ljava/lang/Appendable;->append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;

    .line 299
    :cond_2
    if-ne v3, p3, :cond_5

    .line 325
    .end local v6    # "unescapedChunkStart":I
    :cond_3
    :goto_2
    return-object p0

    .line 289
    .end local v3    # "index":I
    .restart local v0    # "c":C
    .restart local v2    # "escaped":[C
    .restart local v4    # "index":I
    .restart local v6    # "unescapedChunkStart":I
    :cond_4
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->val$out:Ljava/lang/Appendable;

    iget v8, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    int-to-char v8, v8

    invoke-interface {v7, v8}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    goto :goto_0

    .line 303
    .end local v0    # "c":C
    .end local v2    # "escaped":[C
    .end local v4    # "index":I
    .restart local v3    # "index":I
    :cond_5
    invoke-static {p1, v3, p3}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->codePointAt(Ljava/lang/CharSequence;II)I

    move-result v1

    .line 304
    .local v1, "cp":I
    if-gez v1, :cond_6

    .line 307
    neg-int v7, v1

    iput v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->pendingHighSurrogate:I

    goto :goto_2

    .line 311
    :cond_6
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->this$0:Lcom/google/gdata/util/common/base/UnicodeEscaper;

    invoke-virtual {v7, v1}, Lcom/google/gdata/util/common/base/UnicodeEscaper;->escape(I)[C

    move-result-object v2

    .line 312
    .restart local v2    # "escaped":[C
    if-eqz v2, :cond_7

    .line 313
    array-length v7, v2

    invoke-direct {p0, v2, v7}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->outputChars([CI)V

    .line 321
    :goto_3
    invoke-static {v1}, Ljava/lang/Character;->isSupplementaryCodePoint(I)Z

    move-result v7

    if-eqz v7, :cond_8

    const/4 v7, 0x2

    :goto_4
    add-int/2addr v3, v7

    .line 322
    move v6, v3

    .line 323
    goto :goto_1

    .line 317
    :cond_7
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->decodedChars:[C

    const/4 v8, 0x0

    invoke-static {v1, v7, v8}, Ljava/lang/Character;->toChars(I[CI)I

    move-result v5

    .line 318
    .local v5, "len":I
    iget-object v7, p0, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->decodedChars:[C

    invoke-direct {p0, v7, v5}, Lcom/google/gdata/util/common/base/UnicodeEscaper$1;->outputChars([CI)V

    goto :goto_3

    .line 321
    .end local v5    # "len":I
    :cond_8
    const/4 v7, 0x1

    goto :goto_4
.end method
