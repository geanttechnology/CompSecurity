.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;
.super Ljava/lang/Enum;
.source "VPMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "BasePlayerType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

.field public static final enum NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

.field public static final enum UPLYNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 71
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    const-string v1, "NATIVE"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    const-string v1, "UPLYNK"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->UPLYNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->UPLYNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

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
    .line 71
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    return-object v0
.end method
