.class public final enum Lcom/amazon/dcp/messaging/OdotTransport;
.super Ljava/lang/Enum;
.source "OdotTransport.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/messaging/OdotTransport;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/messaging/OdotTransport;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/messaging/OdotTransport;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum LAN:Lcom/amazon/dcp/messaging/OdotTransport;

.field public static final enum Unknown:Lcom/amazon/dcp/messaging/OdotTransport;

.field public static final enum WAN:Lcom/amazon/dcp/messaging/OdotTransport;


# instance fields
.field private mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 10
    new-instance v0, Lcom/amazon/dcp/messaging/OdotTransport;

    const-string/jumbo v1, "LAN"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/dcp/messaging/OdotTransport;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->LAN:Lcom/amazon/dcp/messaging/OdotTransport;

    .line 12
    new-instance v0, Lcom/amazon/dcp/messaging/OdotTransport;

    const-string/jumbo v1, "WAN"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/dcp/messaging/OdotTransport;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->WAN:Lcom/amazon/dcp/messaging/OdotTransport;

    .line 15
    new-instance v0, Lcom/amazon/dcp/messaging/OdotTransport;

    const-string/jumbo v1, "Unknown"

    const v2, 0x7fffffff

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/dcp/messaging/OdotTransport;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->Unknown:Lcom/amazon/dcp/messaging/OdotTransport;

    .line 7
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/dcp/messaging/OdotTransport;

    sget-object v1, Lcom/amazon/dcp/messaging/OdotTransport;->LAN:Lcom/amazon/dcp/messaging/OdotTransport;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/dcp/messaging/OdotTransport;->WAN:Lcom/amazon/dcp/messaging/OdotTransport;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dcp/messaging/OdotTransport;->Unknown:Lcom/amazon/dcp/messaging/OdotTransport;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->$VALUES:[Lcom/amazon/dcp/messaging/OdotTransport;

    .line 17
    new-instance v0, Lcom/amazon/dcp/messaging/OdotTransport$1;

    invoke-direct {v0}, Lcom/amazon/dcp/messaging/OdotTransport$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 36
    iput p3, p0, Lcom/amazon/dcp/messaging/OdotTransport;->mValue:I

    .line 37
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/messaging/OdotTransport;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 46
    invoke-static {}, Lcom/amazon/dcp/messaging/OdotTransport;->values()[Lcom/amazon/dcp/messaging/OdotTransport;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/messaging/OdotTransport;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 48
    .local v3, "transport":Lcom/amazon/dcp/messaging/OdotTransport;
    invoke-virtual {v3}, Lcom/amazon/dcp/messaging/OdotTransport;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 54
    .end local v3    # "transport":Lcom/amazon/dcp/messaging/OdotTransport;
    :goto_1
    return-object v3

    .line 46
    .restart local v3    # "transport":Lcom/amazon/dcp/messaging/OdotTransport;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 54
    .end local v3    # "transport":Lcom/amazon/dcp/messaging/OdotTransport;
    :cond_1
    sget-object v3, Lcom/amazon/dcp/messaging/OdotTransport;->Unknown:Lcom/amazon/dcp/messaging/OdotTransport;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/messaging/OdotTransport;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/dcp/messaging/OdotTransport;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/messaging/OdotTransport;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/messaging/OdotTransport;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/dcp/messaging/OdotTransport;->$VALUES:[Lcom/amazon/dcp/messaging/OdotTransport;

    invoke-virtual {v0}, [Lcom/amazon/dcp/messaging/OdotTransport;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/messaging/OdotTransport;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x0

    return v0
.end method

.method public value()I
    .locals 1

    .prologue
    .line 41
    iget v0, p0, Lcom/amazon/dcp/messaging/OdotTransport;->mValue:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 66
    iget v0, p0, Lcom/amazon/dcp/messaging/OdotTransport;->mValue:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 67
    return-void
.end method
