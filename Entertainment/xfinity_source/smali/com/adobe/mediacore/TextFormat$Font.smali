.class public final enum Lcom/adobe/mediacore/TextFormat$Font;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TextFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Font"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/TextFormat$Font;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum CASUAL:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum CURSIVE:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum MONOSPACED_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum MONOSPACED_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum PROPORTIONAL_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum PROPORTIONAL_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

.field public static final enum SMALL_CAPITALS:Lcom/adobe/mediacore/TextFormat$Font;


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

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "DEFAULT"

    const-string v2, "default"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "MONOSPACED_WITH_SERIFS"

    const-string v2, "monospaced_with_serifs"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "PROPORTIONAL_WITH_SERIFS"

    const-string v2, "proportional_with_serifs"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "MONOSPACED_WITHOUT_SERIFS"

    const-string v2, "monospaced_without_serifs"

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->MONOSPACED_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "PROPORTIONAL_WITHOUT_SERIFS"

    const-string v2, "proportional_without_serifs"

    invoke-direct {v0, v1, v8, v2}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "CASUAL"

    const/4 v2, 0x5

    const-string v3, "casual"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->CASUAL:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "CURSIVE"

    const/4 v2, 0x6

    const-string v3, "cursive"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->CURSIVE:Lcom/adobe/mediacore/TextFormat$Font;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Font;

    const-string v1, "SMALL_CAPITALS"

    const/4 v2, 0x7

    const-string v3, "small_capitals"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/TextFormat$Font;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->SMALL_CAPITALS:Lcom/adobe/mediacore/TextFormat$Font;

    const/16 v0, 0x8

    new-array v0, v0, [Lcom/adobe/mediacore/TextFormat$Font;

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->MONOSPACED_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Font;->CASUAL:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Font;->CURSIVE:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Font;->SMALL_CAPITALS:Lcom/adobe/mediacore/TextFormat$Font;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Font;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Font;

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

    iput-object p3, p0, Lcom/adobe/mediacore/TextFormat$Font;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Font;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/TextFormat$Font;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TextFormat$Font;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/TextFormat$Font;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Font;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Font;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/TextFormat$Font;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/TextFormat$Font;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormat$Font;->_value:Ljava/lang/String;

    return-object v0
.end method
