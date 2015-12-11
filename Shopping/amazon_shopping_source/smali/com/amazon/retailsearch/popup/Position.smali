.class public final enum Lcom/amazon/retailsearch/popup/Position;
.super Ljava/lang/Enum;
.source "Position.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/popup/Position;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/popup/Position;

.field public static final enum BELOW_CENTER:Lcom/amazon/retailsearch/popup/Position;

.field public static final enum BELOW_LEFT:Lcom/amazon/retailsearch/popup/Position;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/amazon/retailsearch/popup/Position;

    const-string/jumbo v1, "BELOW_LEFT"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/popup/Position;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/popup/Position;->BELOW_LEFT:Lcom/amazon/retailsearch/popup/Position;

    .line 16
    new-instance v0, Lcom/amazon/retailsearch/popup/Position;

    const-string/jumbo v1, "BELOW_CENTER"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/popup/Position;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/popup/Position;->BELOW_CENTER:Lcom/amazon/retailsearch/popup/Position;

    .line 13
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/retailsearch/popup/Position;

    sget-object v1, Lcom/amazon/retailsearch/popup/Position;->BELOW_LEFT:Lcom/amazon/retailsearch/popup/Position;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/popup/Position;->BELOW_CENTER:Lcom/amazon/retailsearch/popup/Position;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/retailsearch/popup/Position;->$VALUES:[Lcom/amazon/retailsearch/popup/Position;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/popup/Position;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/retailsearch/popup/Position;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/popup/Position;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/popup/Position;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/retailsearch/popup/Position;->$VALUES:[Lcom/amazon/retailsearch/popup/Position;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/popup/Position;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/popup/Position;

    return-object v0
.end method
