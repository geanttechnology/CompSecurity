.class public Lco/vine/android/api/VineMilestone;
.super Ljava/lang/Object;
.source "VineMilestone.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineMilestone;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public backgroundImageUrl:Ljava/lang/String;

.field public backgroundVideoUrl:Ljava/lang/String;

.field public blurRadius:I

.field public description:Ljava/lang/String;

.field public iconUrl:Ljava/lang/String;

.field public milestoneUrl:Ljava/lang/String;

.field public overlayAlpha:F

.field public overlayColor:I

.field public title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    new-instance v0, Lco/vine/android/api/VineMilestone$1;

    invoke-direct {v0}, Lco/vine/android/api/VineMilestone$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineMilestone;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->backgroundImageUrl:Ljava/lang/String;

    .line 36
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->backgroundVideoUrl:Ljava/lang/String;

    .line 37
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->iconUrl:Ljava/lang/String;

    .line 38
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->title:Ljava/lang/String;

    .line 39
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->description:Ljava/lang/String;

    .line 40
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineMilestone;->milestoneUrl:Ljava/lang/String;

    .line 41
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineMilestone;->overlayColor:I

    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineMilestone;->overlayAlpha:F

    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineMilestone;->blurRadius:I

    .line 44
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFI)V
    .locals 0
    .param p1, "backgroundImageUrl"    # Ljava/lang/String;
    .param p2, "backgroundVideoUrl"    # Ljava/lang/String;
    .param p3, "iconUrl"    # Ljava/lang/String;
    .param p4, "title"    # Ljava/lang/String;
    .param p5, "description"    # Ljava/lang/String;
    .param p6, "milestoneUrl"    # Ljava/lang/String;
    .param p7, "overlayColor"    # I
    .param p8, "overlayAlpha"    # F
    .param p9, "blurRadius"    # I

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lco/vine/android/api/VineMilestone;->backgroundImageUrl:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lco/vine/android/api/VineMilestone;->backgroundVideoUrl:Ljava/lang/String;

    .line 25
    iput-object p3, p0, Lco/vine/android/api/VineMilestone;->iconUrl:Ljava/lang/String;

    .line 26
    iput-object p4, p0, Lco/vine/android/api/VineMilestone;->title:Ljava/lang/String;

    .line 27
    iput-object p5, p0, Lco/vine/android/api/VineMilestone;->description:Ljava/lang/String;

    .line 28
    iput-object p6, p0, Lco/vine/android/api/VineMilestone;->milestoneUrl:Ljava/lang/String;

    .line 29
    iput p7, p0, Lco/vine/android/api/VineMilestone;->overlayColor:I

    .line 30
    iput p8, p0, Lco/vine/android/api/VineMilestone;->overlayAlpha:F

    .line 31
    iput p9, p0, Lco/vine/android/api/VineMilestone;->blurRadius:I

    .line 32
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->backgroundImageUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 49
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->backgroundVideoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 50
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->iconUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 51
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 52
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->description:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 53
    iget-object v0, p0, Lco/vine/android/api/VineMilestone;->milestoneUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 54
    iget v0, p0, Lco/vine/android/api/VineMilestone;->overlayColor:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 55
    iget v0, p0, Lco/vine/android/api/VineMilestone;->overlayAlpha:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 56
    iget v0, p0, Lco/vine/android/api/VineMilestone;->blurRadius:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 57
    return-void
.end method
