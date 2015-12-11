.class public final enum Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;
.super Ljava/lang/Enum;
.source "DeferredDeepLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/DeferredDeepLinkManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DL_STATE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field public static final enum DL_CONSUMED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field public static final enum DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field public static final enum DL_RECEIVED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field public static final enum DL_REQUESTED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field public static final enum INIT:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 25
    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const-string v1, "INIT"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const-string v1, "DL_REQUESTED"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_REQUESTED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const-string v1, "DL_RECEIVED"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const-string v1, "DL_CONSUMED"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_CONSUMED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const-string v1, "DL_EXPIRED"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_REQUESTED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_CONSUMED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    aput-object v1, v0, v6

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->$VALUES:[Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->$VALUES:[Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    return-object v0
.end method
