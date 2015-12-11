.class public final enum Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
.super Ljava/lang/Enum;
.source "ClosedCaptionsFormat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Font"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum CASUAL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum CURSIVE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum MONOSPACED_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum MONSPACED_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum PROPORTIONAL_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum PROPORTIONAL_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field public static final enum SMALL_CAPITALS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 119
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "MONOSPACED_WITH_SERIFS"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "PROPORTIONAL_WITH_SERIFS"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "MONSPACED_WITHOUT_SERIFS"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONSPACED_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "PROPORTIONAL_WITHOUT_SERIFS"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "CASUAL"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->CASUAL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "CURSIVE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->CURSIVE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    const-string v1, "SMALL_CAPITALS"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->SMALL_CAPITALS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .line 118
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONSPACED_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->CASUAL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->CURSIVE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->SMALL_CAPITALS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

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
    .line 118
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 118
    const-class v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    return-object v0
.end method

.method public static valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    .locals 1
    .param p0, "ordinal"    # I

    .prologue
    .line 122
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    .locals 1

    .prologue
    .line 118
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    return-object v0
.end method


# virtual methods
.method textFormatValue()Lcom/adobe/mediacore/TextFormat$Font;
    .locals 1

    .prologue
    .line 126
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/TextFormat$Font;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$Font;

    move-result-object v0

    return-object v0
.end method
