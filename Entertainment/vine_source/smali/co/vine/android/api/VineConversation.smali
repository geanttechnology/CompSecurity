.class public Lco/vine/android/api/VineConversation;
.super Ljava/lang/Object;
.source "VineConversation.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public conversationId:J

.field public conversationObjectId:J

.field public createdBy:J

.field public lastMessage:J

.field public messages:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;"
        }
    .end annotation
.end field

.field public networkType:I

.field public unreadMessageCount:J

.field public users:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 115
    new-instance v0, Lco/vine/android/api/VineConversation$1;

    invoke-direct {v0}, Lco/vine/android/api/VineConversation$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineConversation;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(JJJLjava/util/ArrayList;Ljava/util/ArrayList;IJ)V
    .locals 0
    .param p1, "conversationId"    # J
    .param p3, "lastMessage"    # J
    .param p5, "createdBy"    # J
    .param p9, "networkType"    # I
    .param p10, "unreadMessageCount"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;IJ)V"
        }
    .end annotation

    .prologue
    .line 32
    .local p7, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessage;>;"
    .local p8, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-wide p1, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    .line 34
    iput-wide p3, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    .line 35
    iput-wide p5, p0, Lco/vine/android/api/VineConversation;->createdBy:J

    .line 36
    iput-wide p10, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    .line 37
    iput-object p7, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    .line 38
    iput-object p8, p0, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    .line 39
    iput p9, p0, Lco/vine/android/api/VineConversation;->networkType:I

    .line 40
    return-void
.end method

.method public constructor <init>(JJLjava/util/ArrayList;J)V
    .locals 0
    .param p1, "conversationId"    # J
    .param p3, "lastMessage"    # J
    .param p6, "unreadMessageCount"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p5, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessage;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-wide p1, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    .line 45
    iput-wide p3, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    .line 46
    iput-object p5, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    .line 47
    iput-wide p6, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    .line 70
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    .line 71
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->createdBy:J

    .line 72
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    .line 73
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    .line 75
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineConversation;->networkType:I

    .line 76
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationObjectId:J

    .line 77
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 64
    const/4 v0, 0x0

    return v0
.end method

.method public lastMessage()Lco/vine/android/api/VinePrivateMessage;
    .locals 6

    .prologue
    .line 51
    iget-object v2, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 52
    const/4 v1, 0x0

    .line 59
    :goto_0
    return-object v1

    .line 54
    :cond_0
    iget-object v2, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePrivateMessage;

    .line 55
    .local v1, "message":Lco/vine/android/api/VinePrivateMessage;
    iget-wide v2, v1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    iget-wide v4, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    goto :goto_0

    .line 59
    .end local v1    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_2
    iget-object v2, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VinePrivateMessage;

    move-object v1, v2

    goto :goto_0
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 2
    .param p1, "objectInput"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 94
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    .line 95
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    .line 96
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->createdBy:J

    .line 97
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    .line 98
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    .line 99
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    .line 100
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineConversation;->networkType:I

    .line 101
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationObjectId:J

    .line 102
    return-void
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 2
    .param p1, "objectOutput"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 106
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 107
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 108
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->createdBy:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 109
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 110
    iget-object v0, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 111
    iget-object v0, p0, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 112
    iget v0, p0, Lco/vine/android/api/VineConversation;->networkType:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 113
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 81
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 82
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->lastMessage:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 83
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->createdBy:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 84
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 85
    iget-object v0, p0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 86
    iget-object v0, p0, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 87
    iget v0, p0, Lco/vine/android/api/VineConversation;->networkType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 88
    iget-wide v0, p0, Lco/vine/android/api/VineConversation;->conversationObjectId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 89
    return-void
.end method
