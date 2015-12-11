.class public final enum Lcom/adobe/mediacore/TextFormat$Color;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TextFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Color"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/TextFormat$Color;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BLACK:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BLUE:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_RED:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_WHITE:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum BRIGHT_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum CYAN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_RED:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DARK_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum GRAY:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum GREEN:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum RED:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum WHITE:Lcom/adobe/mediacore/TextFormat$Color;

.field public static final enum YELLOW:Lcom/adobe/mediacore/TextFormat$Color;


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

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DEFAULT"

    const-string v2, "default"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BLACK"

    const-string v2, "black"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BLACK:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "GRAY"

    const-string v2, "gray"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->GRAY:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "WHITE"

    const-string v2, "white"

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->WHITE:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_WHITE"

    const-string v2, "bright_white"

    invoke-direct {v0, v1, v8, v2}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_WHITE:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_RED"

    const/4 v2, 0x5

    const-string v3, "dark_red"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_RED:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "RED"

    const/4 v2, 0x6

    const-string v3, "red"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->RED:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_RED"

    const/4 v2, 0x7

    const-string v3, "bright_red"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_RED:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_GREEN"

    const/16 v2, 0x8

    const-string v3, "dark_green"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "GREEN"

    const/16 v2, 0x9

    const-string v3, "green"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_GREEN"

    const/16 v2, 0xa

    const-string v3, "bright_green"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_BLUE"

    const/16 v2, 0xb

    const-string v3, "dark_blue"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BLUE"

    const/16 v2, 0xc

    const-string v3, "blue"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_BLUE"

    const/16 v2, 0xd

    const-string v3, "bright_blue"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_YELLOW"

    const/16 v2, 0xe

    const-string v3, "dark_yellow"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "YELLOW"

    const/16 v2, 0xf

    const-string v3, "yellow"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_YELLOW"

    const/16 v2, 0x10

    const-string v3, "bright_yellow"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_MAGENTA"

    const/16 v2, 0x11

    const-string v3, "dark_magenta"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "MAGENTA"

    const/16 v2, 0x12

    const-string v3, "magenta"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_MAGENTA"

    const/16 v2, 0x13

    const-string v3, "bright_magenta"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "DARK_CYAN"

    const/16 v2, 0x14

    const-string v3, "dark_cyan"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DARK_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "CYAN"

    const/16 v2, 0x15

    const-string v3, "cyan"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Color;

    const-string v1, "BRIGHT_CYAN"

    const/16 v2, 0x16

    const-string v3, "bright_cyan"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Color;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    const/16 v0, 0x17

    new-array v0, v0, [Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->BLACK:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->GRAY:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->WHITE:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_WHITE:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_RED:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->RED:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_RED:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_GREEN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_BLUE:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_YELLOW:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_MAGENTA:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DARK_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->BRIGHT_CYAN:Lcom/adobe/mediacore/TextFormat$Color;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Color;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Color;

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

    iput-object p3, p0, Lcom/adobe/mediacore/TextFormat$Color;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/TextFormat$Color;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Color;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Color;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/TextFormat$Color;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormat$Color;->_value:Ljava/lang/String;

    return-object v0
.end method
