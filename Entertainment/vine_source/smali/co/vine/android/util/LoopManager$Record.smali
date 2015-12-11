.class public Lco/vine/android/util/LoopManager$Record;
.super Ljava/lang/Object;
.source "LoopManager.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/LoopManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Record"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/util/LoopManager$Record;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public loopCount:I

.field public postId:J

.field public timeStamp:J

.field public userId:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 107
    new-instance v0, Lco/vine/android/util/LoopManager$Record$1;

    invoke-direct {v0}, Lco/vine/android/util/LoopManager$Record$1;-><init>()V

    sput-object v0, Lco/vine/android/util/LoopManager$Record;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 1
    .param p1, "userId"    # J
    .param p3, "postId"    # J

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-wide p1, p0, Lco/vine/android/util/LoopManager$Record;->userId:J

    .line 47
    iput-wide p3, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    .line 48
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    .line 49
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->userId:J

    .line 102
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    .line 103
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    .line 104
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    .line 105
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lco/vine/android/util/LoopManager$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lco/vine/android/util/LoopManager$1;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lco/vine/android/util/LoopManager$Record;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public static fromSerializedString(Ljava/lang/String;)Lco/vine/android/util/LoopManager$Record;
    .locals 4
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 70
    const-string v2, ":"

    invoke-virtual {p0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 71
    .local v1, "spl":[Ljava/lang/String;
    array-length v2, v1

    const/4 v3, 0x4

    if-eq v2, v3, :cond_0

    .line 72
    const/4 v0, 0x0

    .line 79
    :goto_0
    return-object v0

    .line 74
    :cond_0
    new-instance v0, Lco/vine/android/util/LoopManager$Record;

    invoke-direct {v0}, Lco/vine/android/util/LoopManager$Record;-><init>()V

    .line 75
    .local v0, "r":Lco/vine/android/util/LoopManager$Record;
    const/4 v2, 0x0

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lco/vine/android/util/LoopManager$Record;->userId:J

    .line 76
    const/4 v2, 0x1

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lco/vine/android/util/LoopManager$Record;->postId:J

    .line 77
    const/4 v2, 0x2

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    .line 78
    const/4 v2, 0x3

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method public increment()V
    .locals 6

    .prologue
    const/4 v5, -0x1

    .line 54
    iget v1, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    .line 55
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    .line 56
    # getter for: Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;
    invoke-static {}, Lco/vine/android/util/LoopManager;->access$000()Lco/vine/android/util/LongSparseArray;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/util/LongSparseArray;->get(JLjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 57
    .local v0, "currentCount":I
    if-ne v0, v5, :cond_0

    .line 58
    # getter for: Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;
    invoke-static {}, Lco/vine/android/util/LoopManager;->access$000()Lco/vine/android/util/LongSparseArray;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 62
    :goto_0
    return-void

    .line 60
    :cond_0
    # getter for: Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;
    invoke-static {}, Lco/vine/android/util/LoopManager;->access$000()Lco/vine/android/util/LongSparseArray;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    add-int/lit8 v4, v0, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_0
.end method

.method public toSerializedString()Ljava/lang/String;
    .locals 4

    .prologue
    const/16 v3, 0x3a

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-wide v1, p0, Lco/vine/android/util/LoopManager$Record;->userId:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    invoke-virtual {p0}, Lco/vine/android/util/LoopManager$Record;->toSerializedString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 94
    iget-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->userId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 95
    iget-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->postId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 96
    iget v0, p0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 97
    iget-wide v0, p0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 98
    return-void
.end method
