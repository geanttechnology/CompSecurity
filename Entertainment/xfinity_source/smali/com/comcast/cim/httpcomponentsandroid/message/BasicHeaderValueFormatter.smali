.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;
.super Ljava/lang/Object;
.source "BasicHeaderValueFormatter.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueFormatter;


# static fields
.field public static final DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected doFormatValue(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Ljava/lang/String;Z)V
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "quote"    # Z

    .prologue
    const/16 v3, 0x22

    .line 381
    if-nez p3, :cond_0

    .line 382
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_0

    if-nez p3, :cond_0

    .line 383
    invoke-virtual {p2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;->isSeparator(C)Z

    move-result p3

    .line 382
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 387
    .end local v1    # "i":I
    :cond_0
    if-eqz p3, :cond_1

    .line 388
    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 390
    :cond_1
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_3

    .line 391
    invoke-virtual {p2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 392
    .local v0, "ch":C
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;->isUnsafe(C)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 393
    const/16 v2, 0x5c

    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 395
    :cond_2
    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 390
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 397
    .end local v0    # "ch":C
    :cond_3
    if-eqz p3, :cond_4

    .line 398
    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 400
    :cond_4
    return-void
.end method

.method protected estimateNameValuePairLen(Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)I
    .locals 3
    .param p1, "nvp"    # Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .prologue
    .line 354
    if-nez p1, :cond_1

    .line 355
    const/4 v0, 0x0

    .line 363
    :cond_0
    :goto_0
    return v0

    .line 357
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    .line 358
    .local v0, "result":I
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 359
    .local v1, "value":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 361
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, 0x3

    add-int/2addr v0, v2

    goto :goto_0
.end method

.method public formatNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;Z)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "nvp"    # Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .param p3, "quote"    # Z

    .prologue
    .line 323
    if-nez p2, :cond_0

    .line 324
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "NameValuePair must not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 328
    :cond_0
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;->estimateNameValuePairLen(Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)I

    move-result v0

    .line 329
    .local v0, "len":I
    if-nez p1, :cond_2

    .line 330
    new-instance p1, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .end local p1    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-direct {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 335
    .restart local p1    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :goto_0
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 336
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 337
    .local v1, "value":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 338
    const/16 v2, 0x3d

    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 339
    invoke-virtual {p0, p1, v1, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueFormatter;->doFormatValue(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Ljava/lang/String;Z)V

    .line 342
    :cond_1
    return-object p1

    .line 332
    .end local v1    # "value":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->ensureCapacity(I)V

    goto :goto_0
.end method

.method protected isSeparator(C)Z
    .locals 1
    .param p1, "ch"    # C

    .prologue
    .line 412
    const-string v0, " ;,:@()<>\\\"/[]?={}\t"

    invoke-virtual {v0, p1}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected isUnsafe(C)Z
    .locals 1
    .param p1, "ch"    # C

    .prologue
    .line 425
    const-string v0, "\"\\"

    invoke-virtual {v0, p1}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
