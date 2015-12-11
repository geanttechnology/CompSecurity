.class public final enum Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
.super Ljava/lang/Enum;
.source "ClosedCaptionsFormat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FontEdge"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum DEPRESSED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum DROP_SHADOW_LEFT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum DROP_SHADOW_RIGHT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum NONE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum RAISED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field public static final enum UNIFORM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 131
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->NONE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "RAISED"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->RAISED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "DEPRESSED"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEPRESSED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "UNIFORM"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->UNIFORM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "DROP_SHADOW_LEFT"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_LEFT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    const-string v1, "DROP_SHADOW_RIGHT"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .line 130
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->NONE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->RAISED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEPRESSED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->UNIFORM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_LEFT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

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
    .line 130
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 130
    const-class v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    return-object v0
.end method

.method public static valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .locals 1
    .param p0, "ordinal"    # I

    .prologue
    .line 134
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v0

    aget-object v0, v0, p0

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .locals 1

    .prologue
    .line 130
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    return-object v0
.end method


# virtual methods
.method textFormatValue()Lcom/adobe/mediacore/TextFormat$FontEdge;
    .locals 1

    .prologue
    .line 138
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/TextFormat$FontEdge;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormat$FontEdge;

    move-result-object v0

    return-object v0
.end method
