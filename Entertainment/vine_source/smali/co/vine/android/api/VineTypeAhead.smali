.class public Lco/vine/android/api/VineTypeAhead;
.super Ljava/lang/Object;
.source "VineTypeAhead.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineTypeAhead;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public id:J

.field public final token:Ljava/lang/String;

.field public final type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lco/vine/android/api/VineTypeAhead$1;

    invoke-direct {v0}, Lco/vine/android/api/VineTypeAhead$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineTypeAhead;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineTypeAhead;->id:J

    .line 28
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineTypeAhead;->token:Ljava/lang/String;

    .line 29
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineTypeAhead;->type:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "id"    # J

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-wide p3, p0, Lco/vine/android/api/VineTypeAhead;->id:J

    .line 18
    iput-object p2, p0, Lco/vine/android/api/VineTypeAhead;->token:Ljava/lang/String;

    .line 19
    iput-object p1, p0, Lco/vine/android/api/VineTypeAhead;->type:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public static getPlainTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "tagWithHash"    # Ljava/lang/String;

    .prologue
    .line 23
    const/4 v0, 0x1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 37
    iget-wide v0, p0, Lco/vine/android/api/VineTypeAhead;->id:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 38
    iget-object v0, p0, Lco/vine/android/api/VineTypeAhead;->token:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 39
    iget-object v0, p0, Lco/vine/android/api/VineTypeAhead;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 40
    return-void
.end method
