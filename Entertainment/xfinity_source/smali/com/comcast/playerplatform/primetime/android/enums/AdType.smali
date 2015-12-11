.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/AdType;
.super Ljava/lang/Enum;
.source "AdType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/AdType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field public static final enum AUDITUDE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field public static final enum C3:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field public static final enum FREEWHEEL:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field public static final enum MANIFEST_MANIPULATOR:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field public static final enum NONE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 7
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    const-string v1, "AUDITUDE"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->AUDITUDE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 8
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    const-string v1, "C3"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->C3:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 9
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    const-string v1, "MANIFEST_MANIPULATOR"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->MANIFEST_MANIPULATOR:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 10
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->NONE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 11
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    const-string v1, "FREEWHEEL"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->FREEWHEEL:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 6
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->AUDITUDE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->C3:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->MANIFEST_MANIPULATOR:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->NONE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->FREEWHEEL:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/AdType;

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
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/AdType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    return-object v0
.end method
