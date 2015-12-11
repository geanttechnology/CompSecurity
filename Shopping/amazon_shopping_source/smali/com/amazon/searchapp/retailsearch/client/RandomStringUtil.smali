.class public Lcom/amazon/searchapp/retailsearch/client/RandomStringUtil;
.super Ljava/lang/Object;
.source "RandomStringUtil.java"


# static fields
.field private static final RANDOM:Ljava/util/Random;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/RandomStringUtil;->RANDOM:Ljava/util/Random;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static generate(I)Ljava/lang/String;
    .locals 2
    .param p0, "len"    # I

    .prologue
    .line 19
    const-string/jumbo v0, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/RandomStringUtil;->RANDOM:Ljava/util/Random;

    invoke-static {p0, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/RandomStringUtil;->generate(ILjava/lang/String;Ljava/util/Random;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static generate(ILjava/lang/String;Ljava/util/Random;)Ljava/lang/String;
    .locals 3
    .param p0, "len"    # I
    .param p1, "chars"    # Ljava/lang/String;
    .param p2, "rng"    # Ljava/util/Random;

    .prologue
    .line 31
    new-array v1, p0, [C

    .line 33
    .local v1, "text":[C
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p0, :cond_0

    .line 34
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p2, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    aput-char v2, v1, v0

    .line 33
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 37
    :cond_0
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([C)V

    return-object v2
.end method
