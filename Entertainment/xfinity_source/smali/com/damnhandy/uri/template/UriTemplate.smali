.class public abstract Lcom/damnhandy/uri/template/UriTemplate;
.super Ljava/lang/Object;
.source "UriTemplate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/damnhandy/uri/template/UriTemplate$Encoding;
    }
.end annotation


# static fields
.field static final OPERATORS:[C

.field private static final OPERATOR_BITSET:Ljava/util/BitSet;


# instance fields
.field protected defaultDateFormat:Ljava/text/DateFormat;

.field private templateBuffer:Ljava/lang/StringBuilder;

.field protected values:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 66
    const/4 v1, 0x7

    new-array v1, v1, [C

    fill-array-data v1, :array_0

    sput-object v1, Lcom/damnhandy/uri/template/UriTemplate;->OPERATORS:[C

    .line 71
    new-instance v1, Ljava/util/BitSet;

    invoke-direct {v1}, Ljava/util/BitSet;-><init>()V

    sput-object v1, Lcom/damnhandy/uri/template/UriTemplate;->OPERATOR_BITSET:Ljava/util/BitSet;

    .line 75
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Lcom/damnhandy/uri/template/UriTemplate;->OPERATORS:[C

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 77
    sget-object v1, Lcom/damnhandy/uri/template/UriTemplate;->OPERATOR_BITSET:Ljava/util/BitSet;

    sget-object v2, Lcom/damnhandy/uri/template/UriTemplate;->OPERATORS:[C

    aget-char v2, v2, v0

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 75
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 79
    :cond_0
    return-void

    .line 66
    :array_0
    .array-data 2
        0x2bs
        0x23s
        0x2es
        0x2fs
        0x3bs
        0x3fs
        0x26s
    .end array-data
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/damnhandy/uri/template/UriTemplate;->defaultDateFormat:Ljava/text/DateFormat;

    .line 90
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/damnhandy/uri/template/UriTemplate;->values:Ljava/util/Map;

    return-void
.end method

.method public static containsOperator(Ljava/lang/String;)Z
    .locals 3
    .param p0, "op"    # Ljava/lang/String;

    .prologue
    .line 368
    sget-object v0, Lcom/damnhandy/uri/template/UriTemplate;->OPERATOR_BITSET:Ljava/util/BitSet;

    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    const/4 v2, 0x0

    aget-char v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    return v0
.end method

.method public static final fromTemplate(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate;
    .locals 1
    .param p0, "template"    # Ljava/lang/String;

    .prologue
    .line 116
    new-instance v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;

    invoke-direct {v0, p0}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public abstract expand()Ljava/lang/String;
.end method

.method public abstract expand(Ljava/util/Map;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation
.end method

.method public getTemplate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/damnhandy/uri/template/UriTemplate;->templateBuffer:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/damnhandy/uri/template/UriTemplate;
    .locals 1
    .param p1, "variableName"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 305
    iget-object v0, p0, Lcom/damnhandy/uri/template/UriTemplate;->values:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 306
    return-object p0
.end method

.method protected setTemplate(Ljava/lang/String;)V
    .locals 1
    .param p1, "template"    # Ljava/lang/String;

    .prologue
    .line 259
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/damnhandy/uri/template/UriTemplate;->templateBuffer:Ljava/lang/StringBuilder;

    .line 260
    return-void
.end method
