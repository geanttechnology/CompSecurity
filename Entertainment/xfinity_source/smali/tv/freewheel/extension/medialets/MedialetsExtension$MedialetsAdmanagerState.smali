.class final enum Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;
.super Ljava/lang/Enum;
.source "MedialetsExtension.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/extension/medialets/MedialetsExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "MedialetsAdmanagerState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

.field public static final enum RESUME:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

.field public static final enum START:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

.field public static final enum STOP:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 42
    new-instance v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    const-string v1, "START"

    invoke-direct {v0, v1, v2}, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->START:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    new-instance v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    const-string v1, "RESUME"

    invoke-direct {v0, v1, v3}, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->RESUME:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    new-instance v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    const-string v1, "STOP"

    invoke-direct {v0, v1, v4}, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->STOP:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    .line 41
    const/4 v0, 0x3

    new-array v0, v0, [Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    sget-object v1, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->START:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    aput-object v1, v0, v2

    sget-object v1, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->RESUME:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    aput-object v1, v0, v3

    sget-object v1, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->STOP:Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    aput-object v1, v0, v4

    sput-object v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->$VALUES:[Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

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
    .line 41
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 41
    const-class v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    return-object v0
.end method

.method public static values()[Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->$VALUES:[Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-virtual {v0}, [Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ltv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    return-object v0
.end method
