.class public final enum Lcom/amazon/mShop/util/UIUtils$CharacterColor;
.super Ljava/lang/Enum;
.source "UIUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/util/UIUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CharacterColor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/util/UIUtils$CharacterColor;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/util/UIUtils$CharacterColor;

.field public static final enum BLACK:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

.field public static final enum DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

.field public static final enum RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 104
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    const-string/jumbo v1, "RED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/util/UIUtils$CharacterColor;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    .line 105
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    const-string/jumbo v1, "DARK_GRAY"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/util/UIUtils$CharacterColor;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    .line 106
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    const-string/jumbo v1, "BLACK"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/util/UIUtils$CharacterColor;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->BLACK:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    .line 103
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->BLACK:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->$VALUES:[Lcom/amazon/mShop/util/UIUtils$CharacterColor;

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
    .line 103
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/util/UIUtils$CharacterColor;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 103
    const-class v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/util/UIUtils$CharacterColor;
    .locals 1

    .prologue
    .line 103
    sget-object v0, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->$VALUES:[Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-virtual {v0}, [Lcom/amazon/mShop/util/UIUtils$CharacterColor;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    return-object v0
.end method
