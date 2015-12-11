.class public final enum Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;
.super Ljava/lang/Enum;
.source "VideoPlaybackStarter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/VideoPlaybackStarter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PlaybackProfile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

.field public static final enum FULL:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

.field public static final enum LIMITED:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;


# instance fields
.field private final mParameterValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 27
    new-instance v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    const-string/jumbo v1, "FULL"

    const-string/jumbo v2, "full"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->FULL:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    .line 31
    new-instance v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    const-string/jumbo v1, "LIMITED"

    const-string/jumbo v2, "limited"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->LIMITED:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    .line 23
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    sget-object v1, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->FULL:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->LIMITED:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->$VALUES:[Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "parameterValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 36
    iput-object p3, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->mParameterValue:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    const-class v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->$VALUES:[Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    return-object v0
.end method


# virtual methods
.method public getParameterValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->mParameterValue:Ljava/lang/String;

    return-object v0
.end method
