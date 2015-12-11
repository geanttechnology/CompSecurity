.class public Lcom/wishabi/flipp/content/FormattedString$Part;
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
            "Lcom/wishabi/flipp/content/FormattedString$Part;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final a:Ljava/lang/String;

.field final b:[Lcom/wishabi/flipp/content/FormattedString$Format;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 123
    new-instance v0, Lcom/wishabi/flipp/content/ac;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/ac;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/content/FormattedString$Part;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->a:Ljava/lang/String;

    .line 109
    sget-object v0, Lcom/wishabi/flipp/content/FormattedString$Format;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/content/FormattedString$Format;

    iput-object v0, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->b:[Lcom/wishabi/flipp/content/FormattedString$Format;

    .line 110
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;B)V
    .locals 0

    .prologue
    .line 98
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    iput-object p1, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->a:Ljava/lang/String;

    .line 104
    iput-object p2, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->b:[Lcom/wishabi/flipp/content/FormattedString$Format;

    .line 105
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 114
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->a:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/content/FormattedString$Part;->b:[Lcom/wishabi/flipp/content/FormattedString$Format;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 121
    return-void
.end method
