.class public final enum Lcom/amazon/dcp/ota/UpdateState;
.super Ljava/lang/Enum;
.source "UpdateState.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/UpdateState;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/UpdateState;

.field static final synthetic $assertionsDisabled:Z

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/UpdateState;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum Complete:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Deduped:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum DownloadPaused:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Downloaded:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Downloading:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Failed:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Installed:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Installing:Lcom/amazon/dcp/ota/UpdateState;

.field public static final enum Pending:Lcom/amazon/dcp/ota/UpdateState;

.field public static final TAG:Ljava/lang/String;

.field public static final enum Unknown:Lcom/amazon/dcp/ota/UpdateState;


# instance fields
.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 16
    const-class v0, Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/amazon/dcp/ota/UpdateState;->$assertionsDisabled:Z

    .line 18
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Pending"

    invoke-direct {v0, v3, v2, v2}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Pending:Lcom/amazon/dcp/ota/UpdateState;

    .line 19
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Downloading"

    invoke-direct {v0, v3, v1, v1}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Downloading:Lcom/amazon/dcp/ota/UpdateState;

    .line 20
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Downloaded"

    invoke-direct {v0, v3, v6, v6}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Downloaded:Lcom/amazon/dcp/ota/UpdateState;

    .line 21
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Installing"

    invoke-direct {v0, v3, v7, v7}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Installing:Lcom/amazon/dcp/ota/UpdateState;

    .line 22
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Installed"

    invoke-direct {v0, v3, v8, v8}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Installed:Lcom/amazon/dcp/ota/UpdateState;

    .line 23
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Complete"

    const/4 v4, 0x5

    const/4 v5, 0x5

    invoke-direct {v0, v3, v4, v5}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Complete:Lcom/amazon/dcp/ota/UpdateState;

    .line 24
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Failed"

    const/4 v4, 0x6

    const/4 v5, 0x6

    invoke-direct {v0, v3, v4, v5}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Failed:Lcom/amazon/dcp/ota/UpdateState;

    .line 25
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Deduped"

    const/4 v4, 0x7

    const/4 v5, 0x7

    invoke-direct {v0, v3, v4, v5}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Deduped:Lcom/amazon/dcp/ota/UpdateState;

    .line 26
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "DownloadPaused"

    const/16 v4, 0x8

    const/16 v5, 0x8

    invoke-direct {v0, v3, v4, v5}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->DownloadPaused:Lcom/amazon/dcp/ota/UpdateState;

    .line 29
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState;

    const-string/jumbo v3, "Unknown"

    const/16 v4, 0x9

    const v5, 0x7fffffff

    invoke-direct {v0, v3, v4, v5}, Lcom/amazon/dcp/ota/UpdateState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->Unknown:Lcom/amazon/dcp/ota/UpdateState;

    .line 16
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/amazon/dcp/ota/UpdateState;

    sget-object v3, Lcom/amazon/dcp/ota/UpdateState;->Pending:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v3, v0, v2

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->Downloading:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/dcp/ota/UpdateState;->Downloaded:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/dcp/ota/UpdateState;->Installing:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/dcp/ota/UpdateState;->Installed:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->Complete:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->Failed:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->Deduped:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->DownloadPaused:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/dcp/ota/UpdateState;->Unknown:Lcom/amazon/dcp/ota/UpdateState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->$VALUES:[Lcom/amazon/dcp/ota/UpdateState;

    .line 31
    const-class v0, Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->TAG:Ljava/lang/String;

    .line 32
    new-instance v0, Lcom/amazon/dcp/ota/UpdateState$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/UpdateState$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void

    :cond_0
    move v0, v2

    .line 16
    goto/16 :goto_0
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
    .line 50
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 51
    iput p3, p0, Lcom/amazon/dcp/ota/UpdateState;->mValue:I

    .line 52
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/ota/UpdateState;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 61
    invoke-static {}, Lcom/amazon/dcp/ota/UpdateState;->values()[Lcom/amazon/dcp/ota/UpdateState;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/ota/UpdateState;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 63
    .local v3, "state":Lcom/amazon/dcp/ota/UpdateState;
    invoke-virtual {v3}, Lcom/amazon/dcp/ota/UpdateState;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 69
    .end local v3    # "state":Lcom/amazon/dcp/ota/UpdateState;
    :goto_1
    return-object v3

    .line 61
    .restart local v3    # "state":Lcom/amazon/dcp/ota/UpdateState;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 69
    .end local v3    # "state":Lcom/amazon/dcp/ota/UpdateState;
    :cond_1
    sget-object v3, Lcom/amazon/dcp/ota/UpdateState;->Unknown:Lcom/amazon/dcp/ota/UpdateState;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/UpdateState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/amazon/dcp/ota/UpdateState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/UpdateState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/UpdateState;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/amazon/dcp/ota/UpdateState;->$VALUES:[Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/UpdateState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/UpdateState;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 140
    const/4 v0, 0x0

    return v0
.end method

.method public value()I
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lcom/amazon/dcp/ota/UpdateState;->mValue:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 146
    iget v0, p0, Lcom/amazon/dcp/ota/UpdateState;->mValue:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 147
    return-void
.end method
