.class public Lco/vine/android/api/VineNotificationSetting;
.super Ljava/lang/Object;
.source "VineNotificationSetting.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineNotificationSetting;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public choices:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public isBooleanSetting:Z

.field public name:Ljava/lang/String;

.field public section:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    new-instance v0, Lco/vine/android/api/VineNotificationSetting$1;

    invoke-direct {v0}, Lco/vine/android/api/VineNotificationSetting$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineNotificationSetting;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineNotificationSetting;->isBooleanSetting:Z

    .line 40
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->name:Ljava/lang/String;

    .line 41
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->title:Ljava/lang/String;

    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->section:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->value:Ljava/lang/String;

    .line 44
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    .line 45
    return-void

    .line 39
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "isBooleanSetting"    # Z
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "section"    # Ljava/lang/String;
    .param p5, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p6, "choices":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-boolean p1, p0, Lco/vine/android/api/VineNotificationSetting;->isBooleanSetting:Z

    .line 31
    iput-object p2, p0, Lco/vine/android/api/VineNotificationSetting;->name:Ljava/lang/String;

    .line 32
    iput-object p3, p0, Lco/vine/android/api/VineNotificationSetting;->title:Ljava/lang/String;

    .line 33
    iput-object p4, p0, Lco/vine/android/api/VineNotificationSetting;->section:Ljava/lang/String;

    .line 34
    iput-object p5, p0, Lco/vine/android/api/VineNotificationSetting;->value:Ljava/lang/String;

    .line 35
    iput-object p6, p0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    .line 36
    return-void
.end method


# virtual methods
.method public addToMap(Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p1, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->name:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/api/VineNotificationSetting;->value:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    return-void
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 54
    iget-boolean v0, p0, Lco/vine/android/api/VineNotificationSetting;->isBooleanSetting:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 55
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 56
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 57
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->section:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 58
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->value:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 59
    iget-object v0, p0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 60
    return-void

    .line 54
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
