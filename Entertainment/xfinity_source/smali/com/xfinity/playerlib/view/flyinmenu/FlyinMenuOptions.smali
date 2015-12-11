.class public final enum Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
.super Ljava/lang/Enum;
.source "FlyinMenuOptions.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum DOWNLOADS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum FAVORITE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum FEATURED:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum HISTORY:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum KIDS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum LIVE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum MOVIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum NETWORKS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum SETTINGS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field public static final enum TV_SERIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;


# instance fields
.field private final activity:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private final captionResId:I

.field private final iconResId:I


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 21
    new-instance v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v1, "FEATURED"

    sget v3, Lcom/xfinity/playerlib/R$string;->flyin_menu_featured:I

    sget v4, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_featured:I

    const-class v5, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FEATURED:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 22
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "TV_SERIES"

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_tv_series:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_tv:I

    const-class v8, Lcom/xfinity/playerlib/view/browseprograms/SeriesActivity;

    move v5, v9

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->TV_SERIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 23
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "MOVIES"

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_movies:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_movies:I

    const-class v8, Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;

    move v5, v10

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->MOVIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 24
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "NETWORKS"

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_networks:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_networks:I

    const-class v8, Lcom/xfinity/playerlib/view/browsenetworks/NetworksActivity;

    move v5, v11

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->NETWORKS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 25
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "HISTORY"

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_history:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_history:I

    const-class v8, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;

    move v5, v12

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->HISTORY:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 26
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "DOWNLOADS"

    const/4 v5, 0x5

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_downloads:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_downloads:I

    const-class v8, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->DOWNLOADS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 27
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "SETTINGS"

    const/4 v5, 0x6

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_settings:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_settings:I

    const-class v8, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->SETTINGS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 28
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "FAVORITE"

    const/4 v5, 0x7

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_favorite:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_bookmarks:I

    const-class v8, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FAVORITE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 29
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "KIDS"

    const/16 v5, 0x8

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_kids:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_kids:I

    const-class v8, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->KIDS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 30
    new-instance v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    const-string v4, "LIVE"

    const/16 v5, 0x9

    sget v6, Lcom/xfinity/playerlib/R$string;->flyin_menu_live:I

    sget v7, Lcom/xfinity/playerlib/R$drawable;->flyin_menu_live:I

    const-class v8, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;

    invoke-direct/range {v3 .. v8}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;-><init>(Ljava/lang/String;IIILjava/lang/Class;)V

    sput-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->LIVE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    .line 19
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    sget-object v1, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FEATURED:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->TV_SERIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v1, v0, v9

    sget-object v1, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->MOVIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v1, v0, v10

    sget-object v1, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->NETWORKS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v1, v0, v11

    sget-object v1, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->HISTORY:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v1, v0, v12

    const/4 v1, 0x5

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->DOWNLOADS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->SETTINGS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FAVORITE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->KIDS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->LIVE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->$VALUES:[Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IIILjava/lang/Class;)V
    .locals 0
    .param p3, "captionResId"    # I
    .param p4, "iconResId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p5, "activity":Ljava/lang/Class;, "Ljava/lang/Class<+Landroid/app/Activity;>;"
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 37
    iput p3, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->captionResId:I

    .line 38
    iput p4, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->iconResId:I

    .line 39
    iput-object p5, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->activity:Ljava/lang/Class;

    .line 40
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    const-class v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->$VALUES:[Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    return-object v0
.end method


# virtual methods
.method public getActivity()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->activity:Ljava/lang/Class;

    return-object v0
.end method

.method public getCaption(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->captionResId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDrawable(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 47
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->iconResId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method
