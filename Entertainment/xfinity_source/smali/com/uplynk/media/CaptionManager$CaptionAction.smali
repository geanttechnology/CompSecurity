.class public final enum Lcom/uplynk/media/CaptionManager$CaptionAction;
.super Ljava/lang/Enum;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CaptionAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/uplynk/media/CaptionManager$CaptionAction;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum BACKSPACE:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum CLEAR_ALL:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum CLEAR_EOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum COLUMN:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field private static final synthetic ENUM$VALUES:[Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum FLUSH:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum INDENT:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum ITALIC:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum START_NEW_ROW:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum UNDERLINED:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public static final enum UNKNOWN:Lcom/uplynk/media/CaptionManager$CaptionAction;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 41
    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v3}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNKNOWN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v4}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "BACKSPACE"

    invoke-direct {v0, v1, v5}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->BACKSPACE:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "CLEAR_ALL"

    invoke-direct {v0, v1, v6}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_ALL:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "CLEAR_EOR"

    invoke-direct {v0, v1, v7}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_EOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "COLOR"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "COLUMN"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLUMN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "ERASE_DISPLAY_MEM"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "FLUSH"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->FLUSH:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "INDENT"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->INDENT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "ITALIC"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ITALIC:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "LINEBREAK"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "UNDERLINED"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNDERLINED:Lcom/uplynk/media/CaptionManager$CaptionAction;

    new-instance v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    const-string v1, "START_NEW_ROW"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$CaptionAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->START_NEW_ROW:Lcom/uplynk/media/CaptionManager$CaptionAction;

    const/16 v0, 0xe

    new-array v0, v0, [Lcom/uplynk/media/CaptionManager$CaptionAction;

    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNKNOWN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v1, v0, v3

    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->TEXT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->BACKSPACE:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v1, v0, v5

    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_ALL:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v1, v0, v6

    sget-object v1, Lcom/uplynk/media/CaptionManager$CaptionAction;->CLEAR_EOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLOR:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->COLUMN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->ERASE_DISPLAY_MEM:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->FLUSH:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->INDENT:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->ITALIC:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->LINEBREAK:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNDERLINED:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/uplynk/media/CaptionManager$CaptionAction;->START_NEW_ROW:Lcom/uplynk/media/CaptionManager$CaptionAction;

    aput-object v2, v0, v1

    sput-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ENUM$VALUES:[Lcom/uplynk/media/CaptionManager$CaptionAction;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/uplynk/media/CaptionManager$CaptionAction;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$CaptionAction;

    return-object v0
.end method

.method public static values()[Lcom/uplynk/media/CaptionManager$CaptionAction;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->ENUM$VALUES:[Lcom/uplynk/media/CaptionManager$CaptionAction;

    array-length v1, v0

    new-array v2, v1, [Lcom/uplynk/media/CaptionManager$CaptionAction;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
