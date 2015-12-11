.class public final enum Lcom/damnhandy/uri/template/impl/Operator;
.super Ljava/lang/Enum;
.source "Operator.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/damnhandy/uri/template/impl/Operator;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum CONTINUATION:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum FRAGMENT:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum MATRIX:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum NAME_LABEL:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum NUL:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum PATH:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum QUERY:Lcom/damnhandy/uri/template/impl/Operator;

.field public static final enum RESERVED:Lcom/damnhandy/uri/template/impl/Operator;


# instance fields
.field private empty:Ljava/lang/String;

.field private encoding:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

.field private named:Z

.field private operator:Ljava/lang/String;

.field private separator:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .prologue
    const/4 v14, 0x4

    const/4 v13, 0x3

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v2, 0x0

    .line 35
    new-instance v0, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v1, "NUL"

    const-string v3, ""

    const-string v4, ","

    const-string v6, ""

    sget-object v7, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v5, v2

    invoke-direct/range {v0 .. v7}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v0, Lcom/damnhandy/uri/template/impl/Operator;->NUL:Lcom/damnhandy/uri/template/impl/Operator;

    .line 36
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "RESERVED"

    const-string v6, "+"

    const-string v7, ","

    const-string v9, ""

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UR:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v5, v11

    move v8, v2

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->RESERVED:Lcom/damnhandy/uri/template/impl/Operator;

    .line 37
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "NAME_LABEL"

    const-string v6, "."

    const-string v7, "."

    const-string v9, ""

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v5, v12

    move v8, v2

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->NAME_LABEL:Lcom/damnhandy/uri/template/impl/Operator;

    .line 38
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "PATH"

    const-string v6, "/"

    const-string v7, "/"

    const-string v9, ""

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v5, v13

    move v8, v2

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->PATH:Lcom/damnhandy/uri/template/impl/Operator;

    .line 39
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "MATRIX"

    const-string v6, ";"

    const-string v7, ";"

    const-string v9, ""

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v5, v14

    move v8, v11

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->MATRIX:Lcom/damnhandy/uri/template/impl/Operator;

    .line 40
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "QUERY"

    const/4 v5, 0x5

    const-string v6, "?"

    const-string v7, "&"

    const-string v9, "="

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v8, v11

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->QUERY:Lcom/damnhandy/uri/template/impl/Operator;

    .line 41
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "CONTINUATION"

    const/4 v5, 0x6

    const-string v6, "&"

    const-string v7, "&"

    const-string v9, "="

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v8, v11

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->CONTINUATION:Lcom/damnhandy/uri/template/impl/Operator;

    .line 42
    new-instance v3, Lcom/damnhandy/uri/template/impl/Operator;

    const-string v4, "FRAGMENT"

    const/4 v5, 0x7

    const-string v6, "#"

    const-string v7, ","

    const-string v9, ""

    sget-object v10, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UF:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move v8, v2

    invoke-direct/range {v3 .. v10}, Lcom/damnhandy/uri/template/impl/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V

    sput-object v3, Lcom/damnhandy/uri/template/impl/Operator;->FRAGMENT:Lcom/damnhandy/uri/template/impl/Operator;

    .line 30
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/damnhandy/uri/template/impl/Operator;

    sget-object v1, Lcom/damnhandy/uri/template/impl/Operator;->NUL:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v1, v0, v2

    sget-object v1, Lcom/damnhandy/uri/template/impl/Operator;->RESERVED:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v1, v0, v11

    sget-object v1, Lcom/damnhandy/uri/template/impl/Operator;->NAME_LABEL:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v1, v0, v12

    sget-object v1, Lcom/damnhandy/uri/template/impl/Operator;->PATH:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v1, v0, v13

    sget-object v1, Lcom/damnhandy/uri/template/impl/Operator;->MATRIX:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v1, v0, v14

    const/4 v1, 0x5

    sget-object v2, Lcom/damnhandy/uri/template/impl/Operator;->QUERY:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/damnhandy/uri/template/impl/Operator;->CONTINUATION:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/damnhandy/uri/template/impl/Operator;->FRAGMENT:Lcom/damnhandy/uri/template/impl/Operator;

    aput-object v2, v0, v1

    sput-object v0, Lcom/damnhandy/uri/template/impl/Operator;->$VALUES:[Lcom/damnhandy/uri/template/impl/Operator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/damnhandy/uri/template/UriTemplate$Encoding;)V
    .locals 1
    .param p3, "operator"    # Ljava/lang/String;
    .param p4, "separator"    # Ljava/lang/String;
    .param p5, "named"    # Z
    .param p6, "empty"    # Ljava/lang/String;
    .param p7, "encoding"    # Lcom/damnhandy/uri/template/UriTemplate$Encoding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Ljava/lang/String;",
            "Lcom/damnhandy/uri/template/UriTemplate$Encoding;",
            ")V"
        }
    .end annotation

    .prologue
    .line 77
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 63
    sget-object v0, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->U:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    iput-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->encoding:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    .line 68
    const-string v0, ""

    iput-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->empty:Ljava/lang/String;

    .line 78
    iput-object p3, p0, Lcom/damnhandy/uri/template/impl/Operator;->operator:Ljava/lang/String;

    .line 79
    iput-object p4, p0, Lcom/damnhandy/uri/template/impl/Operator;->separator:Ljava/lang/String;

    .line 80
    iput-boolean p5, p0, Lcom/damnhandy/uri/template/impl/Operator;->named:Z

    .line 81
    iput-object p7, p0, Lcom/damnhandy/uri/template/impl/Operator;->encoding:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    .line 82
    iput-object p6, p0, Lcom/damnhandy/uri/template/impl/Operator;->empty:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public static fromOpCode(Ljava/lang/String;)Lcom/damnhandy/uri/template/impl/Operator;
    .locals 7
    .param p0, "opCode"    # Ljava/lang/String;

    .prologue
    .line 162
    invoke-static {}, Lcom/damnhandy/uri/template/impl/Operator;->values()[Lcom/damnhandy/uri/template/impl/Operator;

    move-result-object v0

    .local v0, "arr$":[Lcom/damnhandy/uri/template/impl/Operator;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_3

    aget-object v3, v0, v1

    .line 164
    .local v3, "op":Lcom/damnhandy/uri/template/impl/Operator;
    invoke-virtual {v3}, Lcom/damnhandy/uri/template/impl/Operator;->getOperator()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 173
    .end local v3    # "op":Lcom/damnhandy/uri/template/impl/Operator;
    :goto_1
    return-object v3

    .line 168
    .restart local v3    # "op":Lcom/damnhandy/uri/template/impl/Operator;
    :cond_0
    const-string v4, "!"

    invoke-virtual {p0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "="

    invoke-virtual {p0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 170
    :cond_1
    new-instance v4, Lcom/damnhandy/uri/template/impl/ExpressionParseException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " is not a valid operator."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/damnhandy/uri/template/impl/ExpressionParseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 162
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 173
    .end local v3    # "op":Lcom/damnhandy/uri/template/impl/Operator;
    :cond_3
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/damnhandy/uri/template/impl/Operator;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 30
    const-class v0, Lcom/damnhandy/uri/template/impl/Operator;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/damnhandy/uri/template/impl/Operator;

    return-object v0
.end method

.method public static values()[Lcom/damnhandy/uri/template/impl/Operator;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/damnhandy/uri/template/impl/Operator;->$VALUES:[Lcom/damnhandy/uri/template/impl/Operator;

    invoke-virtual {v0}, [Lcom/damnhandy/uri/template/impl/Operator;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/damnhandy/uri/template/impl/Operator;

    return-object v0
.end method


# virtual methods
.method public getEncoding()Lcom/damnhandy/uri/template/UriTemplate$Encoding;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->encoding:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    return-object v0
.end method

.method public getListSeparator()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    const-string v0, ","

    return-object v0
.end method

.method public getOperator()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->operator:Ljava/lang/String;

    return-object v0
.end method

.method public getPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->operator:Ljava/lang/String;

    return-object v0
.end method

.method public getSeparator()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->separator:Ljava/lang/String;

    return-object v0
.end method

.method public isNamed()Z
    .locals 1

    .prologue
    .line 110
    iget-boolean v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->named:Z

    return v0
.end method

.method public useVarNameWhenExploded()Z
    .locals 1

    .prologue
    .line 141
    iget-boolean v0, p0, Lcom/damnhandy/uri/template/impl/Operator;->named:Z

    return v0
.end method
