.class public Lcom/amazon/dee/result/bif/Span;
.super Ljava/lang/Object;
.source "Span.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mLength:I

.field private mStart:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 46
    invoke-direct {p0, v0, v0}, Lcom/amazon/dee/result/bif/Span;-><init>(II)V

    .line 47
    return-void
.end method

.method public constructor <init>(II)V
    .locals 2
    .param p1, "startIndex"    # I
    .param p2, "length"    # I

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    if-gez p1, :cond_0

    .line 30
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Negative startIndex passes as arg to Span constructor"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 33
    :cond_0
    if-gez p2, :cond_1

    .line 35
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Negative length passed as arg to Span constructor"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_1
    iput p1, p0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    .line 38
    iput p2, p0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    .line 39
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 52
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Span;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 54
    check-cast v0, Lcom/amazon/dee/result/bif/Span;

    .line 55
    .local v0, "other":Lcom/amazon/dee/result/bif/Span;
    iget v2, p0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, v0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, v0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 60
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Span;
    :cond_0
    return v1
.end method

.method public getLength()I
    .locals 1

    .prologue
    .line 98
    iget v0, p0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    return v0
.end method

.method public getStart()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 67
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setLength(I)V
    .locals 0
    .param p1, "length"    # I

    .prologue
    .line 109
    iput p1, p0, Lcom/amazon/dee/result/bif/Span;->mLength:I

    .line 110
    return-void
.end method

.method public setStart(I)V
    .locals 0
    .param p1, "start"    # I

    .prologue
    .line 88
    iput p1, p0, Lcom/amazon/dee/result/bif/Span;->mStart:I

    .line 89
    return-void
.end method
