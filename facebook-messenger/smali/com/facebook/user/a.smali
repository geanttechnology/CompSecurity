.class final Lcom/facebook/user/a;
.super Ljava/lang/Object;
.source "Birthday.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/facebook/user/Birthday;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Parcel;)Lcom/facebook/user/Birthday;
    .locals 1

    .prologue
    .line 49
    new-instance v0, Lcom/facebook/user/Birthday;

    invoke-direct {v0, p1}, Lcom/facebook/user/Birthday;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public a(I)[Lcom/facebook/user/Birthday;
    .locals 1

    .prologue
    .line 53
    new-array v0, p1, [Lcom/facebook/user/Birthday;

    return-object v0
.end method

.method public synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0, p1}, Lcom/facebook/user/a;->a(Landroid/os/Parcel;)Lcom/facebook/user/Birthday;

    move-result-object v0

    return-object v0
.end method

.method public synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0, p1}, Lcom/facebook/user/a;->a(I)[Lcom/facebook/user/Birthday;

    move-result-object v0

    return-object v0
.end method
