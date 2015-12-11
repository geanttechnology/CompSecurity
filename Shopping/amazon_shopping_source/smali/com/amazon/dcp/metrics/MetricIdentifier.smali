.class public Lcom/amazon/dcp/metrics/MetricIdentifier;
.super Ljava/lang/Object;
.source "MetricIdentifier.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;


# instance fields
.field final mComponent:Ljava/lang/String;

.field final mDomain:Ljava/lang/String;

.field final mLevel:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

.field final mName:Ljava/lang/String;

.field mPackage:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier$1;

    invoke-direct {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/metrics/MetricIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 4
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 50
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    invoke-static {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->fromCode(I)Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/amazon/dcp/metrics/MetricIdentifier;-><init>(Lcom/amazon/dcp/metrics/MetricIdentifier$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Lcom/amazon/dcp/metrics/MetricIdentifier$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "level"    # Lcom/amazon/dcp/metrics/MetricIdentifier$Level;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "component"    # Ljava/lang/String;
    .param p4, "name"    # Ljava/lang/String;

    .prologue
    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p4, :cond_1

    .line 79
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 82
    :cond_1
    iput-object p1, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mLevel:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    .line 83
    iput-object p2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    .line 84
    iput-object p3, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    .line 85
    iput-object p4, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    .line 86
    const-string/jumbo v0, "unknown"

    iput-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mPackage:Ljava/lang/String;

    .line 87
    return-void
.end method

.method private static equivalentStrings(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "s1"    # Ljava/lang/String;
    .param p1, "s2"    # Ljava/lang/String;

    .prologue
    .line 250
    if-nez p0, :cond_1

    .line 252
    if-nez p1, :cond_0

    const/4 v0, 0x1

    .line 256
    :goto_0
    return v0

    .line 252
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 256
    :cond_1
    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 96
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 224
    instance-of v2, p1, Lcom/amazon/dcp/metrics/MetricIdentifier;

    if-nez v2, :cond_1

    .line 229
    :cond_0
    :goto_0
    return v1

    :cond_1
    move-object v0, p1

    .line 228
    check-cast v0, Lcom/amazon/dcp/metrics/MetricIdentifier;

    .line 229
    .local v0, "otherId":Lcom/amazon/dcp/metrics/MetricIdentifier;
    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier;->getDomain()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/dcp/metrics/MetricIdentifier;->equivalentStrings(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier;->getComponent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/dcp/metrics/MetricIdentifier;->equivalentStrings(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/dcp/metrics/MetricIdentifier;->equivalentStrings(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getComponent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 240
    const/16 v0, 0x1f

    .line 241
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 242
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int/lit8 v1, v2, 0x1f

    .line 243
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int v1, v2, v3

    .line 244
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int v1, v2, v3

    .line 245
    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 204
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 205
    .local v0, "builder":Ljava/lang/StringBuilder;
    const-string/jumbo v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mLevel:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    invoke-virtual {v2}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ") "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 214
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mLevel:Lcom/amazon/dcp/metrics/MetricIdentifier$Level;

    invoke-virtual {v0}, Lcom/amazon/dcp/metrics/MetricIdentifier$Level;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 108
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mDomain:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 109
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mComponent:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/amazon/dcp/metrics/MetricIdentifier;->mName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 111
    return-void
.end method
