.class public final enum Lcom/amazon/dcp/ota/UpdateType;
.super Ljava/lang/Enum;
.source "UpdateType.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/UpdateType;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/UpdateType;

.field public static final enum App:Lcom/amazon/dcp/ota/UpdateType;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/UpdateType;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum OS:Lcom/amazon/dcp/ota/UpdateType;

.field public static final enum Unknown:Lcom/amazon/dcp/ota/UpdateType;


# instance fields
.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/amazon/dcp/ota/UpdateType;

    const-string/jumbo v1, "OS"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/dcp/ota/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateType;->OS:Lcom/amazon/dcp/ota/UpdateType;

    .line 12
    new-instance v0, Lcom/amazon/dcp/ota/UpdateType;

    const-string/jumbo v1, "App"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/dcp/ota/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateType;->App:Lcom/amazon/dcp/ota/UpdateType;

    .line 15
    new-instance v0, Lcom/amazon/dcp/ota/UpdateType;

    const-string/jumbo v1, "Unknown"

    const v2, 0x7fffffff

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/dcp/ota/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateType;->Unknown:Lcom/amazon/dcp/ota/UpdateType;

    .line 9
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/dcp/ota/UpdateType;

    sget-object v1, Lcom/amazon/dcp/ota/UpdateType;->OS:Lcom/amazon/dcp/ota/UpdateType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/dcp/ota/UpdateType;->App:Lcom/amazon/dcp/ota/UpdateType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dcp/ota/UpdateType;->Unknown:Lcom/amazon/dcp/ota/UpdateType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/dcp/ota/UpdateType;->$VALUES:[Lcom/amazon/dcp/ota/UpdateType;

    .line 17
    new-instance v0, Lcom/amazon/dcp/ota/UpdateType$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/UpdateType$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateType;->CREATOR:Landroid/os/Parcelable$Creator;

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
    iput p3, p0, Lcom/amazon/dcp/ota/UpdateType;->mValue:I

    .line 37
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/ota/UpdateType;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 46
    invoke-static {}, Lcom/amazon/dcp/ota/UpdateType;->values()[Lcom/amazon/dcp/ota/UpdateType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/ota/UpdateType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 48
    .local v3, "type":Lcom/amazon/dcp/ota/UpdateType;
    invoke-virtual {v3}, Lcom/amazon/dcp/ota/UpdateType;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 54
    .end local v3    # "type":Lcom/amazon/dcp/ota/UpdateType;
    :goto_1
    return-object v3

    .line 46
    .restart local v3    # "type":Lcom/amazon/dcp/ota/UpdateType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 54
    .end local v3    # "type":Lcom/amazon/dcp/ota/UpdateType;
    :cond_1
    sget-object v3, Lcom/amazon/dcp/ota/UpdateType;->Unknown:Lcom/amazon/dcp/ota/UpdateType;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/UpdateType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/dcp/ota/UpdateType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/UpdateType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/UpdateType;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/dcp/ota/UpdateType;->$VALUES:[Lcom/amazon/dcp/ota/UpdateType;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/UpdateType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/UpdateType;

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
    iget v0, p0, Lcom/amazon/dcp/ota/UpdateType;->mValue:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 66
    iget v0, p0, Lcom/amazon/dcp/ota/UpdateType;->mValue:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 67
    return-void
.end method
