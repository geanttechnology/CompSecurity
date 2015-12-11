.class public final enum Lcom/damnhandy/uri/template/impl/Modifier;
.super Ljava/lang/Enum;
.source "Modifier.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/damnhandy/uri/template/impl/Modifier;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/damnhandy/uri/template/impl/Modifier;

.field public static final enum DEFAULT_VALUE:Lcom/damnhandy/uri/template/impl/Modifier;

.field public static final enum EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

.field public static final enum NONE:Lcom/damnhandy/uri/template/impl/Modifier;

.field public static final enum PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 15
    new-instance v0, Lcom/damnhandy/uri/template/impl/Modifier;

    const-string v1, "NONE"

    const-string v2, "na"

    invoke-direct {v0, v1, v3, v2}, Lcom/damnhandy/uri/template/impl/Modifier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->NONE:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 16
    new-instance v0, Lcom/damnhandy/uri/template/impl/Modifier;

    const-string v1, "PREFIX"

    const-string v2, ":"

    invoke-direct {v0, v1, v4, v2}, Lcom/damnhandy/uri/template/impl/Modifier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 17
    new-instance v0, Lcom/damnhandy/uri/template/impl/Modifier;

    const-string v1, "EXPLODE"

    const-string v2, "*"

    invoke-direct {v0, v1, v5, v2}, Lcom/damnhandy/uri/template/impl/Modifier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 18
    new-instance v0, Lcom/damnhandy/uri/template/impl/Modifier;

    const-string v1, "DEFAULT_VALUE"

    const-string v2, "="

    invoke-direct {v0, v1, v6, v2}, Lcom/damnhandy/uri/template/impl/Modifier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->DEFAULT_VALUE:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 13
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/damnhandy/uri/template/impl/Modifier;

    sget-object v1, Lcom/damnhandy/uri/template/impl/Modifier;->NONE:Lcom/damnhandy/uri/template/impl/Modifier;

    aput-object v1, v0, v3

    sget-object v1, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    aput-object v1, v0, v4

    sget-object v1, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    aput-object v1, v0, v5

    sget-object v1, Lcom/damnhandy/uri/template/impl/Modifier;->DEFAULT_VALUE:Lcom/damnhandy/uri/template/impl/Modifier;

    aput-object v1, v0, v6

    sput-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->$VALUES:[Lcom/damnhandy/uri/template/impl/Modifier;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 33
    iput-object p3, p0, Lcom/damnhandy/uri/template/impl/Modifier;->value:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/damnhandy/uri/template/impl/Modifier;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/damnhandy/uri/template/impl/Modifier;

    return-object v0
.end method

.method public static values()[Lcom/damnhandy/uri/template/impl/Modifier;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->$VALUES:[Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v0}, [Lcom/damnhandy/uri/template/impl/Modifier;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/damnhandy/uri/template/impl/Modifier;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/Modifier;->value:Ljava/lang/String;

    return-object v0
.end method
