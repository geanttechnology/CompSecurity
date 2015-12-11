.class public Lco/vine/android/api/VineLoopSubmissionResponse;
.super Ljava/lang/Object;
.source "VineLoopSubmissionResponse.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineActivityCounts;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public submissionInterval:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Lco/vine/android/api/VineLoopSubmissionResponse$1;

    invoke-direct {v0}, Lco/vine/android/api/VineLoopSubmissionResponse$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineLoopSubmissionResponse;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "submissionInterval"    # I

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p1, p0, Lco/vine/android/api/VineLoopSubmissionResponse;->submissionInterval:I

    .line 14
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineLoopSubmissionResponse;->submissionInterval:I

    .line 18
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 22
    iget v0, p0, Lco/vine/android/api/VineLoopSubmissionResponse;->submissionInterval:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 23
    return-void
.end method
