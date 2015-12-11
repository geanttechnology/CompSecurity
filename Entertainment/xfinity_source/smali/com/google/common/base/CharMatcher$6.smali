.class final Lcom/google/common/base/CharMatcher$6;
.super Lcom/google/common/base/CharMatcher;
.source "CharMatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/base/CharMatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 218
    invoke-direct {p0}, Lcom/google/common/base/CharMatcher;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic apply(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 218
    check-cast p1, Ljava/lang/Character;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-super {p0, p1}, Lcom/google/common/base/CharMatcher;->apply(Ljava/lang/Character;)Z

    move-result v0

    return v0
.end method

.method public indexIn(Ljava/lang/CharSequence;I)I
    .locals 1
    .param p1, "sequence"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I

    .prologue
    .line 228
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    .line 229
    .local v0, "length":I
    invoke-static {p2, v0}, Lcom/google/common/base/Preconditions;->checkPositionIndex(II)I

    .line 230
    if-ne p2, v0, :cond_0

    const/4 p2, -0x1

    .end local p2    # "start":I
    :cond_0
    return p2
.end method

.method public matches(C)Z
    .locals 1
    .param p1, "c"    # C

    .prologue
    .line 220
    const/4 v0, 0x1

    return v0
.end method

.method public or(Lcom/google/common/base/CharMatcher;)Lcom/google/common/base/CharMatcher;
    .locals 0
    .param p1, "other"    # Lcom/google/common/base/CharMatcher;

    .prologue
    .line 283
    invoke-static {p1}, Lcom/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    return-object p0
.end method

.method public precomputed()Lcom/google/common/base/CharMatcher;
    .locals 0

    .prologue
    .line 292
    return-object p0
.end method
