.class final Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata$1;
.super Ljava/lang/Object;
.source "ExpandableHListConnector.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 931
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 934
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    invoke-static {v1, v2, v3, v4, v5}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->obtain(IIIJ)Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    move-result-object v0

    .line 935
    .local v0, "gm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 931
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata$1;->createFromParcel(Landroid/os/Parcel;)Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 939
    new-array v0, p1, [Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 931
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata$1;->newArray(I)[Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    move-result-object v0

    return-object v0
.end method
