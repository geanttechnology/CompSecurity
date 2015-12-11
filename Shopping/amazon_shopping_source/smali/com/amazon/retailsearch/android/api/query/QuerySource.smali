.class public final enum Lcom/amazon/retailsearch/android/api/query/QuerySource;
.super Ljava/lang/Enum;
.source "QuerySource.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/api/query/QuerySource;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/QuerySource;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum EXTERNAL_APP:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field public static final enum GENERIC_INPUT_BOX:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field public static final enum LINK:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field public static final enum NAV_BAR_INPUT:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field public static final enum UNIVERSAL_SEARCH:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field private static final sources:[Lcom/amazon/retailsearch/android/api/query/QuerySource;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 20
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    const-string/jumbo v1, "GENERIC_INPUT_BOX"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/api/query/QuerySource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->GENERIC_INPUT_BOX:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 21
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    const-string/jumbo v1, "NAV_BAR_INPUT"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/android/api/query/QuerySource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->NAV_BAR_INPUT:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 22
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    const-string/jumbo v1, "LINK"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/android/api/query/QuerySource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->LINK:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 23
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    const-string/jumbo v1, "UNIVERSAL_SEARCH"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/android/api/query/QuerySource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->UNIVERSAL_SEARCH:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 24
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    const-string/jumbo v1, "EXTERNAL_APP"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/android/api/query/QuerySource;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->EXTERNAL_APP:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 18
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/retailsearch/android/api/query/QuerySource;

    sget-object v1, Lcom/amazon/retailsearch/android/api/query/QuerySource;->GENERIC_INPUT_BOX:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/android/api/query/QuerySource;->NAV_BAR_INPUT:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/android/api/query/QuerySource;->LINK:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/android/api/query/QuerySource;->UNIVERSAL_SEARCH:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/android/api/query/QuerySource;->EXTERNAL_APP:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->$VALUES:[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 27
    invoke-static {}, Lcom/amazon/retailsearch/android/api/query/QuerySource;->values()[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->sources:[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 56
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/QuerySource$1;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/query/QuerySource$1;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method static synthetic access$000()[Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->sources:[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/retailsearch/android/api/query/QuerySource;->$VALUES:[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/api/query/QuerySource;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/api/query/QuerySource;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "destParcel"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/api/query/QuerySource;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 50
    return-void
.end method
