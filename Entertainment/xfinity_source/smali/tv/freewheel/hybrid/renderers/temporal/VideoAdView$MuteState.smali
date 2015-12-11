.class final enum Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;
.super Ljava/lang/Enum;
.source "VideoAdView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "MuteState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

.field public static final enum MUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

.field public static final enum UNINITIALIZED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

.field public static final enum UNMUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 56
    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    const-string v1, "UNINITIALIZED"

    invoke-direct {v0, v1, v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNINITIALIZED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    const-string v1, "MUTED"

    invoke-direct {v0, v1, v3}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    const-string v1, "UNMUTED"

    invoke-direct {v0, v1, v4}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    const/4 v0, 0x3

    new-array v0, v0, [Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    sget-object v1, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNINITIALIZED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    aput-object v1, v0, v2

    sget-object v1, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    aput-object v1, v0, v3

    sget-object v1, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    aput-object v1, v0, v4

    sput-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->$VALUES:[Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

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
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 56
    const-class v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    return-object v0
.end method

.method public static values()[Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->$VALUES:[Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    invoke-virtual {v0}, [Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    return-object v0
.end method
