.class public Lcom/amazon/dcp/sso/ParcelableAccount;
.super Ljava/lang/Object;
.source "ParcelableAccount.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/sso/ParcelableAccount;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAccountName:Ljava/lang/String;

.field private final mAccountType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    new-instance v0, Lcom/amazon/dcp/sso/ParcelableAccount$1;

    invoke-direct {v0}, Lcom/amazon/dcp/sso/ParcelableAccount$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/sso/ParcelableAccount;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    .line 44
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/amazon/dcp/sso/ParcelableAccount$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/amazon/dcp/sso/ParcelableAccount$1;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Lcom/amazon/dcp/sso/ParcelableAccount;-><init>(Landroid/os/Parcel;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 112
    if-ne p0, p1, :cond_1

    .line 122
    :cond_0
    :goto_0
    return v1

    .line 116
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 118
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 120
    check-cast v0, Lcom/amazon/dcp/sso/ParcelableAccount;

    .line 122
    .local v0, "other":Lcom/amazon/dcp/sso/ParcelableAccount;
    iget-object v3, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 102
    iget-object v1, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 105
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    if-nez v3, :cond_1

    :goto_1
    add-int/2addr v1, v2

    .line 106
    return v1

    .line 102
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 105
    .restart local v0    # "result":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lcom/amazon/dcp/sso/ParcelableAccount;->mAccountType:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 97
    return-void
.end method
