.class public final enum Lcom/adobe/mediacore/TextFormat$Size;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TextFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Size"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/TextFormat$Size;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/TextFormat$Size;

.field public static final enum DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

.field public static final enum LARGE:Lcom/adobe/mediacore/TextFormat$Size;

.field public static final enum MEDIUM:Lcom/adobe/mediacore/TextFormat$Size;

.field public static final enum SMALL:Lcom/adobe/mediacore/TextFormat$Size;


# instance fields
.field private final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Size;

    const-string v1, "DEFAULT"

    const-string v2, "default"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/TextFormat$Size;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Size;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Size;

    const-string v1, "SMALL"

    const-string v2, "small"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/TextFormat$Size;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Size;->SMALL:Lcom/adobe/mediacore/TextFormat$Size;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Size;

    const-string v1, "MEDIUM"

    const-string v2, "medium"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/TextFormat$Size;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Size;->MEDIUM:Lcom/adobe/mediacore/TextFormat$Size;

    new-instance v0, Lcom/adobe/mediacore/TextFormat$Size;

    const-string v1, "LARGE"

    const-string v2, "large"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/TextFormat$Size;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Size;->LARGE:Lcom/adobe/mediacore/TextFormat$Size;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/adobe/mediacore/TextFormat$Size;

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Size;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Size;->SMALL:Lcom/adobe/mediacore/TextFormat$Size;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Size;->MEDIUM:Lcom/adobe/mediacore/TextFormat$Size;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Size;->LARGE:Lcom/adobe/mediacore/TextFormat$Size;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/TextFormat$Size;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Size;

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

    iput-object p3, p0, Lcom/adobe/mediacore/TextFormat$Size;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Size;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/TextFormat$Size;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TextFormat$Size;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/TextFormat$Size;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Size;->$VALUES:[Lcom/adobe/mediacore/TextFormat$Size;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/TextFormat$Size;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/TextFormat$Size;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormat$Size;->_value:Ljava/lang/String;

    return-object v0
.end method
