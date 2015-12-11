.class public final enum Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
.super Ljava/lang/Enum;
.source "ClosedCaptionsFormat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Color"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BLACK:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum BRIGHT_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DARK_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum GRAY:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field public static final enum YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 107
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BLACK"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BLACK:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "GRAY"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->GRAY:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "WHITE"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_WHITE"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_RED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "RED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_RED"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_GREEN"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "GREEN"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_GREEN"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_BLUE"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BLUE"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_BLUE"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_YELLOW"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "YELLOW"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_YELLOW"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_MAGENTA"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "MAGENTA"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_MAGENTA"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "DARK_CYAN"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "CYAN"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    const-string v1, "BRIGHT_CYAN"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 106
    const/16 v0, 0x17

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BLACK:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->GRAY:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_RED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_GREEN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_BLUE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_YELLOW:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_MAGENTA:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DARK_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BRIGHT_CYAN:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 106
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 106
    const-class v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method

.method public static valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1
    .param p0, "ordinal"    # I

    .prologue
    .line 110
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1

    .prologue
    .line 106
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method


# virtual methods
.method textFormatValue()Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/TextFormat$Color;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v0

    return-object v0
.end method
