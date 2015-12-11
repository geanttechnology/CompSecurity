.class final enum Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;
.super Ljava/lang/Enum;
.source "CameraPreviewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "STATE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

.field public static final enum INIT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

.field public static final enum PICK_IMAGE_NO_CAMERA_PRESENT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 59
    new-instance v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    const-string v1, "INIT"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->INIT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    new-instance v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    const-string v1, "PICK_IMAGE_NO_CAMERA_PRESENT"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->PICK_IMAGE_NO_CAMERA_PRESENT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    sget-object v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->INIT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->PICK_IMAGE_NO_CAMERA_PRESENT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->$VALUES:[Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

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
    .line 59
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 59
    const-class v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->$VALUES:[Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    return-object v0
.end method
