.class public final enum Lcom/poshmark/utils/ShareManager$SHARE_MODE;
.super Ljava/lang/Enum;
.source "ShareManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ShareManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SHARE_MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/ShareManager$SHARE_MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field public static final enum SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 70
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_LISTING"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 71
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_INVITE_FRIENDS"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 72
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_PARTY"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 73
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_CLOSET"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 74
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_SHOWROOM"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 75
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_BRAND"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 76
    new-instance v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    const-string v1, "SHARE_MODE_BRAND_JUSTIN"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 69
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->$VALUES:[Lcom/poshmark/utils/ShareManager$SHARE_MODE;

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
    .line 69
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 69
    const-class v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->$VALUES:[Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/ShareManager$SHARE_MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    return-object v0
.end method
