.class public final enum Lcom/facebook/orca/d/k;
.super Ljava/lang/Enum;
.source "AudioClipPlayer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/orca/d/k;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/orca/d/k;

.field public static final enum PLAYBACK_COMPLETED:Lcom/facebook/orca/d/k;

.field public static final enum PLAYBACK_ERROR:Lcom/facebook/orca/d/k;

.field public static final enum PLAYBACK_POSITION_UPDATED:Lcom/facebook/orca/d/k;

.field public static final enum PLAYBACK_STARTED:Lcom/facebook/orca/d/k;

.field public static final enum PLAYBACK_STOPPED:Lcom/facebook/orca/d/k;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 41
    new-instance v0, Lcom/facebook/orca/d/k;

    const-string v1, "PLAYBACK_STARTED"

    invoke-direct {v0, v1, v2}, Lcom/facebook/orca/d/k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/d/k;->PLAYBACK_STARTED:Lcom/facebook/orca/d/k;

    .line 42
    new-instance v0, Lcom/facebook/orca/d/k;

    const-string v1, "PLAYBACK_ERROR"

    invoke-direct {v0, v1, v3}, Lcom/facebook/orca/d/k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/d/k;->PLAYBACK_ERROR:Lcom/facebook/orca/d/k;

    .line 43
    new-instance v0, Lcom/facebook/orca/d/k;

    const-string v1, "PLAYBACK_STOPPED"

    invoke-direct {v0, v1, v4}, Lcom/facebook/orca/d/k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/d/k;->PLAYBACK_STOPPED:Lcom/facebook/orca/d/k;

    .line 44
    new-instance v0, Lcom/facebook/orca/d/k;

    const-string v1, "PLAYBACK_COMPLETED"

    invoke-direct {v0, v1, v5}, Lcom/facebook/orca/d/k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/d/k;->PLAYBACK_COMPLETED:Lcom/facebook/orca/d/k;

    .line 45
    new-instance v0, Lcom/facebook/orca/d/k;

    const-string v1, "PLAYBACK_POSITION_UPDATED"

    invoke-direct {v0, v1, v6}, Lcom/facebook/orca/d/k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/d/k;->PLAYBACK_POSITION_UPDATED:Lcom/facebook/orca/d/k;

    .line 40
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/facebook/orca/d/k;

    sget-object v1, Lcom/facebook/orca/d/k;->PLAYBACK_STARTED:Lcom/facebook/orca/d/k;

    aput-object v1, v0, v2

    sget-object v1, Lcom/facebook/orca/d/k;->PLAYBACK_ERROR:Lcom/facebook/orca/d/k;

    aput-object v1, v0, v3

    sget-object v1, Lcom/facebook/orca/d/k;->PLAYBACK_STOPPED:Lcom/facebook/orca/d/k;

    aput-object v1, v0, v4

    sget-object v1, Lcom/facebook/orca/d/k;->PLAYBACK_COMPLETED:Lcom/facebook/orca/d/k;

    aput-object v1, v0, v5

    sget-object v1, Lcom/facebook/orca/d/k;->PLAYBACK_POSITION_UPDATED:Lcom/facebook/orca/d/k;

    aput-object v1, v0, v6

    sput-object v0, Lcom/facebook/orca/d/k;->$VALUES:[Lcom/facebook/orca/d/k;

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
    .line 40
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/orca/d/k;
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/facebook/orca/d/k;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/orca/d/k;

    return-object v0
.end method

.method public static values()[Lcom/facebook/orca/d/k;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/facebook/orca/d/k;->$VALUES:[Lcom/facebook/orca/d/k;

    invoke-virtual {v0}, [Lcom/facebook/orca/d/k;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/orca/d/k;

    return-object v0
.end method
