.class public final Lcom/comcast/cim/cmasl/analytics/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/analytics/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView:[I

.field public static final com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView_ringBackingColor:I = 0x1

.field public static final com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView_ringColor:I = 0x0

.field public static final com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView_ringStrokeWidth:I = 0x2

.field public static final com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView_state_animating:I = 0x3

.field public static final com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer:[I

.field public static final com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_addCommas:I = 0x3

.field public static final com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_leadText:I = 0x0

.field public static final com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_noFilterText:I = 0x2

.field public static final com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_showNoFilterText:I = 0x1

.field public static final com_comcast_cim_cmasl_android_util_view_widget_PrependingTextView:[I

.field public static final com_comcast_cim_cmasl_android_util_view_widget_PrependingTextView_prependedText:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v1, 0x4

    .line 94
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/comcast/cim/cmasl/analytics/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ArcSpinImageView:[I

    .line 99
    new-array v0, v1, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/comcast/cim/cmasl/analytics/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer:[I

    .line 104
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x7f010027

    aput v2, v0, v1

    sput-object v0, Lcom/comcast/cim/cmasl/analytics/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_PrependingTextView:[I

    return-void

    .line 94
    nop

    :array_0
    .array-data 4
        0x7f01001e
        0x7f01001f
        0x7f010020
        0x7f010021
    .end array-data

    .line 99
    :array_1
    .array-data 4
        0x7f010022
        0x7f010023
        0x7f010024
        0x7f010025
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
