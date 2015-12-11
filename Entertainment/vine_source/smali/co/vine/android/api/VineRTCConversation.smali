.class public Lco/vine/android/api/VineRTCConversation;
.super Ljava/lang/Object;
.source "VineRTCConversation.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineRTCConversation;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public conversationId:J

.field public participants:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCParticipant;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lco/vine/android/api/VineRTCConversation$1;

    invoke-direct {v0}, Lco/vine/android/api/VineRTCConversation$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineRTCConversation;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(JLjava/util/ArrayList;)V
    .locals 1
    .param p1, "conversationId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCParticipant;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p3, "participants":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCParticipant;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    .line 16
    iput-wide p1, p0, Lco/vine/android/api/VineRTCConversation;->conversationId:J

    .line 17
    iput-object p3, p0, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    .line 22
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineRTCConversation;->conversationId:J

    .line 23
    iget-object v0, p0, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    sget-object v1, Lco/vine/android/api/VineRTCParticipant;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->readTypedList(Ljava/util/List;Landroid/os/Parcelable$Creator;)V

    .line 24
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 33
    iget-wide v0, p0, Lco/vine/android/api/VineRTCConversation;->conversationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 34
    iget-object v0, p0, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    .line 35
    return-void
.end method
