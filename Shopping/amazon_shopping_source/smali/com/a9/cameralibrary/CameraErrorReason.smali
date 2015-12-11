.class public final enum Lcom/a9/cameralibrary/CameraErrorReason;
.super Ljava/lang/Enum;
.source "CameraErrorReason.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/cameralibrary/CameraErrorReason;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/cameralibrary/CameraErrorReason;

.field public static final enum CAMERA_CONNECTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

.field public static final enum CAMERA_EXCEPTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

.field public static final enum CAMERA_OBJECT_NULL:Lcom/a9/cameralibrary/CameraErrorReason;

.field public static final enum NO_PREVIEW_SIZES_MEET_CONSTRAINTS:Lcom/a9/cameralibrary/CameraErrorReason;

.field public static final enum UNKNOWN_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 10
    new-instance v0, Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, "CAMERA_CONNECTION_ERROR"

    invoke-direct {v0, v1, v2}, Lcom/a9/cameralibrary/CameraErrorReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_CONNECTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    .line 11
    new-instance v0, Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, "CAMERA_EXCEPTION_ERROR"

    invoke-direct {v0, v1, v3}, Lcom/a9/cameralibrary/CameraErrorReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_EXCEPTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    .line 12
    new-instance v0, Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, "CAMERA_OBJECT_NULL"

    invoke-direct {v0, v1, v4}, Lcom/a9/cameralibrary/CameraErrorReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_OBJECT_NULL:Lcom/a9/cameralibrary/CameraErrorReason;

    .line 13
    new-instance v0, Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, "NO_PREVIEW_SIZES_MEET_CONSTRAINTS"

    invoke-direct {v0, v1, v5}, Lcom/a9/cameralibrary/CameraErrorReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->NO_PREVIEW_SIZES_MEET_CONSTRAINTS:Lcom/a9/cameralibrary/CameraErrorReason;

    .line 14
    new-instance v0, Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, "UNKNOWN_ERROR"

    invoke-direct {v0, v1, v6}, Lcom/a9/cameralibrary/CameraErrorReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->UNKNOWN_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    .line 9
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/a9/cameralibrary/CameraErrorReason;

    sget-object v1, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_CONNECTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_EXCEPTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_OBJECT_NULL:Lcom/a9/cameralibrary/CameraErrorReason;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/cameralibrary/CameraErrorReason;->NO_PREVIEW_SIZES_MEET_CONSTRAINTS:Lcom/a9/cameralibrary/CameraErrorReason;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/cameralibrary/CameraErrorReason;->UNKNOWN_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    aput-object v1, v0, v6

    sput-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->$VALUES:[Lcom/a9/cameralibrary/CameraErrorReason;

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
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a9/cameralibrary/CameraErrorReason;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/a9/cameralibrary/CameraErrorReason;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/cameralibrary/CameraErrorReason;

    return-object v0
.end method

.method public static values()[Lcom/a9/cameralibrary/CameraErrorReason;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->$VALUES:[Lcom/a9/cameralibrary/CameraErrorReason;

    invoke-virtual {v0}, [Lcom/a9/cameralibrary/CameraErrorReason;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/cameralibrary/CameraErrorReason;

    return-object v0
.end method
