.class public final enum Lcom/a9/cameralibrary/CameraOpenMode;
.super Ljava/lang/Enum;
.source "CameraOpenMode.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/cameralibrary/CameraOpenMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/cameralibrary/CameraOpenMode;

.field public static final enum FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

.field public static final enum FIRST_FRONT_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

.field public static final enum UNKOWN:Lcom/a9/cameralibrary/CameraOpenMode;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/a9/cameralibrary/CameraOpenMode;

    const-string/jumbo v1, "FIRST_FRONT_FACING"

    invoke-direct {v0, v1, v2}, Lcom/a9/cameralibrary/CameraOpenMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_FRONT_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 5
    new-instance v0, Lcom/a9/cameralibrary/CameraOpenMode;

    const-string/jumbo v1, "FIRST_BACK_FACING"

    invoke-direct {v0, v1, v3}, Lcom/a9/cameralibrary/CameraOpenMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 6
    new-instance v0, Lcom/a9/cameralibrary/CameraOpenMode;

    const-string/jumbo v1, "UNKOWN"

    invoke-direct {v0, v1, v4}, Lcom/a9/cameralibrary/CameraOpenMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->UNKOWN:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 3
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/a9/cameralibrary/CameraOpenMode;

    sget-object v1, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_FRONT_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/cameralibrary/CameraOpenMode;->UNKOWN:Lcom/a9/cameralibrary/CameraOpenMode;

    aput-object v1, v0, v4

    sput-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->$VALUES:[Lcom/a9/cameralibrary/CameraOpenMode;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a9/cameralibrary/CameraOpenMode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/a9/cameralibrary/CameraOpenMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/cameralibrary/CameraOpenMode;

    return-object v0
.end method

.method public static values()[Lcom/a9/cameralibrary/CameraOpenMode;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->$VALUES:[Lcom/a9/cameralibrary/CameraOpenMode;

    invoke-virtual {v0}, [Lcom/a9/cameralibrary/CameraOpenMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/cameralibrary/CameraOpenMode;

    return-object v0
.end method
