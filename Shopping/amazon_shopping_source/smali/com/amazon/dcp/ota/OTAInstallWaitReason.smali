.class public final enum Lcom/amazon/dcp/ota/OTAInstallWaitReason;
.super Ljava/lang/Enum;
.source "OTAInstallWaitReason.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/OTAInstallWaitReason;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum A2DPOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum AppNotIdle:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/OTAInstallWaitReason;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum CallOrRing:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum LowBatt:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum MTPIsNotIdleLongEnough:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum MusicOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum NotEnoughDiskSpace:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum NotEnoughIdleTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum NotEnoughScreenOffTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum ScreenOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum UMSOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

.field public static final enum Unknown:Lcom/amazon/dcp/ota/OTAInstallWaitReason;


# instance fields
.field private mId:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 11
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "LowBatt"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->LowBatt:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 12
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "NotEnoughDiskSpace"

    invoke-direct {v0, v1, v5, v5}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughDiskSpace:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 15
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "MusicOn"

    invoke-direct {v0, v1, v6, v6}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->MusicOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 16
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "A2DPOn"

    invoke-direct {v0, v1, v7, v7}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->A2DPOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 17
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "CallOrRing"

    invoke-direct {v0, v1, v8, v8}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->CallOrRing:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 18
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "ScreenOn"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->ScreenOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 19
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "UMSOn"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->UMSOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 20
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "MTPIsNotIdleLongEnough"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->MTPIsNotIdleLongEnough:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 21
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "AppNotIdle"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->AppNotIdle:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 22
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "NotEnoughScreenOffTime"

    const/16 v2, 0x9

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughScreenOffTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 23
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "NotEnoughIdleTime"

    const/16 v2, 0xa

    const/16 v3, 0xa

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughIdleTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 26
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    const-string/jumbo v1, "Unknown"

    const/16 v2, 0xb

    const v3, 0x7fffffff

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->Unknown:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 8
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    sget-object v1, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->LowBatt:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughDiskSpace:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->MusicOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->A2DPOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->CallOrRing:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->ScreenOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->UMSOn:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->MTPIsNotIdleLongEnough:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->AppNotIdle:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughScreenOffTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->NotEnoughIdleTime:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->Unknown:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->$VALUES:[Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    .line 28
    new-instance v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/OTAInstallWaitReason$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 47
    iput p3, p0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->mId:I

    .line 48
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->values()[Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 54
    .local v3, "reason":Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    iget v4, v3, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->mId:I

    if-ne v4, p0, :cond_0

    .line 60
    .end local v3    # "reason":Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    :goto_1
    return-object v3

    .line 52
    .restart local v3    # "reason":Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 60
    .end local v3    # "reason":Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    :cond_1
    sget-object v3, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->Unknown:Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/OTAInstallWaitReason;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->$VALUES:[Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/OTAInstallWaitReason;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/OTAInstallWaitReason;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 72
    iget v0, p0, Lcom/amazon/dcp/ota/OTAInstallWaitReason;->mId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 73
    return-void
.end method
