.class public final enum Lcom/amazon/dcp/ota/NetworkType;
.super Ljava/lang/Enum;
.source "NetworkType.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/NetworkType;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/NetworkType;

.field static final synthetic $assertionsDisabled:Z

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/NetworkType;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum LAN:Lcom/amazon/dcp/ota/NetworkType;

.field public static final enum Roaming:Lcom/amazon/dcp/ota/NetworkType;

.field public static final enum Unknown:Lcom/amazon/dcp/ota/NetworkType;

.field public static final enum WAN:Lcom/amazon/dcp/ota/NetworkType;


# instance fields
.field private mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 13
    const-class v0, Lcom/amazon/dcp/ota/NetworkType;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/amazon/dcp/ota/NetworkType;->$assertionsDisabled:Z

    .line 16
    new-instance v0, Lcom/amazon/dcp/ota/NetworkType;

    const-string/jumbo v3, "LAN"

    invoke-direct {v0, v3, v2, v1}, Lcom/amazon/dcp/ota/NetworkType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->LAN:Lcom/amazon/dcp/ota/NetworkType;

    .line 18
    new-instance v0, Lcom/amazon/dcp/ota/NetworkType;

    const-string/jumbo v3, "WAN"

    invoke-direct {v0, v3, v1, v5}, Lcom/amazon/dcp/ota/NetworkType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->WAN:Lcom/amazon/dcp/ota/NetworkType;

    .line 20
    new-instance v0, Lcom/amazon/dcp/ota/NetworkType;

    const-string/jumbo v3, "Roaming"

    invoke-direct {v0, v3, v5, v6}, Lcom/amazon/dcp/ota/NetworkType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->Roaming:Lcom/amazon/dcp/ota/NetworkType;

    .line 23
    new-instance v0, Lcom/amazon/dcp/ota/NetworkType;

    const-string/jumbo v3, "Unknown"

    const v4, 0x7fffffff

    invoke-direct {v0, v3, v6, v4}, Lcom/amazon/dcp/ota/NetworkType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->Unknown:Lcom/amazon/dcp/ota/NetworkType;

    .line 13
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/dcp/ota/NetworkType;

    sget-object v3, Lcom/amazon/dcp/ota/NetworkType;->LAN:Lcom/amazon/dcp/ota/NetworkType;

    aput-object v3, v0, v2

    sget-object v2, Lcom/amazon/dcp/ota/NetworkType;->WAN:Lcom/amazon/dcp/ota/NetworkType;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/dcp/ota/NetworkType;->Roaming:Lcom/amazon/dcp/ota/NetworkType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/dcp/ota/NetworkType;->Unknown:Lcom/amazon/dcp/ota/NetworkType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->$VALUES:[Lcom/amazon/dcp/ota/NetworkType;

    .line 25
    new-instance v0, Lcom/amazon/dcp/ota/NetworkType$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/NetworkType$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/NetworkType;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void

    :cond_0
    move v0, v2

    .line 13
    goto :goto_0
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 43
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 44
    iput p3, p0, Lcom/amazon/dcp/ota/NetworkType;->mValue:I

    .line 45
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/ota/NetworkType;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 54
    invoke-static {}, Lcom/amazon/dcp/ota/NetworkType;->values()[Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/ota/NetworkType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 56
    .local v3, "type":Lcom/amazon/dcp/ota/NetworkType;
    iget v4, v3, Lcom/amazon/dcp/ota/NetworkType;->mValue:I

    if-ne v4, p0, :cond_0

    .line 62
    .end local v3    # "type":Lcom/amazon/dcp/ota/NetworkType;
    :goto_1
    return-object v3

    .line 54
    .restart local v3    # "type":Lcom/amazon/dcp/ota/NetworkType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 62
    .end local v3    # "type":Lcom/amazon/dcp/ota/NetworkType;
    :cond_1
    sget-object v3, Lcom/amazon/dcp/ota/NetworkType;->Unknown:Lcom/amazon/dcp/ota/NetworkType;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/NetworkType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/dcp/ota/NetworkType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/NetworkType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/NetworkType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/dcp/ota/NetworkType;->$VALUES:[Lcom/amazon/dcp/ota/NetworkType;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/NetworkType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/NetworkType;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 98
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 104
    iget v0, p0, Lcom/amazon/dcp/ota/NetworkType;->mValue:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 105
    return-void
.end method
