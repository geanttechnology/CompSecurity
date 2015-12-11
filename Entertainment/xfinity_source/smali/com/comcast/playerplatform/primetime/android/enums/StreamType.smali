.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
.super Ljava/lang/Enum;
.source "StreamType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/StreamType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

.field public static final enum LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

.field public static final enum VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    const-string v1, "VOD"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 12
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    const-string v1, "LINEAR"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 10
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method
