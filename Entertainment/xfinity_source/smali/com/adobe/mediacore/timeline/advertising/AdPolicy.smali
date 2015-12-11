.class public final enum Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/AdPolicy;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

.field public static final enum PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

.field public static final enum PLAY_FROM_AD_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

.field public static final enum PLAY_FROM_AD_BREAK_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

.field public static final enum SKIP_AD_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

.field public static final enum SKIP_TO_NEXT_AD_IN_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;


# instance fields
.field private _action:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const-string v1, "PLAY"

    const-string v2, "play"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const-string v1, "PLAY_FROM_AD_BEGIN"

    const-string v2, "play_from_ad_begin"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const-string v1, "PLAY_FROM_AD_BREAK_BEGIN"

    const-string v2, "play_from_ad_break_begin"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BREAK_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const-string v1, "SKIP_TO_NEXT_AD_IN_BREAK"

    const-string v2, "skip_to_next_ad_in_break"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->SKIP_TO_NEXT_AD_IN_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const-string v1, "SKIP_AD_BREAK"

    const-string v2, "skip_ad_break"

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->SKIP_AD_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BREAK_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->SKIP_TO_NEXT_AD_IN_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->SKIP_AD_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    aput-object v1, v0, v7

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

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

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->_action:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    return-object v0
.end method


# virtual methods
.method public getAction()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->_action:Ljava/lang/String;

    return-object v0
.end method
