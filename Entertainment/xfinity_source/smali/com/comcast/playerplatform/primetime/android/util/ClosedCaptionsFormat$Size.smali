.class public final enum Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
.super Ljava/lang/Enum;
.source "ClosedCaptionsFormat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Size"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

.field public static final enum DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

.field public static final enum LARGE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

.field public static final enum MEDIUM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

.field public static final enum SMALL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 143
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    const-string v1, "SMALL"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->SMALL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    const-string v1, "MEDIUM"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->MEDIUM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    const-string v1, "LARGE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->LARGE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .line 142
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->SMALL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->MEDIUM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->LARGE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    aput-object v1, v0, v5

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

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
    .line 142
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 142
    const-class v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    return-object v0
.end method

.method public static valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    .locals 1
    .param p0, "ordinal"    # I

    .prologue
    .line 146
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    .locals 1

    .prologue
    .line 142
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    return-object v0
.end method


# virtual methods
.method textFormatValue()Lcom/adobe/mediacore/TextFormat$Size;
    .locals 1

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/TextFormat$Size;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Size;

    move-result-object v0

    return-object v0
.end method
