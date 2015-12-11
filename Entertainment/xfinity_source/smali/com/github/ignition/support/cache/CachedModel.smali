.class public abstract Lcom/github/ignition/support/cache/CachedModel;
.super Ljava/lang/Object;
.source "CachedModel.java"

# interfaces
.implements Landroid/os/Parcelable;


# instance fields
.field private id:Ljava/lang/String;

.field private transactionId:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Lcom/github/ignition/support/cache/CachedModel;->transactionId:J

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "source"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Lcom/github/ignition/support/cache/CachedModel;->transactionId:J

    .line 39
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/CachedModel;->readFromParcel(Landroid/os/Parcel;)V

    .line 40
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 238
    const/4 v0, 0x0

    return v0
.end method

.method public readFromParcel(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "source"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 258
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/github/ignition/support/cache/CachedModel;->id:Ljava/lang/String;

    .line 259
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/github/ignition/support/cache/CachedModel;->transactionId:J

    .line 260
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 246
    iget-object v0, p0, Lcom/github/ignition/support/cache/CachedModel;->id:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 247
    iget-wide v0, p0, Lcom/github/ignition/support/cache/CachedModel;->transactionId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 248
    return-void
.end method
