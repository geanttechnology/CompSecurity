.class public Lcom/wishabi/flipp/content/FormattedString$Format;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/wishabi/flipp/content/FormattedString$Format;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final a:I

.field final b:I

.field final c:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    new-instance v0, Lcom/wishabi/flipp/content/aa;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/aa;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/content/FormattedString$Format;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(IB)V

    .line 36
    return-void
.end method

.method private constructor <init>(IB)V
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    if-nez p1, :cond_0

    .line 48
    sget p1, Lcom/wishabi/flipp/content/ab;->a:I

    .line 50
    :cond_0
    iput p1, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->a:I

    .line 51
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->b:I

    .line 52
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->c:F

    .line 53
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 2

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    invoke-static {}, Lcom/wishabi/flipp/content/ab;->a()[I

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget v0, v0, v1

    iput v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->a:I

    .line 57
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->b:I

    .line 58
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->c:F

    .line 59
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;B)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(Landroid/os/Parcel;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 63
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->a:I

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 69
    iget v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->b:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 70
    iget v0, p0, Lcom/wishabi/flipp/content/FormattedString$Format;->c:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 71
    return-void
.end method
