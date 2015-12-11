.class public Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;
.super Ljava/lang/Object;
.source "VinePrivateMessagePostResponseWithUsers.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final post:Lco/vine/android/api/VinePost;

.field public final recipients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation
.end field

.field public final responses:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePrivateMessageResponse;",
            ">;"
        }
    .end annotation
.end field

.field public final users:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    new-instance v0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers$1;

    invoke-direct {v0}, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->responses:Ljava/util/ArrayList;

    .line 28
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->recipients:Ljava/util/ArrayList;

    .line 29
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->users:Ljava/util/ArrayList;

    .line 30
    const-class v0, Lco/vine/android/api/VinePost;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->post:Lco/vine/android/api/VinePost;

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lco/vine/android/api/VinePost;)V
    .locals 0
    .param p4, "post"    # Lco/vine/android/api/VinePost;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePrivateMessageResponse;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;",
            "Lco/vine/android/api/VinePost;",
            ")V"
        }
    .end annotation

    .prologue
    .line 18
    .local p1, "responses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessageResponse;>;"
    .local p2, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .local p3, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->responses:Ljava/util/ArrayList;

    .line 20
    iput-object p2, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->recipients:Ljava/util/ArrayList;

    .line 21
    iput-object p3, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->users:Ljava/util/ArrayList;

    .line 22
    iput-object p4, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->post:Lco/vine/android/api/VinePost;

    .line 23
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 40
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->responses:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 41
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->recipients:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 42
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->users:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 43
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->post:Lco/vine/android/api/VinePost;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 44
    return-void
.end method
