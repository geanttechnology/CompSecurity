.class final Landroid/support/v4/view/DraftViewPager$SavedState$1;
.super Ljava/lang/Object;
.source "DraftViewPager.java"

# interfaces
.implements Landroid/support/v4/os/ParcelableCompatCreatorCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/view/DraftViewPager$SavedState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/support/v4/os/ParcelableCompatCreatorCallbacks",
        "<",
        "Landroid/support/v4/view/DraftViewPager$SavedState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 860
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroid/support/v4/view/DraftViewPager$SavedState;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 863
    new-instance v0, Landroid/support/v4/view/DraftViewPager$SavedState;

    invoke-direct {v0, p1, p2}, Landroid/support/v4/view/DraftViewPager$SavedState;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Ljava/lang/ClassLoader;

    .prologue
    .line 860
    invoke-virtual {p0, p1, p2}, Landroid/support/v4/view/DraftViewPager$SavedState$1;->createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroid/support/v4/view/DraftViewPager$SavedState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/support/v4/view/DraftViewPager$SavedState;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 868
    new-array v0, p1, [Landroid/support/v4/view/DraftViewPager$SavedState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 860
    invoke-virtual {p0, p1}, Landroid/support/v4/view/DraftViewPager$SavedState$1;->newArray(I)[Landroid/support/v4/view/DraftViewPager$SavedState;

    move-result-object v0

    return-object v0
.end method
