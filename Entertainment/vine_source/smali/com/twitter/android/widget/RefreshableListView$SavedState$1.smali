.class final Lcom/twitter/android/widget/RefreshableListView$SavedState$1;
.super Ljava/lang/Object;
.source "RefreshableListView.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/twitter/android/widget/RefreshableListView$SavedState;
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
        "Lcom/twitter/android/widget/RefreshableListView$SavedState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1259
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/twitter/android/widget/RefreshableListView$SavedState;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 1261
    new-instance v0, Lcom/twitter/android/widget/RefreshableListView$SavedState;

    invoke-direct {v0, p1}, Lcom/twitter/android/widget/RefreshableListView$SavedState;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 1259
    invoke-virtual {p0, p1}, Lcom/twitter/android/widget/RefreshableListView$SavedState$1;->createFromParcel(Landroid/os/Parcel;)Lcom/twitter/android/widget/RefreshableListView$SavedState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/twitter/android/widget/RefreshableListView$SavedState;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 1265
    new-array v0, p1, [Lcom/twitter/android/widget/RefreshableListView$SavedState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 1259
    invoke-virtual {p0, p1}, Lcom/twitter/android/widget/RefreshableListView$SavedState$1;->newArray(I)[Lcom/twitter/android/widget/RefreshableListView$SavedState;

    move-result-object v0

    return-object v0
.end method
