.class public final Luk/co/senab/actionbarpulltorefresh/library/v;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final PullToRefreshHeader:[I

.field public static final PullToRefreshHeader_ptrHeaderBackground:I = 0x0

.field public static final PullToRefreshHeader_ptrHeaderHeight:I = 0x1

.field public static final PullToRefreshHeader_ptrHeaderTitleTextAppearance:I = 0x2

.field public static final PullToRefreshHeader_ptrProgressBarColor:I = 0x3

.field public static final PullToRefreshHeader_ptrProgressBarHeight:I = 0x5

.field public static final PullToRefreshHeader_ptrProgressBarStyle:I = 0x4

.field public static final PullToRefreshHeader_ptrPullText:I = 0x6

.field public static final PullToRefreshHeader_ptrRefreshingText:I = 0x7

.field public static final PullToRefreshHeader_ptrReleaseText:I = 0x8

.field public static final PullToRefreshView:[I

.field public static final PullToRefreshView_ptrViewDelegateClass:I = 0x0

.field public static final SmoothProgressBar:[I

.field public static final SmoothProgressBar_spbStyle:I = 0x0

.field public static final SmoothProgressBar_spb_color:I = 0x1

.field public static final SmoothProgressBar_spb_colors:I = 0x9

.field public static final SmoothProgressBar_spb_interpolator:I = 0x6

.field public static final SmoothProgressBar_spb_mirror_mode:I = 0x8

.field public static final SmoothProgressBar_spb_reversed:I = 0x7

.field public static final SmoothProgressBar_spb_sections_count:I = 0x4

.field public static final SmoothProgressBar_spb_speed:I = 0x5

.field public static final SmoothProgressBar_spb_stroke_separator_length:I = 0x3

.field public static final SmoothProgressBar_spb_stroke_width:I = 0x2


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 76
    const/16 v0, 0x9

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshHeader:[I

    .line 86
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x7f010021

    aput v2, v0, v1

    sput-object v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshView:[I

    .line 88
    const/16 v0, 0xa

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Luk/co/senab/actionbarpulltorefresh/library/v;->SmoothProgressBar:[I

    return-void

    .line 76
    :array_0
    .array-data 4
        0x7f010018
        0x7f010019
        0x7f01001a
        0x7f01001b
        0x7f01001c
        0x7f01001d
        0x7f01001e
        0x7f01001f
        0x7f010020
    .end array-data

    .line 88
    :array_1
    .array-data 4
        0x7f010023
        0x7f010024
        0x7f010025
        0x7f010026
        0x7f010027
        0x7f010028
        0x7f010029
        0x7f01002a
        0x7f01002b
        0x7f01002c
    .end array-data
.end method
