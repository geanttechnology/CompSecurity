.class public final enum Lcom/adobe/mediacore/TextFormat$FontEdge;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TextFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FontEdge"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/TextFormat$FontEdge;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum DEPRESSED:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum DROP_SHADOW_LEFT:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum DROP_SHADOW_RIGHT:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum NONE:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum RAISED:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field public static final enum UNIFORM:Lcom/adobe/mediacore/TextFormat$FontEdge;


# instance fields
.field private final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "DEFAULT"

    const-string v2, "default"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "NONE"

    const-string v2, "none"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->NONE:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "RAISED"

    const-string v2, "raised"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->RAISED:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "DEPRESSED"

    const-string v2, "depressed"

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEPRESSED:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "UNIFORM"

    const-string v2, "uniform"

    invoke-direct {v0, v1, v8, v2}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->UNIFORM:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "DROP_SHADOW_LEFT"

    const/4 v2, 0x5

    const-string v3, "drop_shadow_left"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->DROP_SHADOW_LEFT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    const-string v1, "DROP_SHADOW_RIGHT"

    const/4 v2, 0x6

    const-string v3, "drop_shadow_right"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$FontEdge;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    const/4 v0, 0x7

    new-array v0, v0, [Lcom/adobe/mediacore/TextFormat$FontEdge;

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->NONE:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->RAISED:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEPRESSED:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->UNIFORM:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/TextFormat$FontEdge;->DROP_SHADOW_LEFT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/TextFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->$VALUES:[Lcom/adobe/mediacore/TextFormat$FontEdge;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/adobe/mediacore/TextFormat$FontEdge;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$FontEdge;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TextFormat$FontEdge;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/TextFormat$FontEdge;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->$VALUES:[Lcom/adobe/mediacore/TextFormat$FontEdge;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/TextFormat$FontEdge;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/TextFormat$FontEdge;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormat$FontEdge;->_value:Ljava/lang/String;

    return-object v0
.end method
