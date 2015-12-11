.class public final enum Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

.field public static final enum PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

.field public static final enum REMOVE:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

.field public static final enum REMOVE_AFTER_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

.field public static final enum SKIP:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;


# instance fields
.field private _action:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    const-string v1, "SKIP"

    const-string v2, "skip"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->SKIP:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    const-string v1, "PLAY"

    const-string v2, "play"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    const-string v1, "REMOVE"

    const-string v2, "remove"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    const-string v1, "REMOVE_AFTER_PLAY"

    const-string v2, "remove_after_play"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE_AFTER_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->SKIP:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE_AFTER_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

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

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->_action:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    return-object v0
.end method


# virtual methods
.method public getAction()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->_action:Ljava/lang/String;

    return-object v0
.end method
