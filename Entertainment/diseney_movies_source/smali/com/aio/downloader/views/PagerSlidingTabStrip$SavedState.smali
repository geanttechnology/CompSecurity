.class Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;
.super Landroid/view/View$BaseSavedState;
.source "PagerSlidingTabStrip.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/PagerSlidingTabStrip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "SavedState"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field currentPosition:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 680
    new-instance v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState$1;

    invoke-direct {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState$1;-><init>()V

    sput-object v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 690
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 670
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V

    .line 671
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->currentPosition:I

    .line 672
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;)V
    .locals 0

    .prologue
    .line 669
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcelable;)V
    .locals 0
    .param p1, "superState"    # Landroid/os/Parcelable;

    .prologue
    .line 666
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V

    .line 667
    return-void
.end method


# virtual methods
.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 676
    invoke-super {p0, p1, p2}, Landroid/view/View$BaseSavedState;->writeToParcel(Landroid/os/Parcel;I)V

    .line 677
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->currentPosition:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 678
    return-void
.end method
