.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
.super Ljava/lang/Enum;
.source "DrmWorkflow.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field public static final enum LOCAL:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field public static final enum NO_DRM:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field public static final enum STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field public static final enum WHITE_LIST:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field public static final enum drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    const-string v1, "STREAMING"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 12
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    const-string v1, "LOCAL"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->LOCAL:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 13
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    const-string v1, "NO_DRM"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->NO_DRM:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 14
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    const-string v1, "drmWorkflow"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    const-string v1, "WHITE_LIST"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->WHITE_LIST:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 10
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->LOCAL:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->NO_DRM:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->WHITE_LIST:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    aput-object v1, v0, v6

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

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

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    return-object v0
.end method
