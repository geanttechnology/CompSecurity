.class public Lco/vine/android/recorder/CameraSetting;
.super Ljava/lang/Object;
.source "CameraSetting.java"

# interfaces
.implements Ljava/io/Externalizable;


# static fields
.field private static final serialVersionUID:J = 0x773635a4cd84a345L


# instance fields
.field public backFacingAspectRatio:F

.field public degrees:I

.field public frameRate:I

.field public frontFacing:Z

.field public frontFacingAspectRatio:F

.field public imageFormat:I

.field public originalFrameRate:I

.field public originalH:I

.field public originalW:I

.field public tpf:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(IIIIIZFF)V
    .locals 1
    .param p1, "originalW"    # I
    .param p2, "originalH"    # I
    .param p3, "degrees"    # I
    .param p4, "frameRate"    # I
    .param p5, "imageFormat"    # I
    .param p6, "frontFacing"    # Z
    .param p7, "frontFacingAspectRatio"    # F
    .param p8, "backFacingAspectRatio"    # F

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p1, p0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    .line 33
    iput p2, p0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    .line 34
    iput p3, p0, Lco/vine/android/recorder/CameraSetting;->degrees:I

    .line 35
    iput p4, p0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 36
    iput p4, p0, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    .line 37
    const/16 v0, 0x3e8

    div-int/2addr v0, p4

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->tpf:I

    .line 38
    iput p5, p0, Lco/vine/android/recorder/CameraSetting;->imageFormat:I

    .line 39
    iput-boolean p6, p0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    .line 40
    iput p7, p0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    .line 41
    iput p8, p0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    .line 42
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/CameraSetting;)V
    .locals 1
    .param p1, "setting"    # Lco/vine/android/recorder/CameraSetting;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    .line 46
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    .line 47
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->degrees:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->degrees:I

    .line 48
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 49
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    .line 50
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->tpf:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->tpf:I

    .line 51
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->imageFormat:I

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->imageFormat:I

    .line 52
    iget-boolean v0, p1, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    .line 53
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    .line 54
    iget v0, p1, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    .line 55
    return-void
.end method


# virtual methods
.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 1
    .param p1, "input"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 59
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    .line 60
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    .line 61
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->degrees:I

    .line 62
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 63
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->tpf:I

    .line 64
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->imageFormat:I

    .line 65
    invoke-interface {p1}, Ljava/io/ObjectInput;->readBoolean()Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    .line 66
    invoke-interface {p1}, Ljava/io/ObjectInput;->readFloat()F

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    .line 67
    invoke-interface {p1}, Ljava/io/ObjectInput;->readFloat()F

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    .line 68
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    .line 69
    return-void
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 1
    .param p1, "output"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 74
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 75
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->degrees:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 76
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 77
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->tpf:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 78
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->imageFormat:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 79
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeBoolean(Z)V

    .line 80
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeFloat(F)V

    .line 81
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeFloat(F)V

    .line 82
    iget v0, p0, Lco/vine/android/recorder/CameraSetting;->originalFrameRate:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 83
    return-void
.end method
