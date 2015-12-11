.class Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
.super Ljava/lang/Object;
.source "ExpandableHListConnector.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/ExpandableHListConnector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "GroupMetadata"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Ljava/lang/Comparable",
        "<",
        "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
        ">;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field flPos:I

.field gId:J

.field gPos:I

.field lastChildFlPos:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 931
    new-instance v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata$1;

    invoke-direct {v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata$1;-><init>()V

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 900
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 901
    return-void
.end method

.method static obtain(IIIJ)Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .locals 1
    .param p0, "flPos"    # I
    .param p1, "lastChildFlPos"    # I
    .param p2, "gPos"    # I
    .param p3, "gId"    # J

    .prologue
    .line 904
    new-instance v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    invoke-direct {v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;-><init>()V

    .line 905
    .local v0, "gm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iput p0, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    .line 906
    iput p1, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    .line 907
    iput p2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    .line 908
    iput-wide p3, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gId:J

    .line 909
    return-object v0
.end method


# virtual methods
.method public compareTo(Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;)I
    .locals 2
    .param p1, "another"    # Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .prologue
    .line 913
    if-nez p1, :cond_0

    .line 914
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 917
    :cond_0
    iget v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    iget v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 876
    check-cast p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->compareTo(Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 921
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 925
    iget v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 926
    iget v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 927
    iget v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 928
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 929
    return-void
.end method
