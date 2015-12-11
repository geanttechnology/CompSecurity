.class public Lco/vine/android/api/VineError;
.super Ljava/lang/Object;
.source "VineError.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineError$VineKnownErrors;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineError;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final data:Ljava/lang/String;

.field public final errorCode:I

.field public final message:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 220
    new-instance v0, Lco/vine/android/api/VineError$1;

    invoke-direct {v0}, Lco/vine/android/api/VineError$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineError;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 1
    .param p1, "errorCode"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 193
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/api/VineError;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    .line 194
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorCode"    # I
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "data"    # Ljava/lang/String;

    .prologue
    .line 202
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 203
    iput p1, p0, Lco/vine/android/api/VineError;->errorCode:I

    .line 204
    iput-object p2, p0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    .line 205
    iput-object p3, p0, Lco/vine/android/api/VineError;->data:Ljava/lang/String;

    .line 206
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 196
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 197
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineError;->errorCode:I

    .line 198
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    .line 199
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineError;->data:Ljava/lang/String;

    .line 200
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 245
    if-nez p1, :cond_1

    .line 254
    .end local p1    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v1

    .line 248
    .restart local p1    # "o":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_3

    .line 249
    iget v2, p0, Lco/vine/android/api/VineError;->errorCode:I

    check-cast p1, Lco/vine/android/api/VineError;

    .end local p1    # "o":Ljava/lang/Object;
    iget v3, p1, Lco/vine/android/api/VineError;->errorCode:I

    if-ne v2, v3, :cond_2

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    .line 251
    .restart local p1    # "o":Ljava/lang/Object;
    :cond_3
    instance-of v2, p1, Lco/vine/android/api/VineError$VineKnownErrors;

    if-eqz v2, :cond_0

    .line 252
    iget v2, p0, Lco/vine/android/api/VineError;->errorCode:I

    check-cast p1, Lco/vine/android/api/VineError$VineKnownErrors;

    .end local p1    # "o":Ljava/lang/Object;
    iget v3, p1, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    if-ne v2, v3, :cond_4

    :goto_2
    move v1, v0

    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_2
.end method

.method public getLocalizedMessage(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 231
    iget v1, p0, Lco/vine/android/api/VineError;->errorCode:I

    invoke-static {v1}, Lco/vine/android/api/VineError$VineKnownErrors;->valueOf(I)Lco/vine/android/api/VineError$VineKnownErrors;

    move-result-object v0

    .line 232
    .local v0, "knownError":Lco/vine/android/api/VineError$VineKnownErrors;
    sget-object v1, Lco/vine/android/api/VineError$VineKnownErrors;->INVALID_ERROR_CODE:Lco/vine/android/api/VineError$VineKnownErrors;

    if-eq v0, v1, :cond_0

    .line 233
    invoke-virtual {v0, p1}, Lco/vine/android/api/VineError$VineKnownErrors;->getMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 235
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 215
    iget v0, p0, Lco/vine/android/api/VineError;->errorCode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 216
    iget-object v0, p0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 217
    iget-object v0, p0, Lco/vine/android/api/VineError;->data:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 218
    return-void
.end method
