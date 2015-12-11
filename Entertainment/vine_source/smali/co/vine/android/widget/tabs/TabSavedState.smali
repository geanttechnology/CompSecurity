.class public Lco/vine/android/widget/tabs/TabSavedState;
.super Ljava/lang/Object;
.source "TabSavedState.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/widget/tabs/TabSavedState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final tags:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lco/vine/android/widget/tabs/TabSavedState$1;

    invoke-direct {v0}, Lco/vine/android/widget/tabs/TabSavedState$1;-><init>()V

    sput-object v0, Lco/vine/android/widget/tabs/TabSavedState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabSavedState;->tags:[Ljava/lang/String;

    .line 26
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/tabs/TabInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p1, "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/tabs/TabInfo;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 16
    .local v2, "size":I
    new-array v3, v2, [Ljava/lang/String;

    .line 17
    .local v3, "tabs":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 18
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabInfo;

    .line 19
    .local v1, "info":Lco/vine/android/widget/tabs/TabInfo;
    iget-object v4, v1, Lco/vine/android/widget/tabs/TabInfo;->mTag:Ljava/lang/String;

    aput-object v4, v3, v0

    .line 17
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 21
    .end local v1    # "info":Lco/vine/android/widget/tabs/TabInfo;
    :cond_0
    iput-object v3, p0, Lco/vine/android/widget/tabs/TabSavedState;->tags:[Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabSavedState;->tags:[Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    .line 36
    return-void
.end method
