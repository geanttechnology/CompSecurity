.class public Lco/vine/android/api/VineInbox;
.super Ljava/lang/Object;
.source "VineInbox.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineInbox;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public conversations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;"
        }
    .end annotation
.end field

.field public participants:Ljava/util/ArrayList;
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
    .line 43
    new-instance v0, Lco/vine/android/api/VineInbox$1;

    invoke-direct {v0}, Lco/vine/android/api/VineInbox$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineInbox;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 28
    .local v0, "cl":Ljava/lang/ClassLoader;
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readArrayList(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    .line 29
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readArrayList(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p1, "conversations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineConversation;>;"
    .local p2, "participants":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    .line 23
    iput-object p2, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    .line 24
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 57
    if-ne p0, p1, :cond_1

    .line 67
    :cond_0
    :goto_0
    return v1

    .line 58
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 60
    check-cast v0, Lco/vine/android/api/VineInbox;

    .line 62
    .local v0, "that":Lco/vine/android/api/VineInbox;
    iget-object v3, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    iget-object v4, v0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 63
    goto :goto_0

    .line 62
    :cond_5
    iget-object v3, v0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    if-nez v3, :cond_4

    .line 64
    :cond_6
    iget-object v3, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    if-eqz v3, :cond_7

    iget-object v3, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    iget-object v4, v0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 65
    goto :goto_0

    .line 64
    :cond_7
    iget-object v3, v0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 72
    iget-object v2, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->hashCode()I

    move-result v0

    .line 73
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 74
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 72
    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lco/vine/android/api/VineInbox;->conversations:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 35
    iget-object v0, p0, Lco/vine/android/api/VineInbox;->participants:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 36
    return-void
.end method
