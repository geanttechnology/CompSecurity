.class public final enum Lcom/xfinity/playerlib/view/featured/FeaturedSection;
.super Ljava/lang/Enum;
.source "FeaturedSection.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/featured/FeaturedSection;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/featured/FeaturedSection;

.field public static final enum FEATURED:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

.field public static final enum MOVIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

.field public static final enum TV_SERIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;


# instance fields
.field private final captionResId:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    const-string v1, "FEATURED"

    sget v2, Lcom/xfinity/playerlib/R$string;->featured_label:I

    invoke-direct {v0, v1, v3, v2}, Lcom/xfinity/playerlib/view/featured/FeaturedSection;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->FEATURED:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    .line 13
    new-instance v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    const-string v1, "TV_SERIES"

    sget v2, Lcom/xfinity/playerlib/R$string;->tv_series_label:I

    invoke-direct {v0, v1, v4, v2}, Lcom/xfinity/playerlib/view/featured/FeaturedSection;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->TV_SERIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    .line 14
    new-instance v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    const-string v1, "MOVIES"

    sget v2, Lcom/xfinity/playerlib/R$string;->movies_label:I

    invoke-direct {v0, v1, v5, v2}, Lcom/xfinity/playerlib/view/featured/FeaturedSection;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->MOVIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    .line 10
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    sget-object v1, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->FEATURED:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->TV_SERIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->MOVIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    aput-object v1, v0, v5

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->$VALUES:[Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "captionResId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 19
    iput p3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->captionResId:I

    .line 20
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/featured/FeaturedSection;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/featured/FeaturedSection;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->$VALUES:[Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/featured/FeaturedSection;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    return-object v0
.end method
