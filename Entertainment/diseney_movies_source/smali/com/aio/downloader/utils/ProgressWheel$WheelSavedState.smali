.class Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;
.super Landroid/view/View$BaseSavedState;
.source "ProgressWheel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/utils/ProgressWheel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "WheelSavedState"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field barColor:I

.field barWidth:I

.field circleRadius:I

.field fillRadius:Z

.field isSpinning:Z

.field linearProgress:Z

.field mProgress:F

.field mTargetProgress:F

.field rimColor:I

.field rimWidth:I

.field spinSpeed:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 657
    new-instance v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState$1;

    invoke-direct {v0}, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState$1;-><init>()V

    .line 656
    sput-object v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 664
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 625
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V

    .line 626
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mProgress:F

    .line 627
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mTargetProgress:F

    .line 628
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->isSpinning:Z

    .line 629
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->spinSpeed:F

    .line 630
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barWidth:I

    .line 631
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barColor:I

    .line 632
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimWidth:I

    .line 633
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimColor:I

    .line 634
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->circleRadius:I

    .line 635
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->linearProgress:Z

    .line 636
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_2

    :goto_2
    iput-boolean v1, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->fillRadius:Z

    .line 637
    return-void

    :cond_0
    move v0, v2

    .line 628
    goto :goto_0

    :cond_1
    move v0, v2

    .line 635
    goto :goto_1

    :cond_2
    move v1, v2

    .line 636
    goto :goto_2
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;)V
    .locals 0

    .prologue
    .line 624
    invoke-direct {p0, p1}, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Landroid/os/Parcelable;)V
    .locals 0
    .param p1, "superState"    # Landroid/os/Parcelable;

    .prologue
    .line 621
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V

    .line 622
    return-void
.end method


# virtual methods
.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 3
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 641
    invoke-super {p0, p1, p2}, Landroid/view/View$BaseSavedState;->writeToParcel(Landroid/os/Parcel;I)V

    .line 642
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mProgress:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 643
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mTargetProgress:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 644
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->isSpinning:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 645
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->spinSpeed:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 646
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barWidth:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 647
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barColor:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 648
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimWidth:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 649
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimColor:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 650
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->circleRadius:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 651
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->linearProgress:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 652
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->fillRadius:Z

    if-eqz v0, :cond_2

    :goto_2
    int-to-byte v0, v1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 653
    return-void

    :cond_0
    move v0, v2

    .line 644
    goto :goto_0

    :cond_1
    move v0, v2

    .line 651
    goto :goto_1

    :cond_2
    move v1, v2

    .line 652
    goto :goto_2
.end method
