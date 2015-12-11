.class public Lcom/amazon/dcp/sso/ReturnValueOrError;
.super Ljava/lang/Object;
.source "ReturnValueOrError.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/sso/ReturnValueOrError;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mResponse:Landroid/os/Bundle;

.field private final mResponseCode:I

.field private final mResponseMessage:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/dcp/sso/ReturnValueOrError$1;

    invoke-direct {v0}, Lcom/amazon/dcp/sso/ReturnValueOrError$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/sso/ReturnValueOrError;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 1
    .param p1, "responseCode"    # I
    .param p2, "responseMessage"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponse:Landroid/os/Bundle;

    .line 44
    iput p1, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseCode:I

    .line 45
    iput-object p2, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseMessage:Ljava/lang/String;

    .line 46
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    invoke-virtual {p1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponse:Landroid/os/Bundle;

    .line 52
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseCode:I

    .line 53
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseMessage:Ljava/lang/String;

    .line 54
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/amazon/dcp/sso/ReturnValueOrError$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/amazon/dcp/sso/ReturnValueOrError$1;

    .prologue
    .line 8
    invoke-direct {p0, p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;-><init>(Landroid/os/Parcel;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    return v0
.end method

.method public getResponse()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponse:Landroid/os/Bundle;

    return-object v0
.end method

.method public getResponseCode()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseCode:I

    return v0
.end method

.method public getResponseMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isError()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 58
    iget v1, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseCode:I

    if-eq v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponse:Landroid/os/Bundle;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 87
    iget v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseCode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 88
    iget-object v0, p0, Lcom/amazon/dcp/sso/ReturnValueOrError;->mResponseMessage:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 89
    return-void
.end method
